/*2. Write a java program using Multithreading to display the number’s between 1 to 100 continuously in a JTextField by clicking on JButton. (Use Runnable Interface & Swing).
Ans:*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NumberDisplayApp extends JFrame {

private JTextField textField;
private JButton startButton;
private JButton stopButton;
private volatile boolean running;
private Thread displayThread;

public NumberDisplayApp() {
setTitle("Number Display");
setSize(300, 150);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLocationRelativeTo(null);

textField = new JTextField();
textField.setEditable(false);

startButton = new JButton("Start");
startButton.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
startDisplay();
}
});

stopButton = new JButton("Stop");
stopButton.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
stopDisplay();
}
});

JPanel buttonPanel = new JPanel();
buttonPanel.add(startButton);
buttonPanel.add(stopButton);

JPanel mainPanel = new JPanel(new BorderLayout());
mainPanel.add(textField, BorderLayout.CENTER);
mainPanel.add(buttonPanel, BorderLayout.SOUTH);

add(mainPanel);
}

private void startDisplay() {
running = true;
displayThread = new Thread(new Runnable() {
public void run() {
for (int i = 1; i <= 100 && running; i++) {
final int number = i;
SwingUtilities.invokeLater(new Runnable() {
public void run() {
textField.setText(Integer.toString(number));
}
});
try {
Thread.sleep(500); // Adjust delay as needed
} catch (InterruptedException e) {
e.printStackTrace();
}
}
}
});
displayThread.start();
}

private void stopDisplay() {
running = false;
try {
if (displayThread != null)
displayThread.join();
} catch (InterruptedException e) {
e.printStackTrace();
}
}

public static void main(String[] args) {
SwingUtilities.invokeLater(new Runnable() {
public void run() {
new NumberDisplayApp().setVisible(true);
}
});
}
}

