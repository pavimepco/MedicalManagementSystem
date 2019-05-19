package com.chainsys.mms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.chainsys.mms.model.Departments;

import com.chainsys.mms.util.ConnectionUtil;

public class DepartmentsDAO {
	ResultSet resultSet = null;
	/**
	 * 
	 * @param d
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Departments> findAll(Departments d) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		String sql = "SELECT dept_name FROM trn_depart WHERE DEPT_NAME=?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		System.out.println(d.getDept_name());
		stmt.setString(1, d.getDept_name());
		ResultSet resultset = stmt.executeQuery();
		ArrayList<Departments> dlist = new ArrayList<>();
		while (resultset.next()) {
			Departments obj = new Departments();
			obj.setDept_name(resultset.getString("dept_name"));
			dlist.add(obj);
		}
		return dlist;
	}
}
