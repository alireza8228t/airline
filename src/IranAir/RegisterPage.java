package IranAir;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class RegisterPage {
    private List<IranAir.User> users;
    private User user;

    private FlightGenerator flightGenerator;

    ConsoleColors color = new ConsoleColors();
    Scanner input = new Scanner(System.in);

    public RegisterPage() {
        users = new ArrayList<>();
        flightGenerator = new FlightGenerator();
    }


    /**
     * The first page for register or login
     */
    public void welcomePage () {

        System.out.printf(color.BLUE + "*.*.*.*.*.*.*.*.*.* " + color.BLUE_BRIGHT + "%s" + color.BLUE + ".*.*.*.*.*.*.*.*.*\n", "Welcome to iranAir site");
        System.out.println(color.PURPLE + "\n-user panel: " + "\n");
        System.out.printf(color.YELLOW_BRIGHT + "-Enter #%d to Register or #%d to Login or #%d to exit: ", 1, 2, 3);

        int RegLogNumber = input.nextInt();

        /** Register section*/
        if (RegLogNumber == 1) {
            registerUser();
        }
        /** Login section */
        else if (RegLogNumber == 2) {
            loginPage();
        }
        /** show user and password */
        else if (RegLogNumber == 3) {
            System.exit(0);
        }


    }

    /**
     * Register user section
     */
    public void registerUser() {
        for (int i = 0; i < 12; i++) {
            System.out.println("");
        }

        System.out.printf(color.BLUE_BRIGHT + "*,*,*,*,*,*,*,**,*, %s *,*,*,*,*,*,*,*,*,*\n", "Register New User");

        System.out.print(color.GREEN_BRIGHT + "Enter your UserName: ");
        String userName = input.next();

        for (User user : users) {
            if (user != null) {
                if (user.getUserName().equals(userName)) {
                    System.out.println(color.RED + "This username is already used! press 0 to try again or press 9 to back");
                    int number = input.nextInt();
                    if (number == 0)
                        registerUser();
                    else
                        welcomePage();

                }
            }
        }

        System.out.print(color.GREEN_BRIGHT + "Enter your Password: ");
        String passWord = input.next();

        user = new User(userName, passWord);
        users.add(user);

        for (int i = 0; i < 8; i++) {
            System.out.println("");
        }

        mainMenu(user);

    }

    /**
     * Login page section
     */
    public void loginPage() {
        for (int i = 0; i < 12; i++) {
            System.out.println("");
        }

        System.out.printf(color.BLUE_BRIGHT + "*,*,*,*,*,*,*,*,**,*, %s ,*,*,*,*,*,*,*,*,*,*,\n", "Login User");

        System.out.print(color.GREEN_BRIGHT + "Enter your UserName: ");
        String userName = input.next();

        System.out.print(color.GREEN_BRIGHT + "Enter your PassWord: ");
        String passWord = input.next();

        for (User us : users) {
            if (us.getUserName().equals(userName) && us.getPassWord().equals(passWord)) {
                mainMenu(us);
                return;
            }
        }

        System.out.println(color.RED + "Invalid userName or password\n" + color.GREEN_BRIGHT + "press 0 to try again or press 9 to back");
        int number = input.nextInt();
        if (number == 0)
            loginPage();
        else if (number == 9)
            welcomePage();

        for (int i = 0; i < 8; i++) {
            System.out.println("");
        }
    }

    /**
     * user guide panel
     * @param user
     */
    public void mainMenu(User user) {
        for (int i = 0; i < 8; i++) {
            System.out.println("");
        }

        System.out.println(color.BLUE_BRIGHT + "*.*.*.*.*.*.*.*.* Welcome to IranAir Website *.*.*.*.*.*.*.*\n");
        System.out.println(color.CYAN + "Guidance panel\n");

        System.out.println(color.GREEN_BRIGHT + "* Enter #1 to show list of all flights\n");
        System.out.println(color.GREEN_BRIGHT + "* Enter #2 to search flights\n");
        System.out.println(color.GREEN_BRIGHT + "* Enter #3 to show your flight\n");
        System.out.println(color.GREEN_BRIGHT + "* Enter #4 to logout\n");

        System.out.println(color.YELLOW + "Please select one above: ");
        int number = input.nextInt();

        if (number == 1) {
            listOfAllFlights();
        }

        else if (number == 2) {
            searchFlight(user);
        }
        else if (number == 3) {
            userShowFlights(user);
        }
        else if (number == 4) {
            welcomePage();
        }

        else {
            mainMenu(user);
        }
        for (int i = 0; i < 8; i++) {
            System.out.println("");
        }

    }

    /**
     * Just show all flights
     */
    public void listOfAllFlights() {
        flightGenerator.showList();
        System.out.println(color.CYAN_BOLD + "Press 0 to go to guide panel");
        int number = input.nextInt();
        if (number == 0)
            mainMenu(user);
        else
            listOfAllFlights();
    }

    /**
     * Search flight and add to userTickets
     * @param user
     */
    public void searchFlight(User user) {
        flightGenerator.showList();

        System.out.println(color.BLUE_BRIGHT + "*,*,*,*,* Search Flight *.*.*.*.*.*\n");
        System.out.println("Let's see where do you want to go: \n");
        System.out.println(color.YELLOW + "\nFrom: ");
        String origin = input.next();

        for (Flight flightList : flightGenerator.getFlights()) {
            if (flightList.getOrigin().equals(origin)) {
                flightGenerator.showBySpecificOrigin(origin);
                System.out.println(color.YELLOW + "\nTo: ");
                String destination = input.next();
                for (Flight flightl : flightGenerator.getFlights()) {
                    if (flightl.getDestination().equals(destination)) {
                        flightGenerator.showBySpecificDestination(origin, destination);
                        System.out.println(color.YELLOW + "\nDay of departure: ");
                        String day = input.next();
                        for (Flight fli : flightGenerator.getFlights()) {
                            if (fli.getDay().equals(day)) {
                                flightGenerator.showBySpecificDay(origin, destination, day);
                                System.out.println(color.YELLOW + "\nTime of departure: ");
                                int time = input.nextInt();
                                for (Flight flig : flightGenerator.getFlights()) {
                                    if (flig.getTime() == time) {
                                        flightGenerator.showBySpecificTime(origin, destination, day, time);
                                        System.out.println(color.CYAN_BOLD + "Press 9 to add this ticket or 0 to back to menu: ");
                                        int chooseNumber = input.nextInt();
                                        if (chooseNumber == 9) {
                                            user.addFlight(flightGenerator.showBySpecificTime(origin, destination, day, time));
                                            System.out.println(color.CYAN_BRIGHT + "Flight is added successfully! press 0");
                                            int number = input.nextInt();
                                            mainMenu(user);
                                        }

                                        else if (chooseNumber == 0) {
                                            mainMenu(user);
                                        }

                                        else {
                                            searchFlight(user);
                                        }
                                    }
                                }

                            }
                        }

                    }
                }

            }
        }

    }

    /**
     * Show user flights
     * @param user
     */
    public void userShowFlights(User user) {
        System.out.println(color.PURPLE_BRIGHT + user.showMyFlights());
        System.out.print("Press 0 to back to menu: ");
        int number = input.nextInt();
        if (number == 0)
            mainMenu(user);
        else
            userShowFlights(user);

    }

}
