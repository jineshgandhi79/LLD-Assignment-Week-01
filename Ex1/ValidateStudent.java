import java.util.ArrayList;
import java.util.List;

public class ValidateStudent {
    public List<String> validate(StudentDTO dto) {
        List<String> errors = new ArrayList<>();
        if (dto.name.isBlank()) errors.add("name is required");
        if (dto.email.isBlank() || !dto.email.contains("@")) errors.add("email is invalid");
        if (dto.phone.isBlank() || !dto.phone.chars().allMatch(Character::isDigit)) errors.add("phone is invalid");
        if (!(dto.program.equals("CSE") || dto.program.equals("AI") || dto.program.equals("SWE"))) errors.add("program is invalid");
        return errors;
    }
}
