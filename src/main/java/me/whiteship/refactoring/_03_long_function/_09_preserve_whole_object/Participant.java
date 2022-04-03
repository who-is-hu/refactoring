package me.whiteship.refactoring._03_long_function._09_preserve_whole_object;

import java.util.HashMap;
import java.util.Map;

public record Participant(String username, Map<Integer, Boolean> homework) {
    public Participant(String username) {
        this(username, new HashMap<>());
    }

    public void setHomeworkDone(int index) {
        this.homework.put(index, true);
    }

    // 함수의 위치가 StudyDashboard가 아니라 판단하여 옮기기
    public double getRate(int totalNumberOfEvents) {
        long count = homework().values().stream()
                .filter(v -> v == true)
                .count();
        return (double) (count * 100 / totalNumberOfEvents);
    }

    /**
     * |:white_check_mark:|:white_check_mark:|:white_check_mark:|:x:|
     * @param totalNumberOfEvents
     */
    String checkMark(int totalNumberOfEvents) {
        StringBuilder line = new StringBuilder();
        for (int i = 1; i <= totalNumberOfEvents ; i++) {
            if(homework().containsKey(i) && homework().get(i)) {
                line.append("|:white_check_mark:");
            } else {
                line.append("|:x:");
            }
        }
        return line.toString();
    }
}
