package katheryne.gui;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import katheryne.Katheryne;
import katheryne.Message;
import katheryne.exceptions.InvalidInputException;
import katheryne.exceptions.MissingInformationException;

/**
 * Controller for the main GUI.
 */
public class MainWindow extends AnchorPane {
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;

    private Katheryne katheryne;

    private Image userImage = new Image(this.getClass().getResourceAsStream("/images/Piamon.png"));
    private Image katheryneImage = new Image(this.getClass().getResourceAsStream("/images/Katheryne.png"));

    @FXML
    public void initialize() {
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
        String greeting = Message.MESSAGE_GREETING;
        dialogContainer.getChildren().add(
                DialogBox.getKatheryneDialog(greeting, katheryneImage));
    }

    /** Injects the Duke instance */
    public void setKatheryne(Katheryne k) {
        katheryne = k;
    }

    /**
     * Creates two dialog boxes, one echoing user input and the other containing Duke's reply and then appends them to
     * the dialog container. Clears the user input after processing.
     */
    @FXML
    private void handleUserInput() throws MissingInformationException, InvalidInputException {
        String input = userInput.getText();
        String response = katheryne.getResponse(input);
        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(input, userImage),
                DialogBox.getKatheryneDialog(response, katheryneImage)
        );
        userInput.clear();
        if (input.equals("bye")) {
            PauseTransition delay = new PauseTransition(Duration.seconds(5));
            delay.setOnFinished(event -> System.exit(0));
            delay.play();
        }
    }
}


