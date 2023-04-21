package IranAir;

public class Flight {
    ConsoleColors color = new ConsoleColors();
    private String day;
    private String origin;
    private String destination;
    private String flightNumber;
    private int time;

    public Flight () {

    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String toString() {
        return String.format(color.PURPLE + "%-10s\t %-10s\t %-10s\t %-10s\t %-10d\n", flightNumber, origin, destination, day, time);
    }


}
