import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class input {
    static Scanner inp;
    input() {
        inp=new Scanner(System.in);
    }
}

class Game{

    ArrayList<Integer> fight_level(int count, ArrayList<Integer> levels){
        int level_count=0;
        int[] location = {0, 4, 8};
        location[0]+=(count);
        location[1]+=(count);
        location[2]+=(count);
        if(levels.size()==0){
            System.out.println("You are at the starting location. Choose path:");
        }
        else{
            System.out.println("You are at location "+ levels.get(levels.size()-1)+" Choose path");
        }
        System.out.println("1) Go to Location "+location[0]);
        System.out.println("2) Go to Location "+location[1]);
        System.out.println("3) Go to Location "+location[2]);
        if(levels.size()>0){
            System.out.println("Go back");
        }
        System.out.println("Enter -1 to exit");
        int choice1 = input.inp.nextInt();
        if(choice1==-1){
            levels.add(-1);
            return levels;
        }
        else if(choice1==1){
            System.out.println("Moving to location "+location[0]);
            levels.add(location[0]);
        }
        else if(choice1==2){
            System.out.println("Moving to location "+location[1]);
            levels.add(location[1]);
        }
        else if(choice1==3){
            System.out.println("Moving to location "+location[2]);
            levels.add(location[2]);
        }
        else if(choice1==4){
            System.out.println("Moving to location "+levels.get(levels.size()-1));
            levels.add(levels.get(levels.size()-1));
        }
        return levels;
    }

    void start(){
        ArrayList<Hero> hero = new ArrayList<>();
        String avatar="";
        while(true){
            System.out.println("Welcome to ArchLegends");
            System.out.println("Choose your Option");
            System.out.println("1) New User");
            System.out.println("2) Existing User");
            System.out.println("3) Exit");
            int choice = input.inp.nextInt();
            if(choice==1){
                System.out.println("Enter Username");
                String name = input.inp.next();
                Hero h = new Hero(name);
                hero.add(h);
                System.out.println("Choose a Hero");
                System.out.println("1) Warrior");
                System.out.println("2) Thief");
                System.out.println("3) Mage");
                System.out.println("4) Healer");
                int val = input.inp.nextInt();
                if(val==1)
                    avatar="warrior";
                else if(val==2)
                    avatar="thief";
                else if(val==3)
                    avatar="mage";
                else
                    avatar="healer";
                System.out.println("User Creation done. Username: "+name+" Hero type: "+avatar+" Log in to play the game . Exiting");
            }
            else if(choice==2){
                System.out.println("Enter Username");
                String name = input.inp.next();
                int flag=-1;
                Hero h=hero.get(0);
                for(int i=0;i<hero.size();i++){
                    h = hero.get(i);
                    if(h.getUsername().equals(name)){
                        flag=1;
                        break;
                    }
                }
                if(flag==-1){
                    System.out.println("Username not Found");
                }
                else{
                    ArrayList<Integer> levels = new ArrayList<>();
                    System.out.println("User Found... logging in");
                    System.out.println("Welcome "+name);
                    if(avatar.equals("warrior")){
                        Warrior warrior = new Warrior(h.getUsername());
                        int count = 0;
                        int level=1;
                        boolean fight_result = true;
                        while(!warrior.boss_fight && fight_result){
                            levels = fight_level(count, levels);
                            if(levels.get(levels.size()-1)==-1){
                                break;
                            }

                            fight_result = warrior.fight(level);
                            count++;
                            int x = levels.remove(levels.size()-1);
                            if(fight_result && !levels.contains(x)){
                                level+=1;
                            }
                            if(levels.contains(x)){
                                count-=2;
                            }
                            levels.add(x);
                        }
                        if(fight_result==false){
                            System.out.println("Battle Lost. Start Again");
                        }
                        else if(warrior.boss_fight && fight_result){
                            System.out.println("Boss Killed");
                        }
                    }
                    else if(avatar.equals("thief")){
                        Thief thief = new Thief(h.getUsername());
                        int count = 0;
                        boolean fight_result = true;
                        int level=1;
                        while(!thief.boss_fight && fight_result) {
                            levels = fight_level(count, levels);
                            if(levels.get(levels.size()-1)==-1){
                                break;
                            }
                            fight_result = thief.fight(level);
                            count++;
                            int x = levels.remove(levels.size()-1);
                            if(fight_result && !levels.contains(x)){
                                level+=1;
                            }
                            if(levels.contains(x)){
                                count-=2;
                            }
                            levels.add(x);
                            System.out.println(levels);
                        }
                        if(fight_result==false){
                            System.out.println("Battle Lost. Start Again");
                        }
                        else if(thief.boss_fight && fight_result){
                            System.out.println("Boss Killed");
                        }
                    }

                    else if(avatar.equals("mage")) {
                        Mage mage = new Mage(h.getUsername());
                        int count = 0;
                        int level=1;
                        boolean fight_result = true;
                        while (!mage.boss_fight && fight_result) {
                            levels = fight_level(count, levels);
                            if(levels.get(levels.size()-1)==-1){
                                break;
                            }
                            fight_result = mage.fight(level);
                            count++;
                            int x = levels.remove(levels.size()-1);
                            if(fight_result && !levels.contains(x)){
                                level+=1;
                            }
                            if(levels.contains(x)){
                                count-=2;
                            }
                            levels.add(x);
                        }
                        if(fight_result==false){
                            System.out.println("Battle Lost. Start Again");
                        }
                        else if(mage.boss_fight && fight_result){
                            System.out.println("Boss Killed");
                        }
                    }
                    else if(avatar.equals("healer")) {
                        Healer healer = new Healer(h.getUsername());
                        int count = 0;
                        int level=1;
                        boolean fight_result = true;
                        while (!healer.boss_fight && fight_result) {
                            levels = fight_level(count, levels);
                            if(levels.get(levels.size()-1)==-1){
                                break;
                            }
                            fight_result = healer.fight(level);
                            count++;
                            int x = levels.remove(levels.size()-1);
                            if(fight_result && !levels.contains(x)){
                                level+=1;
                            }
                            if(levels.contains(x)){
                                count-=2;
                            }
                            levels.add(x);
                        }
                        if(fight_result==false){
                            System.out.println("Battle Lost. Start Again");
                        }
                        else if(healer.boss_fight && fight_result){
                            System.out.println("Boss Killed");
                        }
                    }
                }
            }
            else if(choice==3){
                System.exit(0);
            }
        }
    }
}

