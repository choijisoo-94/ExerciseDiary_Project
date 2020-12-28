DROP TABLE purpose cascade constraint;

DROP TABLE youtube cascade constraint;

DROP TABLE users cascade constraint;

DROP TABLE video cascade constraint;

DROP TABLE diary cascade constraint;


CREATE TABLE purpose (
	purpose	VARCHAR2(20)	PRIMARY KEY
);

CREATE TABLE youtube (
	channel	VARCHAR2(50)	PRIMARY KEY,
	youtuber	VARCHAR2(20)	NOT NULL
);

CREATE TABLE users (
	user_id	VARCHAR2(20)	PRIMARY KEY,
	user_password	VARCHAR2(50)	NOT NULL,
	user_name	VARCHAR2(50)	NOT NULL,
	user_gender	VARCHAR2(20)	NOT NULL,
	user_age	VARCHAR2(20)	NOT NULL,
	user_height	VARCHAR2(20)	NOT NULL,
	user_weight	VARCHAR2(20)	NOT NULL,
	purpose	VARCHAR2(20)	NOT NULL
);

CREATE TABLE video (
	program_no	VARCHAR(20)	PRIMARY KEY,
	playlist	VARCHAR2(200)	NOT NULL,
	youtube_url	VARCHAR2(1000)	NOT NULL,
	channel	VARCHAR2(50)	NOT NULL,
	purpose	VARCHAR2(20)	NOT NULL
);

CREATE TABLE diary (
	diary_no	VARCHAR2(20)	PRIMARY KEY,
	diary_title	VARCHAR2(50)	NOT NULL,
	diary_content	VARCHAR2(200)	NOT NULL,
	write_date	DATE NOT NULL,
	today_weight	VARCHAR2(20)	NOT NULL,
	user_id	VARCHAR2(20)	NOT NULL,
	purpose	VARCHAR2(20)	NOT NULL,
	program_no	VARCHAR(20)	NOT NULL
);

ALTER TABLE users ADD CONSTRAINT FK_purpose_TO_users_1 FOREIGN KEY (
	purpose
)
REFERENCES purpose (
	purpose
);

ALTER TABLE diary ADD CONSTRAINT FK_users_TO_diary_1 FOREIGN KEY (
	user_id
)
REFERENCES users (
	user_id
);

ALTER TABLE diary ADD CONSTRAINT FK_purpose_TO_diary_1 FOREIGN KEY (
	purpose
)
REFERENCES purpose (
	purpose
);

ALTER TABLE diary ADD CONSTRAINT FK_video_TO_diary_1 FOREIGN KEY (
	program_no
)
REFERENCES video (
	program_no
);

ALTER TABLE video ADD CONSTRAINT FK_youtube_TO_video_1 FOREIGN KEY (
	channel
)
REFERENCES youtube (
	channel
);

ALTER TABLE video ADD CONSTRAINT FK_purpose_TO_video_1 FOREIGN KEY (
	purpose
)
REFERENCES purpose (
	purpose
);

