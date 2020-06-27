package com.company.projectappiume2e.pages;


import com.company.projectappiume2e.models.RedmineProject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RedmineProjectsPage extends Page {

    private By btnNewProject = By.xpath("//a[text()='New project']");
    private By txtProjectName = By.id("project_name");
    private By txtProjectDescription = By.id("project_description");
    private By txtHomePage = By.id("project_homepage");
    private By chkPublicProject = By.id("project_is_public");
    private By btnCreate = By.name("commit");
    private By lblMessage = By.id("flash_notice");

    public RedmineProjectsPage(WebDriver driver) {
        super(driver);
    }

    public void createProject(RedmineProject redmineProject) {

        driver.findElement(btnNewProject).click();
        driver.findElement(txtProjectName).sendKeys(redmineProject.getName());
        driver.findElement(txtProjectDescription).sendKeys(redmineProject.getDescription());
        driver.findElement(txtHomePage).sendKeys(redmineProject.getHomePage());

        WebElement checkBoxProject = driver.findElement(chkPublicProject);
        if(redmineProject.getPublic()){
            if(!checkBoxProject.isSelected())
                checkBoxProject.click();
        }else {
            if(checkBoxProject.isSelected())
               checkBoxProject.click();
        }


    }

    public String getUIMessage(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(lblMessage)));
        return driver.findElement(lblMessage).getText();
    }
}