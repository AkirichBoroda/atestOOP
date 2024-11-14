import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class ConsoleNotebookView implements NotebookView { // клас для работы с консолью с подключением интерфейса
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void showNotes(List<Note> notes) { // переопределенный метод интерфейса для просмотра записей, с выводом об
                                              // отсутствии записей
        if (notes.isEmpty()) {
            System.out.println("No notes found.");
        } else {
            for (Note note : notes) {
                System.out.println(note);
            }
        }
    }

    @Override
    public void showMessage(String message) { // переопределенный метод интерфейса для вывода сообщения
        System.out.println(message);
    }

    @Override
    public LocalDateTime getDateTimeInput() { // переопределенный метод интерфейса для ввода даты для записи
        System.out.println("Enter date and time(yyyy-MM-dd'T'HH:mm):");
        String input = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        return LocalDateTime.parse(input, formatter);
    }

    @Override
    public String getDescriptionInput() {   // переопределенный метод интерфейса для ввода записи
        System.out.println("Enter note description:");
        return scanner.nextLine();
    }

    @Override
    public String getFileNameInput() {  // переопределенный метод интерфейса для ввода имени файла
        System.out.println("Enter file name:");
        return scanner.nextLine();
    }
}