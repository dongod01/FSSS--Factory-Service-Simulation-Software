import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Font;
import java.awt.Window.Type;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.JSeparator;
import java.awt.Color;
import java.io.*;

@SuppressWarnings("serial")
public class ThirdPage extends JFrame{
	private JPanel contentPane;
	private JButton btnBack;
	
	//This page is used for changing all information of database \n 
	//i.e. total machines/adjusters present with the company. 
	
	//Creating buttons to be used on this page
	
	static SelMachine sel_mac = new SelMachine();
	static SelAdjuster sel_adj = new SelAdjuster();
	static PageEditMachine edit_mac = new PageEditMachine();
	static PageEditAdjuster edit_adj = new PageEditAdjuster();
	static PageDelMachine del_mac = new PageDelMachine();
	static PageDelAdjuster del_adj = new PageDelAdjuster();
	static ShowMachine show_mac = new ShowMachine();
	static ShowAdjuster show_adj = new ShowAdjuster();
	static Utilisation util = new Utilisation();
	
	public ThirdPage() {
		setBackground(new Color(204, 102, 204));
		setType(Type.POPUP);
		setTitle("Simulation Specification");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(50, 50, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(255, 252, 157));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Add new machine button
		
		JButton btnAddMachine = new JButton("Select Machine");
		btnAddMachine.setBackground(new Color(102, 255, 153));
		btnAddMachine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File f123 = new File("src/Machine_info.txt");
				//Error handling for zero machines in database
				if(!f123.exists() || f123.length()==0) {
					JOptionPane.showMessageDialog(null, "No machine in database","Error!",JOptionPane.ERROR_MESSAGE);
					
				}
				else {
				sel_mac.getComboBox().removeAllItems();
				sel_mac.getModel().removeAllElements();
				
				File file = new File("src/Machine_info_sim.txt");
				ArrayList<String> mach = new ArrayList<String>();
				if(file.exists()) {
					FileReader reader = null;
					try {
						reader = new FileReader("src/Machine_info_sim.txt");
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		            BufferedReader bufferedReader = new BufferedReader(reader);
		            String line;
		            int i=0;
		            try {
						while ((line = bufferedReader.readLine()) != null) {
						    if(i%4==0) {
						    	mach.add(line);
						    }
						    
						    i++;
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		            try {
						reader.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				ArrayList<MachineType> mac = new ArrayList<MachineType>();
				
				File fil = new File("src/Machine_info.txt");
				if(!fil.exists()) {
					JOptionPane.showMessageDialog(null, "No machine uploaded","Error!",JOptionPane.ERROR_MESSAGE);
				}
				
				else
				{
				
				if(fil.exists()) {
					FileReader reader = null;
					try {
						reader = new FileReader("src/Machine_info.txt");
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		            BufferedReader bufferedReader = new BufferedReader(reader);
		            String line;
		            
		            int i=0;
		            try {
		            	String s="";
		            	String ss="";
		            	int m=0;
		            	int n=0;
		            	int o=0;
						while ((line = bufferedReader.readLine()) != null) {
						    if(i%4==0) {
						    	s=line;
						    	ss=s.substring(0, s.length());
						    	
						    }
						    if(i%4==1) {
						    	m=Integer.parseInt(line);
						    }
						    if(i%4==2) {
						    	n=Integer.parseInt(line);
						    }
						    if(i%4==3) {
						    	o=Integer.parseInt(line);
						    	MachineType temp = new MachineType(ss,m,n,o);
						    	mac.add(temp);
						    }
						    i++;
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		            try {
						reader.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		            
				}
				}
				int i;
				for(i=0;i<mac.size();i++)
				{
					if(!mach.contains(mac.get(i).Get_name())) {
						sel_mac.getComboBox().addItem(mac.get(i).Get_name());
					}
				}
				if(sel_mac.getComboBox().getItemCount() == 1){
					sel_mac.getBtnAddAnotherMachinetype().setEnabled(false);
				}
				else {
					sel_mac.getBtnAddAnotherMachinetype().setEnabled(true);
				}
				if(sel_mac.getComboBox().getItemCount()!=0) {
				sel_mac.setVisible(true);
				}
				else if(f123.length()>0) {
					JOptionPane.showMessageDialog(null, "All machines already chosen","Error!",JOptionPane.ERROR_MESSAGE);
				}
			}
			}
		});
		btnAddMachine.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAddMachine.setBounds(40, 30, 200, 40);
		contentPane.add(btnAddMachine);
		
		JButton btnAddAdjuster = new JButton("Select Adjuster");
		btnAddAdjuster.setBackground(new Color(102, 255, 153));
		btnAddAdjuster.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				File fil12 = new File("src/Adjuster_info.txt");
				if(!fil12.exists() || fil12.length()==0) {
					JOptionPane.showMessageDialog(null, "No Adjuster in database","Error!",JOptionPane.ERROR_MESSAGE);
				}
				else {
				sel_adj.getComboBox().removeAllItems();
				sel_adj.getModel().removeAllElements();
				File file = new File("src/Adjuster_info_sim.txt");
				ArrayList<String> mach = new ArrayList<String>();
				if(file.exists()) {
					FileReader reader = null;
					try {
						reader = new FileReader("src/Adjuster_info_sim.txt");
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		            BufferedReader bufferedReader = new BufferedReader(reader);
		            String line;
		            int i=0;
		            try {
						while ((line = bufferedReader.readLine()) != null) {
						    if(i%3==0) {
						    	mach.add(line);
						    }
						    
						    i++;
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		            try {
						reader.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				ArrayList<AdjusterType> mac = new ArrayList<AdjusterType>();
				ArrayList<String> str = new ArrayList<String>();
				File fil = new File("src/Adjuster_info.txt");
				if(!fil.exists()) {
					JOptionPane.showMessageDialog(null, "No Adjuster uploaded","Error!",JOptionPane.ERROR_MESSAGE);
				}
				
				else
				{
				
				if(fil.exists()) {
					FileReader reader = null;
					try {
						reader = new FileReader("src/Adjuster_info.txt");
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		            BufferedReader bufferedReader = new BufferedReader(reader);
		            String line;
		            
		            int i=0;
		            try {
		            	String s="";
		            	String ss="";
		            	String s1="";
		            	String ss1="";
		            	
		            	int m=0;
		            	
						while ((line = bufferedReader.readLine()) != null) {
						    if(i%3==0) {
						    	s=line;
						    	ss=s.substring(0, s.length());
						    	
						    }
						    if(i%3==1) {
						    	
						    	s1=line;
						    	ss1=s1.substring(0,s1.length());
						    	str.add(ss1);
						    }
						    if(i%3==2) {
						    	m=Integer.parseInt(line);
						    	ArrayList<String> q = new ArrayList<String>();
						    	AdjusterType temp = new AdjusterType(ss,m,q);
						    	mac.add(temp);
						    	
						    }
						    
						    i++;
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		            try {
						reader.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		            
				}
				}
				int i;
				for(i=0;i<mac.size();i++)
				{
					if(!mach.contains(mac.get(i).Get_name())) {
						sel_adj.getComboBox().addItem(mac.get(i).Get_name());
					}
				}
				if(sel_adj.getComboBox().getItemCount() == 1){
					sel_adj.getBtnAddAnotherMachinetype().setEnabled(false);
				}
				else {
					sel_adj.getBtnAddAnotherMachinetype().setEnabled(true);
				}
				
				if(sel_adj.getComboBox().getItemCount()!=0) {
				sel_adj.setVisible(true);
				}
				else if(fil12.length()>0) {
					JOptionPane.showMessageDialog(null, "All adjusters already chosen","Error!",JOptionPane.ERROR_MESSAGE);
					
				}
			}
			}
		
		});
		btnAddAdjuster.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAddAdjuster.setBounds(40, 80, 200, 40);
		contentPane.add(btnAddAdjuster);
		
		JButton btnEditMachine = new JButton("Edit Machine");
		btnEditMachine.setBackground(new Color(102, 255, 153));
		btnEditMachine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			File file = new File("src/Machine_info_sim.txt");
			if(!file.exists() || file.length()==0){
				JOptionPane.showMessageDialog(null, "No machine selected,can't edit","Error!",JOptionPane.ERROR_MESSAGE);
			}
			else {
				edit_mac.getComboBox().removeAllItems();
				edit_mac.getModel().removeAllElements();
				edit_mac.getSpinner_1().setValue(1);
				
				ArrayList<String> mach = new ArrayList<String>();
				if(file.exists()) {
					FileReader reader = null;
					try {
						reader = new FileReader("src/Machine_info_sim.txt");
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		            BufferedReader bufferedReader = new BufferedReader(reader);
		            String line;
		            int i=0;
		            try {
						while ((line = bufferedReader.readLine()) != null) {
						    if(i%4==0) {
						    	mach.add(line);
						    }
						    
						    i++;
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		            try {
						reader.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				int i;
				for(i=0;i<mach.size();i++)
				{
					edit_mac.getComboBox().addItem(mach.get(i));
				}
				if(edit_mac.getComboBox().getItemCount() == 0){
					edit_mac.getBtnAddAnotherMachinetype().setEnabled(false);
				}
				else {
					edit_mac.getBtnAddAnotherMachinetype().setEnabled(true);
				}
				
			
				edit_mac.setVisible(true);
			}
			}
		});
		btnEditMachine.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnEditMachine.setBounds(40, 130, 200, 40);
		contentPane.add(btnEditMachine);
		
		JButton btnEditAdjuster = new JButton("Edit Adjuster");
		btnEditAdjuster.setBackground(new Color(102, 255, 153));
		btnEditAdjuster.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File file = new File("src/Adjuster_info_sim.txt");
				if(!file.exists() || file.length()==0) {
					JOptionPane.showMessageDialog(null, "No Adjuster selected,can't edit","Error!",JOptionPane.ERROR_MESSAGE);
				}
				else {
				edit_adj.getComboBox().removeAllItems();
				edit_adj.getModel().removeAllElements();
				
				edit_adj.getSpinner_1().setValue(1);
				
				ArrayList<String> mach = new ArrayList<String>();
				if(file.exists()) {
					FileReader reader = null;
					try {
						reader = new FileReader("src/Adjuster_info_sim.txt");
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		            BufferedReader bufferedReader = new BufferedReader(reader);
		            String line;
		            int i=0;
		            try {
						while ((line = bufferedReader.readLine()) != null) {
						    if(i%3==0) {
						    	mach.add(line);
						    }
						    
						    i++;
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		            try {
						reader.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				int i;
				for(i=0;i<mach.size();i++)
				{
					edit_adj.getComboBox().addItem(mach.get(i));
				}
				if(edit_adj.getComboBox().getItemCount() == 0){
					edit_adj.getBtnAddAnotherMachinetype().setEnabled(false);
				}
				else {
					edit_adj.getBtnAddAnotherMachinetype().setEnabled(true);
				}
				edit_adj.setVisible(true);
				
				}
			}
		});
		btnEditAdjuster.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnEditAdjuster.setBounds(40, 180, 200, 40);
		contentPane.add(btnEditAdjuster);
		
		JButton btnDelMachine = new JButton("Del Machine");
		btnDelMachine.setBackground(new Color(102, 255, 153));
		btnDelMachine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File file = new File("src/Machine_info_sim.txt");
				if(!file.exists() || file.length()==0) {
					JOptionPane.showMessageDialog(null, "No Machines selected,can't delete","Error!",JOptionPane.ERROR_MESSAGE);
				}
				else {
				del_mac.getComboBox().removeAllItems();
				del_mac.getModel().removeAllElements();
				
				
				ArrayList<String> mach = new ArrayList<String>();
				if(file.exists()) {
					FileReader reader = null;
					try {
						reader = new FileReader("src/Machine_info_sim.txt");
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		            BufferedReader bufferedReader = new BufferedReader(reader);
		            String line;
		            int i=0;
		            try {
						while ((line = bufferedReader.readLine()) != null) {
						    if(i%4==0) {
						    	mach.add(line);
						    }
						    
						    i++;
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		            try {
						reader.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				int i;
				for(i=0;i<mach.size();i++)
				{
					del_mac.getComboBox().addItem(mach.get(i));
				}
				if(del_mac.getComboBox().getItemCount() == 1){
					del_mac.getBtnAddAnotherMachinetype().setEnabled(false);
				}
				else {
					del_mac.getBtnAddAnotherMachinetype().setEnabled(true);
				}
				del_mac.setVisible(true);
				}
			}
		});
		btnDelMachine.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDelMachine.setBounds(40, 230, 200, 40);
		contentPane.add(btnDelMachine);
		
		JButton btnDelAdjuster = new JButton("Del Adjuster");
		btnDelAdjuster.setBackground(new Color(102, 255, 153));
		btnDelAdjuster.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File file = new File("src/Adjuster_info_sim.txt");
				if(!file.exists() || file.length()==0) {
					JOptionPane.showMessageDialog(null, "No Adjusters selected,can't delete","Error!",JOptionPane.ERROR_MESSAGE);
				}
				else {
				del_adj.getComboBox().removeAllItems();
				del_adj.getModel().removeAllElements();
				
				
				ArrayList<String> mach = new ArrayList<String>();
				if(file.exists()) {
					FileReader reader = null;
					try {
						reader = new FileReader("src/Adjuster_info_sim.txt");
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		            BufferedReader bufferedReader = new BufferedReader(reader);
		            String line;
		            int i=0;
		            try {
						while ((line = bufferedReader.readLine()) != null) {
						    if(i%3==0) {
						    	mach.add(line);
						    }
						    
						    i++;
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		            try {
						reader.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				int i;
				for(i=0;i<mach.size();i++)
				{
					del_adj.getComboBox().addItem(mach.get(i));
				}
				if(del_adj.getComboBox().getItemCount() == 1){
					del_adj.getBtnAddAnotherMachinetype().setEnabled(false);
				}
				else {
					del_adj.getBtnAddAnotherMachinetype().setEnabled(true);
				}
				del_adj.setVisible(true);
				}
			}
		});
		btnDelAdjuster.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDelAdjuster.setBounds(40, 280, 200, 40);
		contentPane.add(btnDelAdjuster);
		
		JButton btnShowMachine = new JButton("Selected Machines");
		btnShowMachine.setBackground(new Color(102, 255, 153));
		btnShowMachine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				File file = new File("src/Machine_info_sim.txt");
				if(!file.exists() || file.length()==0) {
					JOptionPane.showMessageDialog(null, "No machines selected, can't show","Error!",JOptionPane.ERROR_MESSAGE);
				}
				
				else
				{
				ArrayList<MachineType> mach = new ArrayList<MachineType>();
				if(file.exists()) {
					FileReader reader = null;
					try {
						reader = new FileReader("src/Machine_info_sim.txt");
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		            BufferedReader bufferedReader = new BufferedReader(reader);
		            String line;
		            
		            int i=0;
		            try {
		            	String s="";
		            	String ss="";
		            	int m=0;
		            	int n=0;
		            	int o=0;
						while ((line = bufferedReader.readLine()) != null) {
						    if(i%4==0) {
						    	s=line;
						    	ss=s.substring(0, s.length());
						    	
						    }
						    if(i%4==1) {
						    	m=Integer.parseInt(line);
						    }
						    if(i%4==2) {
						    	n=Integer.parseInt(line);
						    }
						    if(i%4==3) {
						    	o=Integer.parseInt(line);
						    	MachineType temp = new MachineType(ss,m,n,o);
						    	mach.add(temp);
						    	Object[] op = {temp.Get_name(),temp.Get_MTTf(),temp.Get_time_repir(),temp.Get_machine_no()};
						    	show_mac.getModel().addRow(op);
						    }
						    i++;
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		            try {
						reader.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				show_mac.setVisible(true);
				}
				
	
			}
		});
		btnShowMachine.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnShowMachine.setBounds(40, 330, 200, 40);
		contentPane.add(btnShowMachine);
		
		show_mac.getBtnBack().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				show_mac.setVisible(false);
				show_mac.getModel().setRowCount(0);
				setVisible(true);
			}
		});
		
		JButton btnShowAdjuster = new JButton("Selected Adjusters");
		btnShowAdjuster.setBackground(new Color(102, 255, 153));
		btnShowAdjuster.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				File file = new File("src/Adjuster_info_sim.txt");
				if(!file.exists()|| file.length()==0) {
					JOptionPane.showMessageDialog(null, "No Adjuster selected, can't show","Error!",JOptionPane.ERROR_MESSAGE);
				}
				
				else
				{
				ArrayList<AdjusterType> mach = new ArrayList<AdjusterType>();
				ArrayList<String> str = new ArrayList<String>();
				if(file.exists()) {
					FileReader reader = null;
					try {
						reader = new FileReader("src/Adjuster_info_sim.txt");
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		            BufferedReader bufferedReader = new BufferedReader(reader);
		            String line;
		            
		            int i=0;
		            try {
		            	String s="";
		            	String ss="";
		            	String s1="";
		            	String ss1="";
		            	
		            	int m=0;
		            	
						while ((line = bufferedReader.readLine()) != null) {
						    if(i%3==0) {
						    	s=line;
						    	ss=s.substring(0, s.length());
						    	
						    }
						    if(i%3==1) {
						    	
						    	s1=line;
						    	ss1=s1.substring(0,s1.length());
						    	str.add(ss1);
						    }
						    if(i%3==2) {
						    	m=Integer.parseInt(line);
						    	ArrayList<String> q = new ArrayList<String>();
						    	AdjusterType temp = new AdjusterType(ss,m,q);
						    	mach.add(temp);
						    	Object[] op = {ss,ss1,m};
						    	show_adj.getModel().addRow(op);
						    	
						    }
						    
						    i++;
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		            try {
						reader.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		            
				}
				
				show_adj.setVisible(true);
				}
	
			}
		});
		btnShowAdjuster.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnShowAdjuster.setBounds(40, 380, 200, 40);
		contentPane.add(btnShowAdjuster);
		
		show_adj.getBtnBack().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				show_adj.setVisible(false);
				show_adj.getModel().setRowCount(0);
				setVisible(true);
			}
		});
		
		JLabel label = new JLabel("");
		label.setBounds(250, 30,700, 390);
		contentPane.add(label);
		ImageIcon image = new ImageIcon("src/Factory_image.jpg");
		Image img = image.getImage();
		Image newImg = img.getScaledInstance(label.getWidth(),label.getHeight(),Image.SCALE_SMOOTH);
		image = new ImageIcon(newImg);
		label.setIcon(image);
		
		btnBack = new JButton("back");
		btnBack.setForeground(new Color(255, 0, 0));
		btnBack.setBackground(new Color(102, 255, 153));
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				setVisible(false);
				
			}
		});
		btnBack.setBounds(800, 520, 150, 30);
		contentPane.add(btnBack);
		
		sel_mac.getButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File file = new File("src/Machine_info.txt");
				if(!file.exists()) {
					JOptionPane.showMessageDialog(null, "No machine uploaded","Error!",JOptionPane.ERROR_MESSAGE);
				}
				
				else
				{
					sel_mac.getModel().addElement(sel_mac.getComboBox().getSelectedItem().toString());
					
					ArrayList <String> arl = new ArrayList <String> ();
					for(int i=0; i<sel_mac.getModel().getSize(); i++)
					{
						arl.add(sel_mac.getModel().getElementAt(i).toString());
					}
					int del[] = new int[100];
					int k;
					for(k=0;k<100;k++) {
						del[k]=1;
					}
				ArrayList<MachineType> mach = new ArrayList<MachineType>();
				if(file.exists()) {
					FileReader reader = null;
					try {
						reader = new FileReader("src/Machine_info.txt");
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		            BufferedReader bufferedReader = new BufferedReader(reader);
		            String line;
		            
		            int i=0;
		            try {
		            	String s="";
		            	String ss="";
		            	int m=0;
		            	int n=0;
		            	int o=0;
						while ((line = bufferedReader.readLine()) != null) {
						    if(i%4==0) {
						    	s=line;
						    	ss=s.substring(0, s.length());
						    	
						    }
						    if(i%4==1) {
						    	m=Integer.parseInt(line);
						    }
						    if(i%4==2) {
						    	n=Integer.parseInt(line);
						    }
						    if(i%4==3) {
						    	o=Integer.parseInt(line);
						    	MachineType temp = new MachineType(ss,m,n,o);
						    	mach.add(temp);
						    }
						    i++;
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		            try {
						reader.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		            //file.delete();
				}
				int m=0;
				for(m=0;m<mach.size();m++) {
					String name = mach.get(m).Get_name();
					if(arl.contains(name)) {
						del[m]=0;
					}
				}
				
					int i=0;
					File f = new File("src/Machine_info_sim.txt");
					FileWriter fr = null;
					try {
						fr = new FileWriter(f, true);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					BufferedWriter br = new BufferedWriter(fr);
					for(i=0;i<mach.size();i++) {
						if(del[i]==0) {
						try {
							br.write(mach.get(i).Get_name());
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}try {
							br.write("\n");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						try {
							br.write(String.valueOf(mach.get(i).Get_MTTf()));
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}try {
							br.write("\n");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						try {
							br.write(String.valueOf(mach.get(i).Get_time_repir()));
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}try {
							br.write("\n");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						try {
							br.write(String.valueOf(mach.get(i).Get_machine_no()));
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}try {
							br.write("\n");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					}
					try {
						br.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						fr.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					sel_mac.setVisible(false);
				
				}
			}
		});
		
		sel_adj.getButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File file = new File("src/Adjuster_info.txt");
				if(!file.exists()) {
					JOptionPane.showMessageDialog(null, "No Adjuster uploaded","Error!",JOptionPane.ERROR_MESSAGE);
				}
				
				else
				{
					sel_adj.getModel().addElement(sel_adj.getComboBox().getSelectedItem().toString());
					
					ArrayList <String> arl = new ArrayList <String> ();
					for(int i=0; i<sel_adj.getModel().getSize(); i++)
					{
						arl.add(sel_adj.getModel().getElementAt(i).toString());
					}
					int del[] = new int[100];
					int k;
					for(k=0;k<100;k++) {
						del[k]=1;
					}
				ArrayList<AdjusterType> mach = new ArrayList<AdjusterType>();
				ArrayList<String> str = new ArrayList<String>();
				if(file.exists()) {
					FileReader reader = null;
					try {
						reader = new FileReader("src/Adjuster_info.txt");
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		            BufferedReader bufferedReader = new BufferedReader(reader);
		            String line;
		            
		            int i=0;
		            try {
		            	String s="";
		            	String ss="";
		            	String s1="";
		            	String ss1="";
		            	
		            	int m=0;
		            	
						while ((line = bufferedReader.readLine()) != null) {
						    if(i%3==0) {
						    	s=line;
						    	ss=s.substring(0, s.length());
						    	
						    }
						    if(i%3==1) {
						    	
						    	s1=line;
						    	ss1=s1.substring(0,s1.length());
						    	str.add(ss1);
						    }
						    if(i%3==2) {
						    	m=Integer.parseInt(line);
						    	ArrayList<String> q = new ArrayList<String>();
						    	AdjusterType temp = new AdjusterType(ss,m,q);
						    	mach.add(temp);
						    	
						    }
						    
						    i++;
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		            try {
						reader.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		            
				}
				
				int m=0;
				for(m=0;m<mach.size();m++) {
					String name = mach.get(m).Get_name();
					if(arl.contains(name)) {
						del[m]=0;
					}
				}
				
					
					File f = new File("src/Adjuster_info_sim.txt");
					FileWriter fr = null;
					try {
						fr = new FileWriter(f, true);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					int i=0;
					BufferedWriter br = new BufferedWriter(fr);
					for(i=0;i<mach.size();i++) {
						if(del[i]==0) {
						try {
							br.write(mach.get(i).Get_name());
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}try {
							br.write("\n");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						try {
							br.write(str.get(i));
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}try {
							br.write("\n");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						try {
							br.write(String.valueOf(mach.get(i).Get_Adjuster_no()));
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}try {
							br.write("\n");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					}
					try {
						br.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						fr.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					sel_adj.setVisible(false);
				
				}
			}
		});
		
		edit_mac.getButton().addActionListener(new ActionListener() {
			int editm_check=0;
			public void actionPerformed(ActionEvent arg0) {
				if(edit_mac.getModel().getSize()==1) {
				File file = new File("src/Machine_info_sim.txt");
				if(!file.exists()) {
					JOptionPane.showMessageDialog(null, "No machine uploaded","Error!",JOptionPane.ERROR_MESSAGE);
				}
				
				else
				{
				ArrayList<MachineType> mach = new ArrayList<MachineType>();
				if(file.exists()) {
					FileReader reader = null;
					try {
						reader = new FileReader("src/Machine_info_sim.txt");
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		            BufferedReader bufferedReader = new BufferedReader(reader);
		            String line;
		            
		            int i=0;
		            try {
		            	String s="";
		            	String ss="";
		            	int m=0;
		            	int n=0;
		            	int o=0;
						while ((line = bufferedReader.readLine()) != null) {
						    if(i%4==0) {
						    	s=line;
						    	ss=s.substring(0, s.length());
						    	
						    }
						    if(i%4==1) {
						    	m=Integer.parseInt(line);
						    }
						    if(i%4==2) {
						    	n=Integer.parseInt(line);
						    }
						    if(i%4==3) {
						    	o=Integer.parseInt(line);
						    	MachineType temp = new MachineType(ss,m,n,o);
						    	mach.add(temp);
						    }
						    i++;
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		            try {
						reader.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		            if((Integer)edit_mac.getSpinner_1().getValue()>=1 && (Integer)edit_mac.getSpinner_1().getValue()<=1000)
		            {
		            file.delete();
		            }
				}
				if((Integer)edit_mac.getSpinner_1().getValue()>=1 && (Integer)edit_mac.getSpinner_1().getValue()<=1000)
				{
					String name = edit_mac.getModel().getElementAt(0).toString();
					
					int i=0;
					for(i=0;i<mach.size();i++) {
						if(mach.get(i).Get_name().equals(name)) {
							
							mach.get(i).Set_machine_no((Integer)edit_mac.getSpinner_1().getValue());
							
						}
						
					}
					File f = new File("src/Machine_info_sim.txt");
					FileWriter fr = null;
					try {
						fr = new FileWriter(f, true);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					BufferedWriter br = new BufferedWriter(fr);
					for(i=0;i<mach.size();i++) {
						try {
							br.write(mach.get(i).Get_name());
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}try {
							br.write("\n");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						try {
							br.write(String.valueOf(mach.get(i).Get_MTTf()));
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}try {
							br.write("\n");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						try {
							br.write(String.valueOf(mach.get(i).Get_time_repir()));
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}try {
							br.write("\n");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						try {
							br.write(String.valueOf(mach.get(i).Get_machine_no()));
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}try {
							br.write("\n");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					try {
						br.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						fr.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					edit_mac.setVisible(false);
				}
				else if ((Integer)edit_mac.getSpinner_1().getValue()<1){
					editm_check=1;
					JOptionPane.showMessageDialog(null, "Quantity cannot be negative or zero","Error!",JOptionPane.ERROR_MESSAGE);
					edit_mac.getSpinner_1().setValue(1);
					editm_check=0;
				}
				else if ((Integer)edit_mac.getSpinner_1().getValue()>1000){
					editm_check=11;
					JOptionPane.showMessageDialog(null, "Quantity cannot exceed 1000","Error!",JOptionPane.ERROR_MESSAGE);
					edit_mac.getSpinner_1().setValue(1);
					editm_check=0;
				}
				
				}
			}
				else {
					JOptionPane.showMessageDialog(null, "Machine not chosen","Error!",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		edit_adj.getButton().addActionListener(new ActionListener() {
			int editadj_check=0;
			public void actionPerformed(ActionEvent arg0) {
				if(edit_adj.getModel().getSize()==1) {
				File file = new File("src/Adjuster_info_sim.txt");
				if(!file.exists()) {
					JOptionPane.showMessageDialog(null, "No Adjuster uploaded","Error!",JOptionPane.ERROR_MESSAGE);
				}
				
				else
				{
				ArrayList<AdjusterType> mach = new ArrayList<AdjusterType>();
				ArrayList<String> str = new ArrayList<String>();
				if(file.exists()) {
					FileReader reader = null;
					try {
						reader = new FileReader("src/Adjuster_info_sim.txt");
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		            BufferedReader bufferedReader = new BufferedReader(reader);
		            String line;
		            
		            int i=0;
		            try {
		            	String s="";
		            	String ss="";
		            	String s1="";
		            	String ss1="";
		            	
		            	int m=0;
		            	
						while ((line = bufferedReader.readLine()) != null) {
						    if(i%3==0) {
						    	s=line;
						    	ss=s.substring(0, s.length());
						    	
						    }
						    if(i%3==1) {
						    	
						    	s1=line;
						    	ss1=s1.substring(0,s1.length());
						    	str.add(ss1);
						    }
						    if(i%3==2) {
						    	m=Integer.parseInt(line);
						    	ArrayList<String> q = new ArrayList<String>();
						    	AdjusterType temp = new AdjusterType(ss,m,q);
						    	mach.add(temp);
						    	
						    }
						    
						    i++;
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		            try {
						reader.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		            
				}
				File fil = new File("src/Adjuster_info_sim.txt");
				if(fil.exists() && (Integer)edit_adj.getSpinner_1().getValue()>=1 && (Integer)edit_adj.getSpinner_1().getValue()<=1000) {
					fil.delete();
				}
				if((Integer)edit_adj.getSpinner_1().getValue()>=1 && (Integer)edit_adj.getSpinner_1().getValue()<=1000)
				{
					String name = edit_adj.getModel().getElementAt(0).toString();
					
					int i=0;
					for(i=0;i<mach.size();i++) {
						if(mach.get(i).Get_name().equals(name)) {
							
							mach.get(i).Set_Adjuster_no((Integer)edit_adj.getSpinner_1().getValue());
							
						}
						
					}
					File f = new File("src/Adjuster_info_sim.txt");
					FileWriter fr = null;
					try {
						fr = new FileWriter(f, true);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					BufferedWriter br = new BufferedWriter(fr);
					for(i=0;i<mach.size();i++) {
						try {
							br.write(mach.get(i).Get_name());
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}try {
							br.write("\n");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						try {
							br.write(str.get(i));
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}try {
							br.write("\n");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						try {
							br.write(String.valueOf(mach.get(i).Get_Adjuster_no()));
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}try {
							br.write("\n");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					try {
						br.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						fr.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					edit_adj.setVisible(false);
				}
				else if ((Integer)edit_adj.getSpinner_1().getValue()<1){
					editadj_check=1;
					JOptionPane.showMessageDialog(null, "Quantity cannot be negative or zero","Error!",JOptionPane.ERROR_MESSAGE);
					edit_adj.getSpinner_1().setValue(1);
					editadj_check=0;
				}
				else if ((Integer)edit_adj.getSpinner_1().getValue()>1000){
					editadj_check=11;
					JOptionPane.showMessageDialog(null, "Quantity cannot exceed 1000","Error!",JOptionPane.ERROR_MESSAGE);
					edit_adj.getSpinner_1().setValue(1);
					editadj_check=0;
				}
				
				}
			}
				else {
					JOptionPane.showMessageDialog(null, "Select the adjuster","Error!",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		del_mac.getButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File file = new File("src/Machine_info_sim.txt");
				if(!file.exists()) {
					JOptionPane.showMessageDialog(null, "No machine uploaded","Error!",JOptionPane.ERROR_MESSAGE);
				}
				
				else
				{
					del_mac.getModel().addElement(del_mac.getComboBox().getSelectedItem().toString());
					
					ArrayList <String> arl = new ArrayList <String> ();
					for(int i=0; i<del_mac.getModel().getSize(); i++)
					{
						arl.add(del_mac.getModel().getElementAt(i).toString());
					}
					int del[] = new int[100];
					int k;
					for(k=0;k<100;k++) {
						del[k]=1;
					}
				ArrayList<MachineType> mach = new ArrayList<MachineType>();
				if(file.exists()) {
					FileReader reader = null;
					try {
						reader = new FileReader("src/Machine_info_sim.txt");
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		            BufferedReader bufferedReader = new BufferedReader(reader);
		            String line;
		            
		            int i=0;
		            try {
		            	String s="";
		            	String ss="";
		            	int m=0;
		            	int n=0;
		            	int o=0;
						while ((line = bufferedReader.readLine()) != null) {
						    if(i%4==0) {
						    	s=line;
						    	ss=s.substring(0, s.length());
						    	
						    }
						    if(i%4==1) {
						    	m=Integer.parseInt(line);
						    }
						    if(i%4==2) {
						    	n=Integer.parseInt(line);
						    }
						    if(i%4==3) {
						    	o=Integer.parseInt(line);
						    	MachineType temp = new MachineType(ss,m,n,o);
						    	mach.add(temp);
						    }
						    i++;
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		            try {
						reader.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		            file.delete();
				}
				int m=0;
				for(m=0;m<mach.size();m++) {
					String name = mach.get(m).Get_name();
					if(arl.contains(name)) {
						del[m]=0;
					}
				}
				
					
					int i=0;
					File f = new File("src/Machine_info_sim.txt");
					FileWriter fr = null;
					try {
						fr = new FileWriter(f, true);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					BufferedWriter br = new BufferedWriter(fr);
					for(i=0;i<mach.size();i++) {
						if(del[i]==1) {
						try {
							br.write(mach.get(i).Get_name());
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}try {
							br.write("\n");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						try {
							br.write(String.valueOf(mach.get(i).Get_MTTf()));
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}try {
							br.write("\n");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						try {
							br.write(String.valueOf(mach.get(i).Get_time_repir()));
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}try {
							br.write("\n");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						try {
							br.write(String.valueOf(mach.get(i).Get_machine_no()));
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}try {
							br.write("\n");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					}
					try {
						br.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						fr.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					del_mac.setVisible(false);
				
				}
			}
		});
		
		del_adj.getButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File file = new File("src/Adjuster_info_sim.txt");
				if(!file.exists()) {
					JOptionPane.showMessageDialog(null, "No Adjuster uploaded","Error!",JOptionPane.ERROR_MESSAGE);
				}
				
				else
				{
					del_adj.getModel().addElement(del_adj.getComboBox().getSelectedItem().toString());
					
					ArrayList <String> arl = new ArrayList <String> ();
					for(int i=0; i<del_adj.getModel().getSize(); i++)
					{
						arl.add(del_adj.getModel().getElementAt(i).toString());
					}
					int del[] = new int[100];
					int k;
					for(k=0;k<100;k++) {
						del[k]=1;
					}
				ArrayList<AdjusterType> mach = new ArrayList<AdjusterType>();
				ArrayList<String> str = new ArrayList<String>();
				if(file.exists()) {
					FileReader reader = null;
					try {
						reader = new FileReader("src/Adjuster_info_sim.txt");
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		            BufferedReader bufferedReader = new BufferedReader(reader);
		            String line;
		            
		            int i=0;
		            try {
		            	String s="";
		            	String ss="";
		            	String s1="";
		            	String ss1="";
		            	
		            	int m=0;
		            	
						while ((line = bufferedReader.readLine()) != null) {
						    if(i%3==0) {
						    	s=line;
						    	ss=s.substring(0, s.length());
						    	
						    }
						    if(i%3==1) {
						    	
						    	s1=line;
						    	ss1=s1.substring(0,s1.length());
						    	str.add(ss1);
						    }
						    if(i%3==2) {
						    	m=Integer.parseInt(line);
						    	ArrayList<String> q = new ArrayList<String>();
						    	AdjusterType temp = new AdjusterType(ss,m,q);
						    	mach.add(temp);
						    	
						    }
						    
						    i++;
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		            try {
						reader.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		            
				}
				File fil = new File("src/Adjuster_info_sim.txt");
				if(fil.exists()) {
					fil.delete();
				}
				int m=0;
				for(m=0;m<mach.size();m++) {
					String name = mach.get(m).Get_name();
					if(arl.contains(name)) {
						del[m]=0;
					}
				}
				
					
					File f = new File("src/Adjuster_info_sim.txt");
					FileWriter fr = null;
					try {
						fr = new FileWriter(f, true);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					int i=0;
					BufferedWriter br = new BufferedWriter(fr);
					for(i=0;i<mach.size();i++) {
						if(del[i]==1) {
						try {
							br.write(mach.get(i).Get_name());
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}try {
							br.write("\n");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						try {
							br.write(str.get(i));
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}try {
							br.write("\n");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						try {
							br.write(String.valueOf(mach.get(i).Get_Adjuster_no()));
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}try {
							br.write("\n");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					}
					try {
						br.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						fr.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					del_adj.setVisible(false);
				
				}
			}
		});
		}	
}
	