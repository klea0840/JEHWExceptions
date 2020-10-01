package task3Worker;

public class Worker implements Comparable<Worker> {

    String name;
    String position;
    int year;

    Worker(String name, String position, int year) {
        this.name = name;
        this.position = position;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public int getYear() {
        return year;
    }

    public int compareTo(Worker other) {
        return this.name.compareTo(other.name);
    }
}
