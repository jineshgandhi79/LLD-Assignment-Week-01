public class CreditsRule implements IEligibilityRule {
    @Override
    public ValidationResult validate(StudentProfile s) {
        if (s.earnedCredits < 20) {
            return ValidationResult.invalid("credits below 20");
        }
        return ValidationResult.valid();
    }
}