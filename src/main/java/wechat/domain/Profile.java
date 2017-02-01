package wechat.domain;

import com.fasterxml.jackson.annotation.*;
import com.google.common.base.MoreObjects;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
"subscribe",
"openid",
"nickname",
"sex",
"language",
"city",
"province",
"country",
"headimgurl",
"subscribe_time",
"remark",
"groupid",
"tagid_list"
})
public class Profile {

@JsonProperty("subscribe")
private Integer subscribe;
@JsonProperty("openid")
private String openid;
@JsonProperty("nickname")
private String nickname;
@JsonProperty("sex")
private Integer sex;
@JsonProperty("language")
private String language;
@JsonProperty("city")
private String city;
@JsonProperty("province")
private String province;
@JsonProperty("country")
private String country;
@JsonProperty("headimgurl")
private String headimgurl;
@JsonProperty("subscribe_time")
private Integer subscribeTime;
@JsonProperty("remark")
private String remark;
@JsonProperty("groupid")
private Integer groupid;
@JsonProperty("tagid_list")
private List<Object> tagidList = new ArrayList<Object>();
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

/**
* 
* @return
* The subscribe
*/
@JsonProperty("subscribe")
public Integer getSubscribe() {
return subscribe;
}

/**
* 
* @param subscribe
* The subscribe
*/
@JsonProperty("subscribe")
public void setSubscribe(Integer subscribe) {
this.subscribe = subscribe;
}

/**
* 
* @return
* The openid
*/
@JsonProperty("openid")
public String getOpenid() {
return openid;
}

/**
* 
* @param openid
* The openid
*/
@JsonProperty("openid")
public void setOpenid(String openid) {
this.openid = openid;
}

/**
* 
* @return
* The nickname
*/
@JsonProperty("nickname")
public String getNickname() {
return nickname;
}

/**
* 
* @param nickname
* The nickname
*/
@JsonProperty("nickname")
public void setNickname(String nickname) {
this.nickname = nickname;
}

/**
* 
* @return
* The sex
*/
@JsonProperty("sex")
public Integer getSex() {
return sex;
}

/**
* 
* @param sex
* The sex
*/
@JsonProperty("sex")
public void setSex(Integer sex) {
this.sex = sex;
}

/**
* 
* @return
* The language
*/
@JsonProperty("language")
public String getLanguage() {
return language;
}

/**
* 
* @param language
* The language
*/
@JsonProperty("language")
public void setLanguage(String language) {
this.language = language;
}

/**
* 
* @return
* The city
*/
@JsonProperty("city")
public String getCity() {
return city;
}

/**
* 
* @param city
* The city
*/
@JsonProperty("city")
public void setCity(String city) {
this.city = city;
}

/**
* 
* @return
* The province
*/
@JsonProperty("province")
public String getProvince() {
return province;
}

/**
* 
* @param province
* The province
*/
@JsonProperty("province")
public void setProvince(String province) {
this.province = province;
}

/**
* 
* @return
* The country
*/
@JsonProperty("country")
public String getCountry() {
return country;
}

/**
* 
* @param country
* The country
*/
@JsonProperty("country")
public void setCountry(String country) {
this.country = country;
}

/**
* 
* @return
* The headimgurl
*/
@JsonProperty("headimgurl")
public String getHeadimgurl() {
return headimgurl;
}

/**
* 
* @param headimgurl
* The headimgurl
*/
@JsonProperty("headimgurl")
public void setHeadimgurl(String headimgurl) {
this.headimgurl = headimgurl;
}

/**
* 
* @return
* The subscribeTime
*/
@JsonProperty("subscribe_time")
public Integer getSubscribeTime() {
return subscribeTime;
}

/**
* 
* @param subscribeTime
* The subscribe_time
*/
@JsonProperty("subscribe_time")
public void setSubscribeTime(Integer subscribeTime) {
this.subscribeTime = subscribeTime;
}

/**
* 
* @return
* The remark
*/
@JsonProperty("remark")
public String getRemark() {
return remark;
}

/**
* 
* @param remark
* The remark
*/
@JsonProperty("remark")
public void setRemark(String remark) {
this.remark = remark;
}

/**
* 
* @return
* The groupid
*/
@JsonProperty("groupid")
public Integer getGroupid() {
return groupid;
}

/**
* 
* @param groupid
* The groupid
*/
@JsonProperty("groupid")
public void setGroupid(Integer groupid) {
this.groupid = groupid;
}

/**
* 
* @return
* The tagidList
*/
@JsonProperty("tagid_list")
public List<Object> getTagidList() {
return tagidList;
}




    /**
* 
* @param tagidList
* The tagid_list
*/
@JsonProperty("tagid_list")
public void setTagidList(List<Object> tagidList) {
this.tagidList = tagidList;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}


    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("subscribe", subscribe)
                .add("openid", openid)
                .add("nickname", nickname)
                .add("sex", sex)
                .add("language", language)
                .add("city", city)
                .add("province", province)
                .add("country", country)
                .add("headimgurl", headimgurl)
                .add("subscribeTime", subscribeTime)
                .add("remark", remark)
                .add("groupid", groupid)
                .add("tagidList", tagidList)
                .add("additionalProperties", additionalProperties)
                .toString();
    }

}