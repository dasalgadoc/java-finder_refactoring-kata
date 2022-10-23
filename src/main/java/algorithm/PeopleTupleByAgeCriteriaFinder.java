package algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PeopleTupleByAgeCriteriaFinder {
    private final List<Person> people;

    public PeopleTupleByAgeCriteriaFinder(List<Person> people) {
        this.people = people;
    }

    public Optional<PeopleTuple> find(AgeDifferenceCriteria ageDifferenceCriteria) {
        List<PeopleTuple> peopleTuplesCombinations = new ArrayList<PeopleTuple>();

        for (int i = 0; i < people.size() - 1; i++) {
            for (int j = i + 1; j < people.size(); j++) {
                PeopleTuple personTuple = new PeopleTuple();
                if (people.get(i).getBirthDate().getTime() < people.get(j).getBirthDate().getTime()) {
                    personTuple.youngest = people.get(i);
                    personTuple.oldest = people.get(j);
                } else {
                    personTuple.youngest = people.get(j);
                    personTuple.oldest = people.get(i);
                }
                personTuple.birthDateDifferenceInMilliseconds = personTuple.oldest.getBirthDate().getTime() - personTuple.youngest.getBirthDate().getTime();
                peopleTuplesCombinations.add(personTuple);
            }
        }

        if (peopleTuplesCombinations.size() < 1) {
            return Optional.empty();
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

        return Optional.of(answer);
    }
}
