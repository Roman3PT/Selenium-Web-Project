package com.Roman3PT;

import com.Roman3PT.assertion.CustomAssertion;
import com.Roman3PT.page.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.Roman3PT.enums.NavigationMenu.*;
import static com.Roman3PT.page.TemplatePage.*;

public class YotecMainTest extends AbstractTest {

    @Test
    public void mainPageVisible() {
        Assert.assertTrue(new MainPage().getMainSlider().isDisplayed());
    }

    @Test
    public void checkNavigationMenu() {
        goToPage(MANUFACTURING_SAFETY);
        ManufacturingSafetyPage safetyPage = new ManufacturingSafetyPage();
        CustomAssertion.assertURL(MANUFACTURING_SAFETY.getStr(), safetyPage.getCurrentURL());
        Assert.assertEquals(service.getTitle(), getLastBreadCrumb().getText());

        goToPage(FUTURE_FOCUS);
        FutureFocusPage focusPage = new FutureFocusPage();
        CustomAssertion.assertURL(FUTURE_FOCUS.getStr(), focusPage.getCurrentURL());
        Assert.assertEquals(service.getTitle(), getLastBreadCrumb().getText());

        goToPage(CORROSIVES);
        CorrosivesPage corrosivesPage = new CorrosivesPage();
        CustomAssertion.assertURL(CORROSIVES.getStr(), corrosivesPage.getCurrentURL());
        Assert.assertEquals(service.getTitle(), getLastBreadCrumb().getText());

        goToPage(PARTS_SERVICE);
        PartsServicePage partsServicePage = new PartsServicePage();
        CustomAssertion.assertURL(PARTS_SERVICE.getStr(), partsServicePage.getCurrentURL());
        Assert.assertEquals(service.getTitle(), getLastBreadCrumb().getText());
        goHome();

        goToPage(MY_HR);
        BenefitsPage benefitsPage = new BenefitsPage();
        CustomAssertion.assertURL(MY_HR.getStr(), benefitsPage.getCurrentURL());
        Assert.assertEquals(service.getTitle(), getLastBreadCrumb().getText());

        goToPage(TIMELINE);
        TimeLinePage timeLinePage = new TimeLinePage();
        CustomAssertion.assertURL(TIMELINE.getStr(), timeLinePage.getCurrentURL());

        goToPage(DEALER);
        DealerPage dealerPage = new DealerPage();
        CustomAssertion.assertURL(DEALER.getStr(), dealerPage.getCurrentURL());
        goHome();
    }
}