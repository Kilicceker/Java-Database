import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Window10 {
	static ArrayList<String>  columnsName= new ArrayList<>();
	static ArrayList<Integer>  primeIndex= new ArrayList<>();
	static ArrayList<String>  typeArrayList= new ArrayList<>();
	 
	static ArrayList<String>  primeList= new ArrayList<>();
	 static Window11 window11=new Window11();
	static ArrayList<String[]>  xdasd= new ArrayList<>();
	private DefaultTableModel model =new DefaultTableModel();
	 JTable table =new JTable();
	
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public void showWindow10() throws IOException{
		
		
		JFrame frame = new JFrame("WINDOW10");
		frame.getContentPane().setBackground(new Color(0,0,0));
		frame.getContentPane().setForeground(Color.white);
		frame.setBounds(700,300,615,574);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		
	
		
		File file = new File(window11.tablex.get(0)+".bin");
		
		InputStream insputStream = new FileInputStream(file);
		
		long length = file.length();
		
		byte[] bytes = new byte[(int) length];

		insputStream.read(bytes);
		insputStream.close();
		
		String s = new String(bytes);
		
		String [] array=s.split("\n");
		
		String [] arrayColumns=array[0].split(" ");
		
		
		
		File filex = new File(window11.tablex.get(0)+"Type"+".bin");
		
		InputStream insputStreamx = new FileInputStream(filex);
		
		long lengthx = filex.length();
		
		byte[] bytesx = new byte[(int) lengthx];

		insputStreamx.read(bytesx);
		insputStreamx.close();
		
		String sx = new String(bytesx);
		
		String [] arrayx=sx.split(" ");
		
		File file1 = new File(window11.tablex.get(0)+"Key"+".bin");
		
		InputStream insputStream1 = new FileInputStream(file1);
		
		long length1 = file1.length();
		
		byte[] bytes1 = new byte[(int) length1];

		insputStream1.read(bytes1);
		insputStream1.close();
		
		String s1 = new String(bytes1);
		
		String [] array1=s1.split("\n");
		String [] array2=array1[1].split(" ");
		primeIndex.add(Integer.parseInt(array1[0]));
		
		for (int i = 0; i < array2.length; i++) {
			primeList.add(array2[i]);
		}
		
		
		for (int i = 0; i < arrayColumns.length; i++) {
			columnsName.add(arrayColumns[i]);
		}
		
		for (int i = 1; i < array.length; i++) {
			
			xdasd.add(array[i].split(" "));
		}
		String[] uniqe=new String[xdasd.size()];
		for (int i = 0; i < xdasd.size(); i++) {
			
			
			uniqe[i]=xdasd.get(i)[primeIndex.get(0)];
		}
		
		
		
		JTable table =new JTable();
		
		
		Object[] columns = new Object[arrayColumns.length];
		
		for (int i = 0; i < columnsName.size(); i++) {
			columns[i]=columnsName.get(i);
			
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
	pane.setBounds(37, 58, 319, 134);
	pane.setForeground(Color.white);
	pane.setBackground(Color.red);
	frame.getContentPane().add(pane);

	JEditorPane editorPane = new JEditorPane();
	pane.setColumnHeaderView(editorPane);
	
	JButton btnNewButton = new JButton("Ordered");
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			
			
			if(arrayx[primeIndex.get(0)].equals("String")) {
				
				for (int i = 0; i < xdasd.size(); i++) {
					for (int j = i+1; j < xdasd.size(); j++) {
						  if(primeList.get(i).compareTo(primeList.get(j))>0) {
							  
							  String[]  xx= xdasd.get(i);
							  xdasd.set(i, xdasd.get(j));
							  xdasd.set(j, xx);
							  
							  String xx2=primeList.get(i);
							  primeList.set(i, primeList.get(j));
							  primeList.set(j, xx2);
							  
						  }
					}
				}
				
				
			}
			
			else if(arrayx[primeIndex.get(0)].equals("Int")) {
				for (int i = 0; i < xdasd.size(); i++) {
					for (int j = i+1; j < xdasd.size(); j++) {
						  if(Integer.parseInt(primeList.get(i))>Integer.parseInt(primeList.get(j))) {
							  
							  String[]  xx= xdasd.get(i);
							  xdasd.set(i, xdasd.get(j));
							  xdasd.set(j, xx);
							  
							  String xx2=primeList.get(i);
							  primeList.set(i, primeList.get(j));
							  primeList.set(j, xx2);
							 
						  }
					}
					 
				}
				
			}
			
			Object[] row= new Object[xdasd.get(0).length];
			model.setRowCount(0);
			for(int i=0;i<xdasd.size();i++) {
				
				for (int k = 0; k < xdasd.get(i).length; k++) {
					row[k]=xdasd.get(i)[k];				
					
				}
				model.addRow(row);
			} 
		
			
			
		}
	});
	btnNewButton.setBounds(366, 65, 89, 23);
	frame.getContentPane().add(btnNewButton);
	Object[] row= new Object[xdasd.get(0).length];
	for(int i=0;i<xdasd.size();i++) {
		
		for (int k = 0; k < xdasd.get(i).length; k++) {
			row[k]=xdasd.get(i)[k];				
			
		}
		model.addRow(row);
	}
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
	
	JLabel lblNewLabel = new JLabel(window11.tablex.get(0));
	lblNewLabel.setForeground(Color.CYAN);
	lblNewLabel.setBounds(148, 27, 131, 20);
	frame.getContentPane().add(lblNewLabel);
	
	frame.revalidate();
	frame.setVisible(true);
	}
}
