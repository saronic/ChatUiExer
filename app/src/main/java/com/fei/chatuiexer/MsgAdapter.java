package com.fei.chatuiexer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fei.chatuiexer.bean.Message;

import java.util.List;

/**
 * Created by lee on 2016/7/20.
 */
public class MsgAdapter extends ArrayAdapter<Message> {
    private Context mContext;

    public MsgAdapter(Context context, int resource, List<Message> msgList) {
        super(context, resource, msgList);
        mContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        Message msg = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.list_item_chat, parent,
                    false);
            viewHolder = new ViewHolder();
            viewHolder.mLeftLinearLayout = (LinearLayout) convertView.findViewById(
                    R.id.list_item_chat_left_linear_layout);
            viewHolder.mRightLinearLayout = (LinearLayout) convertView.findViewById(
                    R.id.list_item_chat_right_linear_layout);
            viewHolder.mLeftTextView = (TextView) convertView.findViewById(
                    R.id.list_item_left_text_view);
            viewHolder.mRightTextView = (TextView) convertView.findViewById(
                    R.id.list_item_right_text_view);
            convertView.setTag(viewHolder);
        }

        viewHolder = (ViewHolder) convertView.getTag();

        if (msg.getMsgType() == Message.TYPE_RECEIVE) {
            viewHolder.mRightLinearLayout.setVisibility(View.GONE);
            viewHolder.mLeftLinearLayout.setVisibility(View.VISIBLE);
            viewHolder.mLeftTextView.setText(msg.getMsgContent());
        } else {
            viewHolder.mLeftLinearLayout.setVisibility(View.GONE);
            viewHolder.mRightLinearLayout.setVisibility(View.VISIBLE);
            viewHolder.mRightTextView.setText(msg.getMsgContent());
        }


        return convertView;
    }

    class ViewHolder {
        LinearLayout mLeftLinearLayout;
        LinearLayout mRightLinearLayout;
        TextView mLeftTextView;
        TextView mRightTextView;
    }

}