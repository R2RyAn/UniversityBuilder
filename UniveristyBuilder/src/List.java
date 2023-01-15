import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToggleButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.Font;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Dimension;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class List extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public List(UniData uni) {
		setBounds(100, 100, 816, 417);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setShowGrid(false);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int index = table.getSelectedRow();
					TableModel model = table.getModel();
					String position = (String) model.getValueAt(index, 0);
					String firstName = (String) model.getValueAt(index, 1);
					String lastName = (String) model.getValueAt(index, 2);
					StudentInfo student = new StudentInfo(firstName,lastName, position,uni);
					student.setVisible(true);
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null,
						    "No data to select",
						    "No data error",
						    JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		table.setOpaque(false);
		table.setRowHeight(25);
		table.setAutoCreateRowSorter(true);
		table.setForeground(SystemColor.textText);
		table.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Position", "First Name", "Last Name", "Country"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.setBounds(57, 107, 671, 260);
		contentPane.add(table);
		
		JLabel lblNewLabel_1 = new JLabel("Poisition");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 15));
		lblNewLabel_1.setBounds(32, 74, 103, 22);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("First Name");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(193, 74, 103, 22);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Last Name");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(367, 74, 103, 22);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Country");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 15));
		lblNewLabel_1_3.setBounds(531, 74, 103, 22);
		contentPane.add(lblNewLabel_1_3);
		
		JButton btnUpList = new JButton("Update List");
		btnUpList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (new DefaultTableModel(
						new String[][] {
						},
						new String[] {
							"Position", "First Name", "Last Name", "Country"
						}
					) {
						Class[] columnTypes = new Class[] {
							String.class, String.class, String.class, String.class
						};
						public Class getColumnClass(int columnIndex) {
							return columnTypes[columnIndex];
						}
					});
				if(uni.deanRecord.size()>0) {
					model.addRow(new String[] { "Dean",uni.deanRecord.get(0).firstName,uni.deanRecord.get(0).lastName,uni.deanRecord.get(0).country});
				}
				if(uni.facultyRecord.size()>0) {
					for(int i =0;i<uni.facultyRecord.size();i++) {
						model.addRow(new String[] { "Faculty",uni.facultyRecord.get(i).firstName,uni.facultyRecord.get(i).lastName,uni.facultyRecord.get(i).country});
					}
				}
				if(uni.stuRecord.size()>0) {
					for(int i =0;i<uni.stuRecord.size();i++) {
						model.addRow(new String[] { "Student",uni.stuRecord.get(i).firstName,uni.stuRecord.get(i).lastName,uni.stuRecord.get(i).country});
					}
				}
				table.setModel(model);
			}
		});
		btnUpList.setBounds(690, 42, 89, 54);
		contentPane.add(btnUpList);
		
		JLabel lblUniversityMember = new JLabel("University Members");
		lblUniversityMember.setHorizontalAlignment(SwingConstants.CENTER);
		lblUniversityMember.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 30));
		lblUniversityMember.setBounds(0, 11, 800, 40);
		contentPane.add(lblUniversityMember);
	}
}
