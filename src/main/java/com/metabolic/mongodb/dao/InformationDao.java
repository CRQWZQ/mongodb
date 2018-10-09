package com.metabolic.mongodb.dao;



import com.metabolic.mongodb.model.InformationMongo;
import com.metabolic.mongodb.model.ViewInformation;

import java.util.List;

/**
 * Created by ZQ_W on 2018/08/11.
 */
public interface InformationDao {

    List<ViewInformation> findInformationByTime(String createTime);

    List<InformationMongo> findInformationByParam(String nick, String createTime);

    InformationMongo findById(String id);

    List<ViewInformation> findInformationByTimeList(String createTime);


}
