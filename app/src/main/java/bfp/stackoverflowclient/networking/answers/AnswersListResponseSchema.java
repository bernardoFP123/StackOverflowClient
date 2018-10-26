package bfp.stackoverflowclient.networking.answers;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AnswersListResponseSchema {
    @SerializedName("items")
    private final List<AnswerSchema> list;

    public AnswersListResponseSchema(List<AnswerSchema> list) {
        this.list = list;
    }

    public List<AnswerSchema> getList() {
        return list;
    }
}
