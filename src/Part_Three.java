public class Part_Three extends Location{
    public Part_Three(Player player) {
        super(player, "Saron");
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
            System.out.println("\n0- Geri Dön - ! ");
            System.out.println("\n1- Saron Oyuğu -- !");
            System.out.println("\n2- Saron Kasabası");
            System.out.println("################################");
            int selection = input.nextInt();

            switch (selection) {

                case 0:
                    location = new Quit(player);
                    return true;
                case 1:
                    location = new Saron_Hollow(player);
                    break;
                case 2:
                    location = new Saron_Town(player);
                    break;
                default:
                    location = new GecersizDeger(player);
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
class Saron_Hollow extends Location {

    public Saron_Hollow(Player player) {
        super(player, "Saron Oyuğu");
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
            System.out.println("\n 0 - Geri Dön ");
            System.out.println("\n 1 - Terkedilmiş Bölge");
            System.out.println("################################");
            int devam = input.nextInt();
            switch (devam) {
                case 0:
                    location = new Quit(player);
                    return true;
                case 1:
                    location = new Abondoned_Place(player);
                    break;
                default:
                    location = new GecersizDeger(player);
                    System.out.println("Lütfen geçerli bir değer giriniz !");
                    break;
            }

            if (!location.onLocatin()) {
                System.out.println("GAME OVER");
                System.exit(0);
                return false;

            }
            return true;
        }
    }
}

class Abondoned_Place extends Location{

    public Abondoned_Place(Player player) {
        super(player, "Terkedilmiş Bölge");
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
            System.out.println("\n 0 - Geri Dön ");
            System.out.println("\n 1 - Yarı İnsan Harabeleri ");
            System.out.println("\n 2 - Warstel Köşkü ");
            System.out.println("################################");
            int devam = input.nextInt();
            switch (devam){
                case 0:
                    location = new Quit(player);
                    return true;
                case 1:
                    location = new Semi_Human_Ruins(player);
                    break;
                case 2:
                    location = new Warstel(player);
                    break;
                default:
                    location = new GecersizDeger(player);
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
class Semi_Human_Ruins extends Location {

    public Semi_Human_Ruins(Player player) {
        super(player, "Yarı İnsan Harabeleri");
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
            System.out.println("\n 0 - Geri Dön  ");
            System.out.println("\n 1 - Kasvetli Kulube");
            System.out.println("\n 2 - Anıt Kalıntıları ");
            System.out.println("################################");
            int devam = input.nextInt();
            switch (devam) {
                case 0:
                    location = new Quit(player);
                    return true;
                case 1:
                    location = new Gloomy_Cabin(player);
                    break;
                case 2:
                    location = new Monument_Remains(player);
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
class Monument_Remains extends BattleLoc {

        public Monument_Remains(Player player) {
            super(player, "Anıt Kalıntıları",new Looter(),"Tahıl",0,true);
        }

}
class Looter extends Enemy{

    public Looter() {
        super(20,"Yağmacı",14,30,"Çalıntı Eşya",100);
    }
}

class Gloomy_Cabin extends Location {
    public Gloomy_Cabin(Player player) {
        super(player, "Kasvetli Kulübe");
    }

    @Override
    public boolean onLocatin() {
        if(getPlayer().getInventory().searchAward("Panzehir")==null) {

            System.out.println("OMERON: Hey ! Nesin lan sen ?\n" +
                    "\n" +
                    "GARİP VARLIK: Acıma son ver. Yalvarırım sana... Bitir işimi.\n");
            System.out.println("Devam etmek için (D) ye bas !");
            String devam = input.next().toUpperCase();
            if (devam.equals("D")) {
                System.out.println("GARİP VARLIK: Vigo... Baron Vigo ve dahi köpeği Ralph. Güç hırsı uğruna insanları kandırıp genetiklerini alt üst ettiler.\nKendilerine insanlardan çok daha güçlü ancak çok daha saf köleler yarattılar. Yalnızca iki yıl önce sıradan bir insandım.\nHastanede çalışır doktorlara yardımcı olurdum. Günün birinde Ralph beni yanına çağırdı ve elime bir bardak likör tutuşturdu.\nHalkımızın kurtuluşu, yeni düzen gibi şeyler zırvaladı. Kurtuluşumuzun öncüsü olarak beni seçmişti. En gözde ırk olup yeni düzende her şeye sahip olacaktık.\nVe her şeyden önemlisi tüm bunların öncüsü ben olacaktım. Hayallerim gözlerime perde çekti ve gerçekleri göremedim.\n" +
                        "\n" +
                        "OMERON: İşler ters gitmiş gibi. Sonra ne oldu ?\n");
                System.out.println("Devam etmek için (D) ye bas !");
                String devam1 = input.next().toUpperCase();
                if (devam1.equals("D")) {
                    System.out.println("GARİP VARLIK: Uyandığımda kendimi küçük bir odaya kapatılmış olarak buldum.Arada bir Ralph gelip kendimi nasıl hissettiğimi soruyordu.\nBir şeyler yanlıştı. Kendimi kahramandan çok bir ucube gibi hissetmeye başladım.\nSırtım kamburlaştı,Ellerim bedenime ait değil gibiydi. Gözlerim deli gibi yanıyordu. Nefes alamıyordum.\nKandırılmıştım, sadece bir denektim. Kimsenin gözünde zerre değeri olmayan bir denek. Ölmeyi ilk defa çok istedim.\n" +
                            "\n" +
                            "OMERON: Seni buraya onlar mı attı ?\n");
                    System.out.println("Devam etmek için (D) ye bas !");
                    String devam2 = input.next().toUpperCase();
                    if (devam2.equals("D")) {
                        System.out.println("GARİP VARLIK: Evet. Benden umutlarını kesmeleriyle kendimi burda bulmam bir oldu. Arada bir gezginler evi boş zannedip yanıma uğrar.\nİğrenen bakışlar altında hikayemi dinlerler. Bir tanesi bana yardım etmeye kararlıydı. Doktoru bulup intikamımı alacaktı.\nAncak kapı mühürlenmiş. Şerefsizler gizli işlerini saklamak için kapıyı mühürlemiş.\n" +
                                "\n" +
                                "OMERON: Adın ne sevgili dostum ?\n" +
                                "\n" +
                                "GARİP VARLIK: Arthur. Saronlu Arthur.\n" +
                                "\n" +
                                "OMERON: Sana yardım edeceğim Arthur.\n");
                        System.out.println("Geri dönmek için Q ya bas !");
                        while (true) {
                            String geri = input.next().toUpperCase();
                            if (geri.equals("Q")) {
                                break;
                            } else {
                                System.out.println("Geçersiz karakter ,tekrar dene !");
                            }
                        }
                    }
                }
            }
        }else{
            System.out.println("OMERON: Arthur.\n" +
                    "\n" +
                    "ARTHUR:...\n" +
                    "\n" +
                    "OMERON: Arthur... Hey Arthur.\n" +
                    "\n" +
                    "ARTHUR:...\n" +
                    "\n" +
                    "OMERON: Geç kaldım. işi bitmiş. Bekleyişin son buldu koca dostum, huzur içinde uyu.\n");
            while (true) {
                String geri = input.next().toUpperCase();
                if (geri.equals("Q")) {
                    break;
                } else {
                    System.out.println("Geçersiz karakter ,tekrar dene !");
                }
            }
        }
        return true;
    }
}





///////////////////////////////////////////////
class Warstel extends Location {
    public Warstel(Player player) {
        super(player, "Warstel Köşkü");
    }

    @Override
    public boolean onLocatin() {
        System.out.println("İlerde tregator kapısı var yaklaşmak için E ye bas !");
        String comeCloser = input.next().toUpperCase();
        if(comeCloser.equals("E")){
            if(getPlayer().getInventory().FindCount("Ruh Mühürü")>0 || getPlayer().getInventory().FindCount("Tregator Anahtarı")>0) {
                if(getPlayer().getInventory().FindCount("Tregator Anahtarı")==0){
                System.out.println("OMERON: Kapının önüne gelince mühür ısınmaya ve değişmeye başladı.\nBana bir mesaj vermeye çalışıyor gibi. Bir sonraki adımım burası olmalı.");
                Awards tregator_key  = Awards.getAwardObjByName("Tregator Anahtarı");
                assert tregator_key != null;
                tregator_key.setCount(1);
                getPlayer().getInventory().getAwardsList().add(tregator_key);
                System.out.println("!!! Ruh Mühürü Tregatorun Anahtarına dönüştü !!!");
                getPlayer().getInventory().deleteAward("Ruh Mühürü");
                System.out.println("+ Tregatorun Anahtarı");
                }
                System.out.println("Kapıyı açmak için E ' ye bas !");
                String open = input.next().toUpperCase();
                if(open.equals("E")){
                    Location location = null;
                    Player player = getPlayer();
                    while(true){
                        System.out.println("0 - Geri ");
                        System.out.println("1 - Çarşı");
                        System.out.println("2 - Yeraltı Hastanesi");
                        System.out.println("3 - Jerry'nin Likörhanesi");
                        System.out.println("4 - Arena");
                        System.out.println("5 - Görkemli Saray");
                        if(getPlayer().isDark_Garden_Visibility_flag()){
                            System.out.println("6 - Karanlık Bostan");
                        }
                        int selection = input.nextInt();
                        switch (selection){
                            case 0:
                                location = new Quit(player);
                                return true;
                            case 1:
                                location = new ToolStore(player);
                                break;
                            case 2:
                                location = new UnderGround_Hospital(player);
                                break;
                            case 3:
                                location = new LiquourHouse_of_Jerry(player);
                                break;
                            case 4:
                                location = new Arena(player);
                                break;
                            case 5:
                                location = new Awesome_Palace(player);
                                break;
                            case 6:
                                location = new Dark_Garden(player);
                                break;
                            default:
                                location = new GecersizDeger(player);
                                System.out.println("Geçersiz değer , tekar dene !");
                                break;
                        }
                        if (!location.onLocatin()) {
                            System.out.println("GAME OVER");
                            System.exit(0);
                            break;
                        }
                    }
                }else{
                    return true;
                }
            }else{
                System.out.println("Sanırım buradan hiçbir yere gidemiyorum geri dönmeliyim (Q) ");
                while (true) {
                    String geri = input.next().toUpperCase();
                    if (geri.equals("Q")) {
                        break;
                    }else {
                        System.out.println("Geçersiz karakter , tekrar dene !");
                    }
                }
            }
        }
        return true;
    }
}
class UnderGround_Hospital extends Location{

    public UnderGround_Hospital(Player player) {
        super(player,"Yeraltı Hastanesi");
    }

    @Override
    public boolean onLocatin() {
        while(true) {

            System.out.println("0 - Geri dön");
            System.out.println("1 - İyileş (100 dinar)");
            System.out.println("2 - Ralphi Bul !");
            int choose = input.nextInt();
            if (choose == 0){
                break;
            }else if(choose == 1){
                getPlayer().setMoney(getPlayer().getMoney()-100);
                getPlayer().setHealth(getPlayer().getMax_health());
                System.out.println("Mevcut Sağlık : "+getPlayer().getHealth());
            }else if(choose == 2){
                System.out.println("DOKTOR RALPH: Kime bakmıştın genç adam.\n" +
                        "\n" +
                        "OMERON: Sana bakmıştım Ralph. Sana Arthur'un selamını getirdim.");
                System.out.println("Devam etmek için (D) ye bas !");
                String devam = input.next().toUpperCase();
                if (devam.equals("D")) {
                    System.out.println("DOKTOR RALPH: Büyük deneylerimizden haberdarsın demek. Zavallı Arthur. Bedeni mutasyonu kaldıramadı. Ne kadar denesem de geri döndüremedim. Yeni kurulacak düzene olan güvenin sarsılmaması için Arthur'u ve Arthur gibilerini gözlerden uzak bir yerde tutmalıydık.\n" +
                            "\n" +
                            "OMERON: Şu yeni düzen... Bana ondan bahset.\n");
                    System.out.println("Devam etmek için (D) ye bas !");
                    String devam1 = input.next().toUpperCase();
                    if (devam1.equals("D")) {
                        System.out.println("DOKTOR RALPH: Büyük deneylerimizden haberdarsın demek. Zavallı Arthur. Bedeni mutasyonu kaldıramadı. Ne kadar denesem de geri döndüremedim. Yeni kurulacak düzene olan güvenin sarsılmaması için Arthur'u ve Arthur gibilerini gözlerden uzak bir yerde tutmalıydık.\n" +
                                "\n" +
                                "OMERON: Şu yeni düzen... Bana ondan bahset.\n");
                        System.out.println("Devam etmek için (D) ye bas !");
                        String devam2 = input.next().toUpperCase();
                        if (devam2.equals("D")) {
                            System.out.println("DOKTOR RALPH: Yenilmez bir ordu. Kimse önümüzde duramayacak. Baron Vigo'nun ve benim önderliğimde tüm kıtaya hükmedecek üstün bir ırk. \n" +
                                    "\n" +
                                    "OMERON: Arthur gibi kaç tane başarısız denek var ?\n");
                            System.out.println("Devam etmek için (D) ye bas !");
                            String devam3 = input.next().toUpperCase();
                            if (devam3.equals("D")) {
                                System.out.println("DOKTOR RALPH: Her beş tanede dört tane başarısız çıkar. Her beş insana karşılık bir üstün varlık. Başarısız olanlar çok yaşamaz, yaşama tutunmaları için çok güçlü bir panzehire ihtiyaç duyarlar. Yalnızca iki adet panzehir var birisi benim, diğeri dostum Vigo için. Arthur bir istisnaydı. \n" +
                                        "\n" +
                                        "OMERON: Beş taneye karşılık bir mi ! Bu delilik. İnsanlar oran bu kadar düşükken denek olmayı nasıl kabul ediyorlar ?\n");

                                System.out.println("Devam etmek için (D) ye bas !");
                                String devam4 = input.next().toUpperCase();
                                if (devam4.equals("D")) {
                                    System.out.println("DOKTOR RALPH: İşte bu yüzden Arthur ve Arthur gibileri göz önünde değil. Fakat ürettiğim üstün Grandeller göz önünde bulunup halkı kendine hayran bırakıyor. En çok da çaresiz insanları... Ben onların umuduyum.\n" +
                                            "\n" +
                                            "OMERON: Sen kafayı yemişsin Ralph. Arthur'a bir söz verdim. Ona yardım edeceğim. Bana panzehirlerden bir tanesini ver yoksa seni öldürürüm. Beni buna mecbur bıraktın.\n");
                                    System.out.println("Devam etmek için (D) ye bas !");
                                    String devam5 = input.next().toUpperCase();
                                    if (devam5.equals("D")) {
                                        System.out.println("DOKTOR RALPH: Delirdin mi sen ! Vigo seni öldürür. Hey ! Sana diyorum. Yaklaşma bana.\n" +
                                                "\n" +
                                                "OMERON: Panzehir Ralph... Bana onu ver.\n" +
                                                "\n" +
                                                "DOKTOR RALPRH: Lanet olsun sana. Al. Hesabını soracağım.\n");
                                        System.out.println("+ PANZEHİR");
                                        getPlayer().getInventory().getAwardsList().add(Awards.getAwardObjByName("Panzehir"));
                                        System.out.println("Geri dönmek için Q ya bas !");
                                        while (true) {
                                            String geri = input.next().toUpperCase();
                                            if (geri.equals("Q")) {
                                                break;
                                            } else {
                                                System.out.println("Geçersiz karakter ,tekrar dene !");
                                            }
                                        }
                                    }
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
class Awesome_Palace extends Location{

    public Awesome_Palace(Player player) {
        super(player, "Görkemli Saray");
    }

    @Override
    public boolean onLocatin() {
        System.out.println("0 - Geri");
        System.out.println("1 - Salon");
        if(getPlayer().isKitchen_flag()){
            System.out.println("2 - Mutfak");
        }
        int selection = input.nextInt();
        if (selection == 1) {
            Saloon_two();
        } else if (selection == 2) {
            Kitchen();
        } else {
            System.out.println("Geçersiz karakter , tekrar dene !");
        }
        return true;
    }
    static void Saloon_two(){
            System.out.println("Baron vigo ile konuşmak için E ' ye bas !");
            String talk = input.next().toUpperCase();
            if(talk.equals("E")){
                System.out.println("BARON VİGO WARSTEL: Hoşgeldin meşhur Anemonlu. Hakkındaki iyi söylemler çığ gibi büyüyor. Elinden kurtulan düşmanlar adeta \nbir şimşek gibi kılıç çarpıştırdığını anlatıyor.Seninle tanışmak ne büyük şeref!\n" +
                        "\n" +
                        "OMERON: Elimden kurtulan olduysa bilmeli ki şanssız günümdeydim. Memnun oldum Baron Warstel.\n");
                System.out.println("(D) ye bas !/(Q)=>Çıkış");
                String devam = input.next().toUpperCase();
                if (devam.equals("D")) {
                    System.out.println("BARON VİGO WARSTEL: Bu kendinden emin tavırlar, Bu üstün kılıç savurma... Bana birini hatırlatıyor. Astor...\nEminim ki sevgili baban da Astor gibi yüce bir askerdir. Aslan yürekli Astor, O gittikten sonra hiçbir şey eskisi gibi olmadı.\nÇapulcular başımıza lord kesildi. Rakip olarak gördüklerini bir bir kapı dışına attılar.\nWarstel'ler ıskarta edildi. Soyum yüzyıllardır krallığımıza hizmet etmekteydi. Her şeyi kabul edebilirim ama Warstel soyadının yere düşmesini kaldıramam.\nBu oyuğa tıkılmamızda parmağı olan herkesten bir bir intikamımı alacağım.\n" +
                            "\n" +
                            "OMERON: Övgüleriniz beni onurlandırdı. Astor... Ona güvenir miydiniz?\n");
                    System.out.println("(D) ye bas !/(Q)=>Çıkış");
                    String devam2 = input.next().toUpperCase();
                    if (devam2.equals("D")) {
                        System.out.println("BARON VİGO WARSTEL: Bu kendinden emin tavırlar, Bu üstün kılıç savurma... Bana birini hatırlatıyor. Astor...\nEminim ki sevgili baban da Astor gibi yüce bir askerdir.\nAslan yürekli Astor, O gittikten sonra hiçbir şey eskisi gibi olmadı. Çapulcular başımıza lord kesildi.\nRakip olarak gördüklerini bir bir kapı dışına attılar. Warstel'ler ıskarta edildi.\nSoyum yüzyıllardır krallığımıza hizmet etmekteydi. Her şeyi kabul edebilirim ama Warstel soyadının yere düşmesini kaldıramam.\nBu oyuğa tıkılmamızda parmağı olan herkesten bir bir intikamımı alacağım.\n" +
                                "\n" +
                                "OMERON: Övgüleriniz beni onurlandırdı. Astor... Ona güvenir miydiniz?\n");
                        System.out.println("(D) ye bas !/(Q)=>Çıkış");
                        String devam3 = input.next().toUpperCase();
                        if (devam3.equals("D")) {
                            System.out.println("BARON VİGO WARSTEL: Astor topraklarımızın birleştirici gücüydü. Hiçbir ırkı ayırt etmeksizin hepsinin lideri olmaya gönül vermişti.\nSoylu kanına rağmen Warstel soyadını kendi hakimiyetine rakip olarak görmemiş, saygı ile yaklaşarak gönüllerimize girmişti.\nDiyarların kralı sıfatına en layık aday o idi. Onu kaybettiğimizde biz de bittik.\nLord Mazzaroth tehtit olarak gördüklerini, krallığın güç kaybetmesi pahasına yok etmeye başladı.\nOna kalmamalı evlat... Krallık ona kalmamalı.\n" +
                                    "\n" +
                                    "\n" +
                                    "OMERON: Bunun için ne yapmayı planlıyorsunuz Baron Warstel. Davalarımız benzer, birbirimize yardımda bulunabiliriz. \n");
                            System.out.println("(D) ye bas !/(Q)=>Çıkış");
                            String devam4 = input.next().toUpperCase();
                            if (devam4.equals("D")) {
                                System.out.println("BARON VİGO WARSTEL: Deneylerimizden haberdar olduğunu varsayıyorum. Dönüşüm için kullandığımız kaynakları arttırıp başarı şansını ne kadar yükseğe taşırsak, işte o zaman kazanırız.\nSana gelince, iyi bir savaşçı olabilirsin Anemonlu dostum ancak bu büyük bir olay.\nElflere yapılan zulümlere başkaldıracak kadar yürekli olman güzel ancak tek başınasın, Eğer kaybedersen kaybolmuş bir ırkın kaybedeni yine sen olacaksın.\nBen ise düzene karşı koyabilecek güce sahip tek kişiyim. Ben kaybedersem herkes kaybedecek.\nSadece kişisel düşünme. Seni davama dahil etmeyece...\n" +
                                        "\n" +
                                        "OMERON: Ben Lord Astor'un oğlu Anemonlu Omeron. Bu herkesten çok benim davam. Sayın Warstel, beni yanınızda istemiyorsanız bunu kabul ederim ancak sakın karşıma çıkayım demeyin.\n");
                                System.out.println("(D) ye bas !/(Q)=>Çıkış");
                                String devam5 = input.next().toUpperCase();
                                if (devam5.equals("D")) {
                                    System.out.println("BARON VİGO WARSTEL: Yüce Tanrım... Astor'un oğlu... Tahmin etmeliydim. Öldüğünü zannediyorduk.\nTanrı bize ikinci bir şans verdi. Bilmeden konuştum. Lütfen saygısızlığımı bağışla.\nDavanda, ben ve silah arkadaşlarımız sonuna kadar arkandayız, Tüm bunların üstesinden gelebiliriz.\n" +
                                            "\n" +
                                            "OMERON: İyiliğinizi karşılıksız istemiyorum Baron Warstel. Deney elimizi güçlendirecek. Bundan eminim.\nDeneyler insan hayatını tehlikeye atmayacaksa gerekli tüm kaynakları sağlayacağım.\nBuna karşılık beni krala götüreceksiniz ve kralın ordusuna karşı aynı safta yer alacağız.\nBen intikamımı alacağım. Siz de Warstel soyadını tekrardan yukarı taşıyacaksınız.\nSimdi bana söyleyin, Elimizi güçlendirecek kaynağa nereden ulaşacağım.\n");
                                    System.out.println("(D) ye bas !/(Q)=>Çıkış");
                                    String devam6 = input.next().toUpperCase();
                                    if (devam6.equals("D")) {
                                        System.out.println("BARON VİGO WARSTEL: Elf Lideri Omeron, Yaşlı kurtun elferin elini güçlendirmek için adada birtakım çalışmalar yürüttüğü kulağıma gelmişti.\nKral Aesir kehanet uğruna elflerin silahını onlara karşı kullandı. Çok güçlü bir enerji kaynağı olmalı ki bütün adayı yerle bir etti.\nBize o gerek. Tüm düğümleri çözücek o kaynak.\n" +
                                                "\n" +
                                                "OMERON: Onu sana getireceğim. Hangi ada bu?\n");
                                        System.out.println("(D) ye bas !/(Q)=>Çıkış");
                                        String devam7 = input.next().toUpperCase();
                                        if (devam7.equals("D")) {
                                            System.out.println("BARON VİGO WARSTEL: Sisler adası. Oraya ulaşmak için bir tekneye ihtiyacın var ve dikkat et Omeron.\nSon olan olaylardan sonra adanın başkalaştığı söyleniyor.\n" +
                                                    "\n" +
                                                    "OMERON: Benim için kaygılanma Warstel.\n" +
                                                    "\n");
                                            System.out.println("(Q) => Çıkış");
                                            while (true) {
                                                String quit = input.next().toUpperCase();
                                                if (quit.equals("Q")) {
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
    }
    public void Kitchen(){
        System.out.println("OMERON: Selam sevgili dostum, sen Aden olmalısın.\n" +
                "\n" +
                "ADEN: Evet. Sen kimsin, neden beni arıyorsun ?\n");
        System.out.println("(D) ye bas !");
        String devam = input.next().toUpperCase();
        if (devam.equals("D")) {
            System.out.println("OMERON: Adım Omeron. Anemonluyum. Sana gelmeden önce likörhaneye uğradım.\n" +
                    "\n" +
                    "ADEN: Ah! Lanet olsun. Lütfen seni abim olacak yaratığın gönderdiğini söyleme bana. Çık dışarı!\n");
            System.out.println("(D) ye bas !");
            String devam2 = input.next().toUpperCase();
            if(devam2.equals("D")){
                System.out.println("OMERON: Aden dinle beni. Hasta olduğunu duydum. Abin senin dönüşmeni istiyor. Bu senin için bir kurtuluş olabilir.\n" +
                        "\n" +
                        "ADEN: Sen kim oluyorsun da benim hastalığım hakkında konuşabiliyorsun! Her şey abim yüzünden. Bir anlık sinirle hayatımızı mahvetti. Ailemizi kaybettikten sonra sokaklarda kaldık. Kimseye sığınamadık, Kimse de bizi yanına istemedi. Kim bir katilin çocuklarını yanında ister ki. Sokaklarda geçirdiğimiz onca yılda bela hiçbir zaman abimin yakasından düşmedi. En sonunda babamın izinden gidip, suçsuz bir insanı öldürdü. İdam edilecekti, abimi ilk kez o zaman kaybetmiştim. Üzüntümden hasta oldum. Vigo bana sahip çıktı.\n");
                System.out.println("(D) ye bas !");
                String devam3 = input.next().toUpperCase();
                if(devam3.equals("D")){
                    System.out.println("OMERON: Abin sert bir ucube olabilir ama sandığın gibi duygusuz falan değil Aden. Senin için çok endişeleniyor ve emin ol yaptıklarından dolayı çok pişman. İkinci bir şansın olsun istiyor.\n" +
                            "\n" +
                            "ADEN: Hayır dostum... Sonuç hüsran olsa da bu sefer kendi kararlarımı kendim vereceğim. O da bir ömür boyu yeni bedenin de kardeşini kendi hataları yüzünden kaybetmenin yükünü taşıyacak.");
                    System.out.println("(D) ye bas !");
                    String devam4 = input.next().toUpperCase();
                    if(devam4.equals("D")){
                        System.out.println("OMERON: Peki Aden. Kararına saygı duyuyorum.\n" +
                                "\n" +
                                "ADEN: Bu parayı al ve bir daha gözüme gözükme Anemonlu dostum. Tek isteğim kalan günlerimi huzur içinde geçirmek.");
                        System.out.println("+ 100 DİNAR");
                        getPlayer().setMoney(getPlayer().getMoney()+100);
                        getPlayer().setKitchen_flag(false);
                        System.out.println("(Q) => Çıkış");
                        while(true) {
                            String quit = input.next().toUpperCase();
                            if(quit.equals("Q")){
                                break;
                            }
                        }
                    }

                }

                }
        }
    }
}
class Dark_Garden extends BattleLoc{

    public Dark_Garden(Player player) {
        super(player,"Karanlık Bostan",new Grandel(),"Grandel Kafası",0,true);
    }

}
class Grandel extends Enemy{

    public Grandel() {
        super(20,"Asi Grandel", 80, 120, "Ekmek", 0);
    }
}
class Arena extends BattleLoc{

    public Arena(Player player) {
        super(player,"Arena",new Zavura(),"Elma",0, true);
    }
}
class Zavura extends Enemy{

    public Zavura() {
        super(15,"Zavura",50,100,"Ekmek",0);
    }
}
class LiquourHouse_of_Jerry extends Location{

    public LiquourHouse_of_Jerry(Player player) {
        super(player,"Jerry'nin Likörhanesi");
    }

    @Override
    public boolean onLocatin() {
        while (true) {
            System.out.println(" 0-  Geri");
            System.out.println(" 1 - Barmen Jerry");
            System.out.println(" 2 - Grandel Carno");
            System.out.println(" 3 - Graham Vidic");
            int selection = input.nextInt();
            if(selection==1){
                BarmenJerry();
            }else if(selection == 2){
                GrandelCarno();
            }else if(selection == 3){
                GrahamVidic();
            }else if(selection==0){
                break;
            }else{
                System.out.println("Geçersiz karakter, tekrar dene !");
            }
        }
        return true;
    }
    void BarmenJerry(){
        if(getPlayer().getInventory().searchLetter(4)==null) {
            System.out.println("OMERON: Bir kadeh likör... En ucuzundan...\n" +
                    "\n" +
                    "BARMEN JERRY: İşte likörün dostum. Benden olsun Anemonlu.\n" +
                    "\n");
            System.out.println("(D) ye bas");
            String devam = input.next().toUpperCase();
            if (devam.equals("D")) {
                System.out.println("OMERON: Neden dik dik bakıyorsun ihtiyar.\n" +
                        "\n" +
                        "BARMEN JERRY: Kimsin sen böyle?");
                System.out.println("(D) ye bas");
                String devam1 = input.next().toUpperCase();
                if (devam1.equals("D")) {
                    System.out.println("OMERON: Sıradan biriyim. Likör için teşekkürler. Güle g...\n" +
                            "\n" +
                            "BARMEN JERRY: Bırak bu işleri. Sıradan birine bizzat Lord Mazzaroth tarafından mühürlenmiş bir mektup bırakıldığı nerede görülmüş!");
                    System.out.println("(D) ye bas");
                    String devam2 = input.next().toUpperCase();
                    if (devam2.equals("D")) {
                        System.out.println("OMERON: Beğendiysen sende kalabilir ihtiyar.\n" +
                                "\n" +
                                "BARMEN JERRY: Şaka mı yapıyorsun sen? Başıma bela istemiyorum. Al şu lanet mektubu ve bir an önce kaybol burdan.\n");
                        System.out.println("+ Lordun Mektubu");
                        this.getPlayer().getInventory().getLettersList().add(Letters.getLetterObjById(4));
                    }
                }
            }
        }else{
            System.out.println("Tamamlanmış görev");
        }
    }
    public void GrandelCarno(){
        System.out.println("OMERON: Üstün ırk ? Daha önce hiç bir grandel ile konuşmamıştım. Konuşabiliyor musunuz ?\n" +
                "\n" +
                "GRANDEL CARNO: Hakkımızda hiç bir şey bilmediğin boş bakışlarından anlaşılıyor. Kaybol!");
        System.out.println("(D) ye bas");
        String devam = input.next().toUpperCase();
        if(devam.equals("D")){
            System.out.println("OMERON: Ralph sana ne vadetti ?\n" +
                    "\n" +
                    "GRANDEL CARNO: Üstat Ralph'in adını ağzına dolarken 2 kez düşün. Üstat Ralph hayal satmaz. Baron Vigo beni ebedi ateşin avucundan aldı.\nİdamını bekleyen bir mahkumdan yüce bir askere. Eskiden iğrenerek bakanlar artık imrenerek bakıyor.\nŞu etrafına bir bak, hepsi birer zavallıdan ibaret. İnat etmezler ise hepsinin damarlarında yüce grandel kanı dolaşacak.\n");
            System.out.println("(D) ye bas");
            String devam1 = input.next().toUpperCase();
            if(devam1.equals("D")) {
                System.out.println("OMERON: Başarı şansı çok düşük. Aklı olan kendini ateşe atmaz.\n" +
                        "\n" +
                        "GRANDEL CARNO: Başka çaresi olmayanlar başarısızlığa değil, başarıya odaklanacaktır. İnan bana kurtuluş şansım canlı canlı yakılarak idam edilecek olmamdan bir hayli yüksekti. ikinci bir hayat elde etmiş olmak bizim gibilerin en büyük şansı.\n" +
                        "\n" +
                        "OMERON: Peki dostum. Sana güzel günler dilerim. Güle G...\n" +
                        "\n" +
                        "GRANDEL CARNO: Dur! Her ne kadar iyi anlaşamamış olsak da sana bir konuda ihtiyacım olabilir.\n");
                System.out.println("(D) ye bas");
                String devam2 = input.next().toUpperCase();
                if (devam2.equals("D")) {
                    System.out.println("OMERON: Vay be ne büyük şeref. Bir grandel bile birine ihtiyaç duyabiliyor. \n" +
                            "\n" +
                            "GRANDEL CARNO: Ukalalık etme. Kardeşim Aden... Çok hasta, az zamanı kaldı. Onun için çok endişeleniyorum. Ne kadar dil döksem de mutasyona ikna edemedim. Tek şansı mutajenler. Yoksa ailemden bana kalan tek emaneti kaybedeceğim.\n");
                    System.out.println("(D) ye bas");
                    String devam3 = input.next().toUpperCase();
                    if (devam3.equals("D")) {
                        System.out.println("OMERON: Onu ikna etmemi mi istiyorsun. Dostum bunu sen yapmalısın. Hala zamanın varken neden ona koşmuyorsun.\n" +
                                "\n" +
                                "GRANDEL CARNO: Yapamam. Dönüştüğüm günden beri yüzüme bakmıyor. Ayrıca Baron Vigo'ya karşı gelemem bir aydır burada görevliyim, halkın grandellere alışması için burada yatıp burada kalkıyorum. Lütfen bunu benim için yap. Onu Baron Vigo'nun yanında bulabilirsin. Kendisi bir aşçı.\n" +
                                "\n" +
                                "OMERON: Peki, şansımı deneyeceğim.\n");
                        getPlayer().setKitchen_flag(true);
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
    public void GrahamVidic(){
        if(!getPlayer().isVidic_task_flag()) {
            if (getPlayer().getInventory().searchAward("Grandel Kafası") == null) {
                System.out.println("GRAHAM VİDİC: Hey! Genç efendi buraya bakın lütfen.\n" +
                        "\n" +
                        "OMERON: Buyrun bayım. Bana mı seslendiniz?");
                System.out.println("(D) ye bas");
                String devam = input.next().toUpperCase();
                if (devam.equals("D")) {
                    System.out.println("GRAHAM VİDİC: Evet. Namınız kulaktan kulağa yayılıyor. Anemonlu savaşçının adını duyunca insanların korkudan kanı çekiliyor. Bana yardım etmelisin Anemonlu. \n" +
                            "\n" +
                            "OMERON: Sıkıntınız nedir ?");
                    System.out.println("(D) ye bas");
                    String devam1 = input.next().toUpperCase();
                    if (devam1.equals("D")) {
                        System.out.println("GRAHAM VİDİC: Benim adım Graham Vidic. Saron kentine bir banka işletirdim. Sevgili babam ise bir bostancıydı. Ölmeden önce bana küçük bir bostan emanet etti. Ben de işlerimi kıymetli evladıma bıraktım ve bostanda yaşayıp, onun işini yapıp onun hatırasını yaşatıyordum. Ta ki lanet olası bir grandel gelip beni evimden edene denk. Bostanımıza göz dikmiş, aylardır babamın ölmesini bekliyormuş. Ancak ben bostana yerleşince bütün planlarını altüst ettim.\n" +
                                "\n" +
                                "OMERON: Onu oradan çıkarmamı mı istiyorsunuz bayım ?");
                        System.out.println("(D) ye bas");
                        String devam2 = input.next().toUpperCase();
                        if (devam2.equals("D")) {
                            System.out.println("GRAHAM VİDİC: Ben bu işlerle başa çıkamayacak kadar yaşlıyım özellikle de bir grandel ile. Çok güçlüler, bir tanesi bile bir düzine cüceyi yerle bir edebilir.\n" +
                                    "\n" +
                                    "OMERON: Peki Bay Graham, sizin için babanızın hatırasını kurtaracağım. Peki bu işten benim kazancım ne olacak ?\n");
                            System.out.println("(D) ye bas");
                            String devam3 = input.next().toUpperCase();
                            if (devam3.equals("D")) {
                                System.out.println("GRAHAM VİDİC: Graham Vidic hiçbir iyiliği karşılıksız bırakmamış, bırakmayacaktır. Yolun elbet Saron kentine düşecektir, işte o zaman sevgili oğlumun yanına uğra ve 2 kraliyet altınını al. Bana o grandelin kafasını getirdiğinde sana bu işlemi gerçekleştirmen için bir Vidic mühürüne sahip bir mektup vereceğim. Kılıcın keskin olsun Anemonlu.\n");
                                getPlayer().setDark_Garden_Visibility_flag(true);
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
            } else {

                System.out.println("OMERON: Grandel'in işini bitirdim bay Graham.\n" +
                        "\n" +
                        "GRAHAM VİDİC: İşte herkesin dilindeki meşhur savaşçı. Sana minnettarım Anemonlu. İşte mektubun, tek yapman gereken oğlumun yanına uğramak. Kendisini Saron kentindeki Vidic bankasında bulabilirsin. Ona selamımı ilet.\n" +
                        "\n" +
                        "\n" +
                        "+VİDİC'İN MEKTUBU\n" +
                        "\n" +
                        "\n" +
                        "+GRAHAM VİDİC KARANLIK BOSTANA YERLEŞİR.\n");
                this.getPlayer().getInventory().getLettersList().add(Letters.getLetterObjById(5));
                this.getPlayer().setVidic_task_flag(true);
                System.out.println("Geri => (Q)");
                while (true) {
                    String geri = input.next().toUpperCase();
                    if (geri.equals("Q")) {
                        break;
                    }
                }


            }
        }else{
            System.out.println("Tamamlanmış Görev");
        }
    }
}
class Saron_Town extends Location{

    public Saron_Town(Player player) {
        super(player,"Saron Kasabası");
    }

    @Override
    public boolean onLocatin() {
        while (true) {
            System.out.println(" 0-  Geri");
            System.out.println(" 1 - Kasaba Merkezi");
            System.out.println(" 2 - Altın Köprüye İlerle");
            System.out.println(" 3 - Envanteri Görüntüle");
            int selection = input.nextInt();
            Location location = null;
            Player player = getPlayer();
            switch (selection) {
                case 0:
                    location = new Quit(player);
                    return true;
                case 1:
                    location = new Down_Town(player);
                    break;
                case 2:
                    location = new Move_toGoldenBridge(player);
                    break;
                case 3:
                    location = new GoInventory(player);
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
class Down_Town extends Location{

    public Down_Town(Player player) {
        super(player,"Kasaba Merkezi");
    }

    @Override
    public boolean onLocatin() {
        while (true) {
            System.out.println(" 0-  Geri");
            System.out.println(" 1 - Kasaba Merkezi");
            System.out.println(" 2 - Altın Köprüye İlerle");
            System.out.println(" 3 - Envanteri Görüntüle");
            int selection = input.nextInt();
            Location location = null;
            Player player = getPlayer();
            switch (selection) {
                case 0:
                    location = new Quit(player);
                    return true;
                case 1:
                    location = new Down_Town(player);
                    break;
                case 2:
                    location = new Move_toGoldenBridge(player);
                    break;
                case 3:
                    location = new GoInventory(player);
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
class Move_toGoldenBridge extends Location{

    public Move_toGoldenBridge(Player player) {
        super(player, "Altın Köprü");
    }

    @Override
    public boolean onLocatin() {
        while (true) {
            System.out.println(" 0-  Geri");
            System.out.println(" 1 - Nehir Kıyısına in");
            System.out.println(" 2 - Karşıya geç");
            int selection = input.nextInt();
            Location location = null;
            Player player = getPlayer();
            switch (selection) {
                case 0:
                    location = new Quit(player);
                    return true;
                case 1:
                    location = new NearOfRiver(player);
                    break;
                case 2:
                    location = new CrossTheRoad(player);
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
class NearOfRiver extends  BattleLoc{

    public NearOfRiver(Player player) {
        super(player,"Nehrin Kıyısı",new RiverMonster(),"Canavar Solungaçları",0,true);
    }

}
class RiverMonster extends  Enemy {
    public RiverMonster() {
        super(30, "Nehir Canavarı", 150,200,"Canavarın Elmas Kalbi", 0);
    }
}
class CrossTheRoad extends Location{
    public CrossTheRoad(Player player) {
        super(player,"Nehrin Karşısı");
    }

    @Override
    public boolean onLocatin() {
        while (true) {
            System.out.println(" 0-  Geri");
            System.out.println(" 1 - Saron Zindanı");
            System.out.println(" 2 - Orgenin Arenası");
            int selection = input.nextInt();
            Location location = null;
            Player player = getPlayer();
            switch (selection) {
                case 0:
                    location = new Quit(player);
                    return true;
                case 1:
                    location = new Prison_of_Saron(player);
                    break;
                case 2:
                    location = new ArenaOfOrge(player);
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

class ArenaOfOrge extends Location{
    public ArenaOfOrge(Player player) {
        super(player,"Orgenin Arenası");
    }

    @Override
    public boolean onLocatin() {
        while (true) {
            System.out.println(" 0-  Geri");
            System.out.println(" 1 - Savaş Alanı ");
            System.out.println(" 2 - Sahibin Kulübesi");
            System.out.println(" 3 - Envanteri görüntüle");
            int selection = input.nextInt();
            Location location = null;
            Player player = getPlayer();
            switch (selection) {
                case 0:
                    location = new Quit(player);
                    return true;
                case 1:
                  location = new BattleArea(player);
                    break;
                case 2:
                    location = new HutofOwner(player);
                    break;
                case 3:
                   location = new GoInventory(player);
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
class BattleArea extends BattleLoc{
    public BattleArea(Player player) {
        super(player,"Savaş Alanı", new IronFist(),"Elma", 0, true);
    }
}
class IronFist extends Enemy{
    public IronFist() {
        super(45, "Demir Yumruk",150, 200, "Demir Eldivenler", 0);
    }
}

class HutofOwner extends BattleLoc {

    public HutofOwner(Player player) {
        super(player, "Patronun Kulubesi", new Boss(), "Ekmek", 30, true);
    }

    @Override
    public boolean onLocatin() {
        System.out.println("PATRON ORGE: Sen de kimsin lan böyle! Güm diye içeri giriyorsun.\n" +
                "\n" +
                "OMERON: Hancıyla olan gerginliğini duydum. Adamın kazanmasını kaldıramayıp hır çıkarmışsın.\n" +
                "\n" +
                "PATRON ORGE: Sen kimsin beni sorguluyorsun? Hile yapıyordu gerekeni yaptım. Burda durmaya devam edersen sana da gerekeni yapacağım.\n" +
                "\n" +
                "OMERON: Elini korkak alıştırma patron.\n" +
                "\n" +
                "PATRON ORGE: Bittin sen!\n" +
                "\n" +
                "\n" +
                "\n");
        playerStats();
        enemyStats(1);
        System.out.println("\nSAVAŞ/KAÇ\n");
        while (true) {
            String choose = input.next().toUpperCase();
            if (choose.equals("S")) {
                BattleSimulation battleSimulation = new BattleSimulation();
                battleSimulation.startSimulation();
                if (combat(1)) {
                    this.getPlayer().getInventory().getAwardsList().add(Awards.getAwardObjByName("Hancının Köstekli Saati"));
                    if (getPlayer().getInventory().searchAward("Hancının Köstekli Saati") != null) {
                        System.out.println("\n+ Hancının Köstekli Saati");
                        System.out.println("\n (Q)=>Geri");
                        while (true) {
                            String geri = input.next().toUpperCase();
                            if (geri.equals("Q")) {
                                break;
                            } else {
                                System.out.println("Geçersiz karakter , tekrar dene !");
                            }
                        }
                        break;
                    }
                } else {
                        System.out.println("Öldünüz,Oyun Bitti... ");
                        System.exit(0);
                    }
                } else if (choose.equals("K")) {
                    return true;
                } else {
                    System.out.println("Geçersiz karakter , tekrar dene");
                }
            }
        return true;
    }
    }

    class Boss extends Enemy {

        public Boss() {
            super(40, "Patron Orge", 50, 70, "Elma", 30);
        }
    }

    class Prison_of_Saron extends Location {
        public Prison_of_Saron(Player player) {
            super(player, "Saron Hapishanesi");
        }

        @Override
        public boolean onLocatin() {
            Location location = null;
            Player player = getPlayer();
            while (true) {
                System.out.println("0 - Geri dön");
                if(!getPlayer().isSaron_prison_flag()){
                    System.out.println("1 - Zindana Gir !");
                }
                if(getPlayer().isSaron_prison_flag()){
                    System.out.println("2 - Üst Kata Çık");
                }
                int selection = input.nextInt();

                switch (selection) {
                    case 0:
                        location = new Quit(player);
                        return true;
                    case 1:
                        location = new SaronPrison(player);
                        break;
                    case 2:
                        location = new Upstairs(player);
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
class Upstairs extends Location {

    public Upstairs(Player player) {
        super(player, "Üst Kat");
    }

    @Override
    public boolean onLocatin() {
        System.out.println("USTA NÖRT: Gözlerime inanamıyorum. Omeron kurtar beni. Bu manyaklar beni canlı canlı yakacak.\n" +
                "\n" +
                "OMERON: Usta Nört... Nasıl düştünüz siz buraya ? \n");
        System.out.println("(D) ye bas !");
        String devam = input.next().toUpperCase();
        if (devam.equals("D")) {
            System.out.println("USTA NÖRT: Bir kervanla seyahat ediyordum. Bir avuç haydut kervana saldırmaya kalktı.\nKervan başı kaçışını sağlamak amacıyla bizi haydutlara yem etti. Yaşlıyım Omeron, eskisi kadar çevik değilim, \nneskiden olsa hepsini kılıçtan geçirirdim. Neyse işte beni ve birkaç kişiyi esir olarak aldılar. \nElf olduğumu anladıkları zaman gözleri parladı. İnsanlar elflerin canlı canlı yakılmasına bayılıyor. \nBeni bir eşya gibi sattılar. Burada ölümü bekliyordum.\n" +
                    "\n" +
                    "OMERON: Hepsi bitti Usta Nört. Sizi kurtaracağım. Macera aramayın. Lütfen doğrudan kıyı bölgesine gidin.\n");
            System.out.println("(D) ye bas !");
            String devam1 = input.next().toUpperCase();
            if (devam1.equals("D")) {
                System.out.println("USTA NÖRT: Sen gelmiyor musun Omeron?\n" +
                        "\n" +
                        "OMERON: Sisler adasına gideceğim. Yapmam gereken işler var.\n");
                System.out.println("(D) ye bas !");
                String devam2 = input.next().toUpperCase();
                if (devam2.equals("D")) {
                    System.out.println("USTA NÖRT: Sisler Adası mı ? Omeron orada dikkatli ol. Ada, eskiden gözden uzak sakin bir yerdi.\nÇalışmalar için uygundu. Sevgili deden adaya bayılırdı. Ancak aynı şeyleri adanın şuan ki durumu için söyleyemeyeceğim. \n" +
                            "\n" +
                            "OMERON: Adaya en son ne zaman gittiniz Üstat Nört?\n");
                    System.out.println("(D) ye bas !");
                    String devam3 = input.next().toUpperCase();
                    if (devam3.equals("D")) {
                        System.out.println("USTA NÖRT: Adadan kaçmayı başarabilen iki kişi bize durumu anlattı. Biz de çalışmalarımızı kurtarmak ve dostlarımızın hatırasını yaşatmak için toplanıp oraya gittik. \nÇalışmalarımız bütünüyle yok olmuştu. Bir hiç uğruna kaybettiğimiz bütün dostlarımızı gömdük ve onlar için bir anıt diktik. \nKabus Anıtı, bizler için durum kabustan farksızdı.  Ada binlerce elfin mezarı olmuştu ve onların kanıyla lanetlenmişti. \nHer daim tetikte ol, kolay bir yolculuk olmayacak. Kılıcın keskin olsun.\n" +
                                "\n" +
                                "OMERON: Teşekkür ederim Üstat Nört.\n");
                        System.out.println("DİYOLOGTAN SONRA ÜSTAT NÖRT KIYI BÖLGESİNDEKİ KAMP ALANINA GİDER.");

                    }
                    return true;
                }

            }
        }

        return false;
    }
}
class SaronGuard extends Enemy{

    public SaronGuard() {
        super(35, "Saron Gardiyanı", 30, 50, "Paslı Anahtarı", 50);
    }
}

class SaronPrison extends BattleLoc {

    public SaronPrison(Player player) {
        super(player, "Saron Zindanı", new SaronGuard(), "Tahıl", 0, true);
    }

    @Override
    public boolean onLocatin() {
        System.out.println("OMERON: Merhaba dostum. İçeriye bir göz atmak istiyorum.\n" +
                "\n" +
                "ZİNDAN GARDİYANI: İçeride yaşlı bir elften başka kimse yok. Kim bir elfi ziyaret etmek ister ki? Yoksa... Kapşonunu indir.\n");
        System.out.println("(D) ye bas");
        String devam = input.next().toUpperCase();
        if (devam.equals("D")) {
            System.out.println("OMERON: Hadi buyur. Neden başımdan hiç bela eksik olmuyor.\n" +
                    "\n" +
                    "ZİNDAN GARDİYANI: İndir! \n" +
                    "\n" +
                    "(OMERON KAPŞONUNU İNDİRİR)\n");
            System.out.println("(D) ye bas");
            String devam1 = input.next().toUpperCase();
            if (devam1.equals("D")) {
                System.out.println("ZİNDAN GARDİYANI: Tahmin etmeliydim. Bedenin ebedi ateşi harlatacak.\n" + "\n");
                playerStats();
                enemyStats(1);
                System.out.println("\nSAVAŞ/KAÇ\n");
                while (true) {
                    String choose = input.next().toUpperCase();
                    if (choose.equals("S")) {
                        BattleSimulation battleSimulation = new BattleSimulation();
                        battleSimulation.startSimulation();
                        if (combat(1)) {
                            this.getPlayer().setSaron_prison_flag(true);
                            this.getPlayer().getInventory().getAwardsList().add(Awards.getAwardObjByName("Paslı Anahtar"));
                            if (getPlayer().getInventory().searchAward("Paslı Anahtar") != null) {
                                System.out.println("\n+ Paslı Anahtar");
                                System.out.println("\n (Q)=>Geri");
                                while (true) {
                                    String geri = input.next().toUpperCase();
                                    if (geri.equals("Q")) {
                                        break;
                                    } else {
                                        System.out.println("Geçersiz karakter , tekrar dene !");
                                    }
                                }
                                break;
                            }
                        } else {
                            System.out.println("Öldünüz,Oyun Bitti... ");
                            System.exit(0);
                        }
                    } else if (choose.equals("K")) {
                        return true;
                    } else {
                        System.out.println("Geçersiz karakter , tekrar dene");
                    }
                }
            }
        }
        return true;
    }
}





