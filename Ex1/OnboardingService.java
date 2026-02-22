import java.util.*;

public class OnboardingService {
    private final IStudentRepository repository;
    private final StudentParser parser;
    private final StudentValidator validator;
    private final IdGenerator idGenerator;
    private final ViewRenderer renderer;

    public OnboardingService(IStudentRepository repository) {
        this.repository = repository;
        this.parser = new StudentParser();
        this.validator = new StudentValidator();
        this.idGenerator = new IdGenerator();
        this.renderer = new ViewRenderer();
    }

    public void registerFromRawInput(String raw) {
        renderer.printInput(raw);

        Map<String, String> data = parser.parseRawInput(raw);
        List<String> errors = validator.validate(data);

        if (!errors.isEmpty()) {
            renderer.printErrors(errors);
            return;
        }

        String id = idGenerator.generateNextId(repository.count());
        StudentRecord record = new StudentRecord(
            id,
            data.get("name"),
            data.get("email"),
            data.get("phone"),
            data.get("program")
        );

        repository.save(record);
        renderer.printSuccess(record, repository.count());
    }
}