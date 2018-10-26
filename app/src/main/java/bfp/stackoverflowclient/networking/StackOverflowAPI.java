package bfp.stackoverflowclient.networking;

import bfp.stackoverflowclient.networking.answers.AnswerSchema;
import bfp.stackoverflowclient.networking.answers.AnswersListResponseSchema;
import bfp.stackoverflowclient.networking.questions.QuestionSchema;
import bfp.stackoverflowclient.networking.questions.QuestionsListResponseSchema;
import bfp.stackoverflowclient.questions.QuestionDetails;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface StackOverflowAPI {
    @GET("/questions?sort=activity&order=desc&site=stackoverflow&filter=withbody")
    Call<QuestionsListResponseSchema> fetchLastActiveTaggedQuestions(@Query("pagesize") Integer pageSize,@Query("tagged") String tag);
    @GET("/questions?sort=activity&order=desc&site=stackoverflow&filter=withbody")
    Call<QuestionsListResponseSchema> fetchLastActiveQuestions(@Query("pagesize") Integer pageSize);
    @GET("/questions/{question_id}?sort=activity&order=desc&site=stackoverflow&filter=withbody")
    Call<QuestionsListResponseSchema> fetchQuestion(@Path("question_id") Integer id);
    @GET("/questions/{question_id}/answers?&order=desc&sort=votes&site=stackoverflow")
    Call<AnswersListResponseSchema> fetchAnswers(@Path("question_id") Integer questionID, @Query("pagesize") Integer pageSize);
}
