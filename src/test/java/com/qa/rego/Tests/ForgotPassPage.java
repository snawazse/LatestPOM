package com.qa.rego.Tests;

import com.qa.rego.Base.BaseTest;
import com.qa.rego.Utils.Constants;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ForgotPassPage extends BaseTest {

    @BeforeClass
    public void forgotPasswordSetup() {
        loginPage = loginPage.navigateToForgotPassword();
    }

    @Test
    @Description("forgot pass Page url Test.....")
    @Severity(SeverityLevel.NORMAL)
    public void forgotPassPageUrlTest() {
        String url = loginPage.getForgotPassPageUrl();
        System.out.println("login page url : " + url);
        Assert.assertTrue(url.contains(Constants.FORGOT_PASS_PAGE_FRACTION_URL));
    }

}
