package com.dsalgado.persons.domain;

public interface AgeComparorByCriteria {
    PeopleTuple resolveAgeDifference(PeopleTuple actualCandidate, PeopleTuple previousCandidate);

}
