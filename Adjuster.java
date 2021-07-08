import java.util.ArrayList;
public class Adjuster extends AdjusterType{
	private String Id;
	private ArrayList<String> Repair_machine;
	private int Working_status;
	private int req_day;
	private int Days_working;
	public Adjuster(String name_, int no, ArrayList<String> machine_name) {
		super(name_, no, machine_name);
	}
	public void Set_id(String s) {
		this.Id=s;
	}
	public String Get_id() {
		return Id;
	}
	public void Add_repair_machine(String ss) {
		this.Repair_machine.add(ss);
	}
	public void Set_working_status(int n) {
		this.Working_status=n;
	}
	public int Get_working_status() {
		return Working_status;
	}
	public void Set_days_working(int n) {
		this.Days_working=n;
	}
	public int Get_days_working() {
		return Days_working;
	}
	public void Set_req_day(int days) {
		this.req_day = days;
	}
	public int Get_req_day() {
		return req_day;
	}
}
