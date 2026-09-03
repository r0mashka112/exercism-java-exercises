
class BirdWatcher {
    private final int[] birdsPerDay;

    public BirdWatcher(int[] birdsPerDay) {
        this.birdsPerDay = birdsPerDay.clone();
    }

    public static int[] getLastWeek() {
        return new int[] {0, 2, 5, 3, 7, 8, 4};
    }

    public int getValueByDay(int index) {
        return this.birdsPerDay[index];
    }

    public void setValueByDay(int index, int value) {
        this.birdsPerDay[index] = value;
    }

    public int getToday() {
        return this.getValueByDay(this.birdsPerDay.length - 1);
    }

    public void incrementTodaysCount() {
        this.setValueByDay(this.birdsPerDay.length - 1, this.getToday() + 1);
    }

    public boolean hasDayWithoutBirds() {
        for (int value : this.birdsPerDay) {
            if (value == 0) {
                return true;
            }
        }

        return false;
    }

    public int getCountForFirstDays(int numberOfDays) {
        int birdCountForPeriod = 0;

        for (int index = 0; index < Math.min(numberOfDays, 7); index++) {
            birdCountForPeriod += this.getValueByDay(index);
        }

        return birdCountForPeriod;
    }

    public int getBusyDays() {
        int numberOfBusyDays = 0;

        for (int value : this.birdsPerDay) {
            numberOfBusyDays += value >= 5 ? 1 : 0;
        }

        return numberOfBusyDays;
    }
}
