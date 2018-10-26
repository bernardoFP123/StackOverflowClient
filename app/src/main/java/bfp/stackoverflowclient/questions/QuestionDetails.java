package bfp.stackoverflowclient.questions;

import bfp.stackoverflowclient.User;

public class QuestionDetails {
    private final String mId;

    private final String mTitle;

    private final String mBody;

    private final User user;

    public QuestionDetails(String mId, String mTitle, String mBody, User user) {
        this.mId = mId;
        this.mTitle = mTitle;
        this.mBody = mBody;
        this.user = user;
    }

    public String getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getBody() {
        return mBody;
    }

    public User getUser() {
        return user;
    }
}
