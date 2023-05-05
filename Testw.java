import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;


public class Testw extends JFrame {

    JTextField t1, t2, t3;
    JButton b1;
    JLabel l1, l2, l3;


    public void Testw(String text) {

        //Cllient cl =new Cllient();

        JFrame f= new JFrame(text);
        JTextArea area=new JTextArea();
        area.setBounds(10,30,200,200);
        f.add(area);
        f.setSize(300,300);
        f.setLayout(null);
        f.setVisible(true);


      /*

        setLayout(null);
        JLabel nameLabel = new JLabel("Name:");
        t1 = new JTextField(160);
/*
        l3 = new JLabel("Signup");
        l3.setFont(new Font("Times New Roman", Font.BOLD, 30));
        l3.setForeground(Color.BLACK);
        l3.setBounds(130, 10, 300, 30);

 */

    //    t2 = new JPasswordField(60);
    //    t3 = new JTextField(60);
    //    b1 = new JButton("Submit");

    //    l1 = new JLabel("Enter your name");
    //    l2 = new JLabel("Password");

    //    l1.setBounds(30, 60, 300, 30);
     //   l2.setBounds(30, 100, 300, 30);

    //    t1.setBounds(150, 60, 80, 30);
    //    t2.setBounds(150, 100, 80, 30);
        // t3.setBounds(100, 100, 80, 30);
  //      b1.setBounds(150, 140, 80, 30);

        // String uniqueId = generateId(unm);



     //   add(nameLabel);
   //     add(t1);
    //    add(t2);
    //    add(l1);
    //    add(l2);
  //      add(l3);
    //    add(b1);
        //        setSize(350, 250);
    //    setVisible(true);

        //         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


}


