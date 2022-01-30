public class Province {
    private double devastation;
    private Nation nation;
    private String name;
    private Pop[] pops = new Pop[0];
    private Building[] buildings;


    public Province(Nation nation, double devastation, String name)
    {

        this.nation = nation;
        this.devastation = devastation;
        this.name = name;
        nation.provinceArrayPush(this);

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



    //SETTER AND GETTER METHODS

    public String getName() {
        return name;
    }

    public Pop[] getPops() {
        return pops;
    }
}
