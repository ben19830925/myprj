package my.pattern.observable;
import java.util.Observable;
import java.util.Observer;


public class NewsBuyerA implements Observer, NewsBuyer {

	public void update(Observable obs, Object arg1) {
		if(obs instanceof ShanghaiNews) {
			obs = (ShanghaiNews)obs;
			newsUpdate(((ShanghaiNews) obs).getNews());
		}
	}

	@Override
	public void newsUpdate(String news) {
		System.out.println("For Buyer A:" + news);
	}
}
