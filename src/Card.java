public enum Card {
    STANDARD("standard"),
    GOLD("gold"),
    VIP("VIP");

    private final String cardType;

    Card(String cardType) {
        this.cardType = cardType;
    }

    public String getCardType() {
        return cardType;
    }
}
