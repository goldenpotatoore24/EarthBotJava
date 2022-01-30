public class Good {

    private String type;
    private double value;
    private double supply;
    private double demand;
    private double productionCost;

    public Good(String type, double value, double productionCost) {
        this.type = type;
        this.value = value;
        this.productionCost = productionCost;
    }

    public void calculateNewValue()
    {
        //TODO: Find a way to calculate a new value from supply and demand
    }

    //GETTER AND SETTER METHODS

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getValue() {
        return value;
    }

    public double getProductionCost() {
        return productionCost;
    }

    public void setProductionCost(double productionCost) {
        this.productionCost = productionCost;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getSupply() {
        return supply;
    }

    public void addSupply(double supply) {
        this.supply += supply;
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
