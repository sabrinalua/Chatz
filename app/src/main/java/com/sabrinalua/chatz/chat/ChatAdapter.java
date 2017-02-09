package com.sabrinalua.chatz.chat;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sabrinalua.chatz.R;

import java.util.ArrayList;

/**
 * Created by sabrinalua on 09/02/2017.
 */

public class ChatAdapter extends BaseAdapter{
    private static LayoutInflater inflater = null;
    private Context context;
    private ArrayList<ChatMessage> chatList;

    public ChatAdapter(Context context, ArrayList<ChatMessage> chatList) {
        this.context = context;
        this.chatList = chatList;
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return chatList.size();
    }

    @Override
    public Object getItem(int position) {
        return chatList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ChatMessage cur = (ChatMessage)getItem(position);
        if (convertView==null){
            convertView = inflater.inflate(R.layout.chatbubble,null);
        }
        TextView tv = (TextView)convertView.findViewById(R.id.message_text);
        tv.setText(cur.getText());
        LinearLayout layout = (LinearLayout) convertView
                .findViewById(R.id.bubble_layout);
        LinearLayout parent_layout = (LinearLayout) convertView
                .findViewById(R.id.bubble_layout_parent);
        if (cur.isMine()) {
            layout.setBackgroundResource(R.drawable.bubble2);
            parent_layout.setGravity(Gravity.RIGHT);
        }
        else {
            layout.setBackgroundResource(R.drawable.bubble1);
            parent_layout.setGravity(Gravity.LEFT);
        }
        return convertView;
    }

//    @Override
    public View getViewz(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.chatlistz,parent,false);
        }
        TextView tv = (TextView)convertView.findViewById(R.id.text_view_item_name);
        ChatMessage cur = (ChatMessage)getItem(position);
        tv.setText(cur.getText());
        if(cur.isMine()){
            tv.setBackgroundResource(R.drawable.bubble2);
        }
        return convertView;
    }
}
