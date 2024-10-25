import java.util.HashMap;

public interface StockExchange {

    public int getDailyPrice(Stock stock);
    public void setDailyPrice(Stock stock, Integer integer) ;
}
