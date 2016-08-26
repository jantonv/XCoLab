package org.xcolab.service.tracking.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.xcolab.service.tracking.service.iptranslation.IpTranslationService;
import org.xcolab.service.tracking.service.iptranslation.Location;
import org.xcolab.service.utils.exceptions.IllegalRequestParameterException;

import java.util.Collections;
import java.util.List;

@RestController
public class IpTranslationController {

    @Autowired
    private IpTranslationService ipTranslationService;


    @RequestMapping(value = "/locations", method = RequestMethod.GET)
    public List<Location> getLocationForIp(@RequestParam String ipAddress) {
        try {
            return ipTranslationService.getLocationForIp(ipAddress)
                    .map(Collections::singletonList)
                    .orElse(Collections.emptyList());
        } catch (IpTranslationService.IpFormatException e) {
            throw new IllegalRequestParameterException("Valid IPv4 address required: " + ipAddress, e);
        }
    }
}
