package com.epam.lab5.pages;

import com.epam.lab5.driver.DriverHandler;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    @FindBy(xpath = "//*[@id='identifierId']")
    private WebElement emailInput;

    @FindBy(xpath = "//*[@id='identifierNext']/content/span")
    private WebElement emailNextButton;

    @FindBy(xpath = ".//*[@id='password']//descendant::input")
    private WebElement passwordInput;

    @FindBy(xpath = ".//*[@id='passwordNext']//descendant::span")
    private WebElement passwordNextButton;

    public LoginPage enterEmail(String email) {
        emailInput.sendKeys(email);
        return this;
    }

    public LoginPage clickNextButton() {
        emailNextButton.click();
        return this;
    }

    public LoginPage enterPassword(String password) {
        DriverHandler.waitToBeClickable(passwordInput).sendKeys(password);
        return this;
    }

    public void clickLoginButton() {
        passwordNextButton.click();
    }

}
