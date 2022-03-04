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

    public double getAmt() {
        return amt;
    }

    public Good getGood() {
        return good;
    }

    public void addGoods(double addAmt) {
        amt += addAmt;
    }

    public Building getProducer() {
        return producer;
    }
}
