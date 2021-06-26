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
import com.alroid.telegrammftapp.databinding.ItemCallBinding;
import com.alroid.telegrammftapp.entity.Call;
import com.alroid.telegrammftapp.fragment.BottomSheetLongClickItem;

import java.util.List;

public class AdapterCallList extends RecyclerView.Adapter<AdapterCallList.LikesViewHolder> {
    Context context;
    List<Call> callList;
    SelectedCall selectedCall;

    public AdapterCallList(Context context, List<Call> CallList, SelectedCall selectedCall) {
        this.context = context;
        this.callList = CallList;
        this.selectedCall = selectedCall;
    }

    @NonNull
    @Override
    public LikesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_call, parent, false);
        return new LikesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LikesViewHolder holder, int position) {
        Call call = callList.get(position);

        holder.iv_user.setImageDrawable(call.getImgUser());
        holder.tv_userName.setText(call.getUserName());
        holder.tv_message.setText(call.getMessage());
        holder.tv_hour.setText(call.getHour());
        holder.tv_date.setText(call.getDate());

    }

    @Override
    public int getItemCount() {
        return callList.size();
    }

    public class LikesViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_user;
        TextView tv_date,
                tv_userName,
                tv_message,
                tv_hour;

        // constructor:
        public LikesViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_user = itemView.findViewById(R.id.iv_user);
            tv_userName = itemView.findViewById(R.id.tv_userName);
            tv_message = itemView.findViewById(R.id.tv_message);
            tv_hour = itemView.findViewById(R.id.tv_hour);
            tv_date = itemView.findViewById(R.id.tv_date);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(context, "clicked", Toast.LENGTH_SHORT).show();
                    selectedCall.selectedCall(callList.get(getAdapterPosition()));
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

    public interface SelectedCall {
        void selectedCall(Call call);
    }

    // Bottom Sheet (long click for each items):
    public void showBottomSheet(View view) {
        BottomSheetLongClickItem addPhotoBottomDialogFragment =
                BottomSheetLongClickItem.newInstance();
        addPhotoBottomDialogFragment.show(((AppCompatActivity) context).getSupportFragmentManager(),
                BottomSheetLongClickItem.TAG);
    }
}
