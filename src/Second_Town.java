import javax.tools.Tool;
import java.util.Random;

class Rent_Room extends NormalLoc {

    public Rent_Room(Player player) {
        super(player, "Oda");
    }

    @Override
    public boolean onLocatin() {
        Rented(getPlayer());
        return true;
    }

    public boolean Rented(Player player) {
        Location location = null;
        Quit quit = new Quit(player);

        while (true) {
            System.out.println(" Uyu (1) / Sandık (2) / Çık (3)");
            int secim = input.nextInt();
            switch (secim) {
                case 1:
                    location = new Sleep(player);
                    break;
                case 2:
                    location = new OpentheChest(player);
                    break;
                case 3:
                    location = new Quit(player);
                    return true;
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

class Saloon extends NormalLoc{
    public Saloon(Player player) {
        super(player, "Salon");
    }

    @Override
    public boolean onLocatin() {
        Location location = null;
        Player player = this.getPlayer();
        Quit quit = new Quit(player);

        while(true){
            System.out.println("0 - Geri dön\n");
            System.out.println("1 - Kumarbaz Koch\n");
            System.out.println("2 - Hancı Bay Yegar\n");
            if(!getPlayer().isEnemy_camp7_flag()){
                System.out.println("3 - Cüce Durin\n");
            }

            int secim = input.nextInt();

            switch (secim){
                case 1:
                    kumarbazKoch();
                    location = new Quit(player);
                    break;
                case 3:
                    talkWithDurin();
                    location = new Quit(player);
                    break;
                case 2:
                    talkWithmrYegar();
                    location = new Quit(player);
                    break;
                case 0:
                   location = new Quit(player);
                   return true;
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
    public void kumarbazKoch(){
        if(!getPlayer().isBoat_flag()) {
            System.out.println("Kumarbaz Cüce KOCH: Eğlenmek ister misin sivri kulak ?\n" +
                    "\n" +
                    "OMERON: Bana mı dedin ? Sen kimsin ihtiyar ?\n" +
                    "\n");
            System.out.println("\n\tDevam etmek için (D) ye bas !");
            String continueKey = input.next().toUpperCase();
            if (continueKey.equals("D")) {
                System.out.println("\n" +
                        "Kumarbaz Cüce KOCH: Otur şuraya. Bana Altın Kemik derler. Kemiklerle doğdum kemiklerle ölürüm. Zavallı annem beni doğururken ölmüş.\nBabam bir kumarbazdı ki beni bir kese dinar için bir tüccara sattı. Piç kurusu tüccar, sırf buçukluğum diye beni köpekleriyle aynı kulübede uyuturdu. Özgürlüğümü onunla kemik atarak kazandım.\n" +
                        "\n" +
                        "OMERON: Sonra ne oldu ?");
                System.out.println("\n\tDevam etmek için (D) ye bas !");
                String continueKey1 = input.next().toUpperCase();
                if (continueKey1.equals("D")) {
                    System.out.println("Kumarbaz Cüce KOCH: Haa ha ha... İlgini çekti demek. Babamı yıllar sonra iskelede buldum. Döküntü bir teknede yaşıyordu, çok hastaydı. Yanına yaklaştığımı bile farketmedi. Onun için bir kemik attım ardından onu boğdum. Zavallı adam, yine kaybetmişti.\n" +
                            "\n" +
                            "OMERON: Layığını bulmuş. Şu bahsettiğin kemik, nasıl oynanıyor ?");
                    System.out.println("\n\tDevam etmek için (D) ye bas !");
                    String continueKey2 = input.next().toUpperCase();
                    if (continueKey2.equals("D")) {
                        System.out.println("\n" +
                                "Kumarbaz Cüce KOCH: Kemiğin 2 yüzü vardır sivri kulak. Kömür ile bezenmiş tarafı ölümü, Aydınlık tarafı ise yaşamı temsil eder. Kemik senin kaderindir.\nKader kimine sonsuz aydınlığını sunar kimini de karanlığında boğar. Unutma sivri kulak, Kemik bahtsızları kölesi yapar.\n" +
                                "\n" +
                                "OMERON: 100 dinar... Sana 100 dinar teklif ediyorum. Eğer kazanırsam bana karşılığında ne vereceksin ?\n");
                        System.out.println("\n\tDevam etmek için (D) ye bas !");
                        String continueKey3 = input.next().toUpperCase();
                        if (continueKey3.equals("D")) {
                            System.out.println("Kumarbaz Cüce KOCH: Kendine fazla güveniyorsun sivri kulak. Peki... Eğer kazanırsan sevgili babamın teknesi senindir. 100 dinara karşılık eski ama iş görür bir tekne. Var mısın ?\n" +
                                    "\n" +
                                    "\n");
                            while (true) {
                                System.out.println("////100 dinarlık kemik at (A)------Kaybedersek tekrar tekneyi kazanana kadar//// Geri dön(Q)\n" + "\n");
                                String playBone = input.next().toUpperCase();
                                if (playBone.equals("A")) {
                                    System.out.println("Kumarbaz Cüce KOCH:Seçimini yap !\n 1 - Aydınlık mı ? \n2 - Karanlık mı ?");
                                    Random random = new Random();
                                    int yazi_tura = random.nextInt(1, 3);
                                    int selection = input.nextInt();
                                    if (selection == yazi_tura) {
                                        System.out.println("\n" +
                                                "KOCH: Tekne senindir, çuha ormanındaki iskelede onu bulabilirsin  .\n" +
                                                "\n" +
                                                "\n" +
                                                "(+ Ağaç Çivili Tekne)\n");
                                        getPlayer().setBoat_flag(true);
                                        break;
                                    } else {
                                        getPlayer().setMoney(getPlayer().getMoney() - 100);
                                        System.out.println("Kaybettin, (- 100 dinar)");
                                        break;
                                    }
                                } else if (playBone.equals("Q")) {
                                    break;
                                } else {
                                    System.out.println("Geçersiz karakter , Tekrar dene !");
                                }
                            }
                        }
                    }
                }
            }
        }

    }
    public void talkWithDurin(){
        System.out.println("Cüce DURIN: Sevgili GameChar.Omeron, seni görmek ne büyük şeref. Sayende ömrümün son yıllarını sevdiklerimle geçireceğim. Sana bir hayat borçluyum. \n" +
                "Lütfen hediyemi kabul et, seni her daim evinde hissettirir. Sandığa Toy Limanından ulaşabilirsin. Ömrün uzun olsun. \n" +
                "\n" +
                "+ Taş anahtar ");
        getPlayer().getInventory().getAwardsList().add(Awards.getAwardObjByName("Taş Anahtar"));
        getPlayer().getInventory().setCountAwardList(1,"Taş Anahtar");

    }
    public void talkWithmrYegar(){
        Awards kraliyetSarabi = getPlayer().getInventory().searchAward("Kraliyet Şarabı");
        if(kraliyetSarabi==null && !getPlayer().isYegar_flag()) {
            System.out.println("Hancı Bay YEGAR: Güzel kentimize hoşgeldin genç adam. Umarım keyifli vakit geçiriyorsundur.\n" +
                    "\n" +
                    "OMERON: Her şey yolunda. İçkiler güzel. Daha da iyisi buçukluklar kendimi uzun hissettiriyor.\n" +
                    "\n" +
                    "Hancı Bay YEGAR: Namını duydum genç adam, bizim bunak Durin'i alıkonduğu delikten çıkarmışsın. Benim için de bir iyilik yapmanı istiyorum, karşılığını fazlasıyla alacaksın.\n" +
                    "\n" +
                    "OMERON: Dökülün bakalım Bay Yegar.\n");
            System.out.println("Devam etmek için (D) ye bas !");
            String continueKey = input.next().toUpperCase();
            if (continueKey.equals("D")) {
                System.out.println("Hancı Bay YEGAR: Şarap genç adam şarap, Şarap ne kadar güzelse cüceler o kadar mutludur. En güzel üzümler bizim topraklarımızda yetişir.\n" +
                        "Ancak tamamı Kral içindir bize göstermezler bile. Bizde arta kalanlarla idare ederiz. \n" +
                        "\n" +
                        "OMERON: Sonuca geç dostum.\n" +
                        "\n" +
                        "Hancı Bay YEGAR: Mahzenden benim için 2 galon Kraliyet Şarabı çalmanı istiyorum. Yapacağın işin karşılığını alacağından emin olabilirsin.\n");
                System.out.println("Evet (E) / Hayır (H) ...");
                while (true) {
                    String choose = input.next().toUpperCase();
                    if (choose.equals("E")) {
                        getPlayer().setCellar_flaag(true);
                        break;
                    } else if (choose.equals("H")) {
                        // MAHZENİ AKTİF ETMEZSEN  200 DİNARLIK ÖDÜLÜ KAÇIRIRSIN AYRIETEN HAİN LUNGOYU YAKALAYAMAZSIN
                        System.out.println("Görüşürüz Bay Yegar ...");
                        break;
                    } else {
                        System.out.println("Geçersiz karakter , tekrar dene !");
                    }
                }
            }
        }else{
            if(!getPlayer().isYegar_flag()) {

                getPlayer().getInventory().deleteAward("Kraliyet Şarabı");
                System.out.println("+ 200 Dinar");
                getPlayer().setYegar_flag(true);
            }else{
                System.out.println("Ödül alınmış ... ");
            }
        }
    }
}

// ####  HAN  ####
class Inn extends NormalLoc{

    public Inn(Player player) {
        super(player, "Han");
    }

    @Override
    public boolean onLocatin() {
        Location location = null;
        Player player = this.getPlayer();
        Quit quit = new Quit(player);
        while(true){
            System.out.println("#############\n");
            System.out.println("0 - Geri dön\n");
            System.out.println("1   Oda Tut (50 dinar)\n");
            System.out.println("2 - Salon\n");
            System.out.println("#############");

            int selection = input.nextInt();
            switch (selection) {
                case 1:
                    int new_money = getPlayer().getMoney()-50;
                    getPlayer().setMoney(new_money);
                    location = new Rent_Room(player);
                    break;
                case 2:
                    location = new Saloon(player);
                    break;
                case 0:
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
        return true;
    }
}

class Wine_Storage extends BattleLoc{

    public Wine_Storage(Player player) {
        super(player,"Şarap Deposu",new Guard(),"Altın Kadeh",0,false);
    }
}

class Guard extends Enemy{
    public Guard() {
        super(30,"Mahzen Bekçisi",20,20,"Kraliyet Şarabı",10);
    }
}
// #### MAHZEN ####
class Cellar extends NormalLoc{

    public Cellar(Player player) {
        super(player,"Şarap Mahzeni");
    }

    @Override
    public boolean onLocatin() {
        Location location = null;
        Player player = getPlayer();
        Quit quit = new Quit(player);
        while(true) {
            System.out.println("---- Şarap Deposuna gir (Ş) ---");
            System.out.println("---- Açık bir kapı var , bi göz at (B) !");
            System.out.println("-- Geri dön (Q)!");

            String secim = input.next().toUpperCase();
            switch (secim) {
                case "Ş":
                    location = new Wine_Storage(player);
                    break;
                case "B":
                    traitorLungo();
                    location = new Quit(player);
                    break;
                case "Q":
                    location = new Quit(player);
                    return true;
                default:
                    break;
            }
            if(!location.onLocatin()) {
                System.out.println("GAME OVER");
                System.exit(0);
                break;
            }
        }

        return true;
    }
    public void traitorLungo(){
        System.out.println("OMERON: Vay Vay Vay Ben de seni arıyordum Lungo. Hayırdır Mahzende farelik mi yapıyosun ?\n" +
                "\n" +
                "Cüce LUNGO: Paralı köpekleri yetmezmiş gibi bir de seni mi gönderdiler. Her şeyimi elimden aldınız daha ne istiyorsunuz. Yaklaşma!\n" +
                "\n" +
                "OMERON: Tüm söndürdüğün hayatlar için hesap vereceksin Lungo. Ailem ve tüm elfler adına seni böcek gibi ezeceğim.\n");
        System.out.println("Devam etmek için (D) ye bas");
        String devam = input.next().toUpperCase();
        if(devam.equals("D")){
            System.out.println("Cüce LUNGO: Hatırlıyorum seni pis melez. Baban Astor da kanında boğulmadan hemen önce fazla cesaretliydi.\nLanet olsun ki bize seni elimizden kaçırdık.Beceriksiz Sirius senin yüzünden bir melez tarafından azarlanıyorum. Yaklaşma!.\n" +
                    "\n" +
                    "OMERON: Kes sesini!. Bir kişi ne uğruna kendi onurunu satabilir. Söyle Kral size ailem karşılığında ne teklif etti!.\n" +
                    "\n");
            System.out.println("Devam etmek için (D) ye bas");
            String devam1 = input.next().toUpperCase();
            if(devam1.equals("D")){
                System.out.println("Cüce LUNGO: HA HA HA. Kendi ırkımızın yöneticisi olacaktık. saraylarda yaşayıp pahalı şaraplar içecektik ve inan bana bütün bunlar birkaç elfin sefil yaşamından daha değerli. Yaklaşma!\n" +
                        "\n" +
                        "OMERON: Fare gibi saklanarak yaşamaktansa onurlarıyla öldüler. Amcam nerede cüce?\n" +
                        "\n" +
                        "Cüce LUNGO: Söylerim ama bırak beni.Dur!\n");
                System.out.println("Devam etmek için (D) ye bas");
                String devam2 = input.next().toUpperCase();
                if(devam2.equals("D")){
                    System.out.println("OMERON: Pazarlık yapabilecek durumda değilsin Lungo. Anlat!\n" +
                            "\n" +
                            "Cüce LUNGO: Tamam tamam dur söylüyorum. Kalede sınırdaki kalede. Hadi ama hadi bırak beni dostum !\n" +
                            "\n" +
                            "\n" +
                            "Öldür(ö)/Bırak(B)\n");
                    String devam3 = input.next().toUpperCase();
                    if(devam3.equals("Ö")){
                        System.out.println("+100 Dinar");
                        getPlayer().setMoney(getPlayer().getMoney()+100);
                    }else if(devam3.equals("B")){
                        System.out.println("\n" +
                                "OMERAN: Kılıcımı senin kanına bulamayacağım Lungo. Ömrün boyunca tependeyim.\nKafanı bir kez olsun bu delikten çıkaramayacaksın.");
                        System.out.println("+100 Dinar");
                        getPlayer().setMoney(getPlayer().getMoney()+100);

                    }
                }
            }
        }
    }
}

// ### PAZAR YERİ ###
class Bazaar extends NormalLoc{

    public Bazaar(Player player) {
        super(player,"Pazar Yeri");
    }

    @Override
    public boolean onLocatin() {
        Location location = null;
        Player player = this.getPlayer();
        Quit quit = new Quit(player);
        while(true){
            System.out.println("#############\n");
            System.out.println("0 - Geri Dön\n");
            System.out.println("1 -  Market\n");
            System.out.println("2   Gizemli Kadınla Konuş\n");
            System.out.println("#############");

            int selection = input.nextInt();
            switch (selection) {
                case 1:
                    location = new ToolStore(player);
                    break;
                case 2:
                 //   location = new talkWithBeggar(player);
                    break;
                case 0:
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
        return true;
    }

}
// ### BELEDİYE BİNASI ####
class Town_Hall extends NormalLoc{

    public Town_Hall(Player player) {
        super(player, "Belediye Binası");
    }

    @Override
    public boolean onLocatin() {

        System.out.println(" -- Baron Rosea (B)--");

        if(getPlayer().getInventory().searchLetter(2)!=null){
            System.out.println(" --  Onbaşı (O)    --");
        }
        System.out.println(" --  Geri Dön (Q)  --");
        String secim = input.next().toUpperCase();
        if(secim.equals("B")){
            Awards arananItem = getPlayer().getInventory().searchAward("Gnoll kafası");
            if(arananItem==null && !getPlayer().isBaron_award_flag()) {

                System.out.println("Baron ROSEO: Kentimize hoşgeldin genç adam.\n" +
                        "\n" +
                        "OMERON: Teşekkürler Başkan Roseo. Bana ihtiyacınız olabileceğini düşündüm.\n" +
                        "\n" +
                        "Baron ROSEO: İyi düşünmüşsün. Hakkında iyi duyumlar alıyorum Omeran.\n" +
                        "\n" +
                        "OMERON: Nedir efendim.\n");
                System.out.println("\t\n Devam etmek için (D) ye bas");
                String continueKey = input.next().toUpperCase();
                if (continueKey.equals("D")) {
                    System.out.println("Baron ROSEO: Babanı tanırdım genç adam. Bu toprakların birleştirici gücüydü, korkusuz bir liderdi ve \nen önemlisi insan dışı ırkların umuduydu. Tüm umutlar onunla beraber karanlığa gömüldü. \n" +
                            "\n" +
                            "OMERON: O benimle beraber yaşamaya devam ediyor başkan hanım. Umudunuzu kaybetmeyin.\n" +
                            "\n" +
                            "Baron ROSEO: Seni takdir ediyorum genç adam, gözlerinde ışıltı hiç sönmesin. Baban gibi korkusuzca kılıç çarpıştırdığını duydum. Belki bana bir konuda yardım edebilirsin.");
                    System.out.println("\t\n Devam etmek için (D) ye bas");
                    String continueKey1 = input.next().toUpperCase();
                    if (continueKey1.equals("D")) {
                        System.out.println("OMERON: Sizi dinliyorum.\n" +
                                "\n" +
                                "Baron ROSEO: Biz cüce halkı geçimimizi tarım ile sağlarız Ancak aldığım duyumlara göre Bir Gnoll değirmenimize yerleşmiş.\nCüceler ne yapsalar kaçıramamışlar. Senden bir an önce bana onun kafasını getirmeni istiyorum.\nKarşılığını fazlasıyla alacaksın.\n");
                        System.out.println("EVET(E)/HAYIR(H)");
                        while (true) {

                            String choose = input.next().toUpperCase();
                            if (choose.equals("E")) {
                                getPlayer().setGnoll_task_flag(true);
                                break;
                            } else if (choose.equals("H")) {
                                break;
                            } else {
                                System.out.println("Geçersiz karakter,tekrar dene !");
                            }

                        }

                    }
                }
            }else{
                if(!getPlayer().isBaron_award_flag()) {
                    getPlayer().setBaron_award_flag(true);
                    System.out.println("Gnoll Ödülü:+100 Dinar");
                    getPlayer().setMoney(getPlayer().getMoney() + 100);
                    getPlayer().getInventory().deleteAward("Gnoll kafası");
                }else{
                    System.out.println("Ödül alınmış ... ");
                }
            }
        }else if(secim.equals("O")){

            System.out.println("Elf goronun mektubunu getirdim onbaşı.\n\t (+ 50 dinar)");
            getPlayer().getInventory().deleteLetter(2);

            getPlayer().setMoney(getPlayer().getMoney()+50);
        }else if(secim.equals("Q")){
            return true;
        }
        return  true;
    }
}
public class Second_Town extends NormalLoc{
    public Second_Town(Player player) {
        super(player, "Kent Merkezi");
    }

    @Override
    public boolean onLocatin() {
        Location location = null;
        Player player = this.getPlayer();
        while (true) {
            System.out.println("########### Bölgeler ###########");
            System.out.println("\n0- Geri Dön -! ");
            System.out.println("\n1- Han - !");
            System.out.println("\n2- Pazar Yeri -- !");
            System.out.println("\n3- Belediye Binası -- !");
            if(getPlayer().isCellar_flaag()){
                System.out.println("\n4- Mahzen -- !");
            }
            System.out.println("\nLütfen gitmek istediğiniz bölgeyi seçiniz : ");

            int selection = input.nextInt();

            switch (selection) {

                case 0:
                    location = new Quit(player);
                    return true;
                case 1:
                    location = new Inn(player);
                    break;
                case 4:
                    location = new Cellar(player);
                    break;
                case 2:
                    location = new Bazaar(player);
                    break;
                case 3:
                    location = new Town_Hall(player);
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
