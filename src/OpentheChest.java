import java.util.ArrayList;
import java.util.List;

public class OpentheChest extends NormalLoc {

    /// Sandıkta 2 tane silah iki tan zırh ve çeşit farketmeksizin toplam 10 tane item saklanabilecek

    public OpentheChest(Player player) {
        super(player, "Sandık");
    }

    @Override
    public boolean onLocatin() {
        while (true) {

            System.out.println("\n######### ENVANTER #########");
            displayInventory(getPlayer());
            System.out.println("\n######### SANDIK #########\n");
            displayChest(getPlayer());
            System.out.println("\n");
            System.out.println("Eşya transferi için T'ye /Çıkış için Q'ya basın.");

            String choose = input.next().toUpperCase();
            if (choose.equals("T")) {
                while (true) {
                    System.out.println("Transfer nereden nereye ?\n(Envanterden Sandığa->E)/(Sandıktan Envantere->S)/((Q)=>Çıkış)");
                    String choose2 = input.next().toUpperCase();
                    if (choose2.equals("E")) {
                        boolean quit_flag = true;
                        while (quit_flag) {

                            System.out.println("Aktarılacak eşyayı seçin");
                            System.out.println("Silah(S) / Zırh(Z) / Eşya(E)/(Q)=>Çıkış)");
                            String choose_obj = input.next().toUpperCase();
                            switch (choose_obj) {
                                case "S":
                                    printWeapons_two();
                                    break;
                                case "Z":
                                    printArmors_two();
                                    break;
                                case "E":
                                    printItems_two();
                                    break;
                                case "Q":
                                    quit_flag = false;
                                    break;
                            }
                        }

                    } else if (choose2.equals("S")) {
                        boolean quit_flag = true;
                        while (quit_flag) {

                            System.out.println("Aktarılacak eşyayı seçin");
                            System.out.println("Silah(S) / Zırh(Z) / Eşya(E)/(Q)=>Çıkış)");
                            String choose_obj = input.next().toUpperCase();
                            switch (choose_obj) {
                                case "S":
                                    printWeapons_three();
                                    break;
                                case "Z":
                                    printArmors_three();
                                    break;
                                case "E":
                                    printItems_three();
                                    break;
                                case "Q":
                                    quit_flag = false;
                                    break;
                            }
                        }

                    } else if (choose2.equals("Q")) {
                        break;
                    } else {
                        System.out.println("Geçersiz karakter , tekrar dene !");
                    }
                }
            } else if (choose.equals("Q")) {
                break;
            } else {
                System.out.println("Geçersiz karakter , tekrar dene !");

            }
        }

        return true;
    }

    boolean quit_flag = true;

    public void displayInventory(Player player) {
        System.out.println("\n" + this.getPlayer().getInventory().getWeapon().getId() + "- Silah : " + this.getPlayer().getInventory().getWeapon().getName() + " ," +
                "\t Level :     " + this.getPlayer().getInventory().getWeapon().getLevel() +
                "\n" + this.getPlayer().getInventory().getArmor().getId() + "- Zırh : " + this.getPlayer().getInventory().getArmor().getName() + " ," +
                "\t Level : " + this.getPlayer().getInventory().getArmor().getLevel());
    }

    public void displayChest(Player player) {
        ArrayList<Weapon> weapon_section = getPlayer().getInventory().getWeapon_section();
        if (weapon_section != null) {
            if (weapon_section.isEmpty()) {
                System.out.println("Sandıkta herhangi bir silah yok !");
            } else {
                for (Weapon weapon : weapon_section) {
                    System.out.println(weapon.getName());
                }
            }
        }
        ArrayList<Armors> armor_section = getPlayer().getInventory().getArmors_section();
        if (armor_section != null) {
            if (armor_section.isEmpty()) {
                System.out.println("Sandıkta herhangi bir zırh yok !");
            } else {
                for (Armors armor : armor_section) {
                    System.out.println(armor.getName());
                }
            }
        }
        ArrayList<Awards> award_section = getPlayer().getInventory().getAward_section();
        if (award_section != null) {
            if (award_section.isEmpty()) {
                System.out.println("Sandıkta herhangi bir eşya yok !");
            } else {
                for (Awards award : award_section) {
                    System.out.println(award.getName() + " x " + award.getCount());
                }
            }
        }
    }

