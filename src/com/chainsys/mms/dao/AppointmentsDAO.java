package com.chainsys.mms.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.chainsys.mms.model.Appointments;

import com.chainsys.mms.util.ConnectionUtil;

public class AppointmentsDAO {
	
	
	ResultSet resultSet = null;

	public void addDetails(Appointments a,String username) throws Exception {
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

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(connection, preparedStatement, resultSet);
		}

	}	
	
	public ArrayList findall(String uname) throws SQLException{
		Connection connection=ConnectionUtil.getConnection();
		String sql="SELECT app_id,doc_name,app_time,app_date FROM trn_appointment WHERE userid=?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, uname);
		ResultSet resultset = stmt.executeQuery();
		ArrayList<Appointments> blist=new ArrayList<Appointments>();
		Appointments app;
		while(resultset.next()){
			app=new Appointments();
			app.setApp_id(resultset.getInt("app_id"));
			app.setDoc_name(resultset.getString("doc_name"));
			System.out.println("doc_name");
			app.setApp_time(resultset.getString("app_time"));
			app.setApp_date(resultset.getDate("app_date").toLocalDate());
			blist.add(app);
		}		
		return blist;
	}

}
