package be.abis.exercise.ut;

import be.abis.exercise.exception.PersonShouldBeAdultExecption;
import be.abis.exercise.model.Person;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class TestPerson {

    private Person persoon;

    @Before
    public void setUp() {
        persoon = new Person(1, "Kristof", "Dhondt", LocalDate.of(1973, 11, 8));
    }

    @Test
    public void personShouldBe46() throws PersonShouldBeAdultExecption {
        assertThat(persoon.calculateAge(), is(equalTo(46)));
    }

    @Test
    public void toStringSentenceStartsWithPerson() {
        String stringSentence = persoon.toString();
        assertThat(stringSentence, startsWith("Person"));
    }

    @Test(expected = PersonShouldBeAdultExecption.class)
    public void throwExeptionForKids() throws PersonShouldBeAdultExecption {
        Person persoonKind = new Person(2, "Rune", "Dhondt", LocalDate.of(2006, 12, 1));
        persoonKind.calculateAge();

    }
}