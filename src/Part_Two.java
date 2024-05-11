public class Part_Two extends Location{
    public Part_Two(Player player) {
        super(player, "Bölüm 2");
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
            System.out.println("\n1- Toy Limanı - !");
            System.out.println("\n2- Cüce Kenti -- !");
            System.out.println("\n3- Trimara Kalesi  -- !");
            System.out.println("\n4 -Envanteri Görüntüle -- !");
            System.out.println("\nLütfen gitmek istediğiniz bölgeyi seçiniz : ");

            int selection = input.nextInt();

            switch (selection) {

                case 0:
                    location = new Quit(player);
                    return true;
                case 1:
                    location = new Harbour(player);
                    break;
                case 2:
                    location = new Dwarf_City(player);
                    break;
                case 3:
                    location =new  Trimara_Castle(player);
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
