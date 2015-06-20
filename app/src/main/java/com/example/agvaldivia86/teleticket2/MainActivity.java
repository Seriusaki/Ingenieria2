package com.example.agvaldivia86.teleticket2;

        import java.util.ArrayList;
        import java.util.List;
        import android.app.Activity;
        import android.os.Bundle;
        import android.view.Menu;
        import android.view.MenuInflater;
        import android.view.View;
        import android.view.View.OnClickListener;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.Button;
        import android.widget.ListView;
        import android.widget.Spinner;
        import android.widget.Toast;

public class MainActivity extends Activity {

    private Spinner spinner;
    ListView listView ;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.t3_nuevo_usuario1);
        addItemsOnSpinner();

        setContentView(R.layout.t4_home);
        listView = (ListView) findViewById(R.id.list_home);
        // Defined Array values to show in ListView
        String[] values = new String[] { "¿Que puedo hacer hoy?",
                "Recomendaciones del día"
        };
        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third parameter - ID of the TextView to which the data is written
        // Forth - the Array of data
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);
        // Assign adapter to ListView
        listView.setAdapter(adapter);
        // ListView Item Click Listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // ListView Clicked item index
                int itemPosition     = position;

                // ListView Clicked item value
                String  itemValue    = (String) listView.getItemAtPosition(position);

                // Show Alert
                Toast.makeText(getApplicationContext(),
                        "Position :"+itemPosition+"  ListItem : " +itemValue , Toast.LENGTH_LONG)
                        .show();

            }

        });




    }
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.my, menu);

        return true;}

    // add items into spinner dynamically
    public void addItemsOnSpinner() {

        spinner = (Spinner) findViewById(R.id.spin_genero_nuevo);
        List list = new ArrayList();
        list.add("Hombre");
        list.add("Mujer");
        ArrayAdapter dataAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
    }



}