package com.aadira.sample.Activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.aadira.sample.R;
import com.aadira.library.Interfaces.ListCallback;
import com.aadira.library.Main.WooCommerce;
import com.gc.materialdesign.views.ButtonRectangle;
import com.gc.materialdesign.views.ProgressBarCircularIndeterminate;

import java.util.List;

import retrofit.RetrofitError;

public class TestActivity extends AppCompatActivity {

    ButtonRectangle products;
    ButtonRectangle categories;
    ProgressBarCircularIndeterminate pg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        init();
    }

    public void init() {
        final TextView texview = (TextView) findViewById(R.id.textview);
        products = (ButtonRectangle) findViewById(R.id.products_button);
        categories = (ButtonRectangle) findViewById(R.id.categories);
        pg = (ProgressBarCircularIndeterminate)findViewById(R.id.progress);
        final WooCommerce wooCommerce = WooCommerce.getInstance();

        pg.setVisibility(View.INVISIBLE);

        products.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                pg.setVisibility(View.VISIBLE);
                texview.setText("");
                wooCommerce.getAllProducts(new ListCallback() {
                    @Override
                    public void Callback(List<?> products, RetrofitError error) {
                        pg.setVisibility(View.INVISIBLE);
                        if (error == null) {
                            texview.setText(products.toString());
//                            System.out.println("products");
//                            System.out.println(products);
                        } else {
                            System.out.println(error);
                            texview.setText(error.toString());

                        }
                    }
                });
            }
        });

        categories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pg.setVisibility(View.VISIBLE);
                texview.setText("");
                wooCommerce.getAllCategories(new ListCallback() {
                    @Override
                    public void Callback(List<?> products, RetrofitError error) {
                        pg.setVisibility(View.INVISIBLE);
                        if (error == null) {
//                            System.out.println("categories");
//                            System.out.println(products);
                            texview.setText(products.toString());

                        } else {
                            System.out.println(error);
                            texview.setText(error.toString());

                        }
                    }
                });
            }
        });


    }

}
