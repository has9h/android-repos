package com.example.sqliteintro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button save, refresh;
    EditText name, salary;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final DatabaseHelper helper = new DatabaseHelper(this);
        final ArrayList array_list = helper.getAllContacts();
        name = findViewById(R.id.nameField);
        salary = findViewById(R.id.salaryField);
        listView = findViewById(R.id.listView);

        final ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, array_list);
        listView.setAdapter(arrayAdapter);

        findViewById(R.id.refreshBtn).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                array_list.clear();
                array_list.addAll(helper.getAllContacts());
                arrayAdapter.notifyDataSetChanged();
                listView.invalidateViews();
                listView.refreshDrawableState();
            }
        });

        findViewById(R.id.saveBtn).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(!name.getText().toString().isEmpty()  && !salary.getText().toString().isEmpty()){
                    if (helper.insert(name.getText().toString(), salary.getText().toString())){
                        Toast.makeText(MainActivity.this, "Inserted", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(MainActivity.this, "Not Inserted",  Toast.LENGTH_LONG).show();
                    }
                } else {
                    name.setError("Enter  Name");
                    salary.setError("Enter Salary");
                }
            }
        });
    }
}
