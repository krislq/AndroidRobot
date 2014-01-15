package com.krislq.robot.action;

/**
 * 
 * @{#} IAction.java Create on 2014-1-15 下午9:43:13    
 *    
 * class desc:   
 *
 * <p>Copyright: Copyright(c) 2013 </p>
 * @Version 1.0
 * @Author <a href="mailto:kris@krislq.com">Kris.lee</a>      
 *  
 *
 */
public interface IAction {
//    public static enum DIRECTION {
//        E,W,S,N
//    }

    public static final int E = 0;
    public static final int W = 1;
    public static final int S = 2;
    public static final int N = 3;
    

    public static final int F = 0;
    public static final int B = 1;
    public static final int L = 2;
    public static final int R = 3;

    public int getAction();
    public boolean isAvisible() ;
    public String getActionName();
}
