package com.krislq.robot.action;


/**
 * 
 * @{#} NoneActionImp.java Create on 2014-1-15 下午9:13:19    
 *    
 * class desc:   
 *
 * <p>Copyright: Copyright(c) 2013 </p>
 * @Version 1.0
 * @Author <a href="mailto:kris@krislq.com">Kris.lee</a>      
 *  
 *
 */
public class NoneActionImp implements IAction{

    @Override
    public int getAction() {
        return 0;
    }

    @Override
    public boolean isAvisible() {
        return false;
    }

    @Override
    public String getActionName() {
        return "NONE";
    }

    
}
