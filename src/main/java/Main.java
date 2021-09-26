import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        FXMLLoader dialogLoader = new FXMLLoader(getClass().getResource("view.fxml"));
        Parent root = dialogLoader.load();
        primaryStage.setTitle("Добро пожаловать!");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();

        Controller controller = dialogLoader.getController();

        new UdpService<>(SaleItem.class,
                items -> controller.showItems(items)).start();

    }

    public static void main(String[] args) throws InterruptedException {

        launch(args);

    }
}
