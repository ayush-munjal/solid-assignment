package net.media.training.live.isp;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by IntelliJ IDEA.
 * User: goyalamit
 * Date: Jul 11, 2011
 * Time: 4:21:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class SensingDoor implements Door{
    private boolean isLocked;
    private boolean isOpened;

    public SensingDoor(Sensor sensor) {
    sensor.register(this);
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
      throw new NotImplementedException();
    }

    public void proximityCallback() {
        this.isOpened = true;
    }

}
