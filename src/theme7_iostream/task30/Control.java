package theme7_iostream.task30;

import java.io.*;

public class Control {
    private File file;
    private MainView mainView;
    private String text;



    public Control(MainView mainView) {
        this.mainView = mainView;

    }

    public void setSelectedFile(File file) {
        this.file = file;
        text = readFile();
    }

    public String getFileName() {
        if (file == null) {
            return "Файл не выбран";
        }
        return file.toString();
    }
    public String getText() {
        return text.isEmpty() ? "null" : text;
    }
    public String readFile() {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while (true) {
                String line = reader.readLine();
                if (line == null) {
                    break;
                }
                sb.append(line).append("\n");
            }
        } catch (FileNotFoundException e) {
            /**/
        } catch (IOException e) {
            /**/
        }
        return sb.toString();
    }

    public String countPuncts() {
        long count =  text.chars().filter(c -> String.valueOf((char) c).matches("\\p{Punct}")).count();
        return count > 0 ? String.format("Найдено %d знака пунктуации", count) : "Знаков препинания не найдено";
    }

    public String countWords() {
        long count = text.trim().split("[\\s\\p{Punct}]+").length;
        return count > 0 ? String.format("Найдено %d слов", count) : "Слов не найдено";
    }
}
