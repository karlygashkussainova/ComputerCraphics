package todo.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import todo.model.Schedule;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class CalendarController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ListView<Schedule> listview;

    @FXML
    private DatePicker date;

    @FXML
    private TextField title;

    @FXML
    private TextArea text;

    @FXML
    private ColorPicker color;

    @FXML
    private Button save;

    @FXML
    private Button delete;

    ObservableMap<String, Schedule> map = FXCollections.observableHashMap();

    @FXML
    void initialize() {
        date.setValue(LocalDate.now());
        listview.setOnMouseClicked(event -> {
            Schedule schedule = listview.getSelectionModel().getSelectedItem();
            date.setValue(schedule.getLocalDate());
            text.setText(schedule.getText());
            title.setText(schedule.getTitle());
            title.setStyle("-fx-control-inner-background: #" + schedule.getColor().toString().substring(2, 8) + ";");
            color.setValue(schedule.getColor());
        });


    }

    @FXML
    public void onSave(){
        if(map.containsKey(title.getText())){
            Schedule schedule = map.get(title.getText());
            schedule.setLocalDate(date.getValue());
            title.setStyle("-fx-control-inner-background: #" + color.getValue().toString().substring(2, 8) + ";");
            schedule.setText(text.getText());
            schedule.setColor(color.getValue());
            map.put(title.getText(), schedule);
            listview.setItems(FXCollections.observableArrayList(map.values()));
            System.out.println(color.getValue().toString().substring(1, 7));
        } else{
            title.setStyle("-fx-control-inner-background: #" + color.getValue().toString().substring(2, 8) + ";");
            Schedule schedule = new Schedule(date.getValue(), title.getText(), text.getText(), color.getValue());
            map.put(title.getText(), schedule);
            listview.setItems(FXCollections.observableArrayList(map.values()));
        }

    }

    @FXML
    public void onDelete(){
        map.remove(title.getText());
        listview.setItems(FXCollections.observableArrayList(map.values()));
    }
}

