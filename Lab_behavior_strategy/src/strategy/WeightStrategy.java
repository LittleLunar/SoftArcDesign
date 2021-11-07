package strategy;

import java.util.Comparator;
import java.util.List;

public class WeightStrategy implements SortStrategy {
    // YOU MAY ADD UP TO 5 LINES OF CODE BELOW THIS COMMENT !! A LINE OF CODE MAY CONTAIN UP TO ONE SEMI-COLON !!
	@Override
	public void customSort(List<Person> people) {
		Comparator<Person> personComparator = new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				return o1.getWeight().compareTo(o2.getWeight());
			}
			
		};
		people.sort(personComparator);
	}
}
