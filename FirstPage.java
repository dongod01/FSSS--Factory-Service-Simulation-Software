import java.awt.EventQueue;
//import java.awt.Image;
//import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JSeparator;
import javax.swing.JOptionPane;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.*;
@SuppressWarnings("serial")
public class FirstPage extends JFrame{
	private JPanel panel;
	static ServiceManager serviceManager;
	private JTextField text_signup_id;
	private JTextField text_signin_id;
	private JPasswordField text_signup_password;
	private JPasswordField text_signup_cpassword;
	private JPasswordField text_signin_password;
	static SecondPage sp = new SecondPage();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FirstPage frame = new FirstPage();
					frame.setVisible(true);
					//
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private static boolean checkPasswordStrength(JPasswordField pwd) {
	      boolean upcase=false,lwcase=false,numcase=false;
	      @SuppressWarnings("deprecation")
		String x = pwd.getText();
	      int i=0;
	      if(x.length()<3) return false;
	      for(;i<x.length();i++) {
	    	  if(x.charAt(i)>='A'&&x.charAt(i)<='Z') upcase=true;
	    	  else if(x.charAt(i)>='a'&&x.charAt(i)<='z') lwcase=true;
	    	  else if(x.charAt(i)>='0'&&x.charAt(i)<='9') numcase=true;
	      }
	      
	      return (upcase && lwcase && numcase);
	   }
	
