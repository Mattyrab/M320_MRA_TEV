public class Main {

    public static void main(String[] args) {

        Portfolio portfolio = new Portfolio();
        Stock microsoft_stock = new Stock();

        StockExchangeSeat newYork = new StockExchangeSeat();
        StockExchangeSeat zurich = new StockExchangeSeat();

        microsoft_stock.setStockCount(7);

        newYork.setDailyPrice(microsoft_stock, 100);
        zurich.setDailyPrice(microsoft_stock, 120);

        portfolio.addStock(microsoft_stock);

        System.out.println(portfolio.getDailyPrice(microsoft_stock, newYork));
        System.out.println(portfolio.getDailyPrice(microsoft_stock, zurich));

    }

}
