import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.stage.Stage;

public class EndScreen{
    
    /**
     * Creates end Screen based on whether you lose or win, 
     * displays victory and defeat screen
     * Added button for replay and quit
     * @Author Jason Arluck
     * @Precon Stage is a valid stage, not blank or null
     * @Precon won must be true or false
     * @return Scene object that will create a new scene for the endscreen, prompting the buttons for replay orr quit.
     */
    public static Scene showEndScreen(Stage stage, boolean won) {
        
        Image backgroundImage = new Image(EndScreen.class.getResourceAsStream(won ? "VictoryScreen.png" : "defeatscreen.jpg"));
        ImageView bg = new ImageView(backgroundImage);
        bg.setFitWidth(500);
        bg.setFitHeight(400);
        //Creates button objects for replay and quit
        Button replay = new Button("Replay");
        Button quit = new Button("Quit");
        //sets up the box surrounding the text
        VBox buttons = new VBox(15, replay, quit);
        buttons.setAlignment(Pos.CENTER);

        StackPane root = new StackPane(bg, buttons);
        //sets up an action when you press the button. Replay will take you back to the main menu.
        replay.setOnAction(e -> {
            try {
                MainMenu menu = new MainMenu();
                menu.start(stage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        //Quit will exit the program
        quit.setOnAction(e -> stage.close());

        return new Scene(root, 500, 400);
    }
}
