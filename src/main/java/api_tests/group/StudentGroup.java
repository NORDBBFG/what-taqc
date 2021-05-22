package api_tests.group;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentGroup {
    private long id;
    private String name;
    private int courseId;
    private String startDate;
    private String finishDate;
    private List<Integer> studentIds;
    private List<Integer> mentorIds;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentGroup that = (StudentGroup) o;
        return courseId == that.courseId &&
                Objects.equals(name, that.name) &&
                Objects.equals(startDate, that.startDate) &&
                Objects.equals(finishDate, that.finishDate) &&
                studentIds.containsAll(that.studentIds) &&
                that.studentIds.containsAll(studentIds) &&
                mentorIds.containsAll(that.mentorIds) &&
                that.mentorIds.containsAll(mentorIds);
    }

}
