public class main {

    private static main realMain = new main();
    private  Nation[] nations = new Nation[0];

    public static void main(String[] args) {


        Good banana = new Good("banana", 10, 1);
        Nation nation1 = new Nation(realMain, "United States of America");
        Market market1 = new Market("Bay Area", nation1, new Nation[]{nation1});
        Province province1 = new Province(nation1, 50.0, "Mountain View", market1);
        Province province2 = new Province(nation1, 30, "Redwood City", market1);
        Province province3 = new Province(nation1, 0, "San Mateo", market1);

        Pop pop1 = new Pop(50, province1, 150, 140);
        Pop pop2 = new Pop(30, province2, 1000, 500);
        Pop pop3 = new Pop(25, province1, 410, 340);
        Pop pop4 = new Pop(100, province3, 123, 53);
        Character char1 = new Character("Steve Job", pop2);
        Character char2 = new Character("Bill Gate", pop3);
        Character char3 = new Character("tim ", pop3);


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
