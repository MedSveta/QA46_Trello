package tests;

import manager.AppManager;
import org.testng.annotations.Test;
import pages.HomePage;

public class LoginTests extends AppManager {
    @Test
    public void loginPositiveTest() {
        new HomePage(getDriver()).clickBtnLogin();
    }
}
