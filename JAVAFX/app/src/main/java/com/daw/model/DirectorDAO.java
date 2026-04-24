package com.daw.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.daw.utils.Db;

public class DirectorDAO extends CrudDAO implements AutoCloseable{
private Connection con;
    public DirectorDAO() {
        super();
        this.con = Db.conectar();
        // llamamos al constructor de CrudDAO Con super
        // Para conectar a bd
        this.nombreTabla = "director";
        this.campos = Arrays.asList("id", "nombre", "nacionalidad", "anyo_nacimiento");

        
    }

    public ResultSet getDirector() {

        ResultSet rs = null;

        try {
            // Creamos la consulta sql
            String query = "select * from director";

            // Creamos la sentencia
            Statement stmt = this.con.createStatement();

            // Ejecutamos y guardamos los datos en un resultset
            rs = stmt.executeQuery(query);

        } catch (Exception e) {
            System.out.println("Hubo un problema con la BD");
            e.printStackTrace();
        }

        return rs;

    }

    public int crearDirector(String nombre, String nacionalidad, int anyo_nacimiento) {

        int columnasModificadas = -1;
        try {
            String query = "insert into director (nombre,nacionalidad,anyo_nacimiento) values (?, ?, ?)";

            PreparedStatement stmt = con.prepareStatement(query);

            stmt.setString(1, nombre);
            stmt.setString(2, nacionalidad);
            stmt.setInt(3, anyo_nacimiento);

            // Ejecutamos y guardamos los datos en un resultset
            columnasModificadas = stmt.executeUpdate();

        } catch (Exception e) {
            System.out.println("Hubo un problema con la BD");
            e.printStackTrace();
        }
        return columnasModificadas;
    }

    public int modificarDirector(int id, HashMap<String, String> campos) {

        int columnasModificadas = -1;

        try {
            String query = "update director set ";

            boolean primerCampo = true;
            for (Map.Entry<String, String> campo : campos.entrySet()) {
                // Si es el primer campo no pongo coma y marco que ya no va a ser el primer
                // Campo para el siguiente campo
                if (primerCampo) {
                    primerCampo = false;
                } else {
                    query += ",";
                }

                query += campo.getKey() + "=?";
            }

            query += " where id = ?";
            PreparedStatement stmt = con.prepareStatement(query);

            int posicion = 1;
            for (Map.Entry<String, String> campo : campos.entrySet()) {

                if (campo.getKey().equals("nombre") || campo.getKey().equals("nacionalidad"))
                    stmt.setString(posicion, campo.getValue());
                else
                    stmt.setInt(posicion, Integer.valueOf(campo.getValue()));

                posicion++;
            }

            System.out.println(query);
            stmt.setInt(posicion, id);

            columnasModificadas = stmt.executeUpdate();

        } catch (Exception e) {
            System.out.println("Hubo un problema con la BD");
            e.printStackTrace();
        }

        return columnasModificadas;

    }

    public int eliminarDirector(int id) {
        int columnasBorradas = -1;
        try {
            String query = "delete from director where id=?";
            PreparedStatement stmt = con.prepareStatement(query);

            stmt.setInt(1, id);
            columnasBorradas = stmt.executeUpdate();

        } catch (Exception e) {
            System.out.println("hubo un problema al borrar la id " + id);
            e.printStackTrace();
        }

        return columnasBorradas;
    }

    @Override
    public void close() throws Exception {
        this.con.close();
    }

}
