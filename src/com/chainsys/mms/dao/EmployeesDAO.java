package com.chainsys.mms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.chainsys.mms.model.Employees;
import com.chainsys.mms.util.ConnectionUtil;

public class EmployeesDAO {

	ResultSet resultSet = null;

	/**
	 * This method insert the employee details 
	 * @param emp
	 * @throws Exception
	 */
	public void addEmployee(Employees emp) throws Exception {
		Connection connection = null;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = ConnectionUtil.getConnection();
			System.out.println(connection);
			String sql = "insert into mms_employee(emp_id,emp_name,emp_desig,emp_gender,dept_id,emp_email,emp_pwd,created_at)values(?,?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, emp.getEmp_id());
			preparedStatement.setString(2, emp.getEmp_name());
			preparedStatement.setString(3, emp.getEmp_desig());
			preparedStatement.setString(4, emp.getEmp_gender());
			preparedStatement.setInt(5, emp.getDept_id());
			preparedStatement.setString(6, emp.getEmp_email());
			preparedStatement.setString(7, emp.getEmp_pwd());
			preparedStatement.setString(8, emp.getCreated_at());
			int rows = preparedStatement.executeUpdate();
			System.out.println("Rows inserted: " + rows);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(connection, preparedStatement, resultSet);
		}
	}

	/**
	 * This method allows the doctor to login by checking email and password
	 * @param e
	 * @return
	 * @throws SQLException
	 */
	public boolean existingDoctors(Employees e) throws SQLException {
		boolean login = false;
		Connection connection = ConnectionUtil.getConnection();
		String sql = "select emp_email,emp_pwd from mms_employee where emp_desig='Doctor' and emp_email=? and emp_pwd=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		try {
			preparedStatement.setString(1, e.getEmp_email());
			preparedStatement.setString(2, e.getEmp_pwd());
			System.out.println(e.toString());
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				String checkEmp = resultSet.getString("emp_email");
				String checkPass = resultSet.getString("emp_pwd");
				if ((checkEmp.equalsIgnoreCase(e.getEmp_email())) && (checkPass.equals(e.getEmp_pwd()))) {
					login = true;
				} else {
					login = false;
				}
				login = true;
			} else {
				login = false;
				System.out.println("Invalid");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		connection.close();
		return login;
	}

	/**
	 * This method checks whether the doctor has an entered a correct email
	 * @param e
	 * @return
	 * @throws SQLException
	 */
	public boolean checkEmployees(Employees e) throws SQLException {
		boolean check = false;
		Connection connection = ConnectionUtil.getConnection();
		String sql = "select emp_email from mms_employee where emp_email=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, e.getEmp_email());
		System.out.println(e.getEmp_email());
		resultSet = preparedStatement.executeQuery();
		try {
			if (resultSet.next()) {
				check = false;
				return check;
			} else {
				check = true;
				return check;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		connection.close();
		return check;
	}
}