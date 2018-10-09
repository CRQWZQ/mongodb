package com.metabolic.mongodb.model;

import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

/**
 * Created by ZQ_W on 2018/08/10.
 */
public class Goods implements Serializable{
    private static final long serialVersionUID = -2051650587563411264L;

    @Field("goods_img")
    private String goodsImg; //商品图片
    @Field("goods_title")
    private String goodsTitle;//商品标题
    @Field("goods_url")
    private String goodsUrl;//商品链接地址
    @Field("goods_sku1")
    private String goodsSku1;//商品sku1
    @Field("goods_sku2")
    private String goodsSku2;//商品sku2
    @Field("goods_price")
    private String goodsPrice;//商品商品价格
    @Field("goods_count")
    private String goodsCount;//商品商品数量

    @Override
    public String toString() {
        return "Goods{" +
                "goodsImg='" + goodsImg + '\'' +
                ", goodsTitle='" + goodsTitle + '\'' +
                ", goodsUrl='" + goodsUrl + '\'' +
                ", goodsSku1='" + goodsSku1 + '\'' +
                ", goodsSku2='" + goodsSku2 + '\'' +
                ", goodsPrice='" + goodsPrice + '\'' +
                ", goodsCount='" + goodsCount + '\'' +
                '}';
    }

    public Goods(){

    }

    public String getGoodsImg() {
        return goodsImg;
    }

    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg;
    }

    public String getGoodsTitle() {
        return goodsTitle;
    }

    public void setGoodsTitle(String goodsTitle) {
        this.goodsTitle = goodsTitle;
    }

    public String getGoodsUrl() {
        return goodsUrl;
    }

    public void setGoodsUrl(String goodsUrl) {
        this.goodsUrl = goodsUrl;
    }

    public String getGoodsSku1() {
        return goodsSku1;
    }

    public void setGoodsSku1(String goodsSku1) {
        this.goodsSku1 = goodsSku1;
    }

    public String getGoodsSku2() {
        return goodsSku2;
    }

    public void setGoodsSku2(String goodsSku2) {
        this.goodsSku2 = goodsSku2;
    }

    public String getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(String goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(String goodsCount) {
        this.goodsCount = goodsCount;
    }
}
