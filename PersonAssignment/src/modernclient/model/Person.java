package modernclient.model;

import javafx.beans.Observable;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.util.Callback;

import java.time.LocalDate;
import java.time.chrono.Chronology;
import java.util.Objects;

public class Person {
    private final StringProperty firstname = new SimpleStringProperty(this, "firstname", "");
    private final StringProperty lastname = new SimpleStringProperty(this, "lastname", "");
    private final StringProperty notes = new SimpleStringProperty(this, "notes", "sample notes");
    //private final StringProperty date = new SimpleStringProperty(this,"date", "");
    private LocalDate date1;
    //private final StringProperty gender = new SimpleStringProperty(this, "gender","");
    //private ObservableList <String> gender = FXCollections.observableArrayList("Female","Male","No gender");
    private LocalDate birthDate;
    private String gender;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if (gender.equals("Male") || gender.equals("Female")) this.gender = gender;
    }


    public Person() {
    }

    public Person(String firstname, String lastname, String notes, LocalDate date1, String gender) {
        this.firstname.set(firstname);
        this.lastname.set(lastname);
        this.notes.set(notes);
       //this.date.set(date);
        this.date1 = date1;
        setGender(gender);
    }

    public String getFirstname() {
        return firstname.get();
    }
    public StringProperty firstnameProperty() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname.set(firstname);
    }
    public String getLastname() {
        return lastname.get();
    }
    public StringProperty lastnameProperty() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname.set(lastname);
    }
    public String getNotes() {
        return notes.get();
    }
    //public String getDate(){return date.get();}
    //public StringProperty dateProperty(){return date;}
    //public void setDate(String date){this.date.set(date);}
    public LocalDate getDate1(){return date1;}
    public void setDate1(LocalDate date1){this.date1 = date1;}




    public StringProperty notesProperty() {
        return notes;
    }
    public void setNotes(String notes) {
        this.notes.set(notes);
    }
    @Override
    public String toString() {
        return firstname.get() + " " + lastname.get();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return Objects.equals(firstname, person.firstname) &&
                Objects.equals(lastname, person.lastname) &&
                Objects.equals(notes, person.notes)&&
                Objects.equals(date1, person.date1) &&
                Objects.equals(gender, person.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname, notes, date1, gender);
    }

    public static Callback<Person, Observable[]> extractor =
            p-> new Observable[] {
                    p.lastnameProperty(), p.firstnameProperty()
            };
}
