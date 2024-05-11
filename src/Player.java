import java.util.Scanner;


public class Player {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    private int xp; // İlerde karakterin xp si öldürülen düşman başına gelicek ve
    // belli bir xp'ye ulaşınca level atlayacak ve farklı bir bölgeye gidecek.
    private int damage;
    private int health;
    private int max_health;
    private int money;
    private String name;
    private String characterName;
    private Scanner input= new Scanner(System.in);
    private Inventory inventory;

    private boolean enemy_camp1_flag=true;// TERKEDİLMİŞ EV
    private boolean enemy_camp2_flag=true;// YÜKSELEN DUMAN
    private boolean enemy_camp3_flag=true;// DAĞ ETEĞİ
    private boolean enemy_camp4_flag=true; // DAĞ İÇİ
    private boolean enemy_camp5_flag=true; // DAĞ ZİRVESİ
    private boolean enemy_camp6_flag=true; // SINIR1
    private boolean enemy_camp7_flag=true; // Maden yetisi

    private boolean pirate_combat_flag = true;//Korsan
    private boolean sirius_combat_flag = true;// Kaptan Sirius
    private boolean toy_combat_flag = true;// Toy Ruhu
    private boolean gnoll_combat_flag = true;//Gnoll
    private boolean watchmen_combat_flag = true;//
    private boolean gateGuard_combat_flag = true;//
    private boolean CastleGuard_combat_flag = true;//

    private boolean ruins_flag = true;
    private boolean side_task1 =true;// Zindandaki mahkumlar için
    private boolean side_task2 = true;
    private boolean side_task3 = true;

    private boolean cave_flag=true;  // MAĞARA
    private boolean ahead_of_forest_flag=true;// Ayı için

    private boolean kolye_flag=false;

    private boolean olta_flag = false;
    private int fulling_count = 0;

    private boolean letterOfGoro=false;
    private boolean gnoll_task_flag =false;
    private boolean parrot_flag = false;

    private boolean hanging_garden_flag = false;
    private boolean cellar_flaag = false;

    private boolean crystal_flag = false;
    private boolean kesis_award_flag = false;

    private boolean baron_award_flag = false;
    private boolean yegar_flag = false;
    private boolean boat_flag = false;

    private boolean trimaran_castle_flag_one = true;
    private boolean isTrimaran_castle_flag_two = false;

    private boolean  isTrimaran_castle_flag_three = false;

    private boolean  dark_Garden_Flag = false;
    private boolean  vidic_task_flag = false;

    private boolean  dark_Garden_Visibility_flag = false;
    private boolean kitchen_flag = false;
    private boolean anemon_mount_music = false;
    private boolean saron_prison_flag = false;
    private boolean saron_prison_guard_flag = false;

    //
//        for (int i = 0; i < getPlayer().getInventory().getAwardsList().size(); i++) {
//        Awards award = getPlayer().getInventory().getAwardsList().get(i);
//        if (award.getName().equals("Cüce Kristali")) {
//            crystal_flag= true;
//            break;
//        }
//    }
    public Player() {
        this.inventory=new Inventory();
    }



    public void makeInit(){
        initPlayer(new GameChar.Omeron());
    }


    public void initPlayer(GameChar gameChar){
        this.setMax_health(gameChar.getMax_health());
        this.setDamage(gameChar.getDamage());
        this.setMoney(gameChar.getMoney());
        this.setHealth(gameChar.getHealth());
        this.setCharacterName(gameChar.getName());
    }


