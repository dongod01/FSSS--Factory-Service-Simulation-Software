public class ServiceManager {
	private String User_Id;
	private String Password;
	public String getUser_Id() {
		return User_Id;
	}
	public String getPassword() {
		return Password;
	}
	public void setUser_Id(String Id) {
		this.User_Id=Id;
	}
	public void setPassword(String password) {
		this.Password = password;
	}
	
	public Boolean checkvalidpassword() {
		int i;
		Boolean Capital = false, small= false, numbool = false;
		for(i=0;i<Password.length();i++) {
			int x1 = Password.charAt(i), x2 = Password.charAt(i), x3 = Password.charAt(i);
			if(x1>='A' && x1<='Z') Capital = true;
			if(x2>='a' && x2<='z') small = true;
			if(x1>='0' && x1<='9') numbool = true;
			
		}
		return (Capital && small && numbool); 
	}
	public ServiceManager(String Id,String password) {
		User_Id = Id;
		Password = password;
	}
	
}
