package com.aadira.library.Models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by kumardivyarajat on 21/02/16.
 */
public class CategoriesParser extends Categories {

    private String rawString;

    public CategoriesParser(String rawString) {
        this.rawString = rawString;
    }

    public ArrayList<Categories> categoriesParser() throws JSONException {
        ArrayList<Categories> categoriesArrayList = new ArrayList<>();

        JSONObject object = new JSONObject(rawString);
//        A.logDebugMessage("1" + object.toString());
        JSONArray array = object.getJSONArray("product_categories");
//        A.logDebugMessage("2" + array.toString());

        for(int i = 0; i < array.length(); i++ ) {
            JSONObject object1 = array.getJSONObject(i);
            Categories categories = new Categories();
            categories.id = object1.getLong("id");
            categories.name = object1.getString("name");
            categories.count = object1.getInt("count");
            categories.description = object1.getString("description");
            categories.display = object1.getString("display");
            categories.image = object1.getString("image");
            categories.parent_id = object1.getLong("parent");
            categories.slug = object1.getString("slug");
            categoriesArrayList.add(categories);
        }
        return categoriesArrayList;
    }

}
