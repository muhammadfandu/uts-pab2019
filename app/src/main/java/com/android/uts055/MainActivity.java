package com.android.uts055;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.android.uts055.extra.MESSAGE";
    public static final String EXTRA_FRUIT = "com.android.uts055.extra.FRUIT";
    String mOrderMessage;
    String mFruitMessage;
    int mFruitPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("UTS_PAB_17523055");
    }

    public void clickAnggurHitam(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://lifestyle.sindonews.com/read/1278773/155/10-manfaat-anggur-hitam-mulai-fungsi-otak-hingga-kulit-1517539621"));
        startActivity(intent);
    }

    public void clickAnggurMerah(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.kompasiana.com/hendipermana/599d4477ed967e083d755d92/12-manfaat-buah-anggur-untuk-kesehatan-no-9-sangat-menakjubkan?page=all"));
        startActivity(intent);
    }

    public void clickApelFuji(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.sunpride.co.id/manfaat-apel-fuji/"));
        startActivity(intent);
    }

    public void clickMangga(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://doktersehat.com/manfaat-mangga/"));
        startActivity(intent);
    }

    public void beliAnggurHitam(View view) {
        mOrderMessage = "Anggur Hitam harga per kg : Rp. 30.000\nMinimal 1Kg, maksimal 4Kg";
        mFruitMessage = "Anggur Hitam";
        mFruitPrice = 30000;

        Intent intent = new Intent(MainActivity.this, OrderActivity.class);
        intent.putExtra(EXTRA_MESSAGE, mOrderMessage);
        intent.putExtra(EXTRA_FRUIT, mFruitMessage);
        intent.putExtra("harga", mFruitPrice);
        startActivity(intent);
    }

    public void beliAnggurMerah(View view) {
        mOrderMessage = "Anggur Merah harga per kg : Rp. 40.000\nMinimal 1Kg, maksimal 4Kg";
        mFruitMessage = "Anggur Merah";
        mFruitPrice = 40000;

        Intent intent = new Intent(MainActivity.this, OrderActivity.class);
        intent.putExtra(EXTRA_MESSAGE, mOrderMessage);
        intent.putExtra(EXTRA_FRUIT, mFruitMessage);
        intent.putExtra("harga", mFruitPrice);
        startActivity(intent);
    }

    public void beliApelFuji(View view) {
        mOrderMessage = "Apel Fuji harga per kg : Rp. 35.000\nMinimal 1Kg, maksimal 4Kg";
        mFruitMessage = "Apel Fuji";
        mFruitPrice = 35000;

        Intent intent = new Intent(MainActivity.this, OrderActivity.class);
        intent.putExtra(EXTRA_MESSAGE, mOrderMessage);
        intent.putExtra(EXTRA_FRUIT, mFruitMessage);
        intent.putExtra("harga", mFruitPrice);
        startActivity(intent);
    }

    public void beliMangga(View view) {
        mOrderMessage = "Mangga harga per kg : Rp. 20.000\nMinimal 1Kg, maksimal 4Kg";
        mFruitMessage = "Mangga";
        mFruitPrice = 20000;

        Intent intent = new Intent(MainActivity.this, OrderActivity.class);
        intent.putExtra(EXTRA_MESSAGE, mOrderMessage);
        intent.putExtra(EXTRA_FRUIT, mFruitMessage);
        intent.putExtra("harga", mFruitPrice);
        startActivity(intent);
    }
}
