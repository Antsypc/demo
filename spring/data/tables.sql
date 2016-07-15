USE labms;
# 创建实验室管理系统相关所有的表
DROP TABLE IF EXISTS student;
DROP TABLE IF EXISTS teacher;
DROP TABLE IF EXISTS labManager;
DROP TABLE IF EXISTS labRoom;
DROP TABLE IF EXISTS labRoomUsage;
DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS equipment;
DROP TABLE IF EXISTS equipmentUsage;
DROP TABLE IF EXISTS equipmentMaintenance;
DROP TABLE IF EXISTS consumables;
DROP TABLE IF EXISTS consumablesUsage;
DROP TABLE IF EXISTS course;
DROP TABLE IF EXISTS courseChooseLog;
DROP TABLE IF EXISTS score;
############################################
# 创建用户一类的表
############################################
# 学生表
CREATE TABLE student(
    studentId CHAR(13) NOT NULL PRIMARY KEY,# 学号
    password VARCHAR(26) NOT NULL,          # 密码
    name VARCHAR(20) NOT NULL,              # 姓名
    department VARCHAR(20) NOT NULL,        # 学院
    major VARCHAR(20) NOT NULL,             # 专业
    _class VARCHAR(20) NOT NULL,            # 班级
    gender VARCHAR(3) NOT NULL,             # 性别
    inYear SMALLINT NOT NULL,               # 入学年份
    nativePlace VARCHAR(50) NOT NULL,       # 籍贯
    phone CHAR(13),                         # 电话
    email VARCHAR(30)                       # 邮箱
)DEFAULT CHARSET=utf8;
# 宿舍表
#CREATE TABLE IF NOT EXISTS student_dorm(
#   student_id CHAR(13) NOT NULL PRIMARY KEY, # 学号
#   campus CHAR(10) NOT NULL,                 # 园区
#   floor CHAR(5) NOT NULL,                   # 楼栋
#   room CHAR(15) NOT NULL                    # 寝室号
#)CHARSET=utf8;
# 教师表
CREATE TABLE teacher(
    teacherId CHAR(8) NOT NULL PRIMARY KEY, # 教师号
    password VARCHAR(26) NOT NULL,          # 密码
    name VARCHAR(20) NOT NULL,              # 姓名
    department VARCHAR(20) NOT NULL,        # 学院
    title VARCHAR(10) NOT NULL,             # 职称
    gender VARCHAR(3) NOT NULL,             # 性别
    phone CHAR(14),                         # 电话
    email VARCHAR(30),                      # 邮箱
    inYear SMALLINT NOT NULL,               # 入职年份
    nativePlace VARCHAR(50) NOT NULL        # 籍贯
)CHARSET=utf8;
# 实验室管理员表
CREATE TABLE labManager(
    labManagerId CHAR(8) NOT NULL PRIMARY KEY, # 员工编号
    password VARCHAR(26) NOT NULL,             # 密码
    name VARCHAR(20) NOT NULL,                 # 姓名
    position VARCHAR(10) NOT NULL,             # 职位
    gender VARCHAR(3) NOT NULL,                # 性别
    phone CHAR(14),                            # 电话
    email VARCHAR(30)                          # 邮箱
)CHARSET=utf8;
# 系统管理员(最初不考虑)
#CREATE TABLE IF NOT EXISTS admin(
#   id SMALLINT NOT NULL PRIMARY KEY,
#   username VARCHAR(20) NOT NULL,
#   password VARCHAR(26) NOT NULL
#)CHARSET=utf8;
############################################
# 创建实验室相关信息表
############################################
# 实验室基本情况表
CREATE TABLE labRoom(
    labRoomId CHAR(7) NOT NULL PRIMARY KEY,
    campus VARCHAR(15) NOT NULL,               # 园区
    building VARCHAR(30) NOT NULL,             # 楼栋
    roomName VARCHAR(30) NOT NULL,             # 实验室名字
    roomType VARCHAR(30),                      # 实验室类型
    capacity SMALLINT NOT NULL,                # 实验室最大容纳人数
    managerId CHAR(8),
    managerName VARCHAR(20)
)CHARSET=utf8;
# 实验室管理员审核通过后把记录写入该表,学生从course得到自己的课程ID，从该表查询课程实验室
CREATE TABLE labRoomUsage(
    labRoomUsageId INT NOT NULL PRIMARY KEY AUTO_INCREMENT, # 主键
    labRoomId INT NOT NULL,                     # 房间号，与labRoom保持一致
    timeFrom INT NOT NULL,                      # 使用起始时间
    courseId INT,                               # 使用该实验室的课程编号，当临时事件使用时可以没有编号
    teacherId CHAR(8),                          # 预约该实验室的老师ID
    nowNum SMALLINT DEFAULT 0,                  # 该课程已有人数
    maxNum SMALLINT DEFAULT 0,                  # 实验室最大容量
    isOk CHAR(1) DEFAULT '0',                   # 实验室管理员是否通过该项实验室申请，默认为‘0’，通过为‘1’
    description VARCHAR(30)                     # 建议只用临时事件使用时填写该字段
)CHARSET=utf8;
############################################
# 创建实验室设备与耗材信息表
############################################
# 固定资产
CREATE TABLE equipment(
    equipmentId VARCHAR(255) NOT NULL PRIMARY KEY,              # 设备唯一编号
    categoryId INT NOT NULL,                                    # 分类编号
    total INT DEFAULT 1,                                        # 设备数量
    unit VARCHAR(20) NOT NULL,                                  # 设备单位
    free INT NOT NULL,                                          # 设备闲置数量
    isOk TINYINT(1) NOT NULL DEFAULT '1'                        # 设备是否已经报废，如果报废了置'0'                                  
)CHARSET=utf8;
# 设备使用情况记录表（主要是补充和新增设备）
CREATE TABLE equipmentUsage(
    equipmentUsageId INT NOT NULL PRIMARY KEY AUTO_INCREMENT,   # 主键
    equipmentId VARCHAR(256) NOT NULL,                          # 设备唯一编号，与equipment表保持一致
    action CHAR(1) NOT NULL,                                    # 'A'补充add，'N'新增new,
    amount INT NOT NULL,                                        # 操作数量
    time INT NOT NULL                                           # 操作时间
)CHARSET=utf8;
# 设备维修记录表(记录维修和废弃记录，通过returnTime判断维修归还)
CREATE TABLE equipmentMaintenance(
    equipmentMaintenanceId INT NOT NULL PRIMARY KEY AUTO_INCREMENT,      # 主键
    equipmentId VARCHAR(255) NOT NULL,                          # 设备ID
    action CHAR(1) NOT NULL,                                    # 'R'维修, 'A'废弃abandon, 'S'废弃scrap
    amount INT NOT NULL,                                        # 维修数量
    checkInTime INT NOT NULL DEFAULT 0,                         # 登记时间
    returnTime INT,                                             # 如果维修好了归还时间
    managerId CHAR(8) NOT NULL,                                 # 记录人
    checkInDescription TEXT,                                    # 维修登记的描述   
    returnDescription TEXT                                      # 修好归还的描述
)CHARSET=utf8;
# 实验耗材
CREATE TABLE consumables(
    consumablesId VARCHAR(255) NOT NULL PRIMARY KEY,            # 耗材唯一编号
    categoryId INT NOT NULL,                                    # 分类编号
    total INT NOT NULL DEFAULT 0,                               # 耗材数量
    unit VARCHAR(20) NOT NULL
)CHARSET=utf8;
# 固定资产设备使用情况记录表（主要是补充和新增设备）
CREATE TABLE consumablesUsage(
    consumablesUsageId INT NOT NULL PRIMARY KEY AUTO_INCREMENT, # 主键
    consumablesId VARCHAR(256) NOT NULL,                        # 耗材唯一编号，与consumables表保持一致
    action CHAR(1) NOT NULL,                                    # 'A'add补充，'N'new新增，'E'export出库使用
    amount INT NOT NULL,                                        # 操作数量
    managerId CHAR(8) NOT NULL,                                 # 操作人ID
    time INT NOT NULL,                                          # 操作时间
    description TEXT                                            # 描述
)CHARSET=utf8;
# 设备和耗材的分类表
CREATE TABLE category(
    categoryId INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,                                 # 类型名字
    parent INT DEFAULT 0                                        # 父类，如果为 0 表示自身是一级分类
)CHARSET=utf8;
############################################
# 创建实验课程信息表
############################################
# 课程表，供学生选课查看有哪些实验课可选
CREATE TABLE course(
    courseId INT NOT NULL PRIMARY KEY AUTO_INCREMENT,# 主键
    courseName VARCHAR(255) NOT NULL,          # 课程名称
    courseClass VARCHAR(255),                  # 学该课程的班级,多个班级用分号隔开
    timeFrom INT NOT NULL,                     # 该课程从哪一天开始
    timeTo INT NOT NULL,                       # 该课程到哪一天截止
    teacherId CHAR(8) NOT NULL,                # 授课教师ID
    teacherName VARCHAR(20),                   # 授课教师姓名
    coursewareURL VARCHAR(255),                # 课程资料存放地址
    description TEXT                           # 该课程的描述
)CHARSET=utf8;
# 学生选课信息表,供学生查看当前已选课程
CREATE TABLE courseChooseLog(
    courseChooseLogId INT NOT NULL PRIMARY KEY AUTO_INCREMENT,  # 主键
    studentId CHAR(13) NOT NULL,                                # 学生ID
    labRoomUsageId INT NOT NULL,                                
    time INT                                                    # 选课时间，CURRENT_TIME
)CHARSET=utf8;
# 学生成绩表
CREATE TABLE score(
    studentId CHAR(13) NOT NULL,                                # 学生ID
    courseId INT NOT NULL,                                      # 课程ID
    stuScore CHAR(6) NOT NULL,                                  # 成绩，如 99.93
    PRIMARY KEY(studentId, courseId)
)CHARSET=utf8;