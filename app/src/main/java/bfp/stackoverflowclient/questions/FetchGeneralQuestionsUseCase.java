package bfp.stackoverflowclient.questions;

import bfp.stackoverflowclient.common.Constants;
import bfp.stackoverflowclient.networking.StackOverflowAPI;
import bfp.stackoverflowclient.networking.questions.QuestionsListResponseSchema;
import bfp.stackoverflowclient.questions.common.FetchQuestionsUseCase;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FetchGeneralQuestionsUseCase extends FetchQuestionsUseCase {
    public FetchGeneralQuestionsUseCase(StackOverflowAPI stackOverflowAPI) {
        super(stackOverflowAPI);
    }

    public void fetchLastActiveQuestionsAndNotify(){
        stackOverflowAPI.fetchLastActiveQuestions(Constants.QUESTIONS_LIST_PAGE_SIZE).enqueue(new Callback<QuestionsListResponseSchema>() {
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
}
