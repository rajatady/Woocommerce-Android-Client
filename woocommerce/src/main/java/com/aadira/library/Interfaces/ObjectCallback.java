package com.aadira.library.Interfaces;

import com.aadira.library.Models.Product;

import retrofit.RetrofitError;

/**
 * Created by kumardivyarajat on 22/02/16.
 */
public interface ObjectCallback {
    void Callback(Product content, RetrofitError error);

}
