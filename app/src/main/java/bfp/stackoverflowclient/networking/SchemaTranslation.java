package bfp.stackoverflowclient.networking;

import java.util.ArrayList;
import java.util.List;

import bfp.stackoverflowclient.User;
import bfp.stackoverflowclient.answers.Answer;
import bfp.stackoverflowclient.networking.answers.AnswerSchema;
import bfp.stackoverflowclient.networking.questions.QuestionSchema;
import bfp.stackoverflowclient.networking.users.UserSchema;
import bfp.stackoverflowclient.questions.Question;
import bfp.stackoverflowclient.questions.QuestionDetails;

public class SchemaTranslation {
    public static List<Answer> getAnswerListFromAnswerSchemasList(List<AnswerSchema> answerSchemas) {
        List<Answer> answers = new ArrayList<>();
        for(AnswerSchema answerSchema : answerSchemas){
            answers.add(getAnswerFromAnswerSchema(answerSchema));
        }
        return answers;
    }
    public static List<QuestionDetails> getQuestionListFromAnswerSchemasList(List<QuestionSchema> questionSchemas) {
        List<QuestionDetails> questions = new ArrayList<>();
        for(QuestionSchema questionSchema : questionSchemas){
            questions.add(getQuestionDetailsFromQuestionSchema(questionSchema));
        }
        return questions;
    }



    public static Answer getAnswerFromAnswerSchema(AnswerSchema answerSchema){
        int answerId = answerSchema.getAnswerId();
        String answerBody = answerSchema.getmBody();
        boolean isAcceptedAnswer = answerSchema.isAccepted();
        int answerScore = answerSchema.getmScore();
        UserSchema userSchema = answerSchema.getUser();
        User user = getUserFromUserSchema(userSchema);
        Answer answer = new Answer(answerId,answerBody,isAcceptedAnswer,user,answerScore);
        return answer;
    }
    public static QuestionDetails getQuestionDetailsFromQuestionSchema(QuestionSchema questionSchema) {
        String questionId = questionSchema.getQuestionId();
        String title = questionSchema.getTitle();
        String body = questionSchema.getBody();
        UserSchema userSchema = questionSchema.getOwner();
        User user = getUserFromUserSchema(userSchema);
        QuestionDetails questionDetails = new QuestionDetails(questionId,title,body,user);
        return questionDetails;
    }

    public static User getUserFromUserSchema( UserSchema userSchema){
        return new User(userSchema.getUserDisplayName(),userSchema.getUserAvatarUrl(),userSchema.getReputation());
    }


}
