package com.krislq.robot.device;

import com.krislq.robot.action.IAction;

public abstract class Robot {

    protected int maxX;
    protected int maxY;

    protected Position mPosition;

    public Robot() {
        mPosition = new Position();
    }

    public void setPosition(Position position) {
        if (position != null) {
            mPosition = position;
        } else {
            mPosition = new Position();
        }
    }

    /**
     * set the bound of the robot
     * method desc：
     * @param x
     * @param y
     */
    public void setBound(int x, int y) {
        this.maxX = x;
        this.maxY = y;
    }

    public abstract Position doAction(IAction action);

    public String printLocation() {
        return printXY() +" "+printDirection();
        
    }
    protected String printXY() {
        System.out.println("X:"+mPosition.x+"#Y:"+mPosition.y);
        return mPosition.x+" "+mPosition.y;
    }
    protected String printDirection() {
        String d = "";
        if(mPosition.direction==0) {
            d = "E";
        } else if(mPosition.direction==1) {
            d = "W";
        } else if(mPosition.direction==2) {
            d = "S";
        } else if(mPosition.direction==3) {
            d = "N";
        }
        System.out.println("printDirection:"+d);
        return d;
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
