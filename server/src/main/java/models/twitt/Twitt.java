package models.twitt;

import models.user.User;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "Twitts")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Twitt {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    User writer;

    String context;

    LocalDateTime writeDateTime;

    public boolean report = false;

    public boolean isReport() {
        return report;
    }

    public void setReport(boolean report) {
        this.report = report;
    }

    public List<User> getReports() {
        return reports;
    }

    public void setReports(List<User> reports) {
        this.reports = reports;
    }

    public List<Comment> getComments() {
        return Comments;
    }

    public void setComments(List<Comment> comments) {
        Comments = comments;
    }

    @ManyToMany
    @JoinTable(name="likelist")
    public List<User> Likes = new LinkedList<>();

    @ManyToMany
    @JoinTable(name="reportlist")
    public List<User> reports = new LinkedList<>();

    @OneToMany
    @JoinTable(name="commentlist")
    public List<Comment> Comments = new LinkedList<>();

    public Twitt() {}

    public Twitt(User writer, String context) {
        this.writeDateTime = LocalDateTime.now();
        this.writer = writer;
        this.context = context;
        writer.twitts.add(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getWriter() {
        return writer;
    }

    public void setWriter(User writer) {
        this.writer = writer;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public LocalDateTime getWriteDateTime() {
        return writeDateTime;
    }

    public void setWriteDateTime(LocalDateTime writeDateTime) {
        this.writeDateTime = writeDateTime;
    }

    public List<User> getLikes() {
        return Likes;
    }

    public void setLikes(List<User> likes) {
        Likes = likes;
    }

//    public List<Comment> getComments() {
//        return Comments;
//    }
//
//    public void setComments(List<Comment> comments) {
//        Comments = comments;
//    }
}
