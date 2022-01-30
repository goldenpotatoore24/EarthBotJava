public class Building {
    private Good producedGood;
    private double efficiency;
    private int workers;

    public Building(Good producedGood, double efficiency, int workers)
    {
        this.producedGood = producedGood;
        this.efficiency = efficiency;
        this.workers = workers;
    }
}
