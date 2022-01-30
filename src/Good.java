public class Good {

    private String type;
    private double value;
    private double supply;
    private double demand;

    public Good(String type, double value, double supply, double demand)
    {
        this.type = type;
        this.value = value;
        this.supply = supply;
        this.demand = demand;
    }

    public void calculateNewValue()
    {
        //TODO: Find a way to calculate a new value from supply and demand
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getSupply() {
        return supply;
    }

    public void setSupply(double supply) {
        this.supply = supply;
    }

    public double getDemand() {
        return demand;
    }

    public void setDemand(double demand) {
        this.demand = demand;
    }
}
