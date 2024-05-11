import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ToolStore extends NormalLoc {

    public ToolStore(Player player) {
        super(player, "Mağaza");
    }

    boolean flag = true;
    private Awards awards;

    @Override
    public boolean onLocatin() {

        while (flag) {
            System.out.println("-------Mağazaya Hoşgeldiniz!-------");
            System.out.println("Mevcut paranız: " + displayBalance()+" gold");
            System.out.println("Yapmak istediğiniz işlemi seçiniz:");
            System.out.println("1 - Silahlar");
            System.out.println("2 - Zırhlar");
           // System.out.println("3-  İksirler");
            System.out.println("3-  Satış yap");
            System.out.println("4 - Geri dön");
            System.out.print("Seçiminiz: ");

            // Kullanıcıdan seçim al
            int selection = Location.input.nextInt();

            switch (selection) {
                case 1:
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    // Zırhlar menüsü
                    printArms();
                    buyArm();
                    break;
//                case 3:
//                    // İksirler ve ev yapım malzemeleri gibi temel ihtiyaçlar satılsın
//                    printPotions();
//                    buyPotions();
//                    break;
                case 3:
                    if(this.getPlayer().getInventory().getAwardsList().isEmpty()){
                        System.out.println("Envanter boş , Satılabilecek herhangi bir şey yok");
                        break;
                    } else{
                        while(true){
                            printSellableAward();
                            System.out.println("Her şeyi satmak için (-1) ye bas !");
                            System.out.println("Geri dönmek için (0) ya bas ! ");
                            int secim = input.nextInt();
                            sellItem(secim);

                            if(secim==-1){
                                sellAllItem();
                                break;
                            }else if(secim==0){
                                break;
                            }else{
                                System.out.println("Geçersiz seçim , tekrar dene !");
                                break;
                            }
                        }
                        break;
                    }
                case 4:
                    System.out.println("Mağazadan çıkılıyor...");
                    flag = false;
                    break;
                default:
                    System.out.println("Geçersiz seçim ! Tekrar deneyiniz");
                    break;
            }
        }
        return true;
    }

    public void printWeapon() {
        System.out.println("------Silahlar------");
        System.out.println("Mevcut paranız: " + displayBalance());
        System.out.println();
        for (Weapon w : Weapon.weapons()) {
            System.out.println(w.getId() + " - " + w.getName() + " > Fiyat: " + w.getPrice() + "-Hasar: " + w.getDamage());
        }
        System.out.println("\n\tMağazaya geri dönmek için 7'e basınız");


    }

    public void buyWeapon() {

        System.out.println("Lütfen bir silah seçin:");
        int selection = input.nextInt();
        if (selection == 7) {
            onLocatin();
        } else {
            while (selection < 1 || selection > Weapon.weapons().length) {
                System.out.println("Geçersiz değer ! Tekrar deneyiniz:");
                selection = input.nextInt();
            }
            Weapon selectedWeapon = Weapon.getWeaponObjById(selection);
            if (selectedWeapon != null) {
                if (selectedWeapon.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("Yeterli paranız bulunmamaktadır !");
                    onLocatin();
                } else {
                    // Burada envanterde en fazla 2 tane silah taşınabildiği için bir koşul yazıldı
                    if(getPlayer().getInventory().getWeaponList().size()>1){
                        System.out.println("Envanter dolu !");
                    }else {
                        System.out.println(selectedWeapon.getName() + " silahını satın aldınız !");
                        int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                        this.getPlayer().setMoney(balance);
                        this.getPlayer().getInventory().getWeaponList().add(selectedWeapon);
                    }
                }
            }
        }
    }

    public void printArms() {

        System.out.println("-----------Zırhlar-----------");
        System.out.println("Mevcut paranız: " + displayBalance());
        System.out.println();
        for (Armors a : Armors.arms()) {
            System.out.println(a.getId() + " - " + a.getName() + " > Fiyat: " + a.getPrice() + "-Dayanıklılık: " + a.getDurability());
        }
        System.out.println("\n\tMağazaya geri dönmek için 4'e basınız");

    }

    public void buyArm() {

        System.out.println("Lütfen bir zırh seçin:");
        int selection = input.nextInt();
        if (selection == 4) {
            onLocatin();
        } else {
            while (selection < 1 || selection > Armors.arms().length) {
                System.out.println("Geçersiz değer ! Tekrar deneyiniz:");
                selection = input.nextInt();
            }
            Armors selectedArm = Armors.getArmObjById(selection);
            if (selectedArm != null) {
                if (selectedArm.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("Yeterli paranız bulunmamaktadır !");
                    onLocatin();
                } else {
                    System.out.println(selectedArm.getName() + "zırhını satın aldınız !");
                    int balance = this.getPlayer().getMoney() - selectedArm.getPrice();
                    this.getPlayer().setMoney(balance);
                    this.getPlayer().getInventory().getArmorList().add(selectedArm);
                }
            }
        }
    }

    public int displayBalance() {
        return this.getPlayer().getMoney();
    }

    public void printSellableAward() {
        System.out.println("Satılabilir eşyalar");
        Player player = this.getPlayer();

        System.out.println("Mevcut paranız : "+this.getPlayer().getMoney());
        if (player != null) {
            Inventory inventory = player.getInventory();
            if (inventory != null) {
                List<Awards> awards = inventory.getAwardsList();
                if (awards != null) {
                    for (Awards award:awards) {
                        if (award != null) {
                            System.out.println(award.getId()+" - "+award.getName() + " x" + award.getCount() + "\t" +"     Birim Satış Fiyatı : "+ award.getSelling_price());
                        }
                    }
                }
            }
        }


    }
    public void sellItem(int selection){

        List<Awards> copyList = new ArrayList<>(getPlayer().getInventory().getAwardsList());
        for(Awards award:copyList){
            if(award.getId()==selection){
                System.out.println("Lütfen kaç tane satmak istediğinizi yazın:");
                int count_selection1 = input.nextInt();
                if(!this.getPlayer().getInventory().getAwardsList().isEmpty()){ // Arraylist'in boş olup olmadığını kontrol et
                    int new_count = award.getCount() - count_selection1; // Negatif sayı kontrolü yapılmalı

                    if (new_count > 0) {
                        award.setCount(new_count);
                        int new_money=this.getPlayer().getMoney()+(award.getSelling_price()*count_selection1);
                        this.getPlayer().setMoney(new_money);
                    }
                    else if(new_count==0){
                        award.setCount(new_count);
                        int new_money=this.getPlayer().getMoney()+(award.getSelling_price()*count_selection1);
                        this.getPlayer().setMoney(new_money);
                        for(int i=0;i<getPlayer().getInventory().getAwardsList().size();i++){
                            if(getPlayer().getInventory().getAwardsList().get(i).getId()==award.getId()){
                                this.getPlayer().getInventory().getAwardsList().remove(award);
                            }
                        }
                    }
                    else {
                        System.out.println("Yetersiz miktar! Stokta yeterince " + award.getName() + " yok.");
                    }
                }
            }
        }
    }
    public void sellAllItem(){
        List<Awards> inventory = getPlayer().getInventory().getAwardsList();

        int totalMoney = getPlayer().getMoney();

        // Tüm envanter ögelerini dolaşarak toplam parayı hesapla
        for (Awards award : inventory) {
            totalMoney += award.getSelling_price() * award.getCount();
        }

        // Tüm envanteri temizle
        inventory.clear();

        // Toplam parayı ayarla
        System.out.println("Tüm eşyalar satıldı. Toplam kazanılan para: " + (totalMoney-getPlayer().getMoney()));
        getPlayer().setMoney(totalMoney);

    }
}