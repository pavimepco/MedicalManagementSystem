package com.chainsys.mms.model;

public class Patients {
 
	private int pat_id;
	private String pat_name;
	private int pat_age;
	private long contact_num;
	private String user_name;
	private String user_pwd;
	
	public int getPat_id() {
		return pat_id;
	}
	public void setPat_id(int pat_id) {
		this.pat_id = pat_id;
	}
	public String getPat_name() {
		return pat_name;
	}
	public void setPat_name(String pat_name) {
		this.pat_name = pat_name;
	}
	public int getPat_age() {
		return pat_age;
	}
	public void setPat_age(int pat_age) {
		this.pat_age = pat_age;
	}
	public long getContact_num() {
		return contact_num;
	}
	public void setContact_num(long contact_num) {
		this.contact_num = contact_num;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_pwd() {
		return user_pwd;
	}
	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}
	public String getPat_gender() {
		return pat_gender;
	}
	public void setPat_gender(String pat_gender) {
		this.pat_gender = pat_gender;
	}
	private String pat_gender;
	
	@Override
	public String toString() {
		return "Patients [pat_id=" + pat_id + ", pat_name=" + pat_name + ", pat_age=" + pat_age + ", contact_num="
				+ contact_num + ", user_name=" + user_name + ", user_pwd=" + user_pwd + ", pat_gender=" + pat_gender
				+ "]";
	}
}
