package bfp.stackoverflowclient.questions;


import java.util.List;

import bfp.stackoverflowclient.common.BaseObservable;
import bfp.stackoverflowclient.networking.SchemaTranslation;
import bfp.stackoverflowclient.networking.StackOverflowAPI;
import bfp.stackoverflowclient.networking.questions.QuestionSchema;
import bfp.stackoverflowclient.networking.questions.QuestionsListResponseSchema;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FetchQuestionUseCase extends BaseObservable<FetchQuestionUseCase.Listener> {
    interface Listener{
        void onQuestionDetailsFetched(QuestionDetails question);
        void onQuestionDetailsFetchFailed();
    }

    StackOverflowAPI stackOverflowAPI;

    public FetchQuestionUseCase(StackOverflowAPI stackOverflowAPI) {
        this.stackOverflowAPI = stackOverflowAPI;
    }

    public void fetchQuestionAndNotify(int questionId){
        stackOverflowAPI.fetchQuestion(questionId).enqueue(new Callback<QuestionsListResponseSchema>() {
            @Override
            public void onResponse(Call<QuestionsListResponseSchema> call, Response<QuestionsListResponseSchema> response) {
                if (response.isSuccessful()) {
                    notifySuccess(response.body().getQuestions());
                } else {
                    notifyFailure();
                }
            }

            @Override
            public void onFailure(Call<QuestionsListResponseSchema> call, Throwable t) {
                notifyFailure();
            }
        });
    }


    protected void notifyFailure() {
        for (Listener listener : getListeners()) {
            listener.onQuestionDetailsFetchFailed();
        }
    }

    protected void notifySuccess(List<QuestionSchema> questionSchemas) {
        QuestionSchema questionSchemaReceived = questionSchemas.get(0);
        QuestionDetails questionDetails = SchemaTranslation.getQuestionDetailsFromQuestionSchema(questionSchemaReceived);
        for (Listener listener : getListeners()) {
            listener.onQuestionDetailsFetched(questionDetails);
        }
    }
}
