package com.krislq.robot.action;


/**
 * 
 * @{#} DefaultActionImp.java Create on 2014-1-15 下午9:13:19    
 *    
 * class desc:   
 *
 * <p>Copyright: Copyright(c) 2013 </p>
 * @Version 1.0
 * @Author <a href="mailto:kris@krislq.com">Kris.lee</a>      
 *  
 *
 */
public class DefaultActionImp implements IAction{
    private int mAction;
    private String mActionName;

    public DefaultActionImp() {
        
    }
    public DefaultActionImp(int key,String name) {
        mAction = key;
        mActionName = name;
    }
    public int getKey() {
        return mAction;
    }

    public void setKey(int mKey) {
        this.mAction = mKey;
    }
    @Override
    public int getAction() {
        return mAction;
    }
    @Override
    public boolean isAvisible() {
        return true;
    }
    @Override
    public String getActionName() {
        return mActionName;
    }
    
    public void setActionName(String mActionName) {
        this.mActionName = mActionName;
    }
    
}
