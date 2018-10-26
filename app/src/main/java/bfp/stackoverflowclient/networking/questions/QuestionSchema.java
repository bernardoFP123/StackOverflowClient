package bfp.stackoverflowclient.networking.questions;

import com.google.gson.annotations.SerializedName;

import bfp.stackoverflowclient.networking.users.UserSchema;

public class QuestionSchema {

    @SerializedName("title")
    private final String title;
    @SerializedName("question_id")
    private final String questionId;
    @SerializedName("body")
    private final String body;
    @SerializedName("owner")
    private final UserSchema owner;

    public QuestionSchema(String title, String questionId, String body, UserSchema owner) {
        this.title = title;
        this.questionId = questionId;
        this.body = body;
        this.owner = owner;
    }

    public String getTitle() {
        return title;
    }

    public String getQuestionId() {
        return questionId;
    }

    public String getBody() {
        return body;
    }

    public UserSchema getOwner() {
        return owner;
    }
}
