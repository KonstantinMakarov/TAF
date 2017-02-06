package com.kanstantsin.taf.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class TimeoutUtils {

    protected static final Logger LOG = LoggerFactory.getLogger(TimeoutUtils.class);

    public static void sleepInSeconds(int seconds){
        LOG.info(String.format("Sleeping %s seconds...", seconds));
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
