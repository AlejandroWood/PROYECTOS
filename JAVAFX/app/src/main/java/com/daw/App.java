package com.daw;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {

        //Label para el nombre (Etiqueta de texto)
        Label lblNombre = new Label("Nombre: ");
        Label lblMensaje = new Label("");
        Label lblBanner = new Label("App Mutante");
        Label lblSlider = new Label("50");
        lblBanner.setScaleX(4);
        lblBanner.setScaleY(4);

        //Input de texto para guardar el valor
        TextField txtNombre = new TextField("");
        txtNombre.setMaxWidth(200);

        //Botón para pulsar
        Button btnNombre = new Button("GO!!!");

        //Creamos un Slider
        Slider sldPuntuacion = new Slider(0, 100, 50);

        //Panel para añadir los elementos
        VBox vPanel = new VBox();

        //Espacio entre los elementos de VBox
        vPanel.setSpacing(20);

        /*
         * Espaciado interior, se utiliza insets y va en el siguiente orden
         * Arriba, Derecha, Abajo, Izquierda
         */
        vPanel.setPadding(new Insets(10,0,10,200));

        vPanel.getChildren().addAll(lblNombre,txtNombre,btnNombre);

        /*Creamos un borderpane, que está dividido en 5 zonas
        central, superior, inferior, derecha e izquierda */
        BorderPane panelPrincipal = new BorderPane();
        panelPrincipal.setCenter(vPanel);
        panelPrincipal.setTop(lblBanner);
        panelPrincipal.setBottom(sldPuntuacion);
        panelPrincipal.setRight(lblSlider);

        /*
        *Para alinear elementos dentro de una posicion de un panelPrincipal
        *podemos utilizar setAlignment, elegir el nodo
        *y con pos. seleccionar la alineacion
        */
        panelPrincipal.setAlignment(lblBanner, Pos.CENTER);
        panelPrincipal.setPadding(new Insets(20));

        //Cuando se presione el botón se ejecutará lo siguiente
        btnNombre.setOnAction( e ->{
            lblMensaje.setText("Bienvenido a tu primera App, " + txtNombre.getText());
            vPanel.getChildren().add(lblMensaje);
        });
        sldPuntuacion.setOnMouseDragged( e ->{
            lblSlider.setText("Valor: " + (int) sldPuntuacion.getValue());
        });

        //Añadimos el VBOX a la escena
        var scene = new Scene(panelPrincipal, 640, 480);

        stage.setTitle("Aplicación Mutante");
        stage.setHeight(500);
        stage.setWidth(900);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}