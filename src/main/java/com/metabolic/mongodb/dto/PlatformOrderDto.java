package com.metabolic.mongodb.dto;

import com.metabolic.mongodb.model.ViewInformation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/09/13.
 */
public class PlatformOrderDto {
    /**
     * 旺旺名
     */
    private String nick;
    /**
     * 违规记录
     */
    private Integer punishCountStr;
    /**
     * 不计销量
     */
    private String noSalesCount;
    /**
     * 删除评价
     */
    private Integer rateDeleteCount;
    /**
     * 真实姓名
     */
    private String trueName;
    /**
     * 是否实名
     */
    private String realNameAuth;
    /**
     * 性别
     */
    private String sex;
    /**
     * 生日
     */
    private String birthday;
    /**
     * 信用评分
     */
    private String credit;
    /**
     * 淘气值
     */
    private Integer taoScore;
    /**
     * 好评率
     */
    private String feedbackRate;

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public Integer getPunishCountStr() {
        return punishCountStr;
    }

    public void setPunishCountStr(Integer punishCountStr) {
        this.punishCountStr = punishCountStr;
    }

    public String getNoSalesCount() {
        return noSalesCount;
    }

    public void setNoSalesCount(String noSalesCount) {
        this.noSalesCount = noSalesCount;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public String getRealNameAuth() {
        return realNameAuth;
    }

    public void setRealNameAuth(String realNameAuth) {
        this.realNameAuth = realNameAuth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public String getFeedbackRate() {
        return feedbackRate;
    }

    public void setFeedbackRate(String feedbackRate) {
        this.feedbackRate = feedbackRate;
    }

    public Integer getRateDeleteCount() {
        return rateDeleteCount;
    }

    public void setRateDeleteCount(Integer rateDeleteCount) {
        this.rateDeleteCount = rateDeleteCount;
    }

    public static List<PlatformOrderDto> valueOf(List<ViewInformation> list) {
        List<PlatformOrderDto> dtos = new ArrayList<>();
        for (ViewInformation info : list) {
            PlatformOrderDto dto = new PlatformOrderDto();
            dto.setNick(info.getNick());
            dto.setPunishCountStr(info.getPunishCountStr());
            dto.setNoSalesCount(info.getNoSalesCount());
            dto.setRateDeleteCount(info.getRateDeleteCount());
            dto.setSex(info.getSex());
            dto.setBirthday(info.getBirthday());
            dto.setCredit(info.getCredit());
            dto.setRealNameAuth(info.getRealNameAuth());
            dto.setTrueName(info.getTrueName());
            dto.setFeedbackRate(info.getFeedbackRate());
            dto.setTaoScore(info.getTaoScore());
            dtos.add(dto);
        }
        return dtos;
    }

    public Integer getTaoScore() {
        return taoScore;
    }

    public void setTaoScore(Integer taoScore) {
        this.taoScore = taoScore;
    }
}
