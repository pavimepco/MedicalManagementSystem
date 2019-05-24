package com.chainsys.mms.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.chainsys.mms.model.Appointments;

import com.chainsys.mms.util.ConnectionUtil;

/**
 * This class maintains appointment details of a patient
 * @author pavi2107
 *
 */
public class AppointmentsDAO {

	ResultSet resultSet = null;

	/**
	 * This method adds appointment list of a patient
	 * @param a
	 * @param username
	 * @throws SQLException
	 */
	public void addDetails(Appointments a, String username) throws SQLException {
		Connection connection = null;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = ConnectionUtil.getConnection();
			System.out.println(connection);
			String sql = "insert into trn_appointment(app_id,doc_name,app_time,app_date,userid)values(app_id_seq.NEXTVAL,?,?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, a.getDoc_name());
			preparedStatement.setString(2, a.getApp_time());
			preparedStatement.setDate(3, Date.valueOf(a.getApp_date()));
			preparedStatement.setString(4, username);
			int rows = preparedStatement.executeUpdate();
			System.out.println("Rows inserted: " + rows);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(connection, preparedStatement, resultSet);
		}
	}

	/**
	 * This method retrieves appointment id,time and date of a patient along with the doctor 
	 * @param uname
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Appointments> findall(String uname) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		String sql = "SELECT app_id,doc_name,app_time,app_date FROM trn_appointment WHERE userid=?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, uname);
		ResultSet resultset = stmt.executeQuery();
		ArrayList<Appointments> blist = new ArrayList<Appointments>();
		Appointments app;
		while (resultset.next()) {
			app = new Appointments();
			app.setApp_id(resultset.getInt("app_id"));
			app.setDoc_name(resultset.getString("doc_name"));
			System.out.println("doc_name");
			app.setApp_time(resultset.getString("app_time"));
			app.setApp_date(resultset.getDate("app_date").toLocalDate());
			blist.add(app);
		}
		connection.close();
		return blist;
	}

	/**
	 * A patient can cancel an appointment using this method
	 * @param userid
	 * @throws SQLException
	 */
	public void deleteAppointment(String userid) throws SQLException {
		String sql = "delete from trn_appointment where userid=?";
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, userid);
		int rows = preparedStatement.executeUpdate();
		System.out.println("Rows affected:" + rows);
		ConnectionUtil.closeConnection(connection, preparedStatement, null);
	}
}