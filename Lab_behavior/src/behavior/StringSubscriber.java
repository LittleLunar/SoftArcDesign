package behavior;

import java.io.File;
import java.util.concurrent.*;


public abstract class StringSubscriber implements Flow.Subscriber<String> {
	
	protected File file;
	protected String name;
	protected Flow.Subscription subscription;
	
	StringSubscriber(String name) {
		this.name = name;
	}
	
	@Override
	public void onSubscribe(Flow.Subscription subscription) {}

	@Override
	public void onNext(String item) {}

	@Override
	public void onError(Throwable throwable) {
		throwable.printStackTrace();
	}

	@Override
	public void onComplete() {
		System.out.println("Complete");
	}

	public void unsubscribe() {
		((StringSubscription) this.subscription).removeSubscriber(this);
		this.subscription = null;
		
	}

}
