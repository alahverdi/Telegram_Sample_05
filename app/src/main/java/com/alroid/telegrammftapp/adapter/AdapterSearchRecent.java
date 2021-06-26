package com.alroid.telegrammftapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.alroid.telegrammftapp.R;
import com.alroid.telegrammftapp.entity.Call;
import com.alroid.telegrammftapp.entity.Search;
import com.alroid.telegrammftapp.fragment.BottomSheetLongClickItem;

import java.util.List;

public class AdapterSearchRecent extends RecyclerView.Adapter<AdapterSearchRecent.LikesViewHolder> {
    Context context;
    List<Search> searchList;
    SelectedSearch selectedSerach;

    public AdapterSearchRecent(Context context, List<Search> searchList, SelectedSearch selectedSearch) {
        this.context = context;
        this.searchList = searchList;
        this.selectedSerach = selectedSearch;
    }

    @NonNull
    @Override
    public LikesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_search_recent, parent, false);
        return new LikesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LikesViewHolder holder, int position) {
        Search search = searchList.get(position);

        holder.iv_user.setImageDrawable(search.getImgUser());
        holder.tv_userName.setText(search.getUserName());

    }

    @Override
    public int getItemCount() {
        return searchList.size();
    }

    public class LikesViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_user;
        TextView tv_userName;

        // constructor:
        public LikesViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_user = itemView.findViewById(R.id.iv_user);
            tv_userName = itemView.findViewById(R.id.tv_userName);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(context, "clicked", Toast.LENGTH_SHORT).show();
                    selectedSerach.selectedSearch(searchList.get(getAdapterPosition()));
                }
            });

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    showBottomSheet(v);
                    return false;
                }
            });
        }
    }

    public interface SelectedSearch {
        void selectedSearch(Search search);
    }

    // Bottom Sheet (long click for each items):
    public void showBottomSheet(View view) {
        BottomSheetLongClickItem addPhotoBottomDialogFragment =
                BottomSheetLongClickItem.newInstance();
        addPhotoBottomDialogFragment.show(((AppCompatActivity) context).getSupportFragmentManager(),
                BottomSheetLongClickItem.TAG);
    }
}
