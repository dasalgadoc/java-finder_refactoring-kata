package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import algorithm.PeopleTupleByAgeCriteriaFinder;
import org.junit.Test;

import algorithm.PeopleTuple;
import algorithm.AgeDifferenceCriteria;
import algorithm.Person;

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

        assertEquals(sue, peopleTuple.get().youngest);
        assertEquals(greg, peopleTuple.get().oldest);
    }

    @Test
    public void Returns_Furthest_Two_For_Two_People() {
        List<Person> list = new ArrayList<Person>();
        list.add(mike);
        list.add(greg);

        PeopleTupleByAgeCriteriaFinder peopleTupleByAgeCriteriaFinder = new PeopleTupleByAgeCriteriaFinder(list);

        Optional<PeopleTuple> peopleTuple = peopleTupleByAgeCriteriaFinder.find(AgeDifferenceCriteria.Highest);

        assertEquals(greg, peopleTuple.get().youngest);
        assertEquals(mike, peopleTuple.get().oldest);
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

        assertEquals(sue, peopleTuple.get().youngest);
        assertEquals(sarah, peopleTuple.get().oldest);
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

        assertEquals(sue, peopleTuple.get().youngest);
        assertEquals(greg, peopleTuple.get().oldest);
    }

}
