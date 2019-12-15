package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;


public class HeroSelectionController {
    @FXML
    private Button Clement;
    @FXML
    private Button Maxime;

    private boolean isFirstCharacterSelected = false, isSecondCharacterSelected = false;
    private boolean finalState;
    private Object firstCharacterSelected, secondCharacterSelected;

    /**
     * @param e is an ActionEvent. Can gives the source and the target.
     * @throws Exception throws by the 'start' function.
     *                   <p>
     *                   This event is consumed by different buttons from the HeroSelection.
     *                   It avoid different errors : If same Hero is selected two times, if only one hero is selected the game will not start.
     * @author Clément GUYON
     */
    @FXML
    private void characterSelected(ActionEvent e) throws Exception {
        if (!isFirstCharacterSelected) {
            isFirstCharacterSelected = true;
            firstCharacterSelected = e.getSource();
        } else {
            if (isFirstCharacterSelected && !isSecondCharacterSelected) {
                if (e.getTarget() != firstCharacterSelected) {
                    isSecondCharacterSelected = true;
                    secondCharacterSelected = e.getSource();
                    if (updateFinalState()) {
                        start();
                    }

                } else {
                    Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                    errorAlert.setTitle("You can't chose the same character.");
                    errorAlert.setHeaderText("Character Selection Error.");
                    errorAlert.setContentText("The first player has taken :" + firstCharacterSelected);
                    errorAlert.show();

                    System.err.println("Same Character Selected");
                }
            }
        }
    }

    /**
     * @return finalState boolean to check if two different character are selected
     * @author Clément GUYON
     */
    private boolean updateFinalState() {
        finalState = isFirstCharacterSelected && isSecondCharacterSelected;
        return finalState;
    }

    /**
     * @author Clément GUYON
     * Set the background of each buttons
     */
    @FXML
    private void initialize() {
        Clement.setStyle("-fx-background-image: url('img/BombMan/Walk/1.png');-fx-background-repeat: no-repeat no-repeat");
    }

    /**
     * @throws IOException throwable by loader.load()
     *                     This function is call if two character are selected. It creates new window of the Game.
     * @author Clément GUYON
     */
    private void start() throws IOException {
        Stage heroSelectionStage = new Stage();
        heroSelectionStage.initModality(Modality.APPLICATION_MODAL);
        heroSelectionStage.setResizable(false);

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/InGame.fxml"));
        loader.setController(new GameController(loader.load(), heroSelectionStage));
    }
}
