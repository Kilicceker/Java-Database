import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
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
import java.awt.Window.Type;

public class Window11 {

	 static ArrayList<String>  tables= new ArrayList<>();
	 static ArrayList<String>  tablex= new ArrayList<>();
	 
	/**
	 * @wbp.parser.entryPoint
	 */
	
	public void showWindow11() throws IOException{
		
		JFrame frame = new JFrame("WINDOW11");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(new Color(0,0,0));
		frame.getContentPane().setForeground(Color.white);
		frame.setBounds(700,300,615,574);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setEnabled(false);
		frame.setBounds(700,300,615,574);
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
			
			btnNewButton.setBounds(200, 0+j, 166, 31);
			frame.getContentPane().add(btnNewButton); 
			
			btnNewButton.addActionListener(new ActionListener() { 
				 
				@Override
				public void actionPerformed(ActionEvent arg0) {
					tablex.add(btnNewButton.getText());
					frame.setVisible(false);
					Window10 w10= new Window10();
					try {
						w10.showWindow10();
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
	
		
		
		frame.setVisible(true);
		
	}
}
