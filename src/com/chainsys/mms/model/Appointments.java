package com.chainsys.mms.model;

import java.time.LocalDate;

public class Appointments {

	private int app_id;
	private int userid;
	private String doc_name;
	private String app_time;
	private LocalDate app_date;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	
	public int getApp_id() {
		return app_id;
	}
	public void setApp_id(int app_id) {
		this.app_id = app_id;
	}
	
	public String getDoc_name() {
		return doc_name;
	}
	public void setDoc_name(String doc_name) {
		this.doc_name = doc_name;
	}
	public String getApp_time() {
		return app_time;
	}
	public void setApp_time(String app_time) {
		this.app_time = app_time;
	}
	public LocalDate getApp_date() {
		return app_date;
	}
	public void setApp_date(LocalDate date) {
		this.app_date = date;
	}
	@Override
	public String toString() {
		return "Appointments [app_id=" + app_id + ", userid=" + userid + ", doc_name=" + doc_name + ", app_time="
				+ app_time + ", app_date=" + app_date + "]";
	}
	
	
	
}
