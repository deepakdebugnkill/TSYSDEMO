package com.demo.ui.common_utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileUtils {
	
	public static String readCellData(String filePath, String sheetName, int rowNum, int cellNum) throws IOException {

		String ret = null;

		FileInputStream fileInput = new FileInputStream(new File(filePath));

		Workbook workbook = new XSSFWorkbook(fileInput);

		Sheet sheet = workbook.getSheet(sheetName);

		Row row = sheet.getRow(rowNum);

		Cell cell = row.getCell(cellNum);

		if (cell != null) {

			CellType type = cell.getCellType();

			switch (type) {

			case STRING:

				ret = cell.getStringCellValue();

				break;

			case NUMERIC:

				if (DateUtil.isCellDateFormatted(cell)) {

					Date dateCellValue = cell.getDateCellValue();

					SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

					ret = dateFormat.format(dateCellValue);

				} else {

					double numericCellValue = cell.getNumericCellValue();

					long check = Math.round(numericCellValue);

					if (numericCellValue == check) {

						ret = String.valueOf(check);

					} else {

						ret = String.valueOf(numericCellValue);

					}

				}

				break;

			default:

				break;

			}

		}

		workbook.close();

		fileInput.close();

		return ret;

	}

	public static void updateCellData(String filePath, String sheetName, int rowNum, int cellNum, String oldData,
			String newData) throws IOException {

		FileInputStream fileInput = new FileInputStream(new File(filePath));

		Workbook workbook = new XSSFWorkbook(fileInput);

		Sheet sheet = workbook.getSheet(sheetName);

		Row row = sheet.getRow(rowNum);

		Cell cell = row.getCell(cellNum);

		String value = cell.getStringCellValue();

		if (value.equals(oldData)) {

			cell.setCellValue(newData);

		}

		FileOutputStream out = new FileOutputStream(new File(filePath));

		workbook.write(out);

		workbook.close();

		fileInput.close();

		out.close();

	}

	public static void writeCellData(String filePath, String sheetName, int rowNum, int cellNum, String data)
			throws IOException {

		FileInputStream fileInput = new FileInputStream(new File(filePath));

		Workbook workbook = new XSSFWorkbook(fileInput);

		Sheet sheet = workbook.getSheet(sheetName);

		Row row = sheet.getRow(rowNum);

		Cell cell = row.createCell(cellNum);

		cell.setCellValue(data);

		FileOutputStream out = new FileOutputStream(new File(filePath));

		workbook.write(out);

		workbook.close();

		fileInput.close();

		out.close();

	}

}
