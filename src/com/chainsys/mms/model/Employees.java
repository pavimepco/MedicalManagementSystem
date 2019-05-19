package com.chainsys.mms.model;

public class Employees {
	private int emp_id;
	private String emp_name;
	private String emp_desig;

	private String emp_gender;
	private int dept_id;

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public String getEmp_desig() {
		return emp_desig;
	}

	public void setEmp_desig(String emp_desig) {
		this.emp_desig = emp_desig;
	}

	public String getEmp_gender() {
		return emp_gender;
	}

	public void setEmp_gender(String emp_gender) {
		this.emp_gender = emp_gender;
	}

	public int getDept_id() {
		return dept_id;
	}

	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}

	public String getEmp_email() {
		return emp_email;
	}

	public void setEmp_email(String emp_email) {
		this.emp_email = emp_email;
	}

	public String getEmp_pwd() {
		return emp_pwd;
	}

	public void setEmp_pwd(String emp_pwd) {
		this.emp_pwd = emp_pwd;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	private String emp_email;
	private String emp_pwd;
	private String created_at;

	@Override
	public String toString() {
		return "Employees [emp_id=" + emp_id + ", emp_name=" + emp_name + ", emp_desig=" + emp_desig + ", emp_gender="
				+ emp_gender + ", dept_id=" + dept_id + ", emp_email=" + emp_email + ", emp_pwd=" + emp_pwd
				+ ", created_at=" + created_at + "]";
	}

}
