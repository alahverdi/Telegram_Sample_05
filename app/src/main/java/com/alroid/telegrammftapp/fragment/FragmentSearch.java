package com.alroid.telegrammftapp.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alroid.telegrammftapp.ChatTelegramActivity;
import com.alroid.telegrammftapp.DataGenerator;
import com.alroid.telegrammftapp.MainActivity;
import com.alroid.telegrammftapp.R;
import com.alroid.telegrammftapp.adapter.AdapterSearchPeople;
import com.alroid.telegrammftapp.adapter.AdapterSearchRecent;
import com.alroid.telegrammftapp.databinding.FragmentSearchBinding;
import com.alroid.telegrammftapp.entity.Search;

public class FragmentSearch extends Fragment implements AdapterSearchRecent.SelectedSearch, AdapterSearchPeople.SelectedSearch {

    FragmentSearchBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentSearchBinding.inflate(inflater);

        AdapterSearchRecent adapterSearchRecent = new AdapterSearchRecent(getActivity(), DataGenerator.getSearchListRecent(getActivity()), this);
        binding.recyclerViewSearchRecent.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false));
        binding.recyclerViewSearchRecent.setAdapter(adapterSearchRecent);

        AdapterSearchPeople adapterSearchPeople = new AdapterSearchPeople(getActivity(), DataGenerator.getSearchListPeople(getActivity()), this);
        binding.recyclerViewSearchPeople.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        binding.recyclerViewSearchPeople.setAdapter(adapterSearchPeople);

        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Toolbar toolbar = getActivity().findViewById(R.id.toolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
            }
        });
    }

    @Override
    public void selectedSearch(Search search) {
        Intent intent = new Intent(getActivity(), ChatTelegramActivity.class);
        intent.putExtra("id", search.getId());
        startActivity(intent);
    }
}
