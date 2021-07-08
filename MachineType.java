
public class MachineType {
	protected String Name;
	protected int MTTF;
	protected int Time_for_repairing;
	protected int No_of_machine;
	public MachineType(String name, int mttf, int time_repair, int no_machine) {
		Name=name;
		MTTF=mttf;
		Time_for_repairing=time_repair;
		No_of_machine=no_machine;
	}
	public void Set_name(String name) {
		this.Name=name;
	}
	public void Set_MTTF(int mttf) {
		this.MTTF=mttf;
	}
	public void Set_time_repair(int time_repair) {
		this.Time_for_repairing=time_repair;
	}
	public void Set_machine_no(int no_machine) {
		this.No_of_machine=no_machine;
	}
	public String Get_name() {
		return Name;
	}
	public int Get_MTTf() {
		return MTTF;
	}
	public int Get_time_repir() {
		return Time_for_repairing;
	}
	public int Get_machine_no() {
		return No_of_machine;
	}
}
