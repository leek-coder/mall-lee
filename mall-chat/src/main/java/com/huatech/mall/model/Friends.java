package com.huatech.mall.model;

/**
 *  
 * 表:friends 
 * @author like 
 * @date 2021-01-27 
 */
public class Friends {
    /**
     * 
     * 表字段:id
     */
    private String id;

    /**
     * 用户id
     * 表字段:my_user_id
     */
    private String myUserId;

    /**
     * 用户的好友id
     * 表字段:my_friend_user_id
     */
    private String myFriendUserId;

    /**
     * 获取
     * @return id String
     */
    public String getId() {
        return id;
    }

    /**
     * 设置
     * @param id 
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取用户id
     * @return myUserId String
     */
    public String getMyUserId() {
        return myUserId;
    }

    /**
     * 设置用户id
     * @param myUserId 用户id
     */
    public void setMyUserId(String myUserId) {
        this.myUserId = myUserId == null ? null : myUserId.trim();
    }

    /**
     * 获取用户的好友id
     * @return myFriendUserId String
     */
    public String getMyFriendUserId() {
        return myFriendUserId;
    }

    /**
     * 设置用户的好友id
     * @param myFriendUserId 用户的好友id
     */
    public void setMyFriendUserId(String myFriendUserId) {
        this.myFriendUserId = myFriendUserId == null ? null : myFriendUserId.trim();
    }
}