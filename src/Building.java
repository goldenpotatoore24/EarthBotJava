public class Building {
    private Good producedGood;
    private double efficiency;
    private int workers;
    private Province location;

    public Building(Good producedGood, double efficiency, int workers, Province location)
    {
        this.producedGood = producedGood;
        this.efficiency = efficiency;
        this.workers = workers;
        this.location = location;
    }



    public Good getProducedGood() {
        return producedGood;
    }

    public void setProducedGood(Good producedGood) {
        this.producedGood = producedGood;
    }

    public double getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(double efficiency) {
        this.efficiency = efficiency;
    }

    public int getWorkers() {
        return workers;
    }

    public void setWorkers(int workers) {
        this.workers = workers;
    }

    public Province getLocation() {
        return location;
    }

    public void setLocation(Province location) {
        this.location = location;
    }
}
