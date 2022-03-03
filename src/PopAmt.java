public class PopAmt {

    private double amt;
    private Pop pop;
    private Building workplace;

    public PopAmt(double amt, Pop pop, Building workplace) {
        this.amt = amt;
        this.pop = pop;
        this.workplace = workplace;
    }

    public double getAmt() {
        return amt;
    }

    public void setAmt(double amt) {
        this.amt = amt;
    }

}
