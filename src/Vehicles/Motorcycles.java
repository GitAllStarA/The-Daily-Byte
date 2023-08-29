package Vehicles;

 public class Motorcycles /*extends Vehicles*/ {

    String bikeName;
    String VIN;
    String keyLocks;

    public void setBikeName(String bikeName) {
        this.bikeName = bikeName;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public void setKeyLocks(String keyLocks) {
        this.keyLocks = keyLocks;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    String registration;

    public String getBikeName() {
        return bikeName;
    }

    String getRegistration() {
        return registration;
    }

    protected String getVIN(){
        return VIN;
    }

    private String getKeyLocks() {
        return keyLocks;
    }


    //@Override
   // public void create(String type, int wheels, String engine) {
      //  super.create(type, wheels, engine);
  //  }
}