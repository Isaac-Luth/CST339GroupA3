package com.groupa3.groupa3.dto;

public class UserRegistrationDto {
    private String username;
    private String firstname;
    private String lastname;
    private String telephone;
    private String email;
    private String verifyemail;
    private String password;
    private String verifypassword;
    
    // other fields and getters/setters

    // Getters
    public String getUsername() {
        return username;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getEmail() {
        return email;
    }

    public String getVerifyemail() {
        return verifyemail;
    }

    public String getPassword() {
        return password;
    }

    public String getVerifypassword() {
        return verifypassword;
    }

    // Setters
    public void setUsername(String username) {
        this.username = username;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setVerifyemail(String verifyemail) {
        this.verifyemail = verifyemail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setVerifypassword(String verifypassword) {
        this.verifypassword = verifypassword;
    }
}
