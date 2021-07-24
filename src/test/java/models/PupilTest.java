package models;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PupilTest {
    Pupil pupil;


    @Test(expected = IllegalArgumentException.class)
    public void testWhenFirstNameIsNull() {
        pupil = new Pupil(null, "Lastname");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWhenLastNameIsNull() {
        pupil = new Pupil("Firstname", null);
    }


    @Test
    public void testGetMarks() {
        pupil.addMark(Subject.MATHEMATICS,3);
        pupil.addMark(Subject.MATHEMATICS,4);
        pupil.addMark(Subject.MATHEMATICS,5);
        pupil.addMark(Subject.BIOLOGY,3);
        pupil.addMark(Subject.BIOLOGY,4);
        pupil.addMark(Subject.BIOLOGY,5);
        pupil.addMark(Subject.PHYSICS,3);
        pupil.addMark(Subject.PHYSICS,4);
        pupil.addMark(Subject.PHYSICS,5);
        pupil.addMark(Subject.ENGLISH,3);
        pupil.addMark(Subject.ENGLISH,4);
        pupil.addMark(Subject.ENGLISH,5);

        assertArrayEquals(new Integer[]{3,4,5}, pupil.getMarks(Subject.MATHEMATICS) );
        assertArrayEquals(new Integer[]{3,4,5}, pupil.getMarks(Subject.BIOLOGY) );
        assertArrayEquals(new Integer[]{3,4,5}, pupil.getMarks(Subject.PHYSICS) );
        assertArrayEquals(new Integer[]{3,4,5}, pupil.getMarks(Subject.ENGLISH) );
        
    }
}