package mtsKmlToExcelConverter;

import java.io.*;
import java.util.Map;
import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;

public class PopulateExcel {
	private String fileStr = "C:\\Java workspace\\testsFor1Z0-808\\Cell_file.xlsx";
	private File cellFile = new File(fileStr);

	public void createCellFile(Map<String, SiteNode> map) {
		int rowNo = 0, colNo = 0;
		Row gsmRow;
		Cell gsmCell;
		try {
			InputStream fInputStream = new FileInputStream(cellFile.toString());
			XSSFWorkbook workbook = new XSSFWorkbook(fInputStream);
			XSSFSheet sheet = workbook.getSheetAt(0);
			for (SiteNode sNode : map.values()) {
				for (int i = 0; i < sNode.getSectorList().size(); i++) {
					gsmRow = sheet.createRow(rowNo);
					gsmCell = gsmRow.createCell(colNo);
					gsmCell.setCellType(Cell.CELL_TYPE_STRING);
					gsmCell.setCellValue(sNode.getRawName());
					colNo++;
					gsmCell = gsmRow.createCell(colNo);
					gsmCell.setCellType(Cell.CELL_TYPE_STRING);
					gsmCell.setCellValue(sNode.getSectorList().get(i));
					colNo++;
					gsmCell = gsmRow.createCell(colNo);
					gsmCell.setCellType(Cell.CELL_TYPE_STRING);
					gsmCell.setCellValue(sNode.getRawCoor());
					colNo++;
					gsmCell = gsmRow.createCell(colNo);
					gsmCell.setCellType(Cell.CELL_TYPE_STRING);
					gsmCell.setCellValue(sNode.getAntennaList().get(i));
					colNo++;
					gsmCell = gsmRow.createCell(colNo);
					gsmCell.setCellType(Cell.CELL_TYPE_STRING);
					gsmCell.setCellValue(sNode.getAzimuthList().get(i));
					colNo++;
					gsmCell = gsmRow.createCell(colNo);
					gsmCell.setCellType(Cell.CELL_TYPE_STRING);
					gsmCell.setCellValue(sNode.geteTiltList().get(i));
					colNo++;
					gsmCell = gsmRow.createCell(colNo);
					gsmCell.setCellType(Cell.CELL_TYPE_STRING);
					gsmCell.setCellValue(sNode.getmTiltList().get(i));
					colNo++;
					gsmCell = gsmRow.createCell(colNo);
					gsmCell.setCellType(Cell.CELL_TYPE_STRING);
					gsmCell.setCellValue(sNode.getHeightList().get(i));
					colNo = 0;
					rowNo++;
				}
				colNo = 8;
				rowNo -= sNode.getSectorList().size();
				gsmRow = sheet.getRow(rowNo);
				for (int i = 0; i < sNode.getBcchList().size(); i++) {
					gsmCell = gsmRow.createCell(colNo);
					gsmCell.setCellType(Cell.CELL_TYPE_STRING);
					gsmCell.setCellValue(sNode.getBcchList().get(i));
					colNo++;
					gsmCell = gsmRow.createCell(colNo);
					gsmCell.setCellType(Cell.CELL_TYPE_STRING);
					gsmCell.setCellValue(sNode.getBsicList().get(i));
					colNo++;
					gsmCell = gsmRow.createCell(colNo);
					gsmCell.setCellType(Cell.CELL_TYPE_STRING);
					gsmCell.setCellValue(sNode.getCgiList().get(i));
					colNo++;
					gsmCell = gsmRow.createCell(colNo);
					gsmCell.setCellType(Cell.CELL_TYPE_STRING);
					gsmCell.setCellValue(sNode.getFreqList().get(i));
					colNo = 8;
					rowNo++;
					gsmRow = sheet.getRow(rowNo);
				}
				colNo = 12;
				for (int i = 0; i < sNode.getScList().size(); i++) {
					gsmCell = gsmRow.createCell(colNo);
					gsmCell.setCellType(Cell.CELL_TYPE_STRING);
					gsmCell.setCellValue(sNode.getScList().get(i));
					colNo++;
					gsmCell = gsmRow.createCell(colNo);
					gsmCell.setCellType(Cell.CELL_TYPE_STRING);
					gsmCell.setCellValue(sNode.getFddList().get(i));
					colNo = 12;
					rowNo++;
					gsmRow = sheet.getRow(rowNo);
				}
				colNo = 0;
			}
			FileOutputStream fOutputStream = new FileOutputStream(cellFile);
			workbook.write(fOutputStream);
			fOutputStream.close();
			fInputStream.close();
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
