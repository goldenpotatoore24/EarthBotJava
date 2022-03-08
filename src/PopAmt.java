public class PopAmt {

    private int amt;
    private Pop pop;
    private Job job;
    private double moneyReserves;

    public PopAmt(int amt, Pop pop, Job job) {
        this.amt = amt;
        this.pop = pop;
        this.job = job;
        job.addWorkers(this);
    }

    public void setMoneyReserves(double moneyReserves) {
        this.moneyReserves = moneyReserves;
    }

    public double getMoneyReserves() {
        return moneyReserves;
    }

    public Job getJob() {
        return job;
    }

    public Pop getPop() {
        return pop;
    }

    public int getAmt() {
        return amt;
    }

    public void setAmt(int amt) {
        this.amt = amt;
    }

}
