import java.util.ArrayList;

public class Job {
    private double wages;
    private int neededWorkers;
    private ArrayList<PopAmt> workers = new ArrayList<PopAmt>();


    public Job(double wages, ArrayList<PopAmt> workers) {
        this.wages = wages;
        this.workers = workers;
    }

    public Job(double wages) {
        this.wages = wages;

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

    public void setWorkers(ArrayList<PopAmt> workers) {
        this.workers = workers;
    }

    public void addWorkers(PopAmt input)
    {
        workers.add(input);
    }

}
