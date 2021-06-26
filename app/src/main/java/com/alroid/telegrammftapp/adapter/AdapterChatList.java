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
import com.alroid.telegrammftapp.entity.Chat;
import com.alroid.telegrammftapp.fragment.BottomSheetLongClickItem;

import java.util.List;

public class AdapterChatList extends RecyclerView.Adapter<AdapterChatList.LikesViewHolder> {
    Context context;
    List<Chat> ChatList;
    SelectedChat selectedChat;

    public AdapterChatList(Context context, List<Chat> chatList, SelectedChat selectedChat) {
        this.context = context;
        this.ChatList = chatList;
        this.selectedChat = selectedChat;
    }

    @NonNull
    @Override
    public LikesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_message, parent, false);
        return new LikesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LikesViewHolder holder, int position) {
        Chat message = ChatList.get(position);

        holder.iv_user.setImageDrawable(message.getImgUser());
        holder.tv_userName.setText(message.getUserName());
        holder.tv_message.setText(message.getMessage());
        holder.tv_hour.setText(message.getHour());
        holder.messageNum.setText(message.getMessageNumber());

    }

    @Override
    public int getItemCount() {
        return ChatList.size();
    }

    public class LikesViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_user;
        TextView tv_userName,
                tv_message,
                tv_hour,
                messageNum;

        // constructor:
        public LikesViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_user = itemView.findViewById(R.id.iv_user);
            tv_userName = itemView.findViewById(R.id.tv_userName);
            tv_message = itemView.findViewById(R.id.tv_message);
            tv_hour = itemView.findViewById(R.id.tv_hour);
            messageNum = itemView.findViewById(R.id.messageNum);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(context, "clicked", Toast.LENGTH_SHORT).show();
                    selectedChat.selectedChat(ChatList.get(getAdapterPosition()));
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

    public interface SelectedChat {
        void selectedChat(Chat chat);
    }

    // Bottom Sheet (long click for each items):
    public void showBottomSheet(View view) {
        BottomSheetLongClickItem addPhotoBottomDialogFragment =
                BottomSheetLongClickItem.newInstance();
        addPhotoBottomDialogFragment.show(((AppCompatActivity) context).getSupportFragmentManager(),
                BottomSheetLongClickItem.TAG);
    }
}
