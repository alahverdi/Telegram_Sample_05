package com.alroid.telegrammftapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.alroid.telegrammftapp.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class BottomSheetLongClickItem extends BottomSheetDialogFragment
        implements View.OnClickListener {

    public static final String TAG = "ActionBottomDialog";

    public static BottomSheetLongClickItem newInstance() {
        return new BottomSheetLongClickItem();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout_bottom_sheet_long_click, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.tv_select).setOnClickListener(this);
        view.findViewById(R.id.tv_mute_notification).setOnClickListener(this);
        view.findViewById(R.id.tv_pin_to_top).setOnClickListener(this);
        view.findViewById(R.id.tv_archive_chat).setOnClickListener(this);
        view.findViewById(R.id.tv_mark_as_unread).setOnClickListener(this);
        view.findViewById(R.id.tv_clear_history).setOnClickListener(this);
        view.findViewById(R.id.tv_delete_chat).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_select:
                Toast.makeText(getContext(), "Selected", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_mute_notification:
                Toast.makeText(getContext(), "Notification Muted", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_pin_to_top:
                Toast.makeText(getContext(), "Pint to top", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_archive_chat:
                Toast.makeText(getContext(), "tv_archive_chat", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_mark_as_unread:
                Toast.makeText(getContext(), "Mark as unread", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_clear_history:
                Toast.makeText(getContext(), "Clear history", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_delete_chat:
                Toast.makeText(getContext(), "Deleted", Toast.LENGTH_SHORT).show();
                break;
        }
        dismiss();
    }

    public interface ItemClickListener {
        void onItemClick(String item);
    }

    @Override
    public int getTheme() {
        return R.style.AppBottomSheetDialogTheme;
    }
}
