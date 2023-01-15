import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class home extends JFrame {

	private JPanel contentPane;
	
	UniData uni = new UniData();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					home frame = new home();
					frame.setVisible(true);
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public home() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 816, 417);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblStats = new JLabel("STATS");
		lblStats.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 20));
		lblStats.setBounds(159, 121, 71, 59);
		contentPane.add(lblStats);
		
		JLabel lblNewLabel_1 = new JLabel("Position");
		lblNewLabel_1.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 12));
		lblNewLabel_1.setBounds(79, 189, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nmbr of members");
		lblNewLabel_1_1.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(135, 191, 103, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Max numbr");
		lblNewLabel_1_2.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 12));
		lblNewLabel_1_2.setBounds(264, 190, 71, 14);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Dean");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 14));
		lblNewLabel_1_3.setBounds(79, 214, 46, 14);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Faculty");
		lblNewLabel_1_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3_1.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 14));
		lblNewLabel_1_3_1.setBounds(79, 245, 61, 19);
		contentPane.add(lblNewLabel_1_3_1);
		
		JLabel lblNewLabel_1_3_1_1 = new JLabel("Students");
		lblNewLabel_1_3_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3_1_1.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 14));
		lblNewLabel_1_3_1_1.setBounds(79, 275, 61, 14);
		contentPane.add(lblNewLabel_1_3_1_1);
		
		JLabel DnbrM = new JLabel("0");
		DnbrM.setHorizontalAlignment(SwingConstants.CENTER);
		DnbrM.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 14));
		DnbrM.setBounds(171, 214, 46, 14);
		contentPane.add(DnbrM);
		
		JLabel FnbrM = new JLabel("0");
		FnbrM.setHorizontalAlignment(SwingConstants.CENTER);
		FnbrM.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 14));
		FnbrM.setBounds(171, 249, 46, 14);
		contentPane.add(FnbrM);
		
		JLabel SnbrM = new JLabel("0");
		SnbrM.setHorizontalAlignment(SwingConstants.CENTER);
		SnbrM.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 14));
		SnbrM.setBounds(171, 277, 46, 14);
		contentPane.add(SnbrM);
		
		JLabel DmaxNbr = new JLabel("1");
		DmaxNbr.setHorizontalAlignment(SwingConstants.CENTER);
		DmaxNbr.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 14));
		DmaxNbr.setBounds(274, 215, 46, 14);
		contentPane.add(DmaxNbr);
		
		JLabel FmxNbr = new JLabel("5");
		FmxNbr.setHorizontalAlignment(SwingConstants.CENTER);
		FmxNbr.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 14));
		FmxNbr.setBounds(274, 249, 46, 14);
		contentPane.add(FmxNbr);
		
		JLabel SmaxNbr = new JLabel("100");
		SmaxNbr.setHorizontalAlignment(SwingConstants.CENTER);
		SmaxNbr.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 14));
		SmaxNbr.setBounds(274, 277, 46, 14);
		contentPane.add(SmaxNbr);
		
		Button addPerson = new Button("Add Person");
		addPerson.setBackground(SystemColor.controlShadow);
		addPerson.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*int D = Integer.parseInt(DnbrM.getText());
				D++;
				DnbrM.setText(""+D);
				*/
				
				AddPerson ap = new AddPerson(uni);
				ap.setVisible(true);
				
			}
		});
		addPerson.setBounds(620, 98, 140, 52);
		contentPane.add(addPerson);
		
		Button btnRefresh = new Button("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SnbrM.setText(""+uni.getNumOfStudent());
				FnbrM.setText(""+uni.getNumOfFaculty());
				DnbrM.setText(""+uni.deanRecord.size());
			}
		});
		btnRefresh.setBackground(SystemColor.controlShadow);
		btnRefresh.setBounds(620, 200, 140, 52);
		contentPane.add(btnRefresh);
		
		Button btnListMember = new Button("List of Members");
		btnListMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List lst = new List(uni);
				lst.setVisible(true);
				
			}
		});
		btnListMember.setBackground(SystemColor.controlShadow);
		btnListMember.setBounds(620, 290, 140, 52);
		contentPane.add(btnListMember);
		
		JLabel lblUniversityBuilder = new JLabel("University Builder");
		lblUniversityBuilder.setHorizontalAlignment(SwingConstants.CENTER);
		lblUniversityBuilder.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 30));
		lblUniversityBuilder.setBounds(0, 11, 800, 40);
		contentPane.add(lblUniversityBuilder);
	}
}
