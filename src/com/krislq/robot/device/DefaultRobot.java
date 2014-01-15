package com.krislq.robot.device;

import com.krislq.robot.action.IAction;

/**
 * 
 * @{#} DefaultRobot.java Create on 2014-1-15 下午10:33:32    
 *    
 * class desc:   
 *
 * <p>Copyright: Copyright(c) 2013 </p>
 * @Version 1.0
 * @Author <a href="mailto:kris@krislq.com">Kris.lee</a>      
 *  
 *
 */
public class DefaultRobot extends Robot{

    public Position doAction(IAction action) {
        int a = action.getAction();
        switch (a) {
        case IAction.B://back
        case IAction.F://font
            move(a);
            break;
        case IAction.L://left
            turn(a);
            break;
        case IAction.R://right
            turn(a);
            break;
        default:
            break;
        }
        return mPosition;
    };

    /**
     * 向前向后
     * method desc：
     * @param action
     */
    private void move(int action) {
        int move = mPosition.direction ^ action;
        if(move< IAction.S) {
            //在x上移动，0为正方向，1为反方向
            if(move%2 ==0 ) {
                mPosition.x +=1;
                if(mPosition.x>maxX) {
                    mPosition.x = maxX;
                }
            } else {
                mPosition.x -=1;
                if(mPosition.x<0) {
                    mPosition.x = 0;
                }
            }
            
        } else{
            //在y上移动，0为正方向，1为反方向
            if(move%2 ==0 ) {
                mPosition.y +=1;  
                if(mPosition.y>maxY) {
                    mPosition.y = maxY;
                }
            } else {
                mPosition.y -=1;
                if(mPosition.y<0) {
                    mPosition.y = 0;
                }
            }
        }
        printLocation();
    }

    /**
     * 转方向
     * method desc：
     * @param action
     */
    private void turn(int action) {
        if(mPosition.direction< IAction.S) {
            mPosition.direction = mPosition.direction ^ (1^action);
        } else {
            mPosition.direction = mPosition.direction ^ action;
        }
        printLocation();
    }
    
    /**
     * 这是四个方向,
     * 第1位，0代表x,   1代表 y
     * 第2位，0代表正,  1代表反
     * 00     东
     * 01     西
     * 10     南
     * 11     北
     * 
     * 前进
     * 00 > 00,01,10,11 >小于2的就是x上移动，大于等于2的就是y上面移动
     * 后退
     * 01 > 01,00,11,10
     * 
     * 向左 10
     * 11 >  11,10,             >东西  >如果方向小于2，则与或11,其它与或10
     * 10 >       ,00,01        >南北
     *    >  11,10,00,01
     * 向右 11
     * 10 > 10,11               >东西  >如果方向小于2，则与或10
     * 11 >      ,01,00         >南北
     *    > 10,11,01,00
     */
}
