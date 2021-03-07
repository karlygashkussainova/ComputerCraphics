package modernclient.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.util.Date;


public class SampleData {
    private static ObservableList <String> gender = FXCollections.observableArrayList("Female","Male","No gender");
    private static LocalDate birthDate = LocalDate.of(Integer.parseInt("2000"), Integer.parseInt("4"), Integer.parseInt("11"));
    public static void fillSampleData(ObservableList<Person> backingList) {
        backingList.add(new Person("Waldo", "Soller", "random notes 1",LocalDate.of(1998, 01,01),"Male"));
        backingList.add(new Person("Herb", "Dinapoli", "random notes 2",birthDate,"Female"));
        backingList.add(new Person("Shawanna", "Goehring", "random notes 3",birthDate,"Female"));
        backingList.add(new Person("Flossie", "Goehring", "random notes 4",birthDate,"Female"));
        backingList.add(new Person("Magdalen", "Meadors", "random notes 5",birthDate,"Female"));
        backingList.add(new Person("Marylou", "Berube", "random notes 6",birthDate,"Female"));
        backingList.add(new Person("Ethan", "Nieto", "random notes 7",birthDate,"Female"));
        backingList.add(new Person("Elli", "Combes", "random notes 8",birthDate,"Female"));
        backingList.add(new Person("Andy", "Toupin", "random notes 9",birthDate,"Female"));
        backingList.add(new Person("Zenia", "Linwood", "random notes 10",birthDate,"Male"));
    }

    /*
    Glenn Marti
    Waldo Soller
    Herb Dinapoli
    Shawanna Goehring
    Flossie Slack
    Magdalen Meadors
    Marylou Berube
    Ethan Nieto
    Elli Combes
    Andy Toupin
    Zenia Linwood
    Alan Mckeithan
    Kattie Mellott
    Benito Kearns
    Lloyd Cundiff
    Karleen Westrich
    Jada Perrotta
    Teofila Holbert
    Moira Heart
    Mitsuko Earwood
     */
}
