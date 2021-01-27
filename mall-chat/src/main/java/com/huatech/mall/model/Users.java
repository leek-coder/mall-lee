package com.huatech.mall.model;

/**
 *  
 * 表:user 
 * @author like 
 * @date 2021-01-27 
 */
public class Users {
    /**
     * 
     * 表字段:id
     */
    private String id;

    /**
     * 用户名，账号，慕信号
     * 表字段:username
     */
    private String username;

    /**
     * 密码
     * 表字段:password
     */
    private String password;

    /**
     * 我的头像，如果没有默认给一张
     * 表字段:face_image
     */
    private String faceImage;

    /**
     * 
     * 表字段:face_image_big
     */
    private String faceImageBig;

    /**
     * 昵称
     * 表字段:nickname
     */
    private String nickname;

    /**
     * 新用户注册后默认后台生成二维码，并且上传到fastdfs
     * 表字段:qrcode
     */
    private String qrcode;

    /**
     * 
     * 表字段:cid
     */
    private String cid;

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
     * 获取用户名，账号，慕信号
     * @return username String
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户名，账号，慕信号
     * @param username 用户名，账号，慕信号
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * 获取密码
     * @return password String
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 获取我的头像，如果没有默认给一张
     * @return faceImage String
     */
    public String getFaceImage() {
        return faceImage;
    }

    /**
     * 设置我的头像，如果没有默认给一张
     * @param faceImage 我的头像，如果没有默认给一张
     */
    public void setFaceImage(String faceImage) {
        this.faceImage = faceImage == null ? null : faceImage.trim();
    }

    /**
     * 获取
     * @return faceImageBig String
     */
    public String getFaceImageBig() {
        return faceImageBig;
    }

    /**
     * 设置
     * @param faceImageBig 
     */
    public void setFaceImageBig(String faceImageBig) {
        this.faceImageBig = faceImageBig == null ? null : faceImageBig.trim();
    }

    /**
     * 获取昵称
     * @return nickname String
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 设置昵称
     * @param nickname 昵称
     */
    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    /**
     * 获取新用户注册后默认后台生成二维码，并且上传到fastdfs
     * @return qrcode String
     */
    public String getQrcode() {
        return qrcode;
    }

    /**
     * 设置新用户注册后默认后台生成二维码，并且上传到fastdfs
     * @param qrcode 新用户注册后默认后台生成二维码，并且上传到fastdfs
     */
    public void setQrcode(String qrcode) {
        this.qrcode = qrcode == null ? null : qrcode.trim();
    }

    /**
     * 获取
     * @return cid String
     */
    public String getCid() {
        return cid;
    }

    /**
     * 设置
     * @param cid 
     */
    public void setCid(String cid) {
        this.cid = cid == null ? null : cid.trim();
    }
}