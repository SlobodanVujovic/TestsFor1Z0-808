package mtsKmlToExcelConverter;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import static org.hamcrest.CoreMatchers.*;

public class ParseXmlFile_getDocumentTest {
	private ParseXmlFile parseXml;
	private Document xmlDoc;
	private NodeList listOfPlacemark;
	private Node placemarkNode;
	private Element placemarkElement;

	@Before
	public void setUp() {
		parseXml = new ParseXmlFile();
		xmlDoc = parseXml.getXmlDoc();
		listOfPlacemark = xmlDoc.getElementsByTagName("Placemark");
		placemarkNode = listOfPlacemark.item(0);
		placemarkElement = (Element) placemarkNode;
	}

	@Test
	public void rootElementName() {
		assertEquals(xmlDoc.getDocumentElement().getNodeName(), "kml");
	}

	@Test
	public void getNodesWithPlacemarkTag() {
		NodeList listOfDocument = xmlDoc.getElementsByTagName("Placemark");

		assertEquals(listOfDocument.getLength(), 17912);
	}

	@Test
	public void numberOfNameNodesWithinPlacemarkTag() {
		NodeList listOfNames = placemarkElement.getElementsByTagName("name");

		assertThat(listOfNames.getLength(), equalTo(1));
	}

	@Test
	public void numberOfDescriptionNodesWithinPlacemarkTag() {
		NodeList listOfDescriptions = placemarkElement.getElementsByTagName("description");

		assertThat(listOfDescriptions.getLength(), equalTo(1));
	}

	@Test
	public void numberOfCoordinatesNodesWithinPlacemarkTag() {
		NodeList listOfCoordinates = placemarkElement.getElementsByTagName("coordinates");

		assertThat(listOfCoordinates.getLength(), equalTo(1));
	}

	@Test
	public void coordinatesWithinFirstPlacemarkTag() {
		String result = parseXml.getNodeInSite(placemarkElement, "coordinates");

		assertThat(result, equalTo("20.4581417,44.8179778,38"));
	}

	@Test
	public void parseDescriptionWithinFirstPlacemarkTag() {
		String result = parseXml.getNodeInSite(placemarkElement, "description");

		assertThat(result, equalTo(
				"Sector BG04D1 Antenna 742241_0947_07T Azimuth 60.0 m.tilt 5.0 e.tilt 7.0 Height 38.00 BCCHNO 52 BSIC 71 Freq 52&25&26&27&28&29&30&31&32&33&34&35&36&37&38&39&40&41&42 CGI 220-03-52011-10104 BSC BBG01D MSC VBG01BC Sector BG04D2 Antenna 742241_0947_07T Azimuth 200.0 m.tilt 8.0 e.tilt 7.0 Height 40.00 BCCHNO 58 BSIC 31 Freq 58&25&26&27&28&29&30&31&32&33&34&35&36&37&38&39&40&41&42 CGI 220-03-52011-20104 BSC BBG01D MSC VBG01BC Sector BG04D3 Antenna 742241_0947_06T Azimuth 310.0 m.tilt 4.0 e.tilt 6.0 Height 38.00 BCCHNO 56 BSIC 31 Freq 56&25&26&27&28&29&30&31&32&33&34&35&36&37&38&39&40&41&42 CGI 220-03-52011-30104 BSC BBG01D MSC VBG01BC Sector BGH04D1 Antenna 742241_1855_06T Azimuth 60.0 m.tilt 5.0 e.tilt 6.0 Height 38.00 BCCHNO 623 BSIC 30 Freq 623&632&633&634&635&636&637&638&639&640&641&642&643&644&645&646&647&648&649&650&651&652&653&654&655&656&657&658 CGI 220-03-52011-15004 BSC BBG01D MSC VBG01BC Sector BGH04D2 Antenna 742241_1855_07T Azimuth 200.0 m.tilt 8.0 e.tilt 7.0 Height 40.00 BCCHNO 616 BSIC 35 Freq 616&632&633&634&635&636&637&638&639&640&641&642&643&644&645&646&647&648&649&650&651&652&653&654&655&656&657&658 CGI 220-03-52011-25004 BSC BBG01D MSC VBG01BC Sector BGH04D3 Antenna 742241_1855_06T Azimuth 310.0 m.tilt 4.0 e.tilt 6.0 Height 38.00 BCCHNO 625 BSIC 75 Freq 625&632&633&634&635&636&637&638&639&640&641&642&643&644&645&646&647&648&649&650&651&652&653&654&655&656&657&658 CGI 220-03-52011-35004 BSC BBG01D MSC VBG01BC Sector BGU04A Antenna 742241_2140_08T Azimuth 60 m.tilt 5 e.tilt 8.0 Height 38 SCRCODE 287 FDDARFCN 10638 RNC RBG00 MSC VBG02S Sector BGU04B Antenna 742241_2140_08T Azimuth 200 m.tilt 8 e.tilt 8.0 Height 40 SCRCODE 85 FDDARFCN 10638 RNC RBG00 MSC VBG02S Sector BGU04C Antenna 742241_2140_08T Azimuth 310 m.tilt 4 e.tilt 8.0 Height 38 SCRCODE 138 FDDARFCN 10638 RNC RBG00 MSC VBG02S Sector BGU04I Antenna 742241_2140_08T Azimuth 60 m.tilt 5 e.tilt 8.0 Height 38 SCRCODE 287 FDDARFCN 10663 RNC RBG00 MSC VBG02S Sector BGU04J Antenna 742241_2140_08T Azimuth 200 m.tilt 8 e.tilt 8.0 Height 40 SCRCODE 85 FDDARFCN 10663 RNC RBG00 MSC VBG02S Sector BGU04K Antenna 742241_2140_08T Azimuth 310 m.tilt 4 e.tilt 8.0 Height 38 SCRCODE 138 FDDARFCN 10663 RNC RBG00 MSC VBG02S "));
	}

	@Test
	public void sectorsWithinFirstPlacemarkTag() {
		parseXml.getSiteNodes();
		String result = parseXml.getHashSites().get("Leposavic - KM10").getSectorList().toString();
		assertThat(result, equalTo("[KM10D1, KM10D2, KM10D3]"));
	}

	@Test
	public void numberOfAllSitesInXml() {
		parseXml.getSiteNodes();

		assertThat(parseXml.getHashSites().size(), equalTo(2079));
	}

	@Test
	public void checkIfHashSitesMatchWithXml() {
		parseXml.getSiteNodes();
		SiteNode sNode = parseXml.getHashSites().get("BG-Cukaricka_padina - BG106,BGH106,BGU106");
		String result = sNode.getRawCoor();

		assertThat(result, equalTo("20.4093056,44.7764889,19"));
	}

	@Test
	public void checkNumberOfElementsInDesc() {
		parseXml.getSiteNodes();
		SiteNode sNode = parseXml.getHashSites().get("BG-Akademija - BG04,BGH04,BGU04");
		int sectorNo = sNode.getSectorList().size();
		int antennaNo = sNode.getAntennaList().size();

		assertEquals(sectorNo, antennaNo);
		assertTrue(sectorNo == 12);
	}

}
