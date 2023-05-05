import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;
import java.net.*;

class SignUp extends JFrame {

    JTextField t1, t2, t3;
    JButton b1;
    JLabel l1, l2, l3;


    //  SIGNUP CLASS

    SignUp() {

        setLayout(null);
        JLabel nameLabel = new JLabel("Name:");
        t1 = new JTextField(60);

        l3 = new JLabel("Signup");
        l3.setFont(new Font("Times New Roman", Font.BOLD, 30));
        l3.setForeground(Color.BLACK);
        l3.setBounds(130, 10, 300, 30);

        t2 = new JPasswordField(60);
        t3 = new JTextField(60);
        b1 = new JButton("Submit");

        l1 = new JLabel("Enter your name");
        l2 = new JLabel("Password");

        l1.setBounds(30, 60, 300, 30);
        l2.setBounds(30, 100, 300, 30);

        t1.setBounds(150, 60, 80, 30);
        t2.setBounds(150, 100, 80, 30);
        // t3.setBounds(100, 100, 80, 30);
        b1.setBounds(150, 140, 80, 30);

        // String uniqueId = generateId(unm);

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String unm = t1.getText();
                String pwd = t2.getText();

                // USERNAME & PASSWORD

                Random rand = new Random();
                String[] adjectives = { "happy", "silly", "cool", "funny", "crazy" };
                String adjective = adjectives[rand.nextInt(adjectives.length)];
                int number = rand.nextInt(100000);
                String username = adjective + "_" + unm ;
                        //"_" + number;

                try {
                    FileWriter fw = new FileWriter("login.txt", true);
                    fw.write(username + "\t" + pwd + "\n");
                    fw.close();

                    //Have to add something

                    /*
                      // Connect to the chat server with the unique username
                    Socket socket = new Socket("localhost", 1234);
                    Cllient client = new Cllient(socket, username);
                    client.listenForMessage();
                    client.sendMessage();

                    // Open the login window
                    Login login = new Login(client);
                    dispose();

                     */




                    Frame f = new JFrame();
                    JOptionPane.showMessageDialog(f, "Registration Completed! \n Your username is " + username);
                } catch (Exception e) {
                }
            }
        });
        add(nameLabel);
        add(t1);
        add(t2);
        add(l1);
        add(l2);
        add(l3);
        add(b1);
        //        setSize(350, 250);
        setVisible(true);
        //         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}















// LOGIN CLASS

class Login extends JFrame {
    JTextField t1, t2;
    JButton b1, b2;
    JLabel l1, l2, l3, l4;

    Login() {
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        l1 = new JLabel("Login");
        l1.setFont(new Font("Times New Roman", Font.BOLD, 30));
        l1.setForeground(Color.BLACK);
        l1.setBounds(130, 10, 300, 30);
        add(l1);

        t1 = new JTextField(60);
        t2 = new JPasswordField(60);
        b1 = new JButton("Sign In");
        b2 = new JButton("Sign Up");

        t1.setBounds(100, 60, 120, 30);
        t2.setBounds(100, 100, 120, 30);
        b1.setBounds(120, 140, 80, 30);
        b2.setBounds(120, 170, 80, 30);

        l3 = new JLabel("Username");
        l4 = new JLabel("Password");
        l3.setBounds(30, 60, 300, 30);
        l4.setBounds(30, 100, 300, 30);

        l2 = new JLabel("");
        l2.setBounds(250, 80, 300, 30);
        add(l3);
        add(l4);
        add(l2);
        add(t1);
        add(t2);
        add(b1);
        add(b2);


      //  /*
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                boolean matched = false;
                String uname = t1.getText().toString();
                String pwd = t2.getText().toString();


                try {
                    FileReader fr = new FileReader("login.txt");
                    BufferedReader br = new BufferedReader(fr);
                    String line;
                    while ((line = br.readLine()) != null) {
                        if (line.equals(uname + "\t" + pwd)) {
                            matched = true;
                            break;
                        }
                    }
                    fr.close();
                } catch (Exception e) {
                }


                if (matched) {
                    l2.setText("Welcome");
                                    // client can join after password match
                    try {
                        Socket socket = new Socket("localhost",1234);
                        Cllient client = new Cllient(socket, uname);

                      //  Testw tr = new Testw();

                        client.readMessage();
                        client.sendMessage();
                    } catch (UnknownHostException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();}


                } else {
                    l2.setText("Invalid Username or Password");
                }

                /*
                 * if(t1.getText().toString().equals("admin") &&
                 * t2.getText().toString().equals("admin"))
                 * l2.setText("Welcome");
                 * else
                 * l2.setText("Invalid Username or Password");
                 */

            }
        });

        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                SignUp s = new SignUp();
                s.setVisible(true);
                s.setBounds(200, 200, 500, 300);
            }
        });

    }
}
        //*/

        // CHAT GPT CODE START

        /*
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String username = t1.getText();
                String password = t2.getText();
                if (validateUser(username, password)) {
                    JOptionPane.showMessageDialog(null, "Successfully logged in!");
                    try {
                        Socket socket = new Socket("localhost", 1234);
                        Cllient client = new Cllient(socket, username);
                        client.listenForMessage();
                        client.sendMessage();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect username or password!");
                }
            }
        });

        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                new SignUp();
                dispose();
            }
        });


        add(t1);
        add(t2);
        add(l1);
        add(l2);
        add(l3);
        add(l4);
        add(b1);
        add(b2);
        setSize(150, 130);
        setVisible(true);


    }

    private boolean validateUser(String username, String password) {
        boolean isValidUser = false;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("login.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] credentials = line.split("\t");
                if (credentials[0].equals(username) && credentials[1].equals(password)) {
                    isValidUser = true;
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return isValidUser;
    }
}

        // CHATGPT CODE ENDS

         */

//          LOG IN PAGE  CLASS



    public class Login_Page {
        public static void main(String[] args) {

        /*
            Login l = new Login();
            l.setBounds(400, 200, 500, 300);
            l.setVisible(true);
            */

            /*
             * SignUp s = new SignUp();
             * s.setBounds(400, 300, 500, 300);
             * s.setVisible(true);
             */
        }
    }

