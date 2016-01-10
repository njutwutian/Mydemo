package com.easygo.model;
import java.lang.String;

public class UserModel {
    //UserModel中使用字段 与数据库user表 字段相对应
	private int id;
    private String nameString;
    private String passwordString;
    private String emailString;
    private boolean isEnable;
    //构造函数
    public UserModel(){
    	
    }
    //重载构造方便赋值
    public UserModel(int id,String nameString,String passwordString,String emailString,boolean isEnable){
    	setId(id);
    	setNameString(nameString);
    	setPasswordString(passwordString);
    	setEmailString(emailString);
    	setEnable(isEnable);
    }
    //set get 方法
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNameString() {
		return nameString;
	}
	public void setNameString(String namesString) {
		this.nameString = namesString;
	}
	public String getPasswordString() {
		return passwordString;
	}
	public void setPasswordString(String passwordsString) {
		this.passwordString = passwordsString;
	}
	public String getEmailString() {
		return emailString;
	}
	public void setEmailString(String emailString) {
		this.emailString = emailString;
	}
	public boolean isEnable() {
		return isEnable;
	}
	public void setEnable(boolean isEnable) {
		this.isEnable = isEnable;
	}       
}
