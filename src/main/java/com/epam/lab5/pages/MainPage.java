package com.epam.lab5.pages;

import com.epam.lab5.driver.DriverHandler;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {

    @FindBy(xpath = ".//*[@class='M j T b hc Zm  Ke']")
    private WebElement composeButton;

    @FindBy(xpath = "//*[@id='composeto']")
    private WebElement mailToInput;

    @FindBy(id = "cmcsubj")
    private WebElement mailSubjectInput;

    @FindBy(xpath = ".//*[@class='qn']")
    private WebElement mailMessageInput;

    @FindBy(xpath = ".//*[@class='M j T b hc en Ee']")
    private WebElement sendEmailButton;

    @FindBy(xpath = ".//*[@id='views']")
    private WebElement moreButton;

    @FindBy(xpath = ".//*[@id='mn_']/div[2]/div/div[1]/div[8]")
    private WebElement sentMailsFolderButton;

    @FindBy(xpath = ".//*[@class='V j cb cm']")
    private WebElement checkBox;

    @FindBy(xpath = ".//*[@class='V j Vd']")
    private WebElement deleteButton;

    @FindBy(xpath = ".//*[@class='yt']")
    private WebElement deletedMessage;

    @FindBy(xpath = (".//*[@class='yt']//descendant::a[@href='#']"))
    private WebElement mailIsDeletedMessage;


    public MainPage clickComposeButton() {
        DriverHandler.waitToBeClickable(composeButton);
        composeButton.click();
        return this;
    }
    public MainPage enterMailTo(String mailTo){
        mailToInput.sendKeys(mailTo);
        return this;
    }

    public MainPage enterMailSubject(String mailSubject){
        mailSubjectInput.sendKeys(mailSubject);
        return this;
    }

    public MainPage enterMailMessage(String mailMessage){
        mailMessageInput.sendKeys(mailMessage);
        return this;
    }

    public MainPage clickSendButton() {
        DriverHandler.waitToBeClickable(sendEmailButton);
        sendEmailButton.click();
        return this;
    }

    public MainPage clickMoreButton() {
        DriverHandler.waitToBeClickable(moreButton);
        moreButton.click();
        return this;
    }


    public MainPage openSentMails() {
        DriverHandler.waitToBeClickable(sentMailsFolderButton);
        sentMailsFolderButton.click();
        return this;
    }

    public MainPage selectEmail() {
        DriverHandler.waitToBeClickable(checkBox);
        checkBox.click();
        return this;
    }

    public  MainPage deleteEmail() {
        DriverHandler.waitToBeClickable(deleteButton);
        deleteButton.click();
        return this;
    }

    public boolean isMailDeleted() {
        return mailIsDeletedMessage.isDisplayed();
    }



}
