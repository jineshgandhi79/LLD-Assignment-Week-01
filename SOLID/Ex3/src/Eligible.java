public class Eligible {
    private final boolean isEligible;
    private final String reason;
    public Eligible(boolean isEligible, String reason) {
        this.isEligible = isEligible;
        this.reason = reason;
    }
    public boolean isEligible() {
        return isEligible;
    }
    public String getReason() {
        return reason;
    }
    
}
