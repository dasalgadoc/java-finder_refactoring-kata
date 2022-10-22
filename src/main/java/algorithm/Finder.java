package algorithm;

import java.util.ArrayList;
import java.util.List;

public class Finder {
    private final List<Person> people;

    public Finder(List<Person> people) {
        this.people = people;
    }

    public PeopleTuple Find(AgeDifferenceCriteria ageDifferenceCriteria) {
        List<PeopleTuple> peopleTuplesRows = new ArrayList<PeopleTuple>();

        for (int i = 0; i < people.size() - 1; i++) {
            for (int j = i + 1; j < people.size(); j++) {
                PeopleTuple personTuple = new PeopleTuple();
                if (people.get(i).birthDate.getTime() < people.get(j).birthDate.getTime()) {
                    personTuple.P1 = people.get(i);
                    personTuple.P2 = people.get(j);
                } else {
                    personTuple.P1 = people.get(j);
                    personTuple.P2 = people.get(i);
                }
                personTuple.D = personTuple.P2.birthDate.getTime() - personTuple.P1.birthDate.getTime();
                peopleTuplesRows.add(personTuple);
            }
        }

        if (peopleTuplesRows.size() < 1) {
            return new PeopleTuple();
        }

        PeopleTuple answer = peopleTuplesRows.get(0);
        for (PeopleTuple peopleTuple : peopleTuplesRows) {
            switch (ageDifferenceCriteria) {
                case One:
                    if (peopleTuple.D < answer.D) {
                        answer = peopleTuple;
                    }
                    break;

                case Two:
                    if (peopleTuple.D > answer.D) {
                        answer = peopleTuple;
                    }
                    break;
            }
        }

        return answer;
    }
}
