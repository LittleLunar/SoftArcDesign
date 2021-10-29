package behavior;

import java.util.concurrent.*;

public class StringPublisher implements Flow.Publisher<String> {
	
	
	private StringSubscription subscription;
	
	private final int SUBSCRIBER_LIMIT = 3;
	private int numberOfSubscriber = 0;
	
	StringPublisher() {
		subscription = new StringSubscription();
	}
	
	@Override
	public void subscribe(Flow.Subscriber<? super String> subscriber) {
		if (numberOfSubscriber < SUBSCRIBER_LIMIT) {
			
			numberOfSubscriber += 1;
			subscriber.onSubscribe(subscription);
			
		} else {
			subscriber.onError(new IllegalStateException());
		}
	}
	
	public void publish(String item) {
		for(StringSubscriber subscriber : this.subscription.getSubscribers()) {
			subscriber.onNext(item);
		}
	}
	
}
