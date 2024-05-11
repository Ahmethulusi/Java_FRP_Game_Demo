class Deck extends BattleLoc{
    public Deck(Player player) {
        super(player,"Güverte",new Pirate(),"Altın Sikke",0,true);
    }
}
class Pirate extends Enemy{
    public Pirate() {
        super(11,"Korsan",15,25,"Ekmek",15);
    }
}

class WareHouse extends NormalLoc{
    public WareHouse(Player player) {
        super(player,"Depo");
    }

    @Override
    public boolean onLocatin() {
        while(true) {
            System.out.println("Geminin deposuna indin.Çok sessiz, istersen etrafa bir bak.(E)/Geri git(G)");
            String look = input.next().toUpperCase();
            if (look.equals("E")) {
                Awards award1 = Awards.getAwardObjByName("Bira Fıçısı");
                Awards award2 = Awards.getAwardObjByName("Saman Çuvalı");
                this.getPlayer().getInventory().getAwardsList().add(award1);
                this.getPlayer().getInventory().getAwardsList().add(award2);
                System.out.println("1 adet " + award1.getName() + " ve " + "1 adet " + award2.getName() + " buldun !");
                return true;
            } else if (look.equals("G")) {
                return true;
            }
        }
    }
}
class Treasure_Room extends NormalLoc {
    public Treasure_Room(Player player) {
        super(player, "Hazine Odası");
    }

    @Override
    public boolean onLocatin() {

        if(!this.getPlayer().isCrystal_flag()) {

            boolean key_flag = false;
            int awardToRemove_index = -1;

            for (int i = 0; i < getPlayer().getInventory().getAwardsList().size(); i++) {
                Awards award = getPlayer().getInventory().getAwardsList().get(i);
                if (award.getName().equals("Taş Anahtar")) {
                    key_flag = true;
                    awardToRemove_index = i; // Anahtarı bulduğumuz indeksi kaydediyoruz
                    break;
                }
            }

            System.out.println("Bir sandık var, açmayı dene (A)");
            while (true) {
                String open = input.next().toUpperCase();
                if (open.equals("A")) {
                    if (key_flag) {
                        System.out.println("(+ Cüce Kristali)");
                        getPlayer().getInventory().getAwardsList().add(Awards.getAwardObjByName("Cüce Kristali"));
                        getPlayer().getInventory().setCountAwardList(1, "Cüce Kristali");

                        // Anahtarı kaldırmak için doğru indeksi kullanıyoruz
                        if (awardToRemove_index != -1) {
                            getPlayer().getInventory().getAwardsList().remove(awardToRemove_index);
                        }

                        System.out.println("\t Önemli! Artık bu kristal sayesinde her yerden Cüce Kentindeki Markete erişebileceksin !");
                        break;
                    } else {
                        System.out.println("Bu sandığı açmak için bir anahtara ihtiyacın var");
                        break;
                    }
                } else {
                    System.out.println("Geçersiz karakter, tekrar dene!");
                }
            }
        }else{
            System.out.println("Buradaki sandığı daha önce açmıştım , dostum durin sağolsun .");
        }
        return true;
    }
}

class Captains_Room extends BattleLoc{
    public Captains_Room(Player player) {
        super(player,"Kaptanın Odası",new Captain_Sirius(),"Ekmek",25,true);
    }

}

class Captains_Cabin extends Location{
    public Captains_Cabin(Player player) {
        super(player, "Kaptan Kamarası");
    }

    @Override
    public boolean onLocatin() {
        Player player = this.getPlayer();
        Location location = null;
        Quit quit = new Quit(player);
        while(true){
            System.out.println("#############\n");
            System.out.println("1 - Hazine Odası\n");
            System.out.println("2 - Kaptanın  Odası\n");
            System.out.println("3 - Geri dön\n");
            System.out.println("#############");

            int selection = input.nextInt();
            switch (selection) {
                case 1:
                    location = new Treasure_Room(player) ;
                    break;
                case 2:
                    location = new Captains_Room(player);
                    break;
                case 3:
                    location = new Quit(player);
                    return true;
                default:
                    location = new GecersizDeger(player);
                    break;
            }
            if(!location.onLocatin()) {
                System.out.println("GAME OVER");
                System.exit(0);
                break;
            }
        }
        return  true;
    }
}

class Go_ElfShip extends Location{
    public Go_ElfShip(Player player) {
        super(player,"ELf Gemisi Enkazı");
    }

