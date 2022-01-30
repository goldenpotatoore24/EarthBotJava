public class Pop {

    private double happiness;
    private Province location;

    public Pop (double happinessIn, Province locationIn)
    {
        happiness = happinessIn;
        location = locationIn;

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
