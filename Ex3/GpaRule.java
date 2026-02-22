public class GpaRule implements IEligibilityRule {
    @Override
    public ValidationResult validate(StudentProfile s) {
        if (s.cgr < 8.0) {
            return ValidationResult.invalid("CGR below 8.0");
        }
        return ValidationResult.valid();
    }
}