class RangeCriterion {
    private long maxValue = Long.MAX_VALUE;
    private long minValue = Long.MIN_VALUE;

    // Add a new Criterion for an insurance plan
    void addCriterion(Tag tag) {
        if (tag.getRelation() == Tag.Relation.LARGER) {
            minValue = Math.max(minValue, Long.parseLong(tag.getValue()));
        }
        if (tag.getRelation() == Tag.Relation.SMALLER) {
            maxValue = Math.min(maxValue, Long.parseLong(tag.getValue()));
        }
    }

    // Function to determine if the desired value is in range based on the criterion
    boolean isInRange(long value) {
        if (value < maxValue && value > minValue) {
            return true;
        }
        return false;
    }
}
