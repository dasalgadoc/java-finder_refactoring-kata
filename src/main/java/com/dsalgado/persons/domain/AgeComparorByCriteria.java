package com.dsalgado.persons.domain;

import java.util.List;

public interface AgeComparorByCriteria {
  PeopleTuple getRequestedPeopleTuple(List<PeopleTuple> peopleTuples);
}
