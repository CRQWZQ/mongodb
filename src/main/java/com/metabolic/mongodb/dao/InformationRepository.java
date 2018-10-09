package com.metabolic.mongodb.dao;

import com.metabolic.mongodb.model.ViewInformation;
import com.metabolic.mongodb.service.GenenDocumentName;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * Created by ZQ_W on 2018/08/10.
 */
public interface InformationRepository extends MongoRepository<ViewInformation, String> {

}
