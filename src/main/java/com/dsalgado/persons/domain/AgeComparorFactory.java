package com.dsalgado.persons.domain;

public class AgeComparorFactory {

    public AgeComparorByCriteria getAgeComparor(AgeDifferenceCriteria ageDifferenceCriteria){
        if (AgeDifferenceCriteria.Highest.equals(ageDifferenceCriteria)){
            return new HighestAgeComparor();
        }
        return new LowestAgeComparor();
    }
}
