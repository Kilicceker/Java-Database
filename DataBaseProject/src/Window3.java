import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.JList;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JFormattedTextField;
import java.awt.TextArea;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import java.awt.Choice;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

import java.awt.Window.Type;
import javax.swing.JComboBox;

public class Window3 {

	public static ArrayList<String>  tables= new ArrayList<>();
	public static ArrayList<String>  table= new ArrayList<>();
	/**
	 * @wbp.parser.entryPoint
	 */
	
	public void showWindow3() throws IOException{
		
		JFrame frame = new JFrame("WINDOW3");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(new Color(0,0,0));
		frame.getContentPane().setForeground(Color.white);
		frame.setBounds(700,300,615,574);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setEnabled(false);
		frame.setBounds(700,300,550,633);
		frame.getContentPane().add(scrollBar);
		
		

		try{
			
			File file = new File("Tables.bin");
			
			InputStream insputStream = new FileInputStream(file);
			long length = file.length();
			byte[] bytes = new byte[(int) length];

			insputStream.read(bytes);
			insputStream.close();
		
			String s = new String(bytes);
					
			String [] array=s.split("\n");
			
			for (int i = 0; i < array.length; i++) {
				tables.add(array[i]);
			}
			
			}catch(Exception e){
				System.out.println("Error is:" + e.getMessage());
			}
        
        
        
       String d;
        int j=0;
		for (int i = 0; i < tables.size(); i++) {
			
			JButton btnNewButton = new JButton(tables.get(i)); 
			
			btnNewButton.setBounds(170, 0+j, 166, 31);
			frame.getContentPane().add(btnNewButton); 
			
			btnNewButton.addActionListener(new ActionListener() { 
				 
				@Override
				public void actionPerformed(ActionEvent arg0) {
					table.add(btnNewButton.getText());
					frame.setVisible(false);
					Window4 w4= new Window4();
					try {
						w4.showWindow4();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
					
					
				}
				
			});
			
			j+=44;
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
		
		String[] strg=new String[tables.size()];
		for (int i = 0; i < tables.size(); i++) {
		     strg[i]=tables.get(i);
		}

	
		JComboBox comboBox = new JComboBox();
		for (int i = 0; i < strg.length; i++) {
			
			
			comboBox.setModel(new DefaultComboBoxModel(strg));

		}
		comboBox.setBounds(389, 448, 116, 22);
		frame.getContentPane().add(comboBox);
		
		
		
		
		
		JLabel lblNewLabel = new JLabel("Select Delete Table");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(389, 412, 135, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Delete");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				File filex = new File(comboBox.getSelectedItem().toString()+"Key"+".bin");
				filex.delete();
				File filex1 = new File(comboBox.getSelectedItem().toString()+"Type"+".bin");
				filex1.delete();
				File filex2 = new File(comboBox.getSelectedItem().toString()+".bin");
				filex2.delete();
				
				tables.remove(comboBox.getSelectedItem());
				 
				File filexx = new File("Tables.bin");
				filexx.delete();
				
				File file = new File("Tables.bin");
				try {
					FileOutputStream fileWriter = new FileOutputStream(file, true);
					DataOutputStream  bWriter = new DataOutputStream (fileWriter);
					for (int i = 0; i < tables.size(); i++) {
					   Files.write(Paths.get("Tables.bin"), (tables.get(i).toString()+"\n").getBytes(), StandardOpenOption.APPEND);
					
					}
					JOptionPane.showMessageDialog(frame, "Succesful delete");

					
					bWriter.close();
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				frame.repaint(100);
			}
		});
		btnNewButton_1.setBounds(389, 501, 116, 35);
		frame.getContentPane().add(btnNewButton_1);
		
	
		
		
		frame.setVisible(true);
		
	}
}
