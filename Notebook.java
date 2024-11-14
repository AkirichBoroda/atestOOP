import java.io.*;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class Notebook {     // создание класса Notebook
    private List<Note> notes = new ArrayList<>();   // поле класса списком записей

    public void add(Note note) {    // метод добавления записи в записную книжку Notebook
        notes.add(note);
    }

    public List<Note> getNotes() {  // гетор для предоставления записей
        return new ArrayList<>(notes);
    }

    public List<Note> getNotesForDay(LocalDateTime dateTime) {  // гетор с сортировкой по дням для записей
        return notes.stream()
                .filter(note -> note.getDateTime().toLocalDate().isEqual(dateTime.toLocalDate()))
                .sorted(Comparator.comparing(Note::getDateTime))
                .collect(Collectors.toList());
    }

    public List<Note> getNotesForWeek(LocalDateTime startOfWeek) {  // гетор с сортировкой по неделе для записей
        LocalDateTime endOfWeek = startOfWeek.plusWeeks(1);
        return notes.stream()
                .filter(note -> !note.getDateTime().isBefore(startOfWeek) &&
                        !note.getDateTime().isAfter(endOfWeek))
                .sorted(Comparator.comparing(Note::getDateTime))
                .collect(Collectors.toList());
    }

    public void saveToFile(String fileName) throws IOException {    // метод для записи в файл из класса Notebook
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Note note : notes) {
                writer.write(note.toString());
                writer.newLine();
            }
        }
    }

    public void loadFromFile(String fileName) throws IOException {  // метод выгрузки записей из файла
        notes.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(": ", 2);
                LocalDateTime dateTime = LocalDateTime.parse(parts[0]);
                String description = parts[1];
                notes.add(new Note(dateTime, description));
            }
        }
    }
}