    public void printInfo(){
        System.out.println(
                "Hasar : "+(getTotalDamage()-1)+"\n"+ "Sağlık : " + this.getHealth()+"/"+this.getMax_health()+
                "\nSilah : " + this.getInventory().getWeapon().getName()+
                        "\nZırh :" + this.getInventory().getArmor().getName()+
                "\nPara : "+this.getMoney()+" dinar");

    }


// ##################  GETTER AND SETTER METHODS ###################
    public int getDamage() {
        return this.getInventory().getWeapon().getDamage()+damage;
    }
    public int getTotalDamage(){
        return getDamage();
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }
    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        if(health<=0){
            System.exit(0);

        }else{
            this.health = health;
        }
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
        if(this.money<0){
            this.money = money;
        }
        else{
            this.money=money;
        }
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCharacterName() {
        return characterName;
    }
    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }
    public Inventory getInventory() {
        return inventory;
    }
    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
    public Weapon getWeapon(){
        return this.getInventory().getWeapon();
    }
    public Armors getArmor(){
        return this.getInventory().getArmor();
    }
    public int getXp() {
        return xp;
    }
    public void setXp(int xp) {
        this.xp = xp;
    }

    public boolean isEnemy_camp1_flag() {
        return enemy_camp1_flag;
    }
    public void setEnemy_camp1_flag(boolean enemy_camp1_flag) {
        this.enemy_camp1_flag = enemy_camp1_flag;
    }
    public boolean isEnemy_camp2_flag() {
        return enemy_camp2_flag;
    }
    public void setEnemy_camp2_flag(boolean enemy_camp2_flag) {
        this.enemy_camp2_flag = enemy_camp2_flag;
    }
    public boolean isEnemy_camp3_flag() {
        return enemy_camp3_flag;
    }
    public void setEnemy_camp3_flag(boolean enemy_camp3_flag) {
        this.enemy_camp3_flag = enemy_camp3_flag;
    }
    public boolean isCave_flag() {
        return cave_flag;
    }
    public void setCave_flag(boolean cave_flag) {
        this.cave_flag = cave_flag;
    }
    public boolean isAhead_of_forest_flag() {
        return ahead_of_forest_flag;
    }
    public void setAhead_of_forest_flag(boolean ahead_of_forest_flag) {
        this.ahead_of_forest_flag = ahead_of_forest_flag;
    }
    public boolean isEnemy_camp4_flag() {
        return enemy_camp4_flag;
    }
    public void setEnemy_camp4_flag(boolean enemy_camp4_flag) {
        this.enemy_camp4_flag = enemy_camp4_flag;
    }
    public boolean isEnemy_camp5_flag() {
        return enemy_camp5_flag;
    }
    public void setEnemy_camp5_flag(boolean enemy_camp5_flag) {
        this.enemy_camp5_flag = enemy_camp5_flag;
    }
    public boolean isEnemy_camp6_flag() {
        return enemy_camp6_flag;
    }
    public void setEnemy_camp6_flag(boolean enemy_camp6_flag) {
        this.enemy_camp6_flag = enemy_camp6_flag;
    }
    public boolean isSide_task1() {
        return side_task1;
    }
    public void setSide_task1(boolean side_task1) {
        this.side_task1 = side_task1;
    }
    public boolean isSide_task2() {
        return side_task2;
    }
    public void setSide_task2(boolean side_task2) {
        this.side_task2 = side_task2;
    }
    public boolean isSide_task3() {
        return side_task3;
    }
    public void setSide_task3(boolean side_task3) {
        this.side_task3 = side_task3;
    }

    public boolean isKolye_flag() {
        return kolye_flag;
    }

    public void setKolye_flag(boolean kolye_flag) {
        this.kolye_flag = kolye_flag;
    }

    public boolean isEnemy_camp7_flag() {
        return enemy_camp7_flag;
    }

    public void setEnemy_camp7_flag(boolean enemy_camp7_flag) {
        this.enemy_camp7_flag = enemy_camp7_flag;
    }

    public boolean isRuins_flag() {
        return ruins_flag;
    }

    public void setRuins_flag(boolean ruins_flag) {
        this.ruins_flag = ruins_flag;
    }

    public boolean isOlta_flag() {
        return olta_flag;
    }

    public void setOlta_flag(boolean olta_flag) {
        this.olta_flag = olta_flag;
    }

    public int getFulling_count() {
        return fulling_count;
    }

    public void setFulling_count(int fulling_count) {
        this.fulling_count = fulling_count;
    }

    public boolean isLetterOfGoro() {
        return letterOfGoro;
    }

    public void setLetterOfGoro(boolean letterOfGoro) {
        this.letterOfGoro = letterOfGoro;
    }

    public boolean isGnoll_task_flag() {
        return gnoll_task_flag;
    }

    public void setGnoll_task_flag(boolean gnoll_task_flag) {
        this.gnoll_task_flag = gnoll_task_flag;
    }

    public boolean isParrot_flag() {
        return parrot_flag;
    }

    public void setParrot_flag(boolean parrot_flag) {
        this.parrot_flag = parrot_flag;
    }

    public boolean isHanging_garden_flag() {
        return hanging_garden_flag;
    }

    public void setHanging_garden_flag(boolean hanging_garden_flag) {
        this.hanging_garden_flag = hanging_garden_flag;
    }

    public boolean isCellar_flaag() {
        return cellar_flaag;
    }

    public void setCellar_flaag(boolean cellar_flaag) {
        this.cellar_flaag = cellar_flaag;
    }


    public boolean isCrystal_flag() {
        for (int i = 0; i < getInventory().getAwardsList().size(); i++) {
            Awards award = getInventory().getAwardsList().get(i);
            if (award.getName().equals("Cüce Kristali")) {
                crystal_flag= true;
                break;
            }
        }
        return crystal_flag;
    }

    public void setCrystal_flag(boolean crystal_flag) {
        this.crystal_flag = crystal_flag;
    }

    public boolean isKesis_award_flag() {
        return kesis_award_flag;
    }

    public void setKesis_award_flag(boolean kesis_award_flag) {
        this.kesis_award_flag = kesis_award_flag;
    }

    public boolean isBaron_award_flag() {
        return baron_award_flag;
    }

    public void setBaron_award_flag(boolean baron_award_flag) {
        this.baron_award_flag = baron_award_flag;
    }

    public boolean isYegar_flag() {
        return yegar_flag;
    }

    public void setYegar_flag(boolean yegar_flag) {
        this.yegar_flag = yegar_flag;
    }

    public boolean isBoat_flag() {
        return boat_flag;
    }

    public void setBoat_flag(boolean boat_flag) {
        this.boat_flag = boat_flag;
    }

    public boolean isTrimaran_castle_flag_one() {
        return trimaran_castle_flag_one;
    }

    public void setTrimaran_castle_flag_one(boolean trimaran_castle_flag_one) {
        this.trimaran_castle_flag_one = trimaran_castle_flag_one;
    }

    public boolean isTrimaran_castle_flag_two() {
        return isTrimaran_castle_flag_two;
    }

    public void setTrimaran_castle_flag_two(boolean trimaran_castle_flag_two) {
        isTrimaran_castle_flag_two = trimaran_castle_flag_two;
    }

    public boolean isTrimaran_castle_flag_three() {
        return isTrimaran_castle_flag_three;
    }

    public void setTrimaran_castle_flag_three(boolean trimaran_castle_flag_three) {
        isTrimaran_castle_flag_three = trimaran_castle_flag_three;
    }

    public boolean isPirate_combat_flag() {
        return pirate_combat_flag;
    }

    public void setPirate_combat_flag(boolean pirate_combat_flag) {
        this.pirate_combat_flag = pirate_combat_flag;
    }

    public boolean isSirius_combat_flag() {
        return sirius_combat_flag;
    }

    public void setSirius_combat_flag(boolean sirius_combat_flag) {
        this.sirius_combat_flag = sirius_combat_flag;
    }

    public boolean isToy_combat_flag() {
        return toy_combat_flag;
    }

    public void setToy_combat_flag(boolean toy_combat_flag) {
        this.toy_combat_flag = toy_combat_flag;
    }

    public boolean isGnoll_combat_flag() {
        return gnoll_combat_flag;
    }

    public void setGnoll_combat_flag(boolean gnoll_combat_flag) {
        this.gnoll_combat_flag = gnoll_combat_flag;
    }

    public boolean isWatchmen_combat_flag() {
        return watchmen_combat_flag;
    }

    public void setWatchmen_combat_flag(boolean watchmen_combat_flag) {
        this.watchmen_combat_flag = watchmen_combat_flag;
    }

    public boolean isGateGuard_combat_flag() {
        return gateGuard_combat_flag;
    }

    public void setGateGuard_combat_flag(boolean gateGuard_combat_flag) {
        this.gateGuard_combat_flag = gateGuard_combat_flag;
    }

    public boolean isCastleGuard_combat_flag() {
        return CastleGuard_combat_flag;
    }

    public void setCastleGuard_combat_flag(boolean castleGuard_combat_flag) {
        CastleGuard_combat_flag = castleGuard_combat_flag;
    }

    public boolean isDark_Garden_Flag() {
        return dark_Garden_Flag;
    }

    public void setDark_Garden_Flag(boolean dark_Garden_Flag) {
        this.dark_Garden_Flag = dark_Garden_Flag;
    }

    public boolean isVidic_task_flag() {
        return vidic_task_flag;
    }

    public void setVidic_task_flag(boolean vidic_task_flag) {
        this.vidic_task_flag = vidic_task_flag;
    }

    public boolean isDark_Garden_Visibility_flag() {
        return dark_Garden_Visibility_flag;
    }

    public void setDark_Garden_Visibility_flag(boolean dark_Garden_Visibility_flag) {
        this.dark_Garden_Visibility_flag = dark_Garden_Visibility_flag;
    }

    public boolean isKitchen_flag() {
        return kitchen_flag;
    }

    public void setKitchen_flag(boolean kitchen_flag) {
        this.kitchen_flag = kitchen_flag;
    }

    public boolean isAnemon_mount_music() {
        return anemon_mount_music;
    }

    public void setAnemon_mount_music(boolean anemon_mount_music) {
        this.anemon_mount_music = anemon_mount_music;
    }

    public boolean isSaron_prison_flag() {
        return saron_prison_flag;
    }

    public void setSaron_prison_flag(boolean saron_prison_flag) {
        this.saron_prison_flag = saron_prison_flag;
    }

    public boolean isSaron_prison_guard_flag() {
        return saron_prison_guard_flag;
    }

    public void setSaron_prison_guard_flag(boolean saron_prison_guard_flag) {
        this.saron_prison_guard_flag = saron_prison_guard_flag;
    }
    // ###########################################################
}

