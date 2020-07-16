package sample;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;



import javafx.collections.FXCollections;





public class Controller {

    private ObservableList<User> usersData = FXCollections.observableArrayList();

    @FXML
    private Button cleanButton;

    @FXML
    private Button exitButton;

    @FXML
    private Button randomButton;

    @FXML
    private Button fillButton;

    @FXML
    private TextField aField;

    @FXML
    private TextField bField;

    @FXML
    private TableView<User> rezultTable;

    @FXML
    private TableColumn<User, Double> tableColumnK;

    @FXML
    private TableColumn<User, String> tableColumnY;

    @FXML
    void initialize() {

        // подготавливаем данные для таблицы
        double[] arrayK = new double[10];
        for (int i=0; i<arrayK.length; i++)
            arrayK[i]=Math.random() *50;

        for (int i=0; i<arrayK.length; i++)
            usersData.add(new User(arrayK[i],""));


        // устанавливаем тип и значение которое должно хранится в колонке
        tableColumnK.setCellValueFactory(new PropertyValueFactory<User, Double>("K"));
        tableColumnY.setCellValueFactory(new PropertyValueFactory<User, String>("Y"));

        // заполняем таблицу данными
        rezultTable.setItems(usersData);

        exitButton.setOnAction(actionEvent -> {
            System.exit(1);
        });

        cleanButton.setOnAction(actionEvent -> {
            aField.clear();
            bField.clear();
        });

        randomButton.setOnAction(actionEvent -> {
            double a=(Math.random() * 50) -25;
            double b=(Math.random() * 50) -25;
            aField.setText(Double.toString(a));
            bField.setText(Double.toString(b));
        });

        fillButton.setOnAction(actionEvent -> {
            double a=Double.valueOf(aField.getText());
            double b=Double.valueOf(bField.getText());

            double[] arrayY= new double[10];
            double sumK=0;
            for (int i=1; i<arrayY.length; i++) {
                sumK+=arrayK[i-1];
                arrayY[i]=Math.sqrt((Math.cos(arrayK[i])*Math.cos(arrayK[i]))/((a*a+b*b) - Math.sin(arrayK[i])))*sumK;
            }

            usersData.clear();
            usersData.add(new User(arrayK[0],"-"));
            for (int i=1; i<arrayK.length; i++){
                usersData.add(new User(arrayK[i],Double.toString(arrayY[i])));
            }



        });
    }



}
