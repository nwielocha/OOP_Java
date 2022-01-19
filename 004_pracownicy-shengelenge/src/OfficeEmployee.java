public class OfficeEmployee extends Employee {
    private int officeStationID; // unikatowy dla klazdego pracownika biurowego
    private int iq; // w skali od 70 do 150

    public OfficeEmployee(String name,
                          String surname,
                          int age,
                          int experience,
                          Address address,
                          int officeStationID,
                          int iq) {
        super(name, surname, age, experience, address);
        this.setOfficeStationID(officeStationID);
        this.setIq(iq);
    }

    public int getOfficeStationID() {
        return officeStationID;
    }

    public void setOfficeStationID(int officeStationID) {
        this.officeStationID = officeStationID;
    }

    public int getIq() {
        return iq;
    }

    public void setIq(int iq) {
        if (iq >= 70 && iq <= 150)
            this.iq = iq;

    }

    @Override
    public void setValue(int value) {
        super.setValue(getExperience() * getIq());
    }

}
