


import java.io.File;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class EmbeddedMediaPlayer extends Application {

    private static final String MEDIA_URL =
            "C:/Users/Ronster/Desktop/bookmyshow-java-master/waiting.mp4";

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Embedded Media Player");
        Group root = new Group();
        Scene scene = new Scene(root, 540, 241);
        
        String workingDir = System.getProperty("user.dir");
        final File f = new File(workingDir, "waiting.mp4");
        final Media m = new Media(f.toURI().toString());
        // create media player
      //  Media media = new Media (MEDIA_URL);
        MediaPlayer mediaPlayer = new MediaPlayer(m);
        final MediaView mv = new MediaView(mediaPlayer);
        final DoubleProperty width = mv.fitWidthProperty();
        final DoubleProperty height = mv.fitHeightProperty();
        width.bind(Bindings.selectDouble(mv.sceneProperty(),"width"));
        height.bind(Bindings.selectDouble(mv.sceneProperty(),"height"));
        mv.setPreserveRatio(true);
        mediaPlayer.setAutoPlay(true);
        MediaControl mediaControl = new MediaControl(mediaPlayer);
        scene.setRoot(mediaControl);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
