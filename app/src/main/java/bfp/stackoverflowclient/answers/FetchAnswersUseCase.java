package bfp.stackoverflowclient.answers;

import java.util.List;

import bfp.stackoverflowclient.common.BaseObservable;
import bfp.stackoverflowclient.common.Constants;
import bfp.stackoverflowclient.networking.SchemaTranslation;
import bfp.stackoverflowclient.networking.StackOverflowAPI;
import bfp.stackoverflowclient.networking.answers.AnswerSchema;
import bfp.stackoverflowclient.networking.answers.AnswersListResponseSchema;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FetchAnswersUseCase extends BaseObservable<FetchAnswersUseCase.Listener> {
public interface Listener {
    void onAnswersFetched(List<Answer> answers);
    void onAnswersFetchFailed();
}
    private final StackOverflowAPI stackOverflowAPI;

    public FetchAnswersUseCase(StackOverflowAPI stackOverflowAPI) {
        this.stackOverflowAPI = stackOverflowAPI;
    }
    //TODO: write api call
    public void fetchAnswersAndNotify(int questionId){
        stackOverflowAPI.fetchAnswers(questionId, Constants.ANSWERS_LIST_PAGE_SIZE).enqueue(new Callback<AnswersListResponseSchema>() {
            @Override
            public void onResponse(Call<AnswersListResponseSchema> call, Response<AnswersListResponseSchema> response) {
                if (response.isSuccessful()) {
                    notifySuccess(response.body().getList());
                } else {
                    notifyFailure();
                }
            }

            @Override
            public void onFailure(Call<AnswersListResponseSchema> call, Throwable t) {
                notifyFailure();
            }
        });
    }

    protected void notifyFailure() {
        for (Listener listener : getListeners()) {
            listener.onAnswersFetchFailed();
        }
    }

    protected void notifySuccess(List<AnswerSchema> answerSchemas) {
        List<Answer> fetchedAnswers = SchemaTranslation.getAnswerListFromAnswerSchemasList(answerSchemas);
        for (Listener listener : getListeners()) {
            listener.onAnswersFetched(fetchedAnswers);
        }
    }


}
