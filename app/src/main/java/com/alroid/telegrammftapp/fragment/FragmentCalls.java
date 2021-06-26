package com.alroid.telegrammftapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alroid.telegrammftapp.DataGenerator;
import com.alroid.telegrammftapp.R;
import com.alroid.telegrammftapp.adapter.AdapterCallList;
import com.alroid.telegrammftapp.adapter.AdapterChatList;
import com.alroid.telegrammftapp.databinding.FragmentCallsBinding;
import com.alroid.telegrammftapp.entity.Call;
import com.google.android.material.snackbar.Snackbar;

public class FragmentCalls extends Fragment implements AdapterCallList.SelectedCall {

    FragmentCallsBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentCallsBinding.inflate(inflater);

        AdapterCallList adapterCall = new AdapterCallList(getActivity(), DataGenerator.getCalls(getActivity()), this);
        binding.recyclerViewCalls.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false));
        binding.recyclerViewCalls.setAdapter(adapterCall);

        return binding.getRoot();
    }

    @Override
    public void selectedCall(Call call) {
        Toast.makeText(getActivity(), "calling...", Toast.LENGTH_SHORT).show();
    }
}
