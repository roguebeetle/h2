// Главный модуль с формами
package org.roguebeetle.forms;

import javax.swing.*;

public class MainWindow extends JFrame{
    private JPanel rootPanel;
    private JButton button1;

    public MainWindow() {
        setContentPane(rootPanel);
        setSize(1024,768);
        setVisible(true);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
