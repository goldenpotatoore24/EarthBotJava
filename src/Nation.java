public class Nation {
    private main game;
    private String name;
    private Province provinces[] = new Province[0];


    public Nation(main game, String name) {
        this.game = game;
        this.name = name;
        game.nationArrayPush(this);

    }

    public Province[] getProvinces() {
        return provinces;
    }

    public main getGame() {
        return game;
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
