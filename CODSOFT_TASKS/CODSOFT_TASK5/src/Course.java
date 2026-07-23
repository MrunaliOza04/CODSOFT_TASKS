public class Course {

    private final String courseCode;
    private final String title;
    private final String description;
    private final int capacity;
    private final String schedule;
    private int registeredCount;

    public Course(String courseCode, String title, String description, int capacity, String schedule) {
        this.courseCode = courseCode;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
        this.registeredCount = 0;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getSchedule() {
        return schedule;
    }

    public int getRegisteredCount() {
        return registeredCount;
    }

    public int getAvailableSeats() {
        return capacity - registeredCount;
    }

    public boolean hasAvailableSeat() {
        return getAvailableSeats() > 0;
    }

    public boolean reserveSeat() {
        if (hasAvailableSeat()) {
            registeredCount++;
            return true;
        }
        return false;
    }

    public void releaseSeat() {
        if (registeredCount > 0) {
            registeredCount--;
        }
    }

    public String getFullDetails() {
        StringBuilder sb = new StringBuilder();
        sb.append("Course Code   : ").append(courseCode).append("\n");
        sb.append("Title         : ").append(title).append("\n");
        sb.append("Description   : ").append(description).append("\n");
        sb.append("Schedule      : ").append(schedule).append("\n");
        sb.append("Capacity      : ").append(capacity).append("\n");
        sb.append("Available Seats: ").append(getAvailableSeats());
        return sb.toString();
    }

    @Override
    public String toString() {
        return courseCode + " - " + title + " (Seats available: " + getAvailableSeats() + "/" + capacity + ")";
    }
}
