public class AttendanceRule implements IEligibilityRule {
    public Eligible eval(StudentProfile s) {
        if (s.attendancePct < 75) {
            return new Eligible(false, "attendance below 75");
        }
        return new Eligible(true, null);
    }
}
