import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.FlowLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JTextField;

public class StudentInfo extends JFrame {

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	int ID;
	String Nationality;
	String profilePicPath="/ProfilePIc.jpeg";
	
	public StudentInfo(String firstName, String lastName,String position,UniData uni) {
		setBounds(100, 100, 816, 417);
		setResizable(false);
		getContentPane().setLayout(null);
		
		if(position.equals("Dean")) {
			ID=uni.deanRecord.get(0).Id;
			Nationality=uni.deanRecord.get(0).country;
		}
		else if(position.equals("Faculty")&& uni.facultyRecord.size()>0) {
			for(int i =0; i<uni.facultyRecord.size();i++) {
				if(uni.facultyRecord.get(i).firstName.equals(firstName) &&
				   uni.facultyRecord.get(i).lastName.equals(lastName)) {
					this.ID=uni.facultyRecord.get(i).Id;
					this.Nationality=uni.facultyRecord.get(i).country;
					
				}
			}
		}
		else if(position.equals("Student") && uni.stuRecord.size()>0) {
			for(int i =0; i<uni.stuRecord.size();i++) {
				if(uni.stuRecord.get(i).firstName.equals(firstName) &&
				   uni.stuRecord.get(i).lastName.equals(lastName)) {
					this.ID=uni.stuRecord.get(i).Id;
					this.Nationality=uni.stuRecord.get(i).country;
					
				}
			}
		}
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(26, 11, 300, 258);
		getContentPane().add(lblNewLabel);
		Image profilePic = new ImageIcon(this.getClass().getResource(profilePicPath)).getImage();
		lblNewLabel.setIcon(new ImageIcon(profilePic));
		
		JPanel panel = new JPanel();
		panel.setBounds(474, 25, 316, 266);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("First Name");
		lblNewLabel_1_1.setBounds(31, 31, 78, 20);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 15));
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Last Name");
		lblNewLabel_1_1_1.setBounds(31, 82, 78, 20);
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 15));
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Position");
		lblNewLabel_1_1_2.setBounds(31, 133, 78, 20);
		lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 15));
		panel.add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Nationality");
		lblNewLabel_1_1_3.setBounds(31, 184, 78, 20);
		lblNewLabel_1_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_3.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 15));
		panel.add(lblNewLabel_1_1_3);
		
		JLabel lblNewLabel_1_1_4 = new JLabel("ID");
		lblNewLabel_1_1_4.setBounds(31, 235, 78, 20);
		lblNewLabel_1_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_4.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 15));
		panel.add(lblNewLabel_1_1_4);
		
		JLabel lblFirstName = new JLabel(firstName);
		lblFirstName.setHorizontalAlignment(SwingConstants.CENTER);
		lblFirstName.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 15));
		lblFirstName.setBounds(170, 31, 78, 20);
		panel.add(lblFirstName);
		
		JLabel lblLastName = new JLabel(lastName);
		lblLastName.setHorizontalAlignment(SwingConstants.CENTER);
		lblLastName.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 15));
		lblLastName.setBounds(170, 82, 78, 20);
		panel.add(lblLastName);
		
		JLabel lblPosition = new JLabel(position);
		lblPosition.setHorizontalAlignment(SwingConstants.CENTER);
		lblPosition.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 15));
		lblPosition.setBounds(170, 133, 78, 20);
		panel.add(lblPosition);
		
		JLabel lblNaitionality = new JLabel(Nationality);
		lblNaitionality.setHorizontalAlignment(SwingConstants.CENTER);
		lblNaitionality.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 15));
		lblNaitionality.setBounds(170, 184, 78, 20);
		panel.add(lblNaitionality);
		
		JLabel lblId = new JLabel(""+ID);
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 15));
		lblId.setBounds(170, 235, 78, 20);
		panel.add(lblId);
		
		
		
		
		
		
	}
}
