package mx.edu.uacm.is.slt.ds.gestorcode8;


import com.sun.tools.javac.Main;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.application.Application.launch;
import javafx.scene.layout.Pane;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("Menu.fxml"));
            
            Pane ventana = loader.load();
            
            Scene scene = new Scene(ventana);
            
            primaryStage.setScene(scene);
            primaryStage.setTitle("Login");
            primaryStage.show();
            
        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        launch();
        
    }

}