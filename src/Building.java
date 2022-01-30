public class Building {
    private Company owner;
    private GoodAmt goodReserves;
    private Good producedGood;
    private double efficiency;
    private int workers;
    private Province location;
    private String type;
    private double productionValue;

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

    public Nation getNation()
    {
        return location.getNation();
    }

    public Market getMarket()
    {
        return location.getMarket();
    }


    public void updateProductionValue()
    {
        productionValue = workers * efficiency;
    }

    public void produce()
    {
        updateProductionValue();
        goodReserves = new GoodAmt(productionValue / producedGood.getProductionCost(), producedGood, this);

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
