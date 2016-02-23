package com.aadira.library.Helpers;

import android.util.Log;

import com.aadira.library.Enums.RequestMethod;
import com.aadira.library.Main.WCBuilder;
import com.google.api.client.auth.oauth.OAuthHmacSigner;
import com.google.api.client.auth.oauth.OAuthParameters;
import com.google.api.client.http.GenericUrl;

import java.security.GeneralSecurityException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by kumardivyarajat on 21/02/16.
 */
public class OAuthSigner {

    private WCBuilder wooCommerce;
    private static final String TAG = "Inside OAuthSigner -   ";

    public OAuthSigner(WCBuilder wooCommerce) {
        this.wooCommerce = wooCommerce;
        Log.i(TAG,wooCommerce.toString());
    }

    public LinkedHashMap<String, String> getSignature(Map<String, String> options, RequestMethod requestMethod, String endpoint) {
        LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();

        OAuthParameters parameters = new OAuthParameters();
        parameters.computeTimestamp();
        parameters.computeNonce();
        parameters.version = "1.0";
        parameters.consumerKey = wooCommerce.getWc_key();
        GenericUrl genericUrl = new GenericUrl();
        genericUrl.setScheme(wooCommerce.isHttps() ? "https" : "http");
        genericUrl.setHost(wooCommerce.getBaseUrl());
        genericUrl.appendRawPath("/wc-api");
        genericUrl.appendRawPath("/v3");
        /*
         *    The endpoint to be called is specified next
         *    */

        genericUrl.appendRawPath(endpoint);

        for (Map.Entry<String, String> entry : options.entrySet())
        {
            System.out.println(entry.getKey() + "/" + entry.getValue());
            genericUrl.appendRawPath("/"+entry.getValue());
        }

        OAuthHmacSigner oAuthHmacSigner = new OAuthHmacSigner();
        oAuthHmacSigner.clientSharedSecret = wooCommerce.getWc_secret();


        parameters.signer = oAuthHmacSigner;
        parameters.signatureMethod = wooCommerce.getSigning_method().getVal();
        try {
            parameters.computeSignature(requestMethod.getVal(), genericUrl);
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }

        map.put("oauth_consumer_key", parameters.consumerKey);
        map.put("oauth_signature_method", parameters.signatureMethod);
        map.put("oauth_timestamp", parameters.timestamp);
        map.put("oauth_nonce", parameters.nonce);
        map.put("oauth_version", parameters.version);
        map.put("oauth_signature", parameters.signature);

        genericUrl.put("oauth_consumer_key", parameters.consumerKey);
        genericUrl.put("oauth_signature_method", parameters.signatureMethod);
        genericUrl.put("oauth_timestamp", parameters.timestamp);
        genericUrl.put("oauth_nonce", parameters.nonce);
        genericUrl.put("oauth_version", parameters.version);
        genericUrl.put("oauth_signature", parameters.signature);

        Log.i(TAG,genericUrl.build());


        return map;
    }

    public LinkedHashMap<String, String> getSignature(RequestMethod requestMethod, String endpoint) {
        OAuthParameters parameters = new OAuthParameters();
        parameters.computeTimestamp();
        parameters.computeNonce();
        parameters.version = "1.0";
        GenericUrl genericUrl = new GenericUrl();
        LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
        try {
            parameters.consumerKey = wooCommerce.getWc_key();

            /*   This part denoted building the base url for Woocommerce API call.
             *   The base url is in the format http://www.example.com/wc-api/v3
             *   Here scheme is http,
             *   the host path is www.example.com,
             *   the api path is wc-api,
             *   and the version of wc api is the version path i.e v3.
             */
            genericUrl.setScheme(wooCommerce.isHttps() ? "https" : "http");
            genericUrl.setHost(wooCommerce.getBaseUrl());
            genericUrl.appendRawPath("/wc-api");
            genericUrl.appendRawPath("/v3");


            /*
             *    The endpoint to be called is specified next,
             */


            genericUrl.appendRawPath(endpoint);
//        genericUrl.set("filter[category]", categories.getName());
//        genericUrl.set("filter[limit]", 25);

            OAuthHmacSigner oAuthHmacSigner = new OAuthHmacSigner();
            oAuthHmacSigner.clientSharedSecret = wooCommerce.getWc_secret();


            parameters.signer = oAuthHmacSigner;
            parameters.signatureMethod = wooCommerce.getSigning_method().getVal();
            try {
                parameters.computeSignature(requestMethod.getVal(), genericUrl);
            } catch (GeneralSecurityException e) {
                e.printStackTrace();
            }

            map.put("oauth_consumer_key", parameters.consumerKey);
            map.put("oauth_signature_method", parameters.signatureMethod);
            map.put("oauth_timestamp", parameters.timestamp);
            map.put("oauth_nonce", parameters.nonce);
            map.put("oauth_version", parameters.version);
            map.put("oauth_signature", parameters.signature);

            genericUrl.put("oauth_consumer_key", parameters.consumerKey);
            genericUrl.put("oauth_signature_method", parameters.signatureMethod);
            genericUrl.put("oauth_timestamp", parameters.timestamp);
            genericUrl.put("oauth_nonce", parameters.nonce);
            genericUrl.put("oauth_version", parameters.version);
            genericUrl.put("oauth_signature", parameters.signature);

            Log.i(TAG, genericUrl.build());


        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return map;
    }

}
