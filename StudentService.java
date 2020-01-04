package com.tt.demoserver.components;

import com.bj58.spat.scf.server.contract.annotation.ServiceBehavior;
import com.tt.demoserver.contract.IStudentService;
import com.tt.demoserver.entity.Student;

import java.util.ArrayList;
import java.util.List;

@ServiceBehavior
public class StudentService implements IStudentService {
    private List<Student> studentList = null;
    public StudentService(){
        studentList = new ArrayList<Student>();
        for(int i=0;i<10;i++){
            Student stu = new Student();
            stu.setSid(i);
            stu.setSname("sName"+i);
            stu.setAddress("sAddress"+i);
            studentList.add(stu);
        }
    }
    public Student getStudentById(int sid) {

        return studentList.get(sid);
    }
    public Student getStudentByName(String sname) {
        for(Student s:studentList){
            if(sname!=null && !sname.equals("") && sname.equals(s.getSname())){
                return s;
            }
        }
        return null;
    }

    public List<Student> getStudentByAddress(String address) {
        List<Student> res = new ArrayList<Student>();
        for(Student s:studentList){
            if(address!=null && address != "" && address.equals(s.getAddress())){
                res.add(s);
            }
        }

        return res;
    }
}

