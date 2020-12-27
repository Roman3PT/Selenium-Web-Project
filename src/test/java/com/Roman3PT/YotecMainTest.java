package com.Roman3PT;

import com.Roman3PT.assertion.CustomAssertion;
import com.Roman3PT.enums.LocationType;
import com.Roman3PT.model.Person;
import com.Roman3PT.page.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import providers.DealerLocationProvider;

import static com.Roman3PT.enums.NavigationMenu.*;
import static com.Roman3PT.page.TemplatePage.*;

public class YotecMainTest extends AbstractTest {

    @Test(priority = 0)
    public void mainPageVisible() {
        Assert.assertTrue(new MainPage().getMainSlider().isDisplayed());
    }

    @Test(priority = 1)
    public void checkNavigationMenu() {
        goToPage(MANUFACTURING_SAFETY);
        CustomAssertion.assertURL(MANUFACTURING_SAFETY.getStr(), getCurrentURL());
        Assert.assertEquals(service.getTitle(), getLastBreadCrumb().getText());

        goToPage(FUTURE_FOCUS);
        CustomAssertion.assertURL(FUTURE_FOCUS.getStr(), getCurrentURL());
        Assert.assertEquals(service.getTitle(), getLastBreadCrumb().getText());

        goToPage(CORROSIVES);
        CustomAssertion.assertURL(CORROSIVES.getStr(), getCurrentURL());
        Assert.assertEquals(service.getTitle(), getLastBreadCrumb().getText());

        goToPage(PARTS_SERVICE);
        CustomAssertion.assertURL(PARTS_SERVICE.getStr(), getCurrentURL());
        Assert.assertEquals(service.getTitle(), getLastBreadCrumb().getText());
        goHome();

        goToPage(MY_HR);
        CustomAssertion.assertURL(MY_HR.getStr(), getCurrentURL());
        Assert.assertEquals(service.getTitle(), getLastBreadCrumb().getText());

        goToPage(TIMELINE);
        CustomAssertion.assertURL(TIMELINE.getStr(), getCurrentURL());

        goToPage(DEALER);
        CustomAssertion.assertURL(DEALER.getStr(), getCurrentURL());
    }

    @Test(priority = 2, dataProvider = "salesCountry", dataProviderClass = DealerLocationProvider.class)
    public void dealerLocation(String companyName, LocationType[] types, Integer count) {
        goToPage(DEALER);
        DealerLocationPage dealerLocationPage = new DealerLocationPage();
        dealerLocationPage.sendSearch(companyName);
        for (LocationType type : types) {
            dealerLocationPage.checkLocationType(type);
        }
        Assert.assertEquals(dealerLocationPage.getCountCompany(), count);
    }

    @Test(priority = 3, dataProvider = "contactUs", dataProviderClass = DealerLocationProvider.class)
    public void contactUsForm(Person person) {
        goToPage(MANUFACTURING_SAFETY);
        contactUs(person);
        Assert.assertTrue(getSuccessMessage().isDisplayed());
    }
}