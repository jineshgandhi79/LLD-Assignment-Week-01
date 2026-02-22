public class ValidationResult {
    public final boolean isEligible;
    public final String reason;

    public ValidationResult(boolean isEligible, String reason) {
        this.isEligible = isEligible;
        this.reason = reason;
    }

    public static ValidationResult valid() { return new ValidationResult(true, null); }
    public static ValidationResult invalid(String reason) { return new ValidationResult(false, reason); }
}