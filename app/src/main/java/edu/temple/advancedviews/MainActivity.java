package edu.temple.advancedviews;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView titleTextView;
    EditText itemEditText;
    Button addButton;
    ListView listView;
    Spinner spinner;

    ArrayList<String> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        items = new ArrayList<>();

        items.add("Dog");
        items.add("Cat");
        items.add("Lizard");
        items.add("Snail");
        items.add("Lantern Fly");
        items.add("Murder Hornet");

        titleTextView = findViewById(R.id.titleTextView);
        itemEditText = findViewById(R.id.itemEditText);
        addButton = findViewById(R.id.addItemButton);
        listView = findViewById(R.id.listView);
        spinner = findViewById(R.id.spinner);

        //final ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, items);

        final BaseAdapter adapter = new AnimalAdapter(this, items);
        listView.setAdapter(adapter);
        spinner.setAdapter(adapter);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                items.add(itemEditText.getText().toString());
                itemEditText.setText("");
                adapter.notifyDataSetChanged();
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                titleTextView.setText(parent.getItemAtPosition(position).toString());
            }
        });
    }
}