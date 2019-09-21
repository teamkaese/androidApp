package com.hackhb19.fawadjawaidmalik.teamkaese;

import android.util.Pair;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public class Product implements Serializable {
    private int id;
    private String productCategory;
    private Position position;
    private String admissionDate;
    private String productStage;
    private String description;
    private boolean isEmpty;

    public Product(int id, String productCategory, Position position, String admissionDate, String productStage,String description,boolean isEmpty) {
        this.id = id;
        this.productCategory = productCategory;
        this.position = position;
        this.admissionDate = admissionDate;
        this.productStage = productStage;
        this.description = description;
        this.isEmpty = isEmpty;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(String admissionDate) {
        this.admissionDate = admissionDate;
    }

    public String getProductStage() {
        return productStage;
    }

    public void setProductStage(String productStage) {
        this.productStage = productStage;
    }

    public static String getProduct(String id) throws Exception{
        return openURL("http://10.200.24.15:8080/api/get/"+ id);
    }

    public static String getAllProductsByCategoryJSON(String cat)throws Exception{
        return openURL("    http://10.200.24.15:8080/api/all?category="+cat);
    }

    public static ArrayList<Product> getAllProducts() throws Exception{

        String json = getAllProductsJSON();

        GsonBuilder gsonBldr = new GsonBuilder();
        gsonBldr.registerTypeAdapter(Product.class, new ProductDeserializer());

        Type targetClassType = new TypeToken<ArrayList<Product>>() { }.getType();

        ArrayList<Product> targetCollection = gsonBldr.create().fromJson(json, targetClassType);

        return targetCollection;
    }

    public static String getAllProductsJSON() throws Exception{
        return openURL("http://10.200.24.15:8080/api/all");
    }

    public static ArrayList<Product> getProductsByCategory(String category)throws Exception{
        String json = getAllProductsByCategoryJSON(category);

        GsonBuilder gsonBldr = new GsonBuilder();
        gsonBldr.registerTypeAdapter(Product.class, new ProductDeserializer());

        Type targetClassType = new TypeToken<ArrayList<Product>>() { }.getType();

        ArrayList<Product> targetCollection = gsonBldr.create().fromJson(json, targetClassType);

        return targetCollection;
    }


    public static String openURL(String urll) throws Exception{
        URL url = new URL(urll);

        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "application/json");

        con.connect();

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }

        in.close();
        con.disconnect();

        return content.toString();
    }

    public static String getParamsString(Map<String, String> params)
            throws UnsupportedEncodingException {
        StringBuilder result = new StringBuilder();

        for (Map.Entry<String, String> entry : params.entrySet()) {
            result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
            result.append("&");
        }

        String resultString = result.toString();
        return resultString.length() > 0
                ? resultString.substring(0, resultString.length() - 1)
                : resultString;
    }

    public static ArrayList<String> getCategorys() throws Exception{
        String categoryJSON = openURL("http://10.200.24.15:8080/api/list/category");
        GsonBuilder gsonBldr = new GsonBuilder();
        return gsonBldr.create().fromJson(categoryJSON, new TypeToken<ArrayList<String>>() { }.getType());
    }

}


