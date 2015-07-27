package com.kaka.app.til.ui.main.activity;

import android.view.Menu;
import android.view.MenuItem;

import com.kaka.app.til.R;
import com.kaka.app.til.ui.main.fragment.MainFragment;
import com.kaka.app.til.ui.twitter.activity.TwitterSessionActivity;
import com.twitter.sdk.android.core.AppSession;


public class MainActivity extends TwitterSessionActivity {

    @Override
    protected int getResourceId() {
        return R.layout.activity_container;
    }

    @Override
    public void executeAfterJoin(AppSession session) {
        super.executeAfterJoin(session);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new MainFragment())
                .commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
