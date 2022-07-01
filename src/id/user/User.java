package id.user;

abstract class User {

    /* Properties */
    protected String username;
    protected String password;

    /* Constructor */
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /* Encapsulations */
    public String getUsername() {
        return this.username;
    }
    public String getPassword() {
        return this.password;
    }

    public void setUsername(String newUsername) {
        this.username = newUsername;
    }
    public void setPassword(String newPassword) {
        this.password = newPassword;
    }

}
