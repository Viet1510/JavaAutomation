package com.techproject.runner;


import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.techproject.poms.Employee;
import com.techproject.poms.Login;
import com.techproject.poms.Manager;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

//@CucumberOptions(features="classpath:features", glue="com/techproject/steps", plugin = {"pretty", "html:src/test/resources/reports/html-reports.html"})
@CucumberOptions(features="classpath:features", glue="com/techproject/steps")//, plugin = {"pretty", "html:src/test/resources/reports/html-reports.html"})

public class TestRunner {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Manager manager;
    public static Login login;
    public static Employee employee;
    @BeforeClass public static void setup(){
        // need to check the chromedriver version matching with the chrome explorer with the below link
        // we can check in target/sufire-reports/...TestRunner.xml for error the chromedriver version
        //https://chromedriver.storage.googleapis.com/index.html?path=107.0.5304.62/
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        //C:\Project2\Tech-Project-Java-Dumplings-\dumpling\src\test\resources\chromedriver.exe
        driver = new ChromeDriver();
        login = new Login(driver);
        manager = new Manager(driver);
        employee = new Employee(driver);
        wait = new WebDriverWait(driver, 15);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
    //src\test\resources\chromedriver.exe
    

    @AfterClass

    public static void teardown(){
        driver.quit();
    }


}
