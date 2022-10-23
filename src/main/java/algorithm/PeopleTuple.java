package algorithm;

public class PeopleTuple {
    private Person youngest;
    private Person oldest;
    private Long birthDateDifferenceInMilliseconds;

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

    public Long getBirthDateDifferenceInMilliseconds() {
        return birthDateDifferenceInMilliseconds;
    }

    public void setBirthDateDifferenceInMilliseconds() {
        this.birthDateDifferenceInMilliseconds = oldest.getBirthDate().getTime() - youngest.getBirthDate().getTime();
    }
}
