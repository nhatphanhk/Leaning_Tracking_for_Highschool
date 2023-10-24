
import DAO.Dao;
import Model.Application;
import Model.Notification;
import Model.Student;
import Model.Teacher;
import Model.Class;
import Model.Timetable;
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
        List<Timetable> students = studentDAO.selectTimetableTeacher("Slot 1", "TC10001");
        for (Timetable student : students) {
            System.out.println(student);
        }

//        Notification classN = studentDAO.selectNotiByNotiId("7");
//        System.out.println(classN);





//
//        Dao notiDAO = new Dao();
////       // Định nghĩa các giá trị mẫu
//    String title = "Test Title";
//    String content = "";
//    LocalDate date = LocalDate.now();
////    int category = 2;
//    String studentid = "ST10001";
////    String teacherid = "TC10001";
//
//    // Gọi hàm insertNotiTeacher với các giá trị mẫu
//    try {
//        notiDAO.insertApplicationStudent(title, content, date, studentid);
//        System.out.println("Thông báo đã được thêm thành công!");
//    } catch (SQLException e) {
//        e.printStackTrace();
