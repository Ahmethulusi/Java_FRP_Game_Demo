import java.util.ArrayList;
import java.util.List;

public class GoInventory extends NormalLoc {
    private Inventory inventory;

    public GoInventory(Player player) {
        super(player,"Envanteri Görüntüle");
        this.inventory=new Inventory();
    }

    @Override
    public boolean onLocatin() {
        boolean ctrl_variable = true;
        do {
            displayInventory();
            System.out.println("\nEmin misin (E/H) ?");
            String selection = input.next().toUpperCase();
            if(selection.equals("E")){
                return true;
            } else if (selection.equals("H")) {
                continue;
            }else if(selection.equals("U")){

                return true;
            }
            else{
                System.out.println("Geçersiz değer !");
                continue;
            }
        }while(ctrl_variable);
        return true;

    }
    // Bu OOP için kötü bir kullanım bunu Inventoryde return ile döndürüp burada kullanman gerekiyor
    public void displayInventory(){
        while(true) {


            System.out.println("\n######### ENVANTER #########\n");
            System.out.println("Silah:"+getPlayer().getWeapon().getName()+"\n");
            System.out.println("Zırh:"+getPlayer().getArmor().getName()+"\n");
            Player player = this.getPlayer();

            System.out.println(" Silahları görmek için S' ye bas" +
                    "\n Zırhları Görmek için Z' ye bas " +
                    "\n Eşyaları görmek için E' ye bas " +
                    "\n Notları görmek için N' ye bas " +
                    "\n Ana menüye dönmek için Q' ya bas !");


            String choose = input.next().toUpperCase();
            if (choose.equals("E")) {
                printAwards();
            } else if (choose.equals("N")) {
                GoLetters();
            } else if(choose.equals("Q")){
                break;
            }else if(choose.equals("S")){
                printWeapons();
            }else if(choose.equals("Z")){
                printArmors();
            }
        }

    }
    public void printWeapons(){
        while(true) {
            if (getPlayer() != null) {
                Inventory inventory = getPlayer().getInventory();
                if (inventory != null) {
                    List<Weapon> weapons = inventory.getWeaponList();
                    if (weapons != null) {
                        if(!weapons.isEmpty()) {

                            for (int i = 0; i < weapons.size(); i++) {
                                Weapon weapon = weapons.get(i);
                                if (weapon != null && weapon.getId() != 0) {
                                    System.out.println(i + 1 + " - " + weapon.getName() + " Hasar: " + weapon.getDamage() + " Level: " + weapon.getLevel());
                                }
                            }
                            System.out.println(" Kuşanmak için numarayı tuşla ! \n 0 - Geri Dön )");
                            int secim = input.nextInt();
                            if (secim == 0) break;
                            else if (secim > weapons.size()) {
                                System.out.println("Geçersiz Seçim , tekrar dene !");
                            } else {
                                if (!getPlayer().getWeapon().getName().equals("Yumruk")) {
                                    this.getPlayer().getInventory().getWeaponList().add(getPlayer().getWeapon());
                                }
                                this.getPlayer().getInventory().setWeapon(getPlayer().getInventory().getWeaponList().get(secim - 1));
                                this.getPlayer().getInventory().getWeaponList().remove(secim - 1);
                            }
                        }else{
                            System.out.println("Envanterde Herhangi bir silah yok !");
                            System.out.println("Geri => (Q)");
                            while(true){
                                String geri = input.next().toUpperCase();
                                if(geri.equals("Q")){
                                    break;
                                }
                            }
                            break;
                        }
                    }
                }
            }
        }
    }
    public void printArmors() {
        while (true) {
            if (getPlayer() != null) {
                Inventory inventory = getPlayer().getInventory();
                if (inventory != null) {
                    List<Armors> armors = inventory.getArmorList();
                    if (armors != null) {
                        if(!armors.isEmpty()) {
                            for (int i = 0; i < armors.size(); i++) {
                                Armors armor = armors.get(i);
                                if (armor != null && armor.getId() != 0) {
                                    System.out.println(i + 1 + " - " + armor.getName() + " Dayanıklılık: " + armor.getDurability() + "Bloklama Sayısı:" + armor.getBlocking_count() + " Level: " + armor.getLevel());
                                }
                            }
                            System.out.println(" Kuşanmak için numarayı tuşla ! \n 0 - Geri Dön )");
                            int secim = input.nextInt();
                            if (secim == 0) break;
                            else if (secim > armors.size()) {
                                System.out.println("Geçersiz Seçim , tekrar dene !");
                            } else {
                                if (!getPlayer().getArmor().getName().equals("Yok")) {
                                    this.getPlayer().getInventory().getArmorList().add(getPlayer().getArmor());
                                }
                                this.getPlayer().getInventory().setArmor(getPlayer().getInventory().getArmorList().get(secim - 1));
                                this.getPlayer().getInventory().getArmorList().remove(secim - 1);
                            }
                        }else{
                            System.out.println("Envanterde Herhangi bir zırh yok !");
                            System.out.println("Geri => (Q)");
                            while(true){
                                String geri = input.next().toUpperCase();
                                if(geri.equals("Q")){
                                    break;
                                }
                            }
                            break;
                        }
                    }
                }
            }
        }
    }
    public void printAwards(){
        while(true){
            if (getPlayer() != null) {
                Inventory inventory = getPlayer().getInventory();
                if (inventory != null) {
                    List<Awards> awards = inventory.getAwardsList();
                    if (awards != null) {
                        int size = awards.size();
                        if(size==0){
                            System.out.println("\nEnvanter Boş !");
                            System.out.println("\nGeri Dön (Q)");
                            String geri = input.next().toUpperCase();
                            if(geri.equals("Q"))break;
                            else{System.out.println("Geçersiz karakter , tekrar dene !");}
                        }else {
                            for (int i = 0; i < awards.size(); i++) {
                                Awards award = awards.get(i);
                                if (award != null) {
                                    System.out.println(award.getName() + " x" + award.getCount() + "\t ");

                                }
                            }
                            System.out.println("\nGeri Dön (Q)");
                            String geri = input.next().toUpperCase();
                            if(geri.equals("Q"))break;
                            else{System.out.println("Geçersiz karakter , tekrar dene !");}
                        }
                    }
                }
            }

        }
    }
    public void printUsableItem(){
        Player player = this.getPlayer();

        if (this.getPlayer() != null) {
            Inventory inventory = player.getInventory();
            if (inventory != null) {
                List<Awards> awards = inventory.getAwardsList();
                if (awards != null) {
                    for (int i = 0; i < awards.size(); i++) {
                        Awards award = awards.get(i);
                        if (award != null && !award.isFlag()) {
                            System.out.println((i+1)+" - "+award.getName() + " x" + award.getCount()+"\t");

                        }
                    }
                }
            }
        }
    }

