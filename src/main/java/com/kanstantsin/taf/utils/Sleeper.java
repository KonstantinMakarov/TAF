package com.kanstantsin.taf.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Sleeper {

    protected static final Logger LOG = LoggerFactory.getLogger(Sleeper.class);

    public static void sleepInMilliseconds(int mSeconds) {
        LOG.info(String.format("Sleeping %s milliseconds...", mSeconds));
        try {
            Thread.sleep(mSeconds);
        } catch (InterruptedException e) {
            LOG.warn("Thread was interrupted!", e);
            Thread.currentThread().interrupt();
        }
    }

    public static void sleepInSeconds(int seconds){
        LOG.info(String.format("Sleeping %s seconds...", seconds));
        sleepInMilliseconds(seconds * 1000);
    }
}