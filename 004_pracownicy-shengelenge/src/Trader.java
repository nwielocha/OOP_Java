public class Trader extends Employee {
    private double commission; // wyrazona w procentach
    enum Level {
        LOW,
        MEDIUM,
        HIGH


    }

    Level effectiveness;

    public Trader(String name,
                  String surname,
                  int age,
                  int experience,
                  Address address,
                  double commission,
                  Level effectiveness) {
        super(name, surname, age, experience, address);
        this.setCommission(commission);
        this.setEffectiveness(effectiveness);
    }

    public double getCommission() {
        return commission;
    }

    public void setCommission(double commission) {
        if (commission >= 0 && commission <= 1)
            this.commission = commission;
    }

    public Level getEffectiveness() {
        return effectiveness;
    }


    public void setEffectiveness(Level effectiveness) {
        this.effectiveness = effectiveness;
    }

    @Override
    public void setValue(int value) {
        int i = 0;
        switch (getEffectiveness()) {
            case LOW -> {
                i = 60;
            }
            case MEDIUM -> {
                i = 90;
            }
            case HIGH -> {
                i = 120;
            }

        }
        super.setValue(getExperience() * i);
    }
}
