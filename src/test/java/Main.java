
import DAO.Dao;
import Model.Notification;
import Model.Student;
import Model.Teacher;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */

/**
 *
 * @author tramy
 */
public class Main {
    public static void main(String[] args) {
        
//        Dao studentDAO = new Dao();
//        List<Student> students = studentDAO.selectAllStudent("1");
//        for (Student student : students) {
//            System.out.println(student);
//        }
//
        Dao notiDAO = new Dao();
        List<Notification> notis = notiDAO.selectAllNotiTeacher("2");
        
        for (Notification noti : notis) {
            Teacher teacher = noti.getTeacher();
            if (teacher != null) {
                System.out.println("Notification ID: " + noti.getNotificationId());
                System.out.println("Teacher Name: " + teacher.getFirstName() + " " + teacher.getLastName());
            }
        }
//        for (Notification noti : notis) {
//            System.out.println(noti);
//        }

        

    }
}



