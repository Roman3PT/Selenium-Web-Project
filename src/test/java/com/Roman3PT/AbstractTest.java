package com.Roman3PT;

import com.Roman3PT.service.DriverWebService;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/**
 * Base class of all tests
 * Its init driver and open base url
 */
public abstract class AbstractTest {

    private static final Logger logger = Logger.getLogger(AbstractTest.class);
    protected static final DriverWebService service = new DriverWebService();

    @BeforeClass
    public void initDriver() {
        service.initializeDriver();
        service.openURL(DriverWebService.getBaseURL());
        logger.info("Open URL: ");
    }

    @AfterClass
    public void destroy() {
        service.quit();
        logger.info("Driver is destroyed!");
    }
}