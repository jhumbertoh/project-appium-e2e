package com.company.projectappiume2e.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AndroidCalculatorPage extends Page {

    //Numbers
    private By btnZero = By.xpath("//android.widget.Button[@text='0']");
    private By btnOne = By.xpath("//android.widget.Button[@text='1']");
    private By btnTwo = By.xpath("//android.widget.Button[@text='2']");
    private By btnThree = By.xpath("//android.widget.Button[@text='3']");
    private By btnFour = By.xpath("//android.widget.Button[@text='4']");
    private By btnFive = By.xpath("//android.widget.Button[@text='5']");
    private By btnSix = By.xpath("//android.widget.Button[@text='6']");
    private By btnSeven = By.xpath("//android.widget.Button[@text='7']");
    private By btnEight = By.xpath("//android.widget.Button[@text='8']");
    private By btnNine = By.xpath("//android.widget.Button[@text='9']");

    //Operators
    private By btnAdd = By.id("com.google.android.calculator:id/op_add");
    private By btnSub = By.id("com.google.android.calculator:id/op_sub");
    private By btnDiv = By.id("com.google.android.calculator:id/op_div");
    private By btnMul = By.id("com.google.android.calculator:id/op_mul");
    private By btnEqu = By.id("com.google.android.calculator:id/eq");

    //Result
    private By txtResult = By.id("com.google.android.calculator:id/result_final");


    public AndroidCalculatorPage(WebDriver driver) {
        super(driver);
        isAndroidCalculatorPageLoaded();
    }

    private void isAndroidCalculatorPageLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(btnEqu)));
    }

    public void calculate(String operator1, String operator2, String operation) {
        //5645 ; 456 ; PLUS
        clickOnCalcNumber(operator1);
        clickOnOperation(operation);
        clickOnCalcNumber(operator2);
        driver.findElement(btnEqu).click();
    }

    public void clickOnCalcNumber(String number) {
        for (Character digit : number.toCharArray()) {
            clickNumber(digit);
        }
    }

    public void clickNumber(Character num) {
        if (num.equals('0')) {
            driver.findElement(btnZero).click();
        } else if (num.equals('1')) {
            driver.findElement(btnOne).click();
        } else if (num.equals('2')) {
            driver.findElement(btnTwo).click();
        } else if (num.equals('3')) {
            driver.findElement(btnThree).click();
        } else if (num.equals('4')) {
            driver.findElement(btnFour).click();
        } else if (num.equals('5')) {
            driver.findElement(btnFive).click();
        } else if (num.equals('6')) {
            driver.findElement(btnSix).click();
        } else if (num.equals('7')) {
            driver.findElement(btnSeven).click();
        } else if (num.equals('8')) {
            driver.findElement(btnEight).click();
        } else if (num.equals('9')) {
            driver.findElement(btnNine).click();
        }
    }

    public void clickOnOperation(String operation) {
        switch (operation.toUpperCase()) {
            case "PLUS":
                driver.findElement(btnAdd).click();
                break;
            case "SUBTRACTION":
                driver.findElement(btnSub).click();
                break;
            case "MULTIPLICATION":
                driver.findElement(btnMul).click();
                break;
            case "DIVISION":
                driver.findElement(btnDiv).click();
                break;
            default:
                throw new IllegalStateException("The option " +operation.toUpperCase() + " in not present");
        }
    }

    public String getResult(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(txtResult));
        return driver.findElement(txtResult).getText();
    }
}
