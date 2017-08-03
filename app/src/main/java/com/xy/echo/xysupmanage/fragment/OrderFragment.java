package com.xy.echo.xysupmanage.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xy.echo.xysupmanage.R;

/**
 * Created by Echo on 2017/7/12.
 */

public class OrderFragment extends Fragment {
    private View mView;
    private RecyclerView mRecyclerView;
    private TextView mTextView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mView=  inflater.inflate(R.layout.list_order,container,false);
        return mView;
    }

    private void initView(){
        mRecyclerView= (RecyclerView) mRecyclerView.findViewById(R.id.recycler_order);
    }

}
