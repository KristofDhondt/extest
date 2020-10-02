package be.abis.exercise.ut;

import be.abis.exercise.model.Address;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestAdress {

    @Test
    public void belgianZipCodeShouldBeNumeric() {
        //arrange
        Address adres = new Address("Warandeberg", "1","1000", "Brussels", "Belgium",  "BE");

        //act
        boolean testZipCode = adres.isValidBelgianZipCode();
        //assert
        assertTrue(testZipCode);
    }

}
