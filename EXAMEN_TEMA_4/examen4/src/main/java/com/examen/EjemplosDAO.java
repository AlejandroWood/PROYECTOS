package com.examen;

import java.sql.ResultSet;
//import java.time.LocalDate;

import com.examen.model.DirectorDAO;

public class EjemplosDAO {
    public static void main(String[] args) {

        DirectorDAO directordb = new DirectorDAO();

        ResultSet rs = directordb.cargarPorId(0);

        try {
            // Recorremos el resultset y mostramos los datos
            while (rs.next()) {
                System.out.println("id:" + rs.getInt("id"));
                System.out.println("nombre:" + rs.getString("nombre"));
                System.out.println("nacionalidad:" + rs.getString("nacionalidad"));
                System.out.println("Año Nacimiento:" + rs.getInt("anyo_nacimiento"));
                System.out.println("-----------------------------------\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        rs = directordb.cargarTodos();

        try {
            // Recorremos el resultset y mostramos los datos
            while (rs.next()) {
                System.out.println("id:" + rs.getInt("id"));
                System.out.println("nombre:" + rs.getString("nombre"));
                System.out.println("nacionalidad:" + rs.getString("nacionalidad"));
                System.out.println("Año Nacimiento:" + rs.getInt("anyo_nacimiento"));
                System.out.println("-----------------------------------\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