    public void printWeapons_two() {
        System.out.println("------Silahlar------");
        System.out.println();
        List<Weapon> liste = getPlayer().getInventory().getWeaponList();

        // Eğer listede silah yoksa mesaj göster ve metodu sonlandır
        if (liste.isEmpty()) {
            System.out.println("Envanterinizde hiç silah bulunmuyor.");
            return;
        }

        for (Weapon w : liste) {
            System.out.println(w.getId() + " - " + w.getName());
        }
        System.out.println("Hangisini bırakmak istiyorsun ?/ Hepsi için (0)");
        int secim = input.nextInt();
        if (secim == 0) {
            for (Weapon w : liste) {
                getPlayer().getInventory().getWeapon_section().add(w);
            }
        } else {
            Weapon eklenecek_silah = Weapon.getWeaponObjById(secim);
            getPlayer().getInventory().getWeapon_section().add(eklenecek_silah);
            for (Weapon w : liste) {
                if (w.getName().equals(eklenecek_silah.getName())) {
                    liste.remove(w);
                    break;
                }
            }
            if (eklenecek_silah != null) {
                System.out.println(eklenecek_silah.getName() + "sandığa bırakıldı !");
            }
        }
    }

    public void printArmors_two() {
        System.out.println("------Zırhlar------");
        System.out.println();
        List<Armors> liste = getPlayer().getInventory().getArmorList();
        if (liste.isEmpty()) {
            System.out.println("Envanterinizde hiç zırh bulunmuyor !");
            return;
        }
        for (Armors a : liste) {
            System.out.println(a.getId() + " - " + a.getName());
        }
        System.out.println("Hangisini bırakmak istiyorsun ?/ Hepsi için (0)");
        int secim = input.nextInt();
        if (secim == 0) {
            for (Armors a : liste) {
                getPlayer().getInventory().getArmors_section().add(a);
                liste.remove(a);

            }
        } else {
            Armors eklenecek_zirh = Armors.getArmObjById(secim);
            getPlayer().getInventory().getArmors_section().add(eklenecek_zirh);
            for (Armors a : liste) {
                if (a.getName().equals(eklenecek_zirh.getName())) {
                    liste.remove(a);
                    break;
                }
            }
            if (eklenecek_zirh != null) {
                System.out.println(eklenecek_zirh.getName() + " sandığa bırakıldı !");
            }
        }
    }

    public void printWeapons_three() {
        if (!this.getPlayer().getInventory().getWeapon_section().isEmpty() && this.getPlayer().getInventory().getWeaponList().size() < 2) {
            List<Weapon> weaponsToRemove = new ArrayList<>();
            for (Weapon weapon : getPlayer().getInventory().getWeapon_section()) {
                System.out.println(weapon.getId() + " - " + weapon.getName());
            }
            System.out.println("Envantere almak istediğiniz silahı seçin");
            int selection = input.nextInt();
            for (Weapon weapon : getPlayer().getInventory().getWeapon_section()) {
                if (weapon.getId() == selection) {
                    weaponsToRemove.add(weapon); // Kaldırılacak silahı geçici bir liste içine ekleyin
                    this.getPlayer().getInventory().getWeaponList().add(weapon);
                    System.out.println(weapon.getName() + " envanterinize alındı !");
                }
            }
            // Geçici listedeki silahları orijinal listeden kaldırın
            this.getPlayer().getInventory().getWeapon_section().removeAll(weaponsToRemove);
        } else if (this.getPlayer().getInventory().getWeaponList().size() > 1) {
            System.out.println("Envanterde max 2 silah taşıyabilirsiniz !");
        } else {
            System.out.println("Envanterde herhangi bir silah yok !");
        }
    }

    public void printArmors_three() {
        List<Armors> armorsToRemove = new ArrayList<>();
        if (!this.getPlayer().getInventory().getArmors_section().isEmpty() && this.getPlayer().getInventory().getArmorList().size() < 2) {
            for (Armors armor : getPlayer().getInventory().getArmors_section()) {
                System.out.println(armor.getId() + " - " + armor.getName());
            }
            System.out.println("Envantere almak istediğiniz zırhı seçin");
            int selection = input.nextInt();
            for (Armors armor : getPlayer().getInventory().getArmors_section()) {
                if (armor.getId() == selection) {
                    armorsToRemove.add(armor); // Kaldırılacak zırhı geçici bir liste içine ekleyin
                    this.getPlayer().getInventory().getArmorList().add(armor);
                    System.out.println(armor.getName() + " envanterinize alındı !");
                }
            }
            // Geçici listedeki zırhları orijinal listeden kaldırın
            this.getPlayer().getInventory().getArmors_section().removeAll(armorsToRemove);
        } else if (this.getPlayer().getInventory().getArmorList().size() > 1) {
            System.out.println("Envanterde max 2 silah taşıyabilirsiniz !");
        } else {
            System.out.println("Envanterde herhangi bir zırh yok !");
        }
    }

