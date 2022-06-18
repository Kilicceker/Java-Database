import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Window8 {
	static ArrayList<String>  columnsName= new ArrayList<>();
	static ArrayList<Integer>  primeIndex= new ArrayList<>();
	static ArrayList<String>  typeArrayList= new ArrayList<>();
	 
	 
	 static Window9 window9=new Window9();
	static ArrayList<String[]>  xdasd= new ArrayList<>();
	private DefaultTableModel model =new DefaultTableModel();
	 JTable table =new JTable();
/**
 * @wbp.parser.entryPoint
 */
public void showWindow8() throws IOException {
		
		
		
		JFrame frame = new JFrame("WINDOW8");
		frame.getContentPane().setBackground(new Color(0,0,0));
		frame.getContentPane().setForeground(Color.white);
		frame.setBounds(700,300,615,574);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
	
		frame.revalidate();
		frame.setVisible(true);
		
		File file = new File(window9.tablex.get(0)+".bin");
		
		InputStream insputStream = new FileInputStream(file);
		
		long length = file.length();
		
		byte[] bytes = new byte[(int) length];

		insputStream.read(bytes);
		insputStream.close();
		
		String s = new String(bytes);
		
		String [] array=s.split("\n");
		
		String [] arrayColumns=array[0].split(" ");
		
		
		
		File filex = new File(window9.tablex.get(0)+"Type"+".bin");
		
		InputStream insputStreamx = new FileInputStream(filex);
		
		long lengthx = filex.length();
		
		byte[] bytesx = new byte[(int) lengthx];

		insputStreamx.read(bytesx);
		insputStreamx.close();
		
		String sx = new String(bytesx);
		
		String [] arrayx=sx.split(" ");
		
		File file1 = new File(window9.tablex.get(0)+".bin");
		
		InputStream insputStream1 = new FileInputStream(file1);
		
		long length1 = file1.length();
		
		byte[] bytes1 = new byte[(int) length1];

		insputStream1.read(bytes1);
		insputStream1.close();
		
		String s1 = new String(bytes);
		
		String [] array1=s1.split("\n");
		
		String [] arrayColumns1=array[0].split(" ");
		
		
		
		
		for (int i = 0; i < arrayColumns.length; i++) {
			columnsName.add(arrayColumns[i]);
		}
		
		for (int i = 1; i < array.length; i++) {
			
			xdasd.add(array[i].split(" "));
		}
		
		
	
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Object[] columns= new Object[3];
				
				for(int i=0;i<3;i++) {
					
					columns[i]=columnsName.get(i);
					
				} 
				if(columns==null) {
					System.out.println();
				}
				model.setColumnIdentifiers(columns);
				
			
				
				Object[] row= new Object[xdasd.get(0).length];
				
				for(int i=0;i<xdasd.size();i++) {
					
					for (int k = 0; k < xdasd.get(i).length; k++) {
						row[k]=xdasd.get(i)[k];				
						
					}
					model.addRow(row);
				} 
				table.repaint();
				
			}
		});
		btnNewButton.setBounds(262, 219, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		
		
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
		
		
		
		frame.setVisible(true);
		
		
		
}}
