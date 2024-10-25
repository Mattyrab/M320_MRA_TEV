import java.util.ArrayList;

public class Portfolio {

    private ArrayList<Stock> stocks = new ArrayList<Stock>();

    StockExchange stockExchange;
    public int getDailyPrice(Stock stock, StockExchangeSeat stockExchangeSeat) {
        stockExchange = stockExchangeSeat;
        return stockExchange.getDailyPrice(stock);
    }

    public ArrayList<Stock> getStocks() {
        return stocks;
    }

    public void addStocks(ArrayList<Stock> stocks) {
        this.stocks.addAll(stocks);
    }

    public void addStock(Stock stock) {
        this.stocks.add(stock);
    }
}
