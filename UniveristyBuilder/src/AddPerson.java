import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.Canvas;
import java.awt.Button;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class AddPerson extends JFrame {

	private JPanel contentPane;
	private JTextField tfFirstName;
	private JTextField tfLastName;
	private JTextField tfCountry;
	UniData uni;
	String filePath;
	boolean flagImage = false;
	

	/**
	 * Create the frame.
	 */
	public AddPerson(UniData uni) {
		this.uni=uni;
		setBounds(100, 100, 816, 417);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add Person");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 11, 800, 40);
		lblNewLabel.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 30));
		contentPane.add(lblNewLabel);
		
		JComboBox posSelect = new JComboBox();
		posSelect.setFont(new Font("Tahoma", Font.PLAIN, 17));
		posSelect.setModel(new DefaultComboBoxModel(new String[] {"Dean", "Faculty", "Student"}));
		posSelect.setBounds(105, 130, 117, 41);
		contentPane.add(posSelect);
		
		tfFirstName = new JTextField();
		tfFirstName.setBounds(269, 133, 103, 40);
		contentPane.add(tfFirstName);
		tfFirstName.setColumns(10);
		
		tfLastName = new JTextField();
		tfLastName.setColumns(10);
		tfLastName.setBounds(402, 130, 107, 40);
		contentPane.add(tfLastName);
		
		tfCountry = new JTextField();
		tfCountry.setColumns(10);
		tfCountry.setBounds(540, 130, 103, 40);
		contentPane.add(tfCountry);
		
		JLabel lblNewLabel_1 = new JLabel("First Name");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 15));
		lblNewLabel_1.setBounds(259, 101, 103, 22);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Last Name");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(402, 101, 103, 22);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Country");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(540, 101, 103, 22);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lbConfirmation = new JLabel("");
		lbConfirmation.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 21));
		lbConfirmation.setHorizontalAlignment(SwingConstants.CENTER);
		lbConfirmation.setBounds(175, 309, 419, 40);
		contentPane.add(lbConfirmation);
		
		Button btnAddImage = new Button("Add Image");
		btnAddImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser fileChooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter(
						"IMAGES","jpg","jpeg","png");
				fileChooser.setFileFilter(filter);
				int response = fileChooser.showOpenDialog(null);
				if(response == JFileChooser.APPROVE_OPTION) {
					File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
					filePath =fileChooser.getSelectedFile().getAbsolutePath();
					flagImage =true;
					
					
				}
				
			}
		});
		btnAddImage.setFont(new Font("Dialog", Font.BOLD, 17));
		btnAddImage.setBackground(SystemColor.controlShadow);
		btnAddImage.setBounds(661, 130, 129, 41);
		contentPane.add(btnAddImage);
		
		Button btnAdd = new Button("Add");
		btnAdd.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				boolean flag = true;
				home hm = new home();
				if(posSelect.getSelectedItem()=="Dean") {
					if(uni.deanRecord.size()<1) {
						Dean dn = new Dean(tfFirstName.getText(),tfLastName.getText(),tfCountry.getText());
						uni.deanRecord.add(dn);
						
						lbConfirmation.setText("Added "+tfFirstName.getText() +" "+tfLastName.getText());
					}
					else{
						lbConfirmation.setText("Max Number Of Deans Admitted");
					}
					
				}
				else if(posSelect.getSelectedItem()=="Faculty") {
					for(int i =0; i<uni.facultyRecord.size();i++) {
						if(uni.facultyRecord.get(i).firstName.equals(tfFirstName.getText()) &&
						   uni.facultyRecord.get(i).lastName.equals(tfLastName.getText())) {
							lbConfirmation.setText("Person Already Exists");
							flag = false;
							break;
						}
					}
					if(flag == true && uni.facultyRecord.size()<=4) {
						Faculty fac = new Faculty(tfFirstName.getText(),tfLastName.getText(),tfCountry.getText());
						uni.facultyRecord.add(fac);
						lbConfirmation.setText("Added "+tfFirstName.getText() +" "+tfLastName.getText());
						if(flagImage == true) {
							for(int i =0;i<uni.facultyRecord.size();i++) {
								if(uni.facultyRecord.get(i).firstName.equals(tfFirstName) 
								&& uni.facultyRecord.get(i).lastName.equals(tfLastName)) {
									uni.facultyRecord.get(i).profilePic = filePath;
								}
							}
						}
						
					}
					else if(uni.facultyRecord.size()>=5) {
						lbConfirmation.setText("Max Number Of Faculty Admitted");
					}
				}
				
				
				else if(posSelect.getSelectedItem()=="Student") {
					for(int i =0; i<uni.stuRecord.size();i++) {
						if(uni.stuRecord.get(i).firstName.equals(tfFirstName.getText()) &&
						   uni.stuRecord.get(i).lastName.equals(tfLastName.getText())) {
							lbConfirmation.setText("Person Already Exists");
							flag = false;
							break;
						}
					}
					if(flag == true && uni.stuRecord.size()<=99) {
						Student stu = new Student(tfFirstName.getText(),tfLastName.getText(),tfCountry.getText());
						uni.stuRecord.add(stu);
						lbConfirmation.setText("Added "+tfFirstName.getText() +" "+tfLastName.getText());
						if(flagImage == true) {
							for(int i =0;i<uni.stuRecord.size();i++) {
								if(uni.stuRecord.get(i).firstName.equals(tfFirstName) 
								&& uni.stuRecord.get(i).lastName.equals(tfLastName)) {
									uni.stuRecord.get(i).profilePic = filePath;
								}
							}
						}
						
					}
					else if(uni.stuRecord.size()>=100) {
						lbConfirmation.setText("Max Number Of Students Admitted");
					}
					
					
				}
				
				
				
			}
		});
		btnAdd.setBackground(SystemColor.controlShadow);
		btnAdd.setFont(new Font("Dialog", Font.BOLD, 17));
		btnAdd.setBounds(175, 225, 165, 54);
		contentPane.add(btnAdd);
		
		Button btnClear = new Button("Clear");
		btnClear.setFont(new Font("Dialog", Font.BOLD, 17));
		btnClear.setBackground(SystemColor.controlShadow);
		btnClear.setBounds(429, 225, 165, 54);
		contentPane.add(btnClear);
		
		
		
		
		
		
	}
}


