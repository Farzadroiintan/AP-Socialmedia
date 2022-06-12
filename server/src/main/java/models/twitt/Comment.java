package models.twitt;

import models.user.User;

import javax.persistence.*;

@Entity
public class Comment extends Twitt{


    @ManyToOne
    Twitt mainTwitt;

    public Comment(User writer, String context, Twitt mainTwitt) {
        super(writer, context);
        this.mainTwitt = mainTwitt;
        mainTwitt.Comments.add(this);
    }

    public Comment() {
    }

}
