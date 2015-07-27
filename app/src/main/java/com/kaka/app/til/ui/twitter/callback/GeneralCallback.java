package com.kaka.app.til.ui.twitter.callback;

import com.twitter.sdk.android.core.AppSession;

/**
 * Created by Alexandr.Salin on 7/27/15.
 */
public interface GeneralCallback {
    public void executeAfterJoin(AppSession session);

    public void onError(Exception e);

    public AppSession getAppSession();
}
