package bfp.stackoverflowclient.screens.questions.question_item;

import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import bfp.stackoverflowclient.questions.Question;
import bfp.stackoverflowclient.R;
import bfp.stackoverflowclient.screens.common.views.BaseObservableViewMvc;


public class QuestionItemViewMvcImpl extends BaseObservableViewMvc<QuestionItemViewMvc.Listener> implements QuestionItemViewMvc {

    TextView textView;
    Question question;

    public QuestionItemViewMvcImpl(LayoutInflater inflater, @Nullable ViewGroup parent){
        setRootView(inflater.inflate(R.layout.question_item_layout,parent,false));
        textView = findViewById(R.id.textViewQuestionName);
        getRootView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(Listener listener : getmListeners()){
                    listener.onQuestionClicked(question);
                }
            }
        });
    }


    @Override
    public void bindQuestion(Question question) {
        this.question = question;
        this.textView.setText(question.getTitle());
    }
}
