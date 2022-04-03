package me.whiteship.refactoring._03_long_function._11_decompose_conditional;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Participants implements Iterable<Participant>{

    private List<Participant> participants;

    @Override
    public Iterator<Participant> iterator() {
        return this.participants.iterator();
    }

    public Participants(List<Participant> participants) {
        this.participants = participants;
    }

    public Participant findParticipant(String username) {
        return isNewParticipant(username) ?
                createNewParticipant(username) :
                findExistingParticipant(username);
    }

    private Participant createNewParticipant(String username) {
        Participant participant = new Participant(username);
        participants.add(participant);
        return participant;
    }

    private Participant findExistingParticipant(String username) {
        return participants.stream().filter(p -> p.username().equals(username)).findFirst().orElseThrow();
    }

    private boolean isNewParticipant(String username) {
        return participants.stream().noneMatch(p -> p.username().equals(username));
    }

    public void sort(Comparator<Participant> comparing) {
        this.participants.sort(comparing);
    }

    public int size() {
        return this.participants.size();
    }
}
