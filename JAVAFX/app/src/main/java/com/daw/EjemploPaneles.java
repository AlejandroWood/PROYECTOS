package com.daw;

import com.daw.panels.PeliculaPanel;

import javafx.application.Application;
//import javafx.geometry.Insets;
//import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
//import javafx.scene.control.Button;
//import javafx.scene.control.ComboBox;
//import javafx.scene.control.Label;
//import javafx.scene.control.Slider;
//import javafx.scene.control.TextArea;
//import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
//import javafx.scene.layout.GridPane;
//import javafx.scene.layout.StackPane;
//import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class EjemploPaneles extends Application {

    @Override
    public void start(Stage stage) {

        BorderPane pPrincipal = new BorderPane();
        PeliculaPanel pPelicula = new PeliculaPanel();
        TabPane tPane = new TabPane();
        Tab tPelicula = new Tab("Crear Pelicula");
        Tab tFicheros = new Tab("Abrir Fichero");
        Tab tBot = new Tab("Agente IA");
        tPelicula.setClosable(false);
        tFicheros.setClosable(false);
        tBot.setClosable(false);
        tPane.getTabs().addAll(tPelicula,tFicheros,tBot);

        MenuBar mbPrincipal = new MenuBar();
        Menu mArchivo = new Menu("Archivo");
        Menu mBD = new Menu("Base de Datos");
        Menu mOpciones = new Menu("Opciones");
        Menu mAyuda = new Menu("Ayuda");
        Menu mOperaciones = new Menu("Operaciones");

        MenuItem miAbrir = new MenuItem("Abrir..");
        MenuItem miGuardar = new MenuItem("Guardar..");
        MenuItem miSalir = new MenuItem("Cerrar..");
        SeparatorMenuItem separador = new SeparatorMenuItem();
        mArchivo.getItems().addAll(miAbrir,miGuardar,separador,miSalir);

        MenuItem miCrearPelicula = new MenuItem("Crear Pelicula");
        MenuItem miBorrarPelicula = new MenuItem("Borrar Pelicula");
        mBD.getItems().add(mOperaciones);
        mOperaciones.getItems().addAll(miCrearPelicula,miBorrarPelicula);

        mbPrincipal.getMenus().addAll(mArchivo,mBD,mOpciones,mAyuda);

        miSalir.setOnAction(e -> {
            stage.close();
        });

        miCrearPelicula.setOnAction(e -> {
            tPane.getSelectionModel().select(tPelicula);
        });


        pPrincipal.setCenter(tPane);
        pPrincipal.setTop(mbPrincipal);
        tPelicula.setContent(pPelicula);

        // Creamos una escena que contiene al gridpane
        Scene scene = new Scene(pPrincipal, 800, 600);
        // Asignamos la escena al stage
        stage.setScene(scene);
        stage.setTitle("Ejemplo Paneles");
        // Mostramos la app
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}