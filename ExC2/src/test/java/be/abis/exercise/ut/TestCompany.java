package be.abis.exercise.ut;

import be.abis.exercise.model.Company;
import be.abis.exercise.model.Address;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestCompany {

    @Test
    public void taxForBelgianCompanyShouldBe51() {
        //arrange
        Address adres = new Address("Warandeberg", "12", "1000", "Brussels", "Belgium", "BE");
        Company comp = new Company("FORTIS", adres);

        //act
        double taxToPay = comp.calculateTaxToPay();

        //assert
        assertEquals(51.0, taxToPay, 0.01);
    }
}
