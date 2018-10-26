package bfp.stackoverflowclient.screens.questions;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import bfp.stackoverflowclient.questions.Question;
import bfp.stackoverflowclient.questions.common.FetchQuestionsUseCase;
import bfp.stackoverflowclient.screens.common.ViewMvcFactory;
import bfp.stackoverflowclient.screens.questions.question_item.QuestionItemViewMvc;

 public class QuestionsRecyclerAdapter extends RecyclerView.Adapter<QuestionsRecyclerAdapter.QuestionViewHolder> implements QuestionItemViewMvc.Listener,FetchQuestionsUseCase.Listener {
     @Override
     public void onLastActiveQuestionsFetched(List<Question> questions) {

     }

     @Override
     public void onLastActiveQuestionsFetchFailed() {

     }

     public interface Listener {
        void onQuestionClicked(Question question);
    }
    static class QuestionViewHolder extends RecyclerView.ViewHolder{
        private final QuestionItemViewMvc viewMvc;
        public QuestionViewHolder(QuestionItemViewMvc viewMvc) {

            super(viewMvc.getRootView());
            this.viewMvc = viewMvc;
        }
    }
    Listener listener;
    ViewMvcFactory viewMvcFactory;

    List<Question> questions = new ArrayList<>();

    public QuestionsRecyclerAdapter(Listener listener, ViewMvcFactory viewMvcFactory) {
        this.listener = listener;
        this.viewMvcFactory = viewMvcFactory;
    }

    @NonNull
    @Override
    public QuestionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        QuestionItemViewMvc viewMvc = viewMvcFactory.getQuestionsListItemViewMvc(parent);
        viewMvc.registerListener(this);
        return new QuestionViewHolder(viewMvc);
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionViewHolder holder, int position) {
        holder.viewMvc.bindQuestion(questions.get(position));
    }

    @Override
    public int getItemCount() {
        return questions.size();
    }

    @Override
    public void onQuestionClicked(Question question) {
        listener.onQuestionClicked(question);
    }



    public void bindQuestions(List<Question> questions){
        this.questions = new ArrayList<>(questions);
        notifyDataSetChanged();
    }
}
