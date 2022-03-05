import org.ajbrown.namemachine.Gender;

public class Character {
    private Gender gender;
    private Company company;
    private String name;
    private Pop pop;

    public Character(Company company, String name, Pop pop, Gender gender) {
        this.company = company;
        this.name = name;
        this.pop = pop;
        this.gender = gender;
        pop.addCharacter(this);

    }

    public Character(String name, Pop pop) {

        this.name = name;
        this.pop = pop;
        pop.addCharacter(this);

    }

    public Character( Pop pop) {
        gender = randomGender();
        this.name = pop.getLocation().getNation().getGame().generateName(gender);
        this.pop = pop;
        pop.addCharacter(this);

    }

    public Gender randomGender()
    {
        int ran = (int)(Math.random() * 2);
        if(ran == 0)
        {
            return Gender.FEMALE;
        } else
        {
            return Gender.MALE;
        }



    }




    public Character(String name) {

        this.name = name;

    }

    public String getGenderName()
    {

        if(gender == gender.MALE)
        {
            return "MALE";
        } else
        {
            return "FEMALE";
        }

    }



    public String getName() {
        return name;
    }
}
