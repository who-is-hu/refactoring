package me.whiteship.refactoring._11_primitive_obsession._32_replace_conditional_with_polymorphism.variation;

import java.util.List;

public class ChinaVoyageRating extends VoyageRating {
    public ChinaVoyageRating(Voyage voyage, List<VoyageHistory> history) {
        super(voyage, history);
    }

    @Override
    protected int captainHistoryRisk() {
        return Math.max(0, super.captainHistoryRisk() - 2);
    }

    @Override
    protected int voyageProfitFactor() {
        return super.voyageProfitFactor() + 3;
    }

    @Override
    protected int historyFactor() {
        return (this.history.size() > 10) ? 1 : 0;
    }

    @Override
    protected int voyageLengthFactor() {
        int result = 0;
        if (this.voyage.length() > 12) result += 1;
        if (this.voyage.length() > 18) result -= 1;
        return result;
    }
}
