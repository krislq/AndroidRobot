package com.krislq.robot.action;

import java.awt.event.KeyEvent;

/**
 * 
 * @{#} ActionFactory.java Create on 2014-1-15 下午9:13:30    
 *    
 * class desc:   
 *
 * <p>Copyright: Copyright(c) 2013 </p>
 * @Version 1.0
 * @Author <a href="mailto:kris@krislq.com">Kris.lee</a>      
 *  
 *
 */
public class ActionFactory {

    public static IAction createAction(int key) {
    IAction action = null;
      switch (key) {
//          'L', 'R'
      case KeyEvent.VK_L:
          action = new DefaultActionImp(IAction.L,"L");
          break;
      case KeyEvent.VK_R:
          action = new DefaultActionImp(IAction.R,"R");
          break;
          //'F', 'B'
      case KeyEvent.VK_F:
          action = new DefaultActionImp(IAction.F,"F");
          break;
      case KeyEvent.VK_B:
          action = new DefaultActionImp(IAction.B,"B");
          break;
      default:
          action = new NoneActionImp();
          break;
      }
      return action;
    }
}
