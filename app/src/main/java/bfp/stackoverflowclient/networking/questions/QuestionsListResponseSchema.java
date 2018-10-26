package bfp.stackoverflowclient.networking.questions;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class QuestionsListResponseSchema {
    @SerializedName("items")
    private final List<QuestionSchema> questions;

    public QuestionsListResponseSchema(List<QuestionSchema> questions) {
        this.questions = questions;
    }

    public List<QuestionSchema> getQuestions() {
        return questions;
    }
}
