package com.project.onlineshop.user;

public abstract class User {
    protected int userId;
    protected String name;
    protected String email;
    protected String password;
    protected String phone;
    protected String address;
    protected boolean isActive;

    public User(int userId, String name, String email, String password, String phone, String address) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.isActive =true;
    }

    public boolean login(String email, String password) {
        return this.email.equals(email) && this.password.equals(password);
    }

    public void logout() {
        System.out.println(name + " logged out successfully");
    }

    public void updateProfile(String phone, String address) {
        this.phone = phone;
        this.address = address;
    }

    public void changePassword(String newPassword) {
        this.password = newPassword;
    }

    public int getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }
}
