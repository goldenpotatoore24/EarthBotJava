import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class main {

    private static main realMain = new main();
    private  Nation[] nations = new Nation[0];
    private static int tick = 58;
    private static int mins = 0;
    private static int hours = 0;
    private static Market[] markets = new Market[0];
    private static ArrayList<Good> Goods = new ArrayList<Good>();


    public static void main(String[] args) {



        Goods.add(new Good("Banana", 20, 1));
        Goods.add(new Good("Unemployment Benefit", 0, 50));

        Nation nation1 = new Nation(realMain, "United States of America", new Character("joe boden"));
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
        Character char3 = new Character("tim", pop3);
        Company bananaCo = new Company(char1, "Banana Co.", province2);


        Building bananaMine = new Building(bananaCo, good("banana"), 0.5, province2);
        Building bananaMine2 = new Building(bananaCo, good("banana"), 0.5, province3);



        tick();





    }



public static void tick()
{
    ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    Runnable toRun = new Runnable() {
        public void run() {
            boolean minTick = false;
            boolean hourTick = false;
            tick++;
            System.out.println(tick);
            if(tick > 59)
            {
                tick = 0;
                mins++;
                minTick = true;
            } else minTick = false;
            if(mins > 59)
            {
                mins = 0;
                hours++;
                hourTick = true;
            } else hourTick = false;
            // ALL TIMED FXNS
            if(minTick)
            {
                System.out.println("Minute Tick");
                System.out.println("Building Production Tick Began");
                for(Building building : realMain.getAllBuildings())
                {

                    building.produce();

                }

                for(Market market : markets)
                {

                    System.out.println(market);
                }
            }







        }
    };
    ScheduledFuture<?> handle = scheduler.scheduleAtFixedRate(toRun, 1, 1, TimeUnit.SECONDS);

}

    public void addGoods(Good input)
    {

        Goods.add(input);

    }


    public void nationArrayPush(Nation input)
    {
        Nation[] newArr = new Nation[nations.length + 1];
        for(int i = 0; i < nations.length; i++)
        {
            newArr[i] = nations[i];
        }
        newArr[newArr.length - 1] = input;
        nations = newArr;
    }

    public Building[] getAllBuildings()
    {
       Building[] allBuildings = new Building[0];

        for(Nation nation : nations)
        {
            for(Province province : nation.getProvinces())
            {
                for(Building building : province.getBuildings())
                {
                    allBuildings = buildingArrayPush(allBuildings, building);
                }
            }
        }
        return allBuildings;
    }


    public static Good good(String name)
    {
        for(int i = 0; i < Goods.size(); i++)
        {
            if(Goods.get(i).getType().equalsIgnoreCase(name))
            {
                return Goods.get(i);
            }
        }
        return null;
    }



    public Province[] getAllProvinces()
    {
        Province[] allProvinces = new Province[0];

        for(Nation nation : nations)
        {
            for(Province province : nation.getProvinces())
            {

                    allProvinces = provinceArrayPush(allProvinces, province);

            }
        }
        return allProvinces;
    }

    public void marketArrayPush(Market input)
    {
        Market[] newArr = new Market[markets.length + 1];
        for(int i = 0; i < markets.length; i++)
        {
            newArr[i] = markets[i];
        }
        newArr[newArr.length - 1] = input;
        markets = newArr;
    }

    public Building[] buildingArrayPush(Building[] buildings, Building input)
    {
        Building[] newArr = new Building[buildings.length + 1];
        for(int i = 0; i < buildings.length; i++)
        {
            newArr[i] = buildings[i];
        }
        newArr[newArr.length - 1] = input;
        return newArr;
    }

    public Province[] provinceArrayPush(Province[] provinces, Province input)
    {
        Province[] newArr = new Province[provinces.length + 1];
        for(int i = 0; i < provinces.length; i++)
        {
            newArr[i] = provinces[i];
        }
        newArr[newArr.length - 1] = input;
        return newArr;
    }

}
