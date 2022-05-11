package me.whiteship.refactoring._11_primitive_obsession._32_replace_conditional_with_polymorphism.variation;

import java.util.List;

public class VoyageRatingFactory {

    public static VoyageRating createVoyageRating(Voyage voyage, List<VoyageHistory> voyageHistoryList) {
        if (voyage.zone().equals("china") && hasChinaHistory(voyageHistoryList)) {
            return new ChinaVoyageRating(voyage, voyageHistoryList);
        } else {
            return new VoyageRating(voyage, voyageHistoryList);
        }
    }

    private static boolean hasChinaHistory(List<VoyageHistory> history) {
        return history.stream().anyMatch(v -> v.zone().equals("china"));
    }
}
