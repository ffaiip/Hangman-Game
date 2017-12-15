/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman1;
import java.util.Scanner;
import javax.swing.JOptionPane;
/**
 *
 * @author beau
 */
public class NewGame extends javax.swing.JFrame {

    /**
     * Creates new form NewGame
     */
    public String userName = "";
    String[] words = { "teacher", "artist", "doctor", "attorney", "chef", "fireman", "programmer", 
        "gardener", "model", "pilot", "pharmacist", "designer", "nurse", "accountant", "engineer", "student", "astronaut",
        "bartender", "policeman", "journalist"};
    int randomWordNumber = (int) (Math.random() * words.length);
    char[] enteredLetters = new char[words[randomWordNumber].length()];
    static int wrongCount = 0;
    public NewGame(String username) {
        userName = username;
        initComponents();
        run(username);
    }
    
    public  void run(String username){
    
	}

	public  void enterLetter(String word, char[] enteredLetters) {
            
            if(questionText.getText().equalsIgnoreCase(word))
            {
                JOptionPane.showMessageDialog(null, "You win !!! ");
                missCountText.setText("Congrats!! " + userName.toUpperCase() + " win!!");
            }
            
             if(wrongCount == 6){
		missCountText.setText(userName.toUpperCase() + " You lose!! The word is " + words[randomWordNumber]);
                
                }   
            printWord(word,enteredLetters);
		Scanner input = new Scanner(System.in);
		int emptyPosition = findEmptyPosition(enteredLetters);
		char userInput = answerText.getText().charAt(0);
		if (inEnteredLetters(userInput, enteredLetters)) {
			cautionText.setText(userInput + " is already in the word");
		} else if (word.contains(String.valueOf(userInput))) {
			enteredLetters[emptyPosition] = userInput;
		} else {
			cautionText.setText(userInput + " is not in the word");
                        wrongCount++;
                        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource(setImage(wrongCount))));
		}
	}

    /**
     *
     * @param count
     * @return
     */
    public String setImage(int count){
            if(count>0 && count<=6){
                String CountStr = count + "";
                String FileInfo = "/image/hangman" + count + ".png" ;
                return FileInfo;
            }
            return "";
        }
	public  void printWord(String word, char[] enteredLetters) {
                String ne = "";
		for (int i = 0; i < word.length(); i++) {
			char letter = word.charAt(i); 
			if (inEnteredLetters(letter, enteredLetters))
				ne = ne.concat(letter+"");
			else {
				ne = ne.concat("-");
			}
		}
                questionText.setText(ne);
	}

	public  boolean inEnteredLetters(char letter, char[] enteredLetters) {
		return new String(enteredLetters).contains(String.valueOf(letter));
	}

	public  int findEmptyPosition(char[] enteredLetters) {
		int i = 0;
		while (enteredLetters[i] != '\u0000')
			i++;
		return i;
	}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        questionText = new javax.swing.JTextField();
        answerText = new javax.swing.JTextField();
        cautionText = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        missCountText = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(800, 600));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/hangman0.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 100, 356, -1));

        questionText.setFont(new java.awt.Font("Apple Braille", 1, 48)); // NOI18N
        questionText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        questionText.setText("-------");
        jPanel1.add(questionText, new org.netbeans.lib.awtextra.AbsoluteConstraints(374, 86, 404, 106));

        answerText.setFont(new java.awt.Font("Lucida Grande", 0, 48)); // NOI18N
        answerText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(answerText, new org.netbeans.lib.awtextra.AbsoluteConstraints(496, 258, 89, 109));

        cautionText.setText("Guess The Word");
        jPanel1.add(cautionText, new org.netbeans.lib.awtextra.AbsoluteConstraints(454, 461, 281, 52));

        jButton1.setLabel("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(603, 282, 124, 63));
        jPanel1.add(missCountText, new org.netbeans.lib.awtextra.AbsoluteConstraints(454, 519, 281, -1));

        jPanel2.setBackground(new java.awt.Color(153, 204, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 600));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        enterLetter(words[randomWordNumber], enteredLetters);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewGame("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField answerText;
    private javax.swing.JTextField cautionText;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField missCountText;
    private javax.swing.JTextField questionText;
    // End of variables declaration//GEN-END:variables
}
