import java.util.ArrayList;

public class Building {
    private Company owner;
    private GoodAmt  goodReserves;
    private Good producedGood;
    private double efficiency;
    private ArrayList<PopAmt> workers = new ArrayList<PopAmt>();
    private Province location;
    private boolean hire;
    private ArrayList<Job> positions = new ArrayList<Job>();
    private int age = 0;
    private double lastIncome = 0;
    private double lastSpending = 0;

    private double productionValue;


    public Building(Company owner, Good producedGood, double efficiency, Province location)
    {
        this.owner = owner;
        this.producedGood = producedGood;
        this.efficiency = efficiency;
        this.location = location;
        this.goodReserves = new GoodAmt(0, producedGood, this);
        this.hire = true;
        positions.add(new Job(0, this)); // Unpaid Workers
        positions.add(new Job(12.5, this)); // Lower Position
        positions.add(new Job(40, this)); // Middle Management
        positions.add(new Job(150, this)); // Upper Management
        productionValue = getWorkers() * efficiency;
        owner.buildingArrayPush(this);
        location.buildingArrayPush(this);

    }

    public Building(Company owner, Good producedGood, double efficiency, Province location, boolean hire)
    {
        this.owner = owner;
        this.producedGood = producedGood;
        this.efficiency = efficiency;
        this.location = location;
        this.goodReserves = new GoodAmt(0, producedGood, this);
        this.hire = hire;
        this.lastIncome = 0;
        productionValue = getWorkers() * efficiency;
        positions.add(new Job(0, this));
        owner.buildingArrayPush(this);
        location.buildingArrayPush(this);

    }

    public ArrayList<Job> getPositions() {
        return positions;
    }

    public Nation getNation()
    {
        return location.getNation();
    }



    public void addWorkerGroup(PopAmt input)
    {
        workers.add(input);
    }


    public double getLastSpending() {
        return lastSpending;
    }

    public void setLastSpending(double lastSpending) {
        this.lastSpending = lastSpending;
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


    public void hire() {

        if (canHire()) {
            for (int k = 0; k < positions.size(); k++) {
                Job job = positions.get(k);
                if(job.shouldHire() > 0)
                {
                    if(location.getPops()[0].getPopGroups().get(0).getAmt() >= job.shouldHire() - job.getAllWorkers())
                    {
                        location.getPops()[0].addWorkers(job, job.shouldHire());
                        System.out.println(owner.getName() + " hired " + job.shouldHire() + " for the " + producedGood.getType() + " production in " + location.getName());
                    } else
                    {
                        location.getPops()[0].addWorkers(job, location.getPops()[0].getPopGroups().get(0).getAmt());
                        System.out.println(owner.getName() + " hired " + location.getPops()[0].getPopGroups().get(0).getAmt() + " for the " + producedGood.getType() + " production in " + location.getName());
                    }
                }
            }
        }
    }


    public boolean canHire() {
        return hire;
    }

    public Market getMarket()
    {
        return location.getMarket();
    }

    public Company getOwner() {
        return owner;
    }

    public void updateProductionValue()
    {
        productionValue = getWorkers() * efficiency;
    }

    public void produce()
    {
        age++;
        updateProductionValue();
        GoodAmt production = new GoodAmt(productionValue / producedGood.getProductionCost(), producedGood, this);
        location.getMarket().goodArrayPush(production); // Add new goodAmt obj to market
        lastIncome = production.getValue();
    }




    public int getAge() {
        return age;
    }



    public double getLastIncome() {
        return lastIncome;
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
