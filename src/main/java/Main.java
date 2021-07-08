import models.Classroom;
import models.Pupil;
import models.Subject;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    static Classroom classroom = new Classroom();
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        loadPupils("src/main/java/models/pupils.txt");
        sortLoadedPupilsList();
        manageClassroom();
    }

    public static void loadPupils(String fileName) {
        try {
            classroom.createPupilsList(fileName);
        } catch (FileNotFoundException c) {
            System.out.println(c.getMessage());
        }
    }

    public static void manageClassroom() {
        while (true) {
            printMenu();
            if (performOperation(scan.nextLine().toLowerCase())) {
                performOperation(scan.nextLine().toLowerCase());
            } else {
                System.out.println("Do zobaczenia nastepnym razem!");
                break;
            }

        }
    }

    public static void printMenu() {
        String temp = "System zarzadzania klasa - Class Manager V 1.0";
        System.out.println(temp);
        for (int i = 0; i < temp.length(); i++) {
            System.out.print("*");
        }
        System.out.println("\nOperacje:");
        System.out.println("A - wyswietl liste obecnosci");
        System.out.println("B - wyswietl oceny wszystkich uczniow");
        System.out.println("C - wyswietl oceny konkretnego ucznia");
        System.out.println("D - odpytaj ucznia");
        System.out.println("E - zrob sprawdzian wiadomosci");
        System.out.println("F - policz srednia ocen ucznia");
        System.out.println("X - KONIEC");
        System.out.print("\nWybieram: ");
    }

    public static void sortLoadedPupilsList() {
        classroom.sortPupilsList();
    }

    public static boolean performOperation(String selectedOption) {
        switch (selectedOption) {
            case "a":
                printPupilsList();
                break;
            case "b":
                printMarksOfAllPupils();
                break;
            case "c":
                printSelectedPupilsMarks();
                break;
            case "d":
                examinePupil();
                break;
            case "e":
                examineAllPupils();
                break;
            case "f":
                printAverageMarks();
                break;
            case "x":
                return false;
        }
        return true;
    }

    public static void printPupilsList() {
        classroom.showPupilsList();
        System.out.println("Wcisnij ENTER, zeby kontynuowac.");
        scan.nextLine();
    }

    public static void printMarksOfAllPupils() {
        System.out.println("\n" + classroom);
        System.out.println("Wcisnij ENTER, zeby kontynuowac.");
        scan.nextLine();
    }

    public static String[] getPupilsFirstLastName() {
        String firstName = "";
        String lastName = "";
        while(firstName.isBlank() || firstName == null) {
            System.out.print("Podaj imie ucznia: ");
            firstName = scan.nextLine().trim();
        }
        while(lastName.isBlank()|| lastName == null) {
            System.out.print("Podaj nazwisko ucznia: ");
            lastName = scan.nextLine().trim();
        }
        return new String[]{firstName, lastName};
    }

    public static void printSelectedPupilsMarks() {
        String[] name = getPupilsFirstLastName();
        if (!classroom.contains(new Pupil(name[0], name[1]))) {
            System.out.println("Brak ucznia na liscie.\n");

        } else {
            classroom.showPupilMarks(new Pupil(name[0], name[1]));
        }
        System.out.println("\nWcisnij ENTER, zeby kontynuowac.");
        scan.nextLine();

    }

    public static void examinePupilBySubject(Subject subject) {
        int mark;
        String[] name = getPupilsFirstLastName();
        if (classroom.getPupil(name[0], name[1]) == null) {
            System.out.println("\nBrak ucznia na liscie.");
        } else {
            mark = new Pupil(name[0], name[1]).getRandomMark();
            classroom.getPupil(name[0], name[1]).addMark(subject, mark);
            System.out.println(name[0] + " " + name[1] + " otrzymal ocene: " + mark);
            System.out.println("\nWcisnij ENTER, zeby kontynuowac.");
            scan.nextLine();
        }
    }

    public static void examinePupil() {
        System.out.println("Z jakiego przedmiotu odpytujesz ucznia?");
        System.out.println("B - biologia\n" +
                "C - chemia\n" +
                "A - jezyk angielski\n" +
                "F - jezyk francuski\n" +
                "M - matematyka\n" +
                "FI - fizyka\n");
        System.out.print("Przedmiot: ");
        while (true) {
            switch (scan.nextLine().toLowerCase().trim()) {
                case "b":
                    examinePupilBySubject(Subject.BIOLOGY);
                    break;
                case "c":
                    examinePupilBySubject(Subject.CHEMISTRY);
                    break;
                case "a":
                    examinePupilBySubject(Subject.ENGLISH);
                    break;
                case "f":
                    examinePupilBySubject(Subject.FRENCH);
                    break;
                case "m":
                    examinePupilBySubject(Subject.MATHEMATICS);
                    break;
                case "fi":
                    examinePupilBySubject(Subject.PHYSICS);
                    break;
                default:
                    break;
            }
            break;
        }
    }

    public static void printAverageMarks() {
        String[] name = getPupilsFirstLastName();
        if (classroom.getPupil(name[0], name[1]) != null) {
            System.out.println(name[0] + " " + name[1] + " srednie arytmetyczne ocen:");
            Subject[] subject = Subject.values();
            for (Subject sub : subject
            ) {
                System.out.println(sub + ": " + classroom.getPupil(name[0], name[1]).calculateAverageMark(sub));
            }
            System.out.println("\nWcisnij ENTER, zeby kontynuowac.");
            scan.nextLine();
        }
    }

    public static void examineAllPupils() {
        System.out.println("Z jakiego przedmiotu robimy sprawdzian?");
        System.out.println("B - biologia\n" +
                "C - chemia\n" +
                "A - jezyk angielski\n" +
                "F - jezyk francuski\n" +
                "M - matematyka\n" +
                "FI - fizyka\n");
        System.out.print("Przedmiot: ");
        switch (scan.nextLine().toLowerCase().trim()) {
            case "b":
                examineAllBySubject(Subject.BIOLOGY);
                break;
            case "c":
                examineAllBySubject(Subject.CHEMISTRY);
                break;
            case "a":
                examineAllBySubject(Subject.ENGLISH);
                break;
            case "f":
                examineAllBySubject(Subject.FRENCH);
                break;
            case "m":
                examineAllBySubject(Subject.MATHEMATICS);
                break;
            case "fi":
                examineAllBySubject(Subject.PHYSICS);
                break;
            default:
                break;
        }
    }

    private static void examineAllBySubject(Subject subject) {
        for (int i = 0; i < classroom.getPupils().size(); i++) {
            classroom.getPupil(i).addMark(subject, classroom.getPupil(i).getRandomMark());
        }
        System.out.println("\nPrace sprawdzone, oceny wystawione.");
        System.out.println("\nWcisnij ENTER, zeby kontynuowac.");
        scan.nextLine();
    }
}

