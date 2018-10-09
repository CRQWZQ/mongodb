package com.metabolic.mongodb.dao.impl;

import com.metabolic.mongodb.dao.InformationDao;
import com.metabolic.mongodb.dao.InformationRepository;
import com.metabolic.mongodb.model.InformationMongo;
import com.metabolic.mongodb.model.ViewInformation;
import com.metabolic.mongodb.service.GenenDocumentName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZQ_W on 2018/08/11.
 */
@Component
public class InformationDaoImpl implements InformationDao {

    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private InformationRepository informationRepository;

    /**
     * 查找指定日期的检验数据
     * @param createTime  检测时间 yyyy-MM-dd
     * @return  返回list集合形式的检测账号详情信息
     */
    @Override
    public List<ViewInformation> findInformationByTime(String createTime) {
        Query query = Query.query(Criteria.where("create_time").gte(createTime /*+ " 00:00:00"*/).lte(createTime/* + " 23:59:59"*/));
        return  mongoTemplate.find(query, ViewInformation.class, "detector");
    }

    /**
     * 根据被检测人昵称和指定日期匹配检测详情
     * @param nick 被检测人姓名
     * @param createTime 被检测时间 yyyy-MM-dd
     * @return 检测人员详细数据信息
     */
    @Override
    public List<InformationMongo> findInformationByParam(String nick, String createTime) {
        Query query = Query.query(Criteria.where("nick").is(nick).and("create_time")
                .gte(createTime + " 00:00:00").lte(createTime + " 23:59:59"));
        return mongoTemplate.find(query, InformationMongo.class);
    }

    /**
     * 根据id获取被检测的详细数据
     * @param id
     * @return
     */
    @Override
    public InformationMongo findById(String id){
        return mongoTemplate.findById( id, InformationMongo.class);
    }

    /**
     * 获取验号数据列表
     * @param createTime
     * @return
     */
    @Override
    public List<ViewInformation> findInformationByTimeList(String createTime) {
        GenenDocumentName genenDocumentName = new GenenDocumentName();
        genenDocumentName.setValue(createTime);
        Query query = Query.query(Criteria.where("create_time").gte(createTime ).lte(createTime));
        return  mongoTemplate.find(query, ViewInformation.class, genenDocumentName.getDocumentName());
    }


}
