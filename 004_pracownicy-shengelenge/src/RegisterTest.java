import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class RegisterTest {
    @Test
    public void testAddEmployee() {
        Register r = new Register();
        Employee e = new OfficeEmployee("Marcin", "Trzeciak", 24, 5, new Address("Gorczycowa", 12, 7, "Gdynia"), 7, 100);
        r.addEmployee(e);
        int size = r.numberOfEmployees();
        assertEquals(1, size);
    }

    @Test
    public void testRemoveEmployee() {
        Register r = new Register();
        r.addEmployee(new Worker("Damian", "Jakis", 42, 12, new Address("Gorczycowa", 12, 7, "Gdynia"), 70));
        r.removeEmployee(0);
        int size = r.numberOfEmployees();
        r.showEmployees();
        assertEquals(0, size);
    }

    @Test
    public void testAddDifferentTypesOfEmployees() {
        Register r = new Register();
        ArrayList<Employee> e = new ArrayList<>();
        e.add(new OfficeEmployee("Jacek", "Barczak", 38, 8, new Address("Gorczycowa", 12, 7, "Gdynia"), 10, 120));
        e.add(new Trader("Marzena", "Kot", 37, 10, new Address("Świętojańska", 17, 8, "Gdynia"),  0.21, Trader.Level.MEDIUM));
        e.add(new Worker("Bartosz", "Wielgus", 27, 3, new Address("Morska", 80, 7, "Gdynia"), 60));
        r.addDifferentTypesOfEmployees(e);
        int size = r.numberOfEmployees();
        r.showEmployees();
        assertEquals(3, size);
    }

    @Test
    public void testRemoveEmployeeById() {
        Register r = new Register();
        ArrayList<Employee> e = new ArrayList<>();
        e.add(new OfficeEmployee("Jacek", "Barczak", 38, 8, new Address("Gorczycowa", 12, 6, "Gdynia"), 10, 120));
        e.add(new Trader("Marzena", "Kot", 37, 10, new Address("Gorczycowa", 12, 7, "Gdynia"), 0.21, Trader.Level.LOW));
        e.add(new Worker("Bartosz", "Wielgus",  27, 3, new Address("Gorczycowa", 12, 8, "Gdynia"), 60));
        r.addDifferentTypesOfEmployees(e);
        r.removeEmployeeById(1);
        int size = r.numberOfEmployees();
        r.showEmployees();
        assertEquals(2, size);
    }

    @Test
    public void testSortByExperience() {
        Register r = new Register();
        ArrayList<Employee> e = new ArrayList<>();
        e.add(new OfficeEmployee("Jacek", "Barczak", 38, 8, new Address("Gorczycowa", 12, 7, "Gdynia"), 10, 120));
        e.add(new Trader("Marzena", "Kot", 37, 10, new Address("Gorczycowa", 12, 7, "Gdańsk"), 0.21, Trader.Level.HIGH));
        e.add(new Worker("Bartosz", "Wielgus", 27, 3, new Address("Gorczycowa", 12, 7, "Sopot"), 60));
        r.addDifferentTypesOfEmployees(e);
        r.sortByExperience();
        int size = r.numberOfEmployees();
        r.showEmployees();
        assertEquals(3, size);
    }

    @Test
    public void testSortByAge() {
        Register r = new Register();
        ArrayList<Employee> e = new ArrayList<>();
        e.add(new OfficeEmployee("Jacek", "Barczak", 38, 8, new Address("Gorczycowa", 12, 7, "Gdynia"), 10, 120));
        e.add(new Trader("Marzena", "Kot", 37, 10, new Address("Gorczycowa", 12, 7, "Gdańsk"), 0.21, Trader.Level.MEDIUM));
        e.add(new Worker("Bartosz", "Wielgus", 27, 3, new Address("Gorczycowa", 12, 7, "Sopot"), 60));
        r.addDifferentTypesOfEmployees(e);
        r.sortByAge();
        int size = r.numberOfEmployees();
        r.showEmployees();
        assertEquals(3, size);
    }

    @Test
    public void testSortBySurname() {
        Register r = new Register();
        ArrayList<Employee> e = new ArrayList<>();
        e.add(new OfficeEmployee("Jacek", "Barczak", 38, 8, new Address("Gorczycowa", 12, 7, "Gdynia"), 10, 120));
        e.add(new Trader("Marzena", "Kot", 37, 10, new Address("Gorczycowa", 12, 7, "Gdańsk"), 0.21, Trader.Level.MEDIUM));
        e.add(new Worker("Bartosz", "Dielgus", 27, 3, new Address("Gorczycowa", 12, 7, "Sopot"), 60));
        r.addDifferentTypesOfEmployees(e);
        r.sortBySurname();
        int size = r.numberOfEmployees();
        r.showEmployees();
        assertEquals(3, size);
    }

    @Test
    public void testShowEmployeesFromGivenCity() {
        Register r = new Register();
        ArrayList<Employee> e = new ArrayList<>();
        e.add(new OfficeEmployee("Jacek", "Barczak", 38, 8, new Address("Gorczycowa", 12, 7, "Gdynia"), 10, 120));
        e.add(new Trader("Marzena", "Kot", 37, 10, new Address("Gorczycowa", 12, 7, "Gdańsk"), 0.21, Trader.Level.MEDIUM));
        e.add(new Worker("Bartosz", "Dielgus", 27, 3, new Address("Gorczycowa", 12, 7, "Sopot"), 60));
        r.addDifferentTypesOfEmployees(e);
        int size = r.numberOfEmployees();
        r.showEmployeesFromGivenCity("Gdańsk");
        assertEquals(3, size);
    }

}
