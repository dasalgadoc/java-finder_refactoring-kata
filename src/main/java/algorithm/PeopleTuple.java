package algorithm;

public class PeopleTuple {
    private Person youngest;
    private Person oldest;
    private Long birthDateDifferenceInMilliseconds;

    public PeopleTuple(Person youngest, Person oldest) {
        this.youngest = youngest;
        this.oldest = oldest;
        setBirthDateDifferenceInMilliseconds();
    }

    public Person getYoungest() {
        return youngest;
    }

    public Person getOldest() {
        return oldest;
    }

    public Long getBirthDateDifferenceInMilliseconds() {
        return birthDateDifferenceInMilliseconds;
    }

    public void setBirthDateDifferenceInMilliseconds() {
        this.birthDateDifferenceInMilliseconds = oldest.getBirthDateInMilliseconds() - youngest.getBirthDateInMilliseconds();
    }
}
