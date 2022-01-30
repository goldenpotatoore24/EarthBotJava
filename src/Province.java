public class Province {
    private double devastation;
    private String name;
    private Pop[] pops = new Pop[0];
    private Building[] buildings;


    public Province(double devastation, String name)
    {

        this.devastation = devastation;
        this.name = name;


    }

    public void popArrayPush(Pop input)
    {
        Pop[] newArr = new Pop[pops.length + 1];
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
