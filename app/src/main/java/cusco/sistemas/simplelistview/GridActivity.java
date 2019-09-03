package cusco.sistemas.simplelistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class GridActivity extends AppCompatActivity {
    private GridView list;
    private List<String> names;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);

        list = (GridView) findViewById(R.id.gridview);

        names = new ArrayList<String>();
        names.add("Fernando");
        names.add("Maria");
        names.add("Santiago");
        names.add("Norma");
        names.add("Fernando");
        names.add("Maria");
        names.add("Santiago");
        names.add("Norma");
        names.add("Fernando");
        names.add("Maria");
        names.add("Santiago");
        names.add("Norma");
        names.add("Fernando");
        names.add("Maria");
        names.add("Santiago");
        names.add("Norma");

        //adaptador, forma visual en que se mostraran los datos
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names);

        //establecemos el adaptador con nuestro ListView
        MyAdapter myAdapter = new MyAdapter(getApplicationContext(), R.layout.grid_item, names);
        list.setAdapter(myAdapter);

        //item click
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(GridActivity.this, "Posicion: "+adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
