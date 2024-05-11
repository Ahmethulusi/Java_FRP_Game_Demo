class BorderSecurity extends Enemy{
    public BorderSecurity() {
        super(10, "Sınır Askeri", 15, 25, "Gümüş Kabza", 5);
    }
}

class CityBorder extends BattleLoc{
    public CityBorder(Player player) {
        super(player, "Sınır",new BorderSecurity(), "Yaşam Meyvesi", 0, true);
    }
}

public class Part_One extends Location {
    public Part_One(Player player) {
        super(player, "Bölüm 1");
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
            System.out.println("\n1- Kıyı Bölgesi -- !");
            System.out.println("\n2- Çuha Ormanı -- !");
            System.out.println("\n3- Anemon Dağı  -- !");
            System.out.println("\n4- Sınır  -- !");
            System.out.println("\n5 -Envanteri Görüntüle -- !");
            System.out.println("\nLütfen gitmek istediğiniz bölgeyi seçiniz : ");

            int selection = input.nextInt();

            // ASAGIDAKİ İFADELERDE POLİMORFİZM İLKESİ KULLANILIYOR.ORTAK BİR NESNEDEN ALTINDAKİ NESNELERİ OLUŞTURUYORUZ
            switch (selection) {

                case 0:
                    location = new Quit(player);
                    return true;
                case 1:
                    location = new Coastal_Zone(player);
                    break;
                case 2:
                    location = new Cuha_Forest(player);
                    break;
                case 3:
                    location = new Anemon_Mount(player);
                    break;
                case 4:
                    location = new CityBorder(player);
                    break;
                case 5:
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
