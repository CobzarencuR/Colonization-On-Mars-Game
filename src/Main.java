import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Tile[][] Mars = new Tile[10][10];

    public static void printTable() {
        for (byte i = 0; i < 10; i++) {
            for (byte j = 0; j < 10; j++) {
                if (Mars[i][j].presents.size() == 0 && !Mars[i][j].explored) {
                    System.out.print("[  ?  ]" + " ");
                } else if (Mars[i][j].presents.size() != 0) {
                    System.out.print("[ ");
                    for (Human object : Mars[i][j].presents) {
                        System.out.print(object.name + " ");
                    }
                    System.out.print("]");
                } else if (Mars[i][j].presents.size() == 0 && Mars[i][j].explored) {
                    System.out.print("[     ]" + " ");
                }
            }
            System.out.println();
        }
    }

    public static void printteam(ArrayList<? extends Human> inarr) {
        for (Human colonist : inarr) {
            if (colonist.HP > 0) {
                System.out.println(colonist.name + ", " + colonist.age + " y/o " + colonist.HP + "/100 HP" + " " + colonist.HEV + "/100 HEV");
            } else {
                System.out.println(colonist.name + " DEAD");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int turnnumber = 1;
        System.out.println("Welcome to Mars Colonization!Please type START to start the game, or type HELP for a list of commands and tips.");
        Scanner scan = new Scanner(System.in);
        String variabileStart = scan.next();
        variabileStart = variabileStart.toUpperCase();
        if (variabileStart.equals("HELP")) {
            System.out.println("Your objective is to explore Mars.");
            System.out.println("Every turn, you can see your team and their status at the top.");
            System.out.println("You win if you explore all of Mars. You lose if your colonists die.");
            System.out.println("Select a team member using the \"select\" command.");
            System.out.println("Once a team member is selected, use \"moveup\", \"movedown\",\"moveleft\" or \"moveright\" to move. Astronauts cannot move more than once in a turn.");
            System.out.println("Unexplored tiles are marked with ?, explore them by moving a Colonist over them.");
            System.out.println("Medics may heal other Astronauts using the \"heal\" command, Engineers may repair other Astronauts suits using the \"repair\" command");
            System.out.println("If your suit breaks, you can't move until it is repaired.");
            System.out.println("Once you are ready to proceed, use the \"NextTurn\" command to move on to the next turn.");
            System.out.println("You can end the game at any time using the \"exit\" command");

        }
        while (!variabileStart.equals("START")) {
            System.out.println("Please type START to start the game: ");
            variabileStart = scan.next();
            variabileStart = variabileStart.toUpperCase();
        }

        System.out.println("Please choose how many engineers do you want: ");
        Scanner scan1 = new Scanner(System.in);
        int numberOfEngineers = scan.nextInt();
        while (numberOfEngineers <= 0) {
            System.out.println("Please introduce a number of engineers greater than 0");
            numberOfEngineers = scan.nextInt();
        }

        System.out.println("Please choose how many medics do you want: ");
        Scanner scan2 = new Scanner(System.in);
        int numberOfMedics = scan.nextInt();
        while (numberOfMedics <= 0) {
            System.out.println("Please introduce a number of medics greater than 0");
            numberOfMedics = scan.nextInt();
        }

        System.out.println("Please choose how many colonists do you want: ");
        Scanner scan3 = new Scanner(System.in);
        int numberOfColonists = scan.nextInt();
        while (numberOfColonists <= 0) {
            System.out.println("Please introduce a number of colonist greater than 0");
            numberOfColonists = scan.nextInt();
        }
        for (byte i = 0; i < 10; i++) {
            for (byte j = 0; j < 10; j++) {
                Mars[i][j] = new Tile(i, j);
                Mars[i][j].explored = false;
            }
        }
        Mars[4][4].explored = true;

        int numberOfAstronauts = numberOfColonists + numberOfMedics + numberOfEngineers;
        ArrayList<Human> Astronauts = new ArrayList<>(numberOfAstronauts);
        ArrayList<Engineer> engineers = new ArrayList<>(numberOfEngineers);
        ArrayList<Medic> medics = new ArrayList<>(numberOfMedics);
        ArrayList<Colonist> colonists = new ArrayList<>(numberOfColonists);

        System.out.println("-------------------------------------------");
        System.out.println("Your team:");

        System.out.println("Engineers:");
        for (int i = 0; i < numberOfEngineers; i++) {
            Engineer e1 = new Engineer((byte) 4, (byte) 4, Engineer.generateName(Human.namesOfEngineers), Engineer.generateAge());
            engineers.add(e1);
            Astronauts.add(e1);
            Mars[4][4].presents.add(e1);
        }
        printteam(engineers);

        System.out.println("Medics:");
        for (int i = 0; i < numberOfMedics; i++) {
            Medic m1 = new Medic((byte) 4, (byte) 4, Medic.generateName(Human.namesOfMedics), Medic.generateAge());
            medics.add(m1);
            Astronauts.add(m1);
            Mars[4][4].presents.add(m1);
        }
        printteam(medics);

        System.out.println("Colonists:");
        for (int i = 0; i < numberOfColonists; i++) {
            Colonist c1 = new Colonist((byte) 4, (byte) 4, Colonist.generateName(Human.namesOfColonists), Colonist.generateAge());
            colonists.add(c1);
            Astronauts.add(c1);
            Mars[4][4].presents.add(c1);
        }
        printteam(colonists);


        System.out.println("It's time to explore!");
        Human SelectedMember = null;
        boolean oktocontinue = false;
        boolean firstprint = true;
        while (true) {
            boolean gameover = false;
            if (colonists.size() == 0) {
                gameover = true;
            }

            while (true) {
                int deadindex = 0;
                Human dead = null;
                for(int i=0;i<Astronauts.size();i++){
                    if(Astronauts.get(i).HP<=0) {
                        deadindex=i;
                        dead = Astronauts.get(i);
                        Mars[Astronauts.get(deadindex).x][Astronauts.get(deadindex).y].presents.remove(dead);
                        Astronauts.remove(i);
                        for(int k=0; k<numberOfColonists; k++){
                            colonists.remove(dead);
                        }
                        for(int l=0; l<numberOfEngineers; l++){
                            engineers.remove(dead);
                        }
                        for(int m=0; m<numberOfMedics; m++){
                            medics.remove(dead);
                        }
                        break;
                    }
                }


                if(!firstprint) {
                    System.out.println("-------------------------------------------");
                    System.out.println("TURN " + turnnumber);
                    System.out.println("Your team:");
                    System.out.println("Medics:");
                    printteam(medics);
                    System.out.println("Engineers:");
                    printteam(engineers);
                    System.out.println("Colonists:");
                    printteam(colonists);
                }
                firstprint = false;
                printTable();
                if (oktocontinue) {
                    for (Human astro : Astronauts) {
                        astro.hasMoved = false;
                        if (astro.HEV < 40) {
                            astro.hasMoved = true;
                        }
                    }
                }
                oktocontinue=false;

                Scanner command = new Scanner(System.in);
                String commandText = scan.next();

                switch (commandText.toLowerCase()) {
                    case "select" -> {
                        System.out.println("Select a team member.");
                        oktocontinue = false;
                        if (commandText.equalsIgnoreCase("Select")) {
                            String argument = command.next();
                            if (!argument.isEmpty()) {
                                for (Human astro : Astronauts) {
                                    if (astro.name.equals(argument)) {
                                        SelectedMember = astro;
                                        break;
                                    }
                                }
                            } else {
                                System.out.println("Invalid command. Please provide a name after 'select'.");
                            }
                            if (SelectedMember != null && SelectedMember.HP > 0) {
                                System.out.println("Selected " + SelectedMember.name);
                            } else {
                                System.out.println("Can't find " + argument);
                            }
                        }
                    }
                    case "nextturn" -> oktocontinue = true;
                    case "moveup" -> {
                        if (SelectedMember.isColonist() && !SelectedMember.hasMoved) {
                            Mars[SelectedMember.x][SelectedMember.y].presents.remove(SelectedMember);
                            SelectedMember.moveUp();
                            Mars[SelectedMember.x][SelectedMember.y].presents.add(SelectedMember);
                            Mars[SelectedMember.x][SelectedMember.y].explored = true;
                            SelectedMember.hasMoved = true;
                            printTable();
                        } else if (!SelectedMember.hasMoved && Mars[SelectedMember.x - 1][SelectedMember.y].explored) {
                            Mars[SelectedMember.x][SelectedMember.y].presents.remove(SelectedMember);
                            SelectedMember.moveUp();
                            Mars[SelectedMember.x][SelectedMember.y].presents.add(SelectedMember);
                            Mars[SelectedMember.x][SelectedMember.y].explored = true;
                            SelectedMember.hasMoved = true;
                            printTable();
                        } else if (SelectedMember.hasMoved) {
                            System.out.println(SelectedMember.name + " can't move");
                        } else if (!Mars[SelectedMember.x - 1][SelectedMember.y].explored && !SelectedMember.isColonist()) {
                            System.out.println("Only colonists can explore");
                            SelectedMember = null;
                        } else if (SelectedMember == null) {
                            System.out.println("Select a team member first");
                        }

                    }
                    case "movedown" -> {
                        if (SelectedMember.isColonist() && !SelectedMember.hasMoved) {
                            Mars[SelectedMember.x][SelectedMember.y].presents.remove(SelectedMember);
                            SelectedMember.moveDown();
                            Mars[SelectedMember.x][SelectedMember.y].presents.add(SelectedMember);
                            Mars[SelectedMember.x][SelectedMember.y].explored = true;
                            SelectedMember.hasMoved = true;
                            printTable();

                        } else if (!SelectedMember.hasMoved && Mars[SelectedMember.x + 1][SelectedMember.y].explored) {
                            Mars[SelectedMember.x][SelectedMember.y].presents.remove(SelectedMember);
                            SelectedMember.moveDown();
                            Mars[SelectedMember.x][SelectedMember.y].presents.add(SelectedMember);
                            Mars[SelectedMember.x ][SelectedMember.y].explored = true;
                            SelectedMember.hasMoved = true;
                            printTable();

                        } else if (SelectedMember.hasMoved) {
                            System.out.println(SelectedMember.name + " can't move");
                        } else if (!Mars[SelectedMember.x + 1][SelectedMember.y].explored && !SelectedMember.isColonist()) {
                            System.out.println("Only colonists can explore");
                            SelectedMember = null;
                        } else if (SelectedMember == null) {
                            System.out.println("Select a team member first");
                        }

                    }
                    case "moveleft" -> {
                        if (SelectedMember.isColonist() && !SelectedMember.hasMoved) {
                            Mars[SelectedMember.x][SelectedMember.y].presents.remove(SelectedMember);
                            SelectedMember.moveLeft();
                            Mars[SelectedMember.x][SelectedMember.y].presents.add(SelectedMember);
                            Mars[SelectedMember.x][SelectedMember.y].explored = true;
                            SelectedMember.hasMoved = true;
                            printTable();

                        } else if (!SelectedMember.hasMoved && Mars[SelectedMember.x][SelectedMember.y - 1].explored) {
                            Mars[SelectedMember.x][SelectedMember.y].presents.remove(SelectedMember);
                            SelectedMember.moveLeft();
                            Mars[SelectedMember.x][SelectedMember.y].presents.add(SelectedMember);
                            Mars[SelectedMember.x][SelectedMember.y].explored = true;
                            SelectedMember.hasMoved = true;
                            printTable();

                        } else if (SelectedMember.hasMoved) {
                            System.out.println(SelectedMember.name + " can't move");
                        } else if (!Mars[SelectedMember.x][SelectedMember.y - 1].explored && !SelectedMember.isColonist()) {
                            System.out.println("Only colonists can explore");
                            SelectedMember = null;
                        } else if (SelectedMember == null) {
                            System.out.println("Select a team member first");
                        }

                    }
                    case "moveright" -> {
                        if (SelectedMember.isColonist() && !SelectedMember.hasMoved) {
                            Mars[SelectedMember.x][SelectedMember.y].presents.remove(SelectedMember);
                            SelectedMember.moveRight();
                            Mars[SelectedMember.x][SelectedMember.y].presents.add(SelectedMember);
                            Mars[SelectedMember.x][SelectedMember.y].explored = true;
                            SelectedMember.hasMoved = true;
                            printTable();

                        } else if (!SelectedMember.hasMoved && Mars[SelectedMember.x][SelectedMember.y + 1].explored) {
                            Mars[SelectedMember.x][SelectedMember.y].presents.remove(SelectedMember);
                            SelectedMember.moveRight();
                            Mars[SelectedMember.x][SelectedMember.y].presents.add(SelectedMember);
                            Mars[SelectedMember.x][SelectedMember.y].explored = true;
                            SelectedMember.hasMoved = true;
                            printTable();

                        } else if (SelectedMember.hasMoved) {
                            System.out.println(SelectedMember.name + " can't move");
                        } else if (!Mars[SelectedMember.x][SelectedMember.y + 1].explored && !SelectedMember.isColonist()) {
                            System.out.println("Only colonists can explore");
                            SelectedMember = null;
                        } else if (SelectedMember == null) {
                            System.out.println("Select a team member first");
                        }

                    }
                    case "heal" -> {
                        if (SelectedMember.isMedic()) {
                            Medic SelectedMedic = (Medic) SelectedMember;
                            String argument = command.next();
                            if (!argument.isEmpty()) {
                                for (Human astro : Mars[SelectedMedic.x][SelectedMedic.y].presents) {
                                    if (astro.name.equals(argument)) {
                                        SelectedMember = astro;
                                        break;
                                    } else {
                                        SelectedMember = null;
                                    }
                                }
                            } else {
                                System.out.println("Can't find " + argument);
                                break;
                            }
                            if (SelectedMember != null && SelectedMember.HP > 0) {
                                SelectedMedic.heal(SelectedMember);
                                System.out.println("Healed " + SelectedMember.name);
                            }
                        } else {
                            System.out.println(SelectedMember.name + " is not a medic");
                        }
                    }

                    case "repair" -> {
                        if (SelectedMember.isEnginner()) {
                            Engineer SelectedMedic = (Engineer) SelectedMember;
                            String argument = command.next();
                            if (!argument.isEmpty()) {
                                for (Human astro : Mars[SelectedMedic.x][SelectedMedic.y].presents) {
                                    if (astro.name.equals(argument)) {
                                        SelectedMember = astro;
                                        break;
                                    } else {
                                        SelectedMember = null;
                                    }
                                }
                            } else {
                                System.out.println("Can't find " + argument);
                                break;
                            }
                            if (SelectedMember != null && SelectedMember.HP > 0) {
                                SelectedMedic.repair(SelectedMember);
                                System.out.println("Repaired " + SelectedMember.name + "'s suit");
                            }
                        } else {
                            System.out.println(SelectedMember.name + " is not an Engineer");
                        }
                    }
                    case "exit" -> {
                        oktocontinue = true;
                        gameover = true;
                    }
                    default -> {
                        System.out.println("Invalid command. Please try again.");
                        oktocontinue = false;
                    }
                }
                if (oktocontinue) {
                    turnnumber++;
                    break;
                }
            }

            for (byte i = 0; i < 10; i++) {
                for (byte j = 0; j < 10; j++) {
                    if(!Mars[i][j].explored) {
                        break;
                    }
                    System.out.println("YOU WON!");
                    gameover =true;
                }
            }

            if(colonists.size() == 0){
                gameover = true;
                System.out.println("GAME OVER");
            }

            if (gameover) {
                System.out.println("Exiting game...");
                break;
            }

        }
    }

}
