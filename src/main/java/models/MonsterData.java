package models;

public class MonsterData {
    private final String name;
    private final String hp;
    private final String attack;
    private final String defence;
    private final String speed;

    public MonsterData(String name, String hp, String attack, String defence, String speed) {
        this.name = name;
        this.hp = hp;
        this.attack = attack;
        this.defence = defence;
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public String getHp() {
        return hp;
    }

    public String getAttack() {
        return attack;
    }

    public String getDefence() {
        return defence;
    }

    public String getSpeed() {
        return speed;
    }

    public MonsterData withName(String value) {
        return new MonsterData(value, hp, attack, defence, speed);
    }

}
