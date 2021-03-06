import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Parser class, contains all parser methods.
 */
public class HtmlParser {

    /**
     * Gets coin price from raw HTML.
     * @param link the site to get price from
     * @param coinToParse coin to search for
     * @return price
     * @throws IOException exception
     */
    public double getCoinPriceFromRawHtml(final String link, final String coinToParse) throws IOException {
        Document document = Jsoup.connect(link + coinToParse).get();
        Elements valueCSSClass = document.select(".price-large");

        String html = valueCSSClass.html();

        Pattern pattern = Pattern.compile("(\\d+\\.\\d+)");
        Matcher matcher = pattern.matcher(html);
        double price = 0;

        while (matcher.find()) {
            price = Double.parseDouble(matcher.group(1));
        }
        return price;
    }
}

