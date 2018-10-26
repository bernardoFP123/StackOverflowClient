package bfp.stackoverflowclient.screens.common;

import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import bfp.stackoverflowclient.screens.common.search_bar.SearchBarViewMvc;
import bfp.stackoverflowclient.screens.common.search_bar.SearchBarViewMvcImpl;
import bfp.stackoverflowclient.screens.common.tool_bar.ToolBarViewMvc;
import bfp.stackoverflowclient.screens.common.tool_bar.ToolBarViewMvcImpl;
import bfp.stackoverflowclient.screens.questions.QuestionsListMvc;
import bfp.stackoverflowclient.screens.questions.QuestionsListMvcImpl;
import bfp.stackoverflowclient.screens.questions.question_item.QuestionItemViewMvc;
import bfp.stackoverflowclient.screens.questions.question_item.QuestionItemViewMvcImpl;

public class ViewMvcFactory {

    private final LayoutInflater mLayoutInflater;

    public ViewMvcFactory(LayoutInflater layoutInflater) {
        mLayoutInflater = layoutInflater;
    }


    public QuestionItemViewMvc getQuestionsListItemViewMvc(@Nullable ViewGroup parent) {
        return new QuestionItemViewMvcImpl(mLayoutInflater, parent);
    }


    public QuestionsListMvc getQuestionsListViewMvc(@Nullable ViewGroup parent) {
        return new QuestionsListMvcImpl(mLayoutInflater, parent, this);
    }

    public ToolBarViewMvc getToolbarViewMvc(@Nullable ViewGroup parent){
        return new ToolBarViewMvcImpl(mLayoutInflater,parent);
    }
}
