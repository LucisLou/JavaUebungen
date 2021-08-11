package InheritanceRPG;

public abstract class RPGCharacter {

    private String name;
    private String gender;
    private Integer lifePoints;

    public RPGCharacter(String name, String gender, Integer lifePoints) {

        this.name = name;
        this.gender = gender;
        this.lifePoints = lifePoints;

    }

    public abstract void showOff();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getLifePoints() {
        return lifePoints;
    }

    public void setLifePoints(Integer lifePoints) {
        this.lifePoints = lifePoints;
    }
}
