package com.examen;

import java.util.Scanner;
import java.sql.ResultSet;
import java.util.HashMap;

import com.examen.model.DirectorDAO;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int id_introducir = 0;
        String nombre_introducir = "";
        String nacionalidad_introducir = "";
        int anyo_nacimiento_introducir = 0;
        int opcion = 0;
        DirectorDAO BDDirectores = new DirectorDAO();
        ResultSet rs = BDDirectores.getDirector();
        int cantidad;
        HashMap<String, String> listaCampos = new HashMap<>();

        while (opcion < 5) {
            System.out.println("Bienvenido a CineManager");
            System.out.println("Gestión de Directores");
            System.out.println();
            System.out.println();
            System.out.println("1. Añadir director");
            System.out.println("2. Modificar director");
            System.out.println("3. Consultar directores");
            System.out.println("4. Eliminar director");
            System.out.println("5. Salir");
            System.out.println();
            System.out.println();
            System.out.print("Opción (1-5): ");
            opcion = teclado.nextInt();
            if (opcion > 5 || opcion < 0) {
                opcion = 0;
            }
            switch (opcion) {
                case 1:
                    System.out.print("Introduzca un nombre: ");
                    nombre_introducir = teclado.next();
                    System.out.print("Introduzca una nacionalidad: ");
                    nacionalidad_introducir = teclado.next();
                    System.out.print("Introduzca un año de nacimiento: ");
                    anyo_nacimiento_introducir = teclado.nextInt();

                    try {
                        cantidad = BDDirectores.crearDirector(nombre_introducir, nacionalidad_introducir, anyo_nacimiento_introducir);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    opcion = 0;
                    break;
                case 2:
                    System.out.print("Introduzca un id: ");
                    id_introducir = teclado.nextInt();
                    System.out.print("Introduzca un nombre: ");
                    nombre_introducir = teclado.next();
                    System.out.print("Introduzca una nacionalidad: ");
                    nacionalidad_introducir = teclado.next();
                    System.out.print("Introduzca un año de nacimiento: ");
                    anyo_nacimiento_introducir = teclado.nextInt();
                    String anyo_nacimiento_string = "" + anyo_nacimiento_introducir;

                    listaCampos.put("nombre", nombre_introducir);
                    listaCampos.put("nacionalidad", nacionalidad_introducir);
                    listaCampos.put("anyo_nacimiento", anyo_nacimiento_string);

                    cantidad = BDDirectores.modificarDirector(id_introducir, listaCampos);
                    opcion = 0;
                    break;
                case 3:
                    rs = BDDirectores.getDirector();
                    try {
                        while (rs.next()) {
                            System.out.println("id:" + rs.getInt("id"));
                            System.out.println("nombre:" + rs.getString("nombre"));
                            System.out.println("nacionalidad:" + rs.getString("nacionalidad"));
                            System.out.println("anyo_nacimiento:" + rs.getInt("anyo_nacimiento"));
                            System.out.println("-----------------------------------\n");
                        }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    opcion = 0;
                    break;
                case 4:
                    System.out.print("Introduce un id: ");
                    id_introducir = teclado.nextInt();
                    try {

            cantidad = BDDirectores.eliminarDirector(id_introducir);

            if (cantidad == 1)
                System.out.println("Se borro bien el director");

        } catch (Exception e) {
            e.printStackTrace();
        }
        opcion = 0;
        break;

    }
        }
        
        teclado.close();
    
        }
    }
