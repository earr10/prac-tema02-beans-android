package earr.com.practema02beans;

import android.content.Context;

public class Usuarios {
    private String nombre = "";
    private String direccion = "";
    private double peso = 0.0;
    private int edad = 0;
    BD objeto = null;

    public Usuarios(Context c) {
        objeto = new BD(c, "usuariosEmpresa", null, 2);//modelo
    }

    public String insertar(String n, String d, String p, int e) {
        //Memoria volatil RAM
        String regreso = "";
        this.nombre = n;
        this.direccion = d;
        this.peso = Double.parseDouble(p);
        if (edad <= 5 && edad >= 1) {
            this.edad = e;
        } else {
            this.edad = 0;
        }
        String texto = objeto.insertar(this.nombre, this.direccion, String.valueOf(this.peso), this.edad);
        return texto;
    }

    public String eliminar(String id) {
        String resultado = "";
        this.nombre = null;
        this.direccion = null;
        this.peso = 0;
        this.edad = 0;
        String texto = objeto.eliminar(id);
        return texto;
    }

    public String actualizar(String id, String n, String d, String p, int e) {
        //Memoria RAM
        this.nombre = n;
        this.direccion = d;
        this.peso = Double.parseDouble(p);
        this.edad = e;
        String texto = objeto.actualizar(id, this.nombre, this.direccion, String.valueOf(this.peso), this.edad);
        return texto;
    }

    public String buscar(String id) {
        String texto = "";
        String datos[] = objeto.buscar(id);
        for (int i = 0; i <= 4; i++) {
            texto += datos[i] + " ";
        }
        return texto;
    }

    public String getNombre() {
        return nombre;
    }
}