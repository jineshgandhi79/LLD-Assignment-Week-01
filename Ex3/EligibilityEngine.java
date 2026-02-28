import java.util.*;

public class EligibilityEngine {
    private final FakeEligibilityStore store;
    private final ArrayList<IEligibilityRule> eligibilityRules;

    public EligibilityEngine(FakeEligibilityStore store) { 
        this.store = store;
        this.eligibilityRules = new ArrayList<>();
        eligibilityRules.add(new AttendanceRule());
        eligibilityRules.add(new CgrRule());
        eligibilityRules.add(new DisciplineRule());
        eligibilityRules.add(new CreditsRule());;
    }

    public void runAndPrint(StudentProfile s) {
        ReportPrinter p = new ReportPrinter();
        EligibilityEngineResult r = evaluate(s);
        p.print(s, r);
        store.save(s.rollNo, r.status);
    }

    public EligibilityEngineResult evaluate(StudentProfile s) {
        List<String> reasons = new ArrayList<>();

        for(IEligibilityRule eligibilityRule : eligibilityRules) {
            Eligible eligible = eligibilityRule.eval(s);
            if(!eligible.isEligible()) {
                reasons.add(eligible.getReason());
            }
        }

        String status = reasons.isEmpty() ? "ELIGIBLE" : "NOT_ELIGIBLE";

        return new EligibilityEngineResult(status, reasons);
    }
}