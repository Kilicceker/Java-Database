import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.JLabel;

public class Windowx {
	private JTextField textField;
    public static  String valueString;
    public static ArrayList<JSpinner>  strnga= new ArrayList<>();
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public void showWindowx(){
		
		JFrame frame = new JFrame("WINDOW1");
		frame.getContentPane().setBackground(new Color(0,0,0));
		frame.getContentPane().setForeground(Color.white);
		frame.setBounds(700,300,615,574);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(103, 61, 39, 23);
		frame.getContentPane().add(spinner);
		strnga.add(spinner);
		
		
		JButton btnNewButton = new JButton("Create Table");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				Window1 w1= new Window1();
				try {
					w1.showWindow1();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 
		        
			}
		});
		btnNewButton.setBounds(209, 44, 140, 56);
		frame.getContentPane().add(btnNewButton);
		
		
		
		JLabel lblNewLabel = new JLabel("Column Number");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setBounds(81, 40, 77, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Show Tables");
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				Window3 w3= new Window3();
				try {
					w3.showWindow3();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		});
		btnNewButton_1.setBounds(209, 145, 140, 56);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Search Window");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Window6 window6 =new Window6();
				frame.setVisible(false);
				try {
					window6.showWindow6();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBounds(209, 268, 140, 67);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("BinarySearch");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Window7 window7 =new Window7();
				frame.setVisible(false);
				try {
					window7.showWindow7();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_3.setBounds(209, 353, 140, 81);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Order Page");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Window9 window9 =new Window9();
				try {
					window9.showWindow9();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_4.setBounds(33, 353, 140, 81);
		frame.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_4_1 = new JButton("Primary Order Page");
		btnNewButton_4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.setVisible(false);
				Window11 window11 =new Window11();
				try {
					window11.showWindow11();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_4_1.setBounds(33, 268, 140, 67);
		frame.getContentPane().add(btnNewButton_4_1);
		
		
		
		
		frame.setVisible(true);
	}
}
