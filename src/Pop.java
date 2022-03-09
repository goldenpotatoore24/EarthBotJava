import java.util.ArrayList;

public class Pop {

    private double happiness;
    private Province location;
    private ArrayList<Character> characters = new ArrayList<Character>();
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
        popGroups.add(new PopAmt(population - dependents, this, location.getBuildings()[0].getPositions().get(0)));
        location.getBuildings()[0].addWorkers(popGroups.get(0));

    }



    public void populateCharacters()
    {
        if(characters.size() < 5)
        {
            for(int i = characters.size(); i < 5; i++)
            {
                characters.add(new Character(this));
                System.out.println("Created new " + characters.get(characters.size() -1).getGenderName() + " Character in " + location.getName() + " named " + characters.get(characters.size() -1).getName());
            }
        }

    }

    public ArrayList<PopAmt> getPopGroups() {
        return popGroups;
    }

    public void addWorkers(Job job, int amt)
    {
        boolean hasFound = false;
        for(int i = 0; i < popGroups.size(); i++)
        {
            if(popGroups.get(i).getJob().equals(job))
            {
                hasFound = true;
                popGroups.get(0).setAmt(popGroups.get(0).getAmt() - amt);
                popGroups.get(i).setAmt(popGroups.get(i).getAmt() + amt);
            }
        }
        if(!hasFound)
        {
            PopAmt newGroup = new PopAmt(amt, this, job);
            popGroups.add(newGroup);
            job.getBuilding().addWorkers(newGroup);
        }
    }


    public void addCharacter(Character input)
    {

        characters.add(input);

    }




    public String toString()
    {
        String txt = "This pop has a happiness of " + happiness + " and a population of " + population + ", " + dependents + " of which are dependents. They live in " + location.getName();
        if(characters.size() > 0)
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
