package com.aadira.library.NetworkInterface;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by kumardivyarajat on 20/02/16.
 */
public interface ProductsInterface {

    @GET("/wc-api/v3")
    public void getBooks(Callback<Object> response);
}
