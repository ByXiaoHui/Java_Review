package com.xiaohui.bean;

/**
 * @ClassName User
 * @Author 何辉
 * @Date 2021/5/11 14:51
 **/
public class User {
    private Integer userid;
    private String username;
    private String password;

    public User() {
        System.out.println("第一步:User构造");
    }

    public void setUsername(String username) {
        System.out.println("第二步：User set方法");
        this.username = username;
    }

    public void initUser(){
        System.out.println("第三步：User初始化");
    }

    public void destoryUser(){
        System.out.println("第五步：User 销毁");
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(Integer userid, String username, String password) {
        System.out.println("allArgConstructor");
        this.userid = userid;
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
