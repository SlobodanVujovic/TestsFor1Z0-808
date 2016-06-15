package mtsKmlToExcelConverter;

import org.xml.sax.*;
import org.w3c.dom.*;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.*;

public class ParseXmlFile {
	private Document xmlDoc = useXmlFile("./23092014_GE.xml");
	private String placemarkTag = "Placemark", descriptionTag = "description", coordinatesTag = "coordinates",
			nameTag = "name";
	private Map<String, SiteNode> hashSites = new HashMap<>();

	public Document getXmlDoc() {
		return xmlDoc;
	}

	public Map<String, SiteNode> getHashSites() {
		return hashSites;
	}

	private Document useXmlFile(String str) {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			factory.setIgnoringComments(true);
			factory.setIgnoringElementContentWhitespace(true);
			DocumentBuilder builder = factory.newDocumentBuilder();
			return builder.parse(new InputSource(str));
		} catch (Exception exp) {
			exp.printStackTrace();
		}
		return null;
	}

	public void getSiteNodes() {
		String rawName = "", rawDesc = "", rawCoor = "";
		NodeList listOfPlacemarks = xmlDoc.getElementsByTagName(placemarkTag);
		for (int i = 0; i < listOfPlacemarks.getLength(); i++) {
			Node placemarkNode = listOfPlacemarks.item(i);
			Element placemarkElement = (Element) placemarkNode;
			if (placemarkElement.getElementsByTagName(descriptionTag).getLength() != 0) {
				rawName = getNodeInSite(placemarkElement, nameTag);
				rawDesc = getNodeInSite(placemarkElement, descriptionTag);
				rawCoor = getNodeInSite(placemarkElement, coordinatesTag);
				SiteNode sNode = new SiteNode(rawName, rawDesc, rawCoor);
				sNode.parseDesc();
				hashSites.put(rawName, sNode);
			}
		}
	}

	public String getNodeInSite(Element siteNode, String tag) {
		String result = "";
		NodeList listOfNodes = siteNode.getElementsByTagName(tag);
		Node nodeOfTag = listOfNodes.item(0);
		Element elementOfTag = (Element) nodeOfTag;
		NodeList listInsideNode = elementOfTag.getChildNodes();
		Node insideNode = listInsideNode.item(0);
		result = insideNode.getNodeValue();
		if (tag.equals("description")) {
			result = result.replace("<b>", "");
			result = result.replace("</b>", "");
			result = result.replace("<br>", " ");
			result = result.replace(":", "");
			result = result.replace("  ", " ");
		}
		return result;
	}

}
