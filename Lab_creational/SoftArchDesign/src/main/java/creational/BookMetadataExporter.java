package creational;

import java.io.PrintStream;

public abstract class BookMetadataExporter extends BookCollection {
	
	protected BookMetadataFormatter formatObj;

    public void export(PrintStream stream) {
    	
    	for (Book b : books) {
    		formatObj.append(b);
    	}
    	
        stream.println(formatObj.getMetadataString());
    }
    
}
