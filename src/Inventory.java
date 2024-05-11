import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Inventory {
    private Weapon weapon;
    private Armors armor;

    private List<Weapon> weaponList;
    private List<Armors> armorList;

    private List<Awards> awardsList;
    private List<Letters> lettersList;
    private List<Potions> potionsList;
    private ArrayList<Weapon> weapon_section;// en fazla 2 silah alınabilsin

    private ArrayList<Armors> armors_section;// en fazla 2 zırh alınabilsin

    private ArrayList<Awards> award_section;

    private Awards awards;
    public Inventory() {
        this.weapon=new Weapon("Yumruk", 0, 1, 0, 0);
        this.armor=new Armors("Yok", 0, 0, 0, 0,0);
        this.weaponList=new ArrayList<Weapon>();
        this.armorList=new ArrayList<Armors>();
        this.awardsList=new ArrayList<Awards>();// ENVANTER İÇİN
        this.lettersList=new ArrayList<Letters>();
        this.potionsList=new ArrayList<Potions>();
        this.armors_section=new ArrayList<Armors>();
        this.weapon_section=new ArrayList<Weapon>();
        this.award_section=new ArrayList<Awards>();
    }

    public List<Letters> getLettersList() {
        return lettersList;
    }

    public void addLetter(Letters letter){
        lettersList.add(letter);
    }
    public void setLettersList(List<Letters> lettersList) {
        this.lettersList = lettersList;
    }






    public List<Awards> getAwardsList() {
        return awardsList;
    }

    public void addAward(Awards award) {
        awardsList.add(award);
    }

    // arraylistteki ödülleri kontrol et ve 0 ise direkt ekle,0'dan fazla ise o ödülün olduğu indeksi bul ve
    public void setCountAwardList(int award_number,String name){
        for (Awards award : awardsList) {
            if(award!=null){
                if(award.getName().equals(name)){
                    award.setCount(award_number);

                }
            }
        }
    }
    public int FindCount(String awardName){
        int target_award_count=0;
        Awards arananAward = Awards.getAwardObjByName(awardName);
        for (int i = 0; i < getAwardsList().size(); i++) {
            Awards award = getAwardsList().get(i); // ArrayList'ten öğeyi al

            // Öğenin istenen özelliğe sahip olup olmadığını kontrol et
            if (award.getName().equals(awardName)) {
                target_award_count=award.getCount();

                break; // Aranan ödülü bulduğumuzda döngüden çık
            }
        }
        return target_award_count;
    }
    public Awards searchAward(String awardName){
        int aranan_id =-1;
        Awards arananAward = Awards.getAwardObjByName(awardName);
        for (int i = 0; i < getAwardsList().size(); i++) {
            Awards award = getAwardsList().get(i); // ArrayList'ten öğeyi al

            // Öğenin istenen özelliğe sahip olup olmadığını kontrol et
            if (award.getName().equals(awardName)) {
                aranan_id = i;
                break; // Aranan ödülü bulduğumuzda döngüden çık
            }
        }
        if(aranan_id!=(-1)){return getAwardsList().get(aranan_id);}
        else{return null;}
    }
    public void deleteAward(String awardName){
        int aranan_id =0;
        Awards silinecek_award = Awards.getAwardObjByName(awardName);
        for (int i = 0; i < getAwardsList().size(); i++) {
            Awards award = getAwardsList().get(i); // ArrayList'ten öğeyi al

            // Öğenin istenen özelliğe sahip olup olmadığını kontrol et
            if (award.getName().equals(awardName)) {
                aranan_id = i;
                break; // Aranan ödülü bulduğumuzda döngüden çık
            }
        }
        this.getAwardsList().remove(aranan_id);
    }

    public Letters searchLetter(int letterId) {
        for (int i = 0; i < getLettersList().size(); i++) {
            Letters letter = getLettersList().get(i);
            if (letter.getId()==letterId) {
                return letter;
            }
        }
        return null; // Aranan mektup bulunamazsa null döndür
    }

    public void deleteLetter(int letterId) {
        for (int i = 0; i < getLettersList().size(); i++) {
            Letters letter = getLettersList().get(i);
            if (letter.getId()==letterId) {
                getLettersList().remove(i);
                return; // Harf bulundu ve silindi, metodu sonlandır
            }
        }
    }


    public void addPotion(Potions potion){
        potionsList.add(potion);
    }
    public void setCountPotionList(int potion_number,String name){

        for (Potions potion : potionsList) {
            if(potion!=null){
                if(potion.getName().equals(name)){
                    potion.setCount(potion_number);
                }
            }
        }
    }

    public List<Potions> getPotionsList() {
        return potionsList;
    }





    public ArrayList<Weapon> getWeapon_section() {
        return weapon_section;
    }


    public void setWeapon_section(ArrayList<Weapon> weapon_section) {
        this.weapon_section = weapon_section;
    }


    public ArrayList<Armors> getArmors_section() {
        return armors_section;
    }

    public void setArmors_section(ArrayList<Armors> armors_section) {
        this.armors_section = armors_section;
    }

    public ArrayList<Awards> getAward_section() {
        return award_section;
    }

    public void setAward_section(ArrayList<Awards> award_section) {
        this.award_section = award_section;
    }
    public void setCountAwardSection(int award_number,String name){
        for (Awards award : award_section) {
            if(award!=null){
                if(award.getName().equals(name)){
                    award.setCount(award_number);

                }
            }
        }
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public Armors getArmor() {
        return armor;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void setArmor(Armors armor) {
        this.armor = armor;
    }

    public List<Weapon> getWeaponList() {
        return weaponList;
    }

    public void setWeaponList(List<Weapon> weaponList) {
        this.weaponList = weaponList;
    }

    public List<Armors> getArmorList() {
        return armorList;
    }

    public void setArmorList(List<Armors> armorList) {
        this.armorList = armorList;
    }
}
