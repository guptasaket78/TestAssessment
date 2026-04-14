package pages;

import configReader.ConfigReader;
import models.MonsterData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static utils.WaitUtils.waitForVisible;
import static utils.WaitUtils.waitForClickable;

public class RegisterPage {
     private final WebDriver driver;
     private final By unicornImage = By.xpath("//div[@data-testid='monster-1']");
     private final By monsterName = By.xpath("//div[@data-testid='monster-name']//input");
     private final By hpValue = By.xpath("//div[@data-testid='hp-value']//input");
     private final By attackValue = By.xpath("//div[@data-testid='attack-value']//input");
     private final By defenceValue = By.xpath("//div[@data-testid='defense-value']//input");
     private final By speedValue = By.xpath("//div[@data-testid='speed-value']//input");
     private final By createMonsterButton = By.xpath("//button[@data-testid='btn-create-monster']");
     private final By validationAlert = By.xpath("//*[@data-testid='alert-required-fields']");

     public RegisterPage(WebDriver driver)
     {
         this.driver =driver;
     }

     public WebElement unicornImage()
     {
         return waitForClickable(driver, unicornImage);
     }

    public WebElement monsterName()
    {
        return waitForVisible(driver, monsterName);
    }

    public WebElement hpValue()
    {
        return waitForVisible(driver, hpValue);
    }

    public WebElement attackValue()
    {
        return waitForVisible(driver, attackValue);
    }

    public WebElement defenceValue()
    {
        return waitForVisible(driver, defenceValue);
    }

    public WebElement speedValue()
    {
        return waitForVisible(driver, speedValue);
    }

    public WebElement createMonsterButton()
    {
        return waitForVisible(driver, createMonsterButton);
    }

    public WebElement validationAlert()
    {
        return waitForVisible(driver, validationAlert);
    }

    public void open()
    {
        driver.get(ConfigReader.baseURL());
    }

    public void selectDefaultMonster()
    {
        unicornImage().click();
    }

    public void fillMonsterForm(MonsterData monsterData)
    {
        type(monsterName(), monsterData.getName());
        type(hpValue(), monsterData.getHp());
        type(attackValue(), monsterData.getAttack());
        type(defenceValue(), monsterData.getDefence());
        type(speedValue(), monsterData.getSpeed());
    }

    public void submit()
    {
        createMonsterButton().click();
    }

    private void type(WebElement element, String value)
    {
        element.clear();
        element.sendKeys(value);
    }

}
