import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class AdjUtil extends JFrame {

	private JPanel contentPane;
	private JTable table;
	public JTable getTable() {
		return table;
	}
	public void setTable(JTable table) {
		this.table = table;
	}
	private DefaultTableModel model;
	public DefaultTableModel getModel() {
		return model;
	}
	public void setModel(DefaultTableModel model) {
		this.model = model;
	}
	private JButton btnBack ;
	private JButton btnDetails;
	public JButton getBtnDetails() {
		return btnDetails;
	}
	public void setBtnDetails(JButton btnDetails) {
		this.btnDetails = btnDetails;
	}
	public JButton getBtnBack() {
		return btnBack;
	}

	public void setBtnBack(JButton btnBack) {
		this.btnBack = btnBack;
	}

	/**
	 * Create the frame.
	 */
	public AdjUtil() {
		setTitle("Individual Adjuster Utilisation");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(236, 189, 58));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 414, 174);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		model=(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Adjuster", "Percentage Utilization"
			}
		) {
			Class<?>[] columnTypes = new Class<?>[] {
				String.class, String.class
			};
			public Class<?> getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.setModel(model);
		btnBack = new JButton("Back");
		btnBack.setForeground(new Color(255, 0, 0));
		btnBack.setBackground(new Color(102, 255, 153));
		
		
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBack.setBounds(292, 210, 89, 30);
		contentPane.add(btnBack);
		
		

	}
}