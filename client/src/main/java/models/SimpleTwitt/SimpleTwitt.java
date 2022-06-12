package models.SimpleTwitt;

import java.time.LocalDateTime;

public class SimpleTwitt {

    int Id;
    String context;
    int likes;
    int comments;
    LocalDateTime writeDateTime;
    int WriterId;
    String WriterUsername;

    public SimpleTwitt() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public LocalDateTime getWriteDateTime() {
        return writeDateTime;
    }

    public void setWriteDateTime(LocalDateTime writeDateTime) {
        this.writeDateTime = writeDateTime;
    }

    public int getWriterId() {
        return WriterId;
    }

    public void setWriterId(int writerId) {
        WriterId = writerId;
    }

    public String getWriterUsername() {
        return WriterUsername;
    }

    public void setWriterUsername(String writerUsername) {
        WriterUsername = writerUsername;
    }

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }
}
