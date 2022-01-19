import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;

public class Register {
    ArrayList<Employee> employees;

    public int id = 0;

    public Register() {
        employees = new ArrayList<>();
    }

    public void addEmployee(Employee e) {
        this.employees.add(e);
        e.id = this.id;
        this.id++;
    }

    public void removeEmployee(int id) {
        employees.remove(id);
    }

    public int numberOfEmployees() {
        return employees.size();
    }

    public void addDifferentTypesOfEmployees(ArrayList<Employee> employees) {
        for (Employee e : employees) {
            addEmployee(e);
        }
    }

    public void removeEmployeeById(int id) {
        this.employees.removeIf(employee -> employee.getId() == id);
    }

    public void showEmployees() {
        for (Employee e : employees) {
            System.out.println(e.getId() + " | " + e.getName() + " " + e.getSurname());
        }
    }

    public void sortByExperience() {
        ArrayList<Employee> e = employees;
        e.sort(Comparator.comparing(Employee::getExperience));
        Collections.reverse(e);
    } // malejąco

    public void sortByAge() {
        ArrayList<Employee> e = employees;
        e.sort(Comparator.comparing(Employee::getAge));
    } // rosnąco

    public void sortBySurname() {
        ArrayList<Employee> e = employees;
        e.sort(Comparator.comparing(Employee::getSurname));
    } // alfabetycznie

    public void showEmployeesFromGivenCity(String city) {
        for (Employee e : employees) {
            if (Objects.equals(e.getAddress().getCityName(), city)) {
                System.out.println(e.getAddress().getCityName() + " | " + e.getName() + " " + e.getSurname());
            }
        }
    }

    // TODO: showEmployeesValue()

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
