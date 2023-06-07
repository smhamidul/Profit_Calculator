package com.hamidul.profitcalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText edTP, edMRP;
    TextView tv1, tv2,toolbar,tvk,tvp;
    CardView button, k, p;
    LinearLayout tv,tvMenu;
    ImageView menu;
    int m,ik, ip,value,bk;

    TextView git;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);


        edTP = findViewById(R.id.edTP);
        edMRP = findViewById(R.id.edMRP);
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        button = findViewById(R.id.button);
        tv = findViewById(R.id.tv);
        menu = findViewById(R.id.menu);
        tvMenu = findViewById(R.id.tvMenu);
        k = findViewById(R.id.k);
        p = findViewById(R.id.p);
        toolbar = findViewById(R.id.toolbar);
        tvk = findViewById(R.id.tvk);
        tvp = findViewById(R.id.tvp);

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (m==0){
                   tvMenu.setVisibility(View.VISIBLE);
                   tv.setVisibility(View.GONE);
                   m = 1;
                }else {
                    tvMenu.setVisibility(View.GONE);
                    m = 0;
                }

            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                float buy, mrp, profit, profitPercent;

                DecimalFormat df = new DecimalFormat("#.00");


                String sbuy = edTP.getText().toString();
                if (sbuy.equals("")){
                    edTP.setError("Please Enter Your Purchase Price");
                    edTP.requestFocus();
                    return;
                }
                buy = Float.parseFloat(sbuy);

                String smrp = edMRP.getText().toString();
                if (smrp.equals("")){
                    edMRP.setError("Please Enter Your MRP");
                    edMRP.requestFocus();
                    return;
                }
                mrp = Float.parseFloat(smrp);


                profit = mrp-buy;
                profit = Float.valueOf(df.format(profit));

                profitPercent = profit/buy*100;
                profitPercent =Float.valueOf(df.format(profitPercent));

                tv1.setText("Profit is : "+profit);
                tv2.setText("Profit % is : "+profitPercent);


                tv.setVisibility(View.VISIBLE);

                value = 1;
            }
        });


        k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                bk=1;

                float mrp,tp;
                DecimalFormat df = new DecimalFormat("#.00");

                if (ik==0){
                    edTP.setVisibility(View.GONE);
                    tv.setVisibility(View.GONE);
                    button.setVisibility(View.GONE);
                    p.setVisibility(View.GONE);
                    toolbar.setText("KELLOGG'S");
                    tvk.setText("Trade Price");
                    edMRP.setText("");
                    ik=1;
                    value=1;
                }else {
                    String smrp = edMRP.getText().toString();
                    if (smrp.equals("")){
                        edMRP.setError("Please Enter Your MRP");
                        edMRP.requestFocus();
                        return;
                    }
                    mrp = Float.parseFloat(smrp);
                    tp = (float) (mrp/1.15);
                    tp=Float.valueOf(df.format(tp));
                    tvk.setText("TP : "+tp);
                    ik=0;
                }
            }
        });


        p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                bk=2;

                float mrp,tp;
                DecimalFormat df = new DecimalFormat("#.00");

                if (ip==0){
                    edTP.setVisibility(View.GONE);
                    tv.setVisibility(View.GONE);
                    button.setVisibility(View.GONE);
                    k.setVisibility(View.GONE);
                    toolbar.setText("PRINGLES");
                    tvp.setText("Trade Price");
                    edMRP.setText("");
                    ip=1;
                    value=1;
                }else {
                    String smrp = edMRP.getText().toString();
                    if (smrp.equals("")){
                        edMRP.setError("Please Enter Your MRP");
                        edMRP.requestFocus();
                        return;
                    }
                    mrp = Float.parseFloat(smrp);
                    tp = (float) (mrp/1.12);
                    tp=Float.valueOf(df.format(tp));
                    tvp.setText("TP : "+tp);
                    ip=0;
                }
            }
        });




    }

    @Override
    public void onBackPressed() {
        if (value==1){
            button.setVisibility(View.VISIBLE);
            tv.setVisibility(View.GONE);
            edTP.setText("");
            edMRP.setText("");
            edTP.requestFocus();
            value=0;
        }else if (value==0){
            super.onBackPressed();
        }
        if (bk==1){
            toolbar.setText("Profit Calculator");
            edTP.setVisibility(View.VISIBLE);
            button.setVisibility(View.VISIBLE);
            tvMenu.setVisibility(View.GONE);
            edMRP.setText("");
            edTP.requestFocus();
            p.setVisibility(View.VISIBLE);
            tvk.setText("KELLOGG'S TP");
            m=0;
            ik=0;
        }else if (bk==2){
            toolbar.setText("Profit Calculator");
            edTP.setVisibility(View.VISIBLE);
            button.setVisibility(View.VISIBLE);
            tvMenu.setVisibility(View.GONE);
            edMRP.setText("");
            edTP.requestFocus();
            k.setVisibility(View.VISIBLE);
            tvp.setText("PRINGLES TP");
            m=0;
            ip=0;
        }

    }

}