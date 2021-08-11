package InheritanceRPG;

public class Archer extends RPGCharacter{

    public Archer(String name, String gender) {
        super(name, gender, Integer.MAX_VALUE);
    }

    public void shootArrow() {
        System.out.println("--->");
    }

    @Override
    public void showOff() {
        shootArrow();
    }
}
