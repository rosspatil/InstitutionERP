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


public class AdmissionOption extends JFrame {
	
	JLabel port=new JLabel("Welcome ");		
	JRadioButton btn1=new JRadioButton("New Student Entry");
	JRadioButton btn2=new JRadioButton("Student search");
	JButton submit=new JButton("submit");
	JButton reset=new JButton("reset");
	ButtonGroup g=new ButtonGroup();
	   

	public AdmissionOption(){	
	
			pack();
			setResizable(false);
			setVisible(true);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setSize(500, 200);
			setLocationRelativeTo(null);
			
			port.setFont(new Font("Times New Roman", 1	,40));
			add(port,BorderLayout.NORTH);
			
			JPanel info=new JPanel(new GridLayout(3, 1));
			info.add(btn1);
			info.add(btn2);
			info.setBorder(new TitledBorder("Amission section"));	
			g.add(btn1);
			g.add(btn2);	
			
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
	private class MyAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource()==reset){
				g.clearSelection();
			}
			
			if(g.isSelected(btn1.getModel())){
				new StudentEntry();
				dispose();
			}
			else if(g.isSelected(btn2.getModel())){
				new StudentSearchForAdmin();
				dispose();
			}
				
			
		}		
	}

}
