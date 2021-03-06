package behavior;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.concurrent.Flow;

public class SymbolSubscriber extends StringSubscriber {
	
	
	SymbolSubscriber(String name) throws IOException {
		super(name);
		
		String filename = "Symbol.txt";
		Path filePath = Paths.get(System.getProperty("user.dir"), "src","behavior",filename);
		
		this.file = new File(filePath.toString());
		
	}

	@Override
	public void onSubscribe(Flow.Subscription subscription) {
		this.subscription = subscription;
		((StringSubscription) this.subscription).addSubscriber(this);
	}

	@Override
	public void onNext(String item) {
		
		if (item.matches("(.*)[[^a-zA-z0-9]&&[^\s]](.*)")) {
			
			try {
				Timestamp timestamp = new Timestamp(System.currentTimeMillis());
				FileWriter fwriter = new FileWriter(file, true);
				
				System.out.println("SymbolSubscriber " + this.name + " receives : " + item);
				
				fwriter.write(timestamp.toString() + " : " + item + "\n");
				
				fwriter.flush();
				fwriter.close();
				fwriter = null;
				timestamp = null;
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
}
