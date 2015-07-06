package my.pattern.observable;
import java.util.Observable;


public class ShanghaiNews extends Observable {
	
	private String news;
	
	public String getNews() {
		return news;
	}

	public void setNews(String news) {
		this.news = news;
	}

	public ShanghaiNews(String news) {
		this.news = news;
	}
	
	public void updateNews(String news) {
		setNews(news);
		setChanged();
		notifyObservers();
	}
}
