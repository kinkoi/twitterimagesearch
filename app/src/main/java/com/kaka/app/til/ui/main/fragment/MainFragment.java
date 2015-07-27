package com.kaka.app.til.ui.main.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.GridView;

import com.kaka.app.til.R;
import com.kaka.app.til.rest.DataManager;
import com.kaka.app.til.rest.callback.TwitterBaseCallback;
import com.kaka.app.til.ui.base.BaseFragment;
import com.kaka.app.til.ui.main.adapter.ImageAdapter;
import com.kaka.app.til.ui.twitter.callback.GeneralCallback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.models.Search;

import butterknife.Bind;
import butterknife.OnTextChanged;


/**
 * Created by Alexandr.Salin on 7/27/15.
 */
public class MainFragment extends BaseFragment {
    private static final String SEARCH_STRIN_KEY = "search_string_key";
    @Bind(R.id.grid)
    GridView grid;

    @Bind(R.id.search_edit_text)
    EditText searchView;

    private GeneralCallback mCallback;
    private SearchCallback mSearchCallback;

    @Override
    protected int getResourceId() {
        return R.layout.fragment_grid_image;
    }

    @Override
    protected void afterInject() {
        grid.setAdapter(new ImageAdapter(getActivity(), new String[]{}));
    }

    @OnTextChanged(R.id.search_edit_text)
    public void onTextChange() {
        String text = searchView.getText().toString();
        if (!TextUtils.isEmpty(text) && mCallback != null) {
            Bundle bundle = new Bundle();
            bundle.putString(SEARCH_STRIN_KEY, text);
            // TODO : make request with params
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        mSearchCallback = new SearchCallback();
        DataManager.searchImagesUrls(mCallback.getAppSession(), mSearchCallback);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof GeneralCallback) {
            mCallback = (GeneralCallback) activity;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallback = null;
    }

    class SearchCallback extends TwitterBaseCallback<Search> {

        @Override
        public void success(Result<Search> searchResult) {

        }

    }
}
