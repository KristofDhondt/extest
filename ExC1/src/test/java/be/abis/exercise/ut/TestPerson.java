package be.abis.exercise.ut;

import be.abis.exercise.exception.PersonShouldBeAdultExecption;
import be.abis.exercise.model.Company;
import be.abis.exercise.model.Person;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

@RunWith(MockitoJUnitRunner.class)
public class TestPerson {

    private Person persoon;
    @Mock Company mockedCompany;

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

    @Test
    public void calculateNetSalaryOfBelgianPersonUsingMockCompany(){
        Person persoon2 = new Person(1, "Kristof", "Dhondt" , LocalDate.of(1973, 11, 8),mockedCompany);
        persoon2.setGrossSalary(4200);
        when(mockedCompany.calculateTaxToPay()).thenReturn(51.0);
        assertEquals(persoon2.calculateNetSalary(), 2058, 0.01);
        verify(mockedCompany,times(1)).calculateTaxToPay();
    }
}