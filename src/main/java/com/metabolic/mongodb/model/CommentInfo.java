package com.metabolic.mongodb.model;

import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.io.Serializable;

/**
 * Created by Administrator on 2018/08/27.
 */
public class CommentInfo implements Serializable {

    private static final long serialVersionUID = 6548982080317868572L;

    @Field("review_title")
    private String reviewTitle; //评价
    @Field("is_point")
    private String isPoint; //是否正常计分
    @Field("comment")
    private String comment;//评价内容
    @Field("date")
    private String date;//评价时间
    @Field("shop_name")
    private String shopName;//卖家
    @Field("shop_type")
    private String shopType;//商家店铺类型图标 星钻等级、天猫店铺、商城
    @Field("trade_title")
    private String tradeTitle;//商品
    @Field("trade_price")
    private String tradePrice;//价格
    @Field("violation_type")
    private String violationType; //违规删评类型

    @Override
    public String toString() {
        return "CommentInfo{" +
                "reviewTitle='" + reviewTitle + '\'' +
                ", isPoint='" + isPoint + '\'' +
                ", comment='" + comment + '\'' +
                ", date='" + date + '\'' +
                ", shopName='" + shopName + '\'' +
                ", shopType='" + shopType + '\'' +
                ", tradeTitle='" + tradeTitle + '\'' +
                ", tradePrice='" + tradePrice + '\'' +
                '}';
    }

    public String getReviewTitle() {
        return reviewTitle;
    }

    public void setReviewTitle(String reviewTitle) {
        this.reviewTitle = reviewTitle;
    }

    public String getIsPoint() {
        return isPoint;
    }

    public void setIsPoint(String isPoint) {
        this.isPoint = isPoint;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopType() {
        return shopType;
    }

    public void setShopType(String shopType) {
        this.shopType = shopType;
    }

    public String getTradeTitle() {
        return tradeTitle;
    }

    public void setTradeTitle(String tradeTitle) {
        this.tradeTitle = tradeTitle;
    }

    public String getTradePrice() {
        return tradePrice;
    }

    public void setTradePrice(String tradePrice) {
        this.tradePrice = tradePrice;
    }

    public String getViolationType() {
        return violationType;
    }

    public void setViolationType(String violationType) {
        this.violationType = violationType;
    }
}
