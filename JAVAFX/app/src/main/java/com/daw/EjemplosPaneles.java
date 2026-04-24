package com.daw;

import com.daw.panels.PeliculaPanel;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EjemplosPaneles extends Application {
    @Override
    public void start(Stage stage) {
        PeliculaPanel pPelicula = new PeliculaPanel();
        //Creamos una escena que contiene al gridPane
        Scene scene = new Scene(pPelicula, 800, 600);

        //Asignamos la escena al stage
        stage.setScene(scene);

        //Le asignamos un título al stage
        stage.setTitle("Ejemplo Paneles");

        //Mostramos la app
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    } 
}
