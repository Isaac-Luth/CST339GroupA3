package com.groupa3.dto;

/**
 * Data transfer object for the user
 */
public class UserDto {
    private String username;
    private String firstname;
    private String lastname;
    private String telephone;
    private String email;
    private String verifyemail;
    private String password;
    private String verifypassword;
    private long id;

    
    
    /** 
     *  Get the username
     * @return String The username
     */
    public String getUsername() {
        return username;
    }

    
    /** 
     *  Get the first name
     * @return String The first name
     */
    public String getFirstname() {
        return firstname;
    }

    
    /** 
     *  Get the last name
     * @return String The last name
     */
    public String getLastname() {
        return lastname;
    }

    
    /** 
     *  Get the telephone number
     * @return String The telephone number
     */
    public String getTelephone() {
        return telephone;
    }

    
    /** 
     *  Get the email
     * @return String The email
     */
    public String getEmail() {
        return email;
    }

    
    /** 
     *  Get the verify email
     * @return String The verify email
     */
    public String getVerifyemail() {
        return verifyemail;
    }

    
    /** 
     *  Get the password
     * @return String The password
     */
    public String getPassword() {
        return password;
    }

    
    /** 
     *  Get the verify password
     * @return String The verify password
     */
    public String getVerifypassword() {
        return verifypassword;
    }

    
    /** 
     *  Get the id
     * @return long The id
     */
    public long getId() {
        return id;
    }

    
    
    /** 
     *  Set the username
     * @param username The username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    
    /** 
     *  Set the first name
     * @param firstname The first name
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    
    /** 
     *  Set the last name
     * @param lastname The last name
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    
    /** 
     *  Set the telephone number
     * @param telephone The telephone number
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    
    /** 
     *  Set the email
     * @param email The email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    
    /** 
     *  Set the verify email
     * @param verifyemail The verify email
     */
    public void setVerifyemail(String verifyemail) {
        this.verifyemail = verifyemail;
    }

    
    /** 
     *  Set the password
     * @param password The password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    
    /** 
     *  Set the verify password
     * @param verifypassword The verify password
     */
    public void setVerifypassword(String verifypassword) {
        this.verifypassword = verifypassword;
    }

    
    /** 
     *  Set the id
     * @param id The id
     */
    public void setId(long id) {
        this.id = id;
    }

}
