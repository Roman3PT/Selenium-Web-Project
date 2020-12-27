package com.Roman3PT.page;

import com.Roman3PT.enums.LocationType;
import org.apache.log4j.Logger;

/**
 * Its class of Dealer page
 * This class performs a selection to select a dealer by parameters
 * */
public class DealerLocationPage extends TemplatePage {

    private static final Logger logger = Logger.getLogger(DealerLocationPage.class);

    private static final String companyName = "input[id='CompanyName']";
    private static final String listCompany = "div[id='w__dealer_list'] div[class='w__dealer_item']";

    public DealerLocationPage sendSearch(String name) {
        findElementByCssLocated(companyName).sendKeys(name);
        logger.info("send name: " + name);
        return this;
    }

    public DealerLocationPage checkLocationType(LocationType type) {
        findElementByCssLocated("button[value='" + type.getName() + "']").click();
        logger.info("check type: " + type.getName());
        return this;
    }

    public Integer getCountCompany() {
        return findElementsByCssVisibility(listCompany).size();
    }
}