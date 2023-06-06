import java.util.Scanner;

public class Colonist extends Human {

    public Colonist(byte x, byte y, String name, int age) {
        this.x = x;
        this.y = y;
        this.name = name;
        this.age = age;
        this.hasMoved=false;
    }

    public void explore() {
        System.out.println("It's time to explore!You have to choose which area you want!");
        System.out.println("Area 1 it's called Demacia");
        System.out.println("Area 2 it's called Yonia");
        System.out.println("Area 3 it's called Noxus");
        System.out.println("Please type 1,2 or 3 to start exploring: ");
        Scanner scan = new Scanner(System.in);
        int option = scan.nextInt();
        switch (option) {
            case 1:
                HP = (byte) (HP - 20);
                HEV = HEV - 40;
                System.out.println("You've arrived in Demacia!Your oxygen level is runnig low.It's " + HEV);
                System.out.println("You need a doctor!");
                System.out.println("Your HP level is " + HP);
                if (x == 2 || y == 2) {
                    System.out.println("Your treatment is almost here!");
                    HP = 100;
                } else {
                    System.out.println("I'm sorry!You are DEAD!");
                    HP = 0;
                }
                break;
            case 2:
                System.out.println("You've arrived in Yonia!");
                System.out.println("Pair with an enginner to complete the quest");
                System.out.println("Go to START and wait from the other player");
                setPosition();
                break;
            case 3:
                System.out.println("You've arrived in Noxus!");
                System.out.println("Move a position to the left");
                //moveLeftPlayer();
                break;
            default:
                throw new IllegalArgumentException("Please retype your option!");
        }

    }

    public void setPosition() {
        this.x = 4;
        this.y = 4;
    }
    @Override
    public boolean isColonist() {
        return true;
    }
    public boolean isEnginner() {
        return false;
    }
    public boolean isMedic() {
        return false;
    }
}
