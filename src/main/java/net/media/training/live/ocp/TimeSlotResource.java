package net.media.training.live.ocp;/**
 * Created by autoopt/mayank.k
 */

public class TimeSlotResource extends Resource{

    @Override
    public int allocate() {
        int resourceId = findFreeTimeSlot();
        markTimeSlotBusy(resourceId);
        return resourceId;
    }

    @Override
    public void free(int resourceId) {
        markTimeSlotFree(resourceId);
    }

    protected void markTimeSlotFree(int resourceId) {
    }

    protected void markTimeSlotBusy(int resourceId) {
    }

    protected int findFreeTimeSlot() {
        return 0;
    }
}
