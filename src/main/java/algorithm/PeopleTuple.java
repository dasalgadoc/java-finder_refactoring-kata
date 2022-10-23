package algorithm;

public class PeopleTuple {
    private Person youngest;
    private Person oldest;
    private long birthDateDifferenceInMilliseconds;

    public Person getYoungest() {
        return youngest;
    }

    public void setYoungest(Person youngest) {
        this.youngest = youngest;
    }

    public Person getOldest() {
        return oldest;
    }

    public void setOldest(Person oldest) {
        this.oldest = oldest;
    }

    public long getBirthDateDifferenceInMilliseconds() {
        return birthDateDifferenceInMilliseconds;
    }

    public void setBirthDateDifferenceInMilliseconds(long birthDateDifferenceInMilliseconds) {
        this.birthDateDifferenceInMilliseconds = birthDateDifferenceInMilliseconds;
    }
}