    public void printItems_two() {
        int targetawardcount = 0;
        if (getPlayer().getInventory().getAwardsList() != null) {
            for (Awards award : getPlayer().getInventory().getAwardsList()) {
                System.out.println(award.getId() + " - " + award.getName() + "x" + award.getCount());
            }
        }
        System.out.println("Seçmek istediğiniz eşyanın ID'sini girin:");
        System.out.println("(0) => Geri !");
        int choose = input.nextInt();
        List<Awards> copyList = new ArrayList<>(getPlayer().getInventory().getAwardsList());
        for (Awards award : copyList) {
            if (award.getId() == choose) {
                System.out.println("Kaç tane bırakmak istiyorsunuz ?");
                int count_selection = input.nextInt();
                if (getPlayer().getInventory().getAward_section() != null) {
                    for (Awards referance_award : getPlayer().getInventory().getAward_section()) {
                        if (referance_award.getId() == award.getId()) {
                            targetawardcount = referance_award.getCount();
                        }
                    }
                    int new_count = award.getCount() - count_selection;
                    if (new_count > 0) {
                        award.setCount(new_count);
                        if (targetawardcount == 0) {
                            Awards will_add_award = Awards.getAwardObjById(award.getId());
                            will_add_award.setCount(count_selection);
                            this.getPlayer().getInventory().getAward_section().add(will_add_award);
                            System.out.println(count_selection + " tane " + award.getName() + " sandığa eklendi");
                        } else {
                            int new_count_for_chest = targetawardcount + count_selection;
                            this.getPlayer().getInventory().setCountAwardSection(new_count_for_chest, award.getName());
                            System.out.println(count_selection + " tane " + award.getName() + " sandığa eklendi");
                        }
                    } else if (new_count == 0) {
                        this.getPlayer().getInventory().getAwardsList().remove(award);
                        if (targetawardcount == 0) {
                            Awards will_add_award = Awards.getAwardObjById(award.getId());
                            will_add_award.setCount(count_selection);
                            this.getPlayer().getInventory().getAward_section().add(will_add_award);
                            System.out.println(count_selection + " tane " + award.getName() + " sandığa eklendi");
                        } else {
                            int new_count_for_chest = targetawardcount + count_selection;
                            this.getPlayer().getInventory().setCountAwardSection(new_count_for_chest, award.getName());
                            System.out.println(count_selection + " tane " + award.getName() + " sandığa eklendi");
                        }
                    } else {
                        System.out.println("Yetersiz miktar ! Stokta yeterince " + award.getName() + " yok.");
                    }
                }
            }

        }
    }

    public void printItems_three() {
        if (!this.getPlayer().getInventory().getAward_section().isEmpty()) {
            System.out.println("Çıkarılacak eşyalar:");
            for (Awards award : this.getPlayer().getInventory().getAward_section()) {
                System.out.println(award.getId() + " - " + award.getName() + " x" + award.getCount());
            }
            System.out.println("Seçmek istediğiniz eşyanın ID'sini girin:");
            System.out.println("(0) => Geri !");
            int selection = input.nextInt();
            System.out.println("Kaç tane almak istediğinizi seçin");
            int count_selection = input.nextInt();

            Awards awardToRemove = null;
            for (Awards award : this.getPlayer().getInventory().getAward_section()) {
                if (award.getId() == selection) {
                    awardToRemove = award;

                }
            }
            if (awardToRemove != null) {
                int targetawardcount = 0;

                int index_of_award = 0;
                if (awardToRemove.getCount() > 1) {
                    this.getPlayer().getInventory().setCountAwardSection(awardToRemove.getCount() - count_selection, awardToRemove.getName());
                    if (this.getPlayer().getInventory().getAwardsList().contains(awardToRemove)) {
                        for (Awards award : getPlayer().getInventory().getAwardsList()) {
                            index_of_award++;
                            if (award.getId() == awardToRemove.getId()) {
                                targetawardcount = award.getCount();
                                break;
                            }
                        }
                        if (targetawardcount == 0) {
                            Awards will_adding = Awards.getAwardObjById(awardToRemove.getId());
                            this.getPlayer().getInventory().getAwardsList().add(will_adding);
                        } else {
                            this.getPlayer().getInventory().setCountAwardList(targetawardcount + count_selection, awardToRemove.getName());
                        }
                    }
                    System.out.println(awardToRemove.getName() + " envanterinize alındı !");
                } else {
                    this.getPlayer().getInventory().getAward_section().remove(awardToRemove);
                    if (this.getPlayer().getInventory().getAwardsList().contains(awardToRemove)) {
                        for (Awards award : getPlayer().getInventory().getAwardsList()) {
                            index_of_award++;
                            if (award.getId() == awardToRemove.getId()) {
                                targetawardcount = award.getCount();
                                break;
                            }
                        }
                        if (targetawardcount == 0) {
                            Awards will_adding = Awards.getAwardObjById(awardToRemove.getId());
                            this.getPlayer().getInventory().getAwardsList().add(will_adding);
                        } else {
                            this.getPlayer().getInventory().setCountAwardList(targetawardcount + count_selection, awardToRemove.getName());
                        }
                    }
                }
                this.getPlayer().getInventory().getAwardsList().add(awardToRemove);

            } else {
                System.out.println("Geçersiz seçim, eşya bulunamadı !");
            }
        } else {
            System.out.println("Sandığınız boş !");
        }

    }
}

