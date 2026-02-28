public class CreditsRule implements IEligibilityRule {
    public Eligible eval(StudentProfile s) {
        if (s.earnedCredits < 20) {
            return new Eligible(false, "credits below 20");
        }
        return new Eligible(true, null);
    }
}
