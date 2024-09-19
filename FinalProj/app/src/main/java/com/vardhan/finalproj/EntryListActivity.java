package com.vardhan.finalproj;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import androidx.appcompat.app.AppCompatActivity;

public class EntryListActivity extends AppCompatActivity {

    private static final String TAG = "EntryListActivity";
    private DatabaseHelper dbHelper;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry_list);

        dbHelper = new DatabaseHelper(this);
        listView = findViewById(R.id.rv_entries);
        loadEntries();
    }

    private void loadEntries() {
        Cursor cursor = dbHelper.getAllEntries();
        String[] from = new String[]{"_id", "title", "content"};
        int[] to = new int[]{android.R.id.text1, android.R.id.text2};

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
                android.R.layout.simple_list_item_2, cursor, from, to, 0);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG, "Entry clicked, id: " + id);
                Intent intent = new Intent(EntryListActivity.this, EntryDetailActivity.class);
                intent.putExtra("entryId", id);
                startActivity(intent);
            }
        });
    }
}
