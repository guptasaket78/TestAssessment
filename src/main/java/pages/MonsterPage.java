package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static utils.WaitUtils.waitForClickable;
import static utils.WaitUtils.waitForInvisible;
import static utils.WaitUtils.waitForVisible;

public class MonsterPage {
     private final WebDriver driver;
     private final By createdMonsterCard = By.xpath("//*[@data-testid='monster-card']");
     private final By createdMonsterName = By.xpath("//*[@data-testid='card-monster-name']");
     private final By deleteMonsterButton = By.xpath("//*[@data-testid='btn-delete']");

     public MonsterPage(WebDriver driver)
     {
         this.driver =driver;
     }

     public WebElement createdMonsterCard()
     {
         return waitForVisible(driver, createdMonsterCard);
     }

    public WebElement createdMonsterName()
    {
        return waitForVisible(driver, createdMonsterName);
    }

    public WebElement deleteMonsterButton()
    {
        return waitForClickable(driver, deleteMonsterButton);
    }

    public int createdMonstersCount()
    {
        List<WebElement> monsterCards = driver.findElements(createdMonsterCard);
        return monsterCards.size();
    }

    public boolean waitUntilMonsterCardDisappears()
    {
        return waitForInvisible(driver, createdMonsterCard);
    }
}
