package org.xcolab.view.caching;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.xcolab.client.contest.pojo.ContestDto;
import org.xcolab.util.http.caching.validation.AbstractCacheValidator;

public class ContestCacheValidator extends AbstractCacheValidator<ContestDto> {

    private static final Logger log = LoggerFactory.getLogger(ContestCacheValidator.class);

    public ContestCacheValidator() {
        super(ContestDto.class);
    }

    @Override
    public boolean isValid(ContestDto entity) {
        log.debug("Validating contest {}", entity.getId());
        return entity.getId() != null && entity.getWeight() != null;
    }
}
