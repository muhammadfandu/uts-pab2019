package com.android.uts055;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class OrderActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    int hargaBuah = 0, hargaTotal = 0, nBuah = 0;
    String buah, metodePembayaran = "Transfer", namaPemesan, result = "";

    EditText namaText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        getSupportActionBar().setTitle("Detail Pemesanan");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        namaText = findViewById(R.id.name_text);
        TextView textView = findViewById(R.id.txtSummary);
        textView.setText(message);

        Spinner spinner = findViewById(R.id.label_spinner);
        if (spinner != null) {
            spinner.setOnItemSelectedListener(this);
        }

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.value_array, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        if (spinner != null) {
            spinner.setAdapter(adapter);
        }
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radioTransfer:
                if (checked)
                    metodePembayaran = "Transfer";
                break;
            case R.id.radioCoD:
                if (checked)
                    metodePembayaran = "Cash on Delivery";
                break;
            default:
                break;
        }
    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String spinnerLabel = adapterView.getItemAtPosition(i).toString();
        nBuah = Integer.parseInt(spinnerLabel);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void prosesOrder(View view) {
        TextView TextResult = findViewById(R.id.txtResult);

        Intent intent = getIntent();

        namaPemesan = namaText.getText().toString();
        buah = intent.getStringExtra(MainActivity.EXTRA_FRUIT);
        hargaBuah = intent.getIntExtra("harga", 0);
        hargaTotal = nBuah * hargaBuah;

        result = "Pesanan untuk " + namaPemesan + " sedang diproses.\n" +
                "-- Detail Pemesanan --\n" +
                "Pilihan Buah       : " + buah + "\n" +
                "Total Harga        : " + hargaTotal + "\n" +
                "Metode Pembayaran  : " + metodePembayaran + "\n";

        TextResult.setText(result);
    }
}
