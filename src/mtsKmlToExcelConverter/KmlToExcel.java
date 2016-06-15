package mtsKmlToExcelConverter;

public class KmlToExcel {

	public static void main(String[] args) {
		ParseXmlFile xmlFile = new ParseXmlFile();
		xmlFile.getSiteNodes();
		PopulateExcel excelFile = new PopulateExcel();
		excelFile.createCellFile(xmlFile.getHashSites());
	}
}
