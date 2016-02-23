package com.aadira.library.Main;

import android.app.Application;
import android.util.Log;

import com.aadira.library.Enums.RequestMethod;
import com.aadira.library.Helpers.Endpoints;
import com.aadira.library.Helpers.OAuthSigner;
import com.aadira.library.Interfaces.ListCallback;
import com.aadira.library.Interfaces.ObjectCallback;
import com.aadira.library.Models.Categories;
import com.aadira.library.Models.CategoriesParser;
import com.aadira.library.Models.Product;
import com.aadira.library.Models.ProductParser;
import com.squareup.leakcanary.LeakCanary;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.QueryMap;
import retrofit.mime.TypedByteArray;

/**
 * Created by kumardivyarajat on 18/02/16.
 */
public class WooCommerce extends Application {

    static volatile WooCommerce singleton = null;

    private static final String TAG = WooCommerce.class.getSimpleName();

//    private boolean isHttps;
//    private String baseUrl;
//    private String wc_key;
//    private String wc_secret;
//    private SigningMethod signing_method;
//    private boolean loggingEnabled;

    private WCBuilder wcBuilder;

    private OAuthSigner OAuthSigner;
    private static WooCommerce ourInstance = new WooCommerce();



    public static WooCommerce getInstance() {
        if (singleton == null) {
            synchronized (WooCommerce.class) {
                if (singleton == null) {
                    singleton = ourInstance;
                }
            }
        }
        return singleton;
    }


//    public boolean isHttps() {
//        return isHttps;
//    }
//
//    public WooCommerce setIsHttps(boolean isHttps) {
//        this.isHttps = isHttps;
//        return this;
//    }
//
//    public String getBaseUrl() {
//        return baseUrl;
//    }
//
//    public void setBaseUrl(String baseUrl) {
//        this.baseUrl = baseUrl;
//    }
//
//    public String getWc_key() {
//        return wc_key;
//    }
//
//    public void setWc_key(String wc_key) {
//        this.wc_key = wc_key;
//    }
//
//    public String getWc_secret() {
//        return wc_secret;
//    }
//
//    public void setWc_secret(String wc_secret) {
//        this.wc_secret = wc_secret;
//    }
//
//    public boolean isLoggingEnabled() {
//        return loggingEnabled;
//    }
//
//    public void setLoggingEnabled(boolean loggingEnabled) {
//        this.loggingEnabled = loggingEnabled;
//    }
//
//    public SigningMethod getSigning_method() {
//        return signing_method;
//    }
//
//    public void setSigning_method(SigningMethod signing_method) {
//        this.signing_method = signing_method;
//    }

    private WooCommerce() {
        Log.d(TAG, "Instance created");
        LeakCanary.install(this);
    }

    public void initialize(WCBuilder builder) {
        this.wcBuilder = builder;
        OAuthSigner = new OAuthSigner(wcBuilder);
        Log.i(TAG, "onCreate");
    }



    @Override
    public void onCreate() {
        super.onCreate();

    }

    private interface ProductsInterface {

        @GET(Endpoints.PRODUCTS_ENDPOINT + "/{id}")
         void getProduct(@Path("id")String id,@QueryMap LinkedHashMap<String, String> options, Callback<Response> response);


        @GET(Endpoints.PRODUCTS_ENDPOINT)
         void getProducts(@QueryMap LinkedHashMap<String, String> options, Callback<Response> response);


        @GET(Endpoints.CATEGORIES_ENDPOINT)
         void getCategories(@QueryMap LinkedHashMap<String, String> options, Callback<Response> response);
    }

