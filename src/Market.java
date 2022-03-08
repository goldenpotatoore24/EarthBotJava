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
        leader.getGame().marketArrayPush(this);

    }


    public void goodArrayPush(GoodAmt input)
    {
        if(input.getAmt() > 0) {
            boolean alreadyExists = false;
            for (GoodAmt good : goods) {
                if (good.getProducer() == input.getProducer() && input.getGood() == input.getGood()) {
                    alreadyExists = true;
                    good.addGoods(input.getAmt());
                }
            }
            if (!alreadyExists) {
                GoodAmt[] newArr = new GoodAmt[goods.length + 1];
                for (int i = 0; i < goods.length; i++) {
                    newArr[i] = goods[i];
                }
                newArr[newArr.length - 1] = input;
                goods = newArr;
            }
        }
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


}
