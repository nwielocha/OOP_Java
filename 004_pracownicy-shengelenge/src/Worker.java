public class Worker extends Employee {
    private int physicalStrength; // w skali od 1 do 100

    public Worker(
                  String name,
                  String surname,
                  int age,
                  int experience,
                  Address address,
                  int physicalStrength) {
        super(name, surname, age, experience, address);
        this.setPhysicalStrength(physicalStrength);
    }


    public int getPhysicalStrength() {
        return physicalStrength;
    }

    public void setPhysicalStrength(int physicalStrength) {
        if (physicalStrength >= 1 && physicalStrength <= 100)
            this.physicalStrength = physicalStrength;
    }

    @Override
    public void setValue(int value) {
        super.setValue((getExperience() * getPhysicalStrength()) / getAge());
    }
}
