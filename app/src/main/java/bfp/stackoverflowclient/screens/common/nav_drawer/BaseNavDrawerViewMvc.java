package bfp.stackoverflowclient.screens.common.nav_drawer;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import java.util.ArrayList;
import java.util.List;

import bfp.stackoverflowclient.questions.ProgrammingLanguageTag;
import bfp.stackoverflowclient.R;
import bfp.stackoverflowclient.screens.common.views.BaseObservableViewMvc;

public abstract class BaseNavDrawerViewMvc<ListenerType> extends BaseObservableViewMvc<ListenerType>
        implements NavDrawerViewMvc {

    private final DrawerLayout mDrawerLayout;
    private final FrameLayout mFrameLayout;
    private final NavigationView mNavigationView;
    private List<ProgrammingLanguageTag> items;


    public BaseNavDrawerViewMvc(LayoutInflater inflater, @Nullable ViewGroup parent) {
        super.setRootView(inflater.inflate(R.layout.drawer_layout, parent, false));
        mDrawerLayout = findViewById(R.id.drawer_layout);
        mFrameLayout = findViewById(R.id.frame_content);
        mNavigationView = findViewById(R.id.nav_view);
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull android.view.MenuItem item) {
                mDrawerLayout.closeDrawers();
                onDrawerItemClicked(items.get(item.getItemId()));
                return false;
            }
        });
    }

    @Override
    public void openDrawer() {
        mDrawerLayout.openDrawer(Gravity.START);
    }

    @Override
    public boolean isDrawerOpen() {
        return mDrawerLayout.isDrawerOpen(Gravity.START);
    }

    @Override
    public void closeDrawer() {
        mDrawerLayout.closeDrawers();
    }

    protected abstract void onDrawerItemClicked(ProgrammingLanguageTag item);

    @Override
    protected void setRootView(View view) {
        mFrameLayout.addView(view);
    }

    //binds the menu to the drawer, sets the MenuItemId as the position on the list
    @Override
    public void bindMenu(List<ProgrammingLanguageTag> items){
        mNavigationView.getMenu().clear();
        this.items = new ArrayList<>(items);
        for(int i = 0; i < items.size(); i++)
            mNavigationView.getMenu().add(Menu.NONE,i,Menu.NONE,items.get(i).getName());
    }



}
