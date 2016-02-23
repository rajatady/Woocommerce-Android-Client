package com.aadira.library.Models;

import java.util.Date;
import java.util.List;

/**
 * Created by kumardivyarajat on 22/02/16.
 */
public class Coupons extends WCObject {

    private long id;
    private String code;
    private String type;
    protected Date created_at;
    protected Date updated_at;
    private String amount;
    boolean usedIndividually;
    private List<Long> includedProducts;
    private List<Long> excludedProducts;
    private String usageLimit;
    private String usageLimitPerUser;
    private String usageLimitToXItems;
    private int usageCount;
    protected Date expiry_date;
    private boolean enablesFreeShipping;
    private List<Long> includedCategories;
    private List<Long> excludedCategories;
    private boolean excludeSaleProducts;
    private String minimumAmount;
    private String maximumAmount;
    private List<String> includedCustomers;
    private String description;


    public Coupons() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public boolean isUsedIndividually() {
        return usedIndividually;
    }

    public void setUsedIndividually(boolean usedIndividually) {
        this.usedIndividually = usedIndividually;
    }

    public List<Long> getIncludedProducts() {
        return includedProducts;
    }

    public void setIncludedProducts(List<Long> includedProducts) {
        this.includedProducts = includedProducts;
    }

    public List<Long> getExcludedProducts() {
        return excludedProducts;
    }

    public void setExcludedProducts(List<Long> excludedProducts) {
        this.excludedProducts = excludedProducts;
    }

    public String getUsageLimit() {
        return usageLimit;
    }

    public void setUsageLimit(String usageLimit) {
        this.usageLimit = usageLimit;
    }

    public String getUsageLimitPerUser() {
        return usageLimitPerUser;
    }

    public void setUsageLimitPerUser(String usageLimitPerUser) {
        this.usageLimitPerUser = usageLimitPerUser;
    }

    public String getUsageLimitToXItems() {
        return usageLimitToXItems;
    }

    public void setUsageLimitToXItems(String usageLimitToXItems) {
        this.usageLimitToXItems = usageLimitToXItems;
    }

    public int getUsageCount() {
        return usageCount;
    }

    public void setUsageCount(int usageCount) {
        this.usageCount = usageCount;
    }

    public Date getExpiry_date() {
        return expiry_date;
    }

    public void setExpiry_date(Date expiry_date) {
        this.expiry_date = expiry_date;
    }

    public boolean isEnablesFreeShipping() {
        return enablesFreeShipping;
    }

    public void setEnablesFreeShipping(boolean enablesFreeShipping) {
        this.enablesFreeShipping = enablesFreeShipping;
    }

    public List<Long> getIncludedCategories() {
        return includedCategories;
    }

    public void setIncludedCategories(List<Long> includedCategories) {
        this.includedCategories = includedCategories;
    }

    public List<Long> getExcludedCategories() {
        return excludedCategories;
    }

    public void setExcludedCategories(List<Long> excludedCategories) {
        this.excludedCategories = excludedCategories;
    }

    public boolean isExcludeSaleProducts() {
        return excludeSaleProducts;
    }

    public void setExcludeSaleProducts(boolean excludeSaleProducts) {
        this.excludeSaleProducts = excludeSaleProducts;
    }

    public String getMinimumAmount() {
        return minimumAmount;
    }

    public void setMinimumAmount(String minimumAmount) {
        this.minimumAmount = minimumAmount;
    }

    public String getMaximumAmount() {
        return maximumAmount;
    }

    public void setMaximumAmount(String maximumAmount) {
        this.maximumAmount = maximumAmount;
    }

    public List<String> getIncludedCustomers() {
        return includedCustomers;
    }

    public void setIncludedCustomers(List<String> includedCustomers) {
        this.includedCustomers = includedCustomers;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    //    {
//        "coupons": [
//        {
//            "id": 1995,
//                "code": "ysm25",
//                "type": "percent",
//                "created_at": "2016-01-20T13:20:05Z",
//                "updated_at": "2016-01-20T13:20:05Z",
//                "amount": "25.00",
//                "individual_use": true,
//                "product_ids": [],
//            "exclude_product_ids": [],
//            "usage_limit": null,
//                "usage_limit_per_user": 1,
//                "limit_usage_to_x_items": 0,
//                "usage_count": 2,
//                "expiry_date": "2016-02-07T00:00:00Z",
//                "enable_free_shipping": false,
//                "product_category_ids": [],
//            "exclude_product_category_ids": [
//            86
//            ],
//            "exclude_sale_items": false,
//                "minimum_amount": "0.00",
//                "maximum_amount": "0.00",
//                "customer_emails": [
//            "mirrayees@reduxpress.in"
//            ],
//            "description": ""
//        }
//        ]
//    }
}