    @Override
    public boolean onLocatin() {
        Player player = this.getPlayer();
        Location location = null;
        Quit quit = new Quit(player);
        while(true){
            System.out.println("#############\n");
            System.out.println("1 - Güverte\n");
            System.out.println("2 - Depo \n");
            System.out.println("3 - Kaptanın Kamarası\n");
            System.out.println("4 - Geri dön\n");
            System.out.println("#############");

            int selection = input.nextInt();
            switch (selection) {
                case 1:
                    location= new Deck(player);
                    break;
                case 2:
                    location = new WareHouse(player);
                    break;
                case 3:
                    location = new Captains_Cabin(player);
                    break;
                case 4:
                    location = new Quit(player);
                    return true;
                default:
                    location = new GecersizDeger(player);

                    break;
            }
            if(!location.onLocatin()) {
                System.out.println("GAME OVER");
                System.exit(0);
                break;
            }
        }
        return  true;
    }
}
class Red_Garden extends BattleLoc{
    public Red_Garden(Player player) {
        super(player, "Kızıl Bahçe",new Toy_Ruhu(),"Ruh Kumu",0,true);
    }
}
class Toy_Ruhu extends Enemy{
    public Toy_Ruhu() {
        super(12,"Toy Ruhu",25,50,"Mantar",0);
    }
}
class Swamp_Hut extends NormalLoc{
    public Swamp_Hut(Player player) {
        super(player,"Bataklık Kulubesi");
    }
    private boolean flag = true;
    @Override
    public boolean onLocatin() {
        while (flag) {
            System.out.println("\n1 - Cadı ile konuş\n");
            System.out.println("2 - İksir al\n");
            System.out.println("3 - Geri dön\n");
            int selection = Location.input.nextInt();

            switch (selection) {
                case 1:

                    talkWithWitch();
                    while(true){
                        System.out.println("Geri dönmek için Q ya bas");
                        String geri = input.next().toUpperCase();
                        if(geri.equals("Q"))break;
                    }
                    break;
                case 2:
                    printPotions();
                    buyPotions();
                    break;
                case 3:
                    System.out.println("Çıkılıyor...");
                    flag = false;
                    break;
                default:
                    System.out.println("Geçersiz seçim ! Tekrar deneyiniz");
                    break;
            }
        }
        return true;
    }


    public void talkWithWitch() {
        System.out.println("SHANİ: Geleceğini biliyordum GameChar.Omeron. Ben Shani.\n" +
                "\n" +
                "OMERAN: Adımı nerden biliyorsun cadı.\n");


        System.out.println("Devam etmek için (D) ye bas !\n");
        String contuniueKey = input.next().toUpperCase();
        if(contuniueKey.equals("D")){
            System.out.println("SHANİ: Kader çizgimiz bizi asla yanıltmaz. Kaderin ilmek ilmek kendisini dokuyor.\n" +
                    "\n" +
                    "OMERAN: Kaderimi bildiğini mi düşünüyorsun. Sanırım fazla ot kokluyorsun.\n");
        }
        System.out.println("Devam etmek için (D) ye bas !\n");
        String contuniueKey1 = input.next().toUpperCase();
        if(contuniueKey1.equals("D")) {
            System.out.println("SHANİ: Ukala Melez.Soylu kanın yalnızca kendini beğenmişlikten ibaret.\n" +
                    "\n" +
                    "OMERON: Sakin ol sadece şaka yapıyorum.Bana kaderim hakkında ne söyleyebilirsin.\n" +
                    "\n" +
                    "SHANİ: Umarım krallık yeteneğin şakaların kadar beceriksiz değildir.");
        }
        System.out.println("Devam etmek için (D) ye bas !\n");
        String contuniueKey2 = input.next().toUpperCase();
        if(contuniueKey2.equals("D")){
            System.out.println( "OMERON: Ne? Sen neden bahsediyorsun Shani?\n" +
                    "\n" +
                    "SHANİ: Kral olacaksın GameChar.Omeron, Bir Kral. Uğruna çok kan dökülecek. Dostların, diyarlarına güneş açsın diye \n\t\tbir sonbahar yaprağı gibi dökülüp senin uğruna can verecekler. Gözlerime bak Astorun oğlu bütün bu sorumluluğa hazır mısın ?");
        }
        System.out.println("Devam etmek için (D) ye bas !\n");
        String contuniueKey3 = input.next().toUpperCase();
        if(contuniueKey3.equals("D")){
            System.out.println("OMERON: Ben yalnız savaşırım cadı. Dostlarıma hayal satmam. Hiçbirinin benim uğruma ölmesine izin vermeyeceğim.\n" +
                    "\n" +
                    "SHANİ: Kadere buyuramazsın GameChar.Omeron. Her zaman sana kimin daha üstün olduğunu gösterecektir.\n");
        }
        System.out.println("Devam etmek için (D) ye bas !\n");
        String contuniueKey4 = input.next().toUpperCase();
        if(contuniueKey4.equals("D")){
            System.out.println("OMERAN: Shani çok hoş bir kadın olduğunu söylemişler miydi?\n" +
                    "\n" +
                    "SHANİ: Güle güle Omeran. Uzun bir süreliğine...\n");
        }

    }

