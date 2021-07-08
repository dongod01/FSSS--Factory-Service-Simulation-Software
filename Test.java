import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

//import javax.swing.JOptionPane;
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter the test case file path:");
		Scanner scanner = new Scanner(System. in);
        String f = scanner. nextLine();
        scanner.close();
		File file = new File(f);
		if(!file.exists()) {
			//JOptionPane.showMessageDialog(null, "No machine uploaded","ERROR",JOptionPane.ERROR_MESSAGE);
			System.out.println("No file found.");
		}
		/*if(add_mac.getTextField().getText().equals(""))
		{
			JOptionPane.showMessageDialog(null, "Enter the machine ID","ERROR",JOptionPane.ERROR_MESSAGE);
		}*/
		else
		{
		//ArrayList<MachineType> mach = new ArrayList<MachineType>();
		if(file.exists()) {
			FileReader reader = null;
			try {
				reader = new FileReader(f);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            //MachineType temp = new MachineType();
            int i=0;int m=0;
            try {
            	String s="";
            	String ss="";//Test Case
            	String ss1="";//MachineType
            	String ss2="";//AdjusterType
            	String ss3="";//Machine
            	String ss4="";//Adjuster
            	String ss5="";//ServiceManager
				while ((line = bufferedReader.readLine()) != null) {
					//System.out.println(line);System.out.println(line.length());
					//s=line.substring(0,line.length());
					//System.out.println(s);
				    ss=line;
				    if(ss.length()>9) {
				    	s=ss.substring(0,9);
				    	if(s.equals("Test Case")) {
				    		m++;
				    		String li;i=0;
				    		li = bufferedReader.readLine();
				    		if(li.length()==12) {
				    			ss1=li.substring(0,11);
				    			//System.out.println(ss1);
				    		}
				    		else if(li.length()==13) {
				    			ss2=li.substring(0,12);
				    			//System.out.println(ss2);
				    		}
				    		else if(li.length()==15) {
				    			ss5=li.substring(0,14);
				    			//System.out.println(ss5);
				    		}
				    		else if(li.length()==8) {
				    			ss3=li.substring(0,7);
				    			//System.out.println(ss3);
				    		}
				    		else if(li.length()==9) {
				    			ss4=li.substring(0,8);
				    			//System.out.println(ss4);
				    		}
				    		if(ss1.equals("MachineType")) {
				    			//int k=1;
				    			int w=0,x=0,y=0;i=0;
					    		while ((li = bufferedReader.readLine()) != null) {
					    			//System.out.println(li);
					    			if(i%4==0) {
								    	s=li;
								    	ss=s.substring(0, s.length());
								    	//s=s.split("\\n");
								    }
								    if(i%4==1) {
								    	w=Integer.parseInt(li);
								    }
								    if(i%4==2) {
								    	x=Integer.parseInt(li);
								    }
								    if(i%4==3) {
								    	y=Integer.parseInt(li);
								    	MachineType temp = new MachineType(ss,w,x,y);
								    	if(temp.Get_name().equals(ss) && temp.Get_MTTf()==w && w>=1 && w<=1000 && temp.Get_time_repir()==x && x <=100 && x>0 &&temp.Get_machine_no()==y && y<=1000 && y>0) {
								    		System.out.println("Test Case "+m+":");
								    		System.out.println("Passed succesfully.");
								    	}
								    	else {
								    		System.out.println("Test Case "+m+"\nFailed due to:");
								    		if(!(temp.Get_MTTf()==w)) {
								    			System.out.println("     MTTF not passed  ");
								    		}
								    		if(!(temp.Get_time_repir()==x)) {
								    			System.out.println("     Repair time not passed  ");
								    		}
								    		if(!(temp.Get_machine_no()==y)) {
								    			System.out.println("     Machine quaitity not passed  ");
								    		}
								    		if(temp.Get_MTTf()==w && temp.Get_time_repir()==x && temp.Get_machine_no()==y) {
								    			if(w<=0) System.out.println("     MTTF can't be zero or negative!");
								    			if(w>1000) System.out.println("     MTTF can't be greater than 1000! ");
								    			if(x<=0) System.out.println("     Repair time can't be zero or negative!");
								    			if(x>100) System.out.println("     Repair time can't be greater than 50 days!");
								    			if(y<=0) System.out.println("     Machine quantity can't be zero or negative!");
								    			if(y>1000) System.out.println("     Machine quantity can't be greater than 1000!");
								    			
								    		}
								    		
								    	}
								    	//mach.add(temp);
								    	//Object[] op = {temp.Get_name(),temp.Get_MTTf(),temp.Get_time_repir(),temp.Get_machine_no()};
								    	//show_mac.getModel().addRow(op);
								    }
								    if(i==3) {
								    	break;
								    }
								    i++;
					    		}
					    		ss1="";
				    		}
				    		if(ss2.equals("AdjusterType")) {
				    			//int k=1;
				    			//System.out.println("Inside AdjusterType");
				    			int w=0;
				    			String q="",qq="";i=0;
					    		while ((li = bufferedReader.readLine()) != null) {
					    			//System.out.println(li);
					    			if(i%3==0) {
								    	s=li;
								    	ss=s.substring(0, s.length());
								    	//s=s.split("\\n");
								    }
								    if(i%3==1) {
								    	//m=Integer.parseInt(line);
								    	
								    	q=li;
								    	qq=q.substring(0,q.length());
								    	//str.add(ss1);
								    }
								    if(i%3==2) {
								    	w=Integer.parseInt(li);//Quantity
								    	ArrayList<String> z = new ArrayList<String>();
								    	int k=0;int n=k;
								    	while(k<qq.length()) {
								    		if(qq.charAt(k)==',') {
								    			String l="";
								    			l=qq.substring(n,k);
								    			z.add(l);
								    			n=k+1;
								    		}
								    		k++;
								    	}
								    	String mu="";
								    	mu=qq.substring(n,qq.length());
								    	z.add(mu);
								    	AdjusterType temp = new AdjusterType(ss,w,z);
								    	if(temp.Get_name().equals(ss)&&temp.Get_Adjuster_no()==w && w>0 && w<=1000 && temp.Get_repir_machine()==z) {
								    		System.out.println("Test Case "+m+":");
								    		System.out.println("Passed succesfully.");
								    	}
								    	
								    	else {
								    		System.out.println("Test Case "+m+"\nFailed due to:");
								    		if(!(temp.Get_Adjuster_no()==w)) {
								    			System.out.println("     Adjuster quantity not passed  ");
								    		}
								    		if(!(temp.Get_repir_machine()==z)) {
								    			System.out.println("     Repair machines not passed  ");
								    		}
								    		if(!(temp.Get_name()==ss)) {
								    			System.out.println("     AdjusterType name not passed  ");
								    		}
								    		if(temp.Get_Adjuster_no()==w && temp.Get_repir_machine()==z && temp.Get_name()==ss) {
								    			
								    			if(w<=0) System.out.println("     Adjuster quantity can't be zero or negative!");
								    			if(w>1000) System.out.println("     Adjuster quantity can't be greater than 1000!");
								    			
								    		}
								    		
								    	}
								    	//List<String> str = Arrays.asList(ss1.split(",",-1));
								    }
								    /*if(i%4==3) {
								    	o=Integer.parseInt(line);
								    	MachineType temp = new MachineType(ss,m,n,o);
								    	mach.add(temp);
								    }*/
								    if(i==2) {
								    	break;
								    }
								    i++;
					    		}
					    		ss2="";
				    		}
					    		if(ss3.equals("Machine")) {
					    			//int k=1;
					    			//System.out.println("Machine");
					    			int w1=0,x1=0,y1=0;i=0;
						    		while ((li = bufferedReader.readLine()) != null) {
						    			//System.out.println(li);
						    			if(i%4==0) {
									    	s=li;
									    	ss=s.substring(0, s.length());
									    	//s=s.split("\\n");
									    }
									    if(i%4==1) {
									    	w1=Integer.parseInt(li);
									    }
									    if(i%4==2) {
									    	x1=Integer.parseInt(li);
									    }
									    if(i%4==3) {
									    	y1=Integer.parseInt(li);
									    	Machine temp = new Machine(ss,w1,x1,y1);
									    	if(temp.Get_name().equals(ss) && temp.Get_MTTf()==w1 && w1>=1 && w1<=1000 && temp.Get_time_repir()==x1 && x1 <=100 && x1>0 &&temp.Get_machine_no()==y1 && y1<=1000 && y1>0) {
									    		System.out.println("Test Case "+m+":");
									    		System.out.println("Passed succesfully.");
									    	}
									    	
									    	else {
									    		System.out.println("Test Case "+m+"\nFailed due to:");
									    		if(!(temp.Get_MTTf()==w1)) {
									    			System.out.println("     MTTF not passed  ");
									    		}
									    		if(!(temp.Get_time_repir()==x1)) {
									    			System.out.println("     Repair time not passed  ");
									    		}
									    		if(!(temp.Get_machine_no()==y1)) {
									    			System.out.println("     Machine quantity not passed  ");
									    		}
									    		if(temp.Get_MTTf()==w1 && temp.Get_time_repir()==x1 && temp.Get_machine_no()==y1) {
									    			if(w1<=0) System.out.println("     MTTF can't be zero or negative!   ");
									    			if(w1>1000) System.out.println("     MTTF can't be greater than 1000!   ");
									    			if(x1<=0) System.out.println("     Repair time can't be zero or negative!   ");
									    			if(x1>100) System.out.println("     Repair time can't be greater than 50 days!   ");
									    			if(y1<=0) System.out.println("     Machine quantity can't be zero or negative!   ");
									    			if(y1>1000) System.out.println("     Machine quantity can't be greater than 1000!   ");
									    			
									    		}
									    		
									    	}
									    	
									    	//mach.add(temp);
									    	//Object[] op = {temp.Get_name(),temp.Get_MTTf(),temp.Get_time_repir(),temp.Get_machine_no()};
									    	//show_mac.getModel().addRow(op);
									    }
									    if(i==3) {
									    	break;
									    }
									    i++;
						    		}
						    		ss3="";
					    		}
					    		if(ss4.equals("Adjuster")) {
					    			//System.out.println("Adjuster");
					    			//int k=1;
					    			int w1=0;i=0;
					    			String q1="",qq1="";
						    		while ((li = bufferedReader.readLine()) != null) {
						    			//System.out.println(li);
						    			if(i%3==0) {
									    	s=li;
									    	ss=s.substring(0, s.length());
									    	//s=s.split("\\n");
									    }
									    if(i%3==1) {
									    	//m=Integer.parseInt(line);
									    	q1=li;
									    	qq1=q1.substring(0,q1.length());
									    	//str.add(ss1);
									    }
									    if(i%3==2) {
									    	w1=Integer.parseInt(li);
									    	ArrayList<String> z = new ArrayList<String>();
									    	int k=0;int n=k;
									    	while(k<qq1.length()) {
									    		if(qq1.charAt(k)==',') {
									    			String l="";
									    			l=qq1.substring(n,k);
									    			z.add(l);
									    			n=k+1;
									    		}
									    		k++;
									    	}
									    	String mu="";
									    	mu=qq1.substring(n,qq1.length());
									    	z.add(mu);
									    	Adjuster temp = new Adjuster(ss,w1,z);
									    	if(temp.Get_name().equals(ss)&&temp.Get_Adjuster_no()==w1 && w1>0 && w1<=1000 && temp.Get_repir_machine()==z) {
									    		System.out.println("Test Case "+m+":");
									    		System.out.println("Passed succesfully.");
									    		
									    	}
									    	
									    	else {
									    		System.out.println("Test Case "+m+"\nFailed due to:");
									    		if(!(temp.Get_Adjuster_no()==w1)) {
									    			System.out.println("     Adjuster quantity not passed  ");
									    		}
									    		if(!(temp.Get_repir_machine()==z)) {
									    			System.out.println("     Repair machines not passed  ");
									    		}
									    		if(!(temp.Get_name()==ss)) {
									    			System.out.println("     AdjusterType name not passed  ");
									    		}
									    		if(temp.Get_Adjuster_no()==w1 && temp.Get_repir_machine()==z && temp.Get_name()==ss) {
									    			
									    			if(w1<=0) System.out.println("     Adjuster quantity can't be zero or negative!   ");
									    			if(w1>1000) System.out.println("     Adjuster quantity can't be greater than 1000!   ");
									    			
									    		}
									    		
									    	}
									    	
									    	//List<String> str = Arrays.asList(ss1.split(",",-1));
									    }
									    /*if(i%4==3) {
									    	o=Integer.parseInt(line);
									    	MachineType temp = new MachineType(ss,m,n,o);
									    	mach.add(temp);
									    }*/
									    if(i==2) {
									    	break;
									    }
									    i++;
						    		}
						    		ss4="";
					    		}
					    		if(ss5.equals("ServiceManager")) {
					    			
					    			//System.out.println("Manager");
					    			String e1="";
					    			String e2="";i=0;
					    			while ((li = bufferedReader.readLine()) != null) {
					    				//System.out.println(li);
					    				if(i%2==0) {
					    					s=li;
									    	e1=s.substring(0, s.length());
					    				}
					    				if(i%2==1) {
					    					s=li;
									    	e2=s.substring(0, s.length());
									    	ServiceManager temp = new ServiceManager(e1,e2);
									    	System.out.println("Test Case "+m+":");
									    	if(temp.getUser_Id().equals(e1)&&temp.getPassword().equals(e2)&&checkString(temp.getPassword())) {
									    		//System.out.println("Test Case "+m+":");
									    		System.out.println("Passed succesfully.");
									    	}
									    	else {
									    		System.out.println("Failed due to:");
									    		if(!(temp.getUser_Id()==e1)) {
									    			System.out.println("     Username not passed  ");
									    		}
									    		else if(!(temp.getPassword()==e2)) {
									    			System.out.println("     Password not passed  ");
									    		}
									    		else if(!checkString(temp.getPassword())) {
									    			System.out.println("     Password Criteria not passed  ");
									    		}
									    		//System.out.println("Test Case "+m+"\nFailed due to unknown reasons.");
									    	}
					    				}
					    				if(i==1) {
					    					break;
					    				}
					    				i++;
					    			}
					    			ss5="";
					    		}
				    		
				    	}
				    }

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
	public static boolean checkString(String str) {
	    char ch;
	    boolean capitalFlag = false;
	    boolean lowerCaseFlag = false;
	    boolean numberFlag = false;
	    for(int i=0;i < str.length();i++) {
	        ch = str.charAt(i);
	        if( Character.isDigit(ch)) {
	            numberFlag = true;
	        }
	        else if (Character.isUpperCase(ch)) {
	            capitalFlag = true;
	        } else if (Character.isLowerCase(ch)) {
	            lowerCaseFlag = true;
	        }
	        if(numberFlag && capitalFlag && lowerCaseFlag)
	            return true;
	    }
	    return false;
	}
}
