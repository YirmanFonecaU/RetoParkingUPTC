package co.edu.uptc.model;

import java.util.Map;

public class User {

    protected  int id;
    protected String userName;
    protected String password;
    protected int phone;
    protected String direction;
    protected String email;
    protected Map<String, String> account;

    public User() {

    }

    public void logIn(String user, String password) {

    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public int getPhone() {
        return phone;
    }

    public String getDirection() {
        return direction;
    }

    public String getEmail() {
        return email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
