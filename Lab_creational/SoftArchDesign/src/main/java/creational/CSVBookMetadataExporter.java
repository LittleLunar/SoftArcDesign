package creational;

import java.io.IOException;

public class CSVBookMetadataExporter extends BookMetadataExporter {
	
	public CSVBookMetadataExporter() throws IOException {
		formatObj = new CSVBookMetadataFormatter();
	}
}
