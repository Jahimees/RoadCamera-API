package by.jnetworks.roadcameraapi.entity;

public class RegisteredCarCount {

    private static RegisteredCarCount registeredCarCountObj;
    private long registeredCarCount;

    private RegisteredCarCount() {

    }

    public static RegisteredCarCount getInstance() {
        if (registeredCarCountObj == null) {
            registeredCarCountObj = new RegisteredCarCount();
        }
        return registeredCarCountObj;
    }

    public long getRegisteredCarCount() {
        return registeredCarCount;
    }

    public void setRegisteredCarCount(long registeredCarCount) {
        this.registeredCarCount = registeredCarCount;
    }
}
