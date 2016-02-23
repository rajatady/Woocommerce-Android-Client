package com.aadira.library.Models;

import java.util.Date;

/**
 * Created by kumardivyarajat on 22/02/16.
 */
public class Customer extends WCObject {

    long id;
    protected Date createdAt;
    String email;
    String firstName;
    String lastName;
    String userName;
    String role;
    String lastOrderId;
    
//    {
//        "customer": {
//        "id": 7,
//                "created_at": "2016-02-01T03:25:54Z",
//                "email": "rajat@reduxpress.in",
//                "first_name": "",
//                "last_name": "",
//                "username": "rajat1",
//                "role": "customer",
//                "last_order_id": null,
//                "last_order_date": null,
//                "orders_count": 0,
//                "total_spent": "0.00",
//                "avatar_url": "http://2.gravatar.com/avatar/?s=96",
//                "billing_address": {
//            "first_name": "",
//                    "last_name": "",
//                    "company": "",
//                    "address_1": "",
//                    "address_2": "",
//                    "city": "",
//                    "state": "",
//                    "postcode": "",
//                    "country": "",
//                    "email": "",
//                    "phone": ""
//        },
//        "shipping_address": {
//            "first_name": "",
//                    "last_name": "",
//                    "company": "",
//                    "address_1": "",
//                    "address_2": "",
//                    "city": "",
//                    "state": "",
//                    "postcode": "",
//                    "country": ""
//        }
//    }
//    }
}
