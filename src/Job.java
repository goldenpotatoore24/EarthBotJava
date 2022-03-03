public class Job {
    private double wages;
    private int workers;

    public Job(double wages, int workers) {
        this.wages = wages;
        this.workers = workers;
    }

    public double getWages() {
        return wages;
    }

    public void setWages(double wages) {
        this.wages = wages;
    }

    public int getWorkers() {
        return workers;
    }

    public void setWorkers(int workers) {
        this.workers = workers;
    }
}
