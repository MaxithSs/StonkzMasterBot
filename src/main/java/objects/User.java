package objects;

/**
 * User class.
 */
public class User {

    /**
     * Holds users Id.
     */
    private final long userId;

    /**
     * Holds users firstname.
     */
    private final String firstName;

    /**
     * Holds users lastname.
     */
    private final String lastName;

    /**
     * Holds users isBot status.
     */
    private final boolean isBot;

    /**
     * Holds users username.
     */
    private final String username;

    /**
     * Holds users language code.
     */
    private final String languageCode;

    /**
     * Holds coin objects.
     */
    private final Coin coin;

    /**
     * Constructor for user object.
     * @param userId userId
     * @param firstName firstName
     * @param lastName lastName
     * @param isBot isBot
     * @param username username
     * @param languageCode languageCode
     * @param coin coin
     */
    public User(
            final long userId,
            final String firstName,
            final String lastName,
            final boolean isBot,
            final String username,
            final String languageCode,
            final Coin coin) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isBot = isBot;
        this.username = username;
        this.languageCode = languageCode;
        this.coin = coin;
    }

    /**
     * Gets users Id.
     * @return userId
     */
    public long getUserId() {
        return userId;
    }

    /**
     * Gets users firstname.
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Gets users lastName.
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Gets users isBot status.
     * @return isBot
     */
    public boolean isBot() {
        return isBot;
    }

    /**
     * Gets users username.
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Gets users language code.
     * @return languageCode
     */
    public String getLanguageCode() {
        return languageCode;
    }

    /**
     * Gets users coin.
     * @return coin
     */
    public Coin getCoin() {
        return coin;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", isBot=" + isBot +
                ", username='" + username + '\'' +
                ", languageCode='" + languageCode + '\'' +
                ", coin=" + coin +
                '}';
    }
}