    public void printPotions(){
        System.out.println("------İksirler------");
        System.out.println("Mevcut paranız: " + this.getPlayer().getMoney());
        System.out.println();
        for (Potions p : Potions.potion()) {
            if(p!=null){
                System.out.println(p.getId() + " - " + p.getName() + " >>> Fiyat: " + p.getPrice() + "  --- Özellik: " + p.getFeature());
            }
        }
        System.out.println("\n\tMağazaya geri dönmek için 5'e basınız");

    }
    public void buyPotions(){
        System.out.println("Bir seçim yapabilirsiniz.");
        int targetpotioncount=0;
        int selection = input.nextInt();
        if (selection == 5) {
            onLocatin();
        } else {
            while (selection < 1 || selection > Potions.potion().length) {
                System.out.println("Geçersiz değer ! Tekrar deneyiniz:");
                selection = input.nextInt();
            }
            Potions selectedPotion = Potions.getPotionObjById(selection);
//            for (Potions potion : this.getPlayer().getInventory().getPotionsList()) {
//                if (potion != null) {
//                    if (potion.getName().equals(selectedPotion.getName())) {
//                        targetpotioncount = potion.getCount();
//                    }
//                }
//            }


            if (selectedPotion != null) {
                if (selectedPotion.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("Yeterli paranız bulunmamaktadır !");
                    onLocatin();
                } else {
                    System.out.println(selectedPotion.getName() + " satın aldınız !");
                    int balance = this.getPlayer().getMoney() - selectedPotion.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Kalan paranız:" + this.getPlayer().getMoney());
                    if(selectedPotion.getName().equals("Can iksiri")){
                        // Can barını yani maximum canı arttırıyor
                        int newMaxHealth = this.getPlayer().getMax_health()+selectedPotion.getMagnitude();
                        this.getPlayer().setMax_health(newMaxHealth);
                        System.out.println("Mevcut canınız  arttı , Yeni Maximum Can: "+this.getPlayer().getMax_health());
                    }else if(selectedPotion.getName().equals("Kalkan iksiri")){
                        // Envanterdeki mevcut kalkanın bloklama sayısını 3 arttırıyor
                        int newBlocking_count = getPlayer().getInventory().getArmor().getBlocking_count()+selectedPotion.getMagnitude();
                        this.getPlayer().getInventory().getArmor().setBlocking_count(newBlocking_count);
                        System.out.println("Zırhınızın blok sayısı 3 arttırıldı !!");
                    }else if(selectedPotion.getName().equals("Öfke iksiri")){
                        int newDamage = getPlayer().getDamage()+selectedPotion.getMagnitude();
                        this.getPlayer().setDamage(newDamage);
                        System.out.println("Hasarınız arttı "+this.getPlayer().getDamage());
                    }else{
                        int new_health = this.getPlayer().getMax_health();
                        this.getPlayer().setHealth(new_health);
                    }
                }
            }
        }
    }
}
class Go_Swamp extends Location {
    public Go_Swamp(Player player) {
        super(player, "Bataklık");
    }

    @Override
    public boolean onLocatin() {
        Player player = this.getPlayer();
        Location location = null;
        Quit quit = new Quit(player);
        while(true){
            System.out.println("#############\n");
            System.out.println("1 - Kızıl Bahçe\n");
            System.out.println("2 - Bataklık Kulubesi \n");
            System.out.println("3 - Geri dön\n");
            System.out.println("#############");

            int selection = input.nextInt();
            switch (selection) {
                case 1:
                    location= new Red_Garden(player);
                    break;
                case 2:
                    location = new Swamp_Hut(player);
                    break;
                case 3:
                    location = new Quit(player);
                    return true;
                default:
                    location = new GecersizDeger(player);
                    break;
            }
            if(!location.onLocatin()) {
                System.out.println("GAME OVER");
                System.exit(0);
                break;
            }
        }
        return  true;
    }
}
public class Harbour extends Location{
    public Harbour(Player player) {
        super(player,"Liman");
    }

    @Override
    public boolean onLocatin() {
        LimanMenu(this.getPlayer());
        return true;
    }
    public boolean LimanMenu(Player player){
        Location location = null;
        Quit quit = new Quit(player);
        while(true){
            System.out.println("#############\n");
            System.out.println("1 - Elf gemisi enkazı\n");
            System.out.println("2 - Bataklık \n");
            System.out.println("3 - Geri dön\n");
            System.out.println("#############");

            int selection = input.nextInt();
            switch (selection) {
                case 1:
                    location= new Go_ElfShip(player);
                    break;
                case 2:
                    location = new Go_Swamp(player);
                    break;
                case 3:
                    location = new Quit(player);
                    return true;
                default:
                    location = new GecersizDeger(player);
                    break;
            }
            if(!location.onLocatin()) {
                System.out.println("GAME OVER");
                System.exit(0);
                break;
            }
        }
        return  true;
    }
}
