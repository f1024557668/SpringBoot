package cn.itcast.springboot.model;

import javax.persistence.Id;

/**
 * Created by Administrator on 2017/6/16.
 */
public class MessageInfo {
    @Id
    private String id;

    private String title;

    private String msgType;

    private String msgInfo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getMsgInfo() {
        return msgInfo;
    }

    public void setMsgInfo(String msgInfo) {
        this.msgInfo = msgInfo;
    }

    @Override
    public String toString() {
        return "[ id ="+id+", title ="+title+", msgInfo="+msgInfo+" ]";
    }
}
