public class Market {
    private String name;
    private Nation leader;
    private Nation[] members;
    private Province[] provinces = new Province[0];
    private GoodAmt[] goods = new GoodAmt[0];

    public Market(String name, Nation leader, Nation[] members) {
        this.name = name;
        this.leader = leader;
        this.members = members;

    }


    public void goodArrayPush(GoodAmt input)
    {
        GoodAmt[] newArr = new GoodAmt[goods.length + 1];
        for(int i = 0; i < goods.length; i++)
        {
            newArr[i] = goods[i];
        }
        newArr[newArr.length - 1] = input;
        goods = newArr;
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

}
