package controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SplashScreenController implements Initializable {

    @FXML
    private AnchorPane splash;

    @FXML
    private ImageView splashImageView;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File splashFile = new File("Img/pharmacy_management.jpg");
        Image splashImage = new Image(splashFile.toURI().toString());
        splashImageView.setImage(splashImage);
        new SplashScreen().start();
    }


    class SplashScreen extends Thread {

        @Override
        public void run() {
            try {
                Thread.sleep(2000);

                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        Parent root = null;
                        try {
                            root = FXMLLoader.load(getClass().getResource("/fxml/Home.fxml"));
                        } catch (Exception e) {
                            Logger.getLogger(SplashScreenController.class.getName()).log(Level.SEVERE, null, e);
                        }
                        assert root != null;
                        Scene scene = new Scene(root);
                        Stage stage = new Stage();
                        stage.setScene(scene);
                        stage.initStyle(StageStyle.UTILITY);
//                        stage.setResizable(false);
                        stage.show();

                        splash.getScene().getWindow().hide();
                    }
                });

            } catch (Exception e) {
                Logger.getLogger(SplashScreenController.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }


}
