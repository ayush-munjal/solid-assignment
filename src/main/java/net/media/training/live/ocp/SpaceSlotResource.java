package net.media.training.live.ocp;

/**
 * Created by autoopt/mayank.k
 */

public class SpaceSlotResource extends Resource{

    @Override
    public int allocate() {
        int resourceId = findFreeSpaceSlot();
        markSpaceSlotBusy(resourceId);
        return resourceId;
    }

    @Override
    public void free(int resourceId) {
        markSpaceSlotFree(resourceId);
    }

    protected void markSpaceSlotFree(int resourceId) {
    }

    protected void markSpaceSlotBusy(int resourceId) {
    }

    protected int findFreeSpaceSlot() {
        return 0;
    }

}
