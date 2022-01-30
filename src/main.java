public class main {


    public static void main(String[] args) {

        Province province1 = new Province(50.0, "Mountain View");

        Pop pop1 = new Pop(50, province1, 150, 140);

        System.out.println(pop1);

    }


}
