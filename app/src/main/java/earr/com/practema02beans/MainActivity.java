package earr.com.practema02beans;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText id, nombre, direccion, peso;
    Spinner edad;
    String texto = "";
    String edades[] = {"1", "2", "3", "4", "5"};

    //String arreglo[]=new String[1000];
    //Usuarios u[] = new Usuarios[1000];
    Usuarios u = new Usuarios(MainActivity.this);//control

    int edadSpiner = 0;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*for (int j = 0; j < 1000; j++) {
            u[i] = new Usuarios(MainActivity.this);
        }*/

        relacionarVista();
        edad.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        edadSpiner = 1;
                        break;
                    case 1:
                        edadSpiner = 2;
                        break;
                    case 2:
                        edadSpiner = 3;
                        break;
                    case 3:
                        edadSpiner = 4;
                        break;
                    case 4:
                        edadSpiner = 5;
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                edadSpiner = 0;
            }
        });
    }

    public void relacionarVista() {
        id = (EditText) findViewById(R.id.id);
        nombre = (EditText) findViewById(R.id.nombre);
        direccion = (EditText) findViewById(R.id.direccion);
        peso = (EditText) findViewById(R.id.peso);
        edad = (Spinner) findViewById(R.id.edad);
        ArrayAdapter adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, edades);
        edad.setAdapter(adaptador);
    }

    public void insertarBD(View vista) {
        //u[i] = new Usuarios(MainActivity.this);
        //String texto = u[i].insertar(nombre.getText().toString(), direccion.getText().toString(), peso.getText().toString(), edadSpiner);

        String texto = u.insertar(nombre.getText().toString(), direccion.getText().toString(), peso.getText().toString(), edadSpiner);
        respuesta(texto);
        i++;
    }

    public void eliminarBD(View vista) {
        //texto = u[i].eliminar(id.getText().toString());
        texto = u.eliminar(id.getText().toString());
        respuesta(texto);
        //i--;
    }

    public void actualizarBD(View vista) {
        //String texto = u[i].actualizar(id.getText().toString(), nombre.getText().toString(), direccion.getText().toString(), peso.getText().toString(), edadSpiner);
        texto = u.actualizar(id.getText().toString(), nombre.getText().toString(), direccion.getText().toString(), peso.getText().toString(), edadSpiner);
        respuesta(texto);
    }

    public void buscarBD(View vista) {
        //String texto = u[i].buscar(id.getText().toString());
        texto = u.buscar(id.getText().toString());
        respuesta(texto);
    }

    public void respuesta(String texto) {
        Toast.makeText(getApplicationContext(), texto, Toast.LENGTH_LONG).show();
    }

}