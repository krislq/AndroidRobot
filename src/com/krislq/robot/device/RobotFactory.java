package com.krislq.robot.device;

/**
 * 
 * @{#} RobotFactory.java Create on 2014-1-15 下午10:00:52    
 *    
 * class desc:   
 *
 * <p>Copyright: Copyright(c) 2013 </p>
 * @Version 1.0
 * @Author <a href="mailto:kris@krislq.com">Kris.lee</a>      
 *  
 *
 */
public class RobotFactory {

    public static Robot createRobot(Position p) {
        Robot r = new DefaultRobot();
        r.setPosition(p);
        return r;
    }
}
