package com.easygo.model;
import java.lang.String;

public class UserModel {
    //UserModel��ʹ���ֶ� �����ݿ�user�� �ֶ����Ӧ
	private int id;
    private String nameString;
    private String passwordString;
    private String emailString;
    private boolean isEnable;
    //���캯��
    public UserModel(){
    	
    }
    //���ع��췽�㸳ֵ
    public UserModel(int id,String nameString,String passwordString,String emailString,boolean isEnable){
    	setId(id);
    	setNameString(nameString);
    	setPasswordString(passwordString);
    	setEmailString(emailString);
    	setEnable(isEnable);
    }
    //set get ����
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
