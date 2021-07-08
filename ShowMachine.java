import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

@SuppressWarnings("serial")
public class ShowMachine extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel model;
	private JButton btnBack;
	

	public JButton getBtnBack() {
		return btnBack;
	}

	public void setBtnBack(JButton btnBack) {
		this.btnBack = btnBack;
	}

	/**
	 * Create the frame.
	 */
	public ShowMachine() {
		setTitle("Machine List");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 502, 375);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(58, 224, 200));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 466, 219);
		contentPane.add(scrollPane);
		
		
		table = new JTable();
		scrollPane.setViewportView(table);
		model = (new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Machine Type", "MTTF(Days)", "Repair Time", "Quantity"
			}
		) {
			Class<?>[] columnTypes = new Class[] {
				String.class, Integer.class, Integer.class, Integer.class
			};
			public Class<?> getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.setModel(model);
		table.setFont(new Font("Tahoma", Font.PLAIN, 13));
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(400, 10, 466, 219);
		contentPane.add(scrollPane_1);
		
		 btnBack = new JButton("Back");
		 btnBack.setForeground(new Color(255, 0, 0));
		 btnBack.setBackground(new Color(102, 255, 153));
	
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnBack.setBounds(200, 300, 89, 25);
		contentPane.add(btnBack);
		
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public DefaultTableModel getModel() {
		return model;
	}

	public void setModel(DefaultTableModel model) {
		this.model = model;
	}
}