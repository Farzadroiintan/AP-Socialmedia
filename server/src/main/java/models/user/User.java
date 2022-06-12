package models.user;
import models.messaging.Chat;
import models.twitt.Twitt;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(unique = true, nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;

    private String firstname;
    private String lastname;
    private String email;
    private String bio;
    private String phoneNumber;

    private boolean publicPage = true;
    private int lastSeenAccess = 0;//2:everybody can see  1.just followers can see  0.nobody can see
    private Date lastSeen = new Date();
    @ManyToMany
    @JoinTable(name="followers")
    public List<User> followers = new LinkedList<>();

    @ManyToMany
    @JoinTable(name="followings")
    public List<User> following = new LinkedList<>();

    @OneToMany
    @JoinTable(name="twittlist")
    public List<Twitt> twitts = new LinkedList<>();

    @OneToMany
    @JoinTable(name="savetwittlist")
    public List<Twitt> saveTwitts = new LinkedList<>();

    @ManyToMany
    @JoinTable(name="otherfollowrequest")
    public List<User> otherFollowReq = new LinkedList<>();

    @ManyToMany
    @JoinTable(name="yourfollowrequest")
    public List<User> yourFollowReq = new LinkedList<>();

    @ManyToMany
    @JoinTable(name="userlikes")
    public List<Twitt> likedTwitt = new LinkedList<>();

    @ManyToMany
    @JoinTable(name="userchats")
    public List<Chat> chat = new LinkedList<>();

    @ElementCollection
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name = "systemnotif")
    public List<String> systemNotification = new LinkedList<>();


    public User(){}

    public User(String username, String password) {
        this.password = password;
        this.username = username;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public List<User> getFollowers() {
        return followers;
    }

    public void setFollowers(List<User> followers) {
        this.followers = followers;
    }

    public List<User> getFollowing() {
        return following;
    }

    public void setFollowing(List<User> following) {
        this.following = following;
    }

    public List<Twitt> getTwitts() {
        return twitts;
    }

    public void setTwitts(List<Twitt> twitts) {
        this.twitts = twitts;
    }

    public List<Twitt> getSaveTwitts() {
        return saveTwitts;
    }

    public void setSaveTwitts(List<Twitt> saveTwitts) {
        this.saveTwitts = saveTwitts;
    }

    public List<User> getOtherFollowReq() {
        return otherFollowReq;
    }

    public void setOtherFollowReq(List<User> otherFollowReq) {
        this.otherFollowReq = otherFollowReq;
    }

    public List<User> getYourFollowReq() {
        return yourFollowReq;
    }

    public void setYourFollowReq(List<User> yourFollowReq) {
        this.yourFollowReq = yourFollowReq;
    }

    public List<Twitt> getLikedTwitt() {
        return likedTwitt;
    }

    public void setLikedTwitt(List<Twitt> likedTwitt) {
        this.likedTwitt = likedTwitt;
    }

    public List<Chat> getChat() {
        return chat;
    }

    public void setChat(List<Chat> chat) {
        this.chat = chat;
    }

    public List<String> getSystemNotification() {
        return systemNotification;
    }

    public void setSystemNotification(List<String> systemNotification) {
        this.systemNotification = systemNotification;
    }
}
