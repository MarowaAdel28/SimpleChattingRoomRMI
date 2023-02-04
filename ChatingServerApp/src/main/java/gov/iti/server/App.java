package gov.iti.server;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Hello world!
 *
 */
public class App extends Application {

    static Server server;
    
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader loader = new FXMLLoader();

        Controller control = new Controller();

        loader.setController(control);
        
        Parent root = loader.load(getClass().getResource("/ServerFxml.fxml").openStream());

        //StackPane root = new StackPane();

        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    

    public static void main(String[] args) {
        launch();
/* 
        try (ServerSocket s = new ServerSocket(1286)) {
            server = new Server(s);
            server.startServer();
            System.out.println("server started");
        } catch (IOException e) {
            e.printStackTrace();
        }

        */

    }
}
