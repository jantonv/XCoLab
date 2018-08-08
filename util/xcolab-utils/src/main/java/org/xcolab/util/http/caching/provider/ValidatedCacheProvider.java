package org.xcolab.util.http.caching.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.xcolab.util.http.caching.CacheCustomization;
import org.xcolab.util.http.caching.CacheCustomization.DiskStorage;
import org.xcolab.util.http.caching.CacheKey;
import org.xcolab.util.http.caching.CacheName;
import org.xcolab.util.http.caching.validation.CacheValidator;

import java.util.HashMap;
import java.util.Map;

public class ValidatedCacheProvider implements CacheProvider {

    private static final Logger log = LoggerFactory.getLogger(ValidatedCacheProvider.class);

    private final Map<Class, CacheValidator> cacheValidators = new HashMap<>();

    private final CacheProvider cacheProvider;

    public ValidatedCacheProvider(CacheProvider cacheProvider) {
        this.cacheProvider = cacheProvider;
    }

    /**
     * Register a CacheValidator in order to validate certain cache entries before they are
     * retrieved from the cache.
     *
     * If the entry is invalid, it will be evicted and null will be returned from the cache.
     * @param cacheValidator Cache validator to register.
     */
    public void registerCacheValidator(CacheValidator cacheValidator) {
        log.trace("Registering validator {} of type {}", cacheValidator.getClass().getSimpleName(),
                cacheValidator.getEntityType());
        cacheValidators.put(cacheValidator.getEntityType(), cacheValidator);
    }

    private <T> boolean isValid(T entity) {
        //noinspection unchecked
        CacheValidator<T> cacheValidator = cacheValidators.get(entity.getClass());
        if (cacheValidator != null) {
            log.trace("Validating entity of type {} with validator {}", entity.getClass(),
                    cacheValidator.getClass().getSimpleName());
        } else {
            log.trace("No validator found for type {}", entity.getClass());
        }
        return cacheValidator == null || cacheValidator.isValid(entity);
    }

    @Override
    public void init(Map<CacheName, CacheCustomization> customizations, DiskStorage diskStorage) {
        cacheProvider.init(customizations, diskStorage);
    }

    @Override
    public <T> T get(CacheKey<?, T> key, CacheName cacheName) {
        T ret = cacheProvider.get(key, cacheName);
        if (ret != null && !isValid(ret)) {
            delete(key, cacheName);
            log.error("Retrieved invalid entry from cache {} with key {}: {}", cacheName, key, ret);
            return null;
        }
        return ret;
    }

    @Override
    public <T> boolean add(CacheKey<?, T> key, CacheName cacheName, T value) {
        if (!isValid(value)) {
            throw new InvalidCacheEntryException(value);
        }
        return cacheProvider.add(key, cacheName, value);
    }

    @Override
    public <T> boolean replace(CacheKey<?, T> key, CacheName cacheName, T value) {
        if (!isValid(value)) {
            throw new InvalidCacheEntryException(value);
        }
        return cacheProvider.replace(key, cacheName, value);
    }

    @Override
    public boolean delete(CacheKey<?, ?> key, CacheName cacheName) {
        return cacheProvider.delete(key, cacheName);
    }

    @Override
    public boolean isActive() {
        return cacheProvider.isActive();
    }

    @Override
    public void clear() {
        cacheProvider.clear();
    }

    @Override
    public void clear(CacheName cacheName) {
        cacheProvider.clear();
    }

    public static class InvalidCacheEntryException extends IllegalStateException {
        public InvalidCacheEntryException(Object invalidEntry) {
            super("Invalid cache entry found: " + invalidEntry);
        }
    }
}
