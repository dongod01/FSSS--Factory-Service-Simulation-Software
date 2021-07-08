
public class Machine extends MachineType{
	private String Id;
	private int Working_status;
	private int Repairing_status;
	private int Working_days;
	private int Total_working_days;
	private int req_day;
	public Machine(String name, int mttf, int time_repair, int no_machine) {
		super(name, mttf, time_repair, no_machine);
		// TODO Auto-generated constructor stub
	}
	public void Set_id(String id) {
		this.Id=id;
	}
	public String Get_id() {
		return Id;
	}
	public void Set_working_status(int st) {
		this.Working_status= st;
	}
	public int Get_working_status() {
		return Working_status;
	}
	public void Set_repairing_status(int st) {
		this.Repairing_status = st;
	}
	public int Get_repairing_status() {
		return Repairing_status;
	}
	public void Set_working_days(int st) {
		this.Working_days = st;
	}
	public int Get_working_days() {
		return Working_days;
	}
	public void Set_total_working_days(int st) {
		this.Total_working_days = st;
	}
	public int Get_total_working_days() {
		return Total_working_days;
	}
	public void Set_req_day(int days) {
		this.req_day=days;
	}
	public int Get_req_day() {
		return req_day;
	}
}
