package com.aadira.library.Interfaces;

import java.util.List;

import retrofit.RetrofitError;

/**
 * Created by kumardivyarajat on 22/02/16.
 */
public interface ListCallback {
    void Callback(List<?> content, RetrofitError error);

}
