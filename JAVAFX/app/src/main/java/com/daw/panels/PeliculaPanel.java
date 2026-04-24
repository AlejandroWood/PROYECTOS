package com.daw.panels;
import java.sql.SQLException;

import com.daw.model.DirectorDAO;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class PeliculaPanel extends GridPane {
    
    private Label lblTitulo;
    private Label lblClasificacion;
    private Label lblDuracion;
    private Label lblSinopsis;

    public TextField txtTitulo;
    public ComboBox<String> cmbClasificacion;
    public Slider sldDuracion;
    public TextArea txtSinopsis;
    public Button btnReset;
    public Button btnGuardar;
        
    public PeliculaPanel() {

        lblTitulo = new Label("Título:");
        lblClasificacion = new Label("Clasificación:");
        lblDuracion = new Label("Duración:");
        lblSinopsis = new Label("Sinopsis:");

        txtTitulo = new TextField("Escribe un Título...");
        cmbClasificacion = new ComboBox<String>();
        sldDuracion = new Slider(30,600,120);
        txtSinopsis = new TextArea("Escribe una descripción...");
        btnReset = new Button("Borrar");
        btnGuardar = new Button("Guardar");

        this.setHgap(10);
        this.setVgap(8);
        this.setPadding(new Insets(20));
        
        cmbClasificacion.getItems().addAll("Todos los Públicos","+3","+6","+9","+12","+14","+18","Jubilados Only");
        txtSinopsis.setPrefWidth(500);
        txtSinopsis.setPrefHeight(300);

        //Añadimos al gridPane todos los elementos
        this.add(lblTitulo, 0, 0);
        this.add(txtTitulo, 1, 0);
        this.add(lblClasificacion, 0, 1);
        this.add(cmbClasificacion, 1, 1);
        this.add(lblDuracion, 0, 2);
        this.add(sldDuracion, 1, 2);
        this.add(lblSinopsis, 0, 3);
        this.add(txtSinopsis, 1, 3, 3, 3);
        this.add(btnGuardar, 0, 6);
        this.add(btnReset, 1, 6);

        btnReset.setOnAction( e -> {
            reset();
        });

    }

    private void reset() {
        this.txtTitulo.clear();
        this.cmbClasificacion.getSelectionModel().selectFirst();
        sldDuracion.setValue(120);
        txtSinopsis.clear();
    }

    private int guardar() {
        try (DirectorDAO directorDAO = new DirectorDAO()){
            directorDAO.crearDirector(txtTitulo.getText(), txtSinopsis.getText(), sldDuracion);
        } catch (Exception e) {
            
        }
    }
}
