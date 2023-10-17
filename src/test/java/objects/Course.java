package objects;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Simplifying class code with loombok annotations
@Getter
@Setter
@NoArgsConstructor
public class Course {
    private String name;
    private String[] sidebarOptions;

    private String mainContent;

    private boolean started;

    private Course[] listOfCourses;
}
