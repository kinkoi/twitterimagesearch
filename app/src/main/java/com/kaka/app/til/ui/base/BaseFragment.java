package com.kaka.app.til.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kaka.app.til.R;

import butterknife.ButterKnife;

/**
 * Created by Alexandr.Salin on 7/27/15.
 */
public abstract class BaseFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getResourceId(), container, false);
        ButterKnife.bind(this, view);
        afterInject();
        return view;
    }

    protected abstract int getResourceId();

    protected abstract void afterInject();
    
}
