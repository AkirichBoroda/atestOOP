import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) { // точка входа в программу
        Notebook model = new Notebook(); // инициализация записной книжки
        NotebookView view = new ConsoleNotebookView();  // инициализация интерфейса просмотра записной книжки в консоли
        NotebookPresenter presenter = new NotebookPresenter(model, view); // инициализация презентора записной книжки
        Scanner scanner = new Scanner(System.in);
        while (true) { // цикл работы с записной книжкой
            System.out.println("1. Add Note"); // отображение интерфейса пользователя
            System.out.println("2. Show Notes for Day");
            System.out.println("3. Show Notes for Week");
            System.out.println("4. Save Notes");
            System.out.println("5. Load Notes");
            System.out.println("6. Exit");
            int choice = scanner.nextInt(); // запуск сканера для ввода с клавиатуры
            scanner.nextLine(); 
            switch (choice) {   // свитч для определения того, что выбрал пользователь
                case 1:
                    presenter.addNote();    // добавление записи в память
                    break;
                case 2:
                    presenter.showNotesForDay(); // отображение записей на день
                    break;
                case 3:
                    presenter.showNotesForWeek();   // отображение записей на неделю
                    break;
                case 4:
                    presenter.saveNotes();  // созранение записей в файл из памяти программы
                    break;
                case 5:
                    presenter.loadNotes();  // загрузка записей в память программы из файла
                    break;
                case 6: // выход из программы
                    return;
                default:
                    System.out.println("Invalid choice"); // защита от дурака, при неправильном вводе номера меню
            }
        }
    }
}