import javax.swing.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

class BestPerformingStockScraper implements StockScraper {
    private JTextArea textArea;
    
    BestPerformingStockScraper(JTextArea textArea) {
        this.textArea = textArea;
    }
    
    public void scrape() {
        String url = "https://www.bankrate.com/investing/best-performing-stocks/";

        try {
            Document doc = Jsoup.connect(url).get();
            Element bestStockTable = doc.select("table").first();
            Elements tableRows = bestStockTable.select("tbody tr");

            tableRows.forEach(row -> {
                String companyName = row.select("td:nth-child(1)").text();
                String percentChange = row.select("td:nth-child(2)").text();

                textArea.append(companyName + " " + percentChange + "\n");
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
