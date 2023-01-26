package app;

import app.dados.FileJSONRead;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("openning_interface.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800 , 500);
        stage.setResizable(false);
        stage.initStyle(StageStyle.DECORATED);
        stage.setTitle("Cadastro de funcionários");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        FileJSONRead.loadJSON();
        launch();

    }

    public void changeScene(String s) {
    }
}