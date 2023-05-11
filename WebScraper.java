import javax.swing.*;
import java.awt.*;


public class WebScraper {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Best Performing Stocks In May 2023");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 500);
        
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        JButton scrapeButton = new JButton("Scrape");
        scrapeButton.addActionListener(e -> {
            StockScraper scraper = new BestPerformingStockScraper(textArea);
            scraper.scrape();
        });
        panel.add(scrapeButton, BorderLayout.SOUTH);
        
        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }
}
