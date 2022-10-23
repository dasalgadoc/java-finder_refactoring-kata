package com.dsalgado.persons.application;

import com.dsalgado.persons.domain.AgeComparorByCriteria;
import com.dsalgado.persons.domain.AgeComparorFactory;
import com.dsalgado.persons.domain.AgeDifferenceCriteria;
import com.dsalgado.persons.domain.PeopleTuple;
import com.dsalgado.persons.domain.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PeopleTupleByAgeCriteriaFinder {
    private final List<Person> people;
    private final AgeComparorFactory ageComparorFactory;

    public PeopleTupleByAgeCriteriaFinder(List<Person> people, AgeComparorFactory ageComparorFactory) {
        this.people = people;
        this.ageComparorFactory = ageComparorFactory;
    }

    public Optional<PeopleTuple> find(AgeDifferenceCriteria ageDifferenceCriteria) {
        List<PeopleTuple> peopleTuplesCombinations = generatePeopleTupleCombinations();

        if (peopleTuplesCombinations.size() < 1) {
            return Optional.empty();
        }

        return Optional.of(getRequestedPeopleTupleByAgeCriteria(ageDifferenceCriteria, peopleTuplesCombinations));
    }

    private List<PeopleTuple> generatePeopleTupleCombinations() {
        List<PeopleTuple> peopleTuplesCombinations = new ArrayList<PeopleTuple>();

        for (int i = 0; i < people.size() - 1; i++) {
            for (int j = i + 1; j < people.size(); j++) {
                Person youngest;
                Person oldest;
                if (people.get(i).getBirthDateInMilliseconds() < people.get(j).getBirthDateInMilliseconds()) {
                    youngest = people.get(i);
                    oldest = people.get(j);
                } else {
                    youngest = people.get(j);
                    oldest = people.get(i);
                }
                PeopleTuple peopleTuple = new PeopleTuple(youngest, oldest);
                peopleTuplesCombinations.add(peopleTuple);
            }
        }
        return peopleTuplesCombinations;
    }

    private PeopleTuple getRequestedPeopleTupleByAgeCriteria(AgeDifferenceCriteria ageDifferenceCriteria, List<PeopleTuple> peopleTuplesCombinations) {
        AgeComparorByCriteria ageComparorByCriteria = ageComparorFactory.getAgeComparor(ageDifferenceCriteria);
        return ageComparorByCriteria.getRequestedPeopleTuple(peopleTuplesCombinations);
    }

}
