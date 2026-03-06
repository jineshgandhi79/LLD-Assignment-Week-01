public class CgrRule implements IEligibilityRule {
    public Eligible eval(StudentProfile s) {
        if (s.cgr < 8.0) {
            return new Eligible(false, "CGR below 8.0");
        }
        return new Eligible(true, null);
    }
}
