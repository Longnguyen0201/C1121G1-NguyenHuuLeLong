use quan_ly_sinh_vien;
-- Hiển thị tất cả các sinh viên có tên bắt đầu bảng ký tự ‘h’
select * from student
where student_Name like 'h%';
-- Hiển thị các thông tin lớp học có thời gian bắt đầu vào tháng 12.
select * from class
where month(start_date) = 12;
-- Hiển thị tất cả các thông tin môn học có credit trong khoảng từ 3-5.
select * from subject
where credit between 3 and 5;
-- Thay đổi mã lớp(ClassID) của sinh viên có tên ‘Hung’ là 2.
set sql_safe_updates = 0;
update student set class_id = 2 where student_name = 'Hung';
set sql_safe_updates = 1;
select * from student;
-- Hiển thị các thông tin: StudentName, SubName, Mark. Dữ liệu sắp xếp theo điểm thi (mark) giảm dần.
select  s.student_Name, sub.sub_name, m.mark
from student s join mark m on s.student_id = m.student_id 
join `subject` sub on m.sub_id = sub.sub_ID
order by mark desc, student_name desc;

