package earr.com.practema02beans;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BD extends SQLiteOpenHelper {
    SQLiteDatabase sql, sql2, sql3, sql4;
    String regreso = "";
    Diccionario dic1 = new Diccionario();

    public BD(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(dic1.getCrearTabla());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(dic1.getBorraTabla());
        onCreate(db);
    }

    public String insertar(String n, String d, String p, int e) {
        sql = getWritableDatabase();
        ContentValues valores = new ContentValues();
        String datos[] = dic1.getDatos();
        valores.put(datos[1], n);
        valores.put(datos[2], d);
        valores.put(datos[3], p);
        valores.put(datos[4], e);
        long i = sql.insert(dic1.getTabla(), null, valores);
        return condicion((int) i);
    }

    public String eliminar(String x) {
        sql2 = getWritableDatabase();
        String argumento[] = {x};
        int i = sql2.delete(dic1.getTabla(), dic1.getClausulaWhere1(), argumento);
        return condicion((int) i);
    }

    public String actualizar(String id, String n, String d, String p, int e) {
        sql3 = getWritableDatabase();
        ContentValues valores = new ContentValues();
        String datos[] = dic1.getDatos();
        valores.put(datos[1], n);
        valores.put(datos[2], d);
        valores.put(datos[3], p);
        valores.put(datos[4], e);
        String argumento[] = {id};
        int i = sql3.update(dic1.getTabla(), valores, dic1.getClausulaWhere1(), argumento);
        return condicion((int) i);
    }

    public String[] buscar(String id) {
        sql4 = getReadableDatabase();
        int i = 0;
        String argumento[] = {id};
        Cursor c = sql4.query(dic1.getTabla(), dic1.getDatos(), dic1.getClausulaWhere1(), argumento, null, null, null);
        //sql4.close();
        return dic1.consulta(c);
    }

    public String condicion(int i) {
        if (i > 0) {
            regreso = "OPERACIÓN EXITOSA";
        } else {
            regreso = "FALLO";
        }
        return regreso;
    }
}