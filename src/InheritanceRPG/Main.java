package InheritanceRPG;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<RPGCharacter> allCharacters = new ArrayList<>();

        Warrior dimitri = new Warrior("Dimitri", "male", 60);
        Wizard byleth = new Wizard("Byleth", "yes" );
        Archer yuri = new Archer("Yuri", "male");

        allCharacters.add(dimitri);
        allCharacters.add(byleth);
        allCharacters.add(yuri);

        for (RPGCharacter character : allCharacters) {
            character.showOff();
        }
    }
}