	public FirstPage() {
		//Login page
		
		setTitle("FACTORY SERVICE SIMULATION SOFTWARE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 600, 600);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(new Color(54, 169, 161));
		setContentPane(panel);
		panel.setLayout(null);
		
		//Header
		
		JLabel st = new JLabel("Service Manager Sign-up");
		st.setForeground(new Color(120, 30, 30));
		st.setFont(new Font("Tahoma", Font.BOLD, 18));
		st.setBounds(50, 10, 300, 24);
		panel.add(st);
		
		//Username
		
		JLabel signup_id= new JLabel("Enter user id : ");
		signup_id.setForeground(new Color(0, 0, 102));
		signup_id.setFont(new Font("Tahoma", Font.BOLD, 14));
		signup_id.setBounds(50, 60, 200, 24);
		panel.add(signup_id);
		
		text_signup_id = new JTextField();
		text_signup_id.setBounds(250, 60, 200, 24);
		panel.add(text_signup_id);
		text_signup_id.setColumns(10);
		
		
		//Enter Password
		
		JLabel signup_password= new JLabel("Enter password : ");
		signup_password.setForeground(new Color(0, 0, 102));
		signup_password.setFont(new Font("Tahoma", Font.BOLD, 14));
		signup_password.setBounds(50, 100, 200, 24);
		panel.add(signup_password);
		
		text_signup_password = new JPasswordField();
		text_signup_password.setEchoChar('@');
		text_signup_password.setBounds(250, 100, 200, 24);
		panel.add(text_signup_password);
		text_signup_password.setColumns(10);
		
		//Confirm Password
		
		JLabel signup_cpassword= new JLabel("Confirm password : ");
		signup_cpassword.setForeground(new Color(0, 0, 102));
		signup_cpassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		signup_cpassword.setBounds(50, 140, 200, 24);
		panel.add(signup_cpassword);
		
		text_signup_cpassword = new JPasswordField();
		text_signup_cpassword.setEchoChar('@');
		text_signup_cpassword.setBounds(250, 140, 200, 24);
		panel.add(text_signup_cpassword);
		text_signup_cpassword.setColumns(10);
		
		JButton btnConfigure = new JButton("Sign-Up");
		btnConfigure.setBackground(new Color(62,169, 54));
		btnConfigure.setFont(new Font("Calibri", Font.BOLD, 19));
		btnConfigure.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				//Error handling for empty fields
				if(text_signup_id.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Enter the user ID","ERROR",JOptionPane.ERROR_MESSAGE);
				}
				else if(text_signup_password.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Enter password field is empty","ERROR",JOptionPane.ERROR_MESSAGE);
				}
				else if(text_signup_cpassword.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Confirm password field is empty","ERROR",JOptionPane.ERROR_MESSAGE);
				}
				else if(!text_signup_password.getText().equals(text_signup_cpassword.getText())) {
					JOptionPane.showMessageDialog(null, "Confirm the password correctly","ERROR",JOptionPane.ERROR_MESSAGE);
					
					text_signup_password.setText(null);
					text_signup_cpassword.setText(null);
				}
				else if(! (checkPasswordStrength(text_signup_password)) ) {
					//Password strength check
					JOptionPane.showMessageDialog(null, "Password must contain uppercase, lowercase and numerical each.","ERROR",JOptionPane.ERROR_MESSAGE);
				}
				else {
					//No error in creating account, previous data is deleted and new files are created.
					serviceManager = new ServiceManager(text_signup_id.getText(),text_signup_password.getText());
					File file = new File("src/Login_info.txt");
					if(file.exists()) {
						file.delete();
					}
					File f = new File("src/Machine_info.txt");
					if(f.exists()) {
						f.delete();
					}
					File g = new File("src/Adjuster_info.txt");
					if(g.exists()) {
						g.delete();
					}
					try {
			            FileWriter writer = new FileWriter("src/Login_info.txt", true);
			            writer.write(serviceManager.getUser_Id());
			            writer.write("\n");   // write new line
			            writer.write(serviceManager.getPassword());
			            writer.close();
			        } catch (IOException e) {
			            e.printStackTrace();
			        }
					text_signup_id.setText(null);
					text_signup_password.setText(null);
					text_signup_cpassword.setText(null);
				}
				//setVisible(false);
			}
		});
		btnConfigure.setBounds(75, 180, 200, 50);
		panel.add(btnConfigure);
		
		//Separator
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 250, 500, 7);
		panel.add(separator);
		
		//Header
		
		JLabel st1 = new JLabel("Service Manager Login");
		st1.setForeground(new Color(120, 30, 30));
		st1.setFont(new Font("Tahoma", Font.BOLD, 18));
		st1.setBounds(50, 265, 300, 24);
		panel.add(st1);
		
		//Sign In UserID
		
		JLabel signin_id= new JLabel("Enter user id : ");
		signin_id.setForeground(new Color(0, 0, 102));
		signin_id.setFont(new Font("Tahoma", Font.BOLD, 14));
		signin_id.setBounds(50, 305, 200, 24);
		panel.add(signin_id);
		
		text_signin_id = new JTextField();
		text_signin_id.setBounds(250, 305, 200, 24);
		panel.add(text_signin_id);
		text_signin_id.setColumns(10);
		
		//Sign In Password
		
		JLabel signin_password= new JLabel("Enter password : ");
		signin_password.setForeground(new Color(0, 0, 102));
		signin_password.setFont(new Font("Tahoma", Font.BOLD, 14));
		signin_password.setBounds(50, 345, 200, 24);
		panel.add(signin_password);
		
		text_signin_password = new JPasswordField();
    	text_signin_password.setEchoChar('@');
		text_signin_password.setBounds(250, 345, 200, 24);
		panel.add(text_signin_password);
		text_signin_password.setColumns(10);
		
		//Show Password checkbox
		
		JCheckBox mark_show_pwd = new JCheckBox("Show Password");  
        mark_show_pwd.setBounds(350,470,200,50);
        panel.add(mark_show_pwd);
        
        mark_show_pwd.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                JCheckBox cb = (JCheckBox) e.getSource();
                if ( ! (cb.isSelected()) ) {
                	text_signup_password.setEchoChar('@');
                	text_signup_cpassword.setEchoChar('@');
                	text_signin_password.setEchoChar('@');
                } else {
                	text_signup_password.setEchoChar((char)0);
                	text_signup_cpassword.setEchoChar((char)0);
                	text_signin_password.setEchoChar((char)0);
                }
            }
        });
        
        //Login button
		
		JButton login = new JButton("Login");
		login.setBackground(new Color(62,169,54));
		login.setFont(new Font("Calibri", Font.BOLD, 19));
		login.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				
				try {
		            FileReader reader = new FileReader("src/Login_info.txt");
		            BufferedReader bufferedReader = new BufferedReader(reader);
		 
		            String line;String id="";String pass="";
		            int i=0;
		            while ((line = bufferedReader.readLine()) != null) {
		                if(i==0) {
		                	id=line;
		                }
		                if(i==1) {
		                	pass=line;
		                }
		                i++;
		            }
		            reader.close();
		            //Handling empty fields
		            if(text_signin_id.getText().equals("")) {
		            	JOptionPane.showMessageDialog(null, "Enter the user ID","ERROR",JOptionPane.ERROR_MESSAGE);
		            }
		            else if(text_signin_password.getText().equals("")) {
		            	JOptionPane.showMessageDialog(null, "Enter the password","ERROR",JOptionPane.ERROR_MESSAGE);
		            }
		            else if(id=="" && pass=="") {
		            	JOptionPane.showMessageDialog(null, "Create an account first!","ERROR",JOptionPane.ERROR_MESSAGE);
		            	text_signin_id.setText(null);
						text_signin_password.setText(null);
		            }
		            else if((!text_signin_id.getText().equals(id))) {
		            	JOptionPane.showMessageDialog(null, "No such user present in database","ERROR",JOptionPane.ERROR_MESSAGE);
						text_signin_id.setText(null);
						text_signin_password.setText(null);
		            }
		            else if((!text_signin_password.getText().equals(pass))) {
		            	JOptionPane.showMessageDialog(null, "Enter correct credentials","ERROR",JOptionPane.ERROR_MESSAGE);
						text_signin_password.setText(null);
		            }
		            else {
		            	//Logged in succesfully, closing login page and opening homepage 
		            	text_signin_id.setText(null);
						text_signin_password.setText(null);
		            	sp.setVisible(true);
		            	setVisible(false);
		            }
		 
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
				File f = new File("src/Machine_info_sim.txt");
				if(f.exists()) {
					f.delete();
				}
				File g = new File("src/Adjuster_info_sim.txt");
				if(g.exists()) {
					g.delete();
				}
			}
		});
		login.setBounds(75, 405, 200, 50);
		panel.add(login);
	}
}
