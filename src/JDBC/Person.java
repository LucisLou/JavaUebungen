package JDBC;

public class Person {

    private String fname;
    private String lname;
    public enum Gender {
        MALE,
        FEMALE,
        OTHER
    }
    private Gender gender;
    private String birthday;

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {

        return fname + "," + lname + "," + gender + "," + birthday;

        /* return "Person{" +
                "fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", gender=" + gender +
                ", birthday='" + birthday + '\'' +
                '}'; */
    }

    public Person(String fname, String lname, char chosenGender, String birthday) {
        this.fname = fname;
        this.lname = lname;
        this.birthday = birthday;

        switch (Character.toLowerCase(chosenGender)) {
            case 'f':
                this.gender = Gender.FEMALE;
                break;
            case 'm':
                this.gender = Gender.MALE;
                break;
            case 'o':
                this.gender = Gender.OTHER;
                break;
        }
    }
}