abstract class Hero extends User{
    private final String username;
    private int HP;
    private int XP;
    int attack_count=0;
    int level_count=0;
    Hero(){
        this.username="";
        this.HP=100;
        this.XP=0;
    }
    Hero(String name){
        this.username = name;
        this.HP=100;
        this.XP=0;
    }

    public String getUsername() {
        return username;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getXP() {
        return XP;
    }

    public void setXP(int XP) {
        this.XP = XP;
    }

    abstract boolean fight(int l);
    abstract void special_attack();
}

class User{
    private int HP_;
    private int level_;

    public int getHP() {
        return HP_;
    }

    public void setHP(int HP) {
        this.HP_ = HP;
    }

    public int getLevel() {
        return level_;
    }

    public void setLevel(int level) {
        this.level_ = level;
    }
}

class Monster extends Hero{
    double[] monster_HP = {100,150,200,250};

    public void setMonsterhp(int monsterhp) {
        this.monsterhp = monsterhp;
    }

    double monsterhp;
    int[] monster_XP = {20,40,60};
    int monsterxp;
    int level;
    private int monster_level;

    public int getMonster_level() {
        return monster_level;
    }

    Random random = new Random();
    Monster(){
    }

    Monster(int XP, int level){
        super();
        if(XP<20){
            monsterhp=100;
            this.level=1;
            monster_level = 1;
            monsterxp = 20;
        }
        else if(XP<40){
            int rand = random.nextInt(2);
            monsterhp = monster_HP[rand];
            monsterxp = monster_XP[rand];
            this.level=2;
            monster_level=rand+1;
        }
        else if(XP>60 && level>3){
            monsterhp=monster_HP[3];
            monsterxp=4*20;
            this.level=4;
            monster_level=4;
        }
        else{
            int rand = random.nextInt(3);
            monsterhp = monster_HP[rand];
            monsterxp = monster_XP[rand];
            this.level=3;
            monster_level=rand+1;
        }
    }

