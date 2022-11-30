package com.techproject.poms;

import org.hibernate.dialect.Dialect;
//import org.hibernate.sql.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Manager {

    @FindBy(id = "reasonInput")
    public WebElement reasonInput ;

    @FindBy(id = "saveButton")
    public WebElement saveButton;

    @FindBy(id = "outButton")
    public WebElement outButton;

    //@FindBy(id = "optionsA/R")
    private WebElement SelectedElement;
    private WebDriver driver;

    public Manager(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver; // this initializes the private driver field

    }
    public void clickSaveButton(){
        this.saveButton.click();
    }

    public void clickOutButton(){
        this.outButton.click();
    }


    public void enterReason(String reason){
        this.reasonInput.clear();
        this.reasonInput.sendKeys(reason);
    }

    public void selectStatus(String Status){
       // WebElement SelecAcceptElement = TestRunner.driver.findElement(By.id("optionsA/R"));
       System.out.println("Selected status :" + Status);
       String IdSelect = "optionsA/R";
       this.SelectedElement = this.driver.findElement(By.id(IdSelect));
        Select testerOption = new Select(SelectedElement);
        testerOption.selectByVisibleText(Status);

    }
    public void selectTicketNumber(String Ticket){
        // WebElement SelecAcceptElement = TestRunner.driver.findElement(By.id("optionsA/R"));
        //Select testerOption = new Select(TestRunner.driver.findElement(By.id("idInput")));
        //testerOption.selectByVisibleText("18");

        System.out.println("Selected Ticket :" + Ticket);
        this.SelectedElement = this.driver.findElement(By.id("idInput"));
         Select testerOption = new Select(SelectedElement);
         testerOption.selectByVisibleText(Ticket);
 
     }
  
}
