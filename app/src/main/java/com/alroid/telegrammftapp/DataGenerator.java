package com.alroid.telegrammftapp;

import android.content.Context;
import android.content.res.Resources;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import com.alroid.telegrammftapp.entity.Call;
import com.alroid.telegrammftapp.entity.Chat;
import com.alroid.telegrammftapp.entity.Search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataGenerator {

    public static List<Chat> getChats(Context context) {
        List<Chat> chats = new ArrayList<>();
        Resources resources = context.getResources();
        String[] userName = resources.getStringArray(R.array.userNames);
        String[] messages = resources.getStringArray(R.array.messages);
        String[] hours = resources.getStringArray(R.array.message_hours);
        String[] messageNum = resources.getStringArray(R.array.message_numbers);

        for (int i = 0; i < userName.length; i++) {
            Chat chat = new Chat();
            chat.setId(i);
            switch (i) {
                case 0:
                    chat.setImgUser(ContextCompat.getDrawable(context, R.drawable.user_pic_01));
                    chat.setUserName(userName[0]);
                    chat.setHour(hours[0]);
                    chat.setMessage(messages[0]);
                    chat.setMessageNumber(messageNum[0]);
                    break;
                case 1:
                    chat.setImgUser(ContextCompat.getDrawable(context, R.drawable.user_pic_02));
                    chat.setUserName(userName[1]);
                    chat.setHour(hours[1]);
                    chat.setMessage(messages[1]);
                    chat.setMessageNumber(messageNum[1]);
                    break;
                case 2:
                    chat.setImgUser(ContextCompat.getDrawable(context, R.drawable.user_pic_03));
                    chat.setUserName(userName[2]);
                    chat.setHour(hours[2]);
                    chat.setMessage(messages[2]);
                    chat.setMessageNumber(messageNum[2]);
                    break;
                case 3:
                    chat.setImgUser(ContextCompat.getDrawable(context, R.drawable.user_pic_04));
                    chat.setUserName(userName[3]);
                    chat.setHour(hours[3]);
                    chat.setMessage(messages[3]);
                    chat.setMessageNumber(messageNum[3]);
                    break;
                case 4:
                    chat.setImgUser(ContextCompat.getDrawable(context, R.drawable.user_pic_05));
                    chat.setUserName(userName[4]);
                    chat.setHour(hours[4]);
                    chat.setMessage(messages[4]);
                    chat.setMessageNumber(messageNum[4]);
                    break;
                case 5:
                    chat.setImgUser(ContextCompat.getDrawable(context, R.drawable.user_pic_06));
                    chat.setUserName(userName[5]);
                    chat.setHour(hours[5]);
                    chat.setMessage(messages[5]);
                    chat.setMessageNumber(messageNum[5]);
                    break;
                case 6:
                    chat.setImgUser(ContextCompat.getDrawable(context, R.drawable.user_pic_07));
                    chat.setUserName(userName[6]);
                    chat.setHour(hours[6]);
                    chat.setMessage(messages[6]);
                    chat.setMessageNumber(messageNum[6]);
                    break;
                case 7:
                    chat.setImgUser(ContextCompat.getDrawable(context, R.drawable.user_pic_08));
                    chat.setUserName(userName[7]);
                    chat.setHour(hours[7]);
                    chat.setMessage(messages[7]);
                    chat.setMessageNumber(messageNum[7]);
                    break;
                case 8:
                    chat.setImgUser(ContextCompat.getDrawable(context, R.drawable.user_pic_09));
                    chat.setUserName(userName[8]);
                    chat.setHour(hours[8]);
                    chat.setMessage(messages[8]);
                    chat.setMessageNumber(messageNum[8]);
                    break;
                case 9:
                    chat.setImgUser(ContextCompat.getDrawable(context, R.drawable.user_pic_10));
                    chat.setUserName(userName[9]);
                    chat.setHour(hours[9]);
                    chat.setMessage(messages[9]);
                    chat.setMessageNumber(messageNum[9]);
                    break;
                case 10:
                    chat.setImgUser(ContextCompat.getDrawable(context, R.drawable.user_pic_11));
                    chat.setUserName(userName[10]);
                    chat.setHour(hours[10]);
                    chat.setMessage(messages[10]);
                    chat.setMessageNumber(messageNum[10]);
                    break;
            }
            chats.add(chat);
        }
        return chats;
    }

    public static List<Call> getCalls(Context context) {
        List<Call> calls = new ArrayList<>();
        Resources resources = context.getResources();
        String[] userName = resources.getStringArray(R.array.userNames);
        String[] messages = resources.getStringArray(R.array.messages_call);
        String[] hours = resources.getStringArray(R.array.message_hours);
        String[] dates = resources.getStringArray(R.array.dates);

        for (int i = 0; i < userName.length; i++) {
            Call call = new Call();
            call.setId(i);
            switch (i) {
                case 0:
                    call.setImgUser(ContextCompat.getDrawable(context, R.drawable.user_pic_10));
                    call.setUserName(userName[9]);
                    call.setHour(hours[9]);
                    call.setMessage(messages[9]);
                    call.setDate(dates[0]);
                    break;
                case 1:
                    call.setImgUser(ContextCompat.getDrawable(context, R.drawable.user_pic_10));
                    call.setUserName(userName[9]);
                    call.setHour(hours[9]);
                    call.setMessage(messages[9]);
                    call.setDate(dates[1]);
                    break;
                case 2:
                    call.setImgUser(ContextCompat.getDrawable(context, R.drawable.user_pic_01));
                    call.setUserName(userName[0]);
                    call.setHour(hours[0]);
                    call.setMessage(messages[0]);
                    call.setDate(dates[2]);
                    break;
                case 3:
                    call.setImgUser(ContextCompat.getDrawable(context, R.drawable.user_pic_04));
                    call.setUserName(userName[3]);
                    call.setHour(hours[3]);
                    call.setMessage(messages[3]);
                    call.setDate(dates[3]);
                    break;
                case 4:
                    call.setImgUser(ContextCompat.getDrawable(context, R.drawable.user_pic_05));
                    call.setUserName(userName[4]);
                    call.setHour(hours[4]);
                    call.setMessage(messages[4]);
                    call.setDate(dates[4]);
                    break;
                case 5:
                    call.setImgUser(ContextCompat.getDrawable(context, R.drawable.user_pic_06));
                    call.setUserName(userName[5]);
                    call.setHour(hours[5]);
                    call.setMessage(messages[5]);
                    call.setDate(dates[5]);
                    break;
                case 6:
                    call.setImgUser(ContextCompat.getDrawable(context, R.drawable.user_pic_07));
                    call.setUserName(userName[6]);
                    call.setHour(hours[6]);
                    call.setMessage(messages[6]);
                    call.setDate(dates[6]);
                    break;
                case 7:
                    call.setImgUser(ContextCompat.getDrawable(context, R.drawable.user_pic_08));
                    call.setUserName(userName[7]);
                    call.setHour(hours[7]);
                    call.setMessage(messages[7]);
                    call.setDate(dates[7]);
                    break;
                case 8:
                    call.setImgUser(ContextCompat.getDrawable(context, R.drawable.user_pic_09));
                    call.setUserName(userName[8]);
                    call.setHour(hours[8]);
                    call.setMessage(messages[8]);
                    call.setDate(dates[8]);
                    break;
                case 9:
                    call.setImgUser(ContextCompat.getDrawable(context, R.drawable.user_pic_10));
                    call.setUserName(userName[9]);
                    call.setHour(hours[9]);
                    call.setMessage(messages[9]);
                    call.setDate(dates[9]);
                    break;
                case 10:
                    call.setImgUser(ContextCompat.getDrawable(context, R.drawable.user_pic_02));
                    call.setUserName(userName[1]);
                    call.setHour(hours[1]);
                    call.setMessage(messages[1]);
                    call.setDate(dates[10]);
                    break;
            }
            calls.add(call);
        }
        return calls;
    }

    public static List<Search> getSearchListRecent(Context context) {
        List<Search> searches = new ArrayList<>();
        Resources resources = context.getResources();
        String[] userName = resources.getStringArray(R.array.userNames);

        for (int i = 0; i < userName.length; i++) {
            Search search = new Search();
            search.setId(i);
            switch (i) {
                case 0:
                    search.setImgUser(ContextCompat.getDrawable(context, R.drawable.user_pic_01));
                    search.setUserName(userName[0]);
                    break;
                case 1:
                    search.setImgUser(ContextCompat.getDrawable(context, R.drawable.user_pic_02));
                    search.setUserName(userName[1]);
                    break;
                case 2:
                    search.setImgUser(ContextCompat.getDrawable(context, R.drawable.user_pic_03));
                    search.setUserName(userName[2]);
                    break;
                case 3:
                    search.setImgUser(ContextCompat.getDrawable(context, R.drawable.user_pic_04));
                    search.setUserName(userName[3]);
                    break;
                case 4:
                    search.setImgUser(ContextCompat.getDrawable(context, R.drawable.user_pic_05));
                    search.setUserName(userName[4]);
                    break;
                case 5:
                    search.setImgUser(ContextCompat.getDrawable(context, R.drawable.user_pic_06));
                    search.setUserName(userName[5]);
                    break;
                case 6:
                    search.setImgUser(ContextCompat.getDrawable(context, R.drawable.user_pic_07));
                    search.setUserName(userName[6]);
                    break;
                case 7:
                    search.setImgUser(ContextCompat.getDrawable(context, R.drawable.user_pic_08));
                    search.setUserName(userName[7]);
                    break;
                case 8:
                    search.setImgUser(ContextCompat.getDrawable(context, R.drawable.user_pic_09));
                    search.setUserName(userName[8]);
                    break;
                case 9:
                    search.setImgUser(ContextCompat.getDrawable(context, R.drawable.user_pic_10));
                    search.setUserName(userName[9]);
                    break;
                case 10:
                    search.setImgUser(ContextCompat.getDrawable(context, R.drawable.user_pic_11));
                    search.setUserName(userName[10]);
                    break;
            }
            searches.add(search);
        }
        return searches;
    }

    public static List<Search> getSearchListPeople(Context context) {
        List<Search> searches = new ArrayList<>();
        Resources resources = context.getResources();
        String[] userName = resources.getStringArray(R.array.userNames);

        for (int i = 0; i < userName.length; i++) {
            Search search = new Search();
            search.setId(i);
            switch (i) {
                case 0:
                    search.setImgUser(ContextCompat.getDrawable(context, R.drawable.user_pic_01));
                    search.setUserName(userName[0]);
                    break;
                case 1:
                    search.setImgUser(ContextCompat.getDrawable(context, R.drawable.user_pic_02));
                    search.setUserName(userName[1]);
                    break;
                case 2:
                    search.setImgUser(ContextCompat.getDrawable(context, R.drawable.user_pic_03));
                    search.setUserName(userName[2]);
                    break;
                case 3:
                    search.setImgUser(ContextCompat.getDrawable(context, R.drawable.user_pic_04));
                    search.setUserName(userName[3]);
                    break;
                case 4:
                    search.setImgUser(ContextCompat.getDrawable(context, R.drawable.user_pic_05));
                    search.setUserName(userName[4]);
                    break;
                case 5:
                    search.setImgUser(ContextCompat.getDrawable(context, R.drawable.user_pic_06));
                    search.setUserName(userName[5]);
                    break;
                case 6:
                    search.setImgUser(ContextCompat.getDrawable(context, R.drawable.user_pic_07));
                    search.setUserName(userName[6]);
                    break;
                case 7:
                    search.setImgUser(ContextCompat.getDrawable(context, R.drawable.user_pic_08));
                    search.setUserName(userName[7]);
                    break;
                case 8:
                    search.setImgUser(ContextCompat.getDrawable(context, R.drawable.user_pic_09));
                    search.setUserName(userName[8]);
                    break;
                case 9:
                    search.setImgUser(ContextCompat.getDrawable(context, R.drawable.user_pic_10));
                    search.setUserName(userName[9]);
                    break;
                case 10:
                    search.setImgUser(ContextCompat.getDrawable(context, R.drawable.user_pic_11));
                    search.setUserName(userName[10]);
                    break;
            }
            searches.add(search);
        }
        return searches;
    }
}
