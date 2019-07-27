package com.staff;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.DatabaseConnection;

public class StudentAllotment extends JFrame {
	
	JLabel namelb=new JLabel("Name:");
	JTextField name=new JTextField();
	JLabel deptlb=new JLabel("Department:");
	JTextField dept=new JTextField();
	JLabel loginlb=new JLabel("Login ID:");
	JTextField login=new JTextField();
	JLabel yrlb=new JLabel("Year:");
	JLabel semlb=new JLabel("Semister:");
	JLabel divlb=new JLabel("Division:");
	JComboBox yr=new JComboBox(new String[] {"Select Suject","FE","SE","TE","BE"});
	JComboBox sem=new JComboBox(new String[] {"Select semister","1","2"});
	JComboBox div=new JComboBox(new String[] {"Select division","A","B","c"});
	JButton reset=new JButton("Reset");
	JButton allot=new JButton("Allot");
	
	StudentAllotment(final String str){
		    pack();
			setResizable(false);
			setBackground(Color.pink);;
			setVisible(true);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setSize(700, 300);
			setLocationRelativeTo(null);
			
			JLabel head=new JLabel("Student Information");
			head.setFont(new Font("Times New Roman", 1, 40));
			add(head,BorderLayout.NORTH);
			
			JPanel info=new JPanel(new GridLayout(6, 2));
			info.add(namelb);
			info.add(name);
			info.add(loginlb);
			info.add(login);	
			info.add(deptlb);
			info.add(dept);
			dept.setText(str);
			dept.setEditable(false);				
			info.add(yrlb);
			info.add(yr);
			info.add(semlb);
			info.add(sem);
			info.add(divlb);
			info.add(div);
			info.setBorder(new TitledBorder("Staff Info"));
			
			JPanel btn=new JPanel();
			btn.add(allot);
			btn.add(reset);
			//btn.add(show);
			JButton cancel=new  JButton("Cancel");
			btn.add(cancel);
			
			JPanel full=new JPanel(new BorderLayout());
			full.add(info,BorderLayout.CENTER);
			full.add(btn,BorderLayout.SOUTH);
			add(full,BorderLayout.CENTER);
			
			JLabel foot=new JLabel("**********Created by Roshan Patil**********");
			add(foot,BorderLayout.SOUTH);		
			
			allot.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						PreparedStatement st=DatabaseConnection.getConnection().prepareStatement("insert into "+str+"  values(?,?,?,?,?,?)");
						
						st.setString(1, name.getText());
						st.setString(3, login.getText());
						st.setString(2, dept.getText());
						String s=yr.getSelectedItem().toString();
						st.setString(4, (s));
						st.setInt(5, sem.getSelectedIndex());
						st.setString(6, div.getSelectedItem().toString());
						st.execute();
						 yr.setSelectedIndex(0);
						 sem.setSelectedIndex(0);
						 div.setSelectedIndex(0);
						DatabaseConnection.getConnection().close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					
				}
			});		
			
			reset.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					reset();	
				}
			});
			cancel.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					toBack();
				}
			});
		
		
	}
	public void reset(){
		  name.setText("");
		  dept.setText("");
		  login.setText("");
		  yr.setSelectedIndex(0);
		  sem.setSelectedIndex(0);
		  div.setSelectedIndex(0);
	}

}
