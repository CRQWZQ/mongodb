package com.metabolic.mongodb.model;

import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;


public class PunishInfo implements Serializable {

    private static final long serialVersionUID = 3105667072090285773L;

    @Field("ruleTypeStr")
    private String ruleTypeStr; //违规方式

    @Field("punishId")
    private String punishId;//违规id

    @Field("ruleCodeName")
    private String ruleCodeName;//违规代码名称

    @Field("pointRangeStr")
    private String pointRangeStr; //违规类型

    public String getRuleTypeStr() {
        return ruleTypeStr;
    }

    public void setRuleTypeStr(String ruleTypeStr) {
        this.ruleTypeStr = ruleTypeStr;
    }

    public String getPunishId() {
        return punishId;
    }

    public void setPunishId(String punishId) {
        this.punishId = punishId;
    }

    public String getRuleCodeName() {
        return ruleCodeName;
    }

    public void setRuleCodeName(String ruleCodeName) {
        this.ruleCodeName = ruleCodeName;
    }

    public String getPointRangeStr() {
        return pointRangeStr;
    }

    public void setPointRangeStr(String pointRangeStr) {
        this.pointRangeStr = pointRangeStr;
    }

    @Override
    public String toString() {
        return "PunishInfo{" +
                "ruleTypeStr='" + ruleTypeStr + '\'' +
                ", punishId='" + punishId + '\'' +
                ", ruleCodeName='" + ruleCodeName + '\'' +
                ", pointRangeStr='" + pointRangeStr + '\'' +
                '}';
    }
}
