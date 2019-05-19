package com.chainsys.mms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.chainsys.mms.model.Patients;
import com.chainsys.mms.util.ConnectionUtil;

public class PatientsDAO {

	ResultSet resultSet = null;

	public void addPatients(Patients p) throws Exception {
		Connection connection = null;
		System.out.println(p.getPat_name()+" "+ p.getPat_age()+" "+ p.getContact_num()+" "+p.getUser_name()+" "+p.getUser_pwd()+" "+p.getPat_gender());
		PreparedStatement preparedStatement = null;
		try {
			connection = ConnectionUtil.getConnection();
			System.out.println(connection);
			String sql = "insert into trn_patients(pat_id,pat_name,pat_age,contact_num,user_name,user_pwd,pat_gender)values(p_id_seq.NEXTVAL,?,?,?,?,?,?)";
			
			
			preparedStatement = connection.prepareStatement(sql);
			// preparedStatement.setInt(1, p.getPat_id());
			preparedStatement.setString(1, p.getPat_name());
			preparedStatement.setInt(2, p.getPat_age());
			preparedStatement.setLong(3, p.getContact_num());
			preparedStatement.setString(4, p.getUser_name());
			preparedStatement.setString(5, p.getUser_pwd());
			preparedStatement.setString(6, p.getPat_gender());

			
			int rows = preparedStatement.executeUpdate();
			System.out.println("Rows inserted: " + rows);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(connection, preparedStatement, resultSet);
		}
	}

	public boolean existingPatients(Patients p) throws SQLException {
		boolean login = false;
		Connection connection = ConnectionUtil.getConnection();
		String sql = "select user_name,user_pwd from trn_patients where user_name=? and user_pwd=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		try {
			preparedStatement.setString(1, p.getUser_name());
			preparedStatement.setString(2, p.getUser_pwd());
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {

				String checkPatients = resultSet.getString(1);
				String checkPass = resultSet.getString(2);
				if ((checkPatients.equalsIgnoreCase(p.getUser_name())) && (checkPass.equals(p.getUser_pwd()))) {
					login = true;
				} else {
					login = false;
				}
			} else {
				System.out.println("invalid");
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		return login;
	}

	public boolean checkPatients(Patients p) throws SQLException {
		boolean check = false;
		Connection connection = ConnectionUtil.getConnection();
		String sql = "select user_name from trn_patients where user_name=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		preparedStatement.setString(1, p.getUser_name());
		resultSet = preparedStatement.executeQuery();

		try {
			if (resultSet.next()) {
				check = false;
				return check;
			} else {
				check = true;
				return check;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}

}
