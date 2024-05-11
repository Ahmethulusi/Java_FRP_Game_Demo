class Scaffold extends NormalLoc{
    public Scaffold(Player player) {
        super(player, "İskele");
    }
    @Override
    public boolean onLocatin() {
        System.out.println("Kumarbaz Kochun teknesini kullanmak için (U) ya bas.");
        String kullan = input.next().toUpperCase();
        if(kullan.equals("U")){
            System.out.println("Gidiliyor...");
        }
        return true;
    }
}

class Cave extends BattleLoc {
    public Cave(Player player) {
        super(player, "Mağara", new Kurt(),"Mantar",0,true);
    }
}
class Kurt extends Enemy {
    public Kurt() {
        super(1, "Kurt", 8, 20,"Diş",0);
    }
}

class Forest extends BattleLoc {
    public Forest(Player player) {
        super(player,"Orman", new Bear(),"Odun",0,true);
    }
}
class Bear extends Enemy {
    public Bear() {
        super(3,"Ayı",20,50,"Kürk",0);
    }
}
class Rising_smoke extends BattleLoc {
    public Rising_smoke(Player player) {
        super(player, "Yükselen duman",new Eskiya(),"Ekmek",25,true);// gold
    }
}
class Eskiya extends Enemy {
    public Eskiya() {
        super(4,"Eşkiya" , 5, 10,"Elma",5);//20 gold(para)
    }
}
class Abondoned_house extends BattleLoc {
    public Abondoned_house(Player player) {
        super(player,"Terkedilmiş Ev",new Haydut(),"Tahıl",25,true);
    }
}
class Haydut extends Enemy {
    public Haydut() {
        super(2,"Haydut",6, 7, "Çalıntı Eşya", 5);
    }
}


public class Cuha_Forest extends Location{
    public Cuha_Forest(Player player) {
        super(player, "Çuha Ormanı");
    }

    @Override
    public boolean onLocatin() {
        Go_forest(this.getPlayer());
        return true;
    }
    public boolean Go_forest(Player player) {
        Location location = null;
        Quit quit = new Quit(player);
        while(true){
            System.out.println("\n\t ################ ÇUHA ORMANI ############### ");
            System.out.println("\t0- Çıkış yap\n");
            System.out.println("\n\t1 - Yükselen bir duman var istersen bi bak !\n");
            System.out.println("\t2- Terkedilmiş eve gir\n");
            System.out.println("\t3- Ormanın İçine doğru ilerle\n");
            System.out.println("\t4- Mağaraya gir\n");
            if(getPlayer().isBoat_flag()) {
                System.out.println("\t5- İskele\n");
            }
            int selection = input.nextInt();
            switch (selection) {
                case 1:
                    location = new Rising_smoke(player);
                    break;
                case 2:
                    location = new Abondoned_house(player);
                    break;
                case 3:
                    location = new Forest(player);
                    break;
                case 4:
                    location = new Cave(player);
                    break;
                case 5:
                    location = new Scaffold(player);
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
                System.out.println("Lütfen geçerli bir değer giriniz !");
                break;
            }
        }
        return  true;
    }
}
