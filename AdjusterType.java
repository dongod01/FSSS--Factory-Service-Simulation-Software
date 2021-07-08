import java.util.ArrayList;
public class AdjusterType {
	protected String Name;
	protected int Adjuster_no;
	protected ArrayList<String> Repair_machine;
	public String Get_name() {
		return Name;
	}
	public int Get_Adjuster_no() {
		return Adjuster_no;
	}
	public ArrayList<String> Get_repir_machine(){
		return Repair_machine;
	}
	public void Set_name(String name_) {
		this.Name = name_;
	}
	public void Set_Adjuster_no(int no) {
		this.Adjuster_no = no;
	}
	public void Add_repair_machine(String machine) {
		this.Repair_machine.add(machine);
	}
	public AdjusterType(String name_, int no, ArrayList<String> machine_name) {
		Name = name_;
		Adjuster_no = no;
		Repair_machine = machine_name;
	}
}
