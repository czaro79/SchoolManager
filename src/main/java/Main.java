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
            performOperation(scan.nextLine().toLowerCase());
            continue;
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

    public static void performOperation(String selectedOption) {
        switch (selectedOption) {
            case "a":
                printPupilsList();
                break;
            case "b":
                printMarksOfAllPupils();
                break;
            case "c":
                String firstName;
                String lastName;
                while (true) {
                    System.out.print("Podaj imie ucznia: ");
                    firstName = scan.nextLine().trim();
                    if (firstName.isBlank()) {
                        continue;
                    } else {
                        break;
                    }
                }
                while (true) {
                    System.out.print("Podaj nazwisko ucznia: ");
                    lastName = scan.nextLine().trim();
                    if (lastName.isBlank()) {
                        continue;
                    } else {
                        System.out.println();
                        break;
                    }
                }
                if (!classroom.contains(new Pupil(firstName, lastName))) {
                    System.out.println("Brak ucznia na liscie.\n");

                } else {
                    classroom.showPupilMarks(new Pupil(firstName, lastName));
                }
                break;
            case "d":
                System.out.println("Z jakiego przedmiotu odpytujesz ucznia?");
                System.out.println("B - biologia\n" +
                        "C - chemia\n" +
                        "A - jezyk angielski\n" +
                        "F - jezyk francuski\n" +
                        "M - matematyka\n" +
                        "FI - fizyka\n");
                System.out.print("Przedmiot: ");
                while (true) {
                    int mark;
                    switch (scan.nextLine().toLowerCase().trim()) {

                        case "b":
                            while (true) {
                                System.out.print("Podaj imie ucznia: ");
                                firstName = scan.nextLine().trim();
                                if (firstName.isBlank()) {
                                    continue;
                                } else {
                                    break;
                                }
                            }
                            while (true) {
                                System.out.print("Podaj nazwisko ucznia: ");
                                lastName = scan.nextLine().trim();
                                if (lastName.isBlank()) {
                                    continue;
                                } else {
                                    System.out.println();
                                    break;
                                }
                            }
                            if (classroom.getPupil(firstName, lastName) == null) {
                                System.out.println("\nBrak ucznia na liscie.");
                                break;
                            } else {
                                mark = new Pupil(firstName, lastName).getRandomMark();
                                classroom.getPupil(firstName, lastName).addMark(Subject.BIOLOGY, mark);
                                System.out.println(firstName + " " + lastName + " otrzymal ocene: " + mark);
                                System.out.println("\nWcisnij ENTER, zeby kontynuowac.");
                                scan.nextLine();
                            }
                            break;
                        case "c":
                            while (true) {
                                System.out.print("Podaj imie ucznia: ");
                                firstName = scan.nextLine().trim();
                                if (firstName.isBlank()) {
                                    continue;
                                } else {
                                    break;
                                }
                            }
                            while (true) {
                                System.out.print("Podaj nazwisko ucznia: ");
                                lastName = scan.nextLine().trim();
                                if (lastName.isBlank()) {
                                    continue;
                                } else {
                                    System.out.println();
                                    break;
                                }
                            }
                            if (classroom.getPupil(firstName, lastName) == null) {
                                System.out.println("\nBrak ucznia na liscie.");
                                break;
                            } else {
                                mark = new Pupil(firstName, lastName).getRandomMark();
                                classroom.getPupil(firstName, lastName).addMark(Subject.CHEMISTRY, mark);
                                System.out.println(firstName + " " + lastName + " otrzymal ocene: " + mark);
                                System.out.println("\nWcisnij ENTER, zeby kontynuowac.");
                                scan.nextLine();
                            }
                            break;
                        case "a":
                            while (true) {
                                System.out.print("Podaj imie ucznia: ");
                                firstName = scan.nextLine().trim();
                                if (firstName.isBlank()) {
                                    continue;
                                } else {
                                    break;
                                }
                            }
                            while (true) {
                                System.out.print("Podaj nazwisko ucznia: ");
                                lastName = scan.nextLine().trim();
                                if (lastName.isBlank()) {
                                    continue;
                                } else {
                                    System.out.println();
                                    break;
                                }
                            }
                            if (classroom.getPupil(firstName, lastName) == null) {
                                System.out.println("\nBrak ucznia na liscie.");
                                break;
                            } else {
                                mark = new Pupil(firstName, lastName).getRandomMark();
                                classroom.getPupil(firstName, lastName).addMark(Subject.ENGLISH, mark);
                                System.out.println(firstName + " " + lastName + " otrzymal ocene: " + mark);
                                System.out.println("\nWcisnij ENTER, zeby kontynuowac.");
                                scan.nextLine();
                            }
                            break;
                        case "f":
                            while (true) {
                                System.out.print("Podaj imie ucznia: ");
                                firstName = scan.nextLine().trim();
                                if (firstName.isBlank()) {
                                    continue;
                                } else {
                                    break;
                                }
                            }
                            while (true) {
                                System.out.print("Podaj nazwisko ucznia: ");
                                lastName = scan.nextLine().trim();
                                if (lastName.isBlank()) {
                                    continue;
                                } else {
                                    System.out.println();
                                    break;
                                }
                            }
                            if (classroom.getPupil(firstName, lastName) == null) {
                                System.out.println("\nBrak ucznia na liscie.");
                                break;
                            } else {
                                mark = new Pupil(firstName, lastName).getRandomMark();
                                classroom.getPupil(firstName, lastName).addMark(Subject.FRENCH, mark);
                                System.out.println(firstName + " " + lastName + " otrzymal ocene: " + mark);
                                System.out.println("\nWcisnij ENTER, zeby kontynuowac.");
                                scan.nextLine();
                            }
                            break;
                        case "m":
                            while (true) {
                                System.out.print("Podaj imie ucznia: ");
                                firstName = scan.nextLine().trim();
                                if (firstName.isBlank()) {
                                    continue;
                                } else {
                                    break;
                                }
                            }
                            while (true) {
                                System.out.print("Podaj nazwisko ucznia: ");
                                lastName = scan.nextLine().trim();
                                if (lastName.isBlank()) {
                                    continue;
                                } else {
                                    System.out.println();
                                    break;
                                }
                            }
                            if (classroom.getPupil(firstName, lastName) == null) {
                                System.out.println("\nBrak ucznia na liscie.");
                                break;
                            } else {
                                mark = new Pupil(firstName, lastName).getRandomMark();
                                classroom.getPupil(firstName, lastName).addMark(Subject.MATHEMATICS, mark);
                                System.out.println(firstName + " " + lastName + " otrzymal ocene: " + mark);
                                System.out.println("\nWcisnij ENTER, zeby kontynuowac.");
                                scan.nextLine();
                            }
                            break;
                        case "fi":
                            while (true) {
                                System.out.print("Podaj imie ucznia: ");
                                firstName = scan.nextLine().trim();
                                if (firstName.isBlank()) {
                                    continue;
                                } else {
                                    break;
                                }
                            }
                            while (true) {
                                System.out.print("Podaj nazwisko ucznia: ");
                                lastName = scan.nextLine().trim();
                                if (lastName.isBlank()) {
                                    continue;
                                } else {
                                    System.out.println();
                                    break;
                                }
                            }
                            if (classroom.getPupil(firstName, lastName) == null) {
                                System.out.println("\nBrak ucznia na liscie.");
                                break;
                            } else {
                                mark = new Pupil(firstName, lastName).getRandomMark();
                                classroom.getPupil(firstName, lastName).addMark(Subject.PHYSICS, mark);
                                System.out.println(firstName + " " + lastName + " otrzymal ocene: " + mark);
                                System.out.println("\nWcisnij ENTER, zeby kontynuowac.");
                                scan.nextLine();
                            }
                            break;
                        default:
                            break;
                    }
                    break;
                }
                break;
            case "e":
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
                        for (int i = 0; i < classroom.getPupils().size(); i++) {
                            classroom.getPupil(i).addMark(Subject.BIOLOGY, classroom.getPupil(i).getRandomMark());
                        }
                        System.out.println("\nPrace sprawdzone, oceny wystawione.");
                        System.out.println("\nWcisnij ENTER, zeby kontynuowac.");
                        scan.nextLine();
                        break;
                    case "c":
                        for (int i = 0; i < classroom.getPupils().size(); i++) {
                            classroom.getPupil(i).addMark(Subject.CHEMISTRY, classroom.getPupil(i).getRandomMark());
                        }
                        System.out.println("\nPrace sprawdzone, oceny wystawione.");
                        System.out.println("\nWcisnij ENTER, zeby kontynuowac.");
                        scan.nextLine();
                        break;
                    case "a":
                        for (int i = 0; i < classroom.getPupils().size(); i++) {
                            classroom.getPupil(i).addMark(Subject.ENGLISH, classroom.getPupil(i).getRandomMark());
                        }
                        System.out.println("\nPrace sprawdzone, oceny wystawione.");
                        System.out.println("\nWcisnij ENTER, zeby kontynuowac.");
                        scan.nextLine();
                        break;
                    case "f":
                        for (int i = 0; i < classroom.getPupils().size(); i++) {
                            classroom.getPupil(i).addMark(Subject.FRENCH, classroom.getPupil(i).getRandomMark());
                        }
                        System.out.println("\nPrace sprawdzone, oceny wystawione.");
                        System.out.println("\nWcisnij ENTER, zeby kontynuowac.");
                        scan.nextLine();
                        break;
                    case "m":
                        for (int i = 0; i < classroom.getPupils().size(); i++) {
                            classroom.getPupil(i).addMark(Subject.MATHEMATICS, classroom.getPupil(i).getRandomMark());
                        }
                        System.out.println("\nPrace sprawdzone, oceny wystawione.");
                        System.out.println("\nWcisnij ENTER, zeby kontynuowac.");
                        scan.nextLine();
                        break;
                    case "fi":
                        for (int i = 0; i < classroom.getPupils().size(); i++) {
                            classroom.getPupil(i).addMark(Subject.PHYSICS, classroom.getPupil(i).getRandomMark());
                        }
                        System.out.println("\nPrace sprawdzone, oceny wystawione.");
                        System.out.println("\nWcisnij ENTER, zeby kontynuowac.");
                        scan.nextLine();
                        break;
                    default:
                        break;
                }
                break;
            case "f":
                while (true) {
                    System.out.print("Podaj imie ucznia: ");
                    firstName = scan.nextLine().trim();
                    if (firstName.isBlank()) {
                        continue;
                    } else {
                        break;
                    }
                }
                while (true) {
                    System.out.print("Podaj nazwisko ucznia: ");
                    lastName = scan.nextLine().trim();
                    if (lastName.isBlank()) {
                        continue;
                    } else {
                        System.out.println();
                        break;
                    }
                }
                if (classroom.getPupil(firstName, lastName) != null) {
                    System.out.println(firstName + " " + lastName + " srednie arytmetyczne ocen:");
                    Subject[] subject = Subject.values();
                    for (Subject sub : subject
                    ) {
                        System.out.println(sub + ": " + classroom.getPupil(firstName, lastName).calculateAverageMark(sub));
                    }
                    System.out.println("\nWcisnij ENTER, zeby kontynuowac.");
                    scan.nextLine();
                }
                break;
            default:
                break;
        }
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


}

