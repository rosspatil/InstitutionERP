package com.staff;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;


public class StudentSearchForStaff extends JFrame{

	JLabel namelb=new JLabel("Name:");
	JTextField name=new JTextField();
	JLabel loginlb=new JLabel("Login ID:");
	JTextField login=new JTextField();
	JLabel fnamelb=new JLabel("Father's name:");
	JTextField fname=new JTextField();
	JLabel mnamelb=new JLabel("Mother's name:");
	JTextField mname=new JTextField();
	JLabel deptlb=new JLabel("Department:");
	JTextField dept=new JTextField();
	JLabel yrlb=new JLabel("Year:");
	JTextField yr=new JTextField();
	JLabel divlb=new JLabel("Division:");
	JTextField div=new JTextField();
	JLabel doblb=new JLabel("Date ofBirth:");
	JTextField dob=new JTextField();
	JLabel moblb=new JLabel("Mobile:");
	JTextField mob=new JTextField();
	JLabel addrlb=new JLabel("Address:");
	JTextField addr=new JTextField();
	JButton show=new JButton("show");
	JButton reset=new JButton("reset");
	JButton delete=new JButton("delete");
	
	public StudentSearchForStaff(final String str) {
		
		
		pack();
		setResizable(false);
		setBackground(Color.pink);;
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(700, 400);
		setLocationRelativeTo(null);
		
		JLabel head=new JLabel("Student Information");
		head.setFont(new Font("Times Roman",Font.BOLD+Font.ITALIC,40));
		add(head,BorderLayout.NORTH);
		
       JPanel info=new JPanel(new GridLayout(10,2));
		
		info.add(namelb);
		info.add(name);		
		info.add(loginlb);
		info.add(login);	
		info.add(deptlb);
		info.add(dept);	
		dept.setText(str);
		info.add(yrlb);
		info.add(yr);
		info.add(divlb);
		info.add(div);
		info.add(fnamelb);
		info.add(fname);
		info.add(mnamelb);
		info.add(mname);
		info.add(doblb);
		info.add(dob);				
		info.add(moblb);
		info.add(mob);
		info.add(addrlb);
		info.add(addr);
		dept.setEditable(false);
		yr.setEditable(false);
		div.setEditable(false);
		name.setEditable(true);
		fname.setEditable(false);
		mname.setEditable(false);
		dob.setEditable(false);
		addr.setEditable(false);
		mob.setEditable(false);

		
		info.setPreferredSize(new Dimension(300, 100));
		info.setBorder(new TitledBorder("Student info"));
		add(info,BorderLayout.CENTER);
		
		JPanel btn=new JPanel();
		btn.add(show);
		btn.add(reset);
		btn.add(delete);
		JButton cancel=new  JButton("Cancel");
		btn.add(cancel);
		add(btn,BorderLayout.SOUTH);
		
		JPanel full=new JPanel(new BorderLayout());
		full.add(info,BorderLayout.CENTER);
		full.add(btn,BorderLayout.SOUTH);
		add(full,BorderLayout.CENTER);
		
		JLabel foot=new JLabel("**********Created by Roshan Patil**********");
		add(foot,BorderLayout.SOUTH);
		
		
		delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Student.delete(name.getText(),str, login.getText());
					reset();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		
		show.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					ResultSet rs=Student.displayStaff(name.getText(), str, login.getText());
					while(rs.next()){
						 if((rs.getString("name")).equalsIgnoreCase(name.getText())&& rs.getString("department").equalsIgnoreCase(str)&&(login.getText()).equalsIgnoreCase(rs.getString("login"))){
							 fname.setText(rs.getString("father"));
							 mname.setText(rs.getString("mother"));
							 yr.setText(rs.getString("year"));
							 div.setText(rs.getString("division"));
							 dob.setText(rs.getString("dob"));
							   addr.setText(rs.getString("address"));
							   mob.setText(rs.getString("mobile"));
							   
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
				reset();
				
			}
		});;
		
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			toBack();				
			}
		});
		
	}
	
	void reset(){
		name.setText("");
		fname.setText("");
		mname.setText("");
		dob.setText("");
		login.setText("");
		addr.setText("");
		mob.setText("");
	}	
	
}

