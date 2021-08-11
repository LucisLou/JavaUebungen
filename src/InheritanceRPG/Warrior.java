package InheritanceRPG;

public class Warrior extends RPGCharacter{

    public Warrior(String name, String gender, Integer lifePoints) {
        super(name, gender, lifePoints);
    }

    public void swingSword() {
        System.out.println("Hyaaa!");
    }

    @Override
    public void showOff() {
        swingSword();
    }

}
