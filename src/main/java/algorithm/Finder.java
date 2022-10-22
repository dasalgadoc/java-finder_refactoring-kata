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
                    personTuple.personOne = people.get(i);
                    personTuple.personTwo = people.get(j);
                } else {
                    personTuple.personOne = people.get(j);
                    personTuple.personTwo = people.get(i);
                }
                personTuple.birthDateDifferenceInMilliseconds = personTuple.personTwo.birthDate.getTime() - personTuple.personOne.birthDate.getTime();
                peopleTuplesRows.add(personTuple);
            }
        }

        if (peopleTuplesRows.size() < 1) {
            return new PeopleTuple();
        }

        PeopleTuple answer = peopleTuplesRows.get(0);
        for (PeopleTuple peopleTuple : peopleTuplesRows) {
            switch (ageDifferenceCriteria) {
                case Lowest:
                    if (peopleTuple.birthDateDifferenceInMilliseconds < answer.birthDateDifferenceInMilliseconds) {
                        answer = peopleTuple;
                    }
                    break;

                case Highest:
                    if (peopleTuple.birthDateDifferenceInMilliseconds > answer.birthDateDifferenceInMilliseconds) {
                        answer = peopleTuple;
                    }
                    break;
            }
        }

        return answer;
    }
}
