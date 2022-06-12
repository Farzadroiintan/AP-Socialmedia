package models;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class SimpleUser {
    private int id;

    private String username;
    private String password;

    private String firstname;
    private String lastname;
    private String email;
    private String bio;
    private String phoneNumber;

    private boolean publicPage = true;
    private int lastSeenAccess = 0;//2:everybody can see  1.just followers can see  0.nobody can see
    private Date lastSeen = new Date();

    public SimpleUser() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isPublicPage() {
        return publicPage;
    }

    public void setPublicPage(boolean publicPage) {
        this.publicPage = publicPage;
    }

    public int getLastSeenAccess() {
        return lastSeenAccess;
    }

    public void setLastSeenAccess(int lastSeenAccess) {
        this.lastSeenAccess = lastSeenAccess;
    }

    public Date getLastSeen() {
        return lastSeen;
    }

    public void setLastSeen(Date lastSeen) {
        this.lastSeen = lastSeen;
    }


}
