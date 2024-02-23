import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class CoWinRegistrationGUI extends JFrame implements ActionListener
{
       private JLabel lblAdharCardNo, lblBirthYear, lblMobileNo, lblAgeGroup,lblHospital,lblVaccine, lblTimeSlot;
       private JTextField txtAdharCardNo, txtBirthYear, txtMobileNo;
       private JRadioButton rdoAgeGroup18, rdoAgeGroup45;
       private JComboBox<String> cboHospital;
       private JRadioButton rdoVaccineCovieshield, rdoVaccineCovaxin, rdoVaccineSputnik;
       private JRadioButton rdoTimeSlotMorning, rdoTimeSlotAfternoon, rdoTimeSlotEvening;
       private JButton btnAdd, btnUpdate, btnDelete, btnView, btnSearch;
       private JPanel panel;
       private ButtonGroup grpVaccine, grpTimeSlot,grpAgeGroup;
       private Connection conn;
       private PreparedStatement pstmt;
       private ResultSet rs;
       private Statement stmt;
       
       public CoWinRegistrationGUI()
       {
              initializeDB();
              lblAdharCardNo = new JLabel("Adhar Card No : ");
              lblBirthYear = new JLabel("Mobile No : ");
              lblAgeGroup = new JLabel("Age Group : ");
              lblHospital = new JLabel("Select Hospital : ");
              lblVaccine = new JLabel("Select Vaccine: ");
              lblTimeSlot = new JLabel("Select Time Slot : ");
              txtAdharCardNo = new JTextField();
              txtBirthYear = new JTextField();
              txtMobileNo = new JTextField();
              rdoAgeGroup18 = new JRadioButton("18 & Above");
              rdoAgeGroup45 = new JRadioButton("45 & Above");
              ButtonGroup grpAgeGroup = new ButtonGroup();
              grpAgeGroup.add(rdoAgeGroup18);
              grpAgeGroup.add(rdoAgeGroup45);
              
              String[] hospitals = {"Tulsai Hospital","City Hospital","Sainath Hospital","Jupiter Hospital","Apollo"};
              cboHospital = new JComboBox<>(hospitals);
              
              rdoVaccineCovieshield = new JRadioButton("Covishield");
              rdoVaccineCovaxin = new JRadioButton("Covaxin");
              rdoVaccineSputnik = new JRadioButton("Sputnik V");
              
              ButtonGroup grpVaccine = new ButtonGroup();
              grpVaccine.add(rdoVaccineCovieshield);
              grpVaccine.add(rdoVaccineCovaxin);
              grpVaccine.add(rdoVaccineSputnik);
              
              rdoTimeSlotMorning = new JRadioButton("Morning");
              rdoTimeSlotAfternoon = new JRadioButton("Afternoon");
              rdoTimeSlotEvening = new JRadioButton("Evening");
              
              ButtonGroup grpTimeSlot = new ButtonGroup();
              
              grpTimeSlot.add(rdoTimeSlotMorning);
              grpTimeSlot.add(rdoTimeSlotAfternoon);
              grpTimeSlot.add(rdoTimeSlotEvening);
              
              btnAdd = new JButton("Add");
              btnUpdate = new JButton("Update");
              btnDelete = new JButton("Delete");
              btnView = new JButton("View");
              btnSearch = new JButton("Search");
              
              JPanel panel = new JPanel(new GridLayout(15,10,10,10));
              panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
              
              panel.add(lblAdharCardNo);
              panel.add(txtAdharCardNo);
              panel.add(lblBirthYear);
              panel.add(txtBirthYear);
              panel.add(lblMobileNo);
              panel.add(txtMobileNo);
              panel.add(rdoAgeGroup18);
              panel.add(new JLabel());
              panel.add(rdoAgeGroup45);
              panel.add(lblHospital);
              panel.add(cboHospital);
              panel.add(lblVaccine);
              panel.add(rdoVaccineCovieshield);
              panel.add(new JLabel());
              panel.add(rdoVaccineCovaxin);
              panel.add(new JLabel());
              panel.add(rdoVaccineSputnik);
              panel.add(lblTimeSlot);
              panel.add(rdoTimeSlotMorning);
              panel.add(new JLabel());
              panel.add(rdoTimeSlotAfternoon);
              panel.add(new JLabel());
              panel.add(rdoTimeSlotEvening);
              panel.add(new JLabel());
              panel.add(btnAdd);
              panel.add(btnUpdate);
              panel.add(btnDelete);
              panel.add(btnView);
              panel.add(btnSearch);
              
              add(panel);
              
              btnAdd.addActionListener(this);
              btnUpdate.addActionListener(this);
              btnDelete.addActionListener(this);
              btnView.addActionListener(this);
              btnSearch.addActionListener(this);
              
             try
              {
                   conn = DriverManager.getConnection("jdbc:postgresql://192.168.1.254/exam27","exam27","exam27");
              }
              catch (SQLException ex)
              {
                     ex.printStackTrace();
              }
              setTitle("Co-Win Registrations");
              setSize(600,600);
              setLocationRelativeTo(null);
              setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
              setVisible(true);
              
       }
       public void actionPerformed(ActionEvent e)
       {
              if (e.getSource()==btnAdd)
              {
                  addRegistration();
              }
              else if (e.getSource()==btnUpdate)
              {
                  updateRegistration();
              }
              else if (e.getSource()==btnDelete)
              {
                  deleteRegistration();
              }
              else if (e.getSource()==btnView)
              {
                  viewRegistrations();
              }
              else if (e.getSource()==btnSearch)
              {
                  searchRegistration();
              }
       }
       private void addRegistration()
       {
               try
               {
                    String adharCardNo = txtAdharCardNo.getText();
                    int birthYear = Integer.parseInt(txtBirthYear.getText());
                    String mobileNo = txtMobileNo.getText();
                    String ageGroup = rdoAgeGroup18.isSelected() ? "18 & Above" : "45 & Above";
                    String hospital = cboHospital.getSelectedItem().toString();
                    String vaccine = rdoVaccineCovieshield.isSelected() ? "Covishield" : (rdoVaccineCovaxin.isSelected()? "Covaxin" : "Sputnik V");
                    String timeSlot = rdoTimeSlotMorning.isSelected()?"Morning" : (rdoTimeSlotAfternoon.isSelected()?"Afternoon" : "Evening");
                    pstmt = conn.prepareStatement("INSERT INTO registrations (adhar_card_no,birth_year,mobile_no,age_group,hospital,vaccine,time_slot)VALUES (?,?,?,?,?,?,?)");
                    pstmt.setString(1,adharCardNo);
                    pstmt.setInt(2,birthYear);
                    pstmt.setString(3,mobileNo);
                    pstmt.setString(4,ageGroup);
                    pstmt.setString(5,hospital);
                    pstmt.setString(6,vaccine);
                    pstmt.setString(1,timeSlot);
                    pstmt.executeUpdate();
                    
                    JOptionPane.showMessageDialog(this,"Registration added successfully!");
               }
               catch (NumberFormatException | SQLException ex)
               {
                      JOptionPane.showMessageDialog(this,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
               }
               clearFields();
       }
       private void updateRegistration()
       {
               try
               {
                    String adharCardNo = txtAdharCardNo.getText();
                    int birthYear = Integer.parseInt(txtBirthYear.getText());
                    String mobileNo = txtMobileNo.getText();
                    String ageGroup = rdoAgeGroup18.isSelected() ? "18 & Above" : "45 & Above";
                    String hospital = cboHospital.getSelectedItem().toString();
                    String vaccine = rdoVaccineCovieshield.isSelected() ? "Covishield" : (rdoVaccineCovaxin.isSelected()? "Covaxin" : "Sputnik V");
                    String timeSlot = rdoTimeSlotMorning.isSelected()?"Morning" : (rdoTimeSlotAfternoon.isSelected()?"Afternoon" : "Evening");
                    pstmt = conn.prepareStatement("UPDATE registrations SET birth_year=?,mobile_no=?,age_group=?,hospital=?,vaccine=?,time_slot=? WHERE adhar_card_no=?");
                    pstmt.setInt(1,birthYear);
                    pstmt.setString(2,mobileNo);
                    pstmt.setString(3,ageGroup);
                    pstmt.setString(4,hospital);
                    pstmt.setString(5,vaccine);
                    pstmt.setString(6,timeSlot);
                    pstmt.setString(7,adharCardNo);
                    int rowsAffected = pstmt.executeUpdate();
                    if (rowsAffected==0)
                    {
                        JOptionPane.showMessageDialog(this,"No registration found with Adhar Card No : "+ adharCardNo,"Error",JOptionPane.ERROR_MESSAGE);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(this,"Registration Updated successfully!");
                    }
                    
               }
               catch (NumberFormatException |SQLException ex)
               {
                     JOptionPane.showMessageDialog(this,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
               }
               clearFields();
       }
       
       private void deleteRegistration()
       {
               try
               {
                    String adharCardNo = txtAdharCardNo.getText();
                    pstmt = conn.prepareStatement("DELETE FROM registrations WHERE adhar_card_no=?");
                    pstmt.setString(1,adharCardNo);
                    int rowsAffected = pstmt.executeUpdate();
                    if (rowsAffected==0)
                    {
                        JOptionPane.showMessageDialog(this,"No registration found with Adhar Card No : "+ adharCardNo,"Error",JOptionPane.ERROR_MESSAGE);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(this,"Registration Deleted successfully!");
                    }
               }
               catch (NumberFormatException |SQLException ex)
               {
                     JOptionPane.showMessageDialog(this,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
               }
               clearFields();
       }
       
       private void viewRegistrations()
       {
               try 
               {
                   pstmt = conn.prepareStatement("SELECT * FROM registrations");
                   rs = pstmt.executeQuery();
                   StringBuilder sb = new StringBuilder();
                   sb.append(String.format("%-15s%-15s%-15s%-15s%-30s%-15s%-15s%\n","AdharCardNo","BirthYear","MobileNo","AgeGroup","Hospital","Vaccine","TimeSlot"));
                   sb.append("------------------------------------------------------------------------\n");
                   while (rs.next())
                   {
                          sb.append(String.format("%-15s%-15d%-15s%-15s%-30s%-15s%-15s%\n",rs.getString("adhar_card_no"),rs.getInt("birth_year"),rs.getString("mobile_no"),rs.getString("age_group"),rs.getString("hospital"),rs.getString("vaccine"),rs.getString("time_slot")));
                   }
                   JOptionPane.showMessageDialog(this,new JScrollPane(new JTextArea(sb.toString())),"Registrations",JOptionPane.PLAIN_MESSAGE);
               }
               catch (SQLException ex)
               {
                      JOptionPane.showMessageDialog(this,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
               }
       }
       
       private void searchRegistration()
       {
               try
               {
                   String adharCardNo = txtAdharCardNo.getText();
                   pstmt.setString(1,adharCardNo);
                   rs = pstmt.executeQuery();
                   
                   if (rs.next())
                   {
                       String ageGroup = rs.getString("age_group");
                       if (ageGroup.equals("18 & Above"))
                       {
                           rdoAgeGroup18.setSelected(true);
                       }
                       else
                       {
                           rdoAgeGroup45.setSelected(true);
                       }
                       cboHospital.setSelectedItem(rs.getString("hospital"));
                       String vaccine = rs.getString("vaccine");
                       if (vaccine.equals("Covishield"))
                       {
                           rdoVaccineCovieshield.setSelected(true);
                       }
                       else if (vaccine.equals("Covaxin"))
                       {
                                rdoVaccineCovaxin.setSelected(true);
                       }
                       else
                       {
                            rdoVaccineSputnik.setSelected(true);
                       }
                       String timeSlot = rs.getString("time_slot");
                       if (timeSlot.equals("Morning"))
                       {
                           rdoTimeSlotMorning.setSelected(true);
                       }
                       else if (timeSlot.equals("Afternoon"))
                       {
                           rdoTimeSlotAfternoon.setSelected(true);
                       }
                       else
                       {
                           rdoTimeSlotEvening.setSelected(true);
                       }
                   }
                   else
                   {
                        JOptionPane.showMessageDialog(this,"No registration found with Adhar Card No : "+ adharCardNo,"Error",JOptionPane.ERROR_MESSAGE);
                   }
               }
               catch (SQLException ex)
               {
                      JOptionPane.showMessageDialog(this,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
               }
       }
       
       private void clearFields()
       {
               txtAdharCardNo.setText("");
               txtBirthYear.setText("");
               txtMobileNo.setText("");
               rdoAgeGroup18.setSelected(true);
               cboHospital.setSelectedIndex(0);
               rdoVaccineCovieshield.setSelected(true);
               rdoTimeSlotMorning.setSelected(true);
       }
       
       private void initializeDB()
       {
               try
               {
                   //Class.forName("org.postgresql.Driver");
                   conn = DriverManager.getConnection("jdbc:postgresql://192.168.1.254/exam27","exam27","exam27");
                   stmt = conn.createStatement();
                   stmt.execute("CREATE TABLE IF NOT EXISTS registrations(adhar_card_no VARCHAR(12) PRIMARY KEY,birth_year INT, mobile_no VARCHAR(10),age_group VARCHAR(50),hospital VARCHAR(50),vaccine VARCHAR(10),time_slot VARCHAR(10))");
               }
               catch (SQLException ex)
               {
                      JOptionPane.showMessageDialog(this,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
               }
       }
       
       public static void main(String[] args)
       {
              CoWinRegistrationGUI gui = new CoWinRegistrationGUI();
              gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
              gui.setVisible(true);
       }
 }
