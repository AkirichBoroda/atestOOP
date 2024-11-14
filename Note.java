import java.time.LocalDateTime;

public class Note { // создание класса для записей
    private LocalDateTime dateTime; // поля класса
    private String description;

    public Note(LocalDateTime dateTime, String description) {   // метод конструктор для создании записи
        this.dateTime = dateTime;
        this.description = description;
    }

    public LocalDateTime getDateTime() {   // геторы для работы с записью
        return dateTime;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {  // переопределение метода для вывода записи по определенному шаблону
        return dateTime.toString() + ": " + description;
    }
}
