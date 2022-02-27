use quan_ly_sinh_vien;
select address , count(student_ID) as 'số lượng học viên'
from student
group by address;

select student.student_ID, student.student_Name, avg(mark)
from student join mark on student.student_ID = mark.student_ID
group by student_ID,student_Name;

select student.student_ID, student.student_Name, avg(mark)
from student join mark on student.student_ID = mark.student_ID
group by student_ID,student_Name
having avg(mark) > 15;

select student.student_ID, student.student_Name, avg(mark)
from student join mark on student.student_ID = mark.student_ID
group by student_ID,student_Name
having avg(mark) >= all (select avg(mark) from mark group by mark.student_id);

select student_ID, avg(mark) from mark group by mark.student_id;

