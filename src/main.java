public class main {

    private static main realMain = new main();
    private  Nation[] nations = new Nation[0];

    public static void main(String[] args) {


        Nation nation1 = new Nation(realMain, "United States of America");
        Province province1 = new Province(nation1, 50.0, "Mountain View");
        Province province2 = new Province(nation1, 30, "Redwood City");
        Province province3 = new Province(nation1, 0, "San Mateo");

        Pop pop1 = new Pop(50, province1, 150, 140);
        Pop pop2 = new Pop(30, province2, 1000, 500);

        for(Nation nation : realMain.nations) {

            for(Province province : nation.getProvinces())
            {
                for (Pop pop : province.getPops()) {
                System.out.println(pop);
            }
            }

        }

    }




    public  void nationArrayPush(Nation input)
    {
        Nation[] newArr = new Nation[nations.length + 1];
        for(int i = 0; i < nations.length; i++)
        {
            newArr[i] = nations[i];
        }
        newArr[newArr.length - 1] = input;
        nations = newArr;
    }





}
