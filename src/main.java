public class main {


    private Province[] provinces = new Province[0];

    public static void main(String[] args) {

        Province province1 = new Province( 50.0, "Mountain View");


        Pop pop1 = new Pop(50, province1, 150, 140);
        Pop pop2 = new Pop(30, province1, 1000, 500);

        for(Pop pop : province1.getPops())
        {
            System.out.println(pop);
        }

    }

    public Province[] provinceArrayPush(Province[] provs, Province input)
    {
        Province[] newArr = new Province[provs.length + 1];
        newArr[newArr.length - 1] = input;
        return newArr;
    }





}
