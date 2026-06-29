package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFSheet sh;
	public XSSFWorkbook wb;
	public XSSFRow row;
	public XSSFCell cell;
	public CellStyle style;
	private String path;

	public ExcelUtils(String path) {
		this.path = path;
	}

	public int getRowCount(String Sheetname) throws Exception {
		fi = new FileInputStream(path);
		wb = new XSSFWorkbook(fi);
		sh = wb.getSheet(Sheetname);
		int RowCount = sh.getLastRowNum();

		wb.close();
		fi.close();
		return RowCount;
	}

	public int getcellcount(String Sheetname, int rownum) throws IOException {
		fi = new FileInputStream(path);
		wb = new XSSFWorkbook(fi);
		sh = wb.getSheet(Sheetname);

		XSSFRow Row = sh.getRow(rownum);

		int cellnum = row.getLastCellNum();

		wb.close();
		fi.close();

		return cellnum;

	}

	public String getCellData(String Sheetname, int rownum, int colnum) throws IOException {
		fi = new FileInputStream(path);

		wb = new XSSFWorkbook(fi);
		sh = wb.getSheet(Sheetname);

		row = sh.getRow(rownum);
		cell = row.getCell(colnum);

		DataFormatter formatter = new DataFormatter();

		String data;
		try {
			data = formatter.formatCellValue(cell);
		}

		catch (Exception e) {
			data = "";
		}

		wb.close();
		fi.close();

		return data;

	}

	public void setCellData(String Sheetname, int rownum, int col, String data) throws IOException

	{
		// if file does not exists then it will create a file
		File xlfile = new File(path);
		if (!xlfile.exists()) {
			fo = new FileOutputStream(path); // create a file

			wb = new XSSFWorkbook(); // create a blank workbook

			wb.write(fo);// it will save

			wb.close(); // close workbook
			fo.close();

		}

		fi = new FileInputStream(path); // this will read the file
		wb = new XSSFWorkbook(fi); // this will load the workbook into memory

		if (wb.getSheetIndex(Sheetname) == -1) {
			sh = wb.createSheet();
			sh = wb.getSheet(Sheetname);

			if (sh.getRow(rownum) == null) {

				row = sh.createRow(rownum);
			} else {
				row = sh.getRow(rownum);
			}
		}
		if (row.getCell(col) == null) {
			cell = row.createCell(col);
		} else {
			cell = row.getCell(col);
		}
		cell.setCellValue(data);

		fo = new FileOutputStream(path);

		wb.write(fo);
		wb.close();

		fo.close();
		fi.close();

	}

	public void setGreenColor(String Sheetname, int rownum, int col) throws IOException {
		fi = new FileInputStream(path);
		wb = new XSSFWorkbook(fi);
		sh = wb.createSheet();

		row = sh.getRow(rownum);

		cell = row.getCell(col);

		style = wb.createCellStyle();

		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		cell.setCellStyle(style);

		fo = new FileOutputStream(path);

		wb.write(fo);

		wb.close();
		fo.close();
		fi.close();

	}

	public void setRedColor(String Sheetname, int rownum, int col) throws IOException {

		fi = new FileInputStream(path);

		wb = new XSSFWorkbook(fi);

		sh = wb.createSheet();

		row = sh.getRow(rownum);
		cell = row.getCell(col);

		style = wb.createCellStyle();
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		fo = new FileOutputStream(path);

		wb.write(fo);

		wb.close();
		fi.close();
		fo.close();
	}

}
