package com.aadira.sample;

import android.app.Application;

import com.aadira.library.Enums.SigningMethod;
import com.aadira.library.Main.WCBuilder;
import com.aadira.library.Main.WooCommerce;
import com.squareup.leakcanary.LeakCanary;

/**
 * Created by kumardivyarajat on 20/02/16.
 */
public class Aadira extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        WCBuilder builder = new WCBuilder();
        builder.setIsHttps(false);
        builder.setBaseUrl("www.example.com");
        builder.setSigning_method(SigningMethod.HMACSHA1);
        builder.setWc_key("");
        builder.setWc_secret("");
        WooCommerce.getInstance().initialize(builder);

        LeakCanary.install(this);

        System.out.println(WooCommerce.getInstance().toString());
    }
}
