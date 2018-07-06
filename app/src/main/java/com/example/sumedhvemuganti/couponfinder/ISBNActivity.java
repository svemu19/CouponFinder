package com.example.sumedhvemuganti.couponfinder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URL;

public class ISBNActivity extends AppCompatActivity {
    public ISBNActivity() {
    }

    public void onCreate(Bundle bundle){
        super.onCreate(bundle);

    }

    public Button.OnClickListener mScan = new Button.OnClickListener() {
        public void onClick(View v) {
            Intent intent = new Intent("com.google.zxing.client.android.SCAN");
            intent.putExtra("SCAN_MODE", "QR_CODE_MODE");
            startActivityForResult(intent, 0);
        }
    };

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
                String contents = intent.getStringExtra("SCAN_RESULT");
                String format = intent.getStringExtra("SCAN_RESULT_FORMAT");
                // Handle successful scan
            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "Look Up Cancelled", Toast.LENGTH_LONG).show();
            }
        }
    }

    public void itemLookUp(String isbn)
    {
        try{
            URL link = new URL(isbn);
            TextView top = findViewById(R.id.product_name);
            top.setText("Item Name");
            TextView bottom = findViewById(R.id.description);
            bottom.setText("description");
            ImageView product = findViewById(R.id.product);
            String tmpHtml = "<html>a whole bunch of html stuff</html>";
            String htmlTextStr = Html.fromHtml(tmpHtml,0).toString();
            int x = 27 + htmlTextStr.indexOf("<table id=\"result\">");
            String isbnNum = htmlTextStr.substring(x, x+13);
            URL url = new URL("http://lookupbyisbn.com/Search/" + isbnNum);






        }
        catch(Exception e)
        {
            Toast.makeText(this, "Look Up Cancelled", Toast.LENGTH_SHORT).show();
        }
    }


}
