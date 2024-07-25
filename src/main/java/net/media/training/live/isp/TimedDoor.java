package net.media.training.live.isp;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by IntelliJ IDEA.
 * User: goyalamit
 * Date: Jul 11, 2011
 * Time: 10:26:24 AM
 * To change this template use File | Settings | File Templates.
 */
public class TimedDoor implements Door,TimerClient  {
    private boolean isLocked;
    private boolean isOpened;
    private static final int TIME_OUT = 100;

    public TimedDoor(Timer timer) {
        timer.register(TIME_OUT, this);
    }

    public void lock() {
        this.isLocked = true;
    }

    public void unlock() {
        this.isLocked = false;
    }

    public void open() {
        if (!isLocked)
            this.isOpened = true;
    }

    public void close() {
        this.isOpened = false;
    }

    public void timeOutCallback() {
        this.isLocked = true;
    }

    public void proximityCallback() {
        throw new NotImplementedException();
    }
}
