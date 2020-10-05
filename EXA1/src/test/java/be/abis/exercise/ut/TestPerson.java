package be.abis.exercise.ut;

import be.abis.exercise.model.Person;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

public class TestPerson {

    @Test
    public void personShouldBe42() {
        Person persoon = new Person(1, "Kristof","Dhondt", LocalDate.of(1977, 11, 8));
        assertEquals(persoon.calculateAge(), 42);
    }

    }
