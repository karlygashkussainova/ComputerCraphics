package todo.model;

import javafx.scene.paint.Color;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Schedule {
    private LocalDate localDate;
    private String title;
    private String text;
    private Color color;

    public Schedule(LocalDate localDate, String title, String text) {
        this.localDate = localDate;
        this.title = title;
        this.text = text;
    }

    public Schedule(LocalDate localDate, String title, String text, Color color) {
        this.localDate = localDate;
        this.title = title;
        this.text = text;
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
        String text = localDate.format(formatter);
        return  title + " " + text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Schedule schedule = (Schedule) o;
        return Objects.equals(localDate, schedule.localDate) && Objects.equals(title, schedule.title) && Objects.equals(text, schedule.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(localDate, title, text);
    }
}
