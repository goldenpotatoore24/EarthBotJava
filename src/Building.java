public class Building {
    private Company owner;
    private Good producedGood;
    private double efficiency;
    private int workers;
    private Province location;
    private String type;

    public Building(Company owner, Good producedGood, double efficiency, int workers, Province location, String type)
    {
        this.owner = owner;
        this.producedGood = producedGood;
        this.efficiency = efficiency;
        this.workers = workers;
        this.location = location;
        this.type = type;
        owner.buildingArrayPush(this);
        location.buildingArrayPush(this);
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
