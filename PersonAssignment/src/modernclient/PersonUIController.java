package modernclient;

import javafx.application.Platform;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import modernclient.model.Person;
import modernclient.model.SampleData;

import java.net.URL;
import java.time.LocalDate;
import java.time.chrono.Chronology;
import java.util.ResourceBundle;

public class PersonUIController implements Initializable {

    @FXML    private TextField firstnameTextField;
    @FXML    private TextField lastnameTextField;
    @FXML    private TextArea notesTextArea;
    @FXML    private Button removeButton;
    @FXML    private Button createButton;
    @FXML    private Button updateButton;
    @FXML    private MenuItem exitMenuItem;
    @FXML    private MenuItem aboutMenuItem;
    @FXML    private ListView<Person> listView;
    @FXML    private ComboBox<String> comboBox;
    @FXML    private DatePicker birthDate;
    @FXML    private TextField textFieldBirthDate;
    @FXML    private TextField textFieldGender;

    ObservableList <String> gender = FXCollections.observableArrayList("Female","Male","No gender");


    private final ObservableList<Person> personList = FXCollections.observableArrayList(Person.extractor);
    // Observable objects returned by extractor (applied to each list element) are listened for changes and
    // transformed into "update" change of ListChangeListener.

    private Person selectedPerson;
    private final BooleanProperty modifiedProperty = new SimpleBooleanProperty(false);
    private ChangeListener<Person> personChangeListener;
    private LocalDate t =  LocalDate.of(Integer.parseInt("2021"), Integer.parseInt("4"), Integer.parseInt("11"));

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // Disable the Remove/Edit buttons if nothing is selected in the ListView control
        removeButton.disableProperty().bind(listView.getSelectionModel().selectedItemProperty().isNull());
        updateButton.disableProperty().bind(listView.getSelectionModel().selectedItemProperty().isNull()
                .or(modifiedProperty.not()).or(firstnameTextField.textProperty().isEmpty().or(lastnameTextField.textProperty().isEmpty())));
        createButton.disableProperty().bind(listView.getSelectionModel().selectedItemProperty().isNotNull()
                .or(firstnameTextField.textProperty().isEmpty().or(lastnameTextField.textProperty().isEmpty())));

        SampleData.fillSampleData(personList);

        // Use a sorted list; sort by lastname; then by firstname
        SortedList<Person> sortedList = new SortedList<>(personList);

        // sort by lastname first, then by firstname; ignore notes
        sortedList.setComparator((p1, p2) -> {
            int result = p1.getLastname().compareToIgnoreCase(p2.getLastname());
            if (result == 0) {
                result = p1.getFirstname().compareToIgnoreCase(p2.getFirstname());
            }
            return result;
        });

        listView.setItems(sortedList);

        listView.getSelectionModel().selectedItemProperty().addListener(personChangeListener = (observable, oldValue, newValue) -> {
            System.out.println("Selected item: " + newValue);
            // newValue can be null if nothing is selected
            selectedPerson = newValue;

            // Boolean property modifiedProperty tracks whether the user has changed any of the
            //three text controls in the form. We reset this flag after each ListView selection and use
            //this property in a bind expression to control the Update button’s disable property.
            modifiedProperty.set(false);

            if (newValue != null) {
                // Populate controls with selected Person
                firstnameTextField.setText(selectedPerson.getFirstname());
                lastnameTextField.setText(selectedPerson.getLastname());
                notesTextArea.setText(selectedPerson.getNotes());
                birthDate.setValue(selectedPerson.getDate1());
                comboBox.setValue(selectedPerson.getGender());

            } else {
                firstnameTextField.setText("");
                lastnameTextField.setText("");
                notesTextArea.setText("");
                birthDate.setValue(t);
                comboBox.setValue("No gender");
                
            }
        });

        // Pre-select the first item
        listView.getSelectionModel().selectFirst();


        comboBox.setValue("Select gender");
        comboBox.setItems(gender);



        exitMenuItem.setMnemonicParsing(false);
        exitMenuItem.setOnAction(e -> Platform.exit());
        exitMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.X, KeyCombination.SHORTCUT_DOWN));

    }

    @FXML
    void onExit(ActionEvent event) {
        exitMenuItem.setMnemonicParsing(false);
        exitMenuItem.setOnAction(e -> Platform.exit());
        exitMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.X, KeyCombination.SHORTCUT_DOWN));
    }

    @FXML
    private void handleKeyAction(KeyEvent keyEvent) {
        modifiedProperty.set(true);
    }

    @FXML
    private void createButtonAction(ActionEvent actionEvent) {
        System.out.println("Create");
        //Person person = new Person(firstnameTextField.getText(), lastnameTextField.getText(), notesTextArea.getText(), birthDate.getPromptText(), comboBox.getValue());
        Person person = new Person(firstnameTextField.getText(), lastnameTextField.getText(), notesTextArea.getText(), birthDate.getValue(), comboBox.getValue());
        personList.add(person);
        // and select it
        listView.getSelectionModel().select(person);
    }

    @FXML
    private void removeButtonAction(ActionEvent actionEvent) {
        System.out.println("Remove " + selectedPerson);
        personList.remove(selectedPerson);
    }

    @FXML
    private void updateButtonAction(ActionEvent actionEvent) {
        System.out.println("Update " + selectedPerson);
        Person p = listView.getSelectionModel().getSelectedItem();
        listView.getSelectionModel().selectedItemProperty().removeListener(personChangeListener);
        p.setFirstname(firstnameTextField.getText());
        p.setLastname(lastnameTextField.getText());
        p.setNotes(notesTextArea.getText());
        //p.setDate(birthDate.getAccessibleText());
        p.setDate1(birthDate.getValue());
        p.setGender(comboBox.getValue());
        listView.getSelectionModel().selectedItemProperty().addListener(personChangeListener);
        modifiedProperty.set(false);
    }

    @FXML
    void onAbout(ActionEvent event) {
        Alert informationAlert = new Alert(Alert.AlertType.INFORMATION, "You need to know more about us");
        informationAlert.setTitle("About software");
        // informationAlert.setHeaderText("Look, an Information Dialog");
        informationAlert.setHeaderText(null);
        informationAlert.setContentText("This is a software tool developed using JavaFX\nPlease, be aware it was a quiz assignment!\nDate of dev: 7.03.2021\nDeveloped by Karlygash Kussainova\n+77052358314");
        informationAlert.showAndWait();
    }



    @FXML
    private void handleDateAndGenderUpdate() {
        modifiedProperty.set(true);
    }

    @FXML
    private void handleDateAndGenderUpdate1() {
        modifiedProperty.set(true);
    }



}
