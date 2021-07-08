package models;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Classroom {
    private final ArrayList<Pupil> pupils;

    public Classroom() {
        this.pupils = new ArrayList<Pupil>();
    }

    public void addPupil(Pupil pupil) {
        if (pupil == null) {
            throw new IllegalArgumentException("Nie ma ucznia do dodania.");
        }
        this.pupils.add(pupil);
    }

    public ArrayList<Pupil> getPupils() {
        return this.pupils;
    }

    public Pupil getPupil(String firstName, String lastName) {
        if (firstName == null || firstName.isBlank()) {
            throw new IllegalArgumentException("Musisz podac jakies imie ucznia!");
        }
        if (lastName == null || lastName.isBlank()) {
            throw new IllegalArgumentException("Uczen musi posiadac nazwisko!");
        }
        for (Pupil obj : pupils
        ) {
            if (obj.getFirstName().equalsIgnoreCase(firstName) && obj.getLastName().equalsIgnoreCase(lastName))
                return obj;
        }
        return null;
    }

    public Pupil getPupil (int index) {
        return this.pupils.get(index);
    }

    public String toString() {
        String temp = "";
        for (Pupil obj : pupils
        ) {
            temp += obj + "\n";
        }
        return temp;
    }

    public void createPupilsList(String fileName) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream(fileName);
        Scanner scan = new Scanner(fis);

        while (scan.hasNextLine()) {
            String[] pupilName = scan.nextLine().split(" ");
            this.pupils.add(new Pupil(pupilName[0], pupilName[1]));
        }
        scan.close();
    }

    public void sortPupilsList() {
        Collections.sort(this.pupils);
    }

    public void showPupilsList() {
        String message = "\nLista obecnosci:";
        System.out.println(message);
        for (int i = 0; i < message.length() - 1; i++) {
            System.out.print("*");
        }
        String temp = "\n";
        int count = 1;
        for (Pupil pupil : this.pupils
        ) {
            temp += count + ". " + pupil.getLastName() + " " + pupil.getFirstName() + "\n";
            count++;
        }
        System.out.println(temp);
        System.out.println();
    }

    public boolean contains(Pupil obj) {
        for (Pupil pupil : pupils
        ) {
            if (pupil.equals(obj)) {
                return true;
            }
        }
        return false;
    }

    public void showPupilMarks(Pupil obj) {
        for (Pupil pupil : pupils
        ) {
            if (pupil.equals(obj)) {
                System.out.println(pupil);
            }
        }
    }
}
