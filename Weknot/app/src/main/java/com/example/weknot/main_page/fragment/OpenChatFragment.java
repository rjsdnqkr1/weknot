package com.example.weknot.main_page.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weknot.R;
import com.example.weknot.adapter.OpenChatRecyclerViewAdapter;
import com.example.weknot.api.OpenChatApi;
import com.example.weknot.data.OpenChat;
import com.example.weknot.databinding.OpenChatFragmentBinding;
import com.example.weknot.retrofit.MyRetrofit;

import java.util.List;

public class OpenChatFragment extends BaseFragment<OpenChatFragmentBinding> {

    public OpenChatFragment() {
        super(R.layout.open_chat_fragment);
    }

    private OpenChatApi openChatApi;

    private List<OpenChat> openChatList;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        init();
    }

    private void init() {

        initData();

        setRecyclerView();
    }

    private void initData() {

        openChatApi = MyRetrofit.getRetrofit().create(OpenChatApi.class);
    }

    private void setRecyclerView() {

        connectRecyclerView(binding.chatRoomRecyclerView, openChatList);
    }

    private void connectRecyclerView(RecyclerView chatRoomRecyclerView, List<OpenChat> openChatList) {

        chatRoomRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));

        OpenChatRecyclerViewAdapter openChatRecyclerViewAdapter = new OpenChatRecyclerViewAdapter();
        chatRoomRecyclerView.setAdapter(openChatRecyclerViewAdapter);
    }
}