    int monster_attack(){
        Random random = new Random();
        if(monsterhp<=0){
            return 0;
        }
        Double val = Math.abs(random.nextGaussian());
        while(val>=1){
            val = Math.abs(random.nextGaussian());
        }
//        int attack_range = (int) this.monsterhp/4;
//        int attack_power = random.nextInt(attack_range+1);
        int attack_power = (int)(val * (this.monsterhp/4));
        if (level == 4) {
           int probability = random.nextInt(10);
           if(probability==1){
               attack_power=getHP()/2;
           }
        }
        return attack_power;
    }
}

class Goblins extends Monster{
    private int goblinHP = 100;
    private int xp = 20;

    public int getGoblinHP() {
        return goblinHP;
    }

    public void setGoblinHP(int goblinHP) {
        this.goblinHP = goblinHP;
    }

    public int getXp() {
        return xp;
    }

}

class Zombies extends Monster{
    private int zombieHP = 100;
    private int xp = 40;

    public int getZombieHP() {
        return zombieHP;
    }

    public void setZombieHP(int zombieHP) {
        this.zombieHP = zombieHP;
    }

    public int getXp() {
        return xp;
    }

}

class Fiends extends Monster{
    private int fiendHP = 200;
    private int xp = 60;

    public int getFiendHP() {
        return fiendHP;
    }

    public void setFiendHP(int fiendHP) {
        this.fiendHP = fiendHP;
    }

    public int getXp() {
        return xp;
    }

}

class Lionfang extends Monster{
    private int lionfangHP = 250;

    public int getLionfangHP() {
        return lionfangHP;
    }

    public void setLionfangHP(int lionfangHP) {
        this.lionfangHP = lionfangHP;
    }
}



class Warrior extends Hero{
    private int attack_power=10;
    private int defense_power=-3;
    int attack_count=0;
    boolean boss_fight=false;
    Warrior(String name){
        super(name);
    }

    public int getAttack_power() {
        return attack_power;
    }

    public void setAttack_power(int attack_power) {
        this.attack_power = attack_power;
    }

    public int getDefense_power() {
        return defense_power;
    }

    public void setDefense_power(int defense_power) {
        this.defense_power = defense_power;
    }

    @Override
    void special_attack(){
        setAttack_power(getAttack_power()+5);
        setDefense_power(getDefense_power()-3);
    }
    void unset_special_attack(){
        setAttack_power(getAttack_power()-5);
        setDefense_power(getDefense_power()+3);
    }

