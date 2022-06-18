import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import javax.swing.JPasswordField;



public class Window2 {
	JTextField textLastname;
	JTextField textJob;
	private JTextField textField_1;
	private JTable table;
	private JTextField txtAsdasd;
	private JTextField textField_2;
	public static ArrayList<String>  str= new ArrayList<>();
	private JTable table_1;
	/**
	 * @wbp.parser.entryPoint
	 */
	public void showWindow2() {
		
		Window1 window1=new Window1();
		
		
		JFrame frame = new JFrame("WINDOW2");
		frame.getContentPane().setBackground(new Color(0,0,0));
		frame.getContentPane().setForeground(Color.white);
		frame.setBounds(700,300,520,484);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel(window1.jtex.get(0).getText());
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(10, 32, 116, 25);
		frame.getContentPane().add(lblNewLabel);
		
		
		JTable table =new JTable();
		
		
		Object[] columns = new Object[(int) Windowx.strnga.get(0).getValue()];
	
		for (int i = 0; i < (Integer)Windowx.strnga.get(0).getValue(); i++) {
			columns[i]=window1.jtex.get(i+1).getText();
		}
		
		
		DefaultTableModel model =new DefaultTableModel();  
		
		model.setColumnIdentifiers(columns);
		table.setModel(model);
		table.setBackground(Color.white);
		table.setForeground(Color.black);
		table.setSelectionBackground(Color.red);
		table.setGridColor(Color.red);
		table.setSelectionForeground(Color.white);
		table.setFont(new Font("thoma",Font.PLAIN,17));
		table.setRowHeight(30);
		table.setAutoCreateRowSorter(true);
		
		JScrollPane pane = new JScrollPane(table);
		pane.setBounds(10, 69, 276, 269);
		pane.setForeground(Color.red);
		pane.setBackground(Color.white);
		frame.getContentPane().add(pane);
		
		JEditorPane editorPane = new JEditorPane();
		pane.setColumnHeaderView(editorPane);
		
		
		
		Object[] row= new Object[(Integer)Windowx.strnga.get(0).getValue()+1];
		//ADD
		
		
		
		//Delete
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(386, 321, 108, 36);
		frame.getContentPane().add(btnDelete);
		
		
		
		
		
		int j=0;
		ArrayList<JLabel>  labelx= new ArrayList<>();
		for (int i = 0; i < (int) Windowx.strnga.get(0).getValue(); i++) {
			labelx.add(new JLabel(window1.jtex.get(i+1).getText()));
			labelx.get(i).setForeground(Color.WHITE);
			labelx.get(i).setBounds(350, 77+j, 86, 20);
			frame.getContentPane().add(labelx.get(i));
			j+=44;
			
		}
		
		int y=0;
		ArrayList<JTextField>  jtexx= new ArrayList<>();
		for (int i = 0; i < (Integer)Windowx.strnga.get(0).getValue(); i++) {
			jtexx.add(new JTextField());
			jtexx.get(i).setBounds(408, 77+y, 86, 20);
			frame.getContentPane().add(jtexx.get(i));
			jtexx.get(i).setColumns(10);
			y+=44;
			
		}
		
		
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(386, 274, 108, 36);
		frame.getContentPane().add(btnAdd);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for(int i=0;i<(Integer)Windowx.strnga.get(0).getValue();i++) {
					row[i]=jtexx.get(i).getText();
				}
				
				model.addRow(row);
				
				try {
					
					File filex = new File(window1.jtex.get(0).getText()+".bin"); 
					FileOutputStream fileWriterx = new FileOutputStream(filex, true);
					DataOutputStream bWriterx = new DataOutputStream(fileWriterx);
					for (int i = 0; i < (Integer)Windowx.strnga.get(0).getValue(); i++) {
						 

			        	Files.write(Paths.get(window1.jtex.get(0).getText()+".bin"), (jtexx.get(i).getText()+" ").getBytes(), StandardOpenOption.APPEND);
			        	

					}
					Files.write(Paths.get(window1.jtex.get(0).getText()+".bin"), ("\n").getBytes(), StandardOpenOption.APPEND);
					
					bWriterx.close();
					JButton btnAdd = new JButton("Add");
					btnAdd.setBounds(386, 351, 108, 36);
					frame.getContentPane().add(btnAdd);
				}
				
				
				catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			/*	JOptionPane.showMessageDialog(frame, "Add is Correct");
				frame.setVisible(false);
				Window3 w3= new Window3();
				try {
					w3.showWindow3();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
			}
		});
		
		
		
		
		
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int i =table.getSelectedRow();
				if(i>=0){
					
					model.removeRow(i);
				}
				else {
					JOptionPane.showMessageDialog(frame, "DeleteError");
				}
			}
		});
		
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
		btnNewButton_1.setBounds(354, 378, 140, 56);
		frame.getContentPane().add(btnNewButton_1);
		
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
		
		frame.revalidate();
		
		frame.setVisible(true);
	}
}