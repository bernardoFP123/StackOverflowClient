package bfp.stackoverflowclient.answers;


import bfp.stackoverflowclient.User;

public class Answer {

    private final int answerId;
    private final String mBody;
    private final boolean isAccepted;
    private final User user;
    private int mScore;

    public Answer(int answerId, String mBody, boolean isAccepted, User user,int mScore) {
        this.answerId = answerId;
        this.mBody = mBody;
        this.isAccepted = isAccepted;
        this.user = user;
        this.mScore = mScore;
    }


    public int getAnswerId() {
        return answerId;
    }

    public String getmBody() {
        return mBody;
    }

    public boolean isAccepted() {
        return isAccepted;
    }

    public User getUser() {
        return user;
    }

    public int getmScore() {
        return mScore;
    }
}
