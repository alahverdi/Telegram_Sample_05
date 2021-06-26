package com.alroid.telegrammftapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.alroid.telegrammftapp.adapter.AdapterChatUser;
import com.alroid.telegrammftapp.databinding.ActivityChatTelegramBinding;
import com.alroid.telegrammftapp.entity.Message;

public class ChatTelegramActivity extends AppCompatActivity {

    ActivityChatTelegramBinding binding;

    private AdapterChatUser adapter;
    private ActionBar actionBar;
    String message, messageResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityChatTelegramBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setupToolbar();
        setupIntent();
        setupComponent();

    }

    public void setupToolbar() {
        setSupportActionBar(binding.toolbar);
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setHomeButtonEnabled(false);
        actionBar.setTitle(null);
        Tools.setSystemBarColorInt(this, Color.parseColor("#426482"));
    }

    private void setupIntent() {
        Intent intent = getIntent();
        if (intent != null) {
            int id = intent.getIntExtra("id", 0);

            Resources resources = getResources();
            String[] usersList = resources.getStringArray(R.array.userNames);
            String[] messageList = resources.getStringArray(R.array.messages);
            String[] messageResponseList = resources.getStringArray(R.array.messages_response);

            message = messageList[id];
            messageResponse = messageResponseList[id];
            binding.tvUser.setText(usersList[id]);

            switch (id) {
                case 0:
                    binding.ivUser.setImageResource(R.drawable.user_pic_01);
                    break;
                case 1:
                    binding.ivUser.setImageResource(R.drawable.user_pic_02);
                    break;
                case 2:
                    binding.ivUser.setImageResource(R.drawable.user_pic_03);
                    break;
                case 3:
                    binding.ivUser.setImageResource(R.drawable.user_pic_04);
                    break;
                case 4:
                    binding.ivUser.setImageResource(R.drawable.user_pic_05);
                    break;
                case 5:
                    binding.ivUser.setImageResource(R.drawable.user_pic_06);
                    break;
                case 6:
                    binding.ivUser.setImageResource(R.drawable.user_pic_07);
                    break;
                case 7:
                    binding.ivUser.setImageResource(R.drawable.user_pic_08);
                    break;
                case 8:
                    binding.ivUser.setImageResource(R.drawable.user_pic_09);
                    break;
                case 9:
                    binding.ivUser.setImageResource(R.drawable.user_pic_10);
                    break;
                case 10:
                    binding.ivUser.setImageResource(R.drawable.user_pic_11);
                    break;
            }
        }
    }

    public void setupComponent() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recyclerView.setLayoutManager(layoutManager);
        binding.recyclerView.setHasFixedSize(true);

        adapter = new AdapterChatUser(this);
        binding.recyclerView.setAdapter(adapter);
        adapter.insertItem(new Message(adapter.getItemCount(), message, false, adapter.getItemCount() % 5 == 0, Tools.getFormattedTimeEvent(System.currentTimeMillis())));
        adapter.insertItem(new Message(adapter.getItemCount(), messageResponse, true, adapter.getItemCount() % 5 == 0, Tools.getFormattedTimeEvent(System.currentTimeMillis())));


        binding.btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendChat();
            }
        });
        binding.textContent.addTextChangedListener(contentWatcher);

        (findViewById(R.id.lyt_back)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void sendChat() {
        final String msg = binding.textContent.getText().toString();
        if (msg.isEmpty()) return;
        adapter.insertItem(new Message(adapter.getItemCount(), msg, true, adapter.getItemCount() % 5 == 0, Tools.getFormattedTimeEvent(System.currentTimeMillis())));
        binding.textContent.setText("");
        binding.recyclerView.scrollToPosition(adapter.getItemCount() - 1);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                adapter.insertItem(new Message(adapter.getItemCount(), msg, false, adapter.getItemCount() % 5 == 0, Tools.getFormattedTimeEvent(System.currentTimeMillis())));
                binding.recyclerView.scrollToPosition(adapter.getItemCount() - 1);
            }
        }, 1000);
    }

    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);
        hideKeyboard();
    }

    private void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    private TextWatcher contentWatcher = new TextWatcher() {
        @Override
        public void afterTextChanged(Editable etd) {
            if (etd.toString().trim().length() == 0) {
                binding.btnSend.setImageResource(R.drawable.ic_mic);
            } else {
                binding.btnSend.setImageResource(R.drawable.ic_send);
            }
        }

        @Override
        public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
        }

        @Override
        public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_chat_telegram, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        } else {
            Toast.makeText(getApplicationContext(), item.getTitle() + " clicked", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

}