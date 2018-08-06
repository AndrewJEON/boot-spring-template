# Boot Based Spring Template #


### 이 저장소는? ###

* Boot Based Spring Template으로 Spring Boot를 사용한 기본 Spring Template


### 설정방법? ###

* 필요사항
    * Spring Boot 2
    * Maven 프로젝트
    * lombok 사용
    * Java: jdk 1.8
    * WAS: Embedded taomcat
    * MySQL 사용

* 주요 사항
    * Spring Boot 기반으로 작성된 Template
    * Javabase Configuration Spring Template과 비슷한 구성을 맞추려고 노력함.
    * 일부 Util성 소스는 Javabased Configuration Spring Template에서 이관해옴.

* 주요 종속성
    * Spring framework: Spring Boot 2.0.4.RELEASE
    * apache: httpcore, httpclient, httpasyncclient, httpmime, commons-lang3, commons-io, commons-fileupload, dbcp2
    * Joda Time
    * Jackson: core, databind, annotations, datatype-joda, dataformat-xml, datatype-guava
    * google: gson, guava
    * mybatis
    * Unirest: 1.4.9
    * 그외 지속적 추가 예정.

* Database configuration
    * Local DB
        * Server : localhost
        * Port : 3306
        * Database : testdb
        * User : dev
        * Password : 1q2w3e$R

<br />

* Profile 설정
    * 로컬환경 > spring.profiles.active = local
    * 개발환경 > spring.profiles.active = development
    * 운영환경 > spring.profiles.active = production

### 향후 추가 예상 내용? ###
* Auth(JWT: https://jwt.io/)
* Mongo DB default 설정
* Redis default 설정
* Swagger
* Google analytics: https://marketingplatform.google.com
* ELK: ElasticSearch, LogStash, Kibana
* 그 외 기타등등

### 연락처 ###

* 정성현 <hashmap27@gmail.com> or <public27@naver.com>
