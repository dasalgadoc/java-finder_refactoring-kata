package com.dsalgado.persons.domain;

import java.util.List;

public class LowestAgeComparor implements AgeComparorByCriteria {
  @Override
  public PeopleTuple getRequestedPeopleTuple(List<PeopleTuple> peopleTuples) {
    return peopleTuples.stream()
        .min(
            (firstPerson, secondPerson) ->
                firstPerson
                    .getBirthDateDifferenceInMilliseconds()
                    .compareTo(secondPerson.getBirthDateDifferenceInMilliseconds()))
        .get();
  }
}
