package providers;

import com.Roman3PT.enums.LocationType;
import org.testng.annotations.DataProvider;

public class DealerLocationProvider {

    @DataProvider()
    public Object[][] salesCountry() {
        return new Object[][] {{
                "Country",
                new LocationType[]{LocationType.SALES, LocationType.SERVICE, LocationType.WARRANTY},
                6
        }};
    }
}