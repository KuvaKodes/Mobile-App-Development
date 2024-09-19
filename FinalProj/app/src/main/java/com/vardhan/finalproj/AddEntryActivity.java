package com.vardhan.finalproj;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class AddEntryActivity extends AppCompatActivity {

    private EditText etTitle, etContent;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_entry);

        etTitle = findViewById(R.id.et_title);
        etContent = findViewById(R.id.et_content);
        dbHelper = new DatabaseHelper(this);

        findViewById(R.id.btn_save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveEntry();
            }
        });
    }

    private void saveEntry() {
        String title = etTitle.getText().toString().trim();
        String content = etContent.getText().toString().trim();
        if (title.isEmpty() || content.isEmpty()) {
            Toast.makeText(this, "Please fill in both fields", Toast.LENGTH_SHORT).show();
            return;
        }

        boolean inserted = dbHelper.addEntry(title, content);
        if (inserted) {
            Toast.makeText(this, "Entry saved", Toast.LENGTH_SHORT).show();
            finish();
        } else {
            Toast.makeText(this, "Error saving entry", Toast.LENGTH_SHORT).show();
        }
    }
}
