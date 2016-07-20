package com.fei.chatuiexer;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.fei.chatuiexer.bean.Message;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView mListView;
    private MsgAdapter mAdapter;
    private List<Message> mMessageList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initMessage();
        mListView = (ListView) findViewById(R.id.avtivity_main_list_view);
        mAdapter = new MsgAdapter(this, R.layout.list_item_chat, mMessageList);
        mListView.setAdapter(mAdapter);
        Button sendButton = (Button) findViewById(R.id.avtivity_main_button);
        final EditText msgEditText = (EditText) findViewById(R.id.activity_main_edit_text);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Message msg = new Message(1, msgEditText.getText().toString());
                mMessageList.add(msg);
                mAdapter.notifyDataSetChanged();
                mListView.setSelection(mMessageList.size());
                msgEditText.setText("");
            }
        });
    }

    private void initMessage() {
        Message msg = new Message(0, "hello guys");
        mMessageList.add(msg);
        msg = new Message(1, "hi, who is that");
        mMessageList.add(msg);
        msg = new Message(0, "this is tom");
        mMessageList.add(msg);
    }



}
