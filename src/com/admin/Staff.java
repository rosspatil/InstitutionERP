package com.admin;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.DatabaseConnection;

public class Staff {

		String name;
		String dept;
		String doj;
		String address;
		String mobile;
		String login;
		String pswd;
		
	public static void insert(Staff s) throws SQLException{
		PreparedStatement st=DatabaseConnection.getConnection().prepareStatement("insert into staff values(?,?,?,?,?,?,?);");
		st.setString(1, s.getName());
		st.setString(2, s.getDept());
		st.setString(3, s.getDoj());
		st.setString(4, s.getAddress());
		st.setString(5, s.getMobile());
	    st.setString(6, s.getLogin());
	    st.setString(7, s.getPswd());
	    st.execute();
	    DatabaseConnection.getConnection().close();
		}

	public static void delete(String str,String str1,String str2) throws SQLException{
		PreparedStatement st=DatabaseConnection.getConnection().prepareStatement("delete from staff where name=? and department=? and login=?;");
		st.setString(1, str);
		st.setString(2, str1);
		st.setString(3, str2);
	    st.executeUpdate();
	    DatabaseConnection.getConnection().close();
		}

	public static ResultSet display(String str,String str1,String str2) throws SQLException{
		PreparedStatement st=DatabaseConnection.getConnection().prepareStatement("select * from staff where name=? and department=? and login=?;");
		st.setString(1, str);
		st.setString(2, str1);
		st.setString(3, str2);
		ResultSet rs=st.executeQuery();
		DatabaseConnection.getConnection().close();
		return rs;
	}

	public static ResultSet login(String str,String str1) throws SQLException{
		PreparedStatement st=DatabaseConnection.getConnection().prepareStatement("select * from staff where login=? and password=? ;");
		st.setString(1, str);
		st.setString(2, str1);
		ResultSet rs=st.executeQuery();
		DatabaseConnection.getConnection().close();
		return rs;
	}

		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getDept() {
			return dept;
		}
		public void setDept(String dept) {
			this.dept = dept;
		}
		public String getLogin() {
			return login;
		}
		public String getDoj() {
			return doj;
		}

		public void setDoj(String doj) {
			this.doj = doj;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getMobile() {
			return mobile;
		}

		public void setMobile(String mobile) {
			this.mobile = mobile;
		}

		public void setLogin(String login) {
			this.login = login;
		}
		public String getPswd() {
			return pswd;
		}
		public void setPswd(String pswd) {
			this.pswd = pswd;
		}

		public Staff(String name, String dept, String doj, String address,
				String mobile, String login, String pswd) {
			super();
			this.name = name;
			this.dept = dept;
			this.doj = doj;
			this.address = address;
			this.mobile = mobile;
			this.login = login;
			this.pswd = pswd;
		}
			
}
