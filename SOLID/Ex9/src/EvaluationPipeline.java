public class EvaluationPipeline {
    IRubric rubric;
    IPlagiarismChecker pc;
    ICodeGrader grader;
    IReportWriter writer;

    
    public EvaluationPipeline(IRubric rubric, IPlagiarismChecker pc, ICodeGrader grader, IReportWriter writer) {
        this.rubric = rubric;
        this.pc = pc;
        this.grader = grader;
        this.writer = writer;
    }


    // DIP violation: high-level module constructs concretes directly
    public void evaluate(Submission sub) {
        int plag = pc.check(sub);
        System.out.println("PlagiarismScore=" + plag);

        int code = grader.grade(sub, rubric);
        System.out.println("CodeScore=" + code);

        String reportName = writer.write(sub, plag, code);
        System.out.println("Report written: " + reportName);

        int total = plag + code;
        String result = (total >= 90) ? "PASS" : "FAIL";
        System.out.println("FINAL: " + result + " (total=" + total + ")");
    }
}