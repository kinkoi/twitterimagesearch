package com.kaka.app.til.ui.twitter.activity;

import com.kaka.app.til.R;
import com.kaka.app.til.rest.DataManager;
import com.kaka.app.til.rest.callback.SessionCallback;
import com.kaka.app.til.ui.base.BaseActivity;
import com.kaka.app.til.ui.twitter.callback.GeneralCallback;
import com.kaka.app.til.ui.twitter.fragment.ProgressFragment;
import com.twitter.sdk.android.core.AppSession;

/**
 * Created by Alexandr.Salin on 7/27/15.
 */
public class TwitterSessionActivity extends BaseActivity implements GeneralCallback {

    private SessionCallback callback;
    private AppSession session;

    @Override
    protected int getResourceId() {
        return R.layout.activity_container;
    }

    @Override
    protected void afterInject() {
        if (getSupportFragmentManager().findFragmentById(R.id.container) == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new ProgressFragment())
                    .commit();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        callback = new SessionCallback(this);
        DataManager.loginGuest(callback);
    }

    @Override
    protected void onStop() {
        super.onStop();
        callback.setCallback(null);
    }

    @Override
    public void executeAfterJoin(AppSession session) {
        this.session = session;
    }

    @Override
    public void onError(Exception e) {

    }

    @Override
    public AppSession getAppSession() {
        return session;
    }
}
