package com.krislq.robot;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;

import com.krislq.robot.action.ActionFactory;
import com.krislq.robot.action.IAction;
import com.krislq.robot.device.Position;
import com.krislq.robot.device.Robot;
import com.krislq.robot.device.RobotFactory;
import com.krislq.robot.util.Resourse;
import com.krislq.robot.util.Utils;

/**
 * 
 * @{#} RobotBrain.java Create on 2014-1-15 下午9:13:25    
 *    
 * class desc:   
 *
 * <p>Copyright: Copyright(c) 2013 </p>
 * @Version 1.0
 * @Author <a href="mailto:kris@krislq.com">Kris.lee</a>      
 *  
 *
 */
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
    

    public static final String APP_NAME = "Robot Run";
    private int mAppWidth = 500;
    private int mAppHeight = 500;
    private JSplitPane mMainPane = null;
    
    private JTextArea mActionArea = null;
    private JTextArea mResultArea = null;
    
    private Robot mRobot = null;
    
    private StringBuilder mResult = new StringBuilder();
    private StringBuilder mAction = new StringBuilder();
    
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
        prepareData();
    }

    private void prepareData() {

        int maxX = 7;
        int maxY = 7;
        int x = 0;
        int y=0;
        int direction = IAction.S;
        String result = JOptionPane.showInputDialog("请输入机器人的坐标系大小。形如:7[空格]7。\n如果输入格式不正确，将默认大小为7 7");
        try {
            if(result!=null && result.length()>0) {
                String[] sizes =result.split(" ");
                if(sizes.length>=2) {
                    maxX = Integer.parseInt(sizes[0]);
                    maxY = Integer.parseInt(sizes[1]);
                }
            }
        } catch (Exception e) {
        }
        result = JOptionPane.showInputDialog("请输入机器人的初始位置。形如：0[空格]0[空格]S。\n" +
        		"四个方向分别为：E,W,S,N。\n" +
        		"输入格式不正确，将默认为:0 0 S");
        try {
            if(result!=null && result.length()>0) {
                String[] positions =result.split(" ");
                if(positions.length>=3) {
                    x = Integer.parseInt(positions[0]);
                    y = Integer.parseInt(positions[1]);
                    String s = positions[2];
                    if("E".equalsIgnoreCase(s)) {
                        direction = IAction.E; 
                    }else if("W".equalsIgnoreCase(s)) {
                        direction = IAction.W; 
                    }else if("N".equalsIgnoreCase(s)) {
                        direction = IAction.N; 
                    }else{
                        direction = IAction.S; 
                    }
                }
            }
        } catch (Exception e) {
        }
        mRobot = RobotFactory.createRobot(new Position(x, y, direction));
        mRobot.setBound(maxX, maxY);
        refreshResult("坐标系："+maxX+" "+maxY);
        refreshResult("初始位置：");
        refreshResult(mRobot.printLocation());
    }

    private void initMainFrame() {
        mMainPane = new JSplitPane();
        mMainPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
        mMainPane.setResizeWeight(0.5);
        mMainPane.setOneTouchExpandable(true);
        
        mActionArea = new JTextArea();
        mActionArea.setText("");
        mActionArea.setLineWrap(true);
        mActionArea.setEnabled(false);
        mResultArea = new JTextArea();
        mResultArea.setText("");
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
//        System.out.println("LeftWidth:"+newValue);
    }


    @Override
    public void keyPressed(KeyEvent event) {
        int key = event.getKeyCode();
        IAction action = ActionFactory.createAction(key);
        if(action.isAvisible()){
            mRobot.doAction(action);
            refreshResult(mRobot.printLocation());
        }
        refreshAction(action.getActionName());
    }
    private void refreshAction(String action) {
        if(mAction.length()>100) {
            mAction.delete(0, 50);
        }
        mAction.append(action+"\n");
        mActionArea.setText(mAction.toString());
    }
    private void refreshResult(String result) {
        if(mResult.length()>100) {
            mResult.delete(0, 50);
        }
        mResult.append(result+"\n");
        mResultArea.setText(mResult.toString());
        
    }


    @Override
    public void keyReleased(KeyEvent event) {
    }


    @Override
    public void keyTyped(KeyEvent event) {
    }
}
