package me.whiteship.refactoring._18_middle_man._40_replace_subclass_with_delegate;

public class PremiumBookingDelegate {
    private Booking booking;
    private PremiumExtra extra;

    public PremiumBookingDelegate(Booking booking, PremiumExtra extra) {
        this.booking = booking;
        this.extra = extra;
    }

    public boolean hasTalkback() {
        return this.booking.show.hasOwnProperty("talkback");
    }
    public double extraPrice(final double basePrice) {
        return Math.round(basePrice + this.extra.getPremiumFee());
    }

    public boolean hasDinner() {
        return this.extra.hasOwnProperty("dinner") && !booking.isPeakDay();
    }
}
