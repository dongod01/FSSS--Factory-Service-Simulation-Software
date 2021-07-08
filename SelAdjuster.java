import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
@SuppressWarnings("serial")
public class SelAdjuster extends JFrame {
	private JPanel contentPane;
	private JTextField textField;
	private JButton btnAddAdjuster;
	private JSpinner spinner_1;
	private JButton btnAddAnotherMachinetype;
	private JComboBox<String> comboBox;
	private JList <String> temp_machine_name;
	private DefaultListModel<String> model;
	private JButton button;
	
	public DefaultListModel<String> getModel() {
		return model;
	}
	public JButton getButton() {
		return btnAddAdjuster;
	}
	
	public JSpinner getSpinner_1() {
		return spinner_1;
	}
	
	public JList<String> getTemp_machine_name() {
		return temp_machine_name;
	}
	public JButton getBtnAddAnotherMachinetype() {
		return btnAddAnotherMachinetype;
	}
	
	/**
	 * Create the frame.
	 */
	public SelAdjuster() {
		
		setTitle("Select Adjuster");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 319);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(58, 224, 200));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMachineType = new JLabel("Adjuster Name :");
		lblMachineType.setForeground(new Color(0, 0, 102));
		lblMachineType.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMachineType.setBounds(21, 70, 119, 24);
		contentPane.add(lblMachineType);
		
		comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("Tahoma", Font.ITALIC, 14));
		comboBox.setBounds(184, 70, 138, 24);
		contentPane.add(comboBox);
		
		model = new DefaultListModel<String>();
		temp_machine_name = new JList <String>(model);
		
		btnAddAnotherMachinetype = new JButton("Select Another Adjuster");
		btnAddAnotherMachinetype.setForeground(new Color(0, 0, 102));
		btnAddAnotherMachinetype.setBackground(new Color(102, 255, 153));
		btnAddAnotherMachinetype.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				model.addElement(comboBox.getSelectedItem().toString());
				
				comboBox.removeItemAt(comboBox.getSelectedIndex());
				if(comboBox.getItemCount() <= 1){
					btnAddAnotherMachinetype.setEnabled(false);
				}
			}
		});
		btnAddAnotherMachinetype.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnAddAnotherMachinetype.setBounds(146, 119, 222, 30);
		contentPane.add(btnAddAnotherMachinetype);
		
		btnAddAdjuster = new JButton("Select Adjuster");
		btnAddAdjuster.setForeground(new Color(0, 0, 102));
		btnAddAdjuster.setBackground(new Color(102, 255, 153));
		btnAddAdjuster.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAddAdjuster.setBounds(103, 236, 138, 33);
		contentPane.add(btnAddAdjuster);
		
		
		button = new JButton("Cancel");
		button.setForeground(Color.RED);
		button.setFont(new Font("Tahoma", Font.BOLD, 14));
		button.setBackground(new Color(102, 255, 153));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		button.setBounds(301, 236, 89, 33);
		contentPane.add(button);
	}
	public JComboBox<String> getComboBox() {
		return comboBox;
	}
	public void setComboBox(JComboBox<String> comboBox) {
		this.comboBox = comboBox;
	}
	public JTextField getTextField() {
		return textField;
	}
	public void setTextField(JTextField textField) {
		this.textField = textField;
	}
	
	public static String concat(ArrayList<String> array) {
	    StringBuilder builder = new StringBuilder("");
	    for (int i = 0; i < array.size(); i++) {
	    	String s = array.get(i);
	    	if(i == array.size() - 1) {
	    		builder.append(s);
	    	}
	    	else
	    		builder.append(s).append(',');
	    }
	    return builder.toString();
	}
	
	public static String concat_int(ArrayList<Integer> array) {
	    StringBuilder builder = new StringBuilder("");
	    for (int i = 0; i < array.size(); i++) {
	    	Integer s = array.get(i);
	    	if(i == array.size() - 1) {
	    		builder.append(s);
	    	}
	    	else
	    		builder.append(s).append(',');
	    }
	    return builder.toString();
	}
}