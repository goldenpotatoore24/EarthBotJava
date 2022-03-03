import java.util.ArrayList;

public class Building {
    private Company owner;
    private GoodAmt goodReserves;
    private Good producedGood;
    private double efficiency;
    private ArrayList<PopAmt> workers = new ArrayList<PopAmt>();
    private Province location;
    private Job[] positions;





    private double productionValue;

    public Building(Company owner, Good producedGood, double efficiency, Province location)
    {
        this.owner = owner;
        this.producedGood = producedGood;
        this.efficiency = efficiency;
        this.location = location;
        productionValue = getWorkers() * efficiency;

        owner.buildingArrayPush(this);

        location.buildingArrayPush(this);


    }



    public Nation getNation()
    {
        return location.getNation();
    }



    public void addWorkerGroup(PopAmt input)
    {
        workers.add(input);
    }


    public int getWorkers()
    {
        int total = 0;
        for(int i = 0; i < workers.size(); i++)
        {

            total += workers.get(i).getAmt();
        }
        return total;

    }

    public Job[] getPositions() {
        return positions;
    }

    public void setPositions(Job[] positions) {
        this.positions = positions;
    }

    public Market getMarket()
    {
        return location.getMarket();
    }


    public void updateProductionValue()
    {
        productionValue = getWorkers() * efficiency;
    }

    public void produce()
    {
        updateProductionValue();
        goodReserves = new GoodAmt(productionValue / producedGood.getProductionCost(), producedGood, this);

    }

    public void hire()
    {



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

    public Province getLocation() {
        return location;
    }

    public void setLocation(Province location) {
        this.location = location;
    }
}
