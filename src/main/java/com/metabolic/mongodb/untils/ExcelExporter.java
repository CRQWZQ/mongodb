package com.metabolic.mongodb.untils;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicates;
import com.metabolic.mongodb.result.BusinessException;
import org.reflections.ReflectionUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;

/**
 * Created by Administrator on 2018/09/13.
 */
public class ExcelExporter {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExcelExporter.class);

    public ExcelExporter() {
    }

    public static <T> Workbook exportExcelFromList(String sheetName, List<T> objList, List<String> attr, List<String> header, Class<T> clazz) {
        checkSize(attr, header);
        Workbook workbook = new XSSFWorkbook();
        return insertData(workbook, sheetName, objList, attr, header, clazz);
    }

    public static <T> Workbook exportExcelWithMultiSheet(Workbook workbook, String sheetName, List<T> objList, List<String> attr, List<String> header, Class<T> clazz) {
        Preconditions.checkNotNull(workbook);
        checkSize(attr, header);
        return insertData(workbook, sheetName, objList, attr, header, clazz);
    }

    private static void checkSize(List<String> attr, List<String> header) {
        if(header.size() != attr.size()) {
            throw new RuntimeException("excel Header和传入的列数不匹配");
        }
    }

    private static <T> Workbook insertData(Workbook workbook, String sheetName, List<T> objList, List<String> attr, List<String> header, Class<T> clazz) {
        Sheet sheet = workbook.createSheet(sheetName);
        int colNum = header.size();
        int rowNum = 0;
        int var15 = rowNum + 1;
        Row row = sheet.createRow(rowNum);

        for(int col = 0; col < colNum; ++col) {
            row.createCell(col).setCellValue((String)header.get(col));
        }

        List<List<Object>> lists = getValueList(objList, clazz, attr);
        Iterator var11 = lists.iterator();

        while(var11.hasNext()) {
            List<Object> list = (List)var11.next();
            row = sheet.createRow(var15++);

            for(int col = 0; col < colNum; ++col) {
                Cell cell = row.createCell(col);
                writeCell(workbook, list.get(col), cell);
            }
        }

        return workbook;
    }

    private static void writeCell(Workbook workbook, Object obj, Cell cell) {
        if(obj == null) {
            cell.setCellValue("");
        } else if(obj instanceof String) {
            cell.setCellValue((String)obj);
        } else if(obj instanceof Character) {
            cell.setCellValue((double)((Character)obj).charValue());
        } else if(obj instanceof Long) {
            cell.setCellValue((double)((Long)obj).longValue());
        } else if(obj instanceof Integer) {
            cell.setCellValue((double)((Integer)obj).intValue());
        } else if(obj instanceof Short) {
            cell.setCellValue((double)((Short)obj).shortValue());
        } else if(obj instanceof Byte) {
            cell.setCellValue((double)((Byte)obj).byteValue());
        } else if(obj instanceof Float) {
            cell.setCellValue((double)((Float)obj).floatValue());
        } else if(obj instanceof Double) {
            cell.setCellValue(((Double)obj).doubleValue());
        } else if(obj instanceof Boolean) {
            cell.setCellValue(((Boolean)obj).booleanValue());
        } else if(obj instanceof Date) {
            CellStyle cellStyle = workbook.createCellStyle();
            CreationHelper createHelper = workbook.getCreationHelper();
            cellStyle.setDataFormat(createHelper.createDataFormat().getFormat("yyyy/m/d h:mm:ss"));
            cell.setCellValue((Date)obj);
            cell.setCellStyle(cellStyle);
        }

    }

    public static <T> List<List<Object>> getValueList(List<T> objList, Class<T> clazz, List<String> attr) {
        Set<Method> methods = ReflectionUtils.getAllMethods(clazz, Predicates.and(ReflectionUtils.withModifier(Modifier.PUBLIC),
                ReflectionUtils.withPrefix("get")));
        Map<String, Method> methodMap = new HashMap<>();


        for (Method method : methods) {
            String attrName = ReflectionHelper.getAttrNameFromMethod(method.getName());
            if (attr.contains(attrName)) {
                methodMap.put(attrName, method);
            }
        }

        if (methodMap.keySet().size() != attr.size()) {
            throw new BusinessException("", "excel格式错误,列表和数据不一致,处理失败");
        }

        List<List<Object>> res = new ArrayList<>();
        for (T obj : objList) {
            List<Object> list = new ArrayList<>();
            for (String name : attr) {
                Method method = methodMap.get(name);
                try {
                    list.add(method.invoke(obj));
                } catch (Exception e) {
                    LOGGER.error("get value error");
                    throw new BusinessException("", "excel格式错误,不能获取对应列的数据|" + name);
                }
            }
            res.add(list);
        }
        return res;
    }
}
