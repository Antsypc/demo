USE labms;

INSERT INTO student(studentId, password, name, department, major, `_class`, gender, inYear, nativePlace, phone, email) VALUES
  ('0121310880433', '123456', 'YOUNG', 'computer', 'software', 'soft01', 'man', 2013, 'China', '15512345678', 'y@mail.com');

INSERT INTO teacher(teacherId, password, name, department, title, gender, phone, email, inYear, nativePlace) VALUES
  ('12345678', '123456', 'Ben', 'computer', 'professor', 'man', '13312345678', 'b@mail.com', 2000, 'China');

INSERT INTO labmanager(labManagerId, password, name, position, gender, phone, email) VALUES
  ('87654321', '123456', 'Jay', 'leader', 'man', '18912345678', 'j@mail.com');

INSERT INTO course(courseName, courseClass, timeFrom, timeTo, teacherId, teacherName, coursewareURL, description) VALUES
  ('Java', 'soft01', 0, 0, '12345678', 'ben', '', 'Java basic');

INSERT INTO labroom(labRoomId, campus, building, roomName, roomType, capacity, managerId, managerName) VALUES
  ('1234567', 'Nan', 'Xin', 'xin202', 'math', 80, '87654321', 'Jay');

INSERT INTO labroomusage(labRoomId, timeFrom, courseId, teacherId, nowNum, maxNum, isOk, description) VALUES
  (1, 0, 1, '12345678', 0, 80, 'a', 'now');