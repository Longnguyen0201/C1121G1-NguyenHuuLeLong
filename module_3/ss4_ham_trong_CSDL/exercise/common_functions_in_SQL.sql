use quan_ly_sinh_vien;
-- Hiển thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất. 
select * from `subject`
where credit = (select max(credit) from `subject`);

-- Hiển thị các thông tin môn học có điểm thi lớn nhất.
select `subject`.sub_ID,`subject`.sub_Name, `subject`.credit, mark.mark from `subject`
inner join mark on `subject`.sub_ID = mark.sub_id
where mark.mark = (select max(mark)from mark);

-- Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần.
select student.student_ID,student.student_Name,student.address, student.phone, student.class_id, `subject`.sub_Name, avg(mark.mark) as avg_mark from student
inner join mark on student.student_ID = mark.student_id
inner join `subject` on `subject`.sub_ID = mark.sub_id
group by student.student_ID
order by mark.mark desc;