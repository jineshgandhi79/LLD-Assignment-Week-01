import java.util.*;

public class EligibilityEngine {
    private final FakeEligibilityStore store;
    private final List<IEligibilityRule> rules;

    public EligibilityEngine(FakeEligibilityStore store, List<IEligibilityRule> rules) {
        this.store = store;
        this.rules = rules;
    }

    public void runAndPrint(StudentProfile s) {
        ReportPrinter p = new ReportPrinter();
        EligibilityEngineResult r = evaluate(s);
        p.print(s, r);
        store.save(s.rollNo, r.status);
    }

    public EligibilityEngineResult evaluate(StudentProfile s) {
        List<String> reasons = new ArrayList<>();
        
        for (IEligibilityRule rule : rules) {
            ValidationResult res = rule.validate(s);
            if (!res.isEligible) {
                reasons.add(res.reason);
                // Break after first failure to match legacy short-circuit behavior
                break; 
            }
        }

        String status = reasons.isEmpty() ? "ELIGIBLE" : "NOT_ELIGIBLE";
        return new EligibilityEngineResult(status, reasons);
    }
}