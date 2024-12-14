-- MySQL dump 10.13  Distrib 5.5.62, for Win64 (AMD64)
--
-- Host: 192.168.0.30    Database: cis_finalproject
-- ------------------------------------------------------
-- Server version	11.4.3-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `attendance`
--

DROP TABLE IF EXISTS `attendance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `attendance` (
  `emp_id` varchar(12) NOT NULL,
  `work_start` time NOT NULL,
  `work_end` time DEFAULT NULL,
  `work_date` date NOT NULL,
  `significant` char(2) DEFAULT NULL,
  `work_total` int(11) DEFAULT NULL,
  `late_check` char(1) NOT NULL DEFAULT 'N' CHECK (`late_check` in ('Y','N')),
  PRIMARY KEY (`emp_id`,`work_date`),
  CONSTRAINT `attendance_emp_id_fk` FOREIGN KEY (`emp_id`) REFERENCES `employee` (`emp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attendance`
--

LOCK TABLES `attendance` WRITE;
/*!40000 ALTER TABLE `attendance` DISABLE KEYS */;
INSERT INTO `attendance` VALUES ('111','19:32:00','19:32:00','2024-12-12','조퇴',0,'Y'),('id_02','09:00:00','18:30:00','2024-12-02',NULL,570,'N'),('id_02','09:00:00','18:30:00','2024-12-03',NULL,570,'N'),('id_02','09:00:00','18:30:00','2024-12-04',NULL,570,'N'),('id_02','09:00:00','18:30:00','2024-12-05',NULL,570,'N'),('id_02','09:00:00','18:30:00','2024-12-06',NULL,570,'N'),('id_02','09:00:00','18:30:00','2024-12-07',NULL,570,'N'),('id_02','09:00:00','18:30:00','2024-12-08',NULL,570,'N'),('id_02','09:00:00','18:30:00','2024-12-09',NULL,570,'N'),('id_02','09:00:00','18:30:00','2024-12-10',NULL,570,'N'),('id_02','09:00:00','18:30:00','2024-12-11',NULL,570,'N'),('id_02','09:00:00','18:30:00','2024-12-12',NULL,570,'N'),('id_02','09:00:00','18:30:00','2024-12-13',NULL,570,'N'),('id_02','22:17:00','22:18:00','2024-12-14',NULL,1,'Y'),('id_03','19:02:00','19:02:00','2024-12-10',NULL,0,'Y'),('id_03','20:00:00','20:00:00','2024-12-11','외출',0,'Y'),('id_07','09:15:00','09:15:00','2024-12-12',NULL,0,'N'),('id_12','20:18:00','20:18:00','2024-12-14',NULL,0,'Y'),('test1','09:00:00','18:03:00','2024-10-22',NULL,543,'N'),('test1','09:00:00','18:30:00','2024-11-04',NULL,570,'N'),('test1','09:00:00','18:30:00','2024-11-05',NULL,570,'N'),('test1','09:00:00','18:30:00','2024-11-06',NULL,570,'N'),('test1','09:00:00','18:30:00','2024-11-08',NULL,570,'N'),('test1','09:00:00','18:30:00','2024-11-09',NULL,570,'N'),('test1','09:00:00','18:30:00','2024-11-10',NULL,570,'N'),('test1','09:00:00','18:30:00','2024-11-11',NULL,570,'N'),('test1','09:00:00','18:30:00','2024-11-12',NULL,570,'N'),('test1','09:00:00','18:30:00','2024-11-13',NULL,570,'N'),('test1','09:00:00','18:30:00','2024-11-14',NULL,570,'N'),('test1','09:00:00','18:30:00','2024-11-15',NULL,570,'N'),('test1','09:00:00','18:30:00','2024-11-16',NULL,570,'N'),('test1','09:00:00','18:30:00','2024-11-17',NULL,570,'N'),('test1','09:00:00','18:30:00','2024-11-18',NULL,570,'N'),('test1','09:00:00','18:30:00','2024-11-19',NULL,570,'N'),('test1','09:00:00','18:30:00','2024-11-20',NULL,570,'N'),('test1','09:00:00','18:30:00','2024-11-21',NULL,570,'N'),('test1','09:00:00','18:30:00','2024-11-22',NULL,570,'N'),('test1','09:00:00','18:30:00','2024-11-25',NULL,570,'N'),('test1','09:00:00','18:30:00','2024-11-26',NULL,570,'N'),('test1','09:00:00','18:30:00','2024-11-27',NULL,570,'N'),('test1','09:00:00','18:30:00','2024-11-28',NULL,570,'N'),('test1','18:56:00','18:56:00','2024-12-10',NULL,0,'Y'),('test1','19:32:00','19:32:00','2024-12-12',NULL,0,'Y'),('test1','14:50:00',NULL,'2024-12-13',NULL,NULL,'Y'),('test2','21:17:00','21:17:00','2024-12-11','조퇴',0,'Y'),('test2','19:30:00','19:31:00','2024-12-12',NULL,1,'Y');
/*!40000 ALTER TABLE `attendance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `board_file`
--

