package tests;

import base.BaseUiTest;
import configReader.ConfigReader;
import models.MonsterData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterMonster extends BaseUiTest {

    @Test
    public void shouldCreateMonsterSuccessfully()
    {
        registerKeyword.createMonster(ConfigReader.monsterData());
        Assert.assertEquals(monsterPage.createdMonstersCount(), 1);
        Assert.assertEquals(
                monsterPage.createdMonsterName().getText(),
                ConfigReader.monsterData().getName()
        );
    }

    @Test
    public void shouldShowValidationWhenNameIsEmpty()
    {
        MonsterData monsterData = ConfigReader.monsterData().withName("");

        registerKeyword.openRegisterPage();
        registerKeyword.createMonsterFromSelectedTemplate(monsterData);

        Assert.assertEquals(registerPage.validationAlert().getText(), "All fields are required");
        Assert.assertEquals(monsterPage.createdMonstersCount(), 0);
    }

    @Test
    public void shouldDeleteCreatedMonster()
    {
        registerKeyword.createMonster(ConfigReader.monsterData());

        monsterPage.deleteMonsterButton().click();

        Assert.assertTrue(monsterPage.waitUntilMonsterCardDisappears());
        Assert.assertEquals(monsterPage.createdMonstersCount(), 0);
    }
}
