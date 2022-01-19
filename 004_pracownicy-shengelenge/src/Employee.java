public abstract class Employee {
    public int id; // unikatowy dla klazdego pracowinka
    private String name;
    private String surname;
    private int age;
    private int experience;
    private Address address;

    private int value;

    public Employee(String name,
                    String surname,
                    int age,
                    int experience,
                    Address address) {
        this.setName(name);
        this.setSurname(surname);
        this.setAge(age);
        this.setExperience(experience);
        this.setAddress(address);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {this.name = name;}

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
