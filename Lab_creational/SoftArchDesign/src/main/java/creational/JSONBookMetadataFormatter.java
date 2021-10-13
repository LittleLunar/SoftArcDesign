package creational;

import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JSONBookMetadataFormatter implements BookMetadataFormatter {
	
	private JSONObject mainObj;
	private JSONArray collectionBook;
	
	public JSONBookMetadataFormatter() throws IOException {
		
		reset();
	}
	
    public BookMetadataFormatter reset() {
    	
    	mainObj = new JSONObject();
    	collectionBook = new JSONArray();
    	
    	mainObj.put("Books", collectionBook);
    	
        return this;
    }

    @Override
    public BookMetadataFormatter append(Book b) {
    	
        JSONObject bookObj = new JSONObject();
        
        bookObj.put("ISBN", b.getISBN());
        
        if (b.getAuthors().length == 1) {
        	
        	bookObj.put("Authors", b.getAuthors()[0]);
        	
        } else {
        	
        	JSONArray authorArr = new JSONArray();
        	
        	for (String s : b.getAuthors()) {
        		authorArr.add(s);
        	}
        	
        	bookObj.put("Authors", authorArr);
        }
        
        bookObj.put("Title", b.getTitle());
        bookObj.put("Publisher", b.getPublisher());
        
        
        collectionBook.add(bookObj);
        
        return this;
    }

    @Override
    public String getMetadataString() {
    	
        return mainObj.toString();
    }
}
