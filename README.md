# Exercise Diary Project

-------------

## :running: 운동 일기장

요즘 밖에 나가긴 무섭고 집에만 있자니 답답하시죠? 

운동 일기장을 통해 목적을 이루고 스트레스를 날리세요!

-------------

## :information_desk_person: 프로젝트 소개
* :mag: **회원가입**을 통해 **원하는 운동 선택**이 가능합니다.
* :mag: 로그인을 성공하면 **모든 운동 프로그램**을 볼 수 있습니다.
* :mag: 자신이 **원하는 운동을 선택**하여 운동한 후 **운동 일기장을 작성 가능**합니다. 
* :mag: 운동 목적이 변하여 **다른 목적을 통해 운동**하고 싶다면 **마이 페이지에서 변경** 가능합니다.

-------------

## :couple: 운동 일기장 프로젝트 관계도 설정

![화면 캡처 2020-12-29 053422](https://user-images.githubusercontent.com/73863771/103255649-7382b000-49cd-11eb-874c-421c5ec6dc5b.png)

--------------

## :page_facing_up: 테이블 설명

### :point_right: user table
* **user_id(PK)**
* user_password
* user_name
* user_gender
* user_age
* user_height
* user_weight
* purpose


### :point_right: youtube table
* **channer(PK)**
* youtuber


### :point_right: diary table
* **diary_no(PK)**
* diary_title
* diary_content
* write_date
* today_weight
* user_id
* purpose
* program_no


### :point_right: video table
* **program_no(PK)**
* playlist
* youtube_url
* youtuber
* channel
* purpose

### :point_right: purpose table
* **purpose(PK)**

--------------

## :scroll: 이 프로젝트의 기술 구현 방식

1. 회원가입
    * C : 유저 정보 작성
    * R : 유저 정보 검색
    * U : 유저 운동 목적 수정
    * D : 유저 탈퇴
2. 로그인
3. 메인 (유튜버, 채널 검색)
    * R : 모든 영상 리스트 출력
    * R : 운동 목적별 리스트 출력
4. 일기작성 ((보류)일기 작성시 시청했던 운동의 프로그램명 검색후 프로그램 번호로 저장)
    * 일기 CRUD 
        * C : 일기 작성
        * R : 프로그램 검색시 해당 영상을 보고 운동했던 날의 일기 검색
        * U : 일기 수정
        * D : 일기 삭제
5. 일기 디테일
    * R : 해당 일기 검색
    * D : 일기 삭제
6. 일기 리스트
    * R : 일기 전체 검색

-------------------

## :two_women_holding_hands: CO - AUTHORS

* 최지수 [(JisooChoi)](https://github.com/choijisoo-94)
* 박다영 [(DayoungPark)](https://github.com/Da-0)
* 박민영 [(MinyoungPark)](https://github.com/minyoung-park)

------------------
## :sparkles: Team Issues

* :eyes: 공통 이슈

    * 목적테이블을 만드는 부분에서 관계도 형성에 많은 고민을 했습니다.
    * ERD CLOUD 를 짜는 과정에서 ddl문에 의존하다가 시간을 소비한 점이 아쉬웠습니다.
    * entity 설계 시 joincoloum과 mappedby에 대해 고민해야 해서 많은 시간을 소요했습니다. 
    * ID 와 PASSWORD 를 확인하는 과정이 어느 부분에 들어가야 하는지 고민하는 시간이 길었습니다.
    * ECLIPSE상의 오라클 XE 자동 생성 과정에서 알수없는 에러들이 많아서 오래 고민했습니다.

-------------------

## :bulb: 각 팀원들의 느낀 점

* :woman: jisoo : 타 프로젝트를 할 때보다 WEB에서 많은 에러가 나서 진행이 늦어졌고, 구현하려던 CRUD 를 부분적으로 완성시키지 못한 점이 아쉬웠다.

* :man: minyoung : web이 아직 덜 이해되어있는 상태로 작업하다보니 뭐가뭔지 모르고 개인적으론 mvc패턴이 갑자기 헷갈리기 시작했습니다. web에 대해 공부를 더 해야할 것 같습니다.

* :woman: dayoung : 시간이 촉박하여 적어도 완성에 가까운 결과물을 내야한다는 부담감에 클린코드는 물론, 예외처리까지도 신경을 못쓴게 가장 아쉬웠습니다. 다음 프로젝트에서는 일의 우선순위를 정해놓고 조금 더 체계적으로, 효율적으로 해야겠다는 생각을 했습니다.


------------------

## :bulb: References

* 엑셀 데이터 값 참고 : https://docs.google.com/spreadsheets/d/1Wd1iWMgHv1M3Js6eivVqQLa8NnXEUmkDi_J6qhA7qHE/edit?usp=sharing 
* 오븐 앱 : https://ovenapp.io/view/XRvSHiCrtm4xgrfSSyI10tSUa14wV0Lw/fV7Lz
* ERD CLOUD : https://www.erdcloud.com/d/ERGqnY8qjTShkzJcq