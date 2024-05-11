import java.util.Enumeration;
import java.util.Scanner;
public class Game {
    private Scanner input= new Scanner(System.in);
    public void start(){
        Player player = new Player();
        System.out.println(player.ANSI_GREEN+"\n\n\n\n\n\n\n\nWhat is Lorem Ipsum?\n" +
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s," +
                "\nWhen an unknown printer took a galley of type and scrambled it to make a type specimen book.\n");
        System.out.println("\n  Devam etmek için (D) ye bas !"+player.ANSI_RESET);
        String devam = input.next().toUpperCase();
        if(devam.equals("D")) {
            System.out.println("\n\nIt has survived not only five centuries, but also the leap into electronic typesetting,\n" +
                    "Remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages," +
                    "\nand more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum\n");
        }
        System.out.println("\nDevam etmek için d ye bas");
        do{ // Eğer kullanıcı boşluk girmeden bir şeyler yazdıysa, tekrar giriş iste
            String giris = input.next().toUpperCase(); // Kullanıcının girişini al
            if(giris.equals("D"))break;
            System.out.println("Geçersiz giriş. Devam etmek için sadece d'ye basın.");
        }while(true);
        System.out.println("Devam ediliyor...");
        Location location = null;
        player.makeInit();

        while(true) {

            System.out.println("\n\n\n\n\n\n\n\n----------------");
            player.printInfo();
            System.out.println("----------------");
            System.out.println("########### Bölgeler ###########");
            System.out.println("\n0- Çıkış yap --> Oyundan çıkarsanız bir daha en baştan başlarsınız ! ");
            System.out.println("\n1- Anemon (Bölüm-1)-- !");
            System.out.println("\n2- Trimaran (Bölüm-2)-- !");
            System.out.println("\n3- Saron (Bölüm-3) -- !");
            System.out.println("\n4 -Envanteri Görüntüle -- !");
            System.out.println("\nLütfen gitmek istediğiniz bölgeyi seçiniz : ");
            int selection = input.nextInt();
            System.out.println("\n\n\n\n\n\n\n\n");

            // ASAGIDAKİ İFADELERDE POLİMORFİZM İLKESİ KULLANILIYOR.ORTAK BİR NESNEDEN ALTINDAKİ NESNELERİ OLUŞTURUYORUZ
            switch (selection) {

                case 0:
                    System.out.println("Oyundan çıkış yapılıyor...");
                    System.exit(0);
                    break;
                case 1:
                    location = new Part_One(player);
                    break;
                case 2:
                    location = new Part_Two(player);
                    break;
                case 3:
                    location = new Part_Three(player);
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
            if(player.getHealth()<=0){
                System.out.println("GAME OVER");
                System.exit(0);
                break;
            }

        }
    }
}