    @Override
    boolean fight(int level){
        level_count+=1;
        int XP = getXP();
        Monster monster = new Monster(XP, level);
        System.out.println("Fight Started. You're fighting a level "+monster.getMonster_level()+" monster.");
        if(monster.monsterhp==250){
            boss_fight=true;
        }
        int heroHP= getHP();
        double monsterHP = monster.monsterhp;
        boolean special_attack=false;
        int special_attack_count=0;
        while(getHP()>0 && monster.monsterhp>0){
            System.out.println("Choose Move");
            System.out.println("1) Attack");
            System.out.println("2) Defense");
            if(attack_count>=4){
                System.out.println("3) Special Attack");
            }
            int choice1 = input.inp.nextInt();
            if(choice1==1){
                System.out.println("You Choose to attack");
                System.out.println("You attacked and inflicted "+getAttack_power()+" damage to monster");
                monster.monsterhp-=getAttack_power();
                System.out.println("Your HP:" +getHP()+"/"+heroHP+" Monsters HP: "+monster.monsterhp+"/"+monsterHP);
                if(special_attack){
                    if(special_attack_count==3){
                        unset_special_attack();
                        special_attack=false;
                    }
                    else{
                        special_attack_count+=1;
                    }
                }
                System.out.println("Monster Attack!");
                int monster_attack = monster.monster_attack();
                System.out.println("The monster attacked and inflicted "+ monster_attack+" damage to you");
                setHP(getHP()-monster_attack);
            }
            else if(choice1==2){
                System.out.println("You Choose to defend");
                int attack_power_reduction = getDefense_power();
                System.out.println("Monster attack reduced by "+attack_power_reduction);
                System.out.println("Your HP:" +getHP()+"/"+heroHP+" Monsters HP: "+monster.monsterhp+"/"+monsterHP);
                System.out.println("Monster Attack!");
                int monster_attack = monster.monster_attack()-attack_power_reduction;
                if(monster_attack>0){
                    System.out.println("The monster attacked and inflicted "+ monster_attack+" damage to you");
                    setHP(getHP()-monster_attack);
                }
                else{
                    System.out.println("The monster attacked and inflicted 0 damage to you");
                }
                if(special_attack){
                    if(special_attack_count==3){
                        unset_special_attack();
                        special_attack=false;
                    }
                    else{
                        special_attack_count+=1;
                    }
                }
            }
            else if(choice1==3){
                special_attack();
                special_attack=true;
                this.attack_count=0;
            }
            System.out.println("Your HP:" +getHP()+"/"+heroHP+" Monsters HP: "+monster.monsterhp+"/"+monsterHP);
            this.attack_count+=1;

        }
        this.attack_count = 0;
        if(getHP()>0){
            System.out.println("Monster Killed");
            if(level<=3){
                setHP(heroHP+50);
            }
            System.out.println(monster.monsterxp+"XP Rewarded");
            setXP(getXP()+monster.monsterxp);
            int l = level+1;
            System.out.println("Level UP: level: "+l);
            return true;
        }
        else
            return false;
    }
}

class Mage extends Hero{
    private int attack_power=5;
    private int defense_power=-5;
    int attack_count=0;
    boolean boss_fight=false;

    Mage(String name){
        super(name);
    }

    public int getAttack_power() {
        return attack_power;
    }

    public void setAttack_power(int attack_power) {
        this.attack_power = attack_power;
    }

    public int getDefense_power() {
        return defense_power;
    }

    public void setDefense_power(int defense_power) {
        this.defense_power = defense_power;
    }

    void special_attack(Monster monster){
        monster.monsterhp = monster.monsterhp - (0.05*monster.monsterhp);
    }
    void unset_special_attack(Monster monster){
        monster.monsterhp = monster.monsterhp + (0.05*monster.monsterhp);
    }

    @Override
    boolean fight(int level){
        level_count+=1;
        int XP = getXP();
        Monster monster = new Monster(XP, level);
        System.out.println("Fight Started. You're fighting a level "+monster.getMonster_level()+" monster.");
        if(monster.monsterhp==250){
            boss_fight=true;
        }
        int heroHP= getHP();
        double monsterHP = monster.monsterhp;
        boolean special_attack=false;
        int special_attack_count=0;
        while(getHP()>0 && monster.monsterhp>0){
            System.out.println("Choose Move");
            System.out.println("1) Attack");
            System.out.println("2) Defense");
            if(attack_count>=4){
                System.out.println("3) Special Attack");
            }
            int choice1 = input.inp.nextInt();
            if(choice1==1){
                System.out.println("You Choose to attack");
                System.out.println("You attacked and inflicted "+getAttack_power()+" damage to monster");
                monster.monsterhp-=getAttack_power();
                System.out.println("Your HP:" +getHP()+"/"+heroHP+" Monsters HP: "+monster.monsterhp+"/"+monsterHP);
                if(special_attack){
                    if(special_attack_count==3){
                        unset_special_attack(monster);
                        special_attack=false;
                        special_attack_count = 0;
                    }
                    else{
                        special_attack_count+=1;
                    }
                }
                System.out.println("Monster Attack!");
                int monster_attack = monster.monster_attack();
                System.out.println("The monster attacked and inflicted "+ monster_attack+" damage to you");
                setHP(getHP()-monster_attack);
            }
            else if(choice1==2){
                System.out.println("You Choose to defend");
                int attack_power_reduction = getDefense_power();
                System.out.println("Monster attack reduced by "+attack_power_reduction);
                System.out.println("Your HP:" +getHP()+"/"+heroHP+" Monsters HP: "+monster.monsterhp+"/"+monsterHP);
                System.out.println("Monster Attack!");
                int monster_attack = monster.monster_attack()-attack_power_reduction;
                if(monster_attack>0){
                    System.out.println("The monster attacked and inflicted "+ monster_attack+" damage to you");
                    setHP(getHP()-monster_attack);
                }
                else{
                    System.out.println("The monster attacked and inflicted 0 damage to you");
                }
                if(special_attack){
                    if(special_attack_count==3){
                        unset_special_attack(monster);
                        special_attack=false;
                    }
                    else{
                        special_attack_count+=1;
                    }
                }
            }
            else if(choice1==3){
                special_attack(monster);
                special_attack=true;
                this.attack_count=0;
            }
            System.out.println("Your HP:" +getHP()+"/"+heroHP+" Monsters HP: "+monster.monsterhp+"/"+monsterHP);
            this.attack_count+=1;
        }
        this.attack_count = 0;
        if(getHP()>0){
            System.out.println("Monster Killed");
            if(level<=3){
                setHP(heroHP+50);
            }
            System.out.println(monster.monsterxp+"XP Rewarded");
            setXP(getXP()+monster.monsterxp);
            int l = level+1;
            System.out.println("Level UP: level: "+l);
            return true;
        }
        else
            return false;
    }
}

class Thief extends Hero{
    private int attack_power=5;
    private int defense_power=-5;
    int attack_count=0;
    boolean boss_fight=false;

