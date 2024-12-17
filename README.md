# SPRING BOOT와 SLACK을 연동하여 알람봇 만들기

## 프로젝트 목적
 - 목표: Spring Boot와 Spring Security를 기반으로 한 로그인 및 회원 관리 시스템입니다. Slack API를 활용하여 출퇴근 시간, 일정 알림 등을 Slack으로 전송하며, 권한별 접근 제어 및 유저 관리를 제공합니다.
 - 주요 기능: 스프링 시큐리티를 이용한 로그인 회원관리, 출퇴근 및 일정 알람봇
 - 개발 기간: 24.11.21 ~ 24.12.05 (2주)
 - 개발 인원: 개인프로젝트

## 프로젝트 결과
 - Spring Security를 이용하여 로그인, 회원 관리
   - 회원가입, 로그인 페이지 외에는 로그인없이 접속 불가
   - 로그인 유저별 권한 분리: USER, ADMIN
   - 가입된 유저도 ADMIN의 승인없이는 로그인 불가
     
 - ADMIN 전용 유저 관리 페이지
   - 가입한 유저의 로그인 승인 및 승인 취소
     
 - Slack API 연동
   - 출근시 slack으로 유저의 출근 시간 전송
   - 퇴근시 유저의 퇴근 시간 및 총 근무시간 전송
   - 일정 등록시 slack으로 일정 알림 전송
   - 스케줄링: 매일 정각마다 등록된 일정 Slack 알림 전송
     
 - 글로벌 예외 처리
   - 권한 부족, 404 에러, 인증 관련 오류에 대한 예외 처리

## 파일구조
    slackproject/
    ├── src/
    │ ├── main/
    │ │ ├── java/
    │ │ │ └── com/
    │ │ │  └── example/
    │ │ │   └── slackproject/
    │ │ │    ├── controller/
    │ │ │    ├── service/
    │ │ │    ├── config/
    │ │ │    ├── Exception/
    │ │ │    └── dto/
    │ │ ├── resources/
    │ │ │ ├── mybatis/
    │ │ │ ├── static/
    │ │ │ ├── templates/
    │ │ │ └── application.properties
    │ ├── webapp/
    │ │ └── WEB-INF/
    │ │   └── views/
    │ └── test/
    ├── .gitignore
    ├── mvnw
    ├── mvnw.cmd
    ├── pom.xml
    └── README.md

## 기술 스택
 - Environment
   - Framework: Spring Boot
   - Database: Oracle
   - API Integration: Slack API
   - Version Control: Git, GitHub

 - Config
   - Security: Spring Security
 
 - Development
   - Frontend: jQuery, JSP, AJAX
