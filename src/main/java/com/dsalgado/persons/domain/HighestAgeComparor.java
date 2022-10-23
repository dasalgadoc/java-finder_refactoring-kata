package com.dsalgado.persons.domain;

import java.util.List;

public class HighestAgeComparor implements AgeComparorByCriteria{
    @Override
    public PeopleTuple getRequestedPeopleTuple(List<PeopleTuple> peopleTuples) {
        return peopleTuples.stream().max((firstPerson,secondPerson) -> firstPerson.getBirthDateDifferenceInMilliseconds().compareTo(secondPerson.getBirthDateDifferenceInMilliseconds())).get();
    }

}