    Thief(String name){
        super(name);
    }

    public int getAttack_power() {
        return attack_power;
    }

    public void setAttack_power(int attack_power) {
        this.attack_power = attack_power;
    }

    public int getDefense_power() {
        return defense_power;
    }

    public void setDefense_power(int defense_power) {
        this.defense_power = defense_power;
    }

    void special_attack(Monster monster){
        setHP(getHP()+(int)(0.3*monster.monsterhp));
        monster.monsterhp -= (int)(0.3*monster.monsterhp);
    }

    @Override
    boolean fight(int level){
        level_count+=1;
        int XP = getXP();
        Monster monster = new Monster(XP, level);
        System.out.println("Fight Started. You're fighting a level "+monster.getMonster_level()+" monster.");
        if(monster.monsterhp==250){
            boss_fight=true;
        }
        int heroHP= getHP();
        double monsterHP = monster.monsterhp;
        while(getHP()>0 && monster.monsterhp>0){
            System.out.println("Choose Move");
            System.out.println("1) Attack");
            System.out.println("2) Defense");
            if(attack_count>=4){
                System.out.println("3) Special Attack");
            }
            int choice1 = input.inp.nextInt();
            if(choice1==1){
                System.out.println("You Choose to attack");
                System.out.println("You attacked and inflicted "+getAttack_power()+" damage to monster");
                monster.monsterhp-=getAttack_power();
                System.out.println("Your HP:" +getHP()+"/"+heroHP+" Monsters HP: "+monster.monsterhp+"/"+monsterHP);

                System.out.println("Monster Attack!");
                int monster_attack = monster.monster_attack();
                System.out.println("The monster attacked and inflicted "+ monster_attack+" damage to you");
                setHP(getHP()-monster_attack);
            }
            else if(choice1==2){
                System.out.println("You Choose to defend");
                int attack_power_reduction = getDefense_power();
                System.out.println("Monster attack reduced by "+attack_power_reduction);
                System.out.println("Your HP:" +getHP()+"/"+heroHP+" Monsters HP: "+monster.monsterhp+"/"+monsterHP);
                System.out.println("Monster Attack!");
                int monster_attack = monster.monster_attack()-attack_power_reduction;
                if(monster_attack>0){
                    System.out.println("The monster attacked and inflicted "+ monster_attack+" damage to you");
                    setHP(getHP()-monster_attack);
                }
                else{
                    System.out.println("The monster attacked and inflicted 0 damage to you");
                }
            }
            else if(choice1==3){
                special_attack(monster);
                this.attack_count=0;
            }
            System.out.println("Your HP:" +getHP()+"/"+heroHP+" Monsters HP: "+monster.monsterhp+"/"+monsterHP);
            this.attack_count+=1;
        }
        this.attack_count = 0;
        if(getHP()>0){
            System.out.println("Monster Killed");
            if(level<=3){
                setHP(heroHP+50);
            }
            System.out.println(monster.monsterxp+"XP Rewarded");
            setXP(getXP()+monster.monsterxp);
            int l = level+1;
            System.out.println("Level UP: level: "+l);
            return true;
        }
        else
            return false;
    }
}

class Healer extends Hero{
    private int attack_power=5;
    private int defense_power=-5;
    int attack_count=0;
    boolean boss_fight=false;

