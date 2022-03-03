import java.util.ArrayList;

public class Pop {

    private double happiness;
    private Province location;
    private Character[] characters = new Character[0];
    private int population;
    private int dependents;
    private ArrayList<PopAmt> popGroups = new ArrayList<PopAmt>();


    public Pop (double happinessIn, Province locationIn, int populationIn, int dependentsIn)
    {
        happiness = happinessIn;
        location = locationIn;
        location.popArrayPush(this);
        population = populationIn;
        dependents = dependentsIn;
        popGroups.add(new PopAmt(population, this, location.getBuildings()[0]));
        location.getBuildings()[0].addWorkerGroup(popGroups.get(0));

    }




    public void characterArrayPush(Character input)
    {
        Character[] newArr = new Character[characters.length + 1];
        for(int i = 0; i < characters.length; i++)
        {
            newArr[i] = characters[i];
        }
        newArr[newArr.length - 1] = input;
        characters = newArr;
    }


    public String toString()
    {
        String txt = "This pop has a happiness of " + happiness + " and a population of " + population + ", " + dependents + " of which are dependents. They live in " + location.getName();
        if(characters.length > 0)
        {
            txt += ". Its characters are: ";
            for(Character character : characters)
            {
                txt += character.getName() + " ";
            }
        }

        return txt;
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
