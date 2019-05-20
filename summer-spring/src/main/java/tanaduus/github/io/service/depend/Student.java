package tanaduus.github.io.service.depend;

public class Student {

    private Teacher teacher;

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void learn() {
        teacher.teach();
    }


}
