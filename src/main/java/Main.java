package main.java;

import java.util.Scanner;

public class Main {
    private static final String MENU_EXIT = "0";
    private static final String MENU_NEXT_STEP = "1";
    private static final String MENU_START_SIMULATION = "2";
    private static final String MENU_NEW_MAP = "3";

    private static final int PAUSE_ENDLESS_SIM = 1;
    private static final int CONTINUE_ENDLESS_SIM = 2;
    private static final int STOP_ENDLESS_SIM = 3;

    public static void main(String[] args) {
        Simulation simulation = new Simulation();

        System.out.println("Number of iteration: " + simulation.numberIteration);
        simulation.initWorld();
        simulation.drawMap();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Simulation!");
        System.out.println("=======================================");

        loopOfGame:
        while (true) {
            mainGameMenu();
            switch (scanner.next()) {
                case MENU_EXIT -> System.exit(0);
                case MENU_NEXT_STEP -> simulation.nextTurn();
                case MENU_START_SIMULATION -> {
                    while (true) {
                        int userInput = inputInSimulation();
                        if (userInput == STOP_ENDLESS_SIM) break loopOfGame;
                        if (userInput == CONTINUE_ENDLESS_SIM || userInput == -1) {
                            simulation.nextTurn();
                            System.out.println("You can enter: 1 - to pause, 2 - to continue, 3 - to exit");
                        }
                        if (userInput == PAUSE_ENDLESS_SIM) {
                            System.out.println("You can enter: 2 - to continue, 3 - to exit");
                            break;
                        }
                    }
                }

                case MENU_NEW_MAP -> {
                    System.out.println("\033[H\033[2J");
                    System.out.flush();
                    simulation = new Simulation();
                    simulation.initWorld();
                    simulation.drawMap();
                }
            }

        }
    }

    private static void mainGameMenu() {
        System.out.println("You can enter:");
        System.out.println("1 - Make one step of simulation");
        System.out.println("2 - Start endless simulation");
        System.out.println("3 - Generate a new map");
        System.out.println("0 - Exit");
    }

    private static int inputInSimulation() {
        try {
            Thread.sleep(3000);
            if (System.in.available() > 0) {
                Scanner scanner = new Scanner(System.in);
                int res = scanner.nextInt();
                if (res == PAUSE_ENDLESS_SIM || res == STOP_ENDLESS_SIM || res == CONTINUE_ENDLESS_SIM) return res;
                System.out.println("Введен не поддерживаемый символ");
                return -1;
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return -1;
    }

}