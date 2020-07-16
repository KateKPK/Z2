package sample;


import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Сложные табличные вычисления в Java");
        primaryStage.setScene(new Scene(root, 1200, 500));
        primaryStage.setResizable(false);
        primaryStage.show();

    }



    public static void main(String[] args) {
        launch(args);
    }
}
