# Exercise Diary Project

-------------

## :running: 운동 일기장

요즘 밖에 나가긴 무섭고 집에만 있자니 답답하시죠? 

운동 일기장을 통해 목적을 이루고 스트레스를 날리세요!

-------------

## :information_desk_person: 프로젝트 소개
* :mag: 회원가입을 통해 원하는 운동 선택이 가능합니다.
* :mag: 로그인을 성공하면 모든 운동 프로그램을 볼 수 있습니다.
* :mag: 자신이 원하는 운동을 선택하여 운동한 후 운동 일기장을 작성 가능합니다. 
* :mag: 운동 목적이 변하여 다른 목적을 통해 운동하고 싶다면 마이 페이지에서 변경 가능합니다.

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
2. 로그인
3. 메인 (유튜버, 채널 검색)
    * 유튜브 추천 list
4. 운동 디테일
    * 유튜브 링크 연결
5. 일기작성 ((보류)일기 작성시 시청했던 운동의 프로그램명 검색후 프로그램 번호로 저장)
    * 일기 CRUD 
        * C : 일기 작성
        * R : 프로그램 검색시 해당 영상을 보고 운동했던 날의 일기 검색
        * U : 일기 수정
        * D : 일기 삭제
6. 일기 디테일
7. 일기 리스트
8. 마이페이지(회원정보수정)
    * 목적 수정

-------------------

## :two_women_holding_hands: CO - AUTHORS

* 최지수 [(JisooChoi)](https://github.com/choijisoo-94)
* 박다영 [(DayoungPark)](https://github.com/Da-0)
* 박민영 [(MinyoungPark)](https://github.com/minyoung-park)

------------------
## :sparkles: Team Issues

* 타 프로젝트를 할 때보다 WEB에서 많은 에러가 나서 진행이 늦어졌고, 구현하려던 CRUD 를 부분적으로 완성시키지 못한 점이 아쉬웠다.
*
*

------------------

## :bulb: References

* 엑셀 데이터 값 참고 : https://docs.google.com/spreadsheets/d/1Wd1iWMgHv1M3Js6eivVqQLa8NnXEUmkDi_J6qhA7qHE/edit?usp=sharing 
* 오븐 앱 : https://ovenapp.io/view/XRvSHiCrtm4xgrfSSyI10tSUa14wV0Lw/fV7Lz
* ERD CLOUD : https://www.erdcloud.com/d/ERGqnY8qjTShkzJcq