
public class Test {

    private int maxPoints;
    private int points = 0;

    public Test(int testPoints, int testMaxPoints) {
        points = testPoints;
        maxPoints = testMaxPoints;
    }

    public int getMaxPoints() {
        return maxPoints;
    }

    public void setMaxPoints(int maxPoints) {
        this.maxPoints = maxPoints;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public float calculateGrade() {
        return (((float) points / maxPoints * 5) + 1);
    }
}