import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;



import java.awt.BorderLayout;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JProgressBar;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.DefaultComboBoxModel;


public class Window1 {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	public static ArrayList<String>  strng= new ArrayList<>();
	public static ArrayList<String>  tablename= new ArrayList<>();
	public static ArrayList<JTextField>  jtex= new ArrayList<>();
	public static ArrayList<JComboBox>  xx= new ArrayList<>();
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	public static ArrayList<JComboBox>  xComboBoxs= new ArrayList<>();
	static ArrayList<JLabel>  jlab= new ArrayList<>();
	static ArrayList<String>  type= new ArrayList<>();

	/**
	 * @throws IOException 
	 * @wbp.parser.entryPoint
	 */
	public void showWindow1() throws IOException {
		
		
		
		
		
		JFrame frame = new JFrame("WINDOW1");
		frame.getContentPane().setBackground(new Color(0,0,0));
		frame.getContentPane().setForeground(Color.white);
		frame.setBounds(700,300,615,574);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Table Name");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(69, 28, 72, 17);
		frame.getContentPane().add(lblNewLabel);
		int count=0;
		
		int j=0;
		int y=0;
		JComboBox comboBox = new JComboBox();
		
		for (int i = 0; i < (Integer)Windowx.strnga.get(0).getValue()+1; i++) {
			jtex.add(new JTextField());
			jtex.get(i).setBounds(151, 28+j, 86, 20);
			frame.getContentPane().add(jtex.get(i));
			jtex.get(i).setColumns(10);
			j+=44;
			count++;
		}
		String[] strg=new String[count-1];
		for (int i = 0; i < count-1; i++) {
			strg[i]="Column"+i;
			
			comboBox.setModel(new DefaultComboBoxModel(strg));

		}
		
		
		
		ArrayList<JLabel>  jlab= new ArrayList<>();
		for (int i = 0; i < (Integer)Windowx.strnga.get(0).getValue(); i++) {
			jlab.add(new JLabel("Col Name "+i));
			jlab.get(i).setForeground(Color.WHITE);
			jlab.get(i).setBounds(69, 77+y, 80, 20);
			frame.getContentPane().add(jlab.get(i));
			
			y+=44;
			
		}
		
		
		
		comboBox.setBounds(330, 62, 105, 22);
		frame.getContentPane().add(comboBox); 
		
		
		JButton btnWindow2 = new JButton("Window5");
		btnWindow2.setBounds(226, 384, 105, 50);
		frame.getContentPane().add(btnWindow2);
		btnWindow2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				Window5 w5= new Window5();
				try {
					w5.showWindow5();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		});
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(69, 384, 105, 50);
		frame.getContentPane().add(btnAdd);
		
		JLabel lblNewLabel_1 = new JLabel("Select Primkey Coloumn ");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(320, 22, 160, 29);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton_Home = new JButton("HOME");
		btnNewButton_Home.setBackground(Color.BLACK);
		btnNewButton_Home.setForeground(Color.RED);
		btnNewButton_Home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Windowx windowx= new Windowx();
				windowx.showWindowx();
			}
		});
		btnNewButton_Home.setBounds(0, 0, 89, 23);
		frame.getContentPane().add(btnNewButton_Home);
		

		int xor=0;
		for (int i = 0; i < (Integer)Windowx.strnga.get(0).getValue(); i++) {
			xComboBoxs.add(new JComboBox());
			
			xComboBoxs.get(i).setModel(new DefaultComboBoxModel(new String[] {"String", "Int", "Bool"}));
			xComboBoxs.get(i).setBounds(250, 72+xor, 43, 22);
			frame.getContentPane().add(xComboBoxs.get(i));
			xor+=44;
		}
		
		
		
		
		
		
		
		File file = new File("Tables.bin");
		
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.setVisible(true);
				File file1 = new File(jtex.get(0).getText()+".bin");
				tablename.add(jtex.get(0).getText());
				if (!file1.exists()) {
		            try {
						file1.createNewFile();
						FileOutputStream fileWriter1 = new FileOutputStream(file1, true);
						DataOutputStream bWriter1 = new DataOutputStream(fileWriter1);
				       
				        bWriter1.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		        }
				
				
				try {
														        
					FileOutputStream fileWriter = new FileOutputStream(file, true);
					DataOutputStream  bWriter = new DataOutputStream (fileWriter);
			       
		        	Files.write(Paths.get("Tables.bin"), (jtex.get(0).getText()+"\n").getBytes(), StandardOpenOption.APPEND);
		        	
					bWriter.close();
				}
				
				
				catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				try {
					
					File filex = new File(jtex.get(0).getText()+".bin"); 
					FileOutputStream fileWriterx = new FileOutputStream(filex, true);
					DataOutputStream bWriterx = new DataOutputStream(fileWriterx);
					for (int i = 1; i < (Integer)Windowx.strnga.get(0).getValue()+1; i++) {
						
			        	Files.write(Paths.get(jtex.get(0).getText()+".bin"), (jtex.get(i).getText()+" ").getBytes(), StandardOpenOption.APPEND);
			        	
	        			    
						
					}
		        	Files.write(Paths.get(jtex.get(0).getText()+".bin"), ("\n").getBytes(), StandardOpenOption.APPEND);
					
					bWriterx.close();
					
					
				}
				
				
				catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				xx.add(comboBox);
		    	/*try {
		    		File filec = new File(jtex.get(0).getText()+"Key"+".bin"); 
					FileOutputStream fileWriterxx = new FileOutputStream(filec, true);
					DataOutputStream bWriterxx = new DataOutputStream(fileWriterxx);
					Files.write(Paths.get(jtex.get(0).getText()+"Key"+".bin"), (comboBox.getSelectedIndex()+"").getBytes(), StandardOpenOption.APPEND);
					bWriterxx.close();
		    	} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}*/
				
				for (int i = 0; i < (Integer)Windowx.strnga.get(0).getValue(); i++) {
					type.add((String) xComboBoxs.get(i).getSelectedItem());
				}
		        frame.repaint();
		        try {
					
					File filex = new File(jtex.get(0).getText()+"Type"+".bin"); 
					FileOutputStream fileWriterx = new FileOutputStream(filex, true);
					DataOutputStream bWriterx = new DataOutputStream(fileWriterx);
					for (int i = 0; i < (Integer)Windowx.strnga.get(0).getValue(); i++) {
						
			        	Files.write(Paths.get(jtex.get(0).getText()+"Type"+".bin"), (type.get(i)+" ").getBytes(), StandardOpenOption.APPEND);
			        	
	        			    
						
					}
		    
					
					bWriterx.close();
					
					
				}
				
				
				catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		
		
		
		
		
		
		frame.setVisible(true);
	}
}
