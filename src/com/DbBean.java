package com;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbBean {

	public static ResultSet adminLogin(String str,String str1) throws SQLException{
		PreparedStatement st=DatabaseConnection.getConnection().prepareStatement("select * from admin where login=? and password=? ;");
		st.setString(1, str);
		st.setString(2, str1);
		ResultSet rs=st.executeQuery();	
		DatabaseConnection.getConnection().close();
		return rs;
		
	}
}
