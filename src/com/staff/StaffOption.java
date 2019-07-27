package com.staff;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;


public class StaffOption extends JFrame {
	
	JLabel port=new JLabel("Welcome Staff");		
	JRadioButton btn1=new JRadioButton("Attendence");
	JRadioButton btn2=new JRadioButton("Result");
	JRadioButton btn3=new JRadioButton("Class Allotment");
	JRadioButton btn4=new JRadioButton("Student search");
	JButton submit=new JButton("submit");
	JButton reset=new JButton("reset");
	ButtonGroup g=new ButtonGroup();
	   

	public StaffOption(final String str){	
	
			pack();
			setResizable(false);
			setVisible(true);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setSize(500, 200);
			setLocationRelativeTo(null);
			
			port.setFont(new Font("Times New Roman", 1	,40));
			add(port,BorderLayout.NORTH);
			
			JPanel info=new JPanel(new GridLayout(4, 1));
			info.add(btn1);
			info.add(btn2);
			info.add(btn3);
			info.add(btn4);
			info.setBorder(new TitledBorder("Staff section"));	
			g.add(btn1);
			g.add(btn2);	
			g.add(btn3);
			g.add(btn4);
			JPanel btn=new JPanel();
			btn.add(submit);
			btn.add(reset);		
			JPanel full=new JPanel(new BorderLayout());
			full.add(info,BorderLayout.CENTER);
			full.add(btn,BorderLayout.SOUTH);
			add(full,BorderLayout.CENTER);
			
			JLabel foot=new JLabel("**********Created by Roshan Patil**********");
			add(foot,BorderLayout.SOUTH);
						
			submit.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(g.isSelected(btn1.getModel())){
						System.out.println("Attenedece");
					}
					else if(g.isSelected(btn2.getModel())){
						System.out.println("Result");
					}
					else if(g.isSelected(btn3.getModel())){
						new StudentAllotment(str);
						dispose();
					}	
					else if(g.isSelected(btn4.getModel())){
						new StudentSearchForStaff(str);
						dispose();
					}	
				}		
					
				
			});
			reset.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					g.clearSelection();
					
				}
			});	
			
	}	
	}
	
