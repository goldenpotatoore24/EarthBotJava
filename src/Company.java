import java.util.ArrayList;

public class Company {

    private Character headOfCompany;

    private String name;
    private Nation headQuarters;
    private Building[] buildings = new Building[0];
    private double moneyReserves;

    public Company(Character headOfCompany, String name, Nation headQuarters) {
        this.headOfCompany = headOfCompany;
        this.name = name;
        this.headQuarters = headQuarters;
        headOfCompany.invest(5000000, this);

        headQuarters.addCompany(this);

    }





    public void pay()
    {

        for(int j = 0; j < buildings.length; j++) {
            for (int i = 0; i < buildings[j].getPositions().size(); i++) {
                double companyExpenses = 0;
                Job currentPos = buildings[j].getPositions().get(i);
                if (currentPos.getWages() > 0) {
                    for (int k = 0; k < currentPos.getWorkers().size(); k++) {
                        PopAmt currentGroup = currentPos.getWorkers().get(k);
                        moneyReserves -= currentGroup.getAmt() * currentPos.getWages();
                        currentGroup.setMoneyReserves(currentGroup.getMoneyReserves() + currentGroup.getAmt() * currentPos.getWages());
                        System.out.println("Company " + name + " paid their employees from " + currentGroup.getPop().getLocation().getName() + " " + currentGroup.getAmt() * currentPos.getWages());
                        companyExpenses += currentGroup.getAmt() * currentPos.getWages();
                    }
                }
            buildings[j].setLastSpending(companyExpenses);
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

    public void addMoneyReserves(double amt)
    {
        moneyReserves += amt;
    }



}

