package creational;

import javax.xml.parsers.ParserConfigurationException;

public class XMLBookMetadataExporter extends BookMetadataExporter {
	
	public XMLBookMetadataExporter() throws ParserConfigurationException {
		formatObj = new XMLBookMetadataFormatter();
	}
	
}