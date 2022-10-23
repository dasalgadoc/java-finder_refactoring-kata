package com.dsalgado.persons.application;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.dsalgado.persons.domain.AgeDifferenceCriteria;
import org.junit.Test;

import com.dsalgado.persons.domain.PeopleTuple;
import com.dsalgado.persons.domain.Person;

public class PeopleTupleByAgeCriteriaFinderTests {

    Person sue =    new Person("Sue", new Date(50, 0, 1));
    Person greg =   new Person("Greg", new Date(52, 5, 1));
    Person sarah =  new Person("Sarah", new Date(82, 0, 1));
    Person mike =   new Person("Mike", new Date(79, 0, 1));

    @Test
    public void Returns_Empty_Tuple_When_Given_Empty_List() {
        List<Person> list = new ArrayList<Person>();
        PeopleTupleByAgeCriteriaFinder peopleTupleByAgeCriteriaFinder = new PeopleTupleByAgeCriteriaFinder(list);

        Optional<PeopleTuple> peopleTuple = peopleTupleByAgeCriteriaFinder.find(AgeDifferenceCriteria.Lowest);

        assertEquals(Optional.empty(), peopleTuple);
    }

    @Test
    public void Returns_Empty_Tuple_When_Given_One_Person() {
        List<Person> list = new ArrayList<Person>();
        list.add(sue);

        PeopleTupleByAgeCriteriaFinder peopleTupleByAgeCriteriaFinder = new PeopleTupleByAgeCriteriaFinder(list);

        Optional<PeopleTuple> peopleTuple = peopleTupleByAgeCriteriaFinder.find(AgeDifferenceCriteria.Lowest);

        assertEquals(Optional.empty(), peopleTuple);
    }

    @Test
    public void Returns_Closest_Two_For_Two_People() {
        List<Person> list = new ArrayList<Person>();
        list.add(sue);
        list.add(greg);
        PeopleTupleByAgeCriteriaFinder peopleTupleByAgeCriteriaFinder = new PeopleTupleByAgeCriteriaFinder(list);

        Optional<PeopleTuple> peopleTuple = peopleTupleByAgeCriteriaFinder.find(AgeDifferenceCriteria.Lowest);

        assertEquals(sue, peopleTuple.get().getYoungest());
        assertEquals(greg, peopleTuple.get().getOldest());
    }

    @Test
    public void Returns_Furthest_Two_For_Two_People() {
        List<Person> list = new ArrayList<Person>();
        list.add(mike);
        list.add(greg);

        PeopleTupleByAgeCriteriaFinder peopleTupleByAgeCriteriaFinder = new PeopleTupleByAgeCriteriaFinder(list);

        Optional<PeopleTuple> peopleTuple = peopleTupleByAgeCriteriaFinder.find(AgeDifferenceCriteria.Highest);

        assertEquals(greg, peopleTuple.get().getYoungest());
        assertEquals(mike, peopleTuple.get().getOldest());
    }

    @Test
    public void Returns_Furthest_Two_For_Four_People() {
        List<Person> list = new ArrayList<Person>();
        list.add(sue);
        list.add(sarah);
        list.add(mike);
        list.add(greg);
        PeopleTupleByAgeCriteriaFinder peopleTupleByAgeCriteriaFinder = new PeopleTupleByAgeCriteriaFinder(list);

        Optional<PeopleTuple> peopleTuple = peopleTupleByAgeCriteriaFinder.find(AgeDifferenceCriteria.Highest);

        assertEquals(sue, peopleTuple.get().getYoungest());
        assertEquals(sarah, peopleTuple.get().getOldest());
    }

    @Test
    public void Returns_Furthest_Two_For_Four_People_Highest() {
        List<Person> list = new ArrayList<Person>();
        list.add(sue);
        list.add(mike);
        list.add(greg);
        list.add(sarah);
        PeopleTupleByAgeCriteriaFinder peopleTupleByAgeCriteriaFinder = new PeopleTupleByAgeCriteriaFinder(list);

        Optional<PeopleTuple> peopleTuple = peopleTupleByAgeCriteriaFinder.find(AgeDifferenceCriteria.Highest);

        assertEquals(sue, peopleTuple.get().getYoungest());
        assertEquals(sarah, peopleTuple.get().getOldest());
    }

    @Test
    public void Returns_Closest_Two_For_Four_People() {
        List<Person> list = new ArrayList<Person>();
        list.add(sue);
        list.add(sarah);
        list.add(mike);
        list.add(greg);

        PeopleTupleByAgeCriteriaFinder peopleTupleByAgeCriteriaFinder = new PeopleTupleByAgeCriteriaFinder(list);

        Optional<PeopleTuple> peopleTuple = peopleTupleByAgeCriteriaFinder.find(AgeDifferenceCriteria.Lowest);

        assertEquals(sue, peopleTuple.get().getYoungest());
        assertEquals(greg, peopleTuple.get().getOldest());
    }

}
