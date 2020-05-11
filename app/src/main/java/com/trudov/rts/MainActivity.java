package com.trudov.rts;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.trudov.rts.R;

public class MainActivity extends AppCompatActivity {
    private Factorizator factorizator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        factorizator = new Factorizator();
    }

    public void factorize(View view) {
        EditText editText = findViewById(R.id.editText2);
        TextView tvr1 = findViewById(R.id.tVr1);
        TextView tvr2 = findViewById(R.id.tVr2);
        TextView tvtime = findViewById(R.id.tVtime);
        long[] values;
        values = factorizator.factor(Long.parseLong(editText.getText().toString()));
        tvr1.setText(String.valueOf(values[0]));
        tvr2.setText(String.valueOf(values[1]));
        tvtime.setText(String.valueOf(values[2]));
        new AlertDialog.Builder(MainActivity.this)
            .setTitle("Finished successfully")
            .setMessage(String.format("iterations: %s", String.valueOf(values[3])))
            .setCancelable(true)
            .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            }).show();
    }
}
