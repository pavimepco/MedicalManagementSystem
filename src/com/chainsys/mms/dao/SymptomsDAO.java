package com.chainsys.mms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.chainsys.mms.model.Departments;
import com.chainsys.mms.model.DoctorList;
import com.chainsys.mms.model.Employees;
import com.chainsys.mms.model.Symptoms;
import com.chainsys.mms.util.ConnectionUtil;

public class SymptomsDAO {

	/**
	 * This method finds the department name and doctor name by entering the symptom name
	 * @param s
	 * @return
	 * @throws SQLException
	 */
	public List findall(Symptoms s) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		String sql = "select s.sym_name,d.dept_name,e.emp_name from mms_employee e inner join trn_depart d on e.dept_id=d.dept_id\r\n"
				+ "join trn_symptom s on s.dep_id=d.dept_id where e.emp_desig='Doctor' and s.sym_name=?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		System.out.println(s.getSym_name());
		stmt.setString(1, s.getSym_name());
		ResultSet resultset = stmt.executeQuery();
		List l = new ArrayList();
		Map map = new HashMap();
		while (resultset.next()) {
			Symptoms obj = new Symptoms();
			Departments d1 = new Departments();
			Employees e1 = new Employees();
			obj.setSym_name(resultset.getString("sym_name"));
			d1.setDept_name(resultset.getString("dept_name"));
			e1.setEmp_name(resultset.getString("emp_name"));
			System.out.println(obj.getSym_name() + " " + d1.getDept_name() + " " + e1.getEmp_name());
			map.put(obj.getSym_name() + "d", d1.getDept_name());
			map.put(obj.getSym_name(), e1.getEmp_name());
			l.add(map);
		}
		connection.close();
		return l;
	}

	public List<DoctorList> findDoctor(Symptoms s) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		String sql = "select s.sym_name,d.dept_name,e.emp_name from mms_employee e inner join trn_depart d on e.dept_id=d.dept_id\r\n"
				+ "join trn_symptom s on s.dep_id=d.dept_id where e.emp_desig='Doctor' and s.sym_name=?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		System.out.println(s.getSym_name());
		stmt.setString(1, s.getSym_name());
		ResultSet resultset = stmt.executeQuery();
		List<DoctorList> l = new ArrayList<DoctorList>();
		while (resultset.next()) {
			DoctorList dl = new DoctorList();
			dl.setSname(resultset.getString("sym_name"));
			dl.setDname(resultset.getString("dept_name"));
			dl.setEname(resultset.getString("emp_name"));
			l.add(dl);
			System.out.println(l);
		}
		connection.close();
		return l;
	}

	/**
	 * This method check whether the given symptom is existing or not
	 * @param s
	 * @return
	 * @throws SQLException
	 */
	public boolean checkSymptoms(Symptoms s) throws SQLException {
		boolean signup = false;
		Connection connection = ConnectionUtil.getConnection();
		String sql = "select sym_name from trn_symptom where sym_name=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, s.getSym_name());
		ResultSet resultSet = preparedStatement.executeQuery();
		try {
			if (resultSet.next()) {
				signup = true;
				return signup;
			} else {
				signup = false;
				return signup;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		connection.close();
		return signup;
	}
}
