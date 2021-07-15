package com.example.smartattendence;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    ListView listViewData;
    ArrayAdapter<String> adapter;
    String[] arrayItems= {"Name1","Name2","Name3","Name4","Name5","Name6","Name7","Name8"};
    int year,month,day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewData=(ListView)findViewById(R.id.listView_data);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arrayItems);
        listViewData.setAdapter(adapter);

        FloatingActionButton fab=findViewById(R.id.item_date);
        final Calendar calendar = Calendar.getInstance();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                year=calendar.get(Calendar.YEAR);
                month=calendar.get(Calendar.MONTH);
                day=calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu)
//    {
//        getMenuInflater().inflate(R.menu.main_menu,menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NotNull MenuItem item)
//    {
//        int id=item.getItemId();
//        if(id==R.id.item_date)
//        {
//            String itemSelected = "Selected items: \n";
//            for(int i=0;i<listViewData.getCount();i++)
//            {
//                if(listViewData.isItemChecked(i))
//                {
//                    itemSelected+=listViewData.getItemAtPosition(i)+"\n";
//                }
//            }
//        }
//        return super.onOptionsItemSelected(item);
//    }
}