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

    public Person(String fname, String lname) {
        this.fname = fname;
        this.lname = lname;
    }

    public Person(String fname, String lname, Gender gender, String birthday) {
        this.fname = fname;
        this.lname = lname;
        this.gender = gender;
        this.birthday = birthday;
    }
}
