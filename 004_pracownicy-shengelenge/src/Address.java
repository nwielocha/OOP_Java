public class Address {
    private String streetName;
    private int streetNumber;
    private int apartmentNumber;
    private String cityName;

    public Address(String streetName,
                   int streetNumber,
                   int apartmentNumber,
                   String cityName) {
        this.setStreetName(streetName);
        this.setStreetNumber(streetNumber);
        this.setApartmentNumber(apartmentNumber);
        this.setCityName(cityName);
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(int apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

}
