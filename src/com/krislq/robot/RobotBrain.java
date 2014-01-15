package com.krislq.robot;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.table.TableColumn;

import com.krislq.robot.util.Resourse;
import com.krislq.robot.util.Utils;

public class RobotBrain extends JFrame implements KeyListener {
    /**
     * serialVersionUID：
     */
    private static final long serialVersionUID = -265931313516696756L;
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    RobotBrain frame = new RobotBrain();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    

    public static final String APP_NAME = "Android Robot Brain";
    private int mAppWidth = 500;
    private int mAppHeight = 500;
    private JSplitPane mMainPane = null;
    
    private JTextArea mActionArea = null;
    private JTextArea mResultArea = null;
    
    public RobotBrain() {
      //the the default ui
        Utils.setLookAndFeel();

        getContentPane().setLayout(new BorderLayout());
        //set the app frame is in the center of the screen
        int screenWith = Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenheight = Toolkit.getDefaultToolkit().getScreenSize().height;
        setBounds((screenWith-mAppWidth)/2, (screenheight - mAppHeight)/2, mAppWidth, mAppHeight);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        setTitle(APP_NAME);
        setIconImage(this.getToolkit().createImage(Resourse.url_icon));

        initMainFrame();
    }
    

    private void initMainFrame() {
        mMainPane = new JSplitPane();
        mMainPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
        mMainPane.setResizeWeight(0.5);
        mMainPane.setOneTouchExpandable(true);
        
        mActionArea = new JTextArea();
        mActionArea.setText("action");
        mActionArea.setLineWrap(true);
        mActionArea.setEnabled(false);
        mResultArea = new JTextArea();
        mResultArea.setText("result");
        mResultArea.setLineWrap(true);
        mResultArea.setEnabled(false);

        mMainPane.setLeftComponent(mActionArea);
        mMainPane.setRightComponent(mResultArea);
        mMainPane.addPropertyChangeListener(new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent evt) {
                if (evt.getPropertyName().equals(JSplitPane.DIVIDER_LOCATION_PROPERTY)) {
                    resizeComponent(Integer.parseInt(evt.getNewValue().toString()));
                }
            }
        });

        add(mMainPane,BorderLayout.CENTER);
        addKeyListener(this);
    }
    public void resizeComponent(int newValue){
        System.out.println("LeftWidth:"+newValue);
    }


    @Override
    public void keyPressed(KeyEvent event) {
        int key = event.getKeyCode();
//        N, S, E, W
        switch (key) {
        //四个方向 
        case KeyEvent.VK_N:
            break;
        case KeyEvent.VK_S:
            break;
        case KeyEvent.VK_E:
            break;
        case KeyEvent.VK_W:
            break;
//            'L', 'R'
        default:
            break;
        }
    }


    @Override
    public void keyReleased(KeyEvent event) {
    }


    @Override
    public void keyTyped(KeyEvent event) {
    }
}
