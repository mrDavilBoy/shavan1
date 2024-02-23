import java.util.HashMap;
import java.util.Map;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class CitySTDCodeApp extends JFrame
{
       private HashMap<String,String>cityMap;
       private JPanel panel;
       private JTextField cityField, codeField;
       private JLabel cityLabel, codeLabel,resultLabel;
       private JButton addButton,removeButton,searchButton;
       
       public CitySTDCodeApp()
       {
              super("City STD Code App");
              cityMap = new HashMap<>();
              panel = new JPanel(new GridLayout(4,2));
              cityField = new JTextField(20);
              codeField = new JLabel("City Name");
              codeLabel = new JLabel("STD Code");
              resultLabel = new JLabel("");
              
              addButton = new JButton("Add");
              addButton.addActionListener(new ActionListener()
              {
                 @Override
                 public void actionPerformed(ActionEvent e)
                 {
                        String city = cityField.getText().trim();
                        String code = codeField.getText().trim();
                        
                        if (city.length()==0|| code.length()==0)
                        {
                            JOptionPane.showMessageDialog(CitySTDCodeApp.this,"Please enter both city name and STD Code","ERROR",JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        
                        if (cityMap.containsKey(city))
                        {
                            JOptionPane.showMessageDialog(CitySTDCodeApp.this,"City Already Exist in the list","ERROR",JOptionPane.ERROR_MESSAGE);
                            
                            return;
                        }
                        cityMap.put(city,code);
                        resultLabel.setText("City added Successfully");
                 }
              });
              
              removeButton = new JButton("Remove");
              removeButton.addActionListener(new ActionListener()
              {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                           String city = cityField.getText().trim();
                           
                           if (city.length()==0)
                        {
                            JOptionPane.showMessageDialog(CitySTDCodeApp.this,"Please enter a city name","ERROR",JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        
                        if (!cityMap.containKey(city))
                        {
                            JOptionPane.showMessageDialog(CitySTDCodeApp.this,"City does not existin the list","ERROR",JOptionPane.ERROR_MESSAGE);
                            
                            return;
                        }
                        cityMap.remove(city);
                        resultLabel.setText("City removed Successfully");
                    }
              });
              
              searchButton = new JButton("Search");
              searchButton.addActionListener(new ActionListener()
              {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                           String city = cityField.getText().trim();
                           
                           if (city.length()==0)
                        {
                            JOptionPane.showMessageDialog(CitySTDCodeApp.this,"Please enter a city name","ERROR",JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        
                        if (!cityMap.containKey(city))
                        {
                            JOptionPane.showMessageDialog(CitySTDCodeApp.this,"City does not existin the list","ERROR",JOptionPane.ERROR_MESSAGE);
                            
                            return;
                        }
                        resultLabel.setText("STD code for "+city+" : "+cityMap.get(city));
                    }
              });
              
              panel.add(cityLabel);
              panel.add(cityField);
              panel.add(codeLabel);
              panel.add(codeField);
              panel.add(addButton);
              panel.add(removeButton);
              panel.add(searchButton);
              panel.add(resultLabel);
              
              getContentPane().add(panel);
              setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
              
              setSize(400,200);
              setLocationRelativeTo(null);
              setVisible(true);
       }
       public static void main(String[] args)
       {
              new CitySTDCodeApp();
       }
}
