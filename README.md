# SPRING BOOT와 SLACK을 연동하여 알람봇 만들기

## 프로젝트 목적
 - 목표: SPRING BOOT에 Slack Api 연동하여 일정 알림봇을 만들고 그 일정을 채널에서 공유되도록 구현하는 것을 목표로 했습니다.
 - 주요 기능: 스프링 시큐리티를 이용한 로그인 회원관리, 출퇴근 및 일정 알람봇
 - 개발 기간: 24.11.21 ~ 24.12.05 (2주)
 - 개발 인원: 개인프로젝트

## 프로젝트 결과
 - Spring Security를 이용하여 로그인, 회원 관리
 - 회원가입, 로그인 페이지 외에는 로그인없이 접속 불가
 - 로그인 유저별 권한 분리 (USER, ADMIN)
 - 가입된 유저도 ADMIN의 승인없이는 로그인 불가
 - 유저관리 페이지는 ADMIN 권한을 가진 유저만 접속 가능, 가입한 유저의 로그인을 승인 및 승인취소 가능
 - 출근시 slack으로 유저의 출근시간, 퇴근시 유저의 퇴근시간과 총 근무시간 전송
 - 일정 등록시 등록된 일정을 slack으로 알림 전송
 - 스케줄링을 이용해 매일 정각마다 등록된 일정이 있는지 확인 후 slack으로 일정 알림 전송
 - 글로벌 예외처리를 구현하여 권한부족, 404에러, 인증관련 오류 예외처리

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
 <div>
    <img src="https://img.shields.io/badge/springboot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white">
    <img src="https://img.shields.io/badge/Oracle-F80000?style=for-the-badge&logo=oracle&logoColor=white">
    <img src="https://img.shields.io/badge/Slack-4A154B?style=for-the-badge&logo=slack&logoColor=white">
 </div>

 - Config
 <div>
    <img src="https://img.shields.io/badge/Spring Security-6DB33F?style=for-the-badge&logo=Spring Security&logoColor=white">
 </div>
 
 - Development
 <div>
    <img src="https://img.shields.io/badge/jquery-%230769AD.svg?style=for-the-badge&logo=jquery&logoColor=white">
 </div>
