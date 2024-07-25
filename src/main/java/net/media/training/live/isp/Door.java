package net.media.training.live.isp;

/**
 * Created by IntelliJ IDEA.
 * User: goyalamit
 * Date: Jul 11, 2011
 * Time: 10:26:10 AM
 * To change this template use File | Settings | File Templates.
 */
public interface Door extends TimerClient, SensorClient{
    void lock();
    void unlock();
    void open();
    void close();
}
