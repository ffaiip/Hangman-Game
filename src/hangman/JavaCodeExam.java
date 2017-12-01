/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;

/**
 *
 * @author Faiip
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class JavaCodeExam extends JFrame implements ActionListener {

 private JFrame frame;
 private JPasswordField passwordField;
 private JLabel showStatus;
 private JTextField textField;
 private Map<String, String> userAndPass = new HashMap<String, String>();

 public static void main(String[] args) throws Exception {
  JavaCodeExam codeExam = new JavaCodeExam();
  codeExam.setUserAndPass("admin", "password");
  codeExam.setUserAndPass("Test", "Test");
  codeExam.setUserAndPass("faii", "36491");
 }

 public JavaCodeExam() {
  this.frame = new JFrame();
  this.frame.setVisible(true);

  this.frame.setTitle("Frame By Java Code Exam");
  this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  JPanel panel = new JPanel();
  panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

  JPanel panel1 = new JPanel();
  JPanel panel2 = new JPanel();
  JPanel panel3 = new JPanel();
  JPanel panel4 = new JPanel();

  JLabel labelUser = new JLabel("Input Username : ");
  panel1.add(labelUser);

  JLabel labelPass = new JLabel("Input Password : ");
  panel2.add(labelPass);

  this.textField = new JTextField(10);
  panel1.add(this.textField);

  this.passwordField = new JPasswordField(10);
  panel2.add(this.passwordField);

  JButton btn = new JButton("Login");
   btn.addActionListener(this);
  panel3.add(btn);

  this.showStatus = new JLabel("Status : ");
  panel4.add(this.showStatus);

  panel.add(panel1);
  panel.add(panel2);
  panel.add(panel3);
  panel.add(panel4);

  this.frame.add(panel);
  this.frame.setSize(400, 200);
 }
 
 private void setUserAndPass(String user, String pass){
  this.userAndPass.put(user, pass);
 }

 @Override
 public void actionPerformed(ActionEvent e) {
  char[] pass = this.passwordField.getPassword();
  String passStr = new String(pass);
  String userStr = this.textField.getText();
  
  String passTrue = this.userAndPass.get(userStr);
  if(passStr.equals(passTrue)){
   this.showStatus.setText("Status : Success");
  }
  else{
   this.showStatus.setText("Status : Fail");
  }
 }
}
