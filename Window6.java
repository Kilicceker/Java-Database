import java.awt.Color;
import java.awt.Font;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.Component;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class Window6 {
	public static ArrayList<String>  columnsName= new ArrayList<>();
	ArrayList<String>  listke= new ArrayList<>();

    public static ArrayList<String[]> cells= new ArrayList<>();
    public static ArrayList<String> newProp= new ArrayList<>();
    public static ArrayList<String>  tables= new ArrayList<>();
    public static ArrayList<String>  newProperty= new ArrayList<>();
    public static ArrayList<String>  primeryArrayList= new ArrayList<>();
    public static ArrayList<String>  primeCol= new ArrayList<>();
	 JTextField textField;
	 private DefaultTableModel model =new DefaultTableModel();
	 JTable table =new JTable();
	 public static int xd;
	 public static String [] arrayColumns;
	 JButton btnNewButton_2 = new JButton("Delete");
	 JButton btnNewButton_1 = new JButton("Upgrade");
	 private JTextField textField_1;
	 ArrayList<JTextField>  textList= new ArrayList<>();
	/**
	 * @throws IOException 
	 * @wbp.parser.entryPoint
	 */
	public void showWindow6() throws IOException {
		
		
		JFrame frame = new JFrame("WINDOW6");
		frame.getContentPane().setBackground(new Color(0,0,0));
		frame.getContentPane().setForeground(Color.white);
		frame.setBounds(700,300,615,574);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		


		
		
			
			File file = new File("Tables"+".bin");
			
			InputStream insputStream = new FileInputStream(file);
			
			long length = file.length();
			byte[] bytes = new byte[(int) length];

			insputStream.read(bytes);
			insputStream.close();
			
			String s = new String(bytes);
			
			String [] array=s.split("\n");
			String[] strg=new String[array.length];
			for (int i = 0; i < array.length; i++) {
			     strg[i]=array[i];
			}
	
		
			JComboBox comboBox = new JComboBox();
			for (int i = 0; i < strg.length; i++) {
				
				
				comboBox.setModel(new DefaultComboBoxModel(strg));

			}
			comboBox.setBounds(10, 77, 103, 22);
			frame.getContentPane().add(comboBox);
			
			JLabel lblNewLabel = new JLabel();
			lblNewLabel.setText(comboBox.getSelectedItem().toString());
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setBounds(151, 81, 103, 14);
			frame.getContentPane().add(lblNewLabel);
			JLabel lblNewLabelx = new JLabel();
			JButton btnNewButton = new JButton("Search");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					lblNewLabel.setText(comboBox.getSelectedItem().toString());
					
					
					try{
						
						File filex = new File(comboBox.getSelectedItem().toString()+".bin");
						
						InputStream insputStream1 = new FileInputStream(filex);
						
						long length1 = filex.length();
						byte[] bytes1 = new byte[(int) length1];
						cells.clear();
						insputStream1.read(bytes1);
						insputStream1.close();
						String strgx = new String(bytes1);
						String [] array1=strgx.split("\n");
						String [] arrayColumns=array1[0].split(" ");
						
						try{		
						File filex1 = new File(comboBox.getSelectedItem().toString()+"Key"+".bin");
						
						InputStream insputStream11 = new FileInputStream(filex1);
						
						long length11 = filex1.length();
						byte[] bytes11 = new byte[(int) length11];
						insputStream11.read(bytes11);
						insputStream11.close(); 
						String strgx1 = new String(bytes11);
						String [] array11=strgx1.split("\n");
						String [] xdaStrings=array11[1].split(" ");
						primeCol.add(array11[0]);
						
						for (int i = 0; i < xdaStrings.length; i++) {
							
							primeryArrayList.add(xdaStrings[i]);
						}
						}
						catch(Exception e1){
							System.out.println("Error is:" + e1.getMessage());
						}
						for (int i = 1; i < array1.length; i++) {
							
							cells.add(array1[i].split(" "));
						}
						
						
						
						boolean con=false;
						
						for (int i = 0; i < cells.size(); i++) {
							for (int j = 0; j < cells.get(0).length; j++) {
								
								if(textField.getText().equals(cells.get(i)[j])) {
									
									
									
									xd=i;
									con=true;
								}
								
								
								
							}
							
							
						}
				
						
						Object[] columns = new Object[arrayColumns.length];
						model.setRowCount(0);
						for (int i = 0; i < arrayColumns.length; i++) {
							columns[i]=arrayColumns[i];
							columnsName.add(arrayColumns[i]);
						}
						
						
						
						model.setColumnIdentifiers(columns);
						if(con==false) {
							JOptionPane.showMessageDialog(frame, "Bulunamadı");
						}
						
						if(con==true) {
							Object[] row= new Object[cells.get(0).length];
							model.setRowCount(0);
							for(int i=0;i<cells.get(0).length;i++) {
								row[i]=cells.get(xd)[i];
									
									
								
							}
							model.addRow(row);	
						}
						
						int y=0;
						
						
						for (int i = 0; i < columnsName.size(); i++) {
							textList.add(new JTextField());
							textList.get(i).setBounds(10+y, 366, 70, 20);
							frame.getContentPane().add(textList.get(i));
							textList.get(i).setColumns(10);
							y+=90;
							
						}
						table.repaint();
						
						
						
						
						}catch(Exception e1){
							System.out.println("Error is:" + e1.getMessage());
						}
					
				}
			});
			btnNewButton.setBounds(414, 77, 89, 23);
			frame.getContentPane().add(btnNewButton);
			
			
			textField = new JTextField();
			textField.setBounds(290, 78, 86, 20);
			frame.getContentPane().add(textField);
			textField.setColumns(10);
			
			
			
			lblNewLabelx.setForeground(Color.WHITE);
			lblNewLabelx.setBounds(300, 100, 103, 14);
			frame.getContentPane().add(lblNewLabelx);
			
			JTable table =new JTable();
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
			pane.setBounds(111, 133, 319, 134);
			pane.setForeground(Color.white);
			pane.setBackground(Color.red);
			frame.getContentPane().add(pane);

			JEditorPane editorPane = new JEditorPane();
			pane.setColumnHeaderView(editorPane);
			
			table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
				
				@Override
				public void valueChanged(ListSelectionEvent e) {
					// TODO Auto-generated method stub
					int i=table.getSelectedRow();
					if(i!=-1) {
						i=table.getSelectedRow();
					for (int k = 0; k < columnsName.size(); k++) {
						
						textList.get(k).setText((String) model.getValueAt(i, k));
						
						
					}
					}
					

					
				} 
				
			});
			
			
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					int i = table.getSelectedRow();
		               
					
					Boolean countBoolean=true;
					for (int j = 0; j < primeryArrayList.size(); j++) {
					if(textList.get(Integer.parseInt(primeCol.get(0))).getText().equals(primeryArrayList.get(j))) {
						countBoolean=false;
						
					}
					}
					
					
					
					
					
					if(countBoolean==false) {
						JOptionPane.showMessageDialog(frame, "Ekleymezsin");
					}
					if(countBoolean==true) {
						for (int k = 0; k < columnsName.size(); k++) {
		  	            	   
		  	            	 model.setValueAt(textList.get(k).getText(), i, k);
		  	            	   
		  	            	   newProp.add(textList.get(k).getText());
		  	            	   
		  				}
						
					String[] aStrings=new String[newProp.size()];
					for (int j = 0; j < aStrings.length; j++) {
						aStrings[j]=newProp.get(j);
					}
					cells.remove(xd);
					
						
						cells.add(xd, aStrings);;
					primeryArrayList.remove(xd);
					primeryArrayList.add(xd,aStrings[Integer.parseInt(primeCol.get(0))]);
					
		
				    	
					try {
						
					
						
					File filex = new File(comboBox.getSelectedItem().toString()+".bin"); 
					filex.delete();
					FileOutputStream fileWriterx = new FileOutputStream(filex, true);
					DataOutputStream bWriterx = new DataOutputStream(fileWriterx);
					
					for (int j = 0; j < columnsName.size(); j++) {
						
						Files.write(Paths.get(comboBox.getSelectedItem().toString()+".bin"), (columnsName.get(j)+" ").getBytes(), StandardOpenOption.APPEND);
						
					}
					Files.write(Paths.get(comboBox.getSelectedItem().toString()+".bin"), ("\n").getBytes(), StandardOpenOption.APPEND);
					for (int y = 0; y < cells.size(); y++) {
							 
						for (int j = 0; j < cells.get(0).length; j++) {
							Files.write(Paths.get(comboBox.getSelectedItem().toString()+".bin"), (cells.get(y)[j]+" ").getBytes(), StandardOpenOption.APPEND);
								}
				    
						Files.write(Paths.get(comboBox.getSelectedItem().toString()+".bin"), ("\n").getBytes(), StandardOpenOption.APPEND);

						}
					
						
					bWriterx.close();
					} 	
					
					catch (Exception e2) {
						// TODO: handle exception
					}
					try {
						
						
						
						File filex = new File(comboBox.getSelectedItem().toString()+"Key"+".bin"); 
						filex.delete();
						FileOutputStream fileWriterx = new FileOutputStream(filex, true);
						DataOutputStream bWriterx = new DataOutputStream(fileWriterx);
						
						
						Files.write(Paths.get(comboBox.getSelectedItem().toString()+"Key"+".bin"), (primeCol.get(0)+"\n").getBytes(), StandardOpenOption.APPEND);
						
								 
							for (int j = 0; j < primeryArrayList.size(); j++) {
								Files.write(Paths.get(comboBox.getSelectedItem().toString()+"Key"+".bin"), (primeryArrayList.get(j)+" ").getBytes(), StandardOpenOption.APPEND);
									
							}
					    

							
						
							
						bWriterx.close();
						} 	
					
						catch (Exception e2) {
							// TODO: handle exception
						}
					}
				}
			});
			btnNewButton_1.setBounds(438, 438, 89, 23);
			frame.getContentPane().add(btnNewButton_1);
			
			
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					int i =table.getSelectedRow();
					if(i>=0){
						
						model.removeRow(i);
						cells.remove(xd);
						primeryArrayList.remove(xd);
						
					}
					else {
						JOptionPane.showMessageDialog(frame, "DeleteError");
					}
					
					try {
						
					
						
					File filex = new File(comboBox.getSelectedItem().toString()+".bin"); 
					filex.delete();
					FileOutputStream fileWriterx = new FileOutputStream(filex, true);
					DataOutputStream bWriterx = new DataOutputStream(fileWriterx);
					
					for (int j = 0; j < columnsName.size(); j++) {
						
						Files.write(Paths.get(comboBox.getSelectedItem().toString()+".bin"), (columnsName.get(j)+" ").getBytes(), StandardOpenOption.APPEND);
						
					}
					Files.write(Paths.get(comboBox.getSelectedItem().toString()+".bin"), ("\n").getBytes(), StandardOpenOption.APPEND);
					for (int y = 0; y < cells.size(); y++) {
							 
						for (int j = 0; j < cells.get(0).length; j++) {
							Files.write(Paths.get(comboBox.getSelectedItem().toString()+".bin"), (cells.get(y)[j]+" ").getBytes(), StandardOpenOption.APPEND);
								}
				    
						Files.write(Paths.get(comboBox.getSelectedItem().toString()+".bin"), ("\n").getBytes(), StandardOpenOption.APPEND);

						}
					
						
					bWriterx.close();
					} 	
					catch (Exception e2) {
						// TODO: handle exception
					}
					try {
						
						
						
						File filex = new File(comboBox.getSelectedItem().toString()+"Key"+".bin"); 
						filex.delete();
						FileOutputStream fileWriterx = new FileOutputStream(filex, true);
						DataOutputStream bWriterx = new DataOutputStream(fileWriterx);
						
						
						Files.write(Paths.get(comboBox.getSelectedItem().toString()+"Key"+".bin"), (primeCol.get(0)+"\n").getBytes(), StandardOpenOption.APPEND);
						
								 
							for (int j = 0; j < primeryArrayList.size(); j++) {
								Files.write(Paths.get(comboBox.getSelectedItem().toString()+"Key"+".bin"), (primeryArrayList.get(j)+" ").getBytes(), StandardOpenOption.APPEND);
									
							}
					    

							
						
							
						bWriterx.close();
						} 	
						
						catch (Exception e2) {
							// TODO: handle exception
						}
					
					
				}
			});
			btnNewButton_2.setBounds(438, 472, 89, 23);
			frame.getContentPane().add(btnNewButton_2);
			
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
