import java.util.HashMap;

public class StockExchangeSeat implements StockExchange {

    private String name;

    // private String location;

    private HashMap<Stock, Integer> dailyPrice = new HashMap<Stock, Integer>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getDailyPrice(Stock stock) {
        return dailyPrice.get(stock);
    }

    public void setDailyPrice(Stock stock, Integer integer) {
        this.dailyPrice.put(stock, integer);
    }
}
