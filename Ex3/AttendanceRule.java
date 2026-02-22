public class AttendanceRule implements IEligibilityRule {
    @Override
    public ValidationResult validate(StudentProfile s) {
        if (s.attendancePct < 75) {
            return ValidationResult.invalid("attendance below 75");
        }
        return ValidationResult.valid();
    }
}