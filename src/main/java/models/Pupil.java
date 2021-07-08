package models;

import java.util.*;
import java.util.stream.DoubleStream;

public class Pupil implements Comparable<Pupil> {
    private String firstName;
    private String lastName;
    private final HashMap<Subject, ArrayList<Integer>> marks;

    public Pupil(String firstName, String lastName) {
        if (firstName == null || firstName.isBlank()) {
            throw new IllegalArgumentException("Musisz podac jakies imie ucznia!");
        }
        if (lastName == null || lastName.isBlank()) {
            throw new IllegalArgumentException("Uczen musi posiadac nazwisko!");
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.marks = new HashMap<Subject, ArrayList<Integer>>();
        Subject[] subject = Subject.values();
        for (Subject sub : subject
        ) {
            this.marks.put(sub, new ArrayList<Integer>());
        }
    }

    private void setFirstName(String firstName) {
        if (firstName == null || firstName.isBlank()) {
            throw new IllegalArgumentException("Musisz podac jakies imie ucznia!");
        }
        this.firstName = firstName;
    }

    private void setLastName(String lastName) {
        if (lastName == null || lastName.isBlank()) {
            throw new IllegalArgumentException("Uczen musi posiadac nazwisko!");
        }
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void addMark(Subject subject, int mark) {
        if (mark < 1 || mark > 6) {
            throw new IllegalArgumentException("Ocena moze byc tylko w zakresie 1-6.");
        }
        this.marks.get(subject).add(mark);
    }

    public Integer[] getMarks(Subject subject) {
        return this.marks.get(subject).toArray(new Integer[0]);
    }


    public String toString() {
        String temp = "Uczeń: " + this.firstName + " " + this.lastName + "\n";
        int tempLength = temp.length();
        for (int i = 0; i < tempLength - 1; i++) {
            temp += "-";
        }
        temp += "\n" + printMarks();
        return temp;
    }

    public boolean equals(Pupil obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Nie mozna porownac ucznia z NULL.");
        }
        return this.firstName.equalsIgnoreCase(obj.firstName) && this.lastName.equalsIgnoreCase(obj.lastName);
    }

    private String printMarks() {
        String temp = "";
        Subject[] subject = Subject.values();
        for (Subject sub : subject) {
            temp += sub + " " + Arrays.toString(this.getMarks(sub)) + "\n";
        }
        return temp;
    }

    public int getRandomMark() {
        return (int) Math.round(Math.random() * 5 + 1);
    }

    public double calculateAverageMark(Subject subject) {

        return (double) Math.round(this.marks.get(subject).stream().mapToDouble(d -> d).average().orElse(0.0) * 100) / 100;
    }

    /**
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     *
     * <p>The implementor must ensure
     * {@code sgn(x.compareTo(y)) == -sgn(y.compareTo(x))}
     * for all {@code x} and {@code y}.  (This
     * implies that {@code x.compareTo(y)} must throw an exception iff
     * {@code y.compareTo(x)} throws an exception.)
     *
     * <p>The implementor must also ensure that the relation is transitive:
     * {@code (x.compareTo(y) > 0 && y.compareTo(z) > 0)} implies
     * {@code x.compareTo(z) > 0}.
     *
     * <p>Finally, the implementor must ensure that {@code x.compareTo(y)==0}
     * implies that {@code sgn(x.compareTo(z)) == sgn(y.compareTo(z))}, for
     * all {@code z}.
     *
     * <p>It is strongly recommended, but <i>not</i> strictly required that
     * {@code (x.compareTo(y)==0) == (x.equals(y))}.  Generally speaking, any
     * class that implements the {@code Comparable} interface and violates
     * this condition should clearly indicate this fact.  The recommended
     * language is "Note: this class has a natural ordering that is
     * inconsistent with equals."
     *
     * <p>In the foregoing description, the notation
     * {@code sgn(}<i>expression</i>{@code )} designates the mathematical
     * <i>signum</i> function, which is defined to return one of {@code -1},
     * {@code 0}, or {@code 1} according to whether the value of
     * <i>expression</i> is negative, zero, or positive, respectively.
     *
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it
     *                              from being compared to this object.
     */
    @Override
    public int compareTo(Pupil o) {
        int lastN = this.lastName.compareTo(o.lastName);
        return lastN == 0 ? this.firstName.compareTo(o.firstName) : lastN;
    }
}

