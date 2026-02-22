import java.util.List;

public interface IStudentRepository {
    void save(StudentRecord record);
    int count();
    List<StudentRecord> all();
}