public class GoodAmt {
    private double amt;
    private Good good;
    private Building producer;

    public GoodAmt(double amt, Good good, Building producer) {
        this.amt = amt;
        this.good = good;
        this.producer = producer;
        producer.getMarket().goodArrayPush(this);
    }
}
