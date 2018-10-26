package bfp.stackoverflowclient.screens.questions;

import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

import java.util.List;

import bfp.stackoverflowclient.questions.Question;
import bfp.stackoverflowclient.R;
import bfp.stackoverflowclient.questions.ProgrammingLanguageTag;
import bfp.stackoverflowclient.screens.common.nav_drawer.BaseNavDrawerViewMvc;
import bfp.stackoverflowclient.screens.common.nav_drawer.NavDrawerViewMvc;
import bfp.stackoverflowclient.screens.common.tool_bar.ToolBarViewMvc;
import bfp.stackoverflowclient.screens.common.ViewMvcFactory;

public class QuestionsListMvcImpl extends BaseNavDrawerViewMvc<QuestionsListMvc.Listener> implements QuestionsListMvc, QuestionsRecyclerAdapter.Listener,NavDrawerViewMvc{

    private final RecyclerView recyclerViewQuestions;
    private final QuestionsRecyclerAdapter adapter;
    private final FrameLayout toolbarContainer;
    private final ToolBarViewMvc toolBarViewMvc;
    private final SwipeRefreshLayout swipeRefreshLayout;
    public QuestionsListMvcImpl(LayoutInflater inflater, @Nullable ViewGroup parent, ViewMvcFactory factory){
        super(inflater,parent);
        super.setRootView(inflater.inflate(R.layout.questions_list,parent,false));
        recyclerViewQuestions = findViewById(R.id.recyclerView);
        recyclerViewQuestions.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new QuestionsRecyclerAdapter(this,factory);
        recyclerViewQuestions.setAdapter(adapter);
        toolbarContainer  = findViewById(R.id.containerTop);
        toolBarViewMvc = factory.getToolbarViewMvc(toolbarContainer);
        initToolbar();
        swipeRefreshLayout = findViewById(R.id.swipeView);
        initSwipeView();
    }
    private void initToolbar() {
        toolBarViewMvc.setTitle(getString(R.string.questions_list_screen_title));
        toolbarContainer.addView(toolBarViewMvc.getRootView());
        toolBarViewMvc.enableHamburgerButtonAndListen(new ToolBarViewMvc.HamburgerClickListener() {
            @Override
            public void onHamburgerClicked() {
                openDrawer();
            }
        });
        toolBarViewMvc.enableAddButtonAndListen(new ToolBarViewMvc.AddButtonClickListener() {
            @Override
            public void onAddButtonClicked() {
                for(Listener listener : getmListeners()){
                    listener.onAddButtonClicked();
                }
            }
        });
    }


    private void initSwipeView(){
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                for(QuestionsListMvc.Listener listener : getmListeners()){
                    listener.onRefresh();
                }
            }
        });

    }
    @Override
    public void bindQuestions(List<Question> questions) {
        adapter.bindQuestions(questions);
    }

    @Override
    public void bindMenuOptions(List<ProgrammingLanguageTag> items) {
        bindMenu(items);
    }

    @Override
    public void stopRefreshing() {
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void displayTagCreationMenu(ProgrammingLanguageTag tag) {
        Toast.makeText(getContext(),"tag create",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onQuestionClicked(Question question) {
        for(QuestionsListMvc.Listener listener : getmListeners()){
            listener.onQuestionClicked(question);
        }
    }

    @Override
    protected void onDrawerItemClicked(ProgrammingLanguageTag item) {
        for(QuestionsListMvc.Listener listener : getmListeners()){
            listener.onTagSelected(item);
        }
    }



}
