package org.oscwii.danbot;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App
{
    public static void main(String[] args)
    {
        new DanBot();
    }

    public static Logger getLogger()
    {
        return LOGGER;
    }

    final static Logger LOGGER = LogManager.getLogger(DanBot.class);
}
