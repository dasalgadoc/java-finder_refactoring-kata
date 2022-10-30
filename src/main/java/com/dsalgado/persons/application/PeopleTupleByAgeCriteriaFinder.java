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
        if(people.size() <= 1){
            return Optional.empty();
        }

        List<PeopleTuple> peopleTuplesCombinations = generatePeopleTupleCombinations();
        return Optional.of(getRequestedPeopleTupleByAgeCriteria(ageDifferenceCriteria, peopleTuplesCombinations));
    }

    private List<PeopleTuple> generatePeopleTupleCombinations() {
        List<PeopleTuple> peopleTuplesCombinations = new ArrayList<PeopleTuple>();
        people.sort((firstPerson, secondPerson) -> firstPerson.getBirthDateInMilliseconds().compareTo(secondPerson.getBirthDateInMilliseconds()));
        for (int i = 0; i < people.size() - 1; i++) {
            for (int j = i + 1; j < people.size(); j++) {
                peopleTuplesCombinations.add(new PeopleTuple(people.get(i), people.get(j)));
            }
        }
        return peopleTuplesCombinations;
    }

    private PeopleTuple getRequestedPeopleTupleByAgeCriteria(AgeDifferenceCriteria ageDifferenceCriteria, List<PeopleTuple> peopleTuplesCombinations) {
        AgeComparorByCriteria ageComparorByCriteria = ageComparorFactory.getAgeComparor(ageDifferenceCriteria);
        return ageComparorByCriteria.getRequestedPeopleTuple(peopleTuplesCombinations);
    }

}
