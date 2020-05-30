package fxController;

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

public class giveNumberPaneKgToUncjaController {

    @FXML

    private TextArea textAreaButton;

    @FXML
    private Button convertButton;

    @FXML
    private Button backButton;

    Mass mass = new Mass ();


    public void initialize() throws Exception {

        convertButton.setOnAction (new EventHandler<ActionEvent> () {

            @Override
            public void handle(ActionEvent actionEvent) {

                double value = Double.parseDouble (textAreaButton.getText ());
                String stringValue = String.valueOf (mass.kilogramToUncja (value));
                textAreaButton.setText (stringValue);

            }
        });

///////////////////////////////////////////////////////////////////////////////////

        backButton.setOnAction (new EventHandler<ActionEvent> () {
            @Override
            public void handle(ActionEvent actionEvent) {

                Stage stage = (Stage) backButton.getScene ().getWindow ();

                Stage massStage = new Stage ();


                try {
                    VBox mainPane = FXMLLoader.load (getClass ().getResource ("/fxml/kgToPane.fxml"));
                    Scene scene = new Scene (mainPane);

                    stage.setScene (scene);
                    stage.setTitle ("Konwerter");
                    stage.show ();
                    stage.setAlwaysOnTop (true);
                    stage.setResizable (true);
                } catch (IOException e) {
                    e.printStackTrace ();
                }

            }
        });
    }
}
