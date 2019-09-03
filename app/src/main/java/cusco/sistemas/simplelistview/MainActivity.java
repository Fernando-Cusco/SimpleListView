package cusco.sistemas.simplelistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = (ListView) findViewById(R.id.idListView);

        //datos que queremos mostrar
        List<String> names = new ArrayList<String>();
        names.add("Fernando Cusco");
        names.add("Maria Zeta");
        names.add("Santiago Cruz");
        names.add("Norma Abad");

        //adaptador, forma visual en que se mostraran los datos
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names);

        //establecemos el adaptador con nuestro ListView
        list.setAdapter(adapter);

        
    }
}
