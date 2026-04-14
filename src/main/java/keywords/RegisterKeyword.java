package keywords;

import models.MonsterData;
import pages.RegisterPage;

public class RegisterKeyword {

    private final RegisterPage registerPage;

    public RegisterKeyword(RegisterPage registerPage)
    {
        this.registerPage =registerPage;
    }

    public void createMonster(MonsterData monsterData)
    {
        openRegisterPage();
        registerPage.selectDefaultMonster();
        registerPage.fillMonsterForm(monsterData);
        registerPage.submit();
    }

    public void openRegisterPage()
    {
        registerPage.open();
    }

    public void createMonsterFromSelectedTemplate(MonsterData monsterData)
    {
        registerPage.selectDefaultMonster();
        registerPage.fillMonsterForm(monsterData);
        registerPage.submit();
    }
}
