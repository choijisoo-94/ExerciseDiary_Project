-- purpose insert
insert into purpose values ('다이어트');
insert into purpose values ('근육량 증가');
insert into purpose values ('체형관리');

-- youtube insert
insert into youtube values ('Dano TV','Dano');
insert into youtube values ('에이핏 afit', '라희');
insert into youtube values ('말왕TV', '말왕');
insert into youtube values ('지피티', '지피티');
insert into youtube values ('힙으뜸', '심으뜸');
insert into youtube values ('피지컬갤러리', '김계란');

-- user insert
insert into users values ('user111','user1234','최지수','F','27','160','55','근육량 증가');

-- video insert
insert into video values ('v_1','올인원 운동/급찐급빠/유산소/앉아서하는운동','https://www.youtube.com/playlist?list=PLvJb0LzWxpUsOvxIeHwWI05Snq7rkykmY','Dano TV','다이어트');
insert into video values ('v_2','전신/하체/상체/비키니','https://www.youtube.com/playlist?list=PLvJb0LzWxpUvB_O0E6Emcq8ZFc4B4vE0M','Dano TV','다이어트');
insert into video values ('v_3','스트레칭/하체/뱃살/전신운동','https://www.youtube.com/playlist?list=PLvJb0LzWxpUskFHwQ_5VTwhLqPnrjYYRZ','Dano TV','다이어트');
insert into video values ('v_4','타바타운동','https://www.youtube.com/playlist?list=PLh3n0CQkj2Tc1BeaNAmelxc0lnK2Thqnj','에이핏 afit','다이어트');
insert into video values ('v_5','댄스 유산소','https://www.youtube.com/playlist?list=PLh3n0CQkj2TdQ8ew8466vgwZB-P6AMgxN','에이핏 afit','다이어트');
insert into video values ('v_6','고강도 인터벌 트레이닝','https://www.youtube.com/playlist?list=PLh3n0CQkj2TdO_R7mtzEGp1MMNNhsP3S2','에이핏 afit','다이어트');
insert into video values ('v_7','말왕의 믿고보는 운동강의','https://www.youtube.com/watch?v=WaWxwZl-U9Q&list=PLW9IOmh5rOAoXmlbOVG34L3nTuFYln8Pe','말왕TV','근육량 증가');
insert into video values ('v_8','여성 헬스 가이드','https://www.youtube.com/watch?v=Lp2hUiUCX0s&list=PLW9IOmh5rOAp_z1J7oMYDqM9hzUjscCmg','말왕TV','근육량 증가');
insert into video values ('v_9','세상에 나쁜 뚱뚱이는 없다','https://www.youtube.com/playlist?list=PLW9IOmh5rOAqIJH2svsPmRMg2-p1gZy7G','말왕TV','근육량 증가');
insert into video values ('v_10','헬창커플','https://www.youtube.com/playlist?list=PLUL8g4XeMfphFiXEFx9uMxAXbU5qKn5PJ','지피티','근육량 증가');
insert into video values ('v_11','멸치탈출 프로젝트','https://www.youtube.com/playlist?list=PLUL8g4XeMfpgfGOrO6vi1lD_v2pKhQ_Nw','지피티','근육량 증가');
insert into video values ('v_12','운동강의','https://www.youtube.com/playlist?list=PLUL8g4XeMfpiq_HkfwP9UXjt4Ek92i-2_','지피티','근육량 증가');
insert into video values ('v_13','운동의 정석','https://www.youtube.com/watch?v=vQNFiMi0m9M&list=PL59wN1Mv0vQe5e31bDp_3vLKKphkHls9L','힙으뜸','체형관리');
insert into video values ('v_14','집에서 필라테스','https://www.youtube.com/watch?v=RWcCaSzueB4&list=PL59wN1Mv0vQdMbdjXByfcsKNKfn_DuFF7','힙으뜸','체형관리');
insert into video values ('v_15','홈트레이닝','https://www.youtube.com/watch?v=RWcCaSzueB4&list=PL59wN1Mv0vQdEBnwW4V0wzLVrm8cT2KLF','힙으뜸','체형관리');
insert into video values ('v_16','체형교정 루틴','https://www.youtube.com/playlist?list=PLA92lMlT0Ro-F1iiJ945d7y7DBL6fAOPZ','피지컬갤러리','체형관리');
insert into video values ('v_17','스트레칭 꿀팁/루틴','https://www.youtube.com/playlist?list=PLA92lMlT0Ro97oShs3v-I5AqRFQr7kacw','피지컬갤러리','체형관리');
insert into video values ('v_18','재활운동/스트레칭/꿀팁','https://www.youtube.com/playlist?list=PLA92lMlT0Ro97oShs3v-I5AqRFQr7kacw','피지컬갤러리','체형관리');

-- diary insert
insert into diary values ('d_1','오늘부터 운동시작!','ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ...이하생략','2020-12-28','59','user111','다이어트','v_3');

commit;
