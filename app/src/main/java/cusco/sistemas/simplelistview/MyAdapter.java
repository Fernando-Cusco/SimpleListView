package cusco.sistemas.simplelistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class MyAdapter  extends BaseAdapter {

    private Context context;
    private int layout;
    private List<String> names;

    public MyAdapter(Context context, int layout, List<String> names){
        this.context = context;
        this.layout = layout;
        this.names = names;
    }

    //numero de veces iterar sobre una coleccion, cantidad de items
    @Override
    public int getCount() {
        return this.names.size();
    }

    //obtener un item
    @Override
    public Object getItem(int position) {
        return this.names.get(position);
    }

    //obtener el id
    @Override
    public long getItemId(int id) {
        return id;
    }

    //dibujar
    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        //copiamos la vista
        View v = view;
        //la vista la replicamos en nuestro layout
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        v = layoutInflater.inflate(R.layout.list_item, null);
        String currentName = names.get(position);
        TextView textView = (TextView) v.findViewById(R.id.tvNombre);
        textView.setText(currentName);
        return v;
    }
}
