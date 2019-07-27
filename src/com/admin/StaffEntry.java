package com.admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class StaffEntry extends JFrame{
	
	JLabel namelb=new JLabel("Name:");
	JTextField name=new JTextField();
	JLabel deptlb=new JLabel("Department:");
	JComboBox dept=new JComboBox(new String[] {"Select department","Mechanical","Computer","Civil","Electrical","Admin"});
	JLabel dojlb=new JLabel("Date ofJoining::");
	JTextField doj=new JTextField();
	JLabel loginlb=new JLabel("Login ID:");
	JTextField login=new JTextField();
	JLabel pswdlb1=new JLabel("Password: ");
	JPasswordField pswd1=new JPasswordField();
	JLabel pswdlb2=new JLabel("Confirm Password: ");
	JPasswordField pswd2=new JPasswordField();
	JLabel moblb=new JLabel("Mobile:");
	JTextField mob=new JTextField();
	JLabel addrlb=new JLabel("Address:");
	JTextField addr=new JTextField();
	JButton reset=new JButton("Reset");
	JButton add=new JButton("Add");
	JButton show=new JButton("Show");
	
	public StaffEntry(){
		 pack();
		setResizable(false);
		setBackground(Color.pink);;
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(700, 400);
		setLocationRelativeTo(null);
		
		JLabel head=new JLabel("Staff Information");
		head.setFont(new Font("Times New Roman", 1, 40));
		add(head,BorderLayout.NORTH);
		
		JPanel info=new JPanel(new GridLayout(8, 2));
		info.add(namelb);
		info.add(name);
		info.add(deptlb);
		info.add(dept);
		info.add(loginlb);
		info.add(login);
		info.add(pswdlb1);
		info.add(pswd1);
		info.add(pswdlb2);
		info.add(pswd2);
		info.add(dojlb);
		info.add(doj);
		info.add(moblb);
		info.add(mob);
		info.add(addrlb);
		info.add(addr);
		info.setBorder(new TitledBorder("Staff Info"));
		
		JPanel btn=new JPanel();
		btn.add(add);
		btn.add(reset);
		btn.add(show);
		JButton cancel=new  JButton("Cancel");
		btn.add(cancel);
		
		JPanel full=new JPanel(new BorderLayout());
		full.add(info,BorderLayout.CENTER);
		full.add(btn,BorderLayout.SOUTH);
		add(full,BorderLayout.CENTER);
		
		JLabel foot=new JLabel("**********Created by Roshan Patil**********");
		add(foot,BorderLayout.SOUTH);		
		
		
		add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					
					if((pswd1.getText()).equals(pswd2.getText())){	
					Staff.insert(new Staff(name.getText(), dept.getSelectedItem().toString(), doj.getText(), addr.getText(), mob.getText(), login.getText(), pswd1.getText()));
					reset();
					}
				} catch (NumberFormatException e1) {
					e1.printStackTrace();
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
		  dept.setSelectedIndex(0);
		  login.setText("");
		  pswd1.setText("");
		  pswd2.setText("");
		  doj.setText("");
		  mob.setText("");
		  addr.setText("");
	}
	
	public static void main(String[] args) {
		new StaffEntry();
	}
}
