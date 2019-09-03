package cusco.sistemas.simplelistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
    private MyAdapter myAdapter;

    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);

        list = (GridView) findViewById(R.id.gridview);

        names = new ArrayList<String>();
        names.add("Fernando");
        names.add("Maria");
        names.add("Santiago");

        //adaptador, forma visual en que se mostraran los datos
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names);

        //establecemos el adaptador con nuestro ListView
        myAdapter = new MyAdapter(getApplicationContext(), R.layout.grid_item, names);
        list.setAdapter(myAdapter);

        //item click
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(GridActivity.this, "Posicion: "+adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_SHORT).show();
            }
        });

        registerForContextMenu(list);
    }

    //Inflamos el layout del menu de opciones
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_bar_menu, menu);
        return true;
    }

    //evento del item del menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
                case R.id.add_item:
                    this.names.add("Add nº: "+(++counter));
                    //refrescamos el adaptador
                    this.myAdapter.notifyDataSetChanged();
                    return true;

                default:
                    return super.onOptionsItemSelected(item);
        }
    }

    //Inflamos el layout del context menu de opciones
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        menu.setHeaderTitle(this.names.get(info.position));

        inflater.inflate(R.menu.context_menu, menu);

    }

    //evento del item del context menu
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()){
            case R.id.delete_item:
                this.names.remove(info.position);
                this.myAdapter.notifyDataSetChanged();
                return true;
                default:
                    return super.onContextItemSelected(item);
        }
    }
}
