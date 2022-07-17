package testClasses;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {

    @DataProvider(name="Credentials")
    public Object[][] getCredentialsFromDataprovider(){
        return new Object[][]
                {
                        { "admin", "abc" },
                        { "rahul", "xyz" },
                        { "laxman", "def" }
                };

    }

    @Test(dataProvider ="Credentials")
    public void getCredentials(String userName, String password) {
        System.out.println("Username is :"+userName+" Password is:"+password);
    }
}
