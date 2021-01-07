/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package printExcelPdf;

import entity.ProductDetailsEntity;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

/**
 *
 * @author HP
 */
public class ExcelView extends AbstractXlsView {

    @Override
    public void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest requets, HttpServletResponse response) throws Exception {

        Sheet excelSheet = workbook.createSheet("ProductDetails List");
        setExcelHeader(excelSheet);

        List<ProductDetailsEntity> productDetailsList = (List<ProductDetailsEntity>) model.get("productDetailsList");
        setExcelRows(excelSheet, productDetailsList);

    }

    public void setExcelHeader(Sheet excelSheet) {
        Row excelHeader = excelSheet.createRow(0);
        excelHeader.createCell(0).setCellValue("ID");
        excelHeader.createCell(1).setCellValue("Name");
        excelHeader.createCell(2).setCellValue("Details");
        
        excelHeader.createCell(4).setCellValue("Price");
        excelHeader.createCell(5).setCellValue("Sex");
        excelHeader.createCell(6).setCellValue("Age Group");
        excelHeader.createCell(7).setCellValue("Color");
        excelHeader.createCell(8).setCellValue("Size");
    }

    public void setExcelRows(Sheet excelSheet, List<ProductDetailsEntity> productDetailsList) {
        int record = 1;
        for (ProductDetailsEntity productDetails : productDetailsList) {
            Row excelRow = excelSheet.createRow(record++);
            excelRow.createCell(0).setCellValue(productDetails.getProductDetailsId());
            excelRow.createCell(1).setCellValue(productDetails.getProduct().getProductName());
            excelRow.createCell(2).setCellValue(productDetails.getProductDetailsName());
          
            excelRow.createCell(4).setCellValue(productDetails.getPrice());
            excelRow.createCell(5).setCellValue(productDetails.getSex().getSexName());
            excelRow.createCell(6).setCellValue(productDetails.getAgeGroup().getAgeName());
            excelRow.createCell(7).setCellValue(productDetails.getColor().getColorName());
            excelRow.createCell(8).setCellValue(productDetails.getSize().getSizeName());
        }
    }



}

