package com.staff;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.DatabaseConnection;




public class AdmissionPortal extends JFrame{
	
JLabel port=new JLabel("Admission Portal");
	
	JLabel namelb=new JLabel("Login: ");
	JTextField name=new JTextField();
	JLabel pswdlb=new JLabel("Password: ");
	JPasswordField pswd=new JPasswordField();
	JButton login=new JButton("login");
	JButton reset=new JButton("reset");
	JButton admin=new JButton("Admin");
	JButton cancel=new  JButton("Cancel");
	
	public AdmissionPortal() {
		pack();
		setResizable(false);
		setBackground(Color.pink);;
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500, 200);
		setLocationRelativeTo(null);
		
		port.setFont(new Font("Times New Roman", 1	,40));
		add(port,BorderLayout.NORTH);
		
		JPanel info=new JPanel(new GridLayout(2, 2));
		info.add(namelb);
		info.add(name);
		info.add(pswdlb);
		info.add(pswd);
		info.setBorder(new TitledBorder("Login info"));
		
		JPanel btn=new JPanel();
		btn.add(login);
		btn.add(reset);
		btn.add(cancel);
		
		JPanel full=new JPanel(new BorderLayout());
		full.add(info,BorderLayout.CENTER);
		full.add(btn,BorderLayout.SOUTH);
		add(full,BorderLayout.CENTER);
		
		JLabel foot=new JLabel("**********Created by Roshan Patil**********");
		add(foot,BorderLayout.SOUTH);
		
		login.addActionListener(new ActionListener() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Statement st=DatabaseConnection.getConnection().createStatement();
					ResultSet rs=st.executeQuery("select * from staff where department='admin'");
					while(rs.next()){
						
						  if((name.getText()).equals((rs.getString("login"))) && (pswd.getText()).equals(rs.getString("password"))){						   
							  new AdmissionOption();
							  dispose();
						   }
						  else {
							System.out.println("not enter");
						}
					}
					
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				
			}
		});       
		
		reset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				name.setText("");
				pswd.setText("");				
			}
		});
		
		
	
	}	

}
