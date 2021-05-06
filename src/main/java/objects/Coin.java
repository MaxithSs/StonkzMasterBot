package objects;

/**
 * Coin Class.
 */
public class Coin {

    /**
     * Holds coins coinName.
     */
    private final String coinName;

    /**
     * Holds coins coinPrice.
     */
    private double coinPrice;

    /**
     * Holds amount of coins.
     */
    private final double coinAmount;

    /**
     * Constructor.
     * @param coinName coinName
     * @param coinPrice coinPrice
     * @param coinAmount coinAmount
     */
    public Coin(final String coinName, final double coinPrice, final double coinAmount) {
        this.coinName = coinName;
        this.coinPrice = coinPrice;
        this.coinAmount = coinAmount;
    }

    /**
     * Gets coins name.
     * @return coinName
     */
    public String getCoinName() {
        return coinName;
    }

    /**
     * Gets coins price.
     * @return coinPrice
     */
    public double getCoinPrice() {
        return coinPrice;
    }

    /**
     * Sets coins price.
     * @param coinPrice coinPrice
     */
    public void setCoinPrice(final double coinPrice) {
        this.coinPrice = coinPrice;
    }

    /**
     * Gets amount of coins.
     * @return coinAmount
     */
    public double getCoinAmount() {
        return coinAmount;
    }

    @Override
    public String toString() {
        return "Coin{" +
                "coinName='" + coinName + '\'' +
                ", coinPrice=" + coinPrice +
                ", coinAmount=" + coinAmount +
                '}';
    }
}
