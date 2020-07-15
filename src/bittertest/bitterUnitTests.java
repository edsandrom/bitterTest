/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bittertest;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import java.util.Locale;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 *
 * @author Edsandro de Oliveira <edsandrom@gmail.com>
 */
public class bitterUnitTests {

    public static boolean createValidUser(WebDriver driver) {
        try {
            //Opening the signup page.
            driver.get("http://10.10.0.30/qa/phoeben/signup.php");

            // Getting the WebElements 
            WebElement txtFirstName = bitterWebElements.getWebElementById(driver, "firstname");
            WebElement txtLastName = bitterWebElements.getWebElementById(driver, "lastname");
            WebElement txtEmail = bitterWebElements.getWebElementById(driver, "email");
            WebElement txtUserName = bitterWebElements.getWebElementById(driver, "username");
            WebElement txtPassword = bitterWebElements.getWebElementById(driver, "password");
            WebElement txtConfirm = bitterWebElements.getWebElementById(driver, "confirm");
            WebElement txtPhoneNumber = bitterWebElements.getWebElementById(driver, "phone");
            WebElement txtAddress = bitterWebElements.getWebElementById(driver, "address");
            Select ddlProvince = bitterWebElements.ddlSelect(driver, "province");
            WebElement txtPostalCode = bitterWebElements.getWebElementById(driver, "postalCode");
            WebElement txtURL = bitterWebElements.getWebElementById(driver, "url");
            WebElement txtDescription = bitterWebElements.getWebElementById(driver, "desc");
            WebElement txtLocation = bitterWebElements.getWebElementById(driver, "location");
            WebElement btnSubmit = bitterWebElements.getWebElementById(driver, "button");

            // Instantiated required Faker objects.
            FakeValuesService fakeValuesService = new FakeValuesService(new Locale("en"), new RandomService());
            Faker faker = new Faker();

            //Only the username has to be changed on multiple testing it
            String username = faker.name().username();

            //Giving Values to WebElements
            txtFirstName.sendKeys("Ed");
            txtLastName.sendKeys("Oliveira");
            txtEmail.sendKeys("ed@fakegmail.com");
            txtUserName.sendKeys(username);
            txtPassword.sendKeys("123");
            txtConfirm.sendKeys("123");
            txtPhoneNumber.sendKeys("(506) 123 4567");
            txtAddress.sendKeys("Street St");
            txtPostalCode.sendKeys("E3B 3B4");
            txtURL.sendKeys("www.ed.com");
            txtDescription.sendKeys("Valid Input");
            txtLocation.sendKeys("Fredericton");
            ddlProvince.selectByVisibleText("New Brunswick");
            btnSubmit.click();

            System.out.println("Username:" + username);
            System.out.println("Password: 123");

            //Check Test
            WebElement mySpan = bitterWebElements.getWebElementById(driver, "spanInfo");
            String mySpanInfoText = mySpan.getText();
            String expectedMessage = "The user name is existed. Please try the different one!";
            System.out.println("Page Message: " + mySpanInfoText);
            String currentURL = driver.getCurrentUrl();
            String expectedURL = "http://10.10.0.30/qa/phoeben/Login.php";

            if (currentURL.contains(expectedURL)) {
                return true;
            } else if (mySpanInfoText.contains(expectedMessage)) {
                return true;
            } else {
                return false;
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public static boolean invalidPostalCode(WebDriver driver) {//Using wrong postal code
        try {
            //Opening the signup page.
            driver.get("http://10.10.0.30/qa/phoeben/signup.php");

            // Getting the WebElements 
            WebElement txtFirstName = bitterWebElements.getWebElementById(driver, "firstname");
            WebElement txtLastName = bitterWebElements.getWebElementById(driver, "lastname");
            WebElement txtEmail = bitterWebElements.getWebElementById(driver, "email");
            WebElement txtUserName = bitterWebElements.getWebElementById(driver, "username");
            WebElement txtPassword = bitterWebElements.getWebElementById(driver, "password");
            WebElement txtConfirm = bitterWebElements.getWebElementById(driver, "confirm");
            WebElement txtPhoneNumber = bitterWebElements.getWebElementById(driver, "phone");
            WebElement txtAddress = bitterWebElements.getWebElementById(driver, "address");
            Select ddlProvince = bitterWebElements.ddlSelect(driver, "province");
            WebElement txtPostalCode = bitterWebElements.getWebElementById(driver, "postalCode");
            WebElement txtURL = bitterWebElements.getWebElementById(driver, "url");
            WebElement txtDescription = bitterWebElements.getWebElementById(driver, "desc");
            WebElement txtLocation = bitterWebElements.getWebElementById(driver, "location");
            WebElement btnSubmit = bitterWebElements.getWebElementById(driver, "button");

            // Instantiated required Faker objects.
            FakeValuesService fakeValuesService = new FakeValuesService(new Locale("en"), new RandomService());
            Faker faker = new Faker();

            //Only the username has to be changed on multiple testing it
            String username = faker.name().username();

            //Giving Values to WebElements
            txtFirstName.sendKeys("Ed");
            txtLastName.sendKeys("Oliveira");
            txtEmail.sendKeys("ed@fakegmail.com");
            txtUserName.sendKeys(username);
            txtPassword.sendKeys("123");
            txtConfirm.sendKeys("123");
            txtPhoneNumber.sendKeys("(506) 123 4567");
            txtAddress.sendKeys("Street St");
            txtPostalCode.sendKeys("S0K 3T0"); //Saskatchewan
            txtURL.sendKeys("www.ed.com");
            txtDescription.sendKeys("Valid Input");
            txtLocation.sendKeys("Fredericton");
            ddlProvince.selectByVisibleText("New Brunswick");
            btnSubmit.click();

            System.out.println("PostalCode:S0K 3T0 - Saskatchewan");
            System.out.println("Selected Province: New Brunswick");

            //Check Test
            WebElement mySpan = bitterWebElements.getWebElementById(driver, "spanInfo");
            String mySpanInfoText = mySpan.getText();
            String notExpectedMessage = "The user name is existed. Please try the different one!";
            System.out.println("Page Message: " + mySpanInfoText);
            String currentURL = driver.getCurrentUrl();
            String expectedURL = "http://10.10.0.30/qa/phoeben/Signup.php";

            if (currentURL.contains(expectedURL)) {
                return true;
            } else if (mySpanInfoText.contains(notExpectedMessage)) {
                return true;
            } else {
                return false;
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public static boolean loginValidUser(WebDriver driver) {
        try {
            //Opening the login page.
            driver.get("http://10.10.0.30/qa/phoeben/Login.php");

            //Getting the WebElements 
            WebElement txtUserName = bitterWebElements.getWebElementById(driver, "username");
            WebElement txtPassword = bitterWebElements.getWebElementById(driver, "password");
            WebElement btnSubmit = bitterWebElements.getWebElementById(driver, "button");

            //Giving valid values to WebElements
            txtUserName.sendKeys("ed");
            txtPassword.sendKeys("123");

            btnSubmit.click();

            System.out.println("Username:" + "ed");
            System.out.println("Password: 123");

            //Check Test
            String currentURL = driver.getCurrentUrl();
            String expectedURL = "http://10.10.0.30/qa/phoeben/index.php";

            if (currentURL.contains(expectedURL)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public static boolean loginInvalidUser(WebDriver driver) {
        try {
            //Opening the login page.
            driver.get("http://10.10.0.30/qa/phoeben/Login.php");

            //Getting the WebElements 
            WebElement txtUserName = bitterWebElements.getWebElementById(driver, "username");
            WebElement txtPassword = bitterWebElements.getWebElementById(driver, "password");
            WebElement btnSubmit = bitterWebElements.getWebElementById(driver, "button");

            //Giving valid values to WebElements
            txtUserName.sendKeys("#$DDSA#$%");
            txtPassword.sendKeys("123");

            btnSubmit.click();

            System.out.println("Username:" + "#$DDSA#$%");
            System.out.println("Password: 123");

            //Check Test
            String currentURL = driver.getCurrentUrl();
            String expectedURL = "http://10.10.0.30/qa/phoeben/Login.php";

            if (currentURL.contains(expectedURL)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public static boolean tweetValidData(WebDriver driver) {
        try {
            //Opening the login page.
            driver.get("http://10.10.0.30/qa/phoeben/Login.php");

            //Loggin in
            loginValidUser(driver);

            //Getting the WebElements 
            WebElement txtTweetInput = bitterWebElements.getWebElementById(driver, "myTweet");
            WebElement btnSubmit = bitterWebElements.getWebElementById(driver, "button");

            //Giving valid values to WebElements
            String tweetText = "Test5 - tweetValidData";
            txtTweetInput.sendKeys(tweetText);

            //Clicking in text area and the submitting
            txtTweetInput.click();
            btnSubmit.click();

            System.out.println(tweetText);

            //Check Test
            WebElement mySpan = bitterWebElements.getTempSpanElementById(driver, "mySpan");
            String mySpanText = mySpan.getText();
            String expectedMessage = "successfully";
            System.out.println("Page Message: " + mySpanText);
            if (mySpanText.contains(expectedMessage)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public static boolean followTest(WebDriver driver) {
        try {
            //Opening the login page.
            driver.get("http://10.10.0.30/qa/phoeben/Login.php");

            //Loggin in
            loginValidUser(driver);

            //Getting the WebElements 
            WebElement followButton = bitterWebElements.getWebElementByClass(driver, "followbutton");

            if (followButton != null) {
                //Clicking on follow button
                followButton.click();
            } else {
                return false;
            }
            //Check Test
            WebElement mySpan = bitterWebElements.getWebElementById(driver, "spanInfo");
            String mySpanInfoText = mySpan.getText();
            String expectedMessage = "Followed successfully!";
            System.out.println("Page Message: " + mySpanInfoText);
            if (mySpanInfoText.contains(expectedMessage)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public static boolean nonNumericPhoneNumberTest(WebDriver driver) {
        try {
            //Opening the signup page.
            driver.get("http://10.10.0.30/qa/phoeben/signup.php");

            // Getting the WebElements 
            WebElement txtFirstName = bitterWebElements.getWebElementById(driver, "firstname");
            WebElement txtLastName = bitterWebElements.getWebElementById(driver, "lastname");
            WebElement txtEmail = bitterWebElements.getWebElementById(driver, "email");
            WebElement txtUserName = bitterWebElements.getWebElementById(driver, "username");
            WebElement txtPassword = bitterWebElements.getWebElementById(driver, "password");
            WebElement txtConfirm = bitterWebElements.getWebElementById(driver, "confirm");
            WebElement txtPhoneNumber = bitterWebElements.getWebElementById(driver, "phone");
            WebElement txtAddress = bitterWebElements.getWebElementById(driver, "address");
            Select ddlProvince = bitterWebElements.ddlSelect(driver, "province");
            WebElement txtPostalCode = bitterWebElements.getWebElementById(driver, "postalCode");
            WebElement txtURL = bitterWebElements.getWebElementById(driver, "url");
            WebElement txtDescription = bitterWebElements.getWebElementById(driver, "desc");
            WebElement txtLocation = bitterWebElements.getWebElementById(driver, "location");
            WebElement btnSubmit = bitterWebElements.getWebElementById(driver, "button");

            // Instantiated required Faker objects.
            FakeValuesService fakeValuesService = new FakeValuesService(new Locale("en"), new RandomService());
            Faker faker = new Faker();

            //Only the username has to be changed on multiple testing it
            String username = faker.name().username();

            //Giving Values to WebElements
            txtFirstName.sendKeys("Ed");
            txtLastName.sendKeys("Oliveira");
            txtEmail.sendKeys("ed@fakegmail.com");
            txtUserName.sendKeys(username);
            txtPassword.sendKeys("123");
            txtConfirm.sendKeys("123");
            txtPhoneNumber.sendKeys("(abc) def ghij");
            txtAddress.sendKeys("Street St");
            txtPostalCode.sendKeys("E3B 3B4");
            txtURL.sendKeys("www.ed.com");
            txtDescription.sendKeys("Valid Input");
            txtLocation.sendKeys("Fredericton");
            ddlProvince.selectByVisibleText("New Brunswick");
            btnSubmit.click();

            System.out.println("Phone Number: " + "(abc) def ghij");

            //Check Test
            String currentURL = driver.getCurrentUrl();
            String expectedURL = "http://10.10.0.30/qa/phoeben/Login.php";

            if (currentURL.contains(expectedURL)) {
                return true;
            } else {
                return false;
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public static boolean invalidEmailDomain(WebDriver driver) {
        try {
            //Opening the signup page.
            driver.get("http://10.10.0.30/qa/phoeben/signup.php");

            // Getting the WebElements 
            WebElement txtFirstName = bitterWebElements.getWebElementById(driver, "firstname");
            WebElement txtLastName = bitterWebElements.getWebElementById(driver, "lastname");
            WebElement txtEmail = bitterWebElements.getWebElementById(driver, "email");
            WebElement txtUserName = bitterWebElements.getWebElementById(driver, "username");
            WebElement txtPassword = bitterWebElements.getWebElementById(driver, "password");
            WebElement txtConfirm = bitterWebElements.getWebElementById(driver, "confirm");
            WebElement txtPhoneNumber = bitterWebElements.getWebElementById(driver, "phone");
            WebElement txtAddress = bitterWebElements.getWebElementById(driver, "address");
            Select ddlProvince = bitterWebElements.ddlSelect(driver, "province");
            WebElement txtPostalCode = bitterWebElements.getWebElementById(driver, "postalCode");
            WebElement txtURL = bitterWebElements.getWebElementById(driver, "url");
            WebElement txtDescription = bitterWebElements.getWebElementById(driver, "desc");
            WebElement txtLocation = bitterWebElements.getWebElementById(driver, "location");
            WebElement btnSubmit = bitterWebElements.getWebElementById(driver, "button");

            // Instantiated required Faker objects.
            FakeValuesService fakeValuesService = new FakeValuesService(new Locale("en"), new RandomService());
            Faker faker = new Faker();

            //Only the username has to be changed on multiple testing it
            String username = faker.name().username();

            //Giving Values to WebElements
            txtFirstName.sendKeys("Ed");
            txtLastName.sendKeys("Oliveira");
            txtEmail.sendKeys("edededed@gmail");
            txtUserName.sendKeys(username);
            txtPassword.sendKeys("123");
            txtConfirm.sendKeys("123");
            txtPhoneNumber.sendKeys("(111) 111 1111");
            txtAddress.sendKeys("Street St");
            txtPostalCode.sendKeys("E3B 3B4");
            txtURL.sendKeys("www.ed.com");
            txtDescription.sendKeys("Valid Input");
            txtLocation.sendKeys("Fredericton");
            ddlProvince.selectByVisibleText("New Brunswick");
            btnSubmit.click();

            System.out.println("Email: " + "edededed@gmail");
            System.out.println("Username: " + username);
            System.out.println("Password: 123");

            //Check Test
            String currentURL = driver.getCurrentUrl();
            String expectedURL = "http://10.10.0.30/qa/phoeben/Login.php";

            if (currentURL.contains(expectedURL)) {
                return true;
            } else {
                return false;
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public static boolean specialCharFirstName(WebDriver driver) {
        try {
            //Opening the signup page.
            driver.get("http://10.10.0.30/qa/phoeben/signup.php");

            // Getting the WebElements 
            WebElement txtFirstName = bitterWebElements.getWebElementById(driver, "firstname");
            WebElement txtLastName = bitterWebElements.getWebElementById(driver, "lastname");
            WebElement txtEmail = bitterWebElements.getWebElementById(driver, "email");
            WebElement txtUserName = bitterWebElements.getWebElementById(driver, "username");
            WebElement txtPassword = bitterWebElements.getWebElementById(driver, "password");
            WebElement txtConfirm = bitterWebElements.getWebElementById(driver, "confirm");
            WebElement txtPhoneNumber = bitterWebElements.getWebElementById(driver, "phone");
            WebElement txtAddress = bitterWebElements.getWebElementById(driver, "address");
            Select ddlProvince = bitterWebElements.ddlSelect(driver, "province");
            WebElement txtPostalCode = bitterWebElements.getWebElementById(driver, "postalCode");
            WebElement txtURL = bitterWebElements.getWebElementById(driver, "url");
            WebElement txtDescription = bitterWebElements.getWebElementById(driver, "desc");
            WebElement txtLocation = bitterWebElements.getWebElementById(driver, "location");
            WebElement btnSubmit = bitterWebElements.getWebElementById(driver, "button");

            // Instantiated required Faker objects.
            FakeValuesService fakeValuesService = new FakeValuesService(new Locale("en"), new RandomService());
            Faker faker = new Faker();

            //Only the username has to be changed on multiple testing it
            String username = faker.name().username();

            //Giving Values to WebElements
            String testVar = "######";
            txtFirstName.sendKeys(testVar);
            txtLastName.sendKeys("Oliveira");
            txtEmail.sendKeys("edededed@fakegmail.com");
            txtUserName.sendKeys(username);
            txtPassword.sendKeys("123");
            txtConfirm.sendKeys("123");
            txtPhoneNumber.sendKeys("(111) 111 1111");
            txtAddress.sendKeys("Street St");
            txtPostalCode.sendKeys("E3B 3B4");
            txtURL.sendKeys("www.ed.com");
            txtDescription.sendKeys("Valid Input");
            txtLocation.sendKeys("Fredericton");
            ddlProvince.selectByVisibleText("New Brunswick");
            btnSubmit.click();

            System.out.println("Firstname: " + testVar);
            System.out.println("Username: " + username);
            System.out.println("Password: 123");

            //Check Test
            WebElement mySpan = bitterWebElements.getWebElementById(driver, "spanInfo");
            String mySpanInfoText = mySpan.getText();
            String notExpectedMessage = "The user name is existed. Please try the different one!";
            System.out.println("Page Message: " + mySpanInfoText);
            String currentURL = driver.getCurrentUrl();
            String expectedURL = "http://10.10.0.30/qa/phoeben/Login.php";

            if (currentURL.contains(expectedURL)) {
                return true;
            } else if (mySpanInfoText.contains(notExpectedMessage)) {
                return true;
            } else {
                return false;
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public static boolean specialCharLastName(WebDriver driver) {
        try {
            //Opening the signup page.
            driver.get("http://10.10.0.30/qa/phoeben/signup.php");

            // Getting the WebElements 
            WebElement txtFirstName = bitterWebElements.getWebElementById(driver, "firstname");
            WebElement txtLastName = bitterWebElements.getWebElementById(driver, "lastname");
            WebElement txtEmail = bitterWebElements.getWebElementById(driver, "email");
            WebElement txtUserName = bitterWebElements.getWebElementById(driver, "username");
            WebElement txtPassword = bitterWebElements.getWebElementById(driver, "password");
            WebElement txtConfirm = bitterWebElements.getWebElementById(driver, "confirm");
            WebElement txtPhoneNumber = bitterWebElements.getWebElementById(driver, "phone");
            WebElement txtAddress = bitterWebElements.getWebElementById(driver, "address");
            Select ddlProvince = bitterWebElements.ddlSelect(driver, "province");
            WebElement txtPostalCode = bitterWebElements.getWebElementById(driver, "postalCode");
            WebElement txtURL = bitterWebElements.getWebElementById(driver, "url");
            WebElement txtDescription = bitterWebElements.getWebElementById(driver, "desc");
            WebElement txtLocation = bitterWebElements.getWebElementById(driver, "location");
            WebElement btnSubmit = bitterWebElements.getWebElementById(driver, "button");

            // Instantiated required Faker objects.
            FakeValuesService fakeValuesService = new FakeValuesService(new Locale("en"), new RandomService());
            Faker faker = new Faker();

            //Only the username has to be changed on multiple testing it
            String username = faker.name().username();

            //Giving Values to WebElements
            String testVar = "######";
            txtFirstName.sendKeys("ed");
            txtLastName.sendKeys(testVar);
            txtEmail.sendKeys("edededed@fakegmail.com");
            txtUserName.sendKeys(username);
            txtPassword.sendKeys("123");
            txtConfirm.sendKeys("123");
            txtPhoneNumber.sendKeys("(111) 111 1111");
            txtAddress.sendKeys("Street St");
            txtPostalCode.sendKeys("E3B 3B4");
            txtURL.sendKeys("www.ed.com");
            txtDescription.sendKeys("Valid Input");
            txtLocation.sendKeys("Fredericton");
            ddlProvince.selectByVisibleText("New Brunswick");
            btnSubmit.click();

            System.out.println("Lastname: " + testVar);
            System.out.println("Username: " + username);
            System.out.println("Password: 123");

            //Check Test
            WebElement mySpan = bitterWebElements.getWebElementById(driver, "spanInfo");
            String mySpanInfoText = mySpan.getText();
            String notExpectedMessage = "The user name is existed. Please try the different one!";
            System.out.println("Page Message: " + mySpanInfoText);
            String currentURL = driver.getCurrentUrl();
            String expectedURL = "http://10.10.0.30/qa/phoeben/Login.php";

            if (currentURL.contains(expectedURL)) {
                return true;
            } else if (mySpanInfoText.contains(notExpectedMessage)) {
                return true;
            } else {
                return false;
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public static boolean blankSpaceUserName(WebDriver driver) {
        try {
            //Opening the signup page.
            driver.get("http://10.10.0.30/qa/phoeben/signup.php");

            // Getting the WebElements 
            WebElement txtFirstName = bitterWebElements.getWebElementById(driver, "firstname");
            WebElement txtLastName = bitterWebElements.getWebElementById(driver, "lastname");
            WebElement txtEmail = bitterWebElements.getWebElementById(driver, "email");
            WebElement txtUserName = bitterWebElements.getWebElementById(driver, "username");
            WebElement txtPassword = bitterWebElements.getWebElementById(driver, "password");
            WebElement txtConfirm = bitterWebElements.getWebElementById(driver, "confirm");
            WebElement txtPhoneNumber = bitterWebElements.getWebElementById(driver, "phone");
            WebElement txtAddress = bitterWebElements.getWebElementById(driver, "address");
            Select ddlProvince = bitterWebElements.ddlSelect(driver, "province");
            WebElement txtPostalCode = bitterWebElements.getWebElementById(driver, "postalCode");
            WebElement txtURL = bitterWebElements.getWebElementById(driver, "url");
            WebElement txtDescription = bitterWebElements.getWebElementById(driver, "desc");
            WebElement txtLocation = bitterWebElements.getWebElementById(driver, "location");
            WebElement btnSubmit = bitterWebElements.getWebElementById(driver, "button");

            // Instantiated required Faker objects.
            FakeValuesService fakeValuesService = new FakeValuesService(new Locale("en"), new RandomService());
            Faker faker = new Faker();

            //Giving Values to WebElements
            String testVar = " "; //blank space
            txtFirstName.sendKeys("ed");
            txtLastName.sendKeys("test");
            txtEmail.sendKeys("edededed@fakegmail.com");
            txtUserName.sendKeys(testVar);
            txtPassword.sendKeys("123");
            txtConfirm.sendKeys("123");
            txtPhoneNumber.sendKeys("(111) 111 1111");
            txtAddress.sendKeys("Street St");
            txtPostalCode.sendKeys("E3B 3B4");
            txtURL.sendKeys("www.ed.com");
            txtDescription.sendKeys("Valid Input");
            txtLocation.sendKeys("Fredericton");
            ddlProvince.selectByVisibleText("New Brunswick");
            btnSubmit.click();

            System.out.println("username: " + testVar);
            System.out.println("Password: 123");

            //Check Test
            WebElement mySpan = bitterWebElements.getWebElementById(driver, "spanInfo");
            String mySpanInfoText = mySpan.getText();
            String notExpectedMessage = "The user name is existed. Please try the different one!";
            System.out.println("Page Message: " + mySpanInfoText);
            String currentURL = driver.getCurrentUrl();
            String expectedURL = "http://10.10.0.30/qa/phoeben/Login.php";

            if (currentURL.contains(expectedURL)) {
                return true;
            } else if (mySpanInfoText.contains(notExpectedMessage)) {
                return true;
            } else {
                return false;
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public static boolean blankSpaceLastName(WebDriver driver) {
        try {
            //Opening the signup page.
            driver.get("http://10.10.0.30/qa/phoeben/signup.php");

            // Getting the WebElements 
            WebElement txtFirstName = bitterWebElements.getWebElementById(driver, "firstname");
            WebElement txtLastName = bitterWebElements.getWebElementById(driver, "lastname");
            WebElement txtEmail = bitterWebElements.getWebElementById(driver, "email");
            WebElement txtUserName = bitterWebElements.getWebElementById(driver, "username");
            WebElement txtPassword = bitterWebElements.getWebElementById(driver, "password");
            WebElement txtConfirm = bitterWebElements.getWebElementById(driver, "confirm");
            WebElement txtPhoneNumber = bitterWebElements.getWebElementById(driver, "phone");
            WebElement txtAddress = bitterWebElements.getWebElementById(driver, "address");
            Select ddlProvince = bitterWebElements.ddlSelect(driver, "province");
            WebElement txtPostalCode = bitterWebElements.getWebElementById(driver, "postalCode");
            WebElement txtURL = bitterWebElements.getWebElementById(driver, "url");
            WebElement txtDescription = bitterWebElements.getWebElementById(driver, "desc");
            WebElement txtLocation = bitterWebElements.getWebElementById(driver, "location");
            WebElement btnSubmit = bitterWebElements.getWebElementById(driver, "button");

            // Instantiated required Faker objects.
            FakeValuesService fakeValuesService = new FakeValuesService(new Locale("en"), new RandomService());
            Faker faker = new Faker();

            //Only the username has to be changed on multiple testing it
            String username = faker.name().username();

            //Giving Values to WebElements
            String testVar = " "; //blank space
            txtFirstName.sendKeys("ed");
            txtLastName.sendKeys(testVar);
            txtEmail.sendKeys("edededed@fakegmail.com");
            txtUserName.sendKeys(username);
            txtPassword.sendKeys("123");
            txtConfirm.sendKeys("123");
            txtPhoneNumber.sendKeys("(111) 111 1111");
            txtAddress.sendKeys("Street St");
            txtPostalCode.sendKeys("E3B 3B4");
            txtURL.sendKeys("www.ed.com");
            txtDescription.sendKeys("Valid Input");
            txtLocation.sendKeys("Fredericton");
            ddlProvince.selectByVisibleText("New Brunswick");
            btnSubmit.click();

            System.out.println("Lastname: " + testVar);
            System.out.println("username: " + username);
            System.out.println("Password: 123");

            //Check Test
            WebElement mySpan = bitterWebElements.getWebElementById(driver, "spanInfo");
            String mySpanInfoText = mySpan.getText();
            String notExpectedMessage = "The user name is existed. Please try the different one!";
            System.out.println("Page Message: " + mySpanInfoText);
            String currentURL = driver.getCurrentUrl();
            String expectedURL = "http://10.10.0.30/qa/phoeben/Login.php";

            if (currentURL.contains(expectedURL)) {
                return true;
            } else if (mySpanInfoText.contains(notExpectedMessage)) {
                return true;
            } else {
                return false;
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public static boolean specialCharUserName(WebDriver driver) {
        try {
            //Opening the signup page.
            driver.get("http://10.10.0.30/qa/phoeben/signup.php");

            // Getting the WebElements 
            WebElement txtFirstName = bitterWebElements.getWebElementById(driver, "firstname");
            WebElement txtLastName = bitterWebElements.getWebElementById(driver, "lastname");
            WebElement txtEmail = bitterWebElements.getWebElementById(driver, "email");
            WebElement txtUserName = bitterWebElements.getWebElementById(driver, "username");
            WebElement txtPassword = bitterWebElements.getWebElementById(driver, "password");
            WebElement txtConfirm = bitterWebElements.getWebElementById(driver, "confirm");
            WebElement txtPhoneNumber = bitterWebElements.getWebElementById(driver, "phone");
            WebElement txtAddress = bitterWebElements.getWebElementById(driver, "address");
            Select ddlProvince = bitterWebElements.ddlSelect(driver, "province");
            WebElement txtPostalCode = bitterWebElements.getWebElementById(driver, "postalCode");
            WebElement txtURL = bitterWebElements.getWebElementById(driver, "url");
            WebElement txtDescription = bitterWebElements.getWebElementById(driver, "desc");
            WebElement txtLocation = bitterWebElements.getWebElementById(driver, "location");
            WebElement btnSubmit = bitterWebElements.getWebElementById(driver, "button");

            // Instantiated required Faker objects.
            FakeValuesService fakeValuesService = new FakeValuesService(new Locale("en"), new RandomService());
            Faker faker = new Faker();

            //Giving Values to WebElements
            String testVar = "######";
            txtFirstName.sendKeys("ed");
            txtLastName.sendKeys("edd");
            txtEmail.sendKeys("edededed@fakegmail.com");
            txtUserName.sendKeys(testVar);
            txtPassword.sendKeys("123");
            txtConfirm.sendKeys("123");
            txtPhoneNumber.sendKeys("(111) 111 1111");
            txtAddress.sendKeys("Street St");
            txtPostalCode.sendKeys("E3B 3B4");
            txtURL.sendKeys("www.ed.com");
            txtDescription.sendKeys("Valid Input");
            txtLocation.sendKeys("Fredericton");
            ddlProvince.selectByVisibleText("New Brunswick");
            btnSubmit.click();

            System.out.println("Username: " + testVar);
            System.out.println("Password: 123");

            //Check Test
            WebElement mySpan = bitterWebElements.getWebElementById(driver, "spanInfo");
            String mySpanInfoText = mySpan.getText();
            String notExpectedMessage = "The user name is existed. Please try the different one!";
            System.out.println("Page Message: " + mySpanInfoText);
            String currentURL = driver.getCurrentUrl();
            String expectedURL = "http://10.10.0.30/qa/phoeben/Login.php";

            if (currentURL.contains(expectedURL)) {
                return true;
            } else if (mySpanInfoText.contains(notExpectedMessage)) {
                return true;
            } else {
                return false;
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public static boolean selectSignup(WebDriver driver) {
        try {

            //Opening the login page.
            driver.get("http://10.10.0.30/qa/phoeben/Login.php");

            //Getting the WebElements 
            WebElement selectSignupLinkText = bitterWebElements.getWebElementByLinkText(driver, "Click Here");

            selectSignupLinkText.click();

            String currentURL = driver.getCurrentUrl();
            String expectedURL = "http://10.10.0.30/qa/phoeben/signup.php";

            if (currentURL.contains(expectedURL)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public static boolean accessUserPage(WebDriver driver) {
        try {

            //Opening the login page.
            driver.get("http://10.10.0.30/qa/phoeben/Login.php");

            //Loggin in
            loginValidUser(driver);

            //Getting the WebElements 
            WebElement selectProfile = bitterWebElements.getWebElementByLinkText(driver, "Ed Oliveira");

            selectProfile.click();

            String currentURL = driver.getCurrentUrl();
            String expectedURL = "http://10.10.0.30/qa/phoeben/userpage.php";

            if (currentURL.contains(expectedURL)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public static boolean performSearch(WebDriver driver) {
        try {

            //Opening the login page.
            driver.get("http://10.10.0.30/qa/phoeben/Login.php");

            //Loggin in
            loginValidUser(driver);

            //Getting the WebElements 
            WebElement searchField = bitterWebElements.selectInputByXpathName(driver, "search");
            searchField.sendKeys("Ed");
            searchField.sendKeys(Keys.ENTER);
            System.out.println(searchField);
            String currentURL = driver.getCurrentUrl();
            String expectedURL = "http://10.10.0.30/qa/phoeben/search.php";

            if (currentURL.contains(expectedURL)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public static boolean passwordValidation(WebDriver driver) {
        try {
            //Opening the signup page.
            driver.get("http://10.10.0.30/qa/phoeben/signup.php");

            // Getting the WebElements 
            WebElement txtFirstName = bitterWebElements.getWebElementById(driver, "firstname");
            WebElement txtLastName = bitterWebElements.getWebElementById(driver, "lastname");
            WebElement txtEmail = bitterWebElements.getWebElementById(driver, "email");
            WebElement txtUserName = bitterWebElements.getWebElementById(driver, "username");
            WebElement txtPassword = bitterWebElements.getWebElementById(driver, "password");
            WebElement txtConfirm = bitterWebElements.getWebElementById(driver, "confirm");
            WebElement txtPhoneNumber = bitterWebElements.getWebElementById(driver, "phone");
            WebElement txtAddress = bitterWebElements.getWebElementById(driver, "address");
            Select ddlProvince = bitterWebElements.ddlSelect(driver, "province");
            WebElement txtPostalCode = bitterWebElements.getWebElementById(driver, "postalCode");
            WebElement txtURL = bitterWebElements.getWebElementById(driver, "url");
            WebElement txtDescription = bitterWebElements.getWebElementById(driver, "desc");
            WebElement txtLocation = bitterWebElements.getWebElementById(driver, "location");
            WebElement btnSubmit = bitterWebElements.getWebElementById(driver, "button");

            // Instantiated required Faker objects.
            FakeValuesService fakeValuesService = new FakeValuesService(new Locale("en"), new RandomService());
            Faker faker = new Faker();
            String username = faker.name().username();

            //Giving Values to WebElements
            String testVar = "123";
            String testVar2 = "12345";
            txtFirstName.sendKeys("ed");
            txtLastName.sendKeys("edd");
            txtEmail.sendKeys("edededed@fakegmail.com");
            txtUserName.sendKeys(username);
            txtPassword.sendKeys(testVar);
            txtConfirm.sendKeys(testVar);
            txtPhoneNumber.sendKeys("(111) 111 1111");
            txtAddress.sendKeys("Street St");
            txtPostalCode.sendKeys("E3B 3B4");
            txtURL.sendKeys("www.ed.com");
            txtDescription.sendKeys("Valid Input");
            txtLocation.sendKeys("Fredericton");
            ddlProvince.selectByVisibleText("New Brunswick");
            btnSubmit.click();

            System.out.println("Username: " + username);
            System.out.println("Password: " + testVar);
            System.out.println("Confirmation: " + testVar2);

            //Check Test
            WebElement mySpan = bitterWebElements.getWebElementById(driver, "spanInfo");
            String mySpanInfoText = mySpan.getText();
            String notExpectedMessage = "The user name is existed. Please try the different one!";
            System.out.println("Page Message: " + mySpanInfoText);
            String currentURL = driver.getCurrentUrl();
            String expectedURL = "http://10.10.0.30/qa/phoeben/Login.php";

            if (currentURL.contains(expectedURL)) {
                return true;
            } else if (mySpanInfoText.contains(notExpectedMessage)) {
                return true;
            } else {
                return false;
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public static boolean moreDigitsPhoneNumber(WebDriver driver) {
        try {
            //Opening the signup page.
            driver.get("http://10.10.0.30/qa/phoeben/signup.php");

            // Getting the WebElements 
            WebElement txtFirstName = bitterWebElements.getWebElementById(driver, "firstname");
            WebElement txtLastName = bitterWebElements.getWebElementById(driver, "lastname");
            WebElement txtEmail = bitterWebElements.getWebElementById(driver, "email");
            WebElement txtUserName = bitterWebElements.getWebElementById(driver, "username");
            WebElement txtPassword = bitterWebElements.getWebElementById(driver, "password");
            WebElement txtConfirm = bitterWebElements.getWebElementById(driver, "confirm");
            WebElement txtPhoneNumber = bitterWebElements.getWebElementById(driver, "phone");
            WebElement txtAddress = bitterWebElements.getWebElementById(driver, "address");
            Select ddlProvince = bitterWebElements.ddlSelect(driver, "province");
            WebElement txtPostalCode = bitterWebElements.getWebElementById(driver, "postalCode");
            WebElement txtURL = bitterWebElements.getWebElementById(driver, "url");
            WebElement txtDescription = bitterWebElements.getWebElementById(driver, "desc");
            WebElement txtLocation = bitterWebElements.getWebElementById(driver, "location");
            WebElement btnSubmit = bitterWebElements.getWebElementById(driver, "button");

            // Instantiated required Faker objects.
            FakeValuesService fakeValuesService = new FakeValuesService(new Locale("en"), new RandomService());
            Faker faker = new Faker();
            String username = faker.name().username();

            //Giving Values to WebElements
            String testVar = "(1111 111 1111"; //There is one digit more, instead of closing bracket

            txtFirstName.sendKeys("ed");
            txtLastName.sendKeys("edd");
            txtEmail.sendKeys("edededed@fakegmail.com");
            txtUserName.sendKeys(username);
            txtPassword.sendKeys("123");
            txtConfirm.sendKeys("123");
            txtPhoneNumber.sendKeys(testVar);
            txtAddress.sendKeys("Street St");
            txtPostalCode.sendKeys("E3B 3B4");
            txtURL.sendKeys("www.ed.com");
            txtDescription.sendKeys("Valid Input");
            txtLocation.sendKeys("Fredericton");
            ddlProvince.selectByVisibleText("New Brunswick");
            btnSubmit.click();

            System.out.println("Username: " + username);
            System.out.println("Password: 123");
            System.out.println("Phone Number: " + testVar);

            //Check Test
            WebElement mySpan = bitterWebElements.getWebElementById(driver, "spanInfo");
            String mySpanInfoText = mySpan.getText();
            String notExpectedMessage = "The user name is existed. Please try the different one!";
            System.out.println("Page Message: " + mySpanInfoText);
            String currentURL = driver.getCurrentUrl();
            String expectedURL = "http://10.10.0.30/qa/phoeben/Login.php";

            if (currentURL.contains(expectedURL)) {
                return true;
            } else if (mySpanInfoText.contains(notExpectedMessage)) {
                return true;
            } else {
                return false;
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public static boolean logout(WebDriver driver) {
        try {

            //Opening the login page.
            driver.get("http://10.10.0.30/qa/phoeben/Login.php");

            //Loggin in
            loginValidUser(driver);

            //Getting the WebElements 
            bitterWebElements.dropdownSelect(driver, "dropdown01", "Logout");
            WebElement logoutLink = bitterWebElements.getWebElementByLinkText(driver, "Logout");
            logoutLink.click();

            String currentURL = driver.getCurrentUrl();
            String expectedURL = "http://10.10.0.30/qa/phoeben/Login.php";

            if (currentURL.contains(expectedURL)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public static boolean editProfPicPageAccess(WebDriver driver) {
        try {
            //Opening the login page.
            driver.get("http://10.10.0.30/qa/phoeben/Login.php");

            //Loggin in
            loginValidUser(driver);

            //Getting the WebElements 
            bitterWebElements.dropdownSelect(driver, "dropdown01", "Edit Profile Picture");
            WebElement editProfPicLink = bitterWebElements.getWebElementByLinkText(driver, "Edit Profile Picture");
            editProfPicLink.click();

            String currentURL = driver.getCurrentUrl();
            String expectedURL = "http://10.10.0.30/qa/phoeben/edit_photo.php";

            if (currentURL.contains(expectedURL)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

}
