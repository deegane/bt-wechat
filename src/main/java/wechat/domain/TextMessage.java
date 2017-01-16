package wechat.domain;

import com.google.common.base.MoreObjects;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/*
" <xml>\n" +
" <ToUserName><![CDATA[oGrjQwittaEKUf2IEkANfkm1z9xs]]></ToUserName>\n" +
" <FromUserName><![CDATA[gh_fb68c8869e2a]]></FromUserName>\n" +
" <CreateTime>"+new Date().getTime()+"</CreateTime>\n" +
" <MsgType><![CDATA[text]]></MsgType>\n" +
" <Content><![CDATA["+message+"]]></Content>\n" +
" </xml>";
 */

@XmlRootElement(name = "xml")
public class TextMessage {
    @XmlElement(name = "ToUserName")
    public String toUserName;
    @XmlElement(name = "FromUserName")
    public String fromUserName;
    @XmlElement(name = "CreateTime")
    public String createTime;
    @XmlElement(name = "MsgType")
    public String msgType;
    @XmlElement(name = "Content")
    public String content;
    @XmlElement(name = "MsgId")
    public String msgId;


    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("toUserName", toUserName)
                .add("fromUserName", fromUserName)
                .add("createTime", createTime)
                .add("msgType", msgType)
                .add("content", content)
                .add("msgId", msgId)
                .toString();
    }
}
