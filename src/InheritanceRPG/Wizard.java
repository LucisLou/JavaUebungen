package InheritanceRPG;

public class Wizard extends RPGCharacter{

    public Wizard (String name, String gender) {
        super(name, gender, 3);
    }

    public void castMagic() {
        System.out.println("Elements, I command thee!");
    }

     @Override
    public void showOff() {
        castMagic();
     }

}
