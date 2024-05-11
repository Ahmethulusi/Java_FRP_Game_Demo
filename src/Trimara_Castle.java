

class Castle_Gate extends BattleLoc{

    public Castle_Gate(Player player) {
        super(player, "Kale Kapısı",new Gate_Guard(),"Kraliyet Çeliği", 0, true);
    }
}
class Gate_Guard extends Enemy{

    public Gate_Guard() {
        super(30,"Kapı Muhafızı", 15, 20, "Kale Anahtarı", 0);
    }
}

class WatchTower extends BattleLoc{

    public WatchTower(Player player) {
        super(player, "Gözcü Kulesi",new WatchMan(),"Gösterişli Taç", 0, true);
    }
}
class WatchMan extends Enemy{
    public WatchMan() {
        super(31, "Gözcü", 10, 15,"Elma",15);
    }
}

class Castle_Guard extends Enemy{
    public Castle_Guard() {
        super(31, "Kale Muhafızı", 20, 30,"Elma",0);
    }
}

class Entrance_Floor extends BattleLoc{

    public Entrance_Floor(Player player) {
        super(player, "Giriş Kat",new Castle_Guard(),"Kraliyet Çeliği", 50, true);
    }
}

class Nolf extends Enemy{
    public Nolf() {
        super(33, "Troll Nolf", 100, 120,"Üzüm",15);
    }
}
class Lower_Floor extends  BattleLoc{
    public Lower_Floor(Player player) {
        super(player, "Alt Kat",new Nolf(),"Kraliyet Şarabı",0,true);
    }
}
class Second_Treasure_Room extends NormalLoc{

    public Second_Treasure_Room(Player player) {
        super(player,"Hazine Odası");
    }

    @Override
    public boolean onLocatin() {
        int targetawardcount = 0;
        for (Awards award : this.getPlayer().getInventory().getAwardsList()) {
            if (award != null) {
                if (award.getName().equals("Kraliyet Altını")) {
                    targetawardcount += award.getCount();
                }
            }
        }
        System.out.println("Hazine Odasına giriş yaptın etrafa bakınmak için (B) ye bas !");
        String lookOut = input.next().toUpperCase();
        if(lookOut.equals("B")){
            if (targetawardcount == 0) {
                getPlayer().getInventory().getAwardsList().add(Awards.getAwardObjByName("Kraliyet Altını"));
                getPlayer().getInventory().setCountAwardList(5, "Kraliyet Altını");
                System.out.println("+5 KRALİYET ALTINI");
                getPlayer().getInventory().getArmorList().add(Armors.getArmObjById(4));
                System.out.println("+ İşlemeli Trimaran Zırhı");
                return true;
            } else {
                getPlayer().getInventory().setCountAwardList(5+ targetawardcount, "Kraliyet Altını");
                System.out.println("+5 KRALİYET ALTINI");
                getPlayer().getInventory().getArmorList().add(Armors.getArmObjById(4));
                System.out.println("+ İşlemeli Trimaran Zırhı");
                return true;
            }
        }
        return true;
    }
}
class Lord_Saloon extends NormalLoc{

    public Lord_Saloon(Player player) {
        super(player, "Lord Salonu");
    }

