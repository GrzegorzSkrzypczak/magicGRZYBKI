package fxController.Mass.Pounds;

import data.Mass;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class giveNumberPoundsToKgController {

    @FXML
    private TextArea textAreaButton;

    @FXML
    private Button convertButton;

    @FXML
    private Button backButton;

    Mass mass = new Mass();

    public void initialize() {

        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Stage stage = (Stage)backButton.getScene().getWindow();

                try {
                    VBox mainPane = FXMLLoader.load(getClass().getResource("/fxml/Mass/Pounds/poundToPane.fxml"));
                    Scene scene = new Scene(mainPane);
                    stage.setScene(scene);
                    stage.setTitle("Pound-Wybór");
                    stage.show();
                    stage.setAlwaysOnTop(true);
                    stage.setResizable(true);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });










        convertButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String textOkno = textAreaButton.getText();
                double doublezTextOkno = Double.parseDouble(textOkno);
                double result = mass.poundsToKilograms(doublezTextOkno);
                String stringzResult = String.valueOf(result);
                textAreaButton.setText(stringzResult);
//                textAreaButton.setText(String.valueOf(mass.poundsToKilograms(Double.parseDouble(textAreaButton.getText()))));
                // TODO Skrócony zapis // ucz sie

            }
        });
    }

}