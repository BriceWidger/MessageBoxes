/*
Brice Widger
3/18/2020
Bellevue University
Assignment 8.1
File: MessageBoxes.java

Sources:
Java Programming; Joyce Farrell; Course Technology
https://gist.github.com/sfcgeorge/83027af0338c7c34adf8
*/

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class MessageBoxes {

   private JButton[] b = { new JButton("Alert"), new JButton("Yes/No"),
           new JButton("Color"), new JButton("Input"), new JButton("4 Vals"), };

   private JTextField txt = new JTextField(15);

   private JFrame frame;

   public MessageBoxes() {

       frame = new JFrame("Title");

       frame.setSize(250, 250);

       frame.getContentPane().setLayout(new FlowLayout());

       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       for (int i = 0; i < b.length; i++) {

           frame.getContentPane().add(b[i]);
       }

       frame.getContentPane().add(txt);

       frame.setVisible(true);

   }

   /*
   The section below public void launchJFrame() is the main area of modification. 
   Basically, all that was needed was to take out the for loop and assign buttons
   0-4 (each with its own action listener) to code that was already provided in 
   the original assignment. It was modification practice for multiple actions
   listeners. JButton[] b was a giveaway to use b[0-4].
   */
   public void launchJFrame() {
       //button 1
       //reference: https://gist.github.com/sfcgeorge/83027af0338c7c34adf8
       b[0].addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               JOptionPane.showMessageDialog(null, "There's a bug on you!",
                       "Hey!", JOptionPane.ERROR_MESSAGE);
           }
       });
       //button 2
       //reference: https://gist.github.com/sfcgeorge/83027af0338c7c34adf8
       b[1].addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               int val = JOptionPane.showConfirmDialog(null, "or no",
                       "Chose yes", JOptionPane.YES_NO_OPTION);

               if (val != JOptionPane.CLOSED_OPTION) {

                   if (val == 0) {

                       txt.setText("Yes");
                   } else {

                       txt.setText("No");
                   }
               }
           }
       });
       //button 3
       //reference: https://gist.github.com/sfcgeorge/83027af0338c7c34adf8
       b[2].addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               Object[] options = { "Red", "Green", "Blue" };

               int sel = JOptionPane.showOptionDialog(null, "Choose a Color!",
                       "Warning", JOptionPane.DEFAULT_OPTION,
                       JOptionPane.WARNING_MESSAGE, null, options, options[0]);

               if (sel != JOptionPane.CLOSED_OPTION) {

                   txt.setText("Color Selected: " + options[sel]);
               }
           }
       });
       //button 4
       //reference: https://gist.github.com/sfcgeorge/83027af0338c7c34adf8
       b[3].addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               String val = JOptionPane
                       .showInputDialog("How mant fingers do you see?");

               txt.setText(val);
           }
       });
       //button 5
       //reference: https://gist.github.com/sfcgeorge/83027af0338c7c34adf8
       b[4].addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               Object[] selections = { "First", "Second", "Third", "Fourth" };

               Object val = JOptionPane.showInputDialog(null, "Choose one",
                       "Input", JOptionPane.INFORMATION_MESSAGE, null,
                       selections, selections[0]);

               if (val != null) {

                   txt.setText(val.toString());
               }
           }
       });
   }

   public static void main(String[] args) {

       MessageBoxes messageBoxes = new MessageBoxes();
       messageBoxes.launchJFrame();
   }
}