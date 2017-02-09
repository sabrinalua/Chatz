package com.sabrinalua.chatz.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import com.sabrinalua.chatz.R;
import com.sabrinalua.chatz.chat.ChatMessage;
import com.sabrinalua.chatz.chat.ChatAdapter;

import java.util.ArrayList;

/**
 * Created by sabrinalua on 09/02/2017.
 */

public class ChatFragment extends Fragment {

    EditText et;
    ListView lv;
    ImageButton btn ;
    String TAG = "ChatFragment";
    ArrayList<ChatMessage> chats;
    ChatAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.chat_linear,container,false);
        et = (EditText)v.findViewById(R.id.messageEditText);
        lv = (ListView)v.findViewById(R.id.msgListView);
        btn =(ImageButton)v.findViewById(R.id.sendMessageButton);
        chats = new ArrayList<>();
        adapter = new ChatAdapter(getActivity(),chats);
        lv.setAdapter(adapter);
        lv.setTranscriptMode(ListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);
        lv.setStackFromBottom(true);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = et.getEditableText().toString();
                Log.e(TAG + "onclick", s+"");
                et.setText("");
                ChatMessage c= new ChatMessage(s, "123",true);
                chats.add(c);
                adapter.notifyDataSetChanged();
            }
        });
        return v;
    }
}