DROP TABLE IF EXISTS `board_file`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `board_file` (
  `file_id` int(11) NOT NULL AUTO_INCREMENT,
  `category` varchar(10) NOT NULL,
  `board_num` int(11) NOT NULL,
  `save_name` varchar(255) NOT NULL,
  `created_date` datetime NOT NULL DEFAULT current_timestamp(),
  `file_size` int(11) DEFAULT NULL,
  `original_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`file_id`),
  KEY `board_file_ibfk_1` (`category`,`board_num`),
  CONSTRAINT `board_file_ibfk_1` FOREIGN KEY (`category`, `board_num`) REFERENCES `board_table` (`category`, `board_num`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `board_file`
--

LOCK TABLES `board_file` WRITE;
/*!40000 ALTER TABLE `board_file` DISABLE KEYS */;
INSERT INTO `board_file` VALUES (2,'공지사항',2,'6f6e1c19-8aff-46f7-ad55-cbca8631e384.jpg','2024-12-10 19:00:10',576679,'AKR20230710076800005_03_i_P4.jpg'),(3,'자유게시판',2,'1df37868-8dd4-4891-bc16-da22720095ce.jpg','2024-12-10 19:06:19',576679,'AKR20230710076800005_03_i_P4.jpg'),(5,'자유게시판',3,'0a3778c2-0c75-4eb6-b9e7-4374754d484c.jpg','2024-12-10 19:17:49',576679,'AKR20230710076800005_03_i_P4.jpg'),(6,'자유게시판',3,'5b1a4769-c944-4cb4-9cc3-c0f791b5c5b8.jpg','2024-12-10 19:17:49',2770658,'greg-rakozy-oMpAz-DN-9I-unsplash.jpg'),(11,'공지사항',10,'55d16437-0399-451e-b828-cfa48f9e515d.jpg','2024-12-11 17:20:13',576679,'AKR20230710076800005_03_i_P4.jpg'),(14,'자유게시판',7,'fe44dd12-98e8-4de8-99cf-4989a0714572.jpg','2024-12-11 17:59:13',576679,'AKR20230710076800005_03_i_P4.jpg'),(26,'자유게시판',19,'957dbc0c-3e06-425c-9663-11db20e75428.jpg','2024-12-13 15:25:46',576679,'zx.jpg'),(29,'자유게시판',21,'e1003736-05b3-4163-b444-f5bde7f4f693.jpg','2024-12-14 19:10:21',576679,'zx.jpg'),(30,'자유게시판',20,'ce5a3959-ce0b-41db-8170-6cb7ffd19c29.jpg','2024-12-14 19:11:33',576679,'zx.jpg'),(32,'공지사항',36,'f3447379-8afa-47b3-bab3-d12b7beace5a.jpg','2024-12-14 19:41:18',576679,'zx.jpg'),(33,'자유게시판',27,'750a452f-e35a-4b71-9c93-027ddd3848f5.jpg','2024-12-14 20:21:48',22005,'happyjpg.jpg'),(34,'자유게시판',31,'f5c609a2-882f-4bb8-b9b2-ad761096687d.jpg','2024-12-14 20:23:23',15421,'angrjpg.jpg'),(35,'공지사항',43,'da9b576a-8889-4362-a4d3-c5c3cdabe688.jpg','2024-12-14 21:10:43',22005,'happyjpg.jpg'),(36,'자유게시판',47,'7e829976-1c8d-4c51-ad4f-00d12dcf2cb6.jpg','2024-12-14 21:59:01',22005,'happyjpg.jpg');
/*!40000 ALTER TABLE `board_file` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `board_table`
--

DROP TABLE IF EXISTS `board_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `board_table` (
  `category` varchar(10) NOT NULL,
  `board_num` int(11) NOT NULL,
  `board_title` varchar(50) DEFAULT NULL,
  `board_content` varchar(255) DEFAULT NULL,
  `create_at` timestamp NULL DEFAULT current_timestamp(),
  `emp_id` varchar(12) DEFAULT NULL,
  `boardHits` int(11) DEFAULT 0,
  `fileAttached` int(11) DEFAULT 0,
  PRIMARY KEY (`category`,`board_num`),
  KEY `fk_board_employee` (`emp_id`),
  CONSTRAINT `fk_board_employee` FOREIGN KEY (`emp_id`) REFERENCES `employee` (`emp_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `board_table`
--

LOCK TABLES `board_table` WRITE;
/*!40000 ALTER TABLE `board_table` DISABLE KEYS */;
INSERT INTO `board_table` VALUES ('공지사항',2,'안녕하세요. 관리자입니다.','그냥 그렇다구요..','2024-11-14 10:00:10','admin',32,1),('공지사항',4,'공지 241115','뿡','2024-11-15 11:54:48','admin',21,0),('공지사항',6,'여러분 그거 아시나요?','전 모르는뎅 ㅋ','2024-11-18 11:54:55','admin',23,0),('공지사항',7,'공지 241119 무조건 필독','사실 필독 안해도 됩니다.','2024-11-19 11:55:04','admin',54,1),('공지사항',10,'금일 퇴근 시간은 12시 입니다.','제발 정시퇴근 해주세요.','2024-11-20 08:20:13','admin',10,1),('공지사항',12,'금일 퇴근 시간은 12시 입니다.','제가 그렇게 정했습니다.','2024-11-21 08:56:22','admin',18,0),('공지사항',13,'금일 퇴근 시간은 12시 입니다.','제가 그렇게 정했습니다.','2024-11-22 09:43:52','admin',13,0),('공지사항',14,'금일 퇴근 시간은 10시 입니다.','빨리 퇴근해주세요.','2024-11-25 10:57:10','admin',23,0),('공지사항',15,'금일 퇴근 시간은 10시 입니다.','제발 정시퇴근 해주세요.','2024-11-26 10:57:10','admin',11,0),('공지사항',16,'금일 퇴근 시간은 10시 입니다.','다들 얼른 퇴근하세요. 수고하셨습니다.','2024-11-27 10:57:10','admin',31,0),('공지사항',19,'공지 241211','꺄악 어딜봐요','2024-11-28 10:57:10','admin',109,0),('공지사항',20,'여러분 다들 그거 아시나요?','전 모릅니다. 수고하세요.','2024-11-30 10:57:10','admin',27,0),('공지사항',21,'휴먼교육센터 일정','사실 없습니다.','2024-12-01 10:57:46','admin',8,0),('공지사항',22,'휴먼교육센터 일정','사실 없습니다.','2024-12-02 10:57:46','admin',3,0),('공지사항',23,'휴먼교육센터 일정','사실 없습니다.','2024-12-03 10:57:46','admin',4,0),('공지사항',24,'휴먼교육센터 일정','사실 없습니다.','2024-12-04 10:57:46','admin',5,0),('공지사항',25,'휴먼교육센터 일정입니다.','사실 없습니다.','2024-12-05 10:58:02','admin',12,0),('공지사항',26,'휴먼교육센터 일정','사실 없습니다.','2024-12-06 10:58:05','admin',40,0),('공지사항',36,'공지사항 241214','오늘은 회사 기념일입니다.','2024-12-07 10:41:18','admin',4,1),('공지사항',37,'공지사항 241208','금일 회사 내 식당에 문제가 발생하여 중식 운영을 하지 못합니다. 참고 부탁드립니다.','2024-12-08 11:10:35','admin',12,0),('공지사항',38,'공지사항 241209','금일 퇴근 시간은 자율 퇴근 부탁드립니다.','2024-12-09 11:11:10','admin',30,0),('공지사항',39,'공지사항 241210','이번 주 주말에는 회사 내 등산 모임이 예정되어 있습니다. 많은 참석 부탁드립니다.','2024-12-10 11:11:55','admin',100,0),('공지사항',40,'공지사항 241211','금일 모든 부서에 퇴근 후 회식이 예정되어 있습니다. 다들 착오 없이 진행하시길 바랍니다.','2024-12-11 11:12:41','admin',28,0),('공지사항',41,'공지사항 241212','금일 부서별 간식 나눔이 예정되어 있습니다. 각 부서별로 수령할 사람 몇 분은 인사팀으로 와주시길 부탁드립니다.','2024-12-12 11:14:44','admin',222,0),('공지사항',42,'공지사항 241213','오늘 하루도 고생 많으셨습니다. 신나는 주말 이전의 금요일이므로 푹 쉬고 다음주에 뵙겠습니다.','2024-12-13 11:15:18','admin',158,0),('공지사항',43,'금일 등산 모임 일정 공유입니다.','금일 09:00 부터 17:30 까지 진행됩니다. 회사에서 도시락 지원해주니 참고하여 물품 챙겨오시길 바랍니다. 감사합니다.','2024-12-14 11:16:33','admin',34,0),('자유게시판',2,'관리자 김진호 입니다.','여러분들 화이팅하세요.','2024-11-14 10:06:19','admin',24,1),('자유게시판',3,'뉴진스는 진짜 최고다..','뉴진스는 영원하다','2024-11-14 10:17:49','id_03',6,2),('자유게시판',4,'확인용 글입니다','오늘은 매우 춥네요 ㅎ','2024-11-15 11:03:38','id_03',31,0),('자유게시판',7,'테스트입니다.','테스트.','2024-11-15 08:58:47','id_06',13,0),('자유게시판',8,'테스트입니다.','테스트.','2024-11-15 11:43:19','id_03',41,0),('자유게시판',10,'테스트입니다.','테스트.','2024-11-15 11:43:30','id_03',8,0),('자유게시판',19,'퇴근하고 싶습니다','살려주세오','2024-11-17 05:56:11','id_05',104,0),('자유게시판',20,'마늘요리','맛있다','2024-12-02 08:51:55','id_02',25,0),('자유게시판',21,'출근!','월요일 좋아','2024-12-03 10:10:21','id_03',5,1),('자유게시판',22,'안녕하세요 개발팀 송지우입니다.','다름이 아니라 저희 개발팀 윤정민 대리님을 칭찬하는 글을 쓰고 싶었습니다. 오늘도 힘내주시는 윤정민 대리님께 감사의 말씀 부탁드립니다.','2024-12-10 11:19:02','id_12',18,0),('자유게시판',23,'이번 주 내내 한파주의보네요','따뜻하게 입고 다니시고 감기 조심하세요','2024-12-14 11:19:04','id_02',10,0),('자유게시판',24,'오늘 퇴근은 언제하나요?','계속 야근인데 너무 힘들어요..','2024-12-14 11:19:28','id_12',8,0),('자유게시판',25,'한수','진 입니다. 한수 부탁드립니다.','2024-12-14 11:20:37','id_09',1,0),('자유게시판',26,'사내 연합 체육대회가 기대됩니다.','추운 날씨에 부상 당하지 않고 화이팅 합시다! 축구팀 화이팅','2024-12-14 11:21:31','id_19',12,0),('자유게시판',27,'오늘 날씨가 참 좋네요 !! ','영하 2도밖에 안된다고 합니다 !\r\n너무 행봉해요 ㅎㅎ','2024-12-14 11:21:48','id_18',4,1),('자유게시판',28,'팀의 업무 효율성을 향상하는 방법','1. 불필요한 미팅을 없앱니다\r\n2. 미팅 효율성을 개선합니다\r\n3. 주요 결과를 기반으로 업무 우선순위를 지정합니다\r\n4. 우선순위가 낮은 업무를 삭제, 연기, 위임, 축소합니다\r\n5. 팀의 강점을 활용할 수 있도록 업무를 배정합니다\r\n6. 시작하기 전에 팀의 업무를 계획합니다','2024-12-14 11:22:45','id_02',99,0),('자유게시판',29,'이 수수수 수퍼노바','수민은 다가와 오예엥','2024-12-14 11:22:57','leesumin',8,0),('자유게시판',30,'이수민입니다.','너무 심심합니다. 일거리 좀 주십쇼.','2024-12-14 11:23:22','leesumin',12,0),('자유게시판',31,'오늘 날씨가 좋다니요 ?? ','제발 정신좀 차립시다','2024-12-14 11:23:23','id_18',6,1),('자유게시판',32,'프로젝트 계획의 필수 요소 7가지','1. 목표\r\n2. 성공 지표\r\n3. 이해관계자와 팀의 역할\r\n4. 예산\r\n5. 마일스톤 및 결과물\r\n6. 타임라인 및 일정.\r\n7. 커뮤티케이션 계획','2024-12-14 11:24:14','id_02',15,0),('자유게시판',33,'사내 농구모임','오늘 밤에 농구 연습 있습니다!! 오늘도 즐겁게 해봐요.','2024-12-14 11:24:20','id_11',5,0),('자유게시판',34,'그쪽도 홍민수님을 아세요?','그게 바로 접니다. 홍홍홍','2024-12-14 11:26:01','hong',7,0),('자유게시판',35,'포모도로 기법을 사용하는 방법','1. 중요도 순으로 작업 목록을 만듭니다.\r\n2. 타이머를 25분으로 맟춥니다.\r\n3. 그동안 작업을 수행합니다.\r\n4. 5분 휴식을 취합니다.\r\n5. 포모도로 4회가 완료된 후 15~30분간 휴식을 취합니다.','2024-12-14 11:26:10','id_02',25,0),('자유게시판',36,'이번 주말 독서의 밤에 초대합니다!','독서 모임을 운영하고 있는 최동훈입니다. 이번 주말에 독서의 밤 행사가 있습니다. 경품도 있으니 많은 참여 부탁드립니다.','2024-12-14 11:26:34','id_06',133,0),('자유게시판',37,'하루하루가 좋은 날입니다.','매일매일이 월요일이면 좋겠네요.','2024-12-14 11:27:07','hong',78,0),('자유게시판',38,'여러분 다들 그거 아시나요?','오늘 드디어 저희 개발팀 프로젝트가 끝났습니다. 얼른 축하해주세요.','2024-12-14 11:28:01','id_07',12,0),('자유게시판',39,'포모도로 기법의 장점','1. 팀 커뮤니케이션 간소화.\r\n2. 주의 분산 방지.\r\n3. 정신적 피로 감소.\r\n4. 집중력 항상.\r\n5. 종기부여 유지.\r\n6. 프로젝트 계획 강화.','2024-12-14 11:28:02','id_02',18,0),('자유게시판',40,'저의 사수 한수진님을 칭찬합니다.','너무 미인입니다.','2024-12-14 11:28:12','id_10',13,0),('자유게시판',41,'회계팀 임도현입니다.','윤도현 아닙니다.','2024-12-14 11:29:46','id_10',14,0),('자유게시판',42,'취미 추천해주세요!!','요즘 하던 모든 취미가 질려서 다른걸 해보려고 합니다ㅎㅎ 발전하는 재미가 있는 좋은 취미 추천해주세용','2024-12-14 11:30:19','id_13',15,0),('자유게시판',43,'제 이름이 너무 부끄럽습니다..','테스트가 뭡니까.. 박민수 과장님이 자꾸 제 이름으로 놀립니다. 서럽습니다..','2024-12-14 11:31:04','test1',14,0),('자유게시판',44,'업무에서 몰입 상태를 활용하는 6가지 팁','1. 도전 요소와 기량 간 균형을 찾습니다\r\n2. 명확한 목표를 설정합니다\r\n3. 몰입을 방해하는 요소를 줄입니다\r\n4. 멀티태스킹을 하지 않습니다\r\n5. 억지로 하지 않습니다\r\n6. 확신이 서지 않는다면 좋아하는 일을 합니다','2024-12-14 11:31:54','id_05',2,0),('자유게시판',45,'재테크 고수님들 한수 알려주세요!','제가 경제학과임에도 불구하고 제 돈관리는 영 꽝입니다..다들 재테크 관리 어떻게 하시나요?','2024-12-14 11:32:39','id_17',7,0),('자유게시판',46,'파레토 법칙','파레토 법칙은 많은 성과에서 결과의 약 80%가 20%의 원인에서 발생한다고 말합니다. \r\n즉, 적은 비율의 원인이 아주 큰 영향을 가져온다는 말입니다.','2024-12-14 11:32:41','id_05',8,0),('자유게시판',47,'안녕하세요','심심하네요','2024-12-14 12:59:01','id_06',1,1);
/*!40000 ALTER TABLE `board_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comment` (
  `category` varchar(10) DEFAULT NULL,
  `board_num` int(11) NOT NULL,
  `comment_num` int(11) NOT NULL,
  `comment_content` varchar(255) NOT NULL,
  `create_at` timestamp NULL DEFAULT current_timestamp(),
  `emp_id` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`comment_num`),
  KEY `fk_board_table` (`category`,`board_num`),
  KEY `fk_employee` (`emp_id`),
  CONSTRAINT `fk_board_table` FOREIGN KEY (`category`, `board_num`) REFERENCES `board_table` (`category`, `board_num`) ON DELETE CASCADE,
  CONSTRAINT `fk_employee` FOREIGN KEY (`emp_id`) REFERENCES `employee` (`emp_id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES ('자유게시판',4,8,'이잉 너무 추워잉','2024-12-11 02:52:01','id_05'),('자유게시판',4,9,'사실 안추워잉','2024-12-11 02:52:03','id_05'),('자유게시판',4,10,'사실 추워잉','2024-12-11 02:52:05','id_05'),('자유게시판',4,11,'뭐야 얘는','2024-12-11 02:52:39',NULL),('자유게시판',4,12,'저도 추운데','2024-12-11 03:03:20','id_06'),('자유게시판',4,13,'같이 따뜻한 아이스 아메리카노 먹으러 가실까요?','2024-12-11 03:03:22','id_06'),('자유게시판',4,14,'싫음말구요','2024-12-11 03:03:25','id_06'),('공지사항',4,19,'뿡뿡','2024-12-11 08:11:00','admin'),('공지사항',26,25,'뭐야','2024-12-13 05:54:36','id_03'),('공지사항',26,26,'뭐야 이건 또','2024-12-13 05:55:22','id_05'),('자유게시판',19,27,'asdvasdv','2024-12-13 06:44:18','id_05'),('자유게시판',19,28,'asdvasdv','2024-12-13 06:44:20','id_05'),('공지사항',36,29,'안녕하신가요 ..','2024-12-14 10:42:09','admin'),('자유게시판',30,30,'코딩좀 하세요','2024-12-14 11:23:51','id_18'),('자유게시판',22,31,'푸하핫','2024-12-14 11:24:29','id_18'),('자유게시판',31,32,'오늘 따뜻하던데용','2024-12-14 11:26:19','hong'),('자유게시판',34,33,'제 이름도 홍민수인데 ㅋㅋ','2024-12-14 11:28:32','111'),('공지사항',43,35,'안녕하세요','2024-12-14 12:57:38','id_06'),('자유게시판',47,36,'댓글남깁니다','2024-12-14 12:59:19','id_06');
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `email`
--

DROP TABLE IF EXISTS `email`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `email` (
  `mail_num` int(11) NOT NULL,
  `mail_title` varchar(20) NOT NULL,
  `mail_content` varchar(255) DEFAULT NULL,
  `mail_check` char(1) NOT NULL DEFAULT 'N' CHECK (`mail_check` in ('Y','N')),
  `create_at` timestamp NOT NULL,
  `recipient_id` varchar(12) NOT NULL,
  `sender_id` varchar(12) NOT NULL,
  PRIMARY KEY (`mail_num`),
  KEY `email_recipient_id_fk` (`recipient_id`),
  KEY `email_sender_id_fk` (`sender_id`),
  CONSTRAINT `email_recipient_id_fk` FOREIGN KEY (`recipient_id`) REFERENCES `employee` (`emp_id`),
  CONSTRAINT `email_sender_id_fk` FOREIGN KEY (`sender_id`) REFERENCES `employee` (`emp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `email`
--

LOCK TABLES `email` WRITE;
/*!40000 ALTER TABLE `email` DISABLE KEYS */;
INSERT INTO `email` VALUES (1,'테스트 메일 제목입니다.','테스트 메일 내용입니다. 이곳에는 메일의 내용이 들어가죠.','N','2024-12-10 09:43:00','test1','test2'),(2,'테스트 메일 제목입니다.','테스트 메일 내용입니다. 이곳에는 메일의 내용이 들어가죠.','N','2024-12-10 09:43:00','test1','test2'),(3,'테스트 메일 제목입니다.','테스트 메일 내용입니다. 이곳에는 메일의 내용이 들어가죠.','N','2024-12-10 09:43:00','test1','test2'),(4,'테스트 메일 제목입니다.','테스트 메일 내용입니다. 이곳에는 메일의 내용이 들어가죠.','N','2024-12-10 09:43:00','test1','test2'),(5,'테스트 메일 제목입니다.','테스트 메일 내용입니다. 이곳에는 메일의 내용이 들어가죠.','N','2024-12-10 09:43:00','test1','test2'),(6,'테스트 메일 제목입니다.','테스트 메일 내용입니다. 이곳에는 메일의 내용이 들어가죠.','N','2024-12-10 09:43:00','test1','test2'),(7,'테스트 메일 제목입니다.','테스트 메일 내용입니다. 이곳에는 메일의 내용이 들어가죠.','N','2024-12-10 09:43:00','test1','test2'),(8,'테스트 메일 제목입니다.','테스트 메일 내용입니다. 이곳에는 메일의 내용이 들어가죠.','N','2024-12-10 09:43:00','test1','test2'),(9,'테스트 메일 제목입니다.','테스트 메일 내용입니다. 이곳에는 메일의 내용이 들어가죠.','N','2024-12-10 09:43:00','test1','test2'),(10,'테스트 메일 제목입니다.','테스트 메일 내용입니다. 이곳에는 메일의 내용이 들어가죠.','N','2024-12-10 09:43:00','test1','test2'),(11,'테스트 메일 제목입니다.','테스트 메일 내용입니다. 이곳에는 메일의 내용이 들어가죠.','N','2024-12-10 09:44:00','test1','test1'),(12,'테스트 메일 제목입니다.','테스트 메일 내용입니다. 이곳에는 메일의 내용이 들어가죠.','N','2024-12-10 09:44:00','test1','test1'),(13,'테스트 메일 제목입니다.','테스트 메일 내용입니다. 이곳에는 메일의 내용이 들어가죠.','N','2024-12-10 09:44:00','test1','test1'),(14,'테스트 메일 제목입니다.','테스트 메일 내용입니다. 이곳에는 메일의 내용이 들어가죠.','N','2024-12-10 09:44:00','test1','test1'),(15,'테스트 메일 제목입니다.','테스트 메일 내용입니다. 이곳에는 메일의 내용이 들어가죠.','N','2024-12-10 09:44:00','test1','test1'),(16,'테스트 메일 제목입니다.','테스트 메일 내용입니다. 이곳에는 메일의 내용이 들어가죠.','N','2024-12-10 09:44:00','test1','test1'),(17,'테스트 메일 제목입니다.','테스트 메일 내용입니다. 이곳에는 메일의 내용이 들어가죠.','N','2024-12-10 09:44:00','test1','test1'),(18,'테스트 메일 제목입니다.','테스트 메일 내용입니다. 이곳에는 메일의 내용이 들어가죠.','N','2024-12-10 09:44:00','test1','test1'),(19,'테스트 메일 제목입니다.','테스트 메일 내용입니다. 이곳에는 메일의 내용이 들어가죠.','N','2024-12-10 09:44:00','test1','test1'),(20,'테스트 메일 제목입니다.','테스트 메일 내용입니다. 이곳에는 메일의 내용이 들어가죠.','Y','2024-12-10 09:44:00','test1','test1'),(21,'테스트 메일 제목입니다.','테스트 메일 내용입니다. 이곳에는 메일의 내용이 들어가죠.','N','2024-12-10 09:44:00','test2','test1'),(22,'테스트 메일 제목입니다.','테스트 메일 내용입니다. 이곳에는 메일의 내용이 들어가죠.','N','2024-12-10 09:44:00','test2','test1'),(23,'테스트 메일 제목입니다.','테스트 메일 내용입니다. 이곳에는 메일의 내용이 들어가죠.','N','2024-12-10 09:44:00','test2','test1'),(24,'테스트 메일 제목입니다.','테스트 메일 내용입니다. 이곳에는 메일의 내용이 들어가죠.','N','2024-12-10 09:44:00','test2','test1'),(25,'테스트 메일 제목입니다.','테스트 메일 내용입니다. 이곳에는 메일의 내용이 들어가죠.','N','2024-12-10 09:44:00','test2','test1'),(26,'테스트 메일 제목입니다.','테스트 메일 내용입니다. 이곳에는 메일의 내용이 들어가죠.','N','2024-12-10 09:44:00','test2','test1'),(27,'테스트 메일 제목입니다.','테스트 메일 내용입니다. 이곳에는 메일의 내용이 들어가죠.','N','2024-12-10 09:44:00','test2','test1'),(28,'테스트 메일 제목입니다.','테스트 메일 내용입니다. 이곳에는 메일의 내용이 들어가죠.','N','2024-12-10 09:44:00','test2','test1'),(29,'테스트 메일 제목입니다.','테스트 메일 내용입니다. 이곳에는 메일의 내용이 들어가죠.','N','2024-12-10 09:44:00','test2','test1'),(30,'테스트 메일 제목입니다.','테스트 메일 내용입니다. 이곳에는 메일의 내용이 들어가죠.','N','2024-12-10 09:44:00','test2','test1'),(31,'테스트 메일 제목입니다.','테스트 메일 내용입니다. 이곳에는 메일의 내용이 들어가죠.','N','2024-12-10 09:44:00','test2','test2'),(32,'테스트 메일 제목입니다.','테스트 메일 내용입니다. 이곳에는 메일의 내용이 들어가죠.','N','2024-12-10 09:44:00','test2','test2'),(33,'테스트 메일 제목입니다.','테스트 메일 내용입니다. 이곳에는 메일의 내용이 들어가죠.','N','2024-12-10 09:44:00','test2','test2'),(34,'테스트 메일 제목입니다.','테스트 메일 내용입니다. 이곳에는 메일의 내용이 들어가죠.','N','2024-12-10 09:44:00','test2','test2'),(35,'테스트 메일 제목입니다.','테스트 메일 내용입니다. 이곳에는 메일의 내용이 들어가죠.','N','2024-12-10 09:44:00','test2','test2'),(36,'테스트 메일 제목입니다.','테스트 메일 내용입니다. 이곳에는 메일의 내용이 들어가죠.','N','2024-12-10 09:44:00','test2','test2'),(37,'테스트 메일 제목입니다.','테스트 메일 내용입니다. 이곳에는 메일의 내용이 들어가죠.','Y','2024-12-10 09:44:00','test2','test2'),(41,'반가워요','그냥 반갑다구요','Y','2024-12-10 09:57:00','test2','test1'),(42,'반가워요','그냥 반갑다구요','Y','2024-12-11 00:42:00','test1','test1'),(43,'반가워요','그냥 반갑다구요','N','2024-12-11 10:47:00','test2','test1'),(44,'반가워요','그냥 반갑다구요','N','2024-12-11 10:48:00','test2','test1'),(45,'하하이','High','N','2024-12-12 00:11:00','admin','id_07'),(48,'하이','이하이','Y','2024-12-12 00:12:00','id_03','id_07'),(49,'GG','GG','N','2024-12-12 01:30:00','id_06','id_03'),(50,'메롱','약오르지','Y','2024-12-13 03:26:00','id_03','id_02'),(51,'테스트','테스트','N','2024-12-13 05:51:00','id_06','id_03'),(52,'메일','내용','N','2024-12-13 05:53:00','id_06','id_03'),(53,'넌 누구냐','누구야','Y','2024-12-13 07:20:00','id_03','id_03'),(54,'반갑다','어 형이야','N','2024-12-13 07:20:00','id_07','id_03'),(55,'야','야임마','Y','2024-12-14 05:53:00','id_02','id_04'),(56,'ㅎㅇㅎㅇ','하잉','Y','2024-12-14 11:17:00','id_03','id_04'),(57,'내게 쓴 메일','오늘 할거 저장 : 점심은 제육볶음 먹고 퇴근 후에는 굶기','Y','2024-12-10 01:35:00','id_02','id_02'),(58,'안녕하세요 박민수 과장님','오늘도 즐거운 하루 되시길 바랍니다.','Y','2024-12-10 11:35:00','id_03','id_02'),(59,'김지훈입니다.','오늘도 힘내십시오! 화이팅!','N','2024-12-11 11:35:00','id_03','id_02'),(60,'김지훈입니다.','오늘도 힘내세용','N','2024-12-12 11:35:00','id_03','id_02'),(61,'박과장님','신입 교육은 언제까지 가면 되는겁니까?','N','2024-12-13 11:35:00','id_03','id_02'),(62,'윤정민 대리님','개발팀 강민준 사원이 오늘 조금 늦는다고 합니다.','N','2024-12-10 11:35:00','id_07','id_02'),(63,'윤정민 대리님','강민준 사원 너무 괴롭히지 마십쇼','N','2024-12-12 11:35:00','id_07','id_02'),(64,'홍민수 과장님도 홍박사님을 아세요?','홍홍홍','Y','2024-12-12 11:35:00','hong','id_02'),(65,'홍민수 과장님','어제 보낸 메일때문에 그러시는건가요?','Y','2024-12-13 11:35:00','hong','id_02'),(66,'홍민수 과장님 죄송합니다..','오늘 돼서 말하지만 홍과장님도 재미있어 하셨잖아요','Y','2024-12-14 11:35:00','hong','id_02'),(67,'나의 동기 민준아','민준아 담배피러 가자 ㄱㄱ','Y','2024-12-07 11:35:00','id_17','id_02'),(68,'민준민준','민준아 오늘 회식 가냐?','Y','2024-12-08 11:35:00','id_17','id_02'),(69,'어이 민준쓰','민준아 나 대신 일 좀 해줘라 ㅋㅋ','Y','2024-12-09 11:35:00','id_17','id_02'),(70,'오늘도 힘들다..','그러니까 오늘 술 ㄱ?','Y','2024-12-10 11:35:00','id_17','id_02'),(71,'민준아','민준아 이번 주 등산모임 가는거냐? 난 가기 싫은데','Y','2024-12-11 11:35:00','id_17','id_02'),(72,'한수진님','오늘 동기끼리 술 마시러 가실래요? 민준이도 간답니다.','Y','2024-12-10 11:37:00','id_09','id_02'),(73,'동기 한수진님','어제는 민준이 챙기느라 고생하셨습니다. 오늘도 화이팅 하십쇼','Y','2024-12-11 01:35:00','id_09','id_02'),(74,'담배 좀 끊어라','오늘만 피고 ㅋㅋ','Y','2024-12-07 11:36:00','id_02','id_17'),(75,'회식 안갑니다','오늘 퇴근부터 시켜주라..','Y','2024-12-08 11:37:00','id_02','id_17'),(76,'나도 힘든데','무슨 니 일까지 하냐 ㅋㅋ','Y','2024-12-09 11:37:00','id_02','id_17'),(77,'가자','술자리에 내가 빠지면 섭하지 ㅋㅋ 바로 간다','Y','2024-12-10 11:38:00','id_02','id_17'),(78,'등산모임?','ㄴㄴ 난 안갈건데?','N','2024-12-11 11:38:00','id_02','id_17'),(79,'김지훈님','그럴까요?','Y','2024-12-10 11:37:00','id_02','id_09'),(80,'저야말로..','저까지 챙기느라 고생 많으셨어요. 지훈님도 오늘 하루 힘내세용','N','2024-12-11 01:35:00','id_02','id_09'),(81,'뭐하는건가요?','이런 장난 좀 재미있네요. 그래도 회사 내 위계질서는 지켜주세요.','Y','2024-12-12 11:38:00','id_02','hong'),(82,'예의는 지켜주세요','지훈씨도 아시는 것 같은데 조심해주세요.','Y','2024-12-13 11:39:00','id_02','hong'),(83,'아니..','그렇긴한데.. 그래도 부탁드리는거잖아요..','Y','2024-12-14 11:39:00','id_02','hong'),(88,'나에게 쓰는 메일','메일 저장','Y','2024-12-14 12:53:00','id_02','id_02'),(91,'나에게 쓰는 메일','나한테 쓰는 메일','N','2024-12-14 13:03:00','id_02','id_02');
/*!40000 ALTER TABLE `email` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `email_file`
--

DROP TABLE IF EXISTS `email_file`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `email_file` (
  `mail_num` int(11) NOT NULL,
  `file_name` char(36) NOT NULL,
  `file_originname` varchar(30) NOT NULL,
  `file_size` int(11) NOT NULL,
  `upload_at` timestamp NOT NULL,
  PRIMARY KEY (`file_name`),
  KEY `email_mail_num_fk` (`mail_num`),
  CONSTRAINT `email_mail_num_fk` FOREIGN KEY (`mail_num`) REFERENCES `email` (`mail_num`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `email_file`
--

LOCK TABLES `email_file` WRITE;
/*!40000 ALTER TABLE `email_file` DISABLE KEYS */;
INSERT INTO `email_file` VALUES (49,'3470252d586f41748800482b66866dee.jpg','zx.jpg',576679,'2024-12-12 01:30:00'),(41,'371a17ea78414028b039da70210cf3aa.png','board.png',11259,'2024-12-10 09:57:00'),(44,'4cb978957e084a31a1a82da293a4f54b.png','ERD.png',628175,'2024-12-11 10:48:00'),(52,'68ac61a8312d403e8a04b0153e0d807f.jpg','zx.jpg',576679,'2024-12-13 05:53:00'),(88,'6f0c5386326d4e3caf13abb91b537207.png','mail.png',15363,'2024-12-14 12:53:00'),(42,'843a729997b3449cab1dcf233a5be71f.png','mokoko.png',175625,'2024-12-11 00:42:00'),(53,'9280899cd3f040b4bd2760fbaaecd738.jpg','zx.jpg',576679,'2024-12-13 07:20:00'),(48,'b6aed974adf744b3ade984d282068738.jpg','zx.jpg',576679,'2024-12-12 00:12:00'),(41,'e104b3d23de0423ba3e5a5fe0fa2be99.png','page.png',4363,'2024-12-10 09:57:00');
/*!40000 ALTER TABLE `email_file` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `emp_id` varchar(12) NOT NULL,
  `resident_num` char(14) NOT NULL,
  `emp_pass` varchar(20) NOT NULL,
  `emp_email` varchar(30) NOT NULL,
  `post_addr` varchar(20) NOT NULL,
  `road_addr` varchar(100) DEFAULT NULL,
  `detail_addr` varchar(30) NOT NULL,
  `role` varchar(5) NOT NULL CHECK (`role` in ('USER','ADMIN')),
  PRIMARY KEY (`emp_id`),
  KEY `fk_resident_num_manager` (`resident_num`),
  CONSTRAINT `fk_resident_num_manager` FOREIGN KEY (`resident_num`) REFERENCES `manager` (`resident_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES ('111','111111-7777777','111','111','111','111','111','USER'),('admin','111111-3333333','1234','admin@gmail.com','13480','경기 성남시 분당구 대왕판교로 477','103호','ADMIN'),('hong','333333-4444444','1234','hong59@gmail.com','13480','경기 성남시 분당구 대왕판교로 477','101호','USER'),('id_01','000000-2222222','1234','yuanzhenhao59@gmail.com','16410','수원시 인계동','102호','USER'),('id_02','000001-1111112','1234','yuanzhenhao02@gmail.com','17540','수원시 권선동','201호','USER'),('id_03','000002-1111113','qwerty!@#','yuanzhenhao03@gmail.com','18450','수원시 팔달구','305호','USER'),('id_04','000003-1111114','hello@2024','yuanzhenhao04@gmail.com','19200','수원시 장안구','401호','USER'),('id_05','000004-1111115','secure!234','yuanzhenhao05@gmail.com','17800','수원시 매교동','101호','USER'),('id_06','000005-1111116','!passkey12','yuanzhenhao06@gmail.com','16500','수원시 고등동','103호','USER'),('id_07','000006-1111117','safe@#123','yuanzhenhao07@gmail.com','16200','수원시 세류동','202호','USER'),('id_08','000007-1111118','lock@123!','yuanzhenhao08@gmail.com','16300','수원시 화서동','304호','USER'),('id_09','000008-1111119','key123!@#','yuanzhenhao09@gmail.com','18000','수원시 우만동','403호','USER'),('id_10','000009-1111120','my!secure','yuanzhenhao10@gmail.com','17750','수원시 권선동','110호','USER'),('id_11','000010-1111121','unique@123','yuanzhenhao11@gmail.com','16450','수원시 인계동','502호','USER'),('id_12','000011-1111122','random@pass','yuanzhenhao12@gmail.com','17600','수원시 매산동','303호','USER'),('id_13','000012-1111123','myCode!123','yuanzhenhao13@gmail.com','16700','수원시 팔달동','408호','USER'),('id_14','000013-1111124','alpha@1234','yuanzhenhao14@gmail.com','16900','수원시 영통구','204호','USER'),('id_15','000014-1111125','bravo@5678','yuanzhenhao15@gmail.com','18200','수원시 광교동','309호','USER'),('id_16','000015-1111126','charlie@!89','yuanzhenhao16@gmail.com','16650','수원시 정자동','507호','USER'),('id_17','000016-1111127','delta#7890','yuanzhenhao17@gmail.com','17050','수원시 파장동','606호','USER'),('id_18','000017-1111128','echo$0123','yuanzhenhao18@gmail.com','18300','수원시 매탄동','205호','USER'),('id_19','000018-1111129','foxtrot@098','yuanzhenhao19@gmail.com','16100','수원시 신동','304호','USER'),('jinho0812','990012-1112222','yuanzhenhao123!@#','yuanzhenhao59@gmail.com','13529','경기 성남시 분당구 분당내곡로 117','102호','USER'),('leesumin','323232-1111111','qwe123!@#','yuanzhenhao59@gmail.com','52550','경남 사천시 주공1길 7','102호','USER'),('mingun','950803-1152321','aaa123!@#','yuanzhenhao59@gmail.com','61627','광주 남구 수원지길 2','101호','USER'),('test1','001111-1234567','1234','test1@gmail.com','16471','경기 수원시 팔달구 중부대로 100','3층','USER'),('test2','001212-2345678','1234','test2@gmail.com','16471','경기 수원시 팔달구 중부대로 100','4층','USER'),('wwww','981111-1152425','www123!@#','www@gmail.com','13479','경기 성남시 분당구 서판교로 32','102호','USER');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `manager`
--

DROP TABLE IF EXISTS `manager`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `manager` (
  `resident_num` char(14) NOT NULL,
  `emp_name` varchar(8) NOT NULL,
  `emp_dept` varchar(10) NOT NULL,
  `emp_rank` varchar(5) NOT NULL,
  `join_date` date NOT NULL,
  `work_status` varchar(20) NOT NULL CHECK (`work_status` in ('재직중','퇴사')),
  PRIMARY KEY (`resident_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manager`
--

LOCK TABLES `manager` WRITE;
/*!40000 ALTER TABLE `manager` DISABLE KEYS */;
INSERT INTO `manager` VALUES ('000000-2222222','원진호','영업팀','인턴','2024-12-20','퇴사'),('000001-1111112','김지훈','개발팀','사원','2024-12-02','재직중'),('000002-1111113','박민수','인사팀','과장','2024-11-30','퇴사'),('000003-1111114','이서연','영업팀','대리','2025-01-10','퇴사'),('000004-1111115','정예린','회계팀','팀장','2024-12-01','재직중'),('000005-1111116','최동훈','영업팀','사원','2024-10-20','재직중'),('000006-1111117','윤정민','개발팀','대리','2025-03-05','재직중'),('000007-1111118','조윤아','영업팀','과장','2024-08-12','재직중'),('000008-1111119','한수진','인사팀','사원','2024-12-02','재직중'),('000009-1111120','임도현','회계팀','대리','2025-02-25','재직중'),('000010-1111121','김영훈','영업팀','인턴','2025-04-18','재직중'),('000011-1111122','송지우','개발팀','사원','2024-09-10','재직중'),('000012-1111123','권민아','인사팀','과장','2024-06-15','재직중'),('000013-1111124','이하윤','영업팀','대리','2025-01-01','재직중'),('000014-1111125','정시우','회계팀','사원','2024-12-22','재직중'),('000015-1111126','황준호','영업팀','팀장','2024-11-01','재직중'),('000016-1111127','강민준','개발팀','사원','2024-12-02','재직중'),('000017-1111128','이수진','영업팀','과장','2025-02-15','재직중'),('000018-1111129','박서현','인사팀','대리','2024-05-30','재직중'),('001111-1234567','김테스트','인사팀','사원','2024-12-10','재직중'),('001212-2345678','박테스트','인사팀','사원','2024-12-10','재직중'),('111111-3333333','관리자','인사팀','과장','2024-12-05','재직중'),('111111-7777777','홍민수','기술팀','과장','2024-12-05','퇴사'),('123455-7954121','새우맨','영업팀','대리','2024-12-10','퇴사'),('323232-1111111','이수민','기술팀','과장','2024-12-05','재직중'),('333333-4444444','홍민수','기술팀','과장','2024-12-05','재직중'),('676767-1111111','박민호','인사팀','과장','2024-12-05','재직중'),('887788-0000000','최진호','기술팀','과장','2024-12-05','재직중'),('950803-1152321','최민권','인사팀','팀장','2024-12-14','재직중'),('970613-1131416','최진민','인사팀','팀장','2024-12-14','재직중'),('990920-1162327','최아름','기술팀','팀장','2024-12-14','재직중');
/*!40000 ALTER TABLE `manager` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personal_task`
--

DROP TABLE IF EXISTS `personal_task`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `personal_task` (
  `task_num` int(11) NOT NULL AUTO_INCREMENT,
  `task_title` varchar(20) NOT NULL,
  `task_content` varchar(255) DEFAULT NULL,
  `task_status` char(2) NOT NULL DEFAULT '진행' CHECK (`task_status` in ('진행','완료')),
  `create_at` timestamp NULL DEFAULT current_timestamp(),
  `receive_id` varchar(12) NOT NULL,
  `directive_id` varchar(12) NOT NULL,
  PRIMARY KEY (`task_num`),
  KEY `task_receive_id_fk` (`receive_id`),
  KEY `task_directive_id_fk` (`directive_id`),
  CONSTRAINT `task_directive_id_fk` FOREIGN KEY (`directive_id`) REFERENCES `employee` (`emp_id`),
  CONSTRAINT `task_receive_id_fk` FOREIGN KEY (`receive_id`) REFERENCES `employee` (`emp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personal_task`
--

LOCK TABLES `personal_task` WRITE;
/*!40000 ALTER TABLE `personal_task` DISABLE KEYS */;
INSERT INTO `personal_task` VALUES (1,'PPT 초안','고객사에 보낼 PPT 초안입니다.','진행','2024-11-27 00:00:00','id_02','id_03'),(2,'OO건설 데이터 분석','데이터 분석 요청입니다.','진행','2024-12-01 05:54:11','id_02','id_09'),(3,'프로젝트 기획안','다음주에 프로젝트 논의가 있을 예정이니 부탁드립니다.','진행','2024-12-07 05:54:11','id_02','id_01'),(4,'프로그램 컨설팅','개발자분과 직접 대화하고 진행하고 싶다고 합니다.','완료','2024-12-09 05:54:11','id_02','id_01'),(5,'고객 요구사항','OO회사 고객님 요구사항입니다.','진행','2024-12-10 05:59:34','id_01','id_06'),(6,'IT 마케팅','마케팅 직접 참여해주시길 바랍니다.','진행','2024-12-11 05:59:34','id_02','id_01'),(7,'IT 박람회 참여','저희 회사가 이번 박람회에 참여하게 되었습니다. 참여하실 인원분들은 이메일을 보내드립니다. 참여 일시는 2024년 12월 30일입니다.','완료','2024-12-12 05:59:34','id_02','id_04'),(8,'프로그램 보수','OO회사 OO프로그램 유지보수 부탁드립니다.','진행','2024-12-13 06:03:35','id_02','id_08'),(9,'시스템 업데이트','업데이트가 필요한 부분이 있어 보냅니다.','완료','2024-12-13 07:05:00','id_02','id_05'),(10,'협력사 미팅','다음주에 OO회사와 미팅 있습니다.','완료','2024-12-13 08:04:30','id_02','id_03');
/*!40000 ALTER TABLE `personal_task` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sequences`
--

DROP TABLE IF EXISTS `sequences`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sequences` (
  `name` varchar(30) NOT NULL,
  `currval` bigint(20) unsigned DEFAULT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sequences`
--

LOCK TABLES `sequences` WRITE;
/*!40000 ALTER TABLE `sequences` DISABLE KEYS */;
INSERT INTO `sequences` VALUES ('board_seq',43),('board_seq_fr',47),('comment_seq',36),('email_seq',92);
/*!40000 ALTER TABLE `sequences` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `task_file`
--

DROP TABLE IF EXISTS `task_file`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `task_file` (
  `task_num` int(11) NOT NULL,
  `file_name` char(36) NOT NULL,
  `file_originname` varchar(20) NOT NULL,
  `upload_at` timestamp NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`file_name`),
  KEY `task_task_num_fk` (`task_num`),
  CONSTRAINT `task_task_num_fk` FOREIGN KEY (`task_num`) REFERENCES `personal_task` (`task_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task_file`
--

LOCK TABLES `task_file` WRITE;
/*!40000 ALTER TABLE `task_file` DISABLE KEYS */;
/*!40000 ALTER TABLE `task_file` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `test`
--

DROP TABLE IF EXISTS `test`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `test` (
  `num` int(11) DEFAULT NULL,
  `name` varchar(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `test`
--

LOCK TABLES `test` WRITE;
/*!40000 ALTER TABLE `test` DISABLE KEYS */;
INSERT INTO `test` VALUES (2,'테스트1');
/*!40000 ALTER TABLE `test` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'cis_finalproject'
--

--
-- Dumping routines for database 'cis_finalproject'
--
/*!50003 DROP FUNCTION IF EXISTS `cis_seq` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`cis`@`192.168.0.%` FUNCTION `cis_seq`(seq_name VARCHAR(32)) RETURNS bigint(20) unsigned
    MODIFIES SQL DATA
    DETERMINISTIC
BEGIN
	DECLARE ret BIGINT UNSIGNED;
	UPDATE sequences SET currval=currval+1 WHERE name=seq_name;
	SELECT currval INTO ret FROM sequences WHERE name=seq_name LIMIT 1;
	RETURN ret;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `create_seq` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`cis`@`192.168.0.%` PROCEDURE `create_seq`(IN seq_name text)
    MODIFIES SQL DATA
    DETERMINISTIC
BEGIN
	DELETE FROM sequences WHERE name=seq_name;
	INSERT INTO sequences VALUES (seq_name, 0);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-12-14 22:31:13
