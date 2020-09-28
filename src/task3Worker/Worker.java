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
        // return String.compareTo(name, other.name);
        // compareTo сравнивает передаваемый объект с объектом, от которого этот метод вызван.
        // Т.е. его надо вызывать так: строка.compareTo(другая_строка)
        // https://docs.oracle.com/javase/8/docs/api/java/lang/String.html#compareTo-java.lang.String-
        return this.name.compareTo(other.getName());
    }
}
