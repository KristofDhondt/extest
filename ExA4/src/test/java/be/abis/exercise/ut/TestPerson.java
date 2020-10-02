package be.abis.exercise.ut;

import be.abis.exercise.model.Person;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.equalTo;

public class TestPerson {

    @Test
    public void personShouldBe46() {
        Person persoon = new Person(1, "Kristof", "Dhondt", LocalDate.of(1973, 11, 8));
        assertThat(persoon.calculateAge(), is (equalTo(46)));
    }

    }
