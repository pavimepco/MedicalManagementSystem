package com.chainsys.mms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.chainsys.mms.model.Patients;
import com.chainsys.mms.util.ConnectionUtil;

public class PatientsDAO {
	static final Logger log = Logger.getLogger(PatientsDAO.class);


	ResultSet resultSet = null;

	/**
	 * This method inserts patient records
	 * @param p
	 * @return
	 */
	public boolean addPatients(Patients p) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		boolean success=false;
		try {
			connection = ConnectionUtil.getConnection();
			System.out.println(connection);
			String sql = "insert into trn_patients(pat_id,pat_name,pat_age,contact_num,user_name,user_pwd,pat_gender)values(p_id_seq.NEXTVAL,?,?,?,?,?,?)";
			//log.debug(" Query"+sql);
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, p.getPat_name());
			preparedStatement.setInt(2, p.getPat_age());
			preparedStatement.setLong(3, p.getContact_num());
			preparedStatement.setString(4, p.getUser_name());
			preparedStatement.setString(5, p.getUser_pwd());
			preparedStatement.setString(6, p.getPat_gender());
			int rows = preparedStatement.executeUpdate();
			log.debug(" Query"+preparedStatement);
			if(rows>0)
			{
				success=true;
			}
		} catch (SQLException e) {
			log.debug("Exception"+e.getMessage());
			
		} finally {
			ConnectionUtil.close(connection, preparedStatement, resultSet);
		}
		return success;
	}

	/**
	 * This method allows the user to login with his user name and password
	 * @param p
	 * @return
	 * @throws SQLException
	 */
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
		connection.close();
		return login;
	}

	/**
	 * This method check whether the user name is existing
	 * @param p
	 * @return
	 * @throws SQLException
	 */
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
		connection.close();
		return check;
	}
}
