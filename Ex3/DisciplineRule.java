public class DisciplineRule implements IEligibilityRule {
    public Eligible eval(StudentProfile s) {
        if (s.disciplinaryFlag != LegacyFlags.NONE) {
            return new Eligible(false, "disciplinary flag present");
        }
        return new Eligible(true, null);
    }
}
