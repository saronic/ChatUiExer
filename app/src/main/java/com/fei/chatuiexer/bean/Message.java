package com.fei.chatuiexer.bean;

/**
 * Created by lee on 2016/7/20.
 */
public class Message {
    public static final int TYPE_RECEIVE = 0;
    public static final int TYPE_SEND = 1;

    private int mMsgType;
    private String mMsgContent;

    public Message(int msgType, String msgContent) {
        mMsgType = msgType;
        mMsgContent = msgContent;
    }

    public int getMsgType() {
        return mMsgType;
    }

    public void setMsgType(int msgType) {
        mMsgType = msgType;
    }

    public String getMsgContent() {
        return mMsgContent;
    }

    public void setMsgContent(String msgContent) {
        mMsgContent = msgContent;
    }
}
