
import DAO.Dao;
import Model.Application;
import Model.AttendanceList;
import Model.Teacher;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/*
	@@ -18,24 +22,33 @@
 */
public class Main {

    public static void main(String[] args) throws SQLException {
//        
        Dao studentDAO = new Dao();
        List<Teacher> students = studentDAO.getAllTeacher();
        for (Teacher student : students) {
            System.out.println(student);
        }

//        Dao notiDAO = new Dao();
//////       // Định nghĩa các giá trị mẫu
//        String title = "Test Title";
//        String content = "Test content";
//        String classid = "2";
//        String notificationid = "50";
////        LocalDate date = LocalDate.now();
////        int category = 1;
////        String studentid = "ST10001";
////    String teacherid = "TC10001";
//            
//
//        // Gọi hàm insertNotiTeacher với các giá trị mẫu
//        try {
//            notiDAO.updateNoti(title, content, classid, notificationid);
//            System.out.println("Thông báo thành công!");
//        } catch (SQLException e) {
//            e.printStackTrace();
//
//        }
//        LocalDate currentDate = LocalDate.now();
//        List<AttendanceList> students = studentDAO.getAttendanceStudentByDate(java.sql.Date.valueOf(currentDate),"1");
//        for (AttendanceList st : students){
//            System.out.println(st);
//        }
    }
}

//

