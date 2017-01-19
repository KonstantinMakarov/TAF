package com.kanstantsin.taf.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TimeoutUtils {

    protected static final Logger LOG = LoggerFactory.getLogger(TimeoutUtils.class);

    public static void sleepInSeconds(int seconds) {
        LOG.info(String.format("Sleeping %s seconds...", seconds));
        //Add timeout
    }
}
