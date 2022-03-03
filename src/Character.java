public class Character {
    private Company company;
    private String name;
    private Pop pop;

    public Character(Company company, String name, Pop pop) {
        this.company = company;
        this.name = name;
        this.pop = pop;
        pop.characterArrayPush(this);

    }

    public Character(String name, Pop pop) {

        this.name = name;
        this.pop = pop;
        pop.characterArrayPush(this);

    }

    public Character(String name) {

        this.name = name;

    }

    public String getName() {
        return name;
    }
}
