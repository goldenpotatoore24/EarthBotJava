import java.util.ArrayList;

public class Market {
    private String name;
    private Nation leader;
    private Nation[] members;
    private Province[] provinces = new Province[0];
    private ArrayList<GoodAmt> goods = new ArrayList<GoodAmt>();

    public Market(String name, Nation leader, Nation[] members) {
        this.name = name;
        this.leader = leader;
        this.members = members;
        leader.getGame().marketArrayPush(this);

    }


    public void goodArrayPush(GoodAmt input)
    {
        goods.add(input);
    }
    public void provinceArrayPush(Province input)
    {
        Province[] newArr = new Province[provinces.length + 1];
        for(int i = 0; i < provinces.length; i++)
        {
            newArr[i] = provinces[i];
        }
        newArr[newArr.length - 1] = input;
        provinces = newArr;
    }

    public String toString()
    {
        String txt = "Market " + name + " has";
        for(GoodAmt good : goods)
        {
            txt += " " + good.getAmt() + " " + good.getGood().getType() + "s from " + good.getProducer().getOwner().getName() + " in " + good.getProducer().getLocation().getName();
        }
        return txt;

    }

    public void sellAll()
    {
        for(int i = 0; i < goods.size(); i++)
        {
            goods.get(i).getProducer().getOwner().addMoneyReserves(goods.get(i).getValue());
            goods.remove(i);
            i--;
        }
    }


}
