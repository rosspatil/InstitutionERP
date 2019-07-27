package com.staff;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.DatabaseConnection;


public class Student {
	

	String name;
	String fname;
	String mname;
	String dob;
	String stdid;
	String pswd;
	String dept;
	String doa;
	String mobile;
	String address;
	
	
	public Student(String name, String fname, String mname, String dob,
			String stdid, String pswd, String dept, String doa, String mobile,
			String address) {
		super();
		this.name = name;
		this.fname = fname;
		this.mname = mname;
		this.dob = dob;
		this.stdid = stdid;
		this.pswd = pswd;
		this.dept = dept;
		this.doa = doa;
		this.mobile = mobile;
		this.address = address;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getStdid() {
		return stdid;
	}
	public void setStdid(String stdid) {
		this.stdid = stdid;
	}
	public String getPswd() {
		return pswd;
	}
	public void setPswd(String pswd) {
		this.pswd = pswd;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getDoa() {
		return doa;
	}
	public void setDoa(String doa) {
		this.doa = doa;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	

	public static void insertinfo(Student s) throws SQLException{
		
		PreparedStatement st=DatabaseConnection.getConnection().prepareStatement("insert into studentinfo  values(?,?,?,?,?,?,?,?,?,?);");		
		st.setString(1, s.getName());
		st.setString(2, s.getFname());
		st.setString(3, s.getMname());
		st.setString(4, s.getDob());
		st.setString(5, s.getDept());
		st.setString(6, s.getDoa());
		st.setString(7, s.getStdid());
		st.setString(8, s.getPswd());
		st.setString(9, s.getMobile());
		st.setString(10, s.getAddress());
		st.execute();		
		DatabaseConnection.getConnection().close();		
	}
	
	public static ResultSet display(String str,String str1,String str2) throws SQLException{
		PreparedStatement st=DatabaseConnection.getConnection().prepareStatement("select * from studentinfo where name=? and department=? and login=?;");
		st.setString(1, str);
		st.setString(2, str1);
		st.setString(3, str2);
		ResultSet rs=st.executeQuery();
		DatabaseConnection.getConnection().close();
		return rs;
	}
	
	public static ResultSet displayStaff(String str,String str1,String str2) throws SQLException{
		PreparedStatement st=DatabaseConnection.getConnection().prepareStatement("select * from "+str1+",studentinfo where "+str1+".login=studentinfo.login and "+str1+".name=? and "+str1+".department=? and "+str1+".login=?;");
		st.setString(1, str);
		st.setString(2, str1);
		st.setString(3, str2);
		
		ResultSet rs=st.executeQuery();
		DatabaseConnection.getConnection().close();
		return rs;
	}
	
	public static void delete(String str,String str1,String str2) throws SQLException{
		PreparedStatement st=DatabaseConnection.getConnection().prepareStatement("delete from staff where name=? and department=? and login=?;");
		st.setString(1, str);
		st.setString(2, str1);
		st.setString(3, str2);
	    st.executeUpdate();
	    DatabaseConnection.getConnection().close();
		}
	
	
}
