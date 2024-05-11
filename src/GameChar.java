public abstract class GameChar {
    private int xp;
    private String name;
    private int damage;
    private int health;
    private int max_health;
    private int money;
    public GameChar(String name,int xp,int damage, int health,int max_health,int money){
        this.xp=xp;
        this.name=name;
        this.damage=damage;
        this.health=health;
        this.max_health=max_health;
        this.money=money;
    }
    public int getDamage() {
        return damage;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMax_health() {
        return max_health;
    }

    public void setMax_health(int max_health) {
        this.max_health = max_health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static class Omeron extends GameChar{
        public Omeron() {
            super("GameChar.Omeron",0, 150, 100, 100,500);
        }
    }

}
