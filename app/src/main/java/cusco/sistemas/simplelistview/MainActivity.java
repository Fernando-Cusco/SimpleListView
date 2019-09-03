package cusco.sistemas.simplelistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView list;
    private List<String> names;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = (ListView) findViewById(R.id.idListView);

        //datos que queremos mostrar
        names = new ArrayList<String>();
        names.add("Fernando Cusco");
        names.add("Maria Zeta");
        names.add("Santiago Cruz");
        names.add("Norma Abad");

        //adaptador, forma visual en que se mostraran los datos
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names);

        //establecemos el adaptador con nuestro ListView
        list.setAdapter(adapter);

        //item click
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "Posicion: "+i, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
