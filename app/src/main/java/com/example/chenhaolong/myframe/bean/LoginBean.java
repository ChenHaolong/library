package com.example.chenhaolong.myframe.bean;

/**
 * Name MyFrame
 * Created by chenhaolong on 2016/8/18.
 */
public class LoginBean{

    /**
     * uid : 25035852
     * ss : yNMuEjzghyqrXdVFFofU4gUWUBHfDMYA
     * username : 阿哥
     * mobile : 13119110371
     * privilege_id : 1001000000
     * push_service_type : 2
     * piv : 171
     * pav : 15
     * lps_server : 210.14.72.52
     * lps_server_port : 1183
     * fristaid_api_server : 210.14.72.52
     * fristaid_api_server_port : 80
     * fristaid_news_server : 210.14.72.52
     * fristaid_news_server_port : 80
     * file_server : 210.14.72.52
     * file_server_port : 80
     */

    private long uid;
    private String ss;
    private String username;
    private String mobile;
    private String privilege_id;
    private int push_service_type;
    private int piv;
    private int pav;
    private String lps_server;
    private int lps_server_port;
    private String fristaid_api_server;
    private int fristaid_api_server_port;
    private String fristaid_news_server;
    private int fristaid_news_server_port;
    private String file_server;
    private String file_server_port;

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getSs() {
        return ss;
    }

    public void setSs(String ss) {
        this.ss = ss;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPrivilege_id() {
        return privilege_id;
    }

    public void setPrivilege_id(String privilege_id) {
        this.privilege_id = privilege_id;
    }

    public int getPush_service_type() {
        return push_service_type;
    }

    public void setPush_service_type(int push_service_type) {
        this.push_service_type = push_service_type;
    }

    public int getPiv() {
        return piv;
    }

    public void setPiv(int piv) {
        this.piv = piv;
    }

    public int getPav() {
        return pav;
    }

    public void setPav(int pav) {
        this.pav = pav;
    }

    public String getLps_server() {
        return lps_server;
    }

    public void setLps_server(String lps_server) {
        this.lps_server = lps_server;
    }

    public int getLps_server_port() {
        return lps_server_port;
    }

    public void setLps_server_port(int lps_server_port) {
        this.lps_server_port = lps_server_port;
    }

    public String getFristaid_api_server() {
        return fristaid_api_server;
    }

    public void setFristaid_api_server(String fristaid_api_server) {
        this.fristaid_api_server = fristaid_api_server;
    }

    public int getFristaid_api_server_port() {
        return fristaid_api_server_port;
    }

    public void setFristaid_api_server_port(int fristaid_api_server_port) {
        this.fristaid_api_server_port = fristaid_api_server_port;
    }

    public String getFristaid_news_server() {
        return fristaid_news_server;
    }

    public void setFristaid_news_server(String fristaid_news_server) {
        this.fristaid_news_server = fristaid_news_server;
    }

    public int getFristaid_news_server_port() {
        return fristaid_news_server_port;
    }

    public void setFristaid_news_server_port(int fristaid_news_server_port) {
        this.fristaid_news_server_port = fristaid_news_server_port;
    }

    public String getFile_server() {
        return file_server;
    }

    public void setFile_server(String file_server) {
        this.file_server = file_server;
    }

    public String getFile_server_port() {
        return file_server_port;
    }

    public void setFile_server_port(String file_server_port) {
        this.file_server_port = file_server_port;
    }

    @Override
    public String toString() {
        return "LoginBean{" +
                "uid=" + uid +
                ", ss='" + ss + '\'' +
                ", username='" + username + '\'' +
                ", mobile='" + mobile + '\'' +
                ", privilege_id='" + privilege_id + '\'' +
                ", push_service_type=" + push_service_type +
                ", piv=" + piv +
                ", pav=" + pav +
                ", lps_server='" + lps_server + '\'' +
                ", lps_server_port=" + lps_server_port +
                ", fristaid_api_server='" + fristaid_api_server + '\'' +
                ", fristaid_api_server_port=" + fristaid_api_server_port +
                ", fristaid_news_server='" + fristaid_news_server + '\'' +
                ", fristaid_news_server_port=" + fristaid_news_server_port +
                ", file_server='" + file_server + '\'' +
                ", file_server_port='" + file_server_port + '\'' +
                '}';
    }
}
