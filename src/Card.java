public enum Card {
    STANDARD("standard"),
    GOLD("gold"),
    VIP("v.i.p.");

    private final String cardType;

    Card(String cardType) {
        this.cardType = cardType;
    }

    public String getCardType() {
        return cardType;
    }
}
