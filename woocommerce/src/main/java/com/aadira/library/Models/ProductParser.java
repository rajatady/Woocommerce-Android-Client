package com.aadira.library.Models;

import android.annotation.SuppressLint;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by kumardivyarajat on 21/02/16.
 */
@SuppressLint("ParcelCreator")
public class ProductParser extends Product {

    private JSONObject rawString;
    public ProductParser(JSONObject rawString) {
        this.rawString = rawString;
    }

    public ArrayList<Product> productsParser() throws JSONException {
        ArrayList<Product> productsList = new ArrayList<>();

        JSONObject object = rawString;

        JSONArray array = object.getJSONArray("products");


        for (int i = 0; i < array.length(); i++) {
            JSONObject object1 = array.getJSONObject(i);
//            A.logDebugMessage(object1.toString());
            Product product = new Product();
            product.title = (object1.getString("title"));
            ;
            product.id = (object1.getLong("id"));
            ;
            SimpleDateFormat format = new SimpleDateFormat(
                    "yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
            format.setTimeZone(TimeZone.getTimeZone("IST"));

            try {
                product.created_at = (format.parse(object1.getString("created_at")));
            } catch (ParseException e) {
                e.printStackTrace();
            }
//            Log.d("Date : ", product.created_at + " ");
//            product.created_at = new Date(object1.getString(""));
            product.type = (object1.getString("type"));
            product.permalink = object1.getString("permalink");
            product.sku = object1.getString("sku");
            product.price = object1.getString("price");
            product.regular_price = object1.getString("regular_price");
            product.sale_price = object1.getString("sale_price");
            product.managing_stock = object1.getBoolean("managing_stock");
            product.stock_quantity = object1.get("stock_quantity").equals("") ? 0 : object1.getInt("stock_quantity");
            product.in_stock = object1.getBoolean("in_stock");
            product.backorders_allowed = object1.getBoolean("backorders_allowed");
            product.backordered = object1.getBoolean("backordered");
            product.sold_individually = object1.getBoolean("sold_individually");
            product.featured = object1.getBoolean("featured");
            product.visible = object1.getBoolean("visible");
            product.catalog_visibility = object1.getString("catalog_visibility");
            product.on_sale = object1.getBoolean("on_sale");
            product.product_url = object1.getString("product_url");
            product.button_text = object1.getString("button_text");
            product.weight = object1.getString("weight");
            product.shipping_required = object1.getBoolean("shipping_required");
            product.shipping_taxable = object1.getBoolean("shipping_taxable");
            product.shipping_class = object1.getString("shipping_class");
            product.shipping_class_id = object1.getString("shipping_class_id");
            product.long_description = object1.getString("description");
            product.short_description = object1.getString("short_description");
            product.reviews_allowed = object1.getBoolean("reviews_allowed");
            product.average_rating = object1.getString("average_rating");
            product.rating_count = object1.getInt("rating_count");
            product.parent_id = object1.getLong("parent_id");
            product.featured_image_url = object1.getString("featured_src");
            product.total_sales = object1.getInt("total_sales");


            JSONArray related_id_array = object1.getJSONArray("related_ids");
            product.related_ids = new ArrayList<>();
            for (int j = 0; j < related_id_array.length(); j++) {
                product.related_ids.add(related_id_array.getLong(j));
            }

            JSONArray upsell_ids_array = object1.getJSONArray("upsell_ids");
            product.upsell_ids = new ArrayList<>();
            for (int j = 0; j < upsell_ids_array.length(); j++) {
                product.upsell_ids.add(upsell_ids_array.getLong(j));
            }

            JSONArray cross_sell_ids_array = object1.getJSONArray("cross_sell_ids");
            product.cross_sell_ids = new ArrayList<>();

            for (int j = 0; j < cross_sell_ids_array.length(); j++) {
                product.cross_sell_ids.add(cross_sell_ids_array.getLong(j));
            }

            JSONArray categories_id_array = object1.getJSONArray("categories");
            product.categories = new ArrayList<>();

            for (int j = 0; j < categories_id_array.length(); j++) {
                product.categories.add(categories_id_array.getString(j));
            }


            JSONArray tags_id_array = object1.getJSONArray("tags");
            product.tags = new ArrayList<>();

            for (int j = 0; j < tags_id_array.length(); j++) {
                product.tags.add(tags_id_array.getString(j));
            }

            JSONArray array1 = object1.getJSONArray("images");
            ArrayList<ProductImage> productImageArrayList = new ArrayList<>();
            for (int j = 0; j < array1.length(); j++) {
                ProductImage image = new ProductImage();
                JSONObject object3 = array1.getJSONObject(j);
                image.id = object3.getLong("id");
                image.src = object3.getString("src");
                image.title = object3.getString("title");
                image.alt = object3.getString("alt");
                image.position = object3.getInt("position");
                productImageArrayList.add(image);
            }

            product.productImages = productImageArrayList;

            JSONArray array2 = object1.getJSONArray("attributes");
            ArrayList<ProductAttribute> attributeArrayList = new ArrayList<>();
            for (int j = 0; j < array2.length(); j++) {
                ProductAttribute attribute = new ProductAttribute();
                JSONObject object3 = array2.getJSONObject(j);

                attribute.setName(object3.getString("name"));
                attribute.setSlug(object3.getString("slug"));
                attribute.setPosition(object3.getInt("position"));
                attribute.setVisible(object3.getBoolean("visible"));
                attribute.setVariations(object3.getBoolean("variation"));
                ArrayList<String> options = new ArrayList<>();
                JSONArray array3 = object3.getJSONArray("options");
                for (int k = 0; k < array3.length(); k++) {
                    String option = array3.getString(k);
                    options.add(option);
                }
                attribute.setOptions(options);
                attributeArrayList.add(attribute);
            }

            product.productAttributeArrayList = attributeArrayList;


            JSONArray array3 = object1.getJSONArray("variations");
            variationId = new ArrayList<>();
            for (int l = 0; l < array3.length(); l++) {
                JSONObject object3 = array3.getJSONObject(l);
                try {
                    variationId.add(String.valueOf(object3.getInt("id")));
                    hasVariations = true;

                } catch (JSONException e) {
                    e.printStackTrace();
                    hasVariations = false;
                }

            }

            productsList.add(product);
        }


        return productsList;
    }

    public Product singleProductParser() throws JSONException {
        Product product = new Product();

        JSONObject object = rawString;

        JSONObject array = object.getJSONObject("product");


//            A.logDebugMessage(object1.toString());
            product.title = (array.getString("title"));
            ;
            product.id = (array.getLong("id"));
            ;
            SimpleDateFormat format = new SimpleDateFormat(
                    "yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
            format.setTimeZone(TimeZone.getTimeZone("IST"));

            try {
                product.created_at = (format.parse(array.getString("created_at")));
            } catch (ParseException e) {
                e.printStackTrace();
            }
//            Log.d("Date : ", product.created_at + " ");
//            product.created_at = new Date(object1.getString(""));
            product.type = (array.getString("type"));
            product.permalink = array.getString("permalink");
            product.sku = array.getString("sku");
            product.price = array.getString("price");
            product.regular_price = array.getString("regular_price");
            product.sale_price = array.getString("sale_price");
            product.managing_stock = array.getBoolean("managing_stock");
            product.stock_quantity = array.get("stock_quantity").equals("") ? 0 : array.getInt("stock_quantity");
            product.in_stock = array.getBoolean("in_stock");
            product.backorders_allowed = array.getBoolean("backorders_allowed");
            product.backordered = array.getBoolean("backordered");
            product.sold_individually = array.getBoolean("sold_individually");
            product.featured = array.getBoolean("featured");
            product.visible = array.getBoolean("visible");
            product.catalog_visibility = array.getString("catalog_visibility");
            product.on_sale = array.getBoolean("on_sale");
            product.product_url = array.getString("product_url");
            product.button_text = array.getString("button_text");
            product.weight = array.getString("weight");
            product.shipping_required = array.getBoolean("shipping_required");
            product.shipping_taxable = array.getBoolean("shipping_taxable");
            product.shipping_class = array.getString("shipping_class");
            product.shipping_class_id = array.getString("shipping_class_id");
            product.long_description = array.getString("description");
            product.short_description = array.getString("short_description");
            product.reviews_allowed = array.getBoolean("reviews_allowed");
            product.average_rating = array.getString("average_rating");
            product.rating_count = array.getInt("rating_count");
            product.parent_id = array.getLong("parent_id");
            product.featured_image_url = array.getString("featured_src");
            product.total_sales = array.getInt("total_sales");


            JSONArray related_id_array = array.getJSONArray("related_ids");
            product.related_ids = new ArrayList<>();
            for (int j = 0; j < related_id_array.length(); j++) {
                product.related_ids.add(related_id_array.getLong(j));
            }

            JSONArray upsell_ids_array = array.getJSONArray("upsell_ids");
            product.upsell_ids = new ArrayList<>();
            for (int j = 0; j < upsell_ids_array.length(); j++) {
                product.upsell_ids.add(upsell_ids_array.getLong(j));
            }

            JSONArray cross_sell_ids_array = array.getJSONArray("cross_sell_ids");
            product.cross_sell_ids = new ArrayList<>();

            for (int j = 0; j < cross_sell_ids_array.length(); j++) {
                product.cross_sell_ids.add(cross_sell_ids_array.getLong(j));
            }

            JSONArray categories_id_array = array.getJSONArray("categories");
            product.categories = new ArrayList<>();

            for (int j = 0; j < categories_id_array.length(); j++) {
                product.categories.add(categories_id_array.getString(j));
            }


            JSONArray tags_id_array = array.getJSONArray("tags");
            product.tags = new ArrayList<>();

            for (int j = 0; j < tags_id_array.length(); j++) {
                product.tags.add(tags_id_array.getString(j));
            }

            JSONArray array1 = array.getJSONArray("images");
            ArrayList<ProductImage> productImageArrayList = new ArrayList<>();
            for (int j = 0; j < array1.length(); j++) {
                ProductImage image = new ProductImage();
                JSONObject object3 = array1.getJSONObject(j);
                image.id = object3.getLong("id");
                image.src = object3.getString("src");
                image.title = object3.getString("title");
                image.alt = object3.getString("alt");
                image.position = object3.getInt("position");
                productImageArrayList.add(image);
            }

            product.productImages = productImageArrayList;

            JSONArray array2 = array.getJSONArray("attributes");
            ArrayList<ProductAttribute> attributeArrayList = new ArrayList<>();
            for (int j = 0; j < array2.length(); j++) {
                ProductAttribute attribute = new ProductAttribute();
                JSONObject object3 = array2.getJSONObject(j);

                attribute.setName(object3.getString("name"));
                attribute.setSlug(object3.getString("slug"));
                attribute.setPosition(object3.getInt("position"));
                attribute.setVisible(object3.getBoolean("visible"));
                attribute.setVariations(object3.getBoolean("variation"));
                ArrayList<String> options = new ArrayList<>();
                JSONArray array3 = object3.getJSONArray("options");
                for (int k = 0; k < array3.length(); k++) {
                    String option = array3.getString(k);
                    options.add(option);
                }
                attribute.setOptions(options);
                attributeArrayList.add(attribute);
            }

            product.productAttributeArrayList = attributeArrayList;


            JSONArray array3 = array.getJSONArray("variations");
            variationId = new ArrayList<>();
            for (int l = 0; l < array3.length(); l++) {
                JSONObject object3 = array3.getJSONObject(l);
                try {
                    variationId.add(String.valueOf(object3.getInt("id")));
                    hasVariations = true;

                } catch (JSONException e) {
                    e.printStackTrace();
                    hasVariations = false;
                }

            }


        return product;
    }
}
