package IranAir;

import java.util.Random;

public class FlightGenerator {

    private Random random;
    private Flight[] flights;
    private ConsoleColors color = new ConsoleColors();

    String[] days = {"Saturday", "Sunday", "Monday", "Tuesday"};
    String[] cities = {"Tehran", "Kerman", "Yazd", "Shiraz", "Mashhad", "Isfahan"};
    int[] times = {8, 10, 18, 20};
    int[][] numbers;

    /**
     * Take the random numbers and push into array
     */
    public FlightGenerator() {
        random = new Random();
        flights = new Flight[15];
        numbers = new int[15][5];

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 5; j++) {
                switch(j) {
                    case 0:
                        numbers[i][j] = random.nextInt(1000);
                        break;
                    case 1:
                        numbers[i][j] = random.nextInt(cities.length);
                        break;
                    case 2:
                        numbers[i][j] = random.nextInt(cities.length);
                        if (numbers[i][j] == numbers[i][j - 1]) {
                            do {
                                numbers[i][j] = random.nextInt(cities.length);
                            }while (numbers[i][j] == numbers[i][j - 1]);
                        }
                        break;
                    case 3:
                        numbers[i][j] = random.nextInt(days.length);
                        break;
                    case 4:
                        numbers[i][j] = random.nextInt(times.length);
                }
            }
        }
    }

    public Flight[] getFlights() {
        return flights;
    }

    /**
     * Get data base the random numbers
     * @return
     */
    public Flight[] makeFlightsList() {
        for (int i = 0; i < 15; i++) {
            flights[i] = new Flight();
            for (int j = 0; j < 5; j++) {
                switch(j) {
                    case 0:
                        String flightNumber = String.valueOf(numbers[i][j]);
                        flights[i].setFlightNumber(flightNumber);
                        break;
                    case 1:
                        String origin = cities[numbers[i][j]];
                        flights[i].setOrigin(origin);
                        break;
                    case 2:
                        String destination = cities[numbers[i][j]];
                        flights[i].setDestination(destination);
                        break;
                    case 3:
                        String day = days[numbers[i][j]];
                        flights[i].setDay(day);
                        break;
                    case 4:
                        int time = times[numbers[i][j]];
                        flights[i].setTime(time);
                        break;
                }

            }
        }

        return flights;

    }

    /**
     * The four methods below show the flight base what user enter
     */
    public void showList() {
        System.out.println(color.BLUE_BRIGHT + "*.*.*.*.*.*.*.*. List of all flights *.*.*.*.*.*.*.");
        System.out.printf(color.YELLOW_BRIGHT + "%-10s\t %-10s\t %-10s\t %-10s\t %-10s\n", "number","origin", "des", "day", "time");
        Flight[] flights = makeFlightsList();
        for (Flight flight : flights) {
            System.out.print(flight.toString());
        }
    }

    public void showBySpecificOrigin(String origin) {
        for (Flight flight : flights) {
            if (flight.getOrigin().equals(origin))
                System.out.print(flight.toString());
        }
    }

    public void showBySpecificDestination(String origin, String destination) {

        for (Flight flight : flights) {
            if (flight.getOrigin().equals(origin) && flight.getDestination().equals(destination))
                System.out.print(flight.toString());
        }
    }

    public void showBySpecificDay(String origin, String destination, String day) {
        for (Flight flight : flights) {
            if (flight.getOrigin().equals(origin) && flight.getDestination().equals(destination) && flight.getDay().equals(day))
                System.out.print(flight.toString());
        }
    }

    public Flight showBySpecificTime(String origin, String destination, String day, int time) {
        Flight newFlight = new Flight();
        for (Flight flight : flights) {
            if (flight.getOrigin().equals(origin) && flight.getDestination().equals(destination) && flight.getDay().equals(day) && flight.getTime() == time) {
                System.out.print(flight.toString());
                newFlight = flight;
            }

        }
        return newFlight;
    }

}
