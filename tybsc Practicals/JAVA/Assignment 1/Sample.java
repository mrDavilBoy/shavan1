import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Sample extends JFrame implements ActionListener
{
      ArrayList<String> element = new ArrayList<>();
      JPanel panel;
      JTextField t1;
      JButton b1;
      JLabel l1;
      
      Sample
      {
            JPanel panel = new panel();
            JLabel l1 = new JLabel("Enter String : ");
            JTextField t1 = new JTextField(20);
            JButton b1 = new JButton("ADD");
            
            p.add(l1);
            p.add(t1);
            p.add(b1);
            
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
            
            
      }
      
      public static void main(String[] args)
      {
             Sample sample1= new Sample();
      }
}
