package com.bawei.wangjiangwei20200102.model.entity;

import java.util.List;

public class HomeEntity {
    public String message;
    public String status;
    public List<Product> result;

    public class Product{

        public String imageUrl;
        public String jumpUrl;
        public String rank;
        public String title;

    }
}
