package behavior;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class StringSubscription implements Flow.Subscription {
	
	private List<StringSubscriber> subscribers = new ArrayList<StringSubscriber>();
	
	
	public void addSubscriber(StringSubscriber subscriber) {
		this.subscribers.add(subscriber);
	}
	
	public void removeSubscriber(StringSubscriber subscriber) {
		this.subscribers.remove(subscriber);
	}
	
	public List<StringSubscriber> getSubscribers() {
		return subscribers;
	}
	
	@Override
	public void request(long n) {}

	@Override
	public void cancel() {}

	


	
}
