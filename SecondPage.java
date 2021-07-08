import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JTextField;
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
public class SecondPage extends JFrame{
	private JPanel contentPane;
	private JButton btnBack;
	static PageAddMachine add_mac = new PageAddMachine();
	static PageAddAdjuster add_adj = new PageAddAdjuster();
	static PageEditMachine edit_mac = new PageEditMachine();
	static PageEditAdjuster edit_adj = new PageEditAdjuster();
	static PageDelMachine del_mac = new PageDelMachine();
	static PageDelAdjuster del_adj = new PageDelAdjuster();
	static ShowMachine show_mac = new ShowMachine();
	static ShowAdjuster show_adj = new ShowAdjuster();
	static Utilisation util = new Utilisation();
	static MacUtil machine_uti = new MacUtil();
	static AdjUtil adjuster_uti = new AdjUtil();
	static ThirdPage th_page = new ThirdPage();
	static FirstPage fi_page = new FirstPage();
	public SecondPage() {
		setBackground(new Color(204, 102, 204));
		
		setType(Type.POPUP);
		setTitle("Simulate");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(200, 10, 1000, 700);					
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(231, 76, 60));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAddMachine = new JButton("Add Machine");
		btnAddMachine.setBackground(new Color(102, 255, 153)); 
		btnAddMachine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				add_mac.reset();
				add_mac.setVisible(true);
			}
		});
		btnAddMachine.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAddMachine.setBounds(40, 30, 200, 40);
		contentPane.add(btnAddMachine);
		
		JButton btnAddAdjuster = new JButton("Add Adjuster");
		btnAddAdjuster.setBackground(new Color(102, 255, 153));
		btnAddAdjuster.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File file = new File("src/Machine_info.txt");
				if(!file.exists() || file.length()==0) {
					JOptionPane.showMessageDialog(null, "No machine in database, cant add adjuster","Error!",JOptionPane.ERROR_MESSAGE);
				}
				else {
				add_adj.getTextField().setText(null);
				add_adj.setVisible(true);
				add_adj.getSpinner_1().setValue(1);
				//int i;
				add_adj.getComboBox().removeAllItems();
				add_adj.getModel().removeAllElements();
				
				ArrayList<String> mach = new ArrayList<String>();
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
					add_adj.getComboBox().addItem(mach.get(i));
				}
				if(add_adj.getComboBox().getItemCount() == 1){
					add_adj.getBtnAddAnotherMachinetype().setEnabled(false);
				}
				else {
					add_adj.getBtnAddAnotherMachinetype().setEnabled(true);
				}
				//add_adj.setComboBox(mach);
				add_adj.setVisible(true);
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
				File file = new File("src/Machine_info.txt");
				if(!file.exists() || file.length()==0) {
					JOptionPane.showMessageDialog(null, "No machine in database, can't edit","Error!",JOptionPane.ERROR_MESSAGE);
				}
				else {
					
				edit_mac.getComboBox().removeAllItems();
				edit_mac.getModel().removeAllElements();
				edit_mac.getSpinner_1().setValue(1);
				
				ArrayList<String> mach = new ArrayList<String>();
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
				File file1 = new File("src/Machine_info.txt");
				File file = new File("src/Adjuster_info.txt");
				
				if (!file.exists() || file.length()==0) {
					JOptionPane.showMessageDialog(null, "No adjuster in database, can't edit","Error!",JOptionPane.ERROR_MESSAGE);
				}
				else {
					
				edit_adj.getComboBox().removeAllItems();
				edit_adj.getModel().removeAllElements();
				
				edit_adj.getSpinner_1().setValue(1);
				
				ArrayList<String> mach = new ArrayList<String>();
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
				File file = new File("src/Machine_info.txt");
				if(!file.exists() || file.length()==0) {
					JOptionPane.showMessageDialog(null, "No machine in database, can't delete","Error!",JOptionPane.ERROR_MESSAGE);
				}
				else {
					
				del_mac.getComboBox().removeAllItems();
				del_mac.getModel().removeAllElements();
				
				
				ArrayList<String> mach = new ArrayList<String>();
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
				File file1 = new File("src/Machine_info.txt");
				File file = new File("src/Adjuster_info.txt");
				
				if(!file.exists() || file.length()==0) {
					JOptionPane.showMessageDialog(null, "No adjuster in database, can't delete","Error!",JOptionPane.ERROR_MESSAGE);
				}
				else {
					
				del_adj.getComboBox().removeAllItems();
				del_adj.getModel().removeAllElements();
				//edit_mac.getSpinner_1().setValue(1);
				
				ArrayList<String> mach = new ArrayList<String>();
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
		
		JButton btnShowMachine = new JButton("Show Machine");
		btnShowMachine.setBackground(new Color(102, 255, 153));
		btnShowMachine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				File file1 = new File("src/Machine_info.txt");
				if(!file1.exists() || file1.length()==0) {
					JOptionPane.showMessageDialog(null, "No machine in database, can't show","Error!",JOptionPane.ERROR_MESSAGE);
				}
				else {
					
				show_mac.setVisible(true);
				File file = new File("src/Machine_info.txt");
				if(!file.exists()) {
					JOptionPane.showMessageDialog(null, "No machine uploaded","Error!",JOptionPane.ERROR_MESSAGE);
				}
				
				else
				{
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
				}
				}
				
			}
		});
		btnShowMachine.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnShowMachine.setBounds(40, 330, 200, 40);
		contentPane.add(btnShowMachine);
		
		show_mac.getBtnBack().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				show_mac.setVisible(false);
				show_mac.getModel().setRowCount(0);
				setVisible(true);
			}
		});
		
		JButton btnShowAdjuster = new JButton("Show Adjuster");
		btnShowAdjuster.setBackground(new Color(102, 255, 153));
		btnShowAdjuster.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				File file1 = new File("src/Machine_info.txt");
				File file = new File("src/Adjuster_info.txt");
		
				if(!file.exists() || file.length()==0) {
					JOptionPane.showMessageDialog(null, "No adjuster in database, can't show","Error!",JOptionPane.ERROR_MESSAGE);
				}
				else {
				
				show_adj.setVisible(true);
				
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
				}
				}
	
			}
		});
		btnShowAdjuster.setFont(new Font("Tahoma", Font.BOLD, 16));
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
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 430, 1000, 5);
		contentPane.add(separator);
		
		JLabel lblSimulationInYears = new JLabel("Simulation Time:");
		lblSimulationInYears.setForeground(new Color(0, 0, 102));
		lblSimulationInYears.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSimulationInYears.setBounds(60, 460, 330, 40);
		contentPane.add(lblSimulationInYears);
		
		JLabel Years = new JLabel("Years:");
		Years.setForeground(new Color(0, 0, 102));
		Years.setFont(new Font("Tahoma", Font.BOLD, 14));
		Years.setBounds(320, 458, 330, 40);
		contentPane.add(Years);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(400, 460, 250, 30);
		contentPane.add(spinner);
		spinner.setValue(1);
		
		JLabel lblextradays = new JLabel("Extra Days : ");
		lblextradays.setForeground(new Color(0, 0, 102));
		lblextradays.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblextradays.setBounds(720, 458, 250, 40);
		contentPane.add(lblextradays);
		
		
		JSpinner extra_days = new JSpinner();
		extra_days.setBounds(820, 460, 100, 30);
		contentPane.add(extra_days);
		extra_days.setValue(1);
		
		
		JButton btnSimulate = new JButton("Simulate");
		btnSimulate.setBackground(new Color(102, 255, 153));
		btnSimulate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if((Integer)spinner.getValue()>=0 && (Integer)spinner.getValue()<100 && (Integer)extra_days.getValue()>=0 && (Integer)extra_days.getValue()<365 && !((Integer)spinner.getValue()==0 && (Integer)extra_days.getValue()==0)) 
				{
				util.getModel().setRowCount(0);
				ArrayList<MachineType> mach = new ArrayList<MachineType>();
				ArrayList<AdjusterType> adj = new ArrayList<AdjusterType>();
				File file = new File("src/Machine_info_sim.txt");
				if(!file.exists()) {
					JOptionPane.showMessageDialog(null, "No machine uploaded","Error!",JOptionPane.ERROR_MESSAGE);
				}
				
				else
				{
				
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
		            
				}
				}
				File fil = new File("src/Adjuster_info_sim.txt");
				if(!fil.exists()) {
					JOptionPane.showMessageDialog(null, "No Adjuster uploaded","Error!",JOptionPane.ERROR_MESSAGE);
				}
				
				else
				{
				
				ArrayList<String> str = new ArrayList<String>();
				if(fil.exists()) {
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
						    	int k=0;int n=k;
						    	while(k<ss1.length()) {
						    		if(ss1.charAt(k)==',') {
						    			String l="";
						    			l=ss1.substring(n,k);
						    			q.add(l);
						    			n=k+1;
						    		}
						    		k++;
						    	}
						    	String mu="";
						    	mu=ss1.substring(n,ss1.length());
						    	q.add(mu);
						    	AdjusterType temp = new AdjusterType(ss,m,q);
						    	adj.add(temp);
						    	
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
				
				
				simulation(mach,adj,(Integer)spinner.getValue(),(Integer)extra_days.getValue(),util,machine_uti,adjuster_uti);
				util.setVisible(true);//,mac_uti,adj_uti,mac_util,adj_util);
				//siml.setVisible(true);
				//setVisible(false);
				File f1 = new File("src/Machine_info_sim.txt");
				if(f1.exists()) {
					f1.delete();
				}
				File g = new File("src/Adjuster_info_sim.txt");
				if(g.exists()) {
					g.delete();
				}
			}
			
				else if((Integer)spinner.getValue() < 0 ) {
					JOptionPane.showMessageDialog(null, "Time input of years cannot be negative.","Error!",JOptionPane.ERROR_MESSAGE);
					spinner.setValue(1);
				}
				else if((Integer)spinner.getValue() > 99 ) {
					JOptionPane.showMessageDialog(null, "Time input of years cannot exceed 100 years.","Error!",JOptionPane.ERROR_MESSAGE);
					spinner.setValue(1);
				}
				
				else if((Integer)extra_days.getValue() < 0 ) {
					JOptionPane.showMessageDialog(null, "Time input of days cannot be negative.","Error!",JOptionPane.ERROR_MESSAGE);
					extra_days.setValue(0);
				}
				
				else if((Integer)spinner.getValue() > 364  ) {
					JOptionPane.showMessageDialog(null, "Time input of days cannot exceed 364, convert to years","Error!",JOptionPane.ERROR_MESSAGE);
					extra_days.setValue(0);
				}
				
				else if((Integer)spinner.getValue()==0 && (Integer)extra_days.getValue()==0) {
					JOptionPane.showMessageDialog(null, "Simulation time has to be atleast 1 day","Error!",JOptionPane.ERROR_MESSAGE);
					extra_days.setValue(1);
				}
			}
		});
		
		
		btnSimulate.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSimulate.setBounds(375, 520, 250, 40);
		contentPane.add(btnSimulate);
		
		
		JButton btnSelSim = new JButton("Select Specification");
		btnSelSim.setBackground(new Color(102, 255, 153));
		btnSelSim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				th_page.setVisible(true);
			}
		});
		btnSelSim.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSelSim.setBounds(50, 520, 250, 40);
		contentPane.add(btnSelSim);
		
		util.getBtnBack().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				util.setVisible(false);
				util.getModel().setRowCount(0);
				adjuster_uti.getModel().setRowCount(0);
				machine_uti.getModel().setRowCount(0);
				
			}
		});
		
		util.getBtnAdjusterUtilisation().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				adjuster_uti.setVisible(true);
				
				util.setVisible(false);
			}
		});
		
		util.getBtnMachinewiseUtilisation().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				machine_uti.setVisible(true);
				util.setVisible(false);
			}
		});
		
		adjuster_uti.getBtnBack().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				adjuster_uti.setVisible(false);
				
				util.setVisible(true);
			}
		});
		
		machine_uti.getBtnBack().addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 		machine_uti.setVisible(false);
		 		
				util.setVisible(true);
		 	}
		 });
		
		btnBack = new JButton("Log out");
		btnBack.setForeground(new Color(255, 0, 0));
		btnBack.setBackground(new Color(102, 255, 153));
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				setVisible(false);
				fi_page.setVisible(true);
				
			}
		});
		btnBack.setBounds(800, 520, 150, 30);
		contentPane.add(btnBack);
		
		add_mac.getButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(add_mac.getTextField().getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "No machine name given","Error!",JOptionPane.ERROR_MESSAGE);
				}
				else if(add_mac.getTextField_1().getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "MTTF field left empty","Error!",JOptionPane.ERROR_MESSAGE);
				}
				else
				{
				int mttf_int=5;
				int check=0;int c=2;
				try{
					mttf_int=Integer.parseInt(add_mac.getTextField_1().getText());
				}
				catch(Exception enbf)
				{
					mttf_int=-2;c=0;
				}
				try{
					
					if(mttf_int<=0)
					{
						check=1;
						mttf_int=mttf_int/0;
						
					}
					if(mttf_int>1000)
					{
						check=11;
						mttf_int=mttf_int/0;
						
					}
					if((Integer)add_mac.getSpinner_1().getValue()<1)
					{
						check=2;
						mttf_int=mttf_int/0;
						
					}
					if((Integer)add_mac.getSpinner_1().getValue()>100)
					{
						check=21;
						mttf_int=mttf_int/0;
						
					}
					
					if((Integer)add_mac.getSpinner().getValue()<1)
					{
						check=3;
						mttf_int=mttf_int/0;
						
					}
					if((Integer)add_mac.getSpinner().getValue()>1000)
					{
						check=31;
						mttf_int=mttf_int/0;
						
					}
					
					//int i=0;
					File file = new File("src/Machine_info.txt");
					ArrayList<String> mach = new ArrayList<String>();
					if(file.exists()) {
						FileReader reader = new FileReader("src/Machine_info.txt");
			            BufferedReader bufferedReader = new BufferedReader(reader);
			            String line;
			            int i=0;
			            while ((line = bufferedReader.readLine()) != null) {
			                if(i%4==0) {
			                	mach.add(line);
			                }
			                
			                i++;
			            }
			            reader.close();
					}
					int k=1;
					for(int i=0; i<mach.size(); i++)
					{
						if(add_mac.getTextField().getText().equals(mach.get(i)))
						{
							check=4;k=0;
							mttf_int=mttf_int/0;
						}
					}
					if(k==1) {
						File f = new File("src/Machine_info.txt");
						FileWriter fr = new FileWriter(f, true);
						BufferedWriter br = new BufferedWriter(fr);
						br.write(add_mac.getTextField().getText());br.write("\n");
						br.write(add_mac.getTextField_1().getText());br.write("\n");
						br.write(String.valueOf(add_mac.getSpinner_1().getValue()));br.write("\n");
						br.write(String.valueOf(add_mac.getSpinner().getValue()));br.write("\n");
						br.close();
						fr.close();
					}
					add_mac.setVisible(false);
					btnAddAdjuster.setEnabled(true);
					
				}
				catch(Exception ef){
					if(check==1)
					{
						if(c!=0) {
						JOptionPane.showMessageDialog(null, "MTTF cannot be negative or zero","Error!",JOptionPane.ERROR_MESSAGE);
						add_mac.getTextField_1().setText(null);
						}
						else if(c==0) {
							JOptionPane.showMessageDialog(null, "MTTF can be an integer only","Error!",JOptionPane.ERROR_MESSAGE);
							add_mac.getTextField_1().setText(null);
						}
						check=0;
					}
					else if(check==11)
					{
						JOptionPane.showMessageDialog(null, "MTTF cannot be greater than 1000 days","Error!",JOptionPane.ERROR_MESSAGE);
						add_mac.getTextField_1().setText(null);
						check=0;
					}
					else if(check==2)
					{
						JOptionPane.showMessageDialog(null, "Repair Time cannot be negative or zero ","Error!",JOptionPane.ERROR_MESSAGE);
						add_mac.getSpinner_1().setValue(1);
						check=0;
					}
					else if(check==21)
					{
						JOptionPane.showMessageDialog(null, "Repair Time cannot be greater than 100 days ","Error!",JOptionPane.ERROR_MESSAGE);
						add_mac.getSpinner_1().setValue(1);
						check=0;
					}
					else if(check==3)
					{
						JOptionPane.showMessageDialog(null, "Quantity cannot be negative or zero ","Error!",JOptionPane.ERROR_MESSAGE);
						add_mac.getSpinner().setValue(1);
						check=0;
					}
					else if(check==31)
					{
						JOptionPane.showMessageDialog(null, "Quantity cannot be greater than 1000 ","Error!",JOptionPane.ERROR_MESSAGE);
						add_mac.getSpinner().setValue(1);
						check=0;
					}
					
					else if(check==4)
					{
						JOptionPane.showMessageDialog(null, "Machine with same name exists, try a different name.","Error!",JOptionPane.ERROR_MESSAGE);
						add_mac.getTextField().setText(null);
						check=0;
					}
					
				}
				
				}
			}
		});
		
		add_adj.getBtnAddAdjuster().addActionListener(new ActionListener() {
			int t;
			public void actionPerformed(ActionEvent arg0) {
				
				if(add_adj.getTextField().getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "No adjuster type given","Error!",JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					
					try{
						if((Integer)add_adj.getSpinner_1().getValue()<1)
						{
							t=2;
							t=t/0;
						}
						if((Integer)add_adj.getSpinner_1().getValue()>1000)
						{
							t=21;
							t=t/0;
						}
						add_adj.getModel().addElement(add_adj.getComboBox().getSelectedItem().toString());
						//JList <String> list = addaj.getTemp_machine_name();
						ArrayList <String> arl = new ArrayList <String> ();
						for(int i=0; i<add_adj.getModel().getSize(); i++)
						{
							arl.add(add_adj.getModel().getElementAt(i).toString());
						}
						String mact = add_adj.concat(arl);
						File file = new File("src/Adjuster_info.txt");
						ArrayList<String> mach = new ArrayList<String>();
						if(file.exists()) {
							FileReader reader = new FileReader("src/Adjuster_info.txt");
				            BufferedReader bufferedReader = new BufferedReader(reader);
				            String line;
				            int i=0;
				            while ((line = bufferedReader.readLine()) != null) {
				                if(i%3==0) {
				                	mach.add(line);
				                }
				                
				                i++;
				            }
				            reader.close();
						}
						int k=1;
						for(int i=0; i<mach.size(); i++)
						{
							if(add_adj.getTextField().getText().equals(mach.get(i)))
							{
								k=0;
								t=3;
								t=t/0;
								
							}
						}
						if(k==1) {
							File f = new File("src/Adjuster_info.txt");
							FileWriter fr = new FileWriter(f, true);
							BufferedWriter br = new BufferedWriter(fr);
							br.write(add_adj.getTextField().getText());br.write("\n");
							br.write(mact);br.write("\n");
							br.write(String.valueOf(add_adj.getSpinner_1().getValue()));br.write("\n");
							
							br.close();
							fr.close();
						}
						
						add_adj.setVisible(false);
						
					}
					catch(Exception p)
					{
						if (t==2) {
							JOptionPane.showMessageDialog(null, "Quantity cannot be negative or zero","Error!",JOptionPane.ERROR_MESSAGE);
							add_adj.getSpinner_1().setValue(1);
							t=0;
						}
						if (t==21) {
							JOptionPane.showMessageDialog(null, "Quantity cannot be greater than 1000","Error!",JOptionPane.ERROR_MESSAGE);
							add_adj.getSpinner_1().setValue(1);
							t=0;
						}
						if (t==3) {
							JOptionPane.showMessageDialog(null, "Adjuster with same name exists, try different ID","Error!",JOptionPane.ERROR_MESSAGE);
							add_adj.getTextField().setText("");
							t=0;
						}
					}
					
				}
			}
		});
		
		edit_mac.getButton().addActionListener(new ActionListener() {
			int editm_check=0;
			public void actionPerformed(ActionEvent arg0) {
				if(edit_mac.getModel().getSize()==1) {
				File file = new File("src/Machine_info.txt");
				
				if(!file.exists()) {
					JOptionPane.showMessageDialog(null, "No machine uploaded","Error!",JOptionPane.ERROR_MESSAGE);
				}
				
				else
				{
					
				editm_check=0;
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
		            if((Integer)edit_mac.getSpinner_1().getValue()>=1&&(Integer)edit_mac.getSpinner_1().getValue()<=1000) {
		            	file.delete();
		            }
				}
				if((Integer)edit_mac.getSpinner_1().getValue()>=1&&(Integer)edit_mac.getSpinner_1().getValue()<=1000)
				{
					
					String name = edit_mac.getModel().getElementAt(0).toString();
					
					int i=0;
					for(i=0;i<mach.size();i++) {
						if(mach.get(i).Get_name().equals(name)) {
							mach.get(i).Set_machine_no((Integer)edit_mac.getSpinner_1().getValue());
							
						}
						
					}
					File f = new File("src/Machine_info.txt");
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
				File file = new File("src/Adjuster_info.txt");
				
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
				File fil = new File("src/Adjuster_info.txt");
				if(fil.exists() && (Integer)edit_adj.getSpinner_1().getValue()>=1&&(Integer)edit_adj.getSpinner_1().getValue()<=1000) {
					fil.delete();
				}
				if((Integer)edit_adj.getSpinner_1().getValue()>=1&&(Integer)edit_adj.getSpinner_1().getValue()<=1000)
				{
					String name = edit_adj.getModel().getElementAt(0).toString();
					
					int i=0;
					for(i=0;i<mach.size();i++) {
						if(mach.get(i).Get_name().equals(name)) {
							mach.get(i).Set_Adjuster_no((Integer)edit_adj.getSpinner_1().getValue());	
						}
						
					}
					File f = new File("src/Adjuster_info.txt");
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
					
					JOptionPane.showMessageDialog(null, "Adjuster not chosen","Error!",JOptionPane.ERROR_MESSAGE);	
				}
			}
		});
		
		del_mac.getButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File file = new File("src/Machine_info.txt");
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
					File f = new File("src/Machine_info.txt");
					FileWriter fr = null;
					try {
						fr = new FileWriter(f, true);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					BufferedWriter br = new BufferedWriter(fr);
					for(i=0;i<mach.size();i++) {
						if(del[i]==1) 
						{
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
				File file = new File("src/Adjuster_info.txt");
				if(!file.exists()) {
					JOptionPane.showMessageDialog(null, "No Adjuster uploaded","Error!",JOptionPane.ERROR_MESSAGE);
				}
				
				else
				{
					del_adj.getModel().addElement(del_adj.getComboBox().getSelectedItem().toString());
					//JList <String> list = addaj.getTemp_machine_name();
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
		            //file.delete();
				}
				File fil = new File("src/Adjuster_info.txt");
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
				
					File f = new File("src/Adjuster_info.txt");
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
	
	
	
	public void simulation(ArrayList<MachineType> Mach, ArrayList<AdjusterType> Adj, int years, int days1, Utilisation util, MacUtil machine_uti, AdjUtil adjuster_uti) {//, float mac_uti, float adj_uti, ArrayList<Float> mac_util, ArrayList<Float> adj_util) {
		int i=0;
		int j=0,k=0;
		int mac_no=0,adj_no=0;
		
		ArrayList<Machine> machine = new ArrayList<Machine>();
		ArrayList<Adjuster> adjuster = new ArrayList<Adjuster>();
		for(i=0;i<Mach.size();i++) {
			for(j=0;j<Mach.get(i).Get_machine_no();j++) {
				Machine temp = new Machine(Mach.get(i).Get_name(),Mach.get(i).Get_MTTf(),Mach.get(i).Get_time_repir(),Mach.get(i).Get_machine_no());
				machine.add(temp);
				mac_no++;
			}
		}
		for(i=0;i<Adj.size();i++) {
			for(j=0;j<Adj.get(i).Get_Adjuster_no();j++) {
				Adjuster temp = new Adjuster(Adj.get(i).Get_name(),Adj.get(i).Get_Adjuster_no(),Adj.get(i).Get_repir_machine());
				adjuster.add(temp);
				adj_no++;
			}
		}
		int days=365*years + days1;
		for(i=0;i<mac_no;i++) {
			machine.get(i).Set_working_status(1);
			machine.get(i).Set_working_days(0);
			machine.get(i).Set_total_working_days(0);
			machine.get(i).Set_repairing_status(0);
			machine.get(i).Set_req_day(0);
		}
		for(k=0;k<adj_no;k++) {
			adjuster.get(k).Set_days_working(0);
			adjuster.get(k).Set_working_status(0);
			adjuster.get(k).Set_req_day(0);
		}
		for(i=0;i<days;i++) {
			ArrayList<Machine> qum = new ArrayList<Machine>();
			ArrayList<Adjuster> qua = new ArrayList<Adjuster>();
			for(j=0;j<mac_no;j++) {
				if(j<machine.size()) {
				int m=1;
				if(machine.get(j).Get_working_status()==1) {
					machine.get(j).Set_working_days(machine.get(j).Get_working_days()+1);
					machine.get(j).Set_total_working_days(machine.get(j).Get_total_working_days()+1);
					if(machine.get(j).Get_working_days()==machine.get(j).Get_MTTf()) {
						machine.get(j).Set_working_status(0);
						machine.get(j).Set_working_days(0);
					}
				}
				else {//if(machine[j].Get_working_status()==0) {
					if(machine.get(j).Get_repairing_status()==0) {
						for(k=0;k<adj_no;k++) {
							if(k<adjuster.size()) {
							if(adjuster.get(k).Get_working_status()==0) {
								if(adjuster.get(k).Get_repir_machine().contains(machine.get(j).Get_name())) {
									adjuster.get(k).Set_working_status(1);
									adjuster.get(k).Set_days_working(adjuster.get(k).Get_days_working()+1);
									adjuster.get(k).Set_req_day(machine.get(j).Get_time_repir()-1);
									if(adjuster.get(k).Get_req_day()==0) {
										adjuster.get(k).Set_working_status(0);
									}
									machine.get(j).Set_repairing_status(1);
									machine.get(j).Set_req_day(machine.get(j).Get_time_repir()-1);
									if(machine.get(j).Get_req_day()==0) {
										machine.get(j).Set_repairing_status(0);
										machine.get(j).Set_working_status(1);
									}
									Machine t=machine.get(j);
									Adjuster r = adjuster.get(k);
									machine.remove(j);
									qum.add(t);
									adjuster.remove(k);
									qua.add(r);
									j=j-1;
									m=0;
								}
							}
							if(m==0) {
								break;
							}
						}
						}
					}
					else {// if(machine[j].Get_repairing_status()==1) {
						machine.get(j).Set_req_day(machine.get(j).Get_req_day()-1);
						if(machine.get(j).Get_req_day()==0) {
							machine.get(j).Set_repairing_status(0);
							machine.get(j).Set_working_status(1);
						}
					}
				}
			}
			}
			for(j=0;j<adj_no;j++) {
				if(j<adjuster.size()) {
				if(adjuster.get(j).Get_working_status()==1) {
					//adjuster.get(j).Set_req_day(adjuster.get(j).Get_req_day()-1);
					//adjuster.get(j).Set_days_working(adjuster.get(j).Get_days_working()+1);
					if(adjuster.get(j).Get_req_day()==0) {
						adjuster.get(j).Set_working_status(0);
					}
					else {
						adjuster.get(j).Set_req_day(adjuster.get(j).Get_req_day()-1);
						adjuster.get(j).Set_days_working(adjuster.get(j).Get_days_working()+1);
					}
				}
			}
			}
			for(j=0;j<qum.size();j++) {
				machine.add(qum.get(j));
			}
			for(j=0;j<qua.size();j++) {
				adjuster.add(qua.get(j));
			}
		}
		float mac_uti=0,adj_uti=0;
		for(i=0;i<mac_no;i++) {
			mac_uti=(float) (mac_uti+(machine.get(i).Get_total_working_days())*1.0/days);
		}
		mac_uti=mac_uti/mac_no;
		mac_uti=mac_uti*100;
		for(i=0;i<adj_no;i++) {
			adj_uti=(float) (adj_uti+(adjuster.get(i).Get_days_working())*1.0/days);
		}
		adj_uti=adj_uti/adj_no;
		adj_uti=adj_uti*100;
		float[] mac_util = new float[100];
		float[] adj_util = new float[100];
		i=j=k=0;
		while(k<Mach.size()) {
			float a=0;
			for(i=j;i<j+Mach.get(k).Get_machine_no();i++) {
				a=(float) (a+(machine.get(i).Get_total_working_days())*1.0/days);				
			}
			a=a/Mach.get(k).Get_machine_no();
			a=a*100;
			mac_util[k]=a;
			
			j=j+Mach.get(k).Get_machine_no();
			k++;
		}
		i=j=k=0;
		while(k<Adj.size()) {
			float a=0;
			for(i=j;i<j+Adj.get(k).Get_Adjuster_no();i++) {
				a=(float) (a+(adjuster.get(i).Get_days_working())*1.0/days);				
			}
			a=a/Adj.get(k).Get_Adjuster_no();
			a=a*100;
			adj_util[k]=a;
			
			j=j+Adj.get(k).Get_Adjuster_no();
			k++;
		}
		
		Object[] p1 = {"Average Machine Utilisation",Float.toString(mac_uti)};
		util.getModel().addRow(p1);
		Object[] p2 = {"Average Adjuster Utilisation",Float.toString(adj_uti)};
		util.getModel().addRow(p2);
		for(i=0;i<Mach.size();i++) {
			Object[] r = {Mach.get(i).Get_name(),Float.toString(mac_util[i])};
			machine_uti.getModel().addRow(r);
		}
		for(i=0;i<Adj.size();i++) {
			Object[] r = {Adj.get(i).Get_name(),Float.toString(adj_util[i])};
			adjuster_uti.getModel().addRow(r);
		}
		
	}
}
