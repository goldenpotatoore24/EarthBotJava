public class PopAmt {

    private double amt;
    private Pop pop;
    private Job job;
    private double moneyReserves;

    public PopAmt(double amt, Pop pop, Job job) {
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

    public Pop getPop() {
        return pop;
    }

    public double getAmt() {
        return amt;
    }

    public void setAmt(double amt) {
        this.amt = amt;
    }

}
