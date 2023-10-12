
import DAO.Dao;
import Model.Notification;
import Model.Student;
import Model.Teacher;
import java.sql.SQLException;
import java.time.LocalDate;
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
    public static void main(String[] args) throws SQLException {
        
        Dao studentDAO = new Dao();
        List<Notification> students = studentDAO.selectAllNotiTeacherPage("TC10001");
        for (Notification student : students) {
            System.out.println(student);
        }
//
//        Dao notiDAO = new Dao();
//       // Định nghĩa các giá trị mẫu
//    String title = "Test Title";
//    String content = "Test Content";
//    LocalDate date = LocalDate.now();
//    int category = 2;
//    int classid = 1;

    // Gọi hàm insertNotiTeacher với các giá trị mẫu
//    try {
//        notiDAO.insertNotiTeacher(title, content, date, category, classid);
//        System.out.println("Thông báo đã được thêm thành công!");
//    } catch (SQLException e) {
//        e.printStackTrace();
//    }
//        for (Notification noti : notis) {
//            Teacher teacher = noti.getTeacher();
//            if (teacher != null) {
//                System.out.println("Notification ID: " + noti.getNotificationId());
//                System.out.println("Teacher Name: " + teacher.getFirstName() + " " + teacher.getLastName());
//            }
//        }
//        for (Notification noti : notis) {
//            System.out.println(noti);
//        }

        

    }
}



