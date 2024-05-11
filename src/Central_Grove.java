
class Temple extends NormalLoc{

    public Temple(Player player) {
        super(player, "Tapınak");
    }

    @Override
    public boolean onLocatin() {
        while(true){
            System.out.println("Kör Keşişle konuşmak için (K) ye bas !");
            String talk = input.next().toUpperCase();
            if(talk.equals("K")) {
                if (!getPlayer().isParrot_flag()) {
                    System.out.println("KÖR KEŞİŞ: Astor sen misin dostum ? Öldüğünü sanıyordum.\n" +
                            "\n" +
                            "OMERON: Astor mu ? Babamı nerden tanıyorsun ?\n");
                    System.out.println("Devam etmek için (D) ye bas");
                    String continueKey1 = input.next().toUpperCase();
                    if (continueKey1.equals("D")) {
                        System.out.println("KÖR KEŞİŞ: Ahh. Tahmin etmeliydim. Tıpkı baban gibi kokuyorsun. Bilgili ve sohbeti hoş bir liderdi. Ne kötü bir kader.\n" +
                                "\n" +
                                "OMERON: Kokmak mı ? Beni göremiyor musun ?\n" +
                                "\n" +
                                "KÖR KEŞİŞ: Sadece seni değil genç adam hayatı göremiyorum ancak hislerim ve hafızam çok kuvvetlidir. \n");
                        System.out.println("Devam etmek için (D) ye bas");
                        String continueKey2 = input.next().toUpperCase();
                        if (continueKey2.equals("D")) {
                            System.out.println("OMERON: Babam hakkındaki güzel sözleriniz için onur duydum, sizin için yapabileceğim bir şey var mı bayım ?\n" +
                                    "\n" +
                                    "KÖR KEŞİŞ: Elbette! Sevgili lulu mu kaybettim genç adam gözlerimi kaybettim. Yalnızca bir kaç saat oldu fazla uzaklaşmış olamaz.\n" +
                                    "\n" +
                                    "OMERON: Kızınız sizi terk mi etti ?\n");
                            System.out.println("Devam etmek için (D) ye bas");
                            String continueKey3 = input.next().toUpperCase();
                            if (continueKey3.equals("D")) {
                                System.out.println("KÖR KEŞİŞ: Ahh. Bir papağan genç adam yaşlı bir papağan.\n" +
                                        "\n" +
                                        "OMERON: Yanlış anlamadım değil mi benden kayıp papağanınızı bulmamı istiyorsunuz.\n" +
                                        "\n" +
                                        "KÖR KEŞİŞ: Evet. O benim tek dostum.");
                            }
                        }
                    }
                    while (true) {

                        System.out.println(" EVET(E) / HAYIR(H) ........");
                        String choose = input.next().toUpperCase();
                        if (choose.equals("E")) {
                            getPlayer().setHanging_garden_flag(true);
                            break;

                        } else if (choose.equals("H")) {
                            System.out.println("Konuşma metni ........");
                            System.out.println("Konuşma metni ........");
                            break;
                        } else {
                            System.out.println("Geçersiz karakter , tekrar dene !");
                        }
                    }
                    break;
                }else{
                    if(!getPlayer().isKesis_award_flag()) {

                        System.out.println("Bu hediyeyi kabul et (+ 50 dinar)");
                        int new_money = getPlayer().getMoney() + 50;
                        this.getPlayer().setMoney(new_money);
                        getPlayer().setKesis_award_flag(true);
                        break;
                    }else{
                        System.out.println("Ödül alınmış ...");
                        System.out.println("Tapınaktan çıkmak için (Q) ya bas !");
                        while(true) {
                            String cik = input.next().toUpperCase();
                            if (cik.equals("Q")) {
                                break;
                            }else{System.out.println("Geçersiz karakter, tekrar dene !");}
                        }
                        break;
                    }

                }
            }
            }
        return true;
    }
}

class Mill extends BattleLoc{

    public Mill(Player player) {
        super(player, "Değirmen",new Gnoll(),"Gnoll kafası",0,true);
    }
}
class Hanging_Garden extends NormalLoc{

    public Hanging_Garden(Player player) {
        super(player, "Asmalı Bahçe");
    }

