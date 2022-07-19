package testClasses;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DataProviderTest {

    @DataProvider(name="Credentials")
    public Object[][] getCredentialsFromDataprovider(){
        return new Object[][]
                {
                        { "admin", "abc"},
                        { "rahul", "xyz" },
                        { "laxman", "def" }
                };

    }

    @Test(dataProvider ="Credentials")
    public void getCredentials(String userName, String password) {
        System.out.println("Username is :"+userName+" Password is:"+password);
    }

    @Test
    @Parameters("country")
    public void getCountry(String country)
    {
        System.out.println("country is:"+ country);
    }
}
