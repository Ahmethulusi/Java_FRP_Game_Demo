import java.util.ArrayList;
import java.util.List;

public class TalkWithSakai extends NormalLoc{
    public TalkWithSakai(Player player) {
        super(player, "Sakai");
    }

    @Override
    public boolean onLocatin() {
        int targetawardcount = 0;



            System.out.println("Sakai ile konuşmak için (E)'ye bas.");
            String talk = input.next().toUpperCase();

            if (talk.equals("E")) {
                for (Awards award : this.getPlayer().getInventory().getAwardsList()) {
                    if (award != null) {
                        if (award.getName().equals("Kayıp Kolye")) {
                            this.getPlayer().setKolye_flag(true);
                        }
                    }
                }
                if(!getPlayer().isKolye_flag()){
                    System.out.println("SAKAİ: Yüce tanrım! Şükürler olsun yeniden karşılaşabildik GameChar.Omeron. Biraz daha geç gelsen zarif bedenim o çukurda kemirgenlere ziyafet çektirebilirdi. Sana bir hayat borçluyum.\n" +
                            "\n" +
                            "OMERON: Önemli değil dostum. iyi görünüyorsun. Kemirgenler biraz daha bekleyebilir. Senin için yapabileceğim bir şey var mı?\n" +
                            "\n" +
                            "SAKAİ: Sevgili eşimi kaybettiğimden beri hatırasını yanımdan ayırmıyordum. Yalnızca aldığım darbeyi hatırlıyorum,\nsonrasında kendimden geçmişim ve gözlerimi açtığımda..Gözlerimi açtığımda o çukurdaydım. Kolyeyi baygınken düşürmüş olmalıyım.\n" +
                            "\n");
                    System.out.println("Devam etmek için (D) ye bas !");
                    String ContinueKey = input.next().toUpperCase();
                    if(ContinueKey.equals("D")){
                        System.out.println("\nOMERON: Kolyeyi bulmamı mı istiyorsun Sakai?\n" +
                                "\n" +
                                "SAKAİ: Hayatımı kurtardın GameChar.Omeron. Benim için yaptığın bu kadar şeyden sonra senden iyiliklerin bir yenisini istemek bana acı veriyor.\nAma ben yapamam dostum. Tüm bunların tekrar yaşanmasından korkuyorum.\n");
                    }

                }

                if (getPlayer().isKolye_flag()) {
                         System.out.println("OMERON: Sakai işte kolyen.\n" +
                                 "\n" +
                                 "SAKAİ: Yüce tanrım! Onu nerede buldun.\n" +
                                 "\n" +
                                 "OMERON: Bir yaratık ona sahip çıkmış. Gerçi ona da yakıştığını söyleyemeceğim. Geri vermek istemedi. Onu biraz incitmiş olabilirim. \n" +
                                 "\n" +
                                 "SAKAİ: Teşekkür ederim GameChar.Omeron. Sana sonsuz minnet duyuyorum dostum. Sana verebilecek hiç bir kuruşum yok.\nBenim için yaptıkların yanında hiç bir değeri olmasa da lütfen bu kabzayı kabul et.(+1 GÜMÜŞ KABZA)\n" +
                                 "\n");
                         ArrayList<Awards> toRemove = new ArrayList<>();

                        for (Awards award : this.getPlayer().getInventory().getAwardsList()) {
                            if (award != null && award.getName().equals("Kayıp Kolye")) {
                                toRemove.add(award);
                            }
                        }

                        // Kaldırılacak öğeleri asıl listeden kaldır
                        this.getPlayer().getInventory().getAwardsList().removeAll(toRemove);
                        if (!this.getPlayer().getInventory().getAwardsList().contains(Awards.getAwardObjByName("Gümüş Kabza"))) {
                            this.getPlayer().getInventory().getAwardsList().add(Awards.getAwardObjByName("Gümüş Kabza"));
                            this.getPlayer().getInventory().setCountAwardList(1, "Gümüş Kabza");
                        } else {
                            for (Awards award : this.getPlayer().getInventory().getAwardsList()) {
                                if (award != null) {
                                    if (award.getName().equals("Gümüş Kabza")) {
                                        targetawardcount = award.getCount();
                                    }
                                }
                                int new_count = targetawardcount + 1;
                                this.getPlayer().getInventory().setCountAwardList(new_count, "Gümüş Kabza");
                            }
                        }
                        System.out.println("Geri dönmek için Q ya bas");
                        String talk2 = input.next().toUpperCase();

                        if (talk2.equals("Q")) {
                            return true;
                        }
                    }else{

                            System.out.println("Geri dönmek için Q ya bas");
                            String talk3 = input.next().toUpperCase();

                            if (talk3.equals("Q")) {
                                return true;
                            }
                        }


            }
        return true;

    }

}
