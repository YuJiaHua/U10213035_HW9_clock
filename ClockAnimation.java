import javafx.application.Application;
import javafx.stage.Stage;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Paint;
import javafx.util.Duration;

public class ClockAnimation extends Application {
  private static final Paint WHITE = null;
  private static final Paint BLACK = null;
  
@Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
	Stage stage = new Stage();
    ClockPane clock = new ClockPane(); // Create a clock
    ControlClock controlClock = new ControlClock();

    // Create a handler for animation
    EventHandler<ActionEvent> eventHandler = e -> {
      clock.setCurrentTime(); // Set a new clock time
    };
    
    // Create an animation for a running clock
    Timeline animation = new Timeline(
      new KeyFrame(Duration.millis(1000), eventHandler));
    animation.setCycleCount(Timeline.INDEFINITE);
    animation.play(); // Start animation
       
    //Add button b1
    Button b1 = new Button("Start");
    b1.setLayoutX(40);
    b1.setLayoutY(10);
    //Add start animation
    b1.setOnAction(e -> animation.play());
    
	  //Add button b2
    Button b2 = new Button("Stop");
    b2.setLayoutX(160);
    b2.setLayoutY(10);
    //Add stop animation
    b2.setOnAction(e -> animation.pause());
    
    controlClock.getChildren().add(b1);
    controlClock.getChildren().add(b2);
    
    // Create a scene and place it in the stage
    Scene scene = new Scene(clock, 250, 250);
    Scene scene2 = new Scene(controlClock, 250, 50);
    primaryStage.setTitle("ClockAnimation"); // Set the stage title
    stage.setTitle("ControlClock");
    primaryStage.setScene(scene); // Place the scene in the stage
    stage.setScene(scene2);
    primaryStage.show(); // Display the stage
    stage.show();
  }

  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}
