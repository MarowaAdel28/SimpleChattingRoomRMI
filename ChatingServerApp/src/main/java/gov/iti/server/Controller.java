package gov.iti.server;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class Controller implements Initializable {

    @FXML
    Button startButton;

    @FXML
    Button stopButton;

    Server server;

    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        
    }

    public Controller () {
        
    }
    @FXML
    public void startServer() {

        server = new Server();
        new Thread(()->server.startServer()).start();
        System.out.println("server started");
    }
    @FXML
    public void stopServer() {
        System.out.println("server stopped");
        server.closeServer();
    }
    
}
