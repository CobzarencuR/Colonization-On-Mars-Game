import java.util.Random;

public abstract class Human implements Movement {
    String name;
    int age;
    boolean hasMoved;
    //  private  String status;
    int HP = 100;

    byte x;
    byte y;
    int HEV = 100;

    @Override
    public void moveUp() {
        if (x != 0) {
            this.x--;
        }
        if (this.x == 2 || this.x == 7 && this.y == 1 || this.y == 4 || this.y == 9) {
            System.out.println("You were infected by something!");
            System.out.println("Have the medic heal you or continue to explore!");
            this.HP -= 40;
        }
        if (this.x == 2 || this.x == 4 || this.x == 6 || this.x == 8 && this.y == 2 || this.y == 5 || this.y == 8) {
            System.out.println("You broke your arm!");
            System.out.println("Have the medic heal you or continue to explore!");
            this.HP -= 20;
        }
        if (this.x == 1 || this.x == 6 || this.x == 9 && this.y == 4 || this.y == 7) {
            System.out.println("Your suit has broken!");
            System.out.println("Have the engineer repair it or continue to explore!");
            this.HEV -= 40;
        }
        if (this.x == 1 || this.x == 3 || this.x == 5 || this.x == 8 && this.y == 1 || this.y == 3 || this.y == 6) {
            System.out.println("Your oxygen levels are dropping fast!");
            System.out.println("Have the engineer refill your tank or continue to explore!");
            this.HEV -= 20;
        }
    }

    @Override
    public void moveDown() {
        if (x != 9) {
            this.x++;
        }
        if (this.x == 2 || this.x == 7 && this.y == 1 || this.y == 4 || this.y == 9) {
            System.out.println("You were infected by something!");
            System.out.println("Have the medic heal you or continue to explore!");
            this.HP -= 40;
        }
        if (this.x == 2 || this.x == 4 || this.x == 6 || this.x == 8 && this.y == 2 || this.y == 5 || this.y == 8) {
            System.out.println("You broke your arm!");
            System.out.println("Have the medic heal you or continue to explore!");
            this.HP -= 20;
        }
        if (this.x == 1 || this.x == 6 || this.x == 9 && this.y == 4 || this.y == 7) {
            System.out.println("Your suit has broken!");
            System.out.println("Have the engineer repair it or continue to explore!");
            this.HEV -= 40;
        }
        if (this.x == 1 || this.x == 3 || this.x == 5 || this.x == 8 && this.y == 1 || this.y == 3 || this.y == 6) {
            System.out.println("Your oxygen levels are dropping fast!");
            System.out.println("Have the engineer refill your tank or continue to explore!");
            this.HEV -= 20;
        }
    }

    @Override
    public void moveLeft() {
        if (y != 0) {
            this.y--;
        }
        if (this.x == 2 || this.x == 7 && this.y == 1 || this.y == 4 || this.y == 9) {
            System.out.println("You were infected by something!");
            System.out.println("Have the medic heal you or continue to explore!");
            this.HP -= 40;
        }
        if (this.x == 2 || this.x == 4 || this.x == 6 || this.x == 8 && this.y == 2 || this.y == 5 || this.y == 8) {
            System.out.println("You broke your arm!");
            System.out.println("Have the medic heal you or continue to explore!");
            this.HP -= 20;
        }
        if (this.x == 1 || this.x == 6 || this.x == 9 && this.y == 4 || this.y == 7) {
            System.out.println("Your suit has broken!");
            System.out.println("Have the engineer repair it or continue to explore!");
            this.HEV -= 40;
        }
        if (this.x == 1 || this.x == 3 || this.x == 5 || this.x == 8 && this.y == 1 || this.y == 3 || this.y == 6) {
            System.out.println("Your oxygen levels are dropping fast!");
            System.out.println("Have the engineer refill your tank or continue to explore!");
            this.HEV -= 20;
        }
    }

    @Override
    public void moveRight() {
        if (y != 0) {
            this.y++;
        }
        if (this.x == 2 || this.x == 7 && this.y == 1 || this.y == 4 || this.y == 9) {
            System.out.println("You were infected by something!");
            System.out.println("Have the medic heal you or continue to explore!");
            this.HP -= 40;
        }
        if (this.x == 2 || this.x == 4 || this.x == 6 || this.x == 8 && this.y == 2 || this.y == 5 || this.y == 8) {
            System.out.println("You broke your arm!");
            System.out.println("Have the medic heal you or continue to explore!");
            this.HP -= 20;
        }
        if (this.x == 1 || this.x == 6 || this.x == 9 && this.y == 4 || this.y == 7) {
            System.out.println("Your suit has broken!");
            System.out.println("Have the engineer repair it or continue to explore!");
            this.HEV -= 40;
        }
        if (this.x == 1 || this.x == 3 || this.x == 5 || this.x == 8 && this.y == 1 || this.y == 3 || this.y == 6) {
            System.out.println("Your oxygen levels are dropping fast!");
            System.out.println("Have the engineer refill your tank or continue to explore!");
            this.HEV -= 20;
        }
    }

    static final String[] namesOfEngineers = {"John", "Michael", "Bill", "Liam", "Emma", "Noah", "Oliver", "Peter", "Chris",
            "Charlotte", "Ethan", "Elizabeth", "Sofia", "Lucas", "James", "Grace", "Alexander", "Chloe", "Daniel",
            "Roxane", "Robert", "David", "Samuel", "Lilly", "Joseph", "Henry", "Ella", "Penelope", "Amelia", "Evelyn"};

    static final String[] namesOfMedics = {
            "Alice", "Bob", "Charlie", "Rob", "Emily",
            "Frank", "Grace", "Henry", "Isabella", "Jack",
            "Katherine", "Ned", "Mia", "Noah", "Olivia",
            "Patrick", "Quinn", "Ruby", "Tyrion", "Tessa",
            "Ursula", "Victor", "Wendy", "Xavier", "Yara",
            "Zachary", "Irine", "Benjamin", "Chloe", "Daniel"
    };

    static final String[] namesOfColonists = {"Adam", "Alex", "Ramon", "Caleb", "Christopher",
            "Lore", "Gigel", "Ethan", "Elijah", "Gabriel",
            "Henry", "Isaac", "Jack", "Jacob", "James",
            "Walker", "Joseph", "Joshua", "Kyle", "Logan",
            "Lucas", "Matthew", "Gabriel", "Mason", "Nathan",
            "Noah", "Robert", "Owen", "Ryan", "Sheldon"};

    static final int[] ages = {24, 30, 18, 19, 21, 32, 25, 20, 22, 23};

    public static int generateAge() {
        Random random = new Random();
        int randomAge = ages[random.nextInt(ages.length)];
        return randomAge;
    }

    public static String generateName(String[] names) {
        Random random = new Random();
        String randomName = names[random.nextInt(names.length)];
        return randomName;
    }

}
