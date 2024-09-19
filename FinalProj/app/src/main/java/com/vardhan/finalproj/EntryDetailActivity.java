package com.vardhan.finalproj;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class EntryDetailActivity extends AppCompatActivity {

    private static final String TAG = "EntryDetailActivity";
    private DatabaseHelper dbHelper;
    private TextView tvTitle, tvContent;
    private long entryId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry_detail);

        tvTitle = findViewById(R.id.tv_title);
        tvContent = findViewById(R.id.tv_content);
        dbHelper = new DatabaseHelper(this);

        entryId = getIntent().getLongExtra("entryId", -1);
        loadEntryDetails();
    }

    private void loadEntryDetails() {
        Cursor cursor = dbHelper.getEntryById(entryId);
        if (cursor.moveToFirst()) {
            String title = cursor.getString(cursor.getColumnIndex("title"));
            String content = cursor.getString(cursor.getColumnIndex("content"));

            tvTitle.setText(title);
            tvContent.setText(content);
        } else {
            Log.d(TAG, "No entry found with id: " + entryId);
        }
        cursor.close();
    }
}
