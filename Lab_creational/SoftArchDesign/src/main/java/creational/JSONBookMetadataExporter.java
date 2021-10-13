package creational;

import java.io.IOException;

public class JSONBookMetadataExporter extends BookMetadataExporter {
	
	public JSONBookMetadataExporter() throws IOException {
		formatObj = new JSONBookMetadataFormatter();
	}
}
