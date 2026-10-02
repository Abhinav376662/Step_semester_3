public class Locker {
    private final int lockerNumber;
    private String combinationCode;
    
    public Locker(int lockerNumber, String initialCode) {
        this.lockerNumber = lockerNumber;
        this.combinationCode = initialCode;
    }
    
    public boolean changeCode(String currentCode, String newCode) {
        if (currentCode.equals(this.combinationCode)) {
            this.combinationCode = newCode;
            return true;
        }
        return false; // Wrong current code — change rejected
    }
    
    public int getLockerNumber() {
        return lockerNumber;
    }
    
    // NO getter for combinationCode — it's write-only via changeCode()
}
