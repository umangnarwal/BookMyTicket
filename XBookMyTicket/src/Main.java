

import java.io.File;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author dean
 */
public class Main extends Application implements Runnable {
  
  public static void runit()
  {launch();}
  String vid;
  public static void main (String[] args) {
    
  }
  
  public static void thrd()
  {     Main mn=new Main();
        Thread t = new Thread(mn);
        t.start();
  }
  @Override
  public void start(Stage primaryStage) {
    
    String workingDir = System.getProperty("user.dir");
    final File f = new File(workingDir, "zedd.mp4");
    final Media m = new Media(f.toURI().toString());
  
    final MediaPlayer mp = new MediaPlayer(m);
    final MediaView mv = new MediaView(mp);
    
    final DoubleProperty width = mv.fitWidthProperty();
    final DoubleProperty height = mv.fitHeightProperty();
    
    width.bind(Bindings.selectDouble(mv.sceneProperty(),"width"));
    height.bind(Bindings.selectDouble(mv.sceneProperty(),"height"));
    
   // mv.setPreserveRatio(true);
    
    StackPane root = new StackPane();
    root.getChildren().add(mv);
    
    final Scene scene = new Scene(root, 700, 600);
    scene.setFill(Color.BLACK);
    
    MediaControl mediaControl = new MediaControl(mp);
    scene.setRoot(mediaControl);
    primaryStage.setScene(scene);
    primaryStage.setTitle("Trailer");
    // primaryStage.setFullScreen(true);
    primaryStage.show();
    
    mp.play();
  }

    @Override
    public void run() {
        this.runit();
    }

 
}
