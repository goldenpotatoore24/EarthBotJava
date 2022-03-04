public class Company {

    private Character headOfCompany;
    private String name;
    private Province headQuarters;
    private Building[] buildings = new Building[0];

    public Company(Character headOfCompany, String name, Province headQuarters) {
        this.headOfCompany = headOfCompany;
        this.name = name;
        this.headQuarters = headQuarters;
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

    public String getName() {
        return name;
    }
}
