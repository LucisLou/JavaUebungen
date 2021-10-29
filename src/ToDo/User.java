package ToDo;

class User {

    // I did not use OOP for this exercise, so this file is redundant
    //However, it's a nice practice anyway, so I kept it

    private String username;
    private String password;

    //Getter & Setter
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

}
