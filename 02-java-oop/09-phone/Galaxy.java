public class Galaxy extends Phone implements Ringable {
    public Galaxy(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
        super(versionNumber, batteryPercentage, carrier, ringTone);
    }

    public String ring() {
        return "Bazinga Bazinga Bazinga";
    }

    public String unlock() {
        return "Unlock Phone with styles";
    }

    public void displayInfo() {

        System.out.println("Version Number:" + this.getVersionNumber());
        System.out.println("Battery Percentage:" + this.getBatteryPercentage());
        System.out.println("Carrier:" + this.getCarrier());
        System.out.println("Ring Tone:" + this.getRingTone());
    }
}

