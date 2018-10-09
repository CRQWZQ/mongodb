package com.metabolic.mongodb.model;

import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZQ_W on 2018/08/10.
 */
public class OrdersInfo implements Serializable{
    private static final long serialVersionUID = -1018717121567874606L;

    @Field("order_id")
    private String orderId;//订单号
    @Field("store_url")
    private String storeUrl;//店铺地址
    @Field("store_name")
    private String storeName;//店铺名称
    @Field("ww_name")
    private String wwName;//店铺旺旺名
    @Field("trade_time")
    private String tradeTime;//订单订购时间
    @Field("post_fee")
    private String postFee;//邮费
    @Field("real_pay")
    private String realPay;//付费金额
    @Field("goods_status")
    private String goodsStatus;//交易状态
    @Field("no_calculate_sign")
    private String noCalculateSign;//不计销量标识

    private List<Goods> goods = new ArrayList<>();

    public OrdersInfo(){}

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getStoreUrl() {
        return storeUrl;
    }

    public void setStoreUrl(String storeUrl) {
        this.storeUrl = storeUrl;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getWwName() {
        return wwName;
    }

    public void setWwName(String wwName) {
        this.wwName = wwName;
    }

    public String getTradeTime() {
        return tradeTime;
    }

    public void setTradeTime(String tradeTime) {
        this.tradeTime = tradeTime;
    }

    public String getPostFee() {
        return postFee;
    }

    public void setPostFee(String postFee) {
        this.postFee = postFee;
    }

    public String getRealPay() {
        return realPay;
    }

    public void setRealPay(String realPay) {
        this.realPay = realPay;
    }

    public List<Goods> getGoods() {
        return goods;
    }

    public void setGoods(List<Goods> goods) {
        this.goods = goods;
    }

    public String getGoodsStatus() {
        return goodsStatus;
    }

    public void setGoodsStatus(String goodsStatus) {
        this.goodsStatus = goodsStatus;
    }

    public String getNoCalculateSign() {
        return noCalculateSign;
    }

    public void setNoCalculateSign(String noCalculateSign) {
        this.noCalculateSign = noCalculateSign;
    }

    @Override
    public String toString() {
        return "OrdersInfo{" +
                "orderId='" + orderId + '\'' +
                ", storeUrl='" + storeUrl + '\'' +
                ", storeName='" + storeName + '\'' +
                ", wwName='" + wwName + '\'' +
                ", tradeTime='" + tradeTime + '\'' +
                ", postFee='" + postFee + '\'' +
                ", realPay='" + realPay + '\'' +
                ", goodsStatus='" + goodsStatus + '\'' +
                ", noCalculateSign='" + noCalculateSign + '\'' +
                ", goods=" + goods +
                '}';
    }
}
