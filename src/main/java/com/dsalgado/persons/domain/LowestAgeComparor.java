package com.dsalgado.persons.domain;

public class LowestAgeComparor implements AgeComparorByCriteria{
    @Override
    public PeopleTuple resolveAgeDifference(PeopleTuple actualCandidate, PeopleTuple previousCandidate) {
        if(actualCandidate.getBirthDateDifferenceInMilliseconds() < previousCandidate.getBirthDateDifferenceInMilliseconds()){
            return actualCandidate;
        }
        return previousCandidate;
    }

}
