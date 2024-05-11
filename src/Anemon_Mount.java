
class MountainTop extends BattleLoc{
    public MountainTop(Player player) {
        super(player, "Zirve",new Kral_Yeti(), "Donmuş Yürek",50, true);
    }
}
class Kral_Yeti extends Enemy{
    public Kral_Yeti() {
        super(6,"Kral Yeti",10,80,"Kayıp Kolye",50);
    }
}
class Monster_Nest extends BattleLoc{
    public Monster_Nest(Player player) {
        super(player,"Canavar Yuvası",new Mount_Monster(),"Donmuş Yürek",0,true);
    }
}
class Mount_Monster extends Enemy{
    public Mount_Monster() {
        super(10, "Mistik Dağ Canavarı", 40, 50, "Mistik Diş", 30);
    }
}
class Mine extends BattleLoc {
    public Mine(Player player) {
        super(player,"Maden",new Mine_Enemy(),"Yakut",30,true);
    }
}
class Mine_Enemy extends Enemy{
    public Mine_Enemy() {
        super(8,"Maden Yeti",15,10,"Zindan Anahtarı",0);
    }
}

class InsideOfTheMountain extends Location{

    public InsideOfTheMountain(Player player) {
        super(player,"Dağın İçi");
    }

    @Override
    public boolean onLocatin() {
        Side_Task_Choose(this.getPlayer());
        return true;
    }

    public boolean Side_Task_Choose(Player player) {
        Location location = null;
        Quit quit = new Quit(player);
        while(true){
            if(getPlayer().isEnemy_camp7_flag()){
                if(!getPlayer().isSide_task1()){
                    System.out.println("Mahkumları kurtarmak için (E) ye bas !");
                    System.out.println("Diğer yoldan  devam etmek için (D) ye bas");
                    String selection = input.next().toUpperCase();
                    if(selection.equals("E")){

                        System.out.println("Zindandan Goro , Sakai ve Cüce Durin  adında 3 mahkum kurtardın,Goro kıyı çarşısına gitmek istedi,\nCüce Durin de kendi şehrine doğru yola çıktı.Sakai'yi de  kampına götürdün artık onunla birlikte yaşayacaksın ");
                        for (Awards award : this.getPlayer().getInventory().getAwardsList()) {
                            if (award != null) {
                                if (award.getName().equals("Zindan Anahtarı")) {
                                    this.getPlayer().setEnemy_camp7_flag(false);
                                    this.getPlayer().getInventory().getAwardsList().remove(award);
                                }
                            }
                        }
                        while(true){
                            System.out.println("Geri dönmek için Q'ya bas.");
                            String choose = input.next().toUpperCase();
                            if(choose.equals("Q"))
                                break;
                            else{
                                continue;
                            }
                        }
                        break;
                    }else{
                        location = new Monster_Nest(player);
                    }
                }else{
                    System.out.println("Biraz ilerledin ve 2 farklı yol çıktı birinde kullanılmayan eski bir maden keşfettin,bakmak ister misin ?(E) ");
                    System.out.println("Diğer yoldan  devam etmek için (D) ye bas");
                }
            }else{
                System.out.println("Maden temizlendi ,mahkumlar kurtarılmış yoluna devam etmek için (D) ye bas.");
            }
            String selection = input.next().toUpperCase();
            if(selection.equals("E")){
                location = new Mine(player);
            }else{
                location = new Monster_Nest(player);
            }

            if(!location.onLocatin()) {
                System.out.println("GAME OVER");
                System.out.println("Lütfen geçerli bir değer giriniz !");
            }
            break;
        }
        return  true;
    }
}


class Mount_Foothills extends BattleLoc{
    public Mount_Foothills(Player player) {
        super(player,"Dağ girişi",new Mount_bandit(),"Donmuş Yürek",0,true);
    }
}
class Mount_bandit extends Enemy {
    public Mount_bandit() {
        super(5, "Dağ Haydutu",7, 25 ,"Yaşam Meyvesi", 15);
    }
}

public class Anemon_Mount extends Location{
    public Anemon_Mount(Player player) {
        super(player, "Anemon Dağı");
    }
    //  Anemon dağının eteği olacak,iç kısmı,ve zirvesi olacak şekilde 3 bölümden oluşacak,
    // Etekte terk edilmiş bir kasaba olacak,burada dağ haydutu çıkacak,içindede bazı dağın koruyucusu olarak adlandırılan tehlikeli yaratıklar olacak
    // Zirve kısmında da esir tutulan bazı tutsaklar olacak , bunları kurtarmak için zindan bekçileriyle savaşmamız gerekiyor ama
    // bizim tercihimize kalmış olacak eğer kurtarısak o tutsaklardan bir tanesi güvenli kampa spawn olacak ve bize yeni bir yan görev verebilecek.
    @Override
    public boolean onLocatin() {
        Go_Mount(this.getPlayer());
        return true;
    }

    public boolean Go_Mount(Player player) {
        Location location = null;
        Quit quit = new Quit(player);
        while(true){
            System.out.println("1 - Dağ eteğindeki terkedilmiş kasabayı kontrol et .");
            if(this.getPlayer().isSide_task1()){
                System.out.println("2 - Dağın içine gir");
            }else{
                System.out.println("2 - Dağın içindeki yoldan devam et ");
            }
            System.out.println("3 - Dağın zirvesine doğru tırman.");
            System.out.println("4 - Geri dön");
            System.out.println("Seç : ");
            int selection = input.nextInt();
            switch (selection) {
                case 1:
                    location = new Mount_Foothills(player);
                    break;
                case 2:
                    location = new InsideOfTheMountain(player);
                    break;
                case 3:
                    location = new MountainTop(player);
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
                System.out.println("Lütfen geçerli bir değer giriniz !");
                break;
            }
        }
        return  true;
    }
}
