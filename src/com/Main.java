package com;

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

import com.admin.AdminPortal;
import com.staff.AdmissionPortal;
import com.staff.StaffPortal;



@SuppressWarnings("serial")
public class Main extends JFrame{
	JLabel port=new JLabel("Welcome To Institute Portal");		
	JRadioButton btn1=new JRadioButton("Admin");
	JRadioButton btn2=new JRadioButton("Staff");
	JRadioButton btn3=new JRadioButton("Student");
	JRadioButton btn4=new JRadioButton("Admission Coordinator");
	JButton submit=new JButton("submit");
	JButton reset=new JButton("reset");
	ButtonGroup g=new ButtonGroup();
	   

	public Main(){	
	
			pack();
			setResizable(false);
			setBackground(Color.pink);;
			setVisible(true);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setSize(500, 200);
			setLocationRelativeTo(null);
			
			port.setFont(new Font("Times New Roman", 1	,40));
			add(port,BorderLayout.NORTH);
			
			JPanel info=new JPanel(new GridLayout(3, 1));
			info.add(btn1);
			info.add(btn2);
			info.add(btn3);	
			info.add(btn4);
			info.setBorder(new TitledBorder("You are "));	
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
						
			submit.addActionListener(new MyAction());
			reset.addActionListener(new MyAction());	
			
	}
	
	public static void main(String[] args) {
		new Main();
	}
	private class MyAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource()==reset){
				g.clearSelection();
			}			
			if(g.isSelected(btn1.getModel())){
				new AdminPortal();
				dispose();
			}
			else if(g.isSelected(btn2.getModel())){
				new StaffPortal();
				dispose();
			}
			else if(g.isSelected(btn3.getModel())){
				System.out.println("student");
			}
			else if(g.isSelected(btn4.getModel())){
				new AdmissionPortal();
				dispose();
			}
			
		}		
	}
	
	
}