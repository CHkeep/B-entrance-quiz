package com.thoughtworks.capability.gtb.entrancequiz.api;

import com.thoughtworks.capability.gtb.entrancequiz.domain.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

//TODO GTB-工程实践: - studentController，首字母大写！！！
//TODO GTB-工程实践: - 所有实现均写在了 controller 里
//TODO GTB-综合: * 整体实现很少，无法给出更多 comments
//TODO GTB-完成度: * 只实现了查询默认学员列表的 API 和 添加学员的 API
@RestController
public class studentController {
    private  List<Student> studentList = initstudentList();

    private  List<Student> initstudentList(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(1,"成吉思汗"));
        students.add(new Student(2,"鲁班七号"));
        students.add(new Student(3,"太乙真人"));
        students.add(new Student(4,"钟无艳"));
        students.add(new Student(5,"花木兰"));
        students.add(new Student(6,"雅典娜"));
        students.add(new Student(7,"芈月"));
        students.add(new Student(8,"白起"));
        students.add(new Student(9,"刘禅"));
        students.add(new Student(10,"庄周"));
        students.add(new Student(11,"马超"));
        students.add(new Student(12,"刘备"));
        students.add(new Student(13,"哪吒"));
        students.add(new Student(14,"大乔"));
        students.add(new Student(15,"蔡文姬"));
        return students;
    }

    @GetMapping("/students")
    public ResponseEntity getStudents(){
        return ResponseEntity.ok(studentList);
    }

    @PostMapping("/students")
    public ResponseEntity addStudent(@RequestBody Student student){
        //TODO GTB-完成度: - student 的 id 不能有客户端提供
        studentList.add(student);
        return ResponseEntity.ok(studentList);
    }

}
