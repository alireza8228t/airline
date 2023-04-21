package IranAir;

import java.util.*;

public class User {
    ConsoleColors color = new ConsoleColors();
    private String userName;
    private String passWord;
    private List<Flight> flights;

    public User(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
        flights = new ArrayList<>();
    }

    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    public String showMyFlights() {
        String str = "";
        if (flights.size() == 0) {
            str = "No flight has been added yet";
        }
        else {
            System.out.println("Your flights list: ");
            System.out.printf(color.GREEN_BRIGHT + "%-10s\t %-10s\t %-10s\t %-10s\t %-10s\n", "number","origin", "destina", "day", "time");
            for (int i = 0; i < flights.size(); i++) {
                str += flights.get(i).toString();
            }
        }
        return str;
    }

    public String toString() {

        return String.format("%s : %s\n", userName, passWord);
    }
}
