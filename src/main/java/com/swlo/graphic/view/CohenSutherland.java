package com.swlo.graphic.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class CohenSutherland extends Application {

    @Override
    public void start(Stage stage) {
        // Cria um Canvas para desenhar as retas
        Canvas canvas = new Canvas(300, 200);

        // Cria um TextField para inserir os pontos das retas
        TextField textField = new TextField();
        textField.setPrefWidth(100);

        // Adiciona os componentes à tela
        Pane pane = new Pane();
        pane.getChildren().addAll(canvas, textField);

        // Define a cena
        Scene scene = new Scene(pane, 300, 200);

        // Mostra a tela
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}