public class Pop {

    private double happiness;
    private Province location;
    private Character[] characters = new Character[0];

    public Pop (double happinessIn, Province locationIn)
    {
        happiness = happinessIn;
        location = locationIn;

    }




    public Character[] charArrayPush(Character[] chars, Character input)
    {
       Character[] newArr = new Character[chars.length + 1];
       newArr[newArr.length - 1] = input;
        return newArr;
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
