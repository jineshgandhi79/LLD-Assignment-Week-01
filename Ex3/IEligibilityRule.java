public interface IEligibilityRule {
    ValidationResult validate(StudentProfile student);
}