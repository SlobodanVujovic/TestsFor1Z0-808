package mtsKmlToExcelConverter;

import java.util.ArrayList;
import java.util.List;

public class SiteNode {
	private String rawName, rawDesc, rawCoor;
	private List<String> sectorList = new ArrayList<>();
	private List<String> antennaList = new ArrayList<>();
	private List<String> azimuthList = new ArrayList<>();
	private List<String> mTiltList = new ArrayList<>();
	private List<String> eTiltList = new ArrayList<>();
	private List<String> heightList = new ArrayList<>();
	private List<String> bcchList = new ArrayList<>();
	private List<String> bsicList = new ArrayList<>();
	private List<String> freqList = new ArrayList<>();
	private List<String> cgiList = new ArrayList<>();
	private List<String> scList = new ArrayList<>();
	private List<String> fddList = new ArrayList<>();

	public SiteNode(String rawName, String rawDesc, String rawCoor) {
		this.rawName = rawName;
		this.rawDesc = rawDesc;
		this.rawCoor = rawCoor;
	}

	public String getRawName() {
		return rawName;
	}

	public String getRawDesc() {
		return rawDesc;
	}

	public String getRawCoor() {
		return rawCoor;
	}

	public List<String> getSectorList() {
		return sectorList;
	}

	public List<String> getAntennaList() {
		return antennaList;
	}

	public List<String> getAzimuthList() {
		return azimuthList;
	}

	public List<String> getmTiltList() {
		return mTiltList;
	}

	public List<String> geteTiltList() {
		return eTiltList;
	}

	public List<String> getHeightList() {
		return heightList;
	}

	public List<String> getBcchList() {
		return bcchList;
	}

	public List<String> getBsicList() {
		return bsicList;
	}

	public List<String> getFreqList() {
		return freqList;
	}

	public List<String> getCgiList() {
		return cgiList;
	}

	public List<String> getScList() {
		return scList;
	}

	public List<String> getFddList() {
		return fddList;
	}

	public void parseDesc() {
		String[] tokenDesc = rawDesc.split(" ");
		for (int i = 0; i < tokenDesc.length; i += 2) {
			if (tokenDesc[i].trim().contains("Sector")) {
				sectorList.add(tokenDesc[i + 1]);
			} else if (tokenDesc[i].trim().contains("Antenna")) {
				antennaList.add(tokenDesc[i + 1]);
			} else if (tokenDesc[i].trim().contains("Azimuth")) {
				azimuthList.add(tokenDesc[i + 1]);
			} else if (tokenDesc[i].trim().contains("m.tilt")) {
				mTiltList.add(tokenDesc[i + 1]);
			} else if (tokenDesc[i].trim().contains("e.tilt")) {
				eTiltList.add(tokenDesc[i + 1]);
			} else if (tokenDesc[i].trim().contains("Height")) {
				heightList.add(tokenDesc[i + 1]);
			} else if (tokenDesc[i].trim().contains("BCCHNO")) {
				bcchList.add(tokenDesc[i + 1]);
			} else if (tokenDesc[i].trim().contains("BSIC")) {
				bsicList.add(tokenDesc[i + 1]);
			} else if (tokenDesc[i].trim().contains("Freq")) {
				freqList.add(tokenDesc[i + 1]);
			} else if (tokenDesc[i].trim().contains("CGI")) {
				cgiList.add(tokenDesc[i + 1]);
			} else if (tokenDesc[i].trim().contains("SCRCODE")) {
				scList.add(tokenDesc[i + 1]);
			} else if (tokenDesc[i].trim().contains("FDDARFCN")) {
				fddList.add(tokenDesc[i + 1]);
			}
		}
	}
}
