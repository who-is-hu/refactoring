package me.whiteship.refactoring._02_duplicated_code._04_extract_function;

import org.kohsuke.github.GHIssue;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class StudyDashboard {

    // 주석이 사라지고 세줄로 읽히는 마법
    // 서비스 로직의 코드는 이런 모양을 가지고 구현은 도메인 객체로 숨겨야 한다고 나는 생각한다.
    private void printParticipants(int eventId) throws IOException {
        GHIssue issue = getGitHubIssue(eventId);
        Set<String> participants = getParticipants(issue);
        print(participants);
    }

    private void print(Set<String> participants) {
        participants.forEach(System.out::println);
    }

    private Set<String> getParticipants(GHIssue issue) throws IOException {
        Set<String> participants = new HashSet<>();
        issue.getComments().forEach(c -> participants.add(c.getUserName()));
        return participants;
    }

    private GHIssue getGitHubIssue(int eventId) throws IOException {
        GitHub gitHub = GitHub.connect();
        GHRepository repository = gitHub.getRepository("whiteship/live-study");
        GHIssue issue = repository.getIssue(eventId);
        return issue;
    }

    private void printReviewers() throws IOException {
        GHIssue issue = getGitHubIssue(30);
        Set<String> reviewers = getParticipants(issue);
        print(reviewers);
    }

    public static void main(String[] args) throws IOException {
        StudyDashboard studyDashboard = new StudyDashboard();
        studyDashboard.printReviewers();
        studyDashboard.printParticipants(15);
    }

}