    @Override
    public boolean onLocatin() {
        System.out.println("LORD MAZZAROTH: Ne büyük bir sürpriz ! Sevgili yeğenim... Ne o, beni ziyarete mi geldin ?\n" +
                "\n" +
                "OMERON: Nihayet buldum seni. Bütün ömrüm bu anı hayal etmekle geçti. Bir an bile seninle karşılaşacağım anı aklımdan çıkartamadım.\n Seni tüm mahvettiğin yaşamlar uğruna öldüreceğim. Babamın ve annemin kanı yerde kalmayacak");
        System.out.println("Devam etmek için (D) ye bas !");
        String devam = input.next().toUpperCase();
        if(devam.equals("D")) {
            System.out.println("LORD MAZZAROTH: Aceleci davranma. Beni hayal kırıklığına uğratıyorsun. Hiçbir şey sebepsiz değildi.\n" +
                    " Ağabeyim Astor yanlış tarafı seçti ve kendi kanına ihanet etti. Elfler her zaman topraklarımızın kanayan yarası olmuştur.\n" +
                    " Sefil yaratıklar. Her zaman daha fazlasını istediler, her zaman daha fazlasını.\n " +
                    "Asrın savaşının nedenini sadece düşkün bir cadının kehaneti mi zannediyorsun GameChar.Omeron ? Ha ha ha...\n" +
                    "\n" +
                    "OMERON: Ucuz yalanların beni kandıramayacak, Seni paramparça edeceğim.");
            System.out.println("Devam etmek için (D) ye bas !");
            String devam1 = input.next().toUpperCase();
            if (devam1.equals("D")) {
                System.out.println("LORD MAZZAROTH: KES SESİNİ MELEZ ! Kiminle konuştuğunu zannediyorsun sen.\n" +
                        " Duyduğun sahte elf destanları seni kör etmiş. Cadının kehaneti Elf Lideri GameChar.Omeron'un iştahını kabarttı.\n" +
                        " Elflerin Yüce Kral Aesir'e karşı olan kıvılcımı kehanet yüzünden vahşi bir aleve dönüştü .\n" +
                        " Onu ve köpeklerini büyük bir iştahla öldürdüm. Tam her şey bitti derken...\n" +
                        " Astor o sefil yaratıkların ukte kalan umutlarını yeniden gün yüzüne çıkardı. Bizi sırtımızdan bıçaklayıp onları kendi kanına tercih etti.\n" +
                        " Bu da yetmezmiş gibi sana o soytarının ismini verip kaderini kirletti. Zavallı Astor. Sonunu kendisi belirledi.\n" +
                        "\n" +
                        "OMERON: Sana inanmıyorum. Bana kanıt göster ! Seni öldürmeden önce tüm bu söylediklerinin doğru olduğunu kanıtla.");
                System.out.println("Devam etmek için (D) ye bas !");
                String devam2 = input.next().toUpperCase();
                if (devam2.equals("D")) {
                    System.out.println("LORD MAZZAROTH: Beni öldüremezsin GameChar.Omeron. Yolunu kaybetmişsin. Bir sonraki adımını göremiyorsun bile.\n" +
                            " Bana ihtiyacın var. Sana kaderinin bir sonraki adımını vereceğim ve karşılığında bu kaleden elimi kolumu sallayarak çıkacağım.\n" +
                            " Sen de ihtiyacın olan gerçeklere ulaşacaksın.\n" +
                            "\n" +
                            "OMERON: Çok kendinden emin konuşuyorsun. Bana ne teklif ediyorsun ?");
                    System.out.println("Devam etmek için (D) ye bas !");
                    String devam3 = input.next().toUpperCase();
                    if (devam3.equals("D")) {
                        System.out.println("LORD MAZZAROTH: Yola geleceğini biliyordum. Al bu mührü. İyi sakla, zamanı geldiği zaman kaderinle arandaki engelleri kaldıracaktır. Bir defa kullanacaksın. \n" +
                                "\n" +
                                "OMERON: Bu şeyi öylece bana verdin. Şuan seni öldürüp yoluma devam edebilirim.");
                        System.out.println("Devam etmek için (D) ye bas !");
                        String devam4 = input.next().toUpperCase();
                        if(devam4.equals("D")){
                            System.out.println("LORD MAZZAROTH: Beni hafife alıyorsun melez. Mühür benim ruhuma bağlı. Ve emin olabilirsin ki GameChar.Omeron, ben yoksam elindekinin hiçbir kıymeti yok. \n" +
                                    "\n" +
                                    "OMERON: Bir gün elbet seni tekrar bulacağım ve bu sefer dilini kesip konuşmana izin vermeyeceğim. \n");
                            getPlayer().getInventory().getAwardsList().add(Awards.getAwardObjByName("Ruh Mühürü"));
                            getPlayer().getInventory().setCountAwardList(1,("Ruh Mühürü"));
                            System.out.println("+ Ruh Mühürü ");
                            System.out.println("Geri => (Q)");
                            while (true) {
                                String geri = input.next().toUpperCase();
                                if (geri.equals("Q")) {
                                    break;
                                }
                            }

                        }
                    }
                }
            }

        }
        return true;

    }
}
//class Lord_Mazzaroth extends Enemy{
//
//    public Lord_Mazzaroth() {
//        super(34, "Lord Mazzaroth", 100, 100,"Tahıl", 0);
//    }
//}
class Higher_Floor extends NormalLoc{
    public Higher_Floor(Player player) {
        super(player, "Üst Kat");
    }

