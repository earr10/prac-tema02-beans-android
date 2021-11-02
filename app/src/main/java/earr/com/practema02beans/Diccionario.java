package earr.com.practema02beans;

import android.database.Cursor;

public class Diccionario {
    private String crearTabla = "CREATE TABLE usuarios (id INTEGER  PRIMARY KEY AUTOINCREMENT, nombre TEXT, direccion TEXT, peso REAL, edad INTEGER)";
    private String tabla = "usuarios";
    private String borraTabla = "DROP TABLE IF EXISTS usuarios";
    private String datos[] = {"id", "nombre", "direccion", "peso", "edad"};
    private String clausulaWhere1 = "id=?";

    public String getCrearTabla() {
        return crearTabla;
    }

    public String getTabla() {
        return tabla;
    }

    public String[] getDatos() {
        return datos;
    }

    public String getBorraTabla() {
        return borraTabla;
    }

    public String getClausulaWhere1() {
        return clausulaWhere1;
    }

    public String[] consulta(Cursor c) {
        String datos[] = new String[5];
        c.moveToFirst();
        int numeroR = c.getCount();
        for (int j = 0; j < numeroR; j++) {
            datos[0] = c.getString(c.getColumnIndex("id")) + " ";
            datos[1] = c.getString(c.getColumnIndex("nombre")) + " ";
            datos[2] = c.getString(c.getColumnIndex("direccion")) + " ";
            datos[3] = c.getString(c.getColumnIndex("peso")) + " ";
            datos[4] = c.getString(c.getColumnIndex("edad")) + "\n";
            c.moveToNext();
        }
        return datos;
    }
}