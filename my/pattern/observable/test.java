package my.pattern.observable;

public class test {
   public static void main(String[] argu) {
	   ShanghaiNews shn = new ShanghaiNews("new open!");
	   NewsBuyerA nba = new NewsBuyerA();
	   NewsBuyerB nbb = new NewsBuyerB();
	   shn.addObserver(nba);
	   shn.addObserver(nbb);
	   shn.updateNews("heng da duo guan!");
	   shn.updateNews("guangzhou shijian!");
   }
}
