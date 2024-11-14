import java.time.LocalDateTime;
import java.util.List;

public interface NotebookView {     // интерфейс для работы
    void showNotes(List<Note> notes);

    void showMessage(String message);

    LocalDateTime getDateTimeInput();

    String getDescriptionInput();

    String getFileNameInput();
}
