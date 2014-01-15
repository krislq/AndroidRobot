package com.krislq.robot.device;

import com.krislq.robot.action.IAction;

/**
 * 
 * @{# Position.java Create on 2014-1-15 下午9:49:12
 * 
 *     class desc:
 * 
 *     <p>
 *     Copyright: Copyright(c) 2013
 *     </p>
 * @Version 1.0
 * @Author <a href="mailto:kris@krislq.com">Kris.lee</a>
 * 
 * 
 */
public class Position {
    int x;
    int y;

    int direction;

    public Position() {
        direction = IAction.E;
    }

    public Position(int x, int y, int d) {
        this.setX(x);
        this.setY(y);
        this.setDirection(d);
    }

    public Position(Position p) {
        if (p == null) {
            return;
        }
        this.setX(p.x);
        this.setY(p.y);
        this.setDirection(p.direction);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

}