    @Override
    public boolean onLocatin() {
        System.out.println("Oduncu Kulubesine girmek için (E) ye bas !");
        String enter = input.next().toUpperCase();
        if(enter.equals("E")) {
            if(!getPlayer().isParrot_flag()) {
                System.out.println("Seslenmek için (E) ye bas !");
                String talk = input.next().toUpperCase();
                if (talk.equals("E")) {
                    System.out.println("OMERON: Kimse yok mu?\n" +
                            "\n" +
                            "Küçük Kız: Buyrun bayım.\n" +
                            "\n" +
                            "OMERON: Ailen nerede ?\n" +
                            "\n" +
                            "Küçük Kız: Çarşıdalar gün içinde çalışıyorlar. Ne istiyorsunuz ?\n" +
                            "\n" +
                            "OMERON: Keşişin papağanını arıyorum. Bildiğin bir şey var mı ?\n");
                    System.out.println("Devam etmek için (D) ye bas !");
                    String continueKey = input.next().toUpperCase();
                    if (continueKey.equals("D")) {
                        System.out.println("OMERON: Keşişin papağanını arıyorum. Bildiğin bir şey var mı ?\n" +
                                "\n" +
                                "Küçük Kız: Papağan falan yok burda. Güle g..\n" +
                                "\n" +
                                "OMERON: Hey Hey dur bakalım. Ne saklıyorsun sen.");
                        System.out.println("Devam etmek için (D) ye bas !");
                        String continueKey1 = input.next().toUpperCase();
                        if (continueKey1.equals("D")) {
                            System.out.println("Küçük Kız: Hiçbir sey saklamıyorum neden bahsettiğinizi bilmiyorum bile.\n" +
                                    "\n" +
                                    "OMERON: Gayet iyi biliyorsun küçük hanım. Lütfen getirir misin artık.\n" +
                                    "\n" +
                                    "Küçük Kız: Ama o benim arkadaşım. Lütfen bayım benimle kalsın.\n" +
                                    "\n" +
                                    "OMERON: Bak küçük hanım belki bir gün sana bir papağan getiririm ama şimdi Lulu'yu almak zorundayım.\n" +
                                    "\n" +
                                    "Küçük Kız: Buyrun bayım.\n");
                            System.out.println("+ Papağan");
                            getPlayer().setParrot_flag(true);
                            System.out.println("\nGeri dönmek için (Q) ya bas !");
                            while(true){
                                String quit = input.next().toUpperCase();
                                if(quit.equals("Q"))break;
                                else{System.out.println("Geçersiz karakter , tekrar dene");}
                            }
                        }
                    }

                }
            }else{
                System.out.println("Buraya daha önce gelmiştim , küçük kızdan keşişin papağanını almak için epey uğraştığımı hatırlıyorum ...");
                System.out.println("Kulubeden Çıkmam için (Q) ya bas !");
                while(true) {
                    String quitKey = input.next().toUpperCase();
                    if (quitKey.equals("Q")) {break;}
                    else{System.out.println("Geçersiz karakter , tekrar dene");}
                }
            }
        }

        return true;
    }
}
public class Central_Grove extends NormalLoc{
    public Central_Grove(Player player) {
        super(player, "Ortakoru");
    }

    @Override
    public boolean onLocatin() {
        Location location = null;
        Player player = this.getPlayer();
        while (true) {
            System.out.println("########### Bölgeler ###########");
            System.out.println("\n0- Geri Dön -! ");
            System.out.println("\n1- Tapınak -- !");
            if(getPlayer().isGnoll_task_flag()){
                System.out.println("\n2- Değirmen -- !");
            }
            if(getPlayer().isHanging_garden_flag()){
                System.out.println("\n3- Asmalı Bahçe -- !");
            }
            System.out.println("\nLütfen gitmek istediğiniz bölgeyi seçiniz : ");

            int selection = input.nextInt();

            switch (selection) {

                case 0:
                    location = new Quit(player);
                    return true;
                case 1:
                    location = new Temple(player);
                    break;
                case 2:
                    location = new Mill(player);
                    break;
                case 3:
                    location = new Hanging_Garden(player);
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
