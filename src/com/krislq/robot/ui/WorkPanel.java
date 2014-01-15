package com.krislq.robot.ui;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class WorkPanel extends JPanel {

    /**
     * serialVersionUID：
     */
    private static final long serialVersionUID = 3263794432094568452L;

    private JLabel mActionLabel = null;
    private JLabel mResultLabel = null;
    public WorkPanel() {
        setLayout(new GridLayout(1,2));
        
        mActionLabel = new JLabel("action");
        mActionLabel.setBackground(Color.red);
        mResultLabel = new JLabel("result");
        mResultLabel.setBackground(Color.black);
        
        add(mActionLabel);
        add(mResultLabel);
    }
}
