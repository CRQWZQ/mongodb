package com.metabolic.mongodb.controller;

import com.google.common.collect.Lists;
import com.metabolic.mongodb.dao.InformationDao;
import com.metabolic.mongodb.dao.InformationRepository;
import com.metabolic.mongodb.dto.PlatformOrderDto;
import com.metabolic.mongodb.model.InformationMongo;
import com.metabolic.mongodb.model.ViewInformation;
import com.metabolic.mongodb.result.BusinessException;
import com.metabolic.mongodb.result.CodeMsg;
import com.metabolic.mongodb.result.Result;
import com.metabolic.mongodb.untils.ExcelExportUtil;
import com.metabolic.mongodb.untils.ExcelExporter;
import com.metabolic.mongodb.untils.TimeTypeCheckUtil;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.logging.Logger;

import static com.metabolic.mongodb.result.CodeMsg.EXCEL_EXPORT_ERROR;
import static com.metabolic.mongodb.result.CodeMsg.EXCEL_UNKNOWN_ERROR;

/**
 * Created by Administrator on 2018/08/21.
 */
@RestController
@RequestMapping(value = "/info")
public class InformationController {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(InformationController.class);
    @Resource
    private InformationDao informationDao;

    /**
     * 查询某个日期的检验数据
     * @param time 日期 eg： 2018-08-21
     * @return
     */
    @RequestMapping(value = "/orders_info", method = RequestMethod.GET)
    public Result<List<ViewInformation>> ordersInfoList(String time) {
        if(!TimeTypeCheckUtil.isValidDate(time)) {
            Result.error(CodeMsg.REQUEST_ILLEGAL);
        }
        return  Result.success(informationDao.findInformationByTime(time));
    }

    /**
     * 查询指定日期、指定检测昵称的用户数据
     *
     * @param time 日期 eg:2018-08-20
     * @param nick 被检测人昵称  eg:tb_073****
     * @return
     */
    @RequestMapping(value = "/orders_by_nick", method = RequestMethod.GET)
    public Result<List<InformationMongo>> ordersBynick (String time, String nick) {
        if(!TimeTypeCheckUtil.isValidDate(time) || nick.isEmpty()) {
            Result.error(CodeMsg.REQUEST_ILLEGAL);
        }
        return Result.success(informationDao.findInformationByParam(time, nick));
    }

    @RequestMapping(value = "/order_by_id", method = RequestMethod.GET)
    public Result<InformationMongo> orderById(String id) {
        if (id.isEmpty()) {
            Result.error(CodeMsg.REQUEST_ILLEGAL);
        }
        return Result.success(informationDao.findById(id));
    }

    @RequestMapping(value = "/orders_info_list", method = RequestMethod.GET)
    public Result<List<ViewInformation>> ordersInfoListTime (String time) {
        if(!TimeTypeCheckUtil.isValidDate(time)) {
            Result.error(CodeMsg.REQUEST_ILLEGAL);
        }
        return Result.success(informationDao.findInformationByTimeList(time));
    }
    /**
     * 导出Excel 验号数据
     * @param request
     * @param response
     * @param time
     * @return
     */
    @RequestMapping(value = "/orders_info_export", method = RequestMethod.GET)
    Result<Boolean> exportOrdersInfo(HttpServletRequest request, HttpServletResponse response,  String time) {
        List<ViewInformation> list = informationDao.findInformationByTime(time);
        if (CollectionUtils.isEmpty(list)) {
            throw new BusinessException(EXCEL_UNKNOWN_ERROR, "无数据可以导出");
        }
        List<PlatformOrderDto> dtos = PlatformOrderDto.valueOf(list);
        List<String> attrList = Lists.newArrayList("nick", "punishCountStr", "noSalesCount", "rateDeleteCount", "trueName", "realNameAuth", "sex", "birthday", "taoScore", "credit", "feedbackRate");
        List<String> header = Lists.newArrayList("旺旺昵称", "违规记录", "不计销量", "删评记录", "真实姓名", "是否实名", "性别", "生日", "淘气值", "信用评分", "好评率");
        try{
            Workbook workbook = ExcelExporter.exportExcelFromList("查验账号列表", dtos, attrList, header, PlatformOrderDto.class);
            ExcelExportUtil.export(request, response, workbook, "查验账号列表.xlsx");
        }catch (Exception e){
            LOGGER.warn("export exportOrdersInfo failed | e=" , e);
            throw new BusinessException(EXCEL_EXPORT_ERROR, "账号检测列表导出失败");
        }
        return Result.success(true);
    }

}

