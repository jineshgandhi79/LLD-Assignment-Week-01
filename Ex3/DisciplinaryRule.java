public class DisciplinaryRule implements IEligibilityRule {
    @Override
    public ValidationResult validate(StudentProfile s) {
        if (s.disciplinaryFlag != LegacyFlags.NONE) {
            return ValidationResult.invalid("disciplinary flag present");
        }
        return ValidationResult.valid();
    }
}