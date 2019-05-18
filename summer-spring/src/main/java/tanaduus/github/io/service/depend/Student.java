package tanaduus.github.io.service.depend;

import tanaduus.github.io.aop.MyAnnotation;

public class Student {

    private Teacher teacher;

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void learn() {
        teacher.teach();
    }


}
