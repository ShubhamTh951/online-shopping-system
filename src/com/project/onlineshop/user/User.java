package com.project.onlineshop.user;

public abstract class User {
    protected int userId;
    protected String name;
    protected String email;
    protected String password;
    protected String phone;
    protected String address;
    protected boolean isActive;
    protected boolean loggedIn;

    public User(int userId, String name, String email, String password, String phone, String address) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.isActive =true;
        this.loggedIn = false;
    }

    public boolean login(String email, String password) {
        if (!isActive) return false;
        if (this.email.equals(email) && this.password.equals(password)) {
            this.loggedIn = true;
            return true;
        }
        return false;
    }

    public void logout() {
        loggedIn = false;
        System.out.println(name + " logged out.");
    }

    public boolean updateProfile(String phone, String address) {
        if (!loggedIn) return false;
        this.phone = phone;
        this.address = address;
        return true;
    }

    public boolean changePassword(String oldPassword, String newPassword) {
        if (!loggedIn) return false;
        if (!this.password.equals(oldPassword)) return false;
        this.password = newPassword;
        return true;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public int getUserId() {
        return userId;
    }
}
