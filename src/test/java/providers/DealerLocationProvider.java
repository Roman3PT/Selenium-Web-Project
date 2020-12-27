package providers;

import com.Roman3PT.enums.LocationType;
import com.Roman3PT.model.Person;
import org.testng.annotations.DataProvider;

public class DealerLocationProvider {

    @DataProvider()
    public Object[][] salesCountry() {
        return new Object[][]{{
                "Country",
                new LocationType[]{LocationType.SALES, LocationType.SERVICE, LocationType.WARRANTY},
                6
        }};
    }

    @DataProvider()
    public Object[][] contactUs() {
        Person person = new Person("Roman3PT", "JSpace", "romanbogatko1998@mail.ru", "+198 (23) 503-12-37", "Belarus");
        return new Object[][]{{
                person
        }};
    }
}