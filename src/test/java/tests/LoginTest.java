package tests;

import Pages.LoginPage;
import base.BaseTest;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import utils.ExcelUtils;

import java.io.IOException;

public class LoginTest extends BaseTest {

    @Test
    public void init() throws IOException, InvalidFormatException {


        // Read Excel data
        String[][] excelData = ExcelUtils.readExcelData();

        // Loop through Excel rows
        for (int i = 0; i < excelData.length; i++) {

            System.out.println("Executing Test Case: " + (i + 1));

        // Pass BaseTest driver to LoginPage
        LoginPage loginPage = new LoginPage(driver);

        // Open Registration page
        loginPage.registration();

        // Scroll down
        loginPage.scrollTo();

        // Fill Registration form
        //loginPage.login();

            // Pass Excel data
            loginPage.login(
                    excelData[i][0],
                    excelData[i][1],
                    excelData[i][2]
            );

            System.out.println("Test Case " + (i + 1) + " completed");

            // Return to application for next record
            if (i < excelData.length - 1) {
                driver.get("https://demo.guru99.com/test/newtours/");
            }
        }
    }
}