    public List<Product> getAllProducts(final ListCallback fetched) {
        StringBuilder builder = new StringBuilder();
        builder.append(wcBuilder.isHttps() ? "https://" : "http://");
        builder.append(wcBuilder.getBaseUrl() + "/");
        builder.append("wc-api/v3");
        Log.i(TAG,builder.toString());
        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint(builder.toString())
                .build();

        ProductsInterface api = adapter.create(ProductsInterface.class);

        api.getProducts(OAuthSigner.getSignature(RequestMethod.GET, Endpoints.PRODUCTS_ENDPOINT), new Callback<Response>() {
            @Override
            public void success(Response response1, Response response) {
//                System.out.println(response1.getBody());
//                System.out.println(response.getUrl());
//                System.out.println(response.getStatus());
//                System.out.println(response.getHeaders());
                String bodyString = new String(((TypedByteArray) response.getBody()).getBytes());
                try {
                    JSONObject object = new JSONObject(bodyString);
//                    System.out.println("JSON " + object);
                    ArrayList<Product> products = new ProductParser(object).productsParser();
//                    System.out.println(products);
                    fetched.Callback(products, null);
                    return;
                } catch (JSONException e) {
                    e.printStackTrace();

                }
            }

            @Override
            public void failure(RetrofitError error) {
                System.out.println(error);
                fetched.Callback(null, error);
                return;
            }
        });

        return null;
    }

    public List<Product> getAllCategories(final ListCallback fetched) {
        StringBuilder builder = new StringBuilder();
        builder.append(wcBuilder.isHttps() ? "https://" : "http://");
        builder.append(wcBuilder.getBaseUrl() + "/");
        builder.append("wc-api/v3");
        Log.i(TAG,builder.toString());
        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint(builder.toString())
                .build();

        ProductsInterface api = adapter.create(ProductsInterface.class);

        api.getCategories(OAuthSigner.getSignature(RequestMethod.GET, Endpoints.CATEGORIES_ENDPOINT), new Callback<Response>() {
            @Override
            public void success(Response response1, Response response) {
//                System.out.println(response1.getBody());
//                System.out.println(response.getUrl());
//                System.out.println(response.getStatus());
//                System.out.println(response.getHeaders());
                String bodyString = new String(((TypedByteArray) response.getBody()).getBytes());
                try {
                    JSONObject object = new JSONObject(bodyString);
//                    System.out.println("JSON " + object);
                    ArrayList<Categories> categories = new CategoriesParser(bodyString).categoriesParser();
//                    System.out.println(products);
                    fetched.Callback(categories, null);
                    return;
                } catch (JSONException e) {
                    e.printStackTrace();
                    return;
                }
            }

            @Override
            public void failure(RetrofitError error) {
                System.out.println(error);
                fetched.Callback(null, error);
                return;
            }
        });

        return null;
    }


    public Product getProduct(String id,final ObjectCallback fetched) {
        StringBuilder builder = new StringBuilder();
        builder.append(wcBuilder.isHttps() ? "https://" : "http://");
        builder.append(wcBuilder.getBaseUrl() + "/");
        builder.append("wc-api/v3");
        Log.i(TAG,builder.toString());
        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint(builder.toString())
                .build();

        ProductsInterface api = adapter.create(ProductsInterface.class);
        LinkedHashMap<String, String> options = new LinkedHashMap<String, String>();
        options.put("id","3862");

        api.getProduct("3862", OAuthSigner.getSignature(options,RequestMethod.GET, Endpoints.PRODUCTS_ENDPOINT), new Callback<Response>() {
            @Override
            public void success(Response response1, Response response) {
//                System.out.println(response1.getBody());
//                System.out.println(response.getUrl());
//                System.out.println(response.getStatus());
//                System.out.println(response.getHeaders());
                String bodyString = new String(((TypedByteArray) response.getBody()).getBytes());
                try {
                    JSONObject object = new JSONObject(bodyString);
//                    System.out.println("JSON " + object);
                    Product product = new ProductParser(object).singleProductParser();
                    System.out.println(product);
                    fetched.Callback(product, null);
                    return;
                } catch (JSONException e) {
                    e.printStackTrace();
                    return;
                }
            }

            @Override
            public void failure(RetrofitError error) {
                System.out.println(error.getUrl());
                fetched.Callback(null, error);
                return;
            }
        });

        return null;
    }


}
