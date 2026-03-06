import java.util.*;

public class OnboardingService {
    private final FakeDb db;
    private final ParseStudent ps;
    private final ValidateStudent vs;

    public OnboardingService(FakeDb db) { 
        this.db = db;
        this.vs = new ValidateStudent();
        this.ps = new ParseStudent();
    }

    public void registerFromRawInput(String raw) {
        
        StudentDTO dto = ps.parseStudent(raw);
        List<String> errors = vs.validate(dto);
        
        if (!errors.isEmpty()) {
            System.out.println("ERROR: cannot register");
            for (String e : errors) System.out.println("- " + e);
            return;
        }

        String id = IdUtil.nextStudentId(db.count());
        StudentRecord rec = new StudentRecord(id, dto.name, dto.email, dto.phone, dto.program);

        db.save(rec);

        System.out.println("OK: created student " + id);
        System.out.println("Saved. Total students: " + db.count());
        System.out.println("CONFIRMATION:");
        System.out.println(rec);
    }
}