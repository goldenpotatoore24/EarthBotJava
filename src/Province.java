public class Province {
    private double devastation;
    private Nation nation;
    private String name;
    private Pop[] pops = new Pop[0];
    private Building[] buildings = new Building[0];
    private Market market;


    public Province(Nation nation, double devastation, String name, Market market)
    {

        this.nation = nation;
        this.devastation = devastation;
        this.name = name;
        this.market = market;
        nation.provinceArrayPush(this);
        market.provinceArrayPush(this);
        new Building(nation.getStateCompany(), main.good("Unemployment Benefit"), 50, this);

    }

    public void popArrayPush(Pop input)
    {
        Pop[] newArr = new Pop[pops.length + 1];
        for(int i = 0; i < pops.length; i++)
        {
            newArr[i] = pops[i];
        }
        newArr[newArr.length - 1] = input;
        pops = newArr;
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



    //SETTER AND GETTER METHODS


    public Building[] getBuildings() {
        return buildings;
    }

    public Market getMarket() {
        return market;
    }

    public Nation getNation() {
        return nation;
    }

    public String getName() {
        return name;
    }

    public Pop[] getPops() {
        return pops;
    }
}
