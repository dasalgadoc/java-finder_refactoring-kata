package algorithm;

import java.util.ArrayList;
import java.util.List;

public class Finder {
    private final List<Person> people;

    public Finder(List<Person> people) {
        this.people = people;
    }

    public PeopleTuple Find(AgeDifferenceCriteria ageDifferenceCriteria) {
        List<PeopleTuple> peopleTuplesCombinations = new ArrayList<PeopleTuple>();

        for (int i = 0; i < people.size() - 1; i++) {
            for (int j = i + 1; j < people.size(); j++) {
                PeopleTuple personTuple = new PeopleTuple();
                if (people.get(i).birthDate.getTime() < people.get(j).birthDate.getTime()) {
                    personTuple.youngest = people.get(i);
                    personTuple.oldest = people.get(j);
                } else {
                    personTuple.youngest = people.get(j);
                    personTuple.oldest = people.get(i);
                }
                personTuple.birthDateDifferenceInMilliseconds = personTuple.oldest.birthDate.getTime() - personTuple.youngest.birthDate.getTime();
                peopleTuplesCombinations.add(personTuple);
            }
        }

        if (peopleTuplesCombinations.size() < 1) {
            return new PeopleTuple();
        }

        PeopleTuple answer = peopleTuplesCombinations.get(0);
        for (PeopleTuple peopleTuple : peopleTuplesCombinations) {
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
