import java.util.ArrayList;

public class Company {

    private Character headOfCompany;
    private ArrayList<Job> positions = new ArrayList<Job>();
    private String name;
    private Nation headQuarters;
    private Building[] buildings = new Building[0];
    private double moneyReserves;

    public Company(Character headOfCompany, String name, Nation headQuarters) {
        this.headOfCompany = headOfCompany;
        this.name = name;
        this.headQuarters = headQuarters;
        headOfCompany.invest(5000, this);
        positions.add(new Job(12.5)); // Lower Position
        positions.add(new Job(40)); // Middle Management
        positions.add(new Job(150)); // Upper Tier
        headQuarters.addCompany(this);

    }


    public void pay()
    {

        for(int i = 0; i < positions.size(); i++)
        {
            Job currentPos = positions.get(i);
            for(int k = 0; k < currentPos.getWorkers().size(); k++)
            {
                PopAmt currentGroup = currentPos.getWorkers().get(k);
                moneyReserves -= currentGroup.getAmt() * currentPos.getWages();
                currentGroup.setMoneyReserves(currentGroup.getMoneyReserves() + currentGroup.getAmt() * currentPos.getWages());
                System.out.println("Company " + name + " paid their employees from " + currentGroup.getPop().getLocation().getName() + " " + currentGroup.getAmt() * currentPos.getWages());
            }

        }

    }


    public void buildingArrayPush(Building input)
    {
        Building[] newArr = new Building[buildings.length + 1];
        for(int i = 0; i < buildings.length; i++)
        {
            newArr[i] = buildings[i];
        }
        newArr[newArr.length - 1] = input;
        buildings = newArr;
    }

    public double getMoneyReserves() {
        return moneyReserves;
    }

    public void setMoneyReserves(double moneyReserves) {
        this.moneyReserves = moneyReserves;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Job> getPositions() {
        return positions;
    }
}

