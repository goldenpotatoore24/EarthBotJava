import java.util.ArrayList;

public class Job {
    private double wages;
    private int neededWorkers;
    private ArrayList<PopAmt> workers = new ArrayList<PopAmt>();
    private Building building;



    public Job(double wages, ArrayList<PopAmt> workers, Building building) {
        this.wages = wages;
        this.workers = workers;
        this.building = building;

    }

    public Job(double wages, Building building) {
        this.wages = wages;
        this.building = building;
        if(building.canHire()) {
            if (wages == 0) {
                neededWorkers = Integer.MAX_VALUE;
            } else if(building.getPositions().size() == 1)
            {
                neededWorkers = Integer.MAX_VALUE;
            } else {
                if (building.getPositions().size() == 2) {
                    neededWorkers = (int) (building.getPositions().get(1).getAllWorkers() / 5);
                } else if (building.getPositions().size() == 3) {
                    neededWorkers = (int) (building.getPositions().get(2).getAllWorkers() / 5);
                }
            }
        }
    }

    public int getNeededWorkers() {
        return neededWorkers;
    }

    public int shouldHire()
    {
        if(wages == 0)
        {
            return 0; // SET TO 0 BECAUSE THESE ARE INTERNS AND PEOPLE CURRENTLY HAVE NO FREE WILL TO CHOOSE THEIR JOBS ...
            // SO COMPANIES WILL JUST HIRE INFINITE INTERNS (FIX LATER WHEN PEOPLE HAVE FREE WILL)
        }
        if(neededWorkers < getAllWorkers())
        {
            return 0; // have enough workers :clap:
        }
        if(building.getAge() <= 3)
        {
            if(building.getLastSpending() > building.getLastIncome() * 2)
            {
                return 0;
            } else
            {
                return (int)((building.getLastIncome() + building.getOwner().getMoneyReserves()) / wages);
            }
        } else if(building.getAge() <= 6)
        {
            if(building.getLastSpending() > building.getLastIncome() * 1.5)
            {
                return 0;
            } else
            {
                return (int)((building.getLastIncome() * 0.75) / wages);
            }
        } else
        {
            if(building.getLastSpending() + wages > building.getLastIncome())
            {
                return 0;
            } else
            {
                return (int)((building.getLastIncome() - building.getLastSpending()) * 0.75);
            }
        }
    }


    public double getWages() {
        return wages;
    }

    public void setWages(double wages) {
        this.wages = wages;
    }

    public ArrayList<PopAmt> getWorkers() {
        return workers;
    }

    public int getAllWorkers()
    {
        int count = 0;
        for(int i = 0; i < workers.size(); i++)
        {
            count += workers.get(i).getAmt();
        }
        return count;
    }


    public void setWorkers(ArrayList<PopAmt> workers) {
        this.workers = workers;
    }

    public void addWorkers(PopAmt input)
    {
        workers.add(input);
    }

}
