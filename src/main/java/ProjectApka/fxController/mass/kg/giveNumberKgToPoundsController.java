package ProjectApka.fxController.mass.kg;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class giveNumberKgToPoundsController extends GiveToKG {


    public void initialize() throws Exception {

        convertButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    double value = Double.parseDouble(textAreaButton.getText());
                    String stringValue = String.valueOf(mass.kilogramToPunds(value));
                    textAreaButton.setText(stringValue);
                } catch (IllegalArgumentException e) {
                    textAreaButton.setText("Podaj liczbę!!");
                }
            }

        });

///////////////////////////////////////////////////////////////////////////////////

        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                Stage stage = (Stage) backButton.getScene().getWindow();


                try {
                    VBox mainPane = FXMLLoader.load(getClass().getResource("/fxml/mass/Kg/kgToPane.fxml"));
                    Scene scene = new Scene(mainPane);

                    stage.setScene(scene);
                    stage.setTitle("Kg-Wybor");
                    stage.show();
                    stage.setAlwaysOnTop(true);
                    stage.setResizable(true);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
