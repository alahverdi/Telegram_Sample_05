package com.alroid.telegrammftapp.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alroid.telegrammftapp.ChatTelegramActivity;
import com.alroid.telegrammftapp.DataGenerator;
import com.alroid.telegrammftapp.MainActivity;
import com.alroid.telegrammftapp.R;
import com.alroid.telegrammftapp.adapter.AdapterChatList;
import com.alroid.telegrammftapp.databinding.FragmentChatsBinding;
import com.alroid.telegrammftapp.entity.Chat;

public class FragmentChats extends Fragment implements AdapterChatList.SelectedChat {

    FragmentChatsBinding binding;
    //NavController navController;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentChatsBinding.inflate(inflater);

        AdapterChatList adapterChat = new AdapterChatList(getActivity(), DataGenerator.getChats(getActivity()), this);
        binding.recyclerViewChats.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false));
        binding.recyclerViewChats.setAdapter(adapterChat);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //navController = Navigation.findNavController(view);
    }

    @Override
    public void selectedChat(Chat chat) {
        //navController.navigate(R.id.chatTelegramActivity);

        Intent intent = new Intent(getActivity(), ChatTelegramActivity.class);
        intent.putExtra("id", chat.getId());
        startActivity(intent);
    }
}
