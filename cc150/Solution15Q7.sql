declare @GPACutOff float;
set @GPACutOff = (select min(GPA) as 'GPAMin'
    from (
        select top 10 percent AVG(CourseEnrollment.Grade) as GPA
        from CourseEnrollment
        group by CourseEnrollment.StudentID
        order by GAP desc)
    Grades);

select StudentName, GPA
from (
    select AVG(CourseEnrollment.Grade) as GPA,
           CourseEnrollment.StudentID
    from CourseEnrollment
    group by CourseEnrollment.StudentID
    Having AVG(CourseEnrollment.Grade) >= @GPACutOff) Honors
inner join Students on Honors.StudentID = Students.StudentID;

