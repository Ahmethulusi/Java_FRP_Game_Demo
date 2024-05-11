public abstract class BattleLoc extends Location {


    private int bet;
    private Enemy enemy;

    private String name;
    private String str_award;
    private int int_award;
    private boolean destroy_flag_6=false;

    public BattleLoc(Player player, String name, Enemy enemy, String str_award, int int_award, boolean destroy_flag) {
        super(player,name);
        this.enemy = enemy;
        this.name = name;
        this.str_award = str_award;
        this.int_award = int_award;
        this.destroy_flag_6=destroy_flag;
    }




    @Override
    public boolean onLocatin() {

        String name = this.getName();
        System.out.println("Can: "+this.getPlayer().getHealth());
        System.out.println("Hasar: "+this.getPlayer().getTotalDamage());

        if(name.equals("Mağara")){
                   if(!getPlayer().isCave_flag()){
                       System.out.println("Temizlenmiş bölge ... ");
                       return true;
                   }
               }else if(name.equals("Orman")){
                   if(!getPlayer().isAhead_of_forest_flag()){
                       System.out.println("Temizlenmiş bölge ...");
                       return true;
                   }
               }if(name.equals("Terkedilmiş Ev")){
                   if(!getPlayer().isEnemy_camp1_flag()){
                       System.out.println("Temizlenmiş bölge ...");
                       return true;
                   }
               }if(name.equals("Yükselen duman")){
                   if(!getPlayer().isEnemy_camp2_flag()) {
                       System.out.println("Temizlenmiş bölge ... ");
                       return true;
                   }
               }if(name.equals("Maden")) {
                    if (!getPlayer().isSide_task1()) {
                        System.out.println("Temizlenmiş bölge ... ");
                        return true;
                    }
                }if(name.equals("Dağ girişi")){
                    if(!getPlayer().isEnemy_camp3_flag()) {
                        System.out.println("Temizlenmiş bölge ... ");
                        return true;
                    }
               }if(name.equals("Canavar Yuvası")){
                   if(!getPlayer().isEnemy_camp6_flag()) {
                        System.out.println("Temizlenmiş bölge ... ");
                    return true;
                    }
                }if(name.equals("Dağın içi")){
                    if(!getPlayer().isEnemy_camp4_flag()) {
                        System.out.println("Temizlenmiş bölge ... ");
                        return true;
                    }
                }if(name.equals("Zirve")){
                    if(!getPlayer().isEnemy_camp5_flag()) {
                        System.out.println("Temizlenmiş bölge ... ");
                        return true;
                    }
                }if(name.equals("Değirmen")) {
                    if (!getPlayer().isGnoll_combat_flag()) {
                    System.out.println("Temizlenmiş bölge ... ");
                    return true;
                    }
                }if(name.equals("Güverte")) {
                   if (!getPlayer().isPirate_combat_flag()) {
                        System.out.println("Temizlenmiş bölge ... ");
                        return true;
                    }
                }
                if(name.equals("Kızıl Bahçe")){
                    if(!getPlayer().isToy_combat_flag()){
                        System.out.println("Temizlenmiş Bölge");
                        return true;
                    }
                }if(name.equals("Kaptanın Odası")){
                    if(!getPlayer().isSirius_combat_flag()) {
                        System.out.println("Temizlenmiş Bölge");
                        return true;
                    }
                }if(name.equals("Karanlık Bostan")) {
                    if (getPlayer().isDark_Garden_Flag()) {
                        System.out.println("Temizlenmiş Bölge");
                        return true;
                    }
                }


            useLifeFruit();

               int obs_number = enemy.randomObstacleNumber();
            if(this.getEnemy().getName().equals("Ayı")){
                System.out.println("Düşman:"+this.getEnemy().getName()+" var. Dikkatli ol !");
            }else if(this.getEnemy().getName().equals("Kurt")){
                System.out.println("Düşman: "+this.getEnemy().getName()+" olabilir.");
            }else if(this.getEnemy().getName().equals("Mistik Dağ Canavarı")){
                System.out.println("Düşman: "+this.getEnemy().getName());
            }else if(this.getEnemy().getName().equals("Kral Yeti")){
                System.out.println("Düşman: "+this.getEnemy().getName());
            }else if(this.getEnemy().getName().equals("Kaptan Sirius")){
                System.out.println("Düşman: "+this.getEnemy().getName());
            }else if(this.getEnemy().getName().equals("Gnoll")){
                System.out.println("Düşman: "+this.getEnemy().getName());
            }else if(this.getEnemy().getName().equals("Kale Muhafızı")){
                System.out.println("KALE MUHAFIZI: İşin bitti melez. Söz veriyorum ölümün acısız olacak.\n" +
                        "\n" +
                        "OMERON: Lord için can vermek. Tam bir aptallık.\n");
            } else if(this.getEnemy().getName().equals("Kapı Muhafızı")){
                System.out.println("KAPI MUHAFIZI: Aylar sonra kanlı canlı bir elf. Türünüz tükendi zannediyordum.\n" +
                        "\n" +
                        "OMERON: Bizim için endişelenme dostum. İşte karşındayım.\n");
                        System.out.println("Devam etmek için (D) ye bas !");
                        String devam = input.next().toUpperCase();
                        if(devam.equals("D")) {
                            System.out.println("KAPI MUHAFIZI: Uzun süredir elf boğmamıştım. Seni kurtlara yem edeceğim.\n" +
                                    "\n" +
                                    "OMERON: Göreceğiz.\n");
                        }
            }else if(this.getEnemy().getName().equals("Troll Nolf")) {
                System.out.println("OMERON: Bu da ne lan böyle ? Depoyu Troll mü koruyor ?\n" +
                        "\n" +
                        "TROLL NOLF: D D Dur orda ! B B Baba Depoyu Nolf'e verdi. B B Burası benim !\n" +
                        "\n" +
                        "OMERON: Nolf sana zarar vermeyeceğim. Misafir kabul ediyor musun ?\n" +
                        "\n" +
                        "TROLL NOLF: M M Misafir ? B B Baba Nolf'e çok kızar.\n");
                System.out.println("Devam etmek için (D) ye bas !");
                String devam = input.next().toUpperCase();
                if (devam.equals("D")) {
                    System.out.println("OMERON: Neden buradasın Nolf ?\n" +
                            "\n" +
                            "TROLL NOLF: B B Beni paramparça edecekler. N N Nolf çok üzgün. B B Baba Nolf'u korur.\n" +
                            "\n" +
                            "OMERON: Kim yapacak bunu Nolf ?\n" +
                            "\n" +
                            "TROLL NOLF: C C Cüceler...\n" +
                            "\n" +
                            "OMERON: Lord seni kandırıyor koca dostum. Sana kimse bir şey yapamaz. \n" +
                            "\n" +
                            "TROLL NOLF: K K Kimse Nolf'u kandıramaz. N N Nolf seni ezecek.\n");

                }
            }else if(this.getEnemy().getName().equals("Zavura")){

                System.out.println("SAVAŞ SORUMLUSU: Hey sen ! Kılıç sallamasını biliyor musun ?\n" +
                        "\n" +
                        "OMERON: Anlamadığım söylenemez.\n");
                System.out.println("Devam etmek için (D) ye bas");
                String devam = input.next().toUpperCase();
                if(devam.equals("D")){
                    System.out.println("SAVAŞ SORUMLUSU: Şu karşıdakini görüyor musun ? Zavura... Yarım akıllı, elimdeki bütün adamları kılıçtan geçirdi. Artık birisi ona dur demeli. \n" +
                            "\n" +
                            "OMERON: O kadar da korkutucu gözükmüyor.\n" +
                            "\n" +
                            "SAVAŞ SORUMLUSU: Kazanırsan bahsin iki katı.\n");
                    System.out.println("Devam etmek için (D) ye bas");
                    String devam1 = input.next().toUpperCase();
                    if(devam1.equals("D")){
                        System.out.println("OMERON: 3 Katı...\n" +
                                "\n" +
                                "SAVAŞ SORUMLUSU: Lanet olası fırsatçı... Tamam 3 katı olsun. Onunla dövüşmek istiyor musun ?\n" +
                                "\n" +
                                "EVET(E)/HAYIR(H)\n");
                        String secim = input.next().toUpperCase();
                        if(secim.equals("E")){
                            System.out.println("OMERON: Şanslı günündesin dostum.\n" +
                                    "\n" +
                                    "BAHİS GİR:(MAKSİMUM 50 DİNAR GİRİLİR 3 KATINI GERİ ALIRIZ)\n");
                            int bet = input.nextInt();
                            if(bet>50){
                                System.out.println("En fazla 50 dinar bahis girilebilir");
                                while(true){
                                    int bet1 = input.nextInt();
                                    if(bet1<=50){break;}
                                    else {System.out.println("En fazla 50 dinar bahis girilebilir");}
                                }
                            }
                            System.out.println("ÇENEKIRAN ZAVURA: Sonun geldi. Koleksiyonuma bir elf çenesi eklenecek.\n" +
                                    "\n" +
                                    "OMERON: Ünlü son sözler.");
                            System.out.println(this.getEnemy().getName()+" : "+ getEnemy().getDamage()+" Sağlık : "+ getEnemy().getHealth());
                            boolean isWon= savas(this.getEnemy().getStr_Award(),obs_number);
                            return isWon;
                        }else{
                            return true;
                        }
                    }
                }
            }
            else{
                System.out.println("Dikkatli ol burada bir veya daha fazla "+this.getEnemy().getName()+" olabilir.");
            }

               enemyStats(obs_number);
            if(this.getEnemy().getName().equals("Troll Nolf")){
                System.out.println("<S>avaş veya <İ>kna et");
                String selection = input.next().toUpperCase();
                if(selection.equals("S")){
                    System.out.println("OMERON: Peki Nolf. Baban haklıymış, Az sonra seni paramparça edeceğim.");
                    boolean isWon= savas(this.getEnemy().getStr_Award(),obs_number);
                    return isWon;
                }else if(selection.equals("İ")){
                    System.out.println("OMERON: Sakin Nolf. Al koca dostum senin için güzel bir elma, hem de sulu sulu.\n" +
                            "\n" +
                            "TROLL NOLF: NOLF ELMA SEVER. NOLF SENİ DE SEVER.\n" +
                            "\n" +
                            "OMERON: Bu kadar basit");
                    Awards arananItem = getPlayer().getInventory().searchAward("Elma");
                    if(arananItem==null){
                        System.out.println("OMERON: Oooo ! Olamaz elimizde hiç elma kalmamış.");
                        System.out.println("OMERON: Peki Nolf. Baban haklıymış, Az sonra seni paramparça edeceğim.");
                        boolean isWon= savas(this.getEnemy().getStr_Award(),obs_number);
                        return isWon;
                    }else{
                        getPlayer().getInventory().deleteAward("Elma");
                        Awards kraliyetSarabiVarmi = getPlayer().getInventory().searchAward(str_award);
                        Awards uzumVarMi = getPlayer().getInventory().searchAward(this.getEnemy().getStr_Award());
                        if(kraliyetSarabiVarmi==null){
                            getPlayer().getInventory().getAwardsList().add(Awards.getAwardObjByName(str_award));
                            getPlayer().getInventory().setCountAwardList(1,str_award);
                        }else{
                            getPlayer().getInventory().getAwardsList().add(Awards.getAwardObjByName(str_award));
                            getPlayer().getInventory().setCountAwardList(kraliyetSarabiVarmi.getCount()+1,str_award);
                        }
                        if(uzumVarMi==null){
                            getPlayer().getInventory().getAwardsList().add(Awards.getAwardObjByName(this.getEnemy().getStr_Award()));
                            getPlayer().getInventory().setCountAwardList(1,this.getEnemy().getStr_Award());
                        }else{
                            getPlayer().getInventory().getAwardsList().add(Awards.getAwardObjByName(this.getEnemy().getStr_Award()));
                            getPlayer().getInventory().setCountAwardList(uzumVarMi.getCount()+1,this.getEnemy().getStr_Award());
                        }
                    }
                    return true;
                }
            }else{
                System.out.println("<S>avaş veya <K>aç");
            }
               String selection = input.next().toUpperCase();
               if(selection.equals("S")){
                   return savas(this.getEnemy().getStr_Award(),obs_number);
               } else if (selection.equals("K")) {
                   System.out.println("Ana menüye dönülüyor...");
                   return true;
               }else{
                   System.out.println("Geçersiz Seçim");
                   return true;
               }

    }


    boolean flag=true;
    public boolean savas(String name,int obs_number) {
        BattleSimulation battleSimulation1=new BattleSimulation();
        battleSimulation1.startSimulation();
        int targetawardcount  = 0;
        int targetawardcount1 = 0;

        if(this.getEnemy().getName().equals("Ayı")){
            obs_number=1;
        }else if(this.getEnemy().getName().equals("Kurt")){
            obs_number =2;
        }else if(this.getEnemy().getName().equals("Mistik Dağ Canavarı")){
            obs_number=1;
        }else if(this.getEnemy().getName().equals("Kral Yeti")){
            obs_number=1;
        }else if(this.getEnemy().getName().equals("Kaptan Sirius")){
            obs_number=1;
        }else if(this.getEnemy().getName().equals("Gnoll")){
            obs_number=1;
        }else if(this.getEnemy().getName().equals("Mahzen Bekçisi")){
            obs_number=2;
        }else if(this.getEnemy().getName().equals("Kapı Muhafızı")){
            obs_number=1;
        }else if(this.getEnemy().getName().equals("Troll Nolf")){
            obs_number=1;
        }else if(this.getEnemy().getName().equals("Zavura")){
            obs_number=1;
        }else if(this.getEnemy().getName().equals("Asi Grandel")) {
            obs_number = 1;
        }else if(this.getEnemy().getName().equals("Patron Orge")) {
            obs_number = 1;
        }

        do {
            if (combat(obs_number)) {
                String looking_for_Name = this.getName();
                if (looking_for_Name.equals("Mağara")) {
                    this.getPlayer().setCave_flag(false);
                } else if (looking_for_Name.equals("Orman")) {
                    this.getPlayer().setAhead_of_forest_flag(false);
                } else if (looking_for_Name.equals("Terkedilmiş Ev")) {
                    this.getPlayer().setEnemy_camp1_flag(false);
                } else if (looking_for_Name.equals("Yükselen duman")) {
                    this.getPlayer().setEnemy_camp2_flag(false);
                } else if (looking_for_Name.equals("Dağ girişi")) {
                    this.getPlayer().setEnemy_camp3_flag(false);
                } else if (looking_for_Name.equals("Dağın içi")) {
                    this.getPlayer().setEnemy_camp4_flag(false);
                } else if (looking_for_Name.equals("Zirve")) {
                    this.getPlayer().setEnemy_camp5_flag(false);
                } else if (looking_for_Name.equals("Canavar Yuvası")) {
                    this.getPlayer().setEnemy_camp6_flag(false);
                } else if (looking_for_Name.equals("Maden")) {
                    this.getPlayer().setSide_task1(false);
                } else if (looking_for_Name.equals("Giriş Kat")) {
                    this.getPlayer().setTrimaran_castle_flag_one(false);
                    this.getPlayer().setTrimaran_castle_flag_two(true);
                    this.getPlayer().setTrimaran_castle_flag_three(true);
                } else if (looking_for_Name.equals("Değirmen")) {
                    this.getPlayer().setGnoll_combat_flag(false);
                } else if (looking_for_Name.equals("Kızıl Bahçe")) {
                    this.getPlayer().setToy_combat_flag(false);
                } else if (looking_for_Name.equals("Kaptanın Odası")){
                    this.getPlayer().setSirius_combat_flag(false);
                }else if(looking_for_Name.equals("Güverte")){
                    this.getPlayer().setPirate_combat_flag(false);
                }else if(looking_for_Name.equals("Gözcü Kulesi")){
                    this.getPlayer().setWatchmen_combat_flag(false);
                }else if(looking_for_Name.equals("Kale Kapısı")) {
                    this.getPlayer().setGateGuard_combat_flag(false);
//                }else if(looking_for_Name.equals("Giriş Kat")) {
//                    this.getPlayer().setCastleGuard_combat_flag(false);
                }else if(looking_for_Name.equals("Karanlık Bostan")){
                    this.getPlayer().setDark_Garden_Flag(true);
                }


                if(looking_for_Name.equals("Terkedilmiş Ev")){
                    obs_number=1;
                } else if (looking_for_Name.equals("Maden")) {
                    obs_number=1;
                }else if (looking_for_Name.equals("Anıt Kalıntıları")) {
                    obs_number=1;
                }

                //  #############a## BURADAN AŞAĞISI SAVAŞTAN SAĞ ÇIKMA DURUMUNDA ÖDÜL SİSTEMİ VE ENVANTERDEKİ DÜZENLEMELERLE İLGİLİ ##################
                if(this.getEnemy().getInt_Award()==0){
                    System.out.println(obs_number + " tane " + this.getEnemy().getStr_Award() + " ve 1 " + this.getStr_Award());
                }
                else{
                    if(str_award.equals("Altın Kadeh")){
                        System.out.println(2 + " Galon " + this.getEnemy().getStr_Award() + ", 1 " + this.getStr_Award() + "+ " + (this.getEnemy().getInt_Award()*obs_number + int_award) + " + dinar ");
                    }else{
                        System.out.println(obs_number + " tane " + this.getEnemy().getStr_Award() + " ve 1 " + this.getStr_Award() + "+ " + (this.getEnemy().getInt_Award()*obs_number + int_award) + " + dinar ");
                    }


                }
                this.getPlayer().setMoney(this.getPlayer().getMoney() + int_award + obs_number * this.getEnemy().getInt_Award());
                for (Awards award : this.getPlayer().getInventory().getAwardsList()) {
                    if (award != null) {
                        if (award.getName().equals(getEnemy().getStr_Award())) {
                            targetawardcount += award.getCount();
                        }
                    }
                }
                for (Awards award : this.getPlayer().getInventory().getAwardsList()) {
                    if (award != null) {
                        if (award.getName().equals(this.getStr_Award())) {
                             targetawardcount1 += award.getCount();
                        }
                    }
                }

                if (targetawardcount > 0) {
                    //Oyuncu savaşı kazanırsa gelen ödüllerle birlikte envanterdeki ve parasındaki düzenlemeler aşağıdaki gibi olur.
                 //   playerStats();
//                    this.getPlayer().getInventory().addAward(selectedaward);

                    this.getPlayer().getInventory().setCountAwardList((targetawardcount + obs_number), this.getEnemy().getStr_Award());
                    System.out.println("Geri dönmek için Q'ya bas.");
                    String choose = input.next().toUpperCase();
                    if(choose.equals("Q"))
                        flag = false;
                    else{
                        continue;
                    }
                } else {
                    //Oyuncu savaşı kazanırsa gelen ödüllerle birlikte envanterdeki ve paramdaki düzenlemeler aşağıdaki gibi olur.
               //     playerStats();
                    Awards selectedaward = Awards.getAwardObjByName(name);
                    this.getPlayer().getInventory().addAward(selectedaward);
                    this.getPlayer().getInventory().setCountAwardList(obs_number, this.getEnemy().getStr_Award());
                    // Mekan Ödülü

                }
                // Aşağıdaki mekan ödülleri için düzenleme
                if(targetawardcount1>0){
                    this.getPlayer().getInventory().setCountAwardList((targetawardcount1+obs_number),str_award);
                }
                else{
                    Awards selectedaward2 = Awards.getAwardObjByName(str_award);
                    this.getPlayer().getInventory().addAward(selectedaward2);
                    this.getPlayer().getInventory().setCountAwardList(1,str_award);
                }

                if(this.getEnemy().getName().equals("Zavura")){
                    this.getPlayer().setMoney(getPlayer().getMoney()+3*bet);
                    System.out.println("+ "+3*bet+" dinar");
                }
                // BattleLocation  Maden ise gerçekleşecek olaylar.
                if(this.getName().equals("Maden")){
                    while(true) {


                        System.out.println("Mahkumları kurtarmak için anahtarı kullan E \nMahkumları görmezden gelip yoluna devam etmek için H ye bas !");
                        String selection = input.next().toUpperCase();
                        if (selection.equals("E")) {
                            System.out.println("Zindandan Goro , Sakai ve Cüce Durin  adında 3 mahkum kurtardın,Goro kıyı çarşısına gitmek istedi,\nCüce Durin de kendi şehrine doğru yola çıktı.Sakai'yi de  kampına götürdün artık onunla birlikte yaşayacaksın ");
                            for (Awards award : this.getPlayer().getInventory().getAwardsList()) {
                                if (award != null) {
                                    if (award.getName().equals("Zindan Anahtarı")) {
                                        this.getPlayer().setEnemy_camp7_flag(false);
                                        this.getPlayer().getInventory().getAwardsList().remove(award);
                                    }
                                }
                            }
                            break;
                        }else if(selection.equals("H")){
                            System.out.println("Mahkumları ölüme terk ettin !");
                            break;
                        }
                    }
                }


                if(this.getEnemy().getName().equals("Gözcü")){
                    this.getPlayer().getInventory().getLettersList().add(Letters.getLetterObjById(3));
                    while(true) {
                        System.out.println("Bir Mektup buldun ,okumak için (R) ye bas ! \nGeri dönmek için (G) ye bas !");
                        String selection = input.next().toUpperCase();
                        if (selection.equals("R")) {
                            System.out.println("Bir Askerin Mektubu\n" +
                                    "\n" +
                                    "Biricik sevgilim Calanthe'ye\n" +
                                    "\n" +
                                    "\tCanımın içi yokluğun beni zora sokuyor. Bugün sensiz geçen 2. ayım. Daha önce böyle bir hüznü tatmamıştım, böyle bir sızı doldurmamıştı yüreğimi." +
                                    "\n\tBöylesine üzülmemiş, Gecenin karanlığında boğulmamıştım. Beni merak etme, işler gayet yolunda. Herhangi bir tehdit yok." +
                                    "\n\tBu taş kulenin tepesinde saatlerimi seni düşünerek geçirip buluşacağımız günün hayaliyle yaşıyorum.\n" +
                                    "\tSenin gözlerinin yanında sönük kalacaklarını bilsem de sana Trimaran'ın en göz alıcı taşlarından bir taç yaptırdım. Kızıl saçlarına çok yakışacak.\n" +
                                    "\t\n" +
                                    "\n" +
                                    "\tUmarım senin için de her şey yolundadır sevgili Calanthe'm. Yakın zamanda bir daha ayrılmamak üzere birleşeceğiz.\nLütfen bana bolca o güzel elmalı turtalarından yap. Seni çok seviyorum.\n" +
                                    "\t\n" +
                                    "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t-VESKEL-");
                            break;
                        }else if(selection.equals("G")) {
                            break;
                        }else{
                            System.out.println("Geçersiz karakter , tekrar dene !");
                        }
                    }
                }
                // BattleLocation  Kaptan Siriusun Odası ise gerçekleşecek olaylar.
                if(this.getName().equals("Kaptanın Odası")){
                    this.getPlayer().getInventory().getLettersList().add(Letters.getLetterObjById(1));
                    while(true) {

                        System.out.println("Bir Mektup buldun ,okumak için (R) ye bas ! \nGeri dönmek için (G) ye bas !");
                        String selection = input.next().toUpperCase();
                        if (selection.equals("R")) {
                            System.out.println("Kral Aesir'e\n" +
                                    "\n" +
                                    "Vadettikleriniz yalnızca hayalden ibaret. Beni bu bok çukuruna mahkum ettiniz. Söylentiler beni halk içine çıkamaz duruma getirdi. " +
                                    "\nAilemi göremiyorum ve çocuklarım bensiz büyüyor. Yalnızca deli bir kadının kehaneti uğruna binlerce elfin hayatlarını ve hayallerini yıktınız.\n" +
                                    "Rahat uyuyamıyorum. Her gün kamaramdan o kadını gördükçe yoldaşlarımın, arkadaşlarımın ve yakınlarımın ölüm çığlıkları kulaklarımda yankılanıyor.\nSize kandığım için her gün kendime lanet ediyorum." +
                                    "İhanet söylemleri dibimizdeki Cüce kentine kadar yayıldı Lungo'nun da sonu yakındır.\nArtık sizden bir beklentim yok. Umuyorum ki kendi kanınızda boğulursunuz.\n" +
                                    "\n" +
                                    "\n" +
                                    "\t\t\t\t\t\t\t\t\t\t\t\t-Kaptan Sirius-");
                            break;
                        }else if(selection.equals("G")){
                            break;
                        }
                    }
                }

                while(flag){
                    System.out.println("\nGeri dönmek için Q'ya bas.");
                    String choose = input.next().toUpperCase();
                    if(choose.equals("Q"))
                        flag = false;
                    else{
                        continue;
                    }
                }
                destroy_flag_6=false;
            } else {
                return false;
            }
        } while (flag);
        return true;
    }



    // Şimdilik savaş algoritması  düşmanın hem sağlığının hem hasarının playerdan daha az ise kazanacak şeklinde olur
    public boolean combat(int obsnumber){
        // ## GİRDİĞİMİZ FİGHTLARDAN BAŞARIYLA ÇIKABİLMEMİZ İÇİN HEM SAĞLIĞIMIZIN DÜŞMANLARIN TOPLAM SAĞLIĞINDAN DAHA FAZLA ,
        // ## HEM TOPLAM HASARIMIZIN DÜŞMANLARIN TOPLAM HASARININ ZIRHIN DURABİLİTYSİNİN FARKINDAN FAZLA OLMASI GEREKİYOR
        if((obsnumber*(this.getEnemy().getHealth())<this.getPlayer().getHealth()) && (this.getPlayer().getTotalDamage()>(this.getEnemy().getDamage()*obsnumber)-(this.getPlayer().getInventory().getArmor().getDurability()))){
            int new_blocking_count = this.getPlayer().getInventory().getArmor().getBlocking_count()-obsnumber;
            this.getPlayer().getInventory().getArmor().setBlocking_count(new_blocking_count);
            if(this.getPlayer().getInventory().getArmor().getBlocking_count()==0 && !this.getPlayer().getInventory().getArmor().getName().equals("Yok")){
                this.getPlayer().getInventory().getArmor().setDurability(0);
                System.out.println("Zırhınız kullanılamaz halde...,Tamirciye gidip yaptırabilirsiniz ya da yeni bir kalkan alabilirsiniz !");
            }
            this.getPlayer().setHealth(this.getPlayer().getHealth()-(this.getEnemy().getDamage()*obsnumber));

            System.out.println(this.getEnemy().getName()+" düşmanı ile savaştan başarıyla çıktınız,Tebrikler.");
            return true;
        }
        else{
            System.out.println("Öldünüz,Oyun bitti...");
            System.exit(0);
            return false;
        }
    }

    public void playerStats(){
        System.out.println("--------------------------");
        System.out.println("Sağlık : "+getPlayer().getHealth());
        System.out.println("Hasar : "+getPlayer().getDamage());
        System.out.println("--------------------------");

    }
    public void enemyStats(int obs_number){
        if(this.getEnemy().getName().equals("Ayı")){
            obs_number=1;
        }else if(this.getEnemy().getName().equals("Kurt")){
            obs_number =2;
        }else if(this.getEnemy().getName().equals("Mistik Dağ Canavarı")){
            obs_number=1;
        }else if(this.getEnemy().getName().equals("Kral Yeti")){
            obs_number=1;
        }else if(this.getEnemy().getName().equals("Kaptan Sirius")){
            obs_number=1;
        }else if(this.getEnemy().getName().equals("Gnoll")){
            obs_number=1;
        }else if(this.getEnemy().getName().equals("Kapı Muhafızı")){
            obs_number=1;
        }else if(this.getEnemy().getName().equals("Troll Nolf")){
            obs_number=1;
        }else if(this.getEnemy().getName().equals("Asi Grandel")){
            obs_number=1;
        }else {

            System.out.println(this.getEnemy().getName() + " Değerleri");
            System.out.println("--------------------------");
            System.out.println("Can : " + (this.getEnemy().getHealth() * obs_number));
            System.out.println("Hasar : " + (this.getEnemy().getDamage() * obs_number));
            System.out.println("--------------------------");

        }
    }

    public void useLifeFruit(){
        int lifeFruit_count=0;
        for(Awards award:getPlayer().getInventory().getAwardsList()){
            if(award!=null){
                if(award.getName().equals("Yaşam Meyvesi")){
                    lifeFruit_count = award.getCount();
                }
            }
        }
        if(this.getPlayer().getHealth()< getPlayer().getMax_health()*0.4 && lifeFruit_count>0){
            System.out.println("Canınız Az Yaşam Meyvesini kullanmak için (U) ya basın !");
            String take = input.next().toUpperCase();
            if(take.equals("U")){
                int ex_health = this.getPlayer().getHealth();
                this.getPlayer().setHealth(ex_health + 30);
                System.out.println("Sağlık : "+getPlayer().getHealth());
                if((lifeFruit_count-1)==0){
                    this.getPlayer().getInventory().deleteAward("Yaşam Meyvesi");
                }
                else{
                    this.getPlayer().getInventory().setCountAwardList(lifeFruit_count-1,"Yaşam Meyvesi");
                }

            }
        }
    }
    public Enemy getEnemy() {
        return enemy;
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }

    public String getStr_Award() {
        return str_award;
    }

    public void setStr_Award(String award) {
        this.str_award = str_award;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public int getInt_award() {
        return int_award;
    }

    public void setInt_award(int int_award) {
        this.int_award = int_award;
    }

    public boolean isDestroy_flag() {
        return destroy_flag_6;
    }

    public void setDestroy_flag(boolean destroy_flag) {
        this.destroy_flag_6 = destroy_flag;
    }


}