    public void GoLetters(){
        while(true){
            if (getPlayer() != null) {
                Inventory inventory = getPlayer().getInventory();
                if (inventory != null) {
                    List<Letters> letters = inventory.getLettersList();
                    if (letters != null) {
                        int size = letters.size();
                        if(size==0){
                            System.out.println("\nHerhangi bir not yok !");
                            System.out.println("\nGeri Dön (Q)");
                            String geri = input.next().toUpperCase();
                            if(geri.equals("Q"))break;
                            else{System.out.println("Geçersiz karakter , tekrar dene !");}
                            break;
                        }else{
                            for (int i = 0; i < letters.size(); i++) {
                                Letters letter = letters.get(i);
                                if (letter != null) {
                                    System.out.println(letter.getId()+" - "+letter.getLetter_name());
                                }
                            }
//                            System.out.println("\nGeri Dön (Q)");
//                            String geri = input.next().toUpperCase();
//                            if(geri.equals("Q"))break;
//                            else{System.out.println("Geçersiz karakter , tekrar dene !");}
                        }

                    }else{
                        break;
                    }
                }
            }
            System.out.println("Geri dönmek için (0) a basın !");
            int selection = input.nextInt();
            if(selection==0){
                break;
            }else{
                if (getPlayer() != null) {
                    Inventory inventory = getPlayer().getInventory();
                    if (inventory != null) {
                        List<Letters> letters = inventory.getLettersList();
                        if (letters != null) {
                            for (int i = 0; i < letters.size(); i++) {
                                Letters letter = letters.get(i);
                                if (letter != null) {
                                    if(letter.getId()==selection){
                                        System.out.println(letter.getContent_of_letter());
                                    }
                                }
                            }
                        }
                    }
                }

                System.out.println("\nGeri dönmek için Q ' ya bas !");
                String geri = input.next().toUpperCase();
                if(geri.equals("Q")){
                    break;
                }else{
                    System.out.println("Geçersiz değer,tekrar dene !");
                }
            }
        }
    }

}