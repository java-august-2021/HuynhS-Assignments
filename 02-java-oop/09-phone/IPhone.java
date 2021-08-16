public class IPhone extends Phone implements Ringable {


    public IPhone(String versionNumber, int batteryPercentage, String carrier, String ringTone)
    {
        super(versionNumber, batteryPercentage, carrier, ringTone);
    };

    public String ring(){
        return "Ring Ring Ring";
    }
    public String unlock(){
        return "Phone is unlocked";
    }



    public void displayInfo(){
        System.out.printf("VersionNumber: %s - Battery Percentage: %d - Carrier: %s - Ring Tone: %s", this.getVersionNumber(), this.getBatteryPercentage(), this.getCarrier(), this.getRingTone());

        System.out.println("Version Number:" + this.getVersionNumber());
        System.out.println("Battery Percentage:" + this.getBatteryPercentage());
        System.out.println("Carrier:" + this.getCarrier());
        System.out.println("Ring Tone:" + this.getRingTone());
    };


}
