package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import algorithm.PeopleTupleByAgeCriteriaFinder;
import org.junit.Before;
import org.junit.Test;

import algorithm.PeopleTuple;
import algorithm.AgeDifferenceCriteria;
import algorithm.Person;

public class PeopleTupleByAgeCriteriaFinderTests {

    Person sue = Person.create("Sue", new Date(50, 0, 1));
    Person greg = Person.create("Greg", new Date(52, 5, 1));
    Person sarah = Person.create("Sarah", new Date(82, 0, 1));
    Person mike = Person.create("Mike", new Date(79, 0, 1));

    @Test
    public void Returns_Empty_Results_When_Given_Empty_List() {
        List<Person> list = new ArrayList<Person>();
        PeopleTupleByAgeCriteriaFinder peopleTupleByAgeCriteriaFinder = new PeopleTupleByAgeCriteriaFinder(list);

        PeopleTuple result = peopleTupleByAgeCriteriaFinder.Find(AgeDifferenceCriteria.Lowest);
        assertEquals(null, result.youngest);

        assertEquals(null, result.oldest);
    }

    @Test
    public void Returns_Empty_Results_When_Given_One_Person() {
        List<Person> list = new ArrayList<Person>();
        list.add(sue);

        PeopleTupleByAgeCriteriaFinder peopleTupleByAgeCriteriaFinder = new PeopleTupleByAgeCriteriaFinder(list);

        PeopleTuple result = peopleTupleByAgeCriteriaFinder.Find(AgeDifferenceCriteria.Lowest);

        assertEquals(null, result.youngest);
        assertEquals(null, result.oldest);
    }

    @Test
    public void Returns_Closest_Two_For_Two_People() {
        List<Person> list = new ArrayList<Person>();
        list.add(sue);
        list.add(greg);
        PeopleTupleByAgeCriteriaFinder peopleTupleByAgeCriteriaFinder = new PeopleTupleByAgeCriteriaFinder(list);

        PeopleTuple result = peopleTupleByAgeCriteriaFinder.Find(AgeDifferenceCriteria.Lowest);

        assertEquals(sue, result.youngest);
        assertEquals(greg, result.oldest);
    }

    @Test
    public void Returns_Furthest_Two_For_Two_People() {
        List<Person> list = new ArrayList<Person>();
        list.add(mike);
        list.add(greg);

        PeopleTupleByAgeCriteriaFinder peopleTupleByAgeCriteriaFinder = new PeopleTupleByAgeCriteriaFinder(list);

        PeopleTuple result = peopleTupleByAgeCriteriaFinder.Find(AgeDifferenceCriteria.Highest);

        assertEquals(greg, result.youngest);
        assertEquals(mike, result.oldest);
    }

    @Test
    public void Returns_Furthest_Two_For_Four_People() {
        List<Person> list = new ArrayList<Person>();
        list.add(sue);
        list.add(sarah);
        list.add(mike);
        list.add(greg);
        PeopleTupleByAgeCriteriaFinder peopleTupleByAgeCriteriaFinder = new PeopleTupleByAgeCriteriaFinder(list);

        PeopleTuple result = peopleTupleByAgeCriteriaFinder.Find(AgeDifferenceCriteria.Highest);

        assertEquals(sue, result.youngest);
        assertEquals(sarah, result.oldest);
    }

    @Test
    public void Returns_Closest_Two_For_Four_People() {
        List<Person> list = new ArrayList<Person>();
        list.add(sue);
        list.add(sarah);
        list.add(mike);
        list.add(greg);

        PeopleTupleByAgeCriteriaFinder peopleTupleByAgeCriteriaFinder = new PeopleTupleByAgeCriteriaFinder(list);

        PeopleTuple result = peopleTupleByAgeCriteriaFinder.Find(AgeDifferenceCriteria.Lowest);

        assertEquals(sue, result.youngest);
        assertEquals(greg, result.oldest);
    }

}
