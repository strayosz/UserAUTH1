package module;

public class User {
    private String login;
    private String password;
    private Role role;

    public User(){}

    public User(String login, String password, Role role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    public String getLogin() {
        return login;
    }
}
