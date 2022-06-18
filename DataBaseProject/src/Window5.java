import java.awt.Color;
import java.awt.Font;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.InterruptedByTimeoutException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.management.loading.PrivateClassLoader;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Window5 {
	
	private static ArrayList<String>  columnsName= new ArrayList<>();
	private static ArrayList<String>  newProperty= new ArrayList<>();
	private ArrayList<String>  proprety= new ArrayList<>();
	 ArrayList<String[]>  xdasd= new ArrayList<>();
	 ArrayList<String>  primeryArrayList= new ArrayList<>();
	private JTable table;
	private JTextField textField;	
	private Window1 window1=new Window1();
	private JButton btnNewButton = new JButton("Upgrade");
	private DefaultTableModel model =new DefaultTableModel();
	
	/**
	 * @wbp.parser.entryPoint
	 */ 
	public void showWindow5() throws IOException {
		
		
		JFrame frame = new JFrame("WINDOW5");
		frame.getContentPane().setBackground(new Color(0,0,0));
		frame.getContentPane().setForeground(Color.white);
		frame.setBounds(700,300,615,574);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		
		try{
			
			File file = new File(window1.tablename.get(0)+".bin");
			
			InputStream insputStream = new FileInputStream(file);
			
			long length = file.length();
			byte[] bytes = new byte[(int) length];

			insputStream.read(bytes);
			insputStream.close();
		
			String s = new String(bytes);
					
			String [] array=s.split("\n");
			String [] arrayColumns=array[0].split(" ");
			
			for (int i = 0; i < arrayColumns.length; i++) {
				columnsName.add(arrayColumns[i]);
			}
			
			for (int i = 1; i < array.length; i++) {
				
				xdasd.add(array[i].split(" "));
			}
			}catch(Exception e){
				System.out.println("Error is:" + e.getMessage());
			}
		File filex = new File(window1.tablename.get(0)+"Type"+".bin");
		
		InputStream insputStreamx = new FileInputStream(filex);
		
		long lengthx = filex.length();
		
		byte[] bytesx = new byte[(int) lengthx];

		insputStreamx.read(bytesx);
		insputStreamx.close();
		
		String sx = new String(bytesx);
		
		String [] type=sx.split(" ");
		
	
		
		JLabel lblNewLabel = new JLabel(window1.tablename.get(0));
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setForeground(Color.WHITE); 
		lblNewLabel.setBounds(31, 11, 65, 39);
		frame.getContentPane().add(lblNewLabel);
		
		JTable table =new JTable();
		
		Object[] columns = new Object[columnsName.size()];
		
		for (int i = 0; i < columnsName.size(); i++) {
			columns[i]=columnsName.get(i);
		}
		
	
		
		
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
		pane.setBounds(10, 47, 319, 177);
		pane.setForeground(Color.white);
		pane.setBackground(Color.red);
		frame.getContentPane().add(pane);

		JEditorPane editorPane = new JEditorPane();
		pane.setColumnHeaderView(editorPane);
		
		
		
		
		int j=0;
		ArrayList<JLabel>  labelList= new ArrayList<>();
		for (int i = 0; i < columnsName.size(); i++) {
			labelList.add(new JLabel(columnsName.get(i)));
			labelList.get(i).setForeground(Color.WHITE);
			labelList.get(i).setBounds(350, 77+j, 86, 20);
			frame.getContentPane().add(labelList.get(i));
			j+=44;
			
		}
		int y=0;
		ArrayList<JTextField>  textList= new ArrayList<>();
		
		for (int i = 0; i < columnsName.size(); i++) {
			textList.add(new JTextField());
			textList.get(i).setBounds(408, 77+y, 86, 20);
			frame.getContentPane().add(textList.get(i));
			textList.get(i).setColumns(10);
			y+=44;
			
		}
		int kk=0;
		ArrayList<JLabel>  typlistx= new ArrayList<>();
		for (int i = 0; i < type.length; i++) {
			typlistx.add(new JLabel(type[i].toString()));
			typlistx.get(i).setForeground(Color.WHITE);
			typlistx.get(i).setBounds(500, 77+kk, 86, 20);
			frame.getContentPane().add(typlistx.get(i));
			kk+=44;
			
		}
		if(xdasd.size()>0) {
		
		Object[] row= new Object[xdasd.get(0).length];
		for(int i=0;i<xdasd.size();i++) {
			
			for (int k = 0; k < xdasd.get(i).length; k++) {
				row[k]=xdasd.get(i)[k];				
				
			}
			model.addRow(row);
		} 
		
		
		
		
		
		
		
		
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				newProperty.clear();
				for(int i=0;i<columnsName.size();i++) { 
					row[i]=textList.get(i).getText();
					
					newProperty.add(textList.get(i).getText());
					
				}
				
				Save();
																
																								
			} 
		});
		}
		btnNewButton.setBounds(282, 384, 121, 52);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Delete");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int i =table.getSelectedRow();
				if(i>=0){
					
					model.removeRow(i);
					primeryArrayList.remove(i);
					try {
						savePrimery();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					Save();
					
				}
				else {
					JOptionPane.showMessageDialog(frame, "DeleteError");
				}
			}
		});
		btnNewButton_1.setBounds(146, 384, 126, 52);
		frame.getContentPane().add(btnNewButton_1);
		
		
		
		
		
		
		btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
               
               int i = table.getSelectedRow();
               
     				Boolean count = false;
     				for(int m = 0; m < primeryArrayList.size(); m++)
     				{
     					//(String) model.getValueAt(i, k);
     					
     					
     				    if(primeryArrayList.get(m).equals(textList.get(window1.xx.get(0).getSelectedIndex()).getText()))
     				    {
     				    	
     				        count = true;
     				        break;
     				    }
     				}
 					
 					if(((String) model.getValueAt(i, window1.xx.get(0).getSelectedIndex())).equals(textList.get(window1.xx.get(0).getSelectedIndex()).getText())) {
 						count=false;
 					}
 					
     				if(count)
     				{
     					JOptionPane.showMessageDialog(frame, "Ekleyemezsin");
     				}
     				else
     				{
     					for (int k = 0; k < columnsName.size(); k++) {
     	            	   
     	            	   model.setValueAt(textList.get(k).getText(), i, k);
     	            	   
     	            	   
     				}
     					primeryArrayList.remove(i);
     					primeryArrayList.add(i, textList.get(window1.xx.get(0).getSelectedIndex()).getText());
     					
     				}
     				
   
				
     				Save();
     				try {
						savePrimery();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
               
               
            }
        });
		
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
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(10, 384, 126, 50);
		frame.getContentPane().add(btnAdd);
		JLabel lblNewLabel_1 = new JLabel(window1.xx.get(0).getSelectedIndex()+" Column is primery key");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(429, 30, 170, 23);
		frame.getContentPane().add(lblNewLabel_1);
		

		
		
		
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				int aa=0;
				Object[] row= new Object[columnsName.size()];
				for(int i=0;i<columnsName.size();i++) {
					row[i]=textList.get(i).getText();
						
						
					
					
				}
				int k=0;
				Boolean count1 = false;
				for ( k = 0; k < columns.length; k++) {
					
					
					if (type[k].equals("Int")&& textList.get(k).getText().matches("[+-]?\\d*(\\.\\d+)?")) {
						
						count1=false;
					}
					else if(type[k].equals("String")&& !textList.get(k).getText().matches("[+-]?\\d*(\\.\\d+)?")) {
						
						count1=false;
					}
					else if (type[k].equals("Bool")) {
						count1=false;
					}
					else {
						count1=true;
						break;
					}
					
				}
				if(count1)
				{
					JOptionPane.showMessageDialog(frame, k +". false type");
				}
				else {
				
				if(primeryArrayList.size()>0) {
				Boolean count = false;
				for(int i = 0; i < primeryArrayList.size(); i++)
				{
				    if(primeryArrayList.get(i).equals(textList.get(window1.xx.get(0).getSelectedIndex()).getText()))
				    {
				        count = true;
				        break;
				    }
				} 
				if(count)
				{
					JOptionPane.showMessageDialog(frame, " You can't add,primary is already exist");
				}
				else
				{
					primeryArrayList.add(textList.get(window1.xx.get(0).getSelectedIndex()).getText());
					model.addRow(row);
					Save();
					
				}
				
				}
				else {
					primeryArrayList.add(textList.get(window1.xx.get(0).getSelectedIndex()).getText());
					
					
						model.addRow(row);
						Save();
						
						
			    	
				}
				try {
					savePrimery();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				
			}
		});
	
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
	private void savePrimery() throws IOException {
		
		File filex = new File(window1.tablename.get(0)+"Key"+".bin"); 
		filex.delete();
		File filexc = new File(window1.tablename.get(0)+"Key"+".bin"); 

		FileOutputStream fileWriterx = new FileOutputStream(filexc, true);
		DataOutputStream bWriterx = new DataOutputStream(fileWriterx);   
		
    	Files.write(Paths.get(window1.tablename.get(0)+"Key"+".bin"), (window1.xx.get(0).getSelectedIndex()+"\n").getBytes(), StandardOpenOption.APPEND);

	for (int i = 0; i < primeryArrayList.size(); i++) {
		
		
    	Files.write(Paths.get(window1.tablename.get(0)+"Key"+".bin"), (primeryArrayList.get(i)+" ").getBytes(), StandardOpenOption.APPEND);
    	bWriterx.close(); 
	}
 	
	}
	
	
	
	
	private void Save() {
		

			
			File file = new File(window1.tablename.get(0)+".bin");
			file.delete(); 
			try {
				
				
				for (int t = 0; t < columnsName.size(); t++) {
					File filex = new File(window1.tablename.get(0)+".bin"); 
					FileOutputStream fileWriterx = new FileOutputStream(filex, true);
					DataOutputStream bWriterx = new DataOutputStream(fileWriterx);
		        	Files.write(Paths.get(window1.tablename.get(0)+".bin"), (columnsName.get(t)+" ").getBytes(), StandardOpenOption.APPEND);
		        	
	    			    
					bWriterx.close(); 
				}
				Files.write(Paths.get(window1.tablename.get(0)+".bin"), ("\n").getBytes(), StandardOpenOption.APPEND);

			}catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			 
			
			
			File filex = new File(window1.tablename.get(0)+".bin"); 
			FileOutputStream fileWriterx;
			try {
				fileWriterx = new FileOutputStream(filex, true);
				DataOutputStream bWriterx = new DataOutputStream(fileWriterx);
			
			
			for (int x = 0; x < model.getRowCount(); x++) {
				for (int k = 0; k < columnsName.size(); k++) {
					 
					Files.write(Paths.get(window1.tablename.get(0)+".bin"), ((String)model.getValueAt(x, k)+" ").getBytes(), StandardOpenOption.APPEND);
					
					 
				}
				Files.write(Paths.get(window1.tablename.get(0)+".bin"), ("\n").getBytes(), StandardOpenOption.APPEND);
			} 
			bWriterx.close();  
			} 
			catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			
		}	
			
	}
}
