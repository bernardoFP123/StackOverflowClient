package bfp.stackoverflowclient.networking.answers;

import com.google.gson.annotations.SerializedName;

import bfp.stackoverflowclient.networking.users.UserSchema;

public class AnswerSchema {
    @SerializedName("answer_id")
    private final int answerId;
    @SerializedName("body")
    private final String mBody;
    @SerializedName("is_accepted")
    private final boolean isAccepted;
    @SerializedName("owner")
    private final UserSchema user;
    @SerializedName("score")
    private int mScore;

    public AnswerSchema(int answerId, String mBody, boolean isAccepted, UserSchema user, int mScore) {
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

    public UserSchema getUser() {
        return user;
    }

    public int getmScore() {
        return mScore;
    }
}