    Healer(String name){
        super(name);
    }

    public int getAttack_power() {
        return attack_power;
    }

    public void setAttack_power(int attack_power) {
        this.attack_power = attack_power;
    }

    public int getDefense_power() {
        return defense_power;
    }

    public void setDefense_power(int defense_power) {
        this.defense_power = defense_power;
    }

    @Override
    void special_attack(){
        setHP(getHP()+(int)(getHP()*0.05));
    }
    void unset_special_attack(){
        setHP(getHP()-(int)(getHP()*0.05));
    }

    @Override
    boolean fight(int level){
        level_count+=1;
        int XP = getXP();
        Monster monster = new Monster(XP, level);
        System.out.println("Fight Started. You're fighting a level "+monster.getMonster_level()+" monster.");
        if(monster.monsterhp==250){
            boss_fight=true;
        }
        int heroHP= getHP();
        double monsterHP = monster.monsterhp;
        boolean special_attack=false;
        int special_attack_count=0;
        while(getHP()>0 && monster.monsterhp>0){
            System.out.println("Choose Move");
            System.out.println("1) Attack");
            System.out.println("2) Defense");
            if(attack_count>=4){
                System.out.println("3) Special Attack");
            }
            int choice1 = input.inp.nextInt();
            if(choice1==1){
                System.out.println("You Choose to attack");
                System.out.println("You attacked and inflicted "+getAttack_power()+" damage to monster");
                monster.monsterhp-=getAttack_power();
                System.out.println("Your HP:" +getHP()+"/"+heroHP+" Monsters HP: "+monster.monsterhp+"/"+monsterHP);
                if(special_attack){
                    if(special_attack_count==3){
                        unset_special_attack();
                        special_attack=false;
                    }
                    else{
                        special_attack_count+=1;
                    }
                }
                System.out.println("Monster Attack!");
                int monster_attack = monster.monster_attack();
                System.out.println("The monster attacked and inflicted "+ monster_attack+" damage to you");
                setHP(getHP()-monster_attack);
            }
            else if(choice1==2){
                System.out.println("You Choose to defend");
                int attack_power_reduction = getDefense_power();
                System.out.println("Monster attack reduced by "+attack_power_reduction);
                System.out.println("Your HP:" +getHP()+"/"+heroHP+" Monsters HP: "+monster.monsterhp+"/"+monsterHP);
                System.out.println("Monster Attack!");
                int monster_attack = monster.monster_attack()-attack_power_reduction;
                if(monster_attack>0){
                    System.out.println("The monster attacked and inflicted "+ monster_attack+" damage to you");
                    setHP(getHP()-monster_attack);
                }
                else{
                    System.out.println("The monster attacked and inflicted 0 damage to you");
                }
                if(special_attack){
                    if(special_attack_count==3){
                        unset_special_attack();
                        special_attack=false;
                    }
                    else{
                        special_attack_count+=1;
                    }
                }
            }
            else if(choice1==3){
                special_attack();
                special_attack=true;
                this.attack_count=0;
            }
            System.out.println("Your HP:" +getHP()+"/"+heroHP+" Monsters HP: "+monster.monsterhp+"/"+monsterHP);
            this.attack_count+=1;
        }
        this.attack_count = 0;
        if(getHP()>0){
            System.out.println("Monster Killed");
            if(level<=3){
                setHP(heroHP+50);
            }
            System.out.println(monster.monsterxp+"XP Rewarded");
            setXP(getXP()+monster.monsterxp);
            int l = level+1;
            System.out.println("Level UP: level: "+l);
            return true;
        }
        else
            return false;
    }
}

public class Main {
    public static void main(String[] args) {
        input temp=new input();
        Game game = new Game();
        game.start();
    }
}