    @Override
    public boolean onLocatin() {
        Location location = null;
        Player player = this.getPlayer();
        while (true) {
            System.out.println("########### Bölgeler ###########");
            System.out.println("\n0- Geri Dön -! ");
            System.out.println("\n1- Lord Salonu- !");
            System.out.println("\n2- Hazine Odası -- !");
            System.out.println("\nLütfen gitmek istediğiniz bölgeyi seçiniz : ");

            int selection = input.nextInt();

            switch (selection) {

                case 0:
                    location = new Quit(player);
                    return true;
                case 1:
                    location = new Lord_Saloon(player);
                    break;
                case 2:
                    location = new Second_Treasure_Room(player);
                    break;
                default:
                    location = new GecersizDeger(player);
                    System.out.println("Lütfen geçerli bir değer giriniz !");
                    break;
            }


            if (!location.onLocatin()) {
                System.out.println("GAME OVER");
                System.exit(0);
                break;
            }
        }
        return true;
    }

}





class Castle_Entrance extends NormalLoc {

    public Castle_Entrance(Player player) {
        super(player, "Kale Girişi");
    }

    @Override
    public boolean onLocatin() {
        Location location = null;
        Player player = this.getPlayer();
        while (true) {
            System.out.println("########### Bölgeler ###########");
            System.out.println("\n0- Geri Dön -! ");
            if(getPlayer().isTrimaran_castle_flag_one()){
                System.out.println("\n1- Giriş Katı -- !");
            }
            if(getPlayer().isTrimaran_castle_flag_two()){
                System.out.println("\n2- Alt Kat - !");
            }
            if(getPlayer().isTrimaran_castle_flag_three()){
                System.out.println("\n3- Üst Kat  -- !");
            }
            System.out.println("\n4 -Envanteri Görüntüle -- !");
            System.out.println("\nLütfen gitmek istediğiniz bölgeyi seçiniz : ");

            int selection = input.nextInt();

            switch (selection) {

                case 0:
                    location = new Quit(player);
                    return true;
                case 2:
                    location = new Lower_Floor(player);
                    break;
                case 1:
                    location = new Entrance_Floor(player);
                    break;
                case 3:
                    location = new Higher_Floor(player);
                    break;
                case 4:
                    location = new GoInventory(player);
                    break;

                default:
                    location = new GecersizDeger(player);
                    System.out.println("Lütfen geçerli bir değer giriniz !");
                    break;
            }


            if (!location.onLocatin()) {
                System.out.println("GAME OVER");
                System.exit(0);
                break;
            }
        }
        return true;
    }
}
class Trimara_Castle extends NormalLoc{
    public Trimara_Castle(Player player) {
        super(player,"Trimara Kalesi");
    }

    @Override
    public boolean onLocatin() {
        Location location = null;
        Player player = this.getPlayer();
        while (true) {
            System.out.println("----------------");
            player.printInfo();
            System.out.println("----------------");
            System.out.println("########### Bölgeler ###########");
            System.out.println("\n0- Geri Dön -! ");
            System.out.println("\n1- Kale Kapısı - !");
            System.out.println("\n2- Gözcü Kulesi -- !");
            System.out.println("\n3- Kale Girişi  -- !");
            System.out.println("\n4 -Envanteri Görüntüle -- !");
            System.out.println("\nLütfen gitmek istediğiniz bölgeyi seçiniz : ");

            int selection = input.nextInt();

            switch (selection) {

                case 0:
                    location = new Quit(player);
                    return true;
                case 1:
                    location = new Castle_Gate(player);
                    break;
                case 2:
                    location = new WatchTower(player);
                    break;
                case 3:
                    location = new Castle_Entrance(player);
                    break;
                case 4:
                    location = new GoInventory(player);
                    break;

                default:
                    location = new GecersizDeger(player);
                    System.out.println("Lütfen geçerli bir değer giriniz !");
                    break;
            }


            if (!location.onLocatin()) {
                System.out.println("GAME OVER");
                System.exit(0);
                break;
            }
        }

        return true;
    }
}