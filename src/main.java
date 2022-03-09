import org.ajbrown.namemachine.Gender;
import org.ajbrown.namemachine.NameGenerator;
import java.util.ArrayList;
import java.util.concurrent.*;

public class main {

    private static main realMain = new main();
    private static Nation[] nations = new Nation[0];
    private static int tick = 58;
    private static int mins = 0;
    private static int hours = 0;
    private static Market[] markets = new Market[0];
    private static ArrayList<Good> Goods = new ArrayList<Good>();


    public static void main(String[] args) {



        Goods.add(new Good("Banana", 20, 1));
        Goods.add(new Good("Unemployment Benefit", 0, 1000));

        Nation nation1 = new Nation(realMain, "United States of America", new Character("joe boden"));
        Market market1 = new Market("Bay Area", nation1, new Nation[]{nation1});
        Province province1 = new Province(nation1, 50.0, "Mountain View", market1);
        Province province2 = new Province(nation1, 30, "Redwood City", market1);
        Province province3 = new Province(nation1, 0, "San Mateo", market1);

        Pop pop1 = new Pop(50, province1, 150, 140);
        Pop pop2 = new Pop(30, province2, 10000000, 3000000);
        Pop pop3 = new Pop(25, province1, 700 , 234);
        Pop pop4 = new Pop(100, province3, 5000000, 1000000);

        Character char1 = new Character("Steve Job", pop2);
        Character char2 = new Character("Bill Gate", pop3);
        Character char3 = new Character("tim", pop3);
        Company bananaCo = new Company(char1, "Banana Co.", nation1);


        Building bananaMine = new Building(bananaCo, good("banana"), 0.5, province2);
        Building bananaMine2 = new Building(bananaCo, good("banana"), 0.5, province3);

       /* for(int i = 0; i < getAllPops().size(); i++)
        {
            getAllPops().get(i).populateCharacters();
        }

        */


        tick();





    }

    private static ArrayList<Pop> getAllPops()
    {
        ArrayList<Pop> allPops = new ArrayList<Pop>();
        for(int i = 0; i < getAllProvinces().length; i++)
        {
            for(int k = 0; k < getAllProvinces()[i].getPops().length; k++)
            {
                allPops.add(getAllProvinces()[i].getPops()[k]);
            }
        }
        return allPops;

    }


    public static void tick()
{
    ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    Runnable toRun = new Runnable() {
        public void run() {
            boolean minTick = false;
            boolean hourTick = false;
            tick += 30;
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

                for(int i = 0; i < getAllCompanies().size(); i++)
                {
                    getAllCompanies().get(i).pay();
                }

                for(Building building : realMain.getAllBuildings())
                {

                    building.produce();
                    building.hire();

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

    public static void addGoods(Good input)
    {

        Goods.add(input);

    }

    public static ArrayList<Company> getAllCompanies()
    {
        ArrayList allCompanies = new ArrayList<Company>();
        for(int i = 0; i < nations.length; i++)
        {
            Nation currentNation = nations[i];
            for(int k = 0; k < currentNation.getCompanies().size(); k++)
            {
                Company currentCompany = currentNation.getCompanies().get(k);
                allCompanies.add(currentCompany);
            }
        }
        return allCompanies;
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

    public static String generateName(Gender gender)
    {
        NameGenerator generator = new NameGenerator();
        return generator.generateName(gender).toString();

    }

    public static String generateName()
    {
        NameGenerator generator = new NameGenerator();
    return generator.generateName().toString();

    }



    public static Province[] getAllProvinces()
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

    public static Province[] provinceArrayPush(Province[] provinces, Province input)
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
