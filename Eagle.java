public class Eagle extends Bird implements Fly {

    private boolean flying;
    private int depths;

    public Eagle(String name) {
        super(name);
        this.flying = false;
        this.depths = 0;
    }


    @Override
    public String sing() {
        return "Screech!";
    }

  /**
     * dives, must be on ground
     */
    @Override
    public void takeOff() {
        if (!this.flying && this.depths == 0) {
            this.flying = true;
            System.out.printf("%s takes off in the sky.%n", this.getName());
        }
    }

    /**
     * swim downward
     * @param meters depths increase
     * @return depth
     */
    @Override
    public int ascend(int meters) {
        if (this.flying) {
            this.depths = Math.min(this.depths + meters, 325);
            System.out.printf("%s flies upward, altitude : %d%n", this.getName(), this.depths);
        }
        return this.depths;
    }

    /**
     * swin upward
     * @param meters depths decrease
     * @return depth
     */
    @Override
    public int descend(int meters) {
        if (this.flying) {
            this.depths = Math.max(this.depths - meters, 0);
            System.out.printf("%s flies downward, altitude : %d%n", this.getName(), this.depths);
        }
        return this.depths;
    }

    public void glide() {
	System.out.println("It glides into the air.");
}

    /**
     * get out of water, must be on surface
     */
    @Override
    public void land() {
        if (this.depths == 1) {
            System.out.printf("%s lands on the ground.%n", this.getName());
        } else {
	System.out.printf("%s is too high, it can't lands.%n", this.getName());
        }
}
}

    
