/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bittertest;

import java.math.BigDecimal;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author Edsandro de Oliveira <edsandrom@gmail.com>
 */
public class BitterTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        int sitePassed = 0;
        int siteDidntPass = 0;
        // Set the ChromeDriver path.
        Path relPath = Paths.get("");
        String driverPath = relPath.toAbsolutePath().toString();
        System.setProperty("webdriver.chrome.driver", driverPath + "/chromedriver.exe");

        //New ChromeDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //Test 1 - createValidUser
        System.out.println("");
        System.out.println("Test 1 - Create Valid User");
        boolean test1 = bitterUnitTests.createValidUser(driver);
        if (test1) {
            System.out.println("User created");
            System.out.println("Site Passed");
            sitePassed++;
        } else {
            System.out.println("User not created");
            System.out.println("Site didn't pass");
            siteDidntPass++;
        }
        driver.close();

        //Test 2 - invalidPostalCode
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("");
        System.out.println("Test 2 - Invalid Postal Code");
        boolean test2 = bitterUnitTests.invalidPostalCode(driver);
        if (test2) {
            System.out.println("User not created");
            System.out.println("Site Passed");
            sitePassed++;
        } else {
            System.out.println("User created");
            System.out.println("Site didn't pass");
            siteDidntPass++;
        }
        driver.close();

        //Test 3 - loginValidUser
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("");
        System.out.println("Test 3 - Login Valid User");
        boolean test3 = bitterUnitTests.loginValidUser(driver);
        if (test3) {
            System.out.println("User logged in");
            System.out.println("Site Passed");
            sitePassed++;
        } else {
            System.out.println("User not logged in");
            System.out.println("Site didn't pass");
            siteDidntPass++;
        }
        driver.close();

        //Test 4 - loginInvalidUser
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("");
        System.out.println("Test 4 - Login Invalid User");
        boolean test4 = bitterUnitTests.loginInvalidUser(driver);
        if (test4) {
            System.out.println("User not logged in");
            System.out.println("Site Passed");
            sitePassed++;
        } else {
            System.out.println("User logged in");
            System.out.println("Site didn't pass");
            siteDidntPass++;
        }
        driver.close();

        //Test 5 - tweetValidData
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("");
        System.out.println("Test 5 - Tweeting Valid Data");
        boolean test5 = bitterUnitTests.tweetValidData(driver);
        if (test5) {
            System.out.println("Tweeted Successfully");
            System.out.println("Site Passed");
            sitePassed++;
        } else {
            System.out.println("Tweeted not Successfully");
            System.out.println("Site didn't pass");
            siteDidntPass++;
        }
        driver.close();

        //Test 6 - followTest
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("");
        System.out.println("Test 6 - Following User Test");
        boolean test6 = bitterUnitTests.followTest(driver);
        if (test6) {
            System.out.println("Followed Successfully");
            System.out.println("Site Passed");
            sitePassed++;
        } else {
            System.out.println("Followed not Successfully");
            System.out.println("Site didn't pass");
            siteDidntPass++;
        }
        driver.close();

        //Test 7 - invalidPhoneNumberTest
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("");
        System.out.println("Test 7 - Invalid Phone Number");
        boolean test7 = bitterUnitTests.nonNumericPhoneNumberTest(driver);
        if (test7) {
            System.out.println("User created");
            System.out.println("Site didn't Pass");
            siteDidntPass++;
        } else {
            System.out.println("User not created");
            System.out.println("Site passed");
            sitePassed++;
        }
        driver.close();

        //Test 8 - invalidEmailDomain
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("");
        System.out.println("Test 8 - Invalid Email Domain");
        boolean test8 = bitterUnitTests.invalidEmailDomain(driver);
        if (test8) {
            System.out.println("User created");
            System.out.println("Site didn't Pass");
            siteDidntPass++;
        } else {
            System.out.println("User not created");
            System.out.println("Site passed");
            sitePassed++;
        }
        driver.close();

        //Test 9 - specialCharFirstName
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("");
        System.out.println("Test 9 - Special Chars Firstname");
        boolean test9 = bitterUnitTests.specialCharFirstName(driver);
        if (test9) {
            System.out.println("User created");
            System.out.println("Site didn't pass");
            siteDidntPass++;
        } else {
            System.out.println("User not created");
            System.out.println("Site passed");
            sitePassed++;
        }
        driver.close();

        //Test 10 - specialCharLastName
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("");
        System.out.println("Test 10 - Special Chars Lastname");
        boolean test10 = bitterUnitTests.specialCharLastName(driver);
        if (test10) {
            System.out.println("User created");
            System.out.println("Site didn't pass");
            siteDidntPass++;
        } else {
            System.out.println("User not created");
            System.out.println("Site passed");
            sitePassed++;
        }
        driver.close();

        //Test 11 - blankSpaceUserName
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("");
        System.out.println("Test 11 - Blank Space Username");
        boolean test11 = bitterUnitTests.blankSpaceUserName(driver);
        if (test11) {
            System.out.println("User created");
            System.out.println("Site didn't Pass");
            siteDidntPass++;
        } else {
            System.out.println("User not created");
            System.out.println("Site passed");
            sitePassed++;
        }
        driver.close();

        //Test 12 - blankSpaceFirstName
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("");
        System.out.println("Test 12 - Blank Space Firstname");
        boolean test12 = bitterUnitTests.blankSpaceUserName(driver);
        if (test12) {
            System.out.println("User created");
            System.out.println("Site didn't Pass");
            siteDidntPass++;
        } else {
            System.out.println("User not created");
            System.out.println("Site passed");
            sitePassed++;
        }
        driver.close();

        //Test 13 - blankSpaceLastName
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("");
        System.out.println("Test 13 - Blank Space Lastname");
        boolean test13 = bitterUnitTests.blankSpaceLastName(driver);
        if (test13) {
            System.out.println("User created");
            System.out.println("Site didn't Pass");
            siteDidntPass++;
        } else {
            System.out.println("User not created");
            System.out.println("Site passed");
            sitePassed++;
        }
        driver.close();

        //Test 14 - specialCharUserName
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("");
        System.out.println("Test 14 - Special Chars Username");
        boolean test14 = bitterUnitTests.specialCharUserName(driver);
        if (test14) {
            System.out.println("User created");
            System.out.println("Site didn't pass");
            siteDidntPass++;
        } else {
            System.out.println("User not created");
            System.out.println("Site passed");
            sitePassed++;
        }
        driver.close();

        // Test 15 - selectSignup 
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("");
        System.out.println("Test 15 - Click to Sign Up from Login Page");
        boolean test15 = bitterUnitTests.selectSignup(driver);
        if (test15) {
            System.out.println("Page accessed");
            System.out.println("Site passed");
            sitePassed++;
        } else {
            System.out.println("Page not accessed");
            System.out.println("Site didn't pass");
            siteDidntPass++;
        }
        driver.close();

        // Test 16 - accessUserPage 
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("");
        System.out.println("Test 16 - Access Userpage");
        boolean test16 = bitterUnitTests.accessUserPage(driver);
        if (test16) {
            System.out.println("Page accessed");
            System.out.println("Site passed");
            sitePassed++;
        } else {
            System.out.println("Page not accessed");
            System.out.println("Site didn't pass");
            siteDidntPass++;
        }
        driver.close();

        //Test 17 - performSearch 
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().window().maximize();
        System.out.println("");
        System.out.println("Test 17 - Search");
        boolean test17 = bitterUnitTests.performSearch(driver);
        if (test17) {
            System.out.println("Search Performed");
            System.out.println("Site passed");
            sitePassed++;
        } else {
            System.out.println("Search Performed");
            System.out.println("Site didn't pass");
            siteDidntPass++;
        }
        driver.close();

        //Test 18 - passwordValidation
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("");
        System.out.println("Test 18 - Password Validation Check");
        boolean test18 = bitterUnitTests.passwordValidation(driver);
        if (test18) {
            System.out.println("User created");
            System.out.println("Site didn't pass");
            siteDidntPass++;
        } else {
            System.out.println("User not created");
            System.out.println("Site passed");
            sitePassed++;
        }
        driver.close();

        //Test 19 - moreDigitsPhoneNumber
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("");
        System.out.println("Test 19 - Phone Number with 1 digit instead of )");
        boolean test19 = bitterUnitTests.moreDigitsPhoneNumber(driver);
        if (test19) {
            System.out.println("User created");
            System.out.println("Site didn't pass");
            siteDidntPass++;
        } else {
            System.out.println("User not created");
            System.out.println("Site passed");
            sitePassed++;
        }
        driver.close();

        //Test 20 - logout
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("");
        System.out.println("Test 20 - Logout Check");
        boolean test20 = bitterUnitTests.logout(driver);
        if (test20) {
            System.out.println("Logged out");
            System.out.println("Site passed");
            sitePassed++;
        } else {
            System.out.println("Didn't Log out");
            System.out.println("Site didn't pass");
            siteDidntPass++;
        }
        driver.close();
        
        //Test 21 - logout
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("");
        System.out.println("Test 21 - Edit Profile Picture Page Access");
        boolean test21 = bitterUnitTests.editProfPicPageAccess(driver);
        if (test21) {
            System.out.println("Page Accessed");
            System.out.println("Site passed");
            sitePassed++;
        } else {
            System.out.println("Page not accessed");
            System.out.println("Site didn't pass");
            siteDidntPass++;
        }
        driver.close();

        driver.quit();

        System.out.println("");
        // TESTS RESULTS SUMMARY

        System.out.println("***************************************************************************");
        System.out.println("***************************TEST RESULTS SUMMARY****************************");
        System.out.println("***************************************************************************");
        int totalTests = sitePassed + siteDidntPass;
        int sitePassedPoints = sitePassed;
        int siteDidntPassPoints = siteDidntPass * 2;
        int totalPoints = sitePassedPoints + siteDidntPassPoints;
        System.out.println("The total tests performed were: " + totalTests);
        System.out.println("The (expected) total points awarded are: " + totalPoints);
        double approvalRate = 100 * ((double) sitePassed / (double) totalTests);
        BigDecimal appRate = new BigDecimal(approvalRate);
        appRate = appRate.setScale(2, BigDecimal.ROUND_HALF_EVEN);
        System.out.println("The site was approved in " + sitePassed + " tests.");
        System.out.println("The site was reproved in " + siteDidntPass + " tests.");
        System.out.println("The site has " + appRate + "% approval rate under this test scope");
        System.out.println("All username and password generated through this script are displayed here.");
        System.out.println("***************************************************************************");
    }

}
