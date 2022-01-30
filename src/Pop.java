public class Pop {

    private double happiness;
    private Province location;
    private Character[] characters = new Character[0];
    private int population;
    private int dependents;


    public Pop (double happinessIn, Province locationIn, int populationIn, int dependentsIn)
    {
        happiness = happinessIn;
        location = locationIn;
        location.popArrayPush(this);
        population = populationIn;
        dependents = dependentsIn;


    }




    public Character[] charArrayPush(Character[] chars, Character input)
    {
       Character[] newArr = new Character[chars.length + 1];
       newArr[newArr.length - 1] = input;
       return newArr;
    }


    public String toString()
    {
        return "This pop has a happiness of " + happiness + " and a population of " + population + ", " + dependents + " of which are dependents. They live in " + location.getName();
    }


    //GETTER AND SETTER METHODS

    public void setLocation(Province location) {
        this.location = location;
    }


    public Province getLocation() {
        return location;
    }

    public double getHappiness() {
        return happiness;
    }

    public void setHappiness(double happiness) {
        this.happiness = happiness;
    }
}
