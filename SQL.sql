
/*DROP TABLE TEACHER;
DROP TABLE PUPIL;
DROP TABLE SUBJECT;
DROP TABLE CLASSES;
*/

CREATE TABLE CLASSES (
     CLASS_ID NUMBER(6),
     CLASS_NAME VARCHAR(20),
     constraint classes_class_id_pk PRIMARY KEY(CLASS_ID)
       
);

--insert into classes values(1,'First Class');
--insert into classes values(2,'Second Class');
--insert into classes values(3,'Third Class');





CREATE TABLE SUBJECT (
     SUBJECT_ID NUMBER(6),
     SUBJECT_NAME VARCHAR(20),
     CLASS_ID NUMBER(6),
     constraint subject_subject_id_pk PRIMARY KEY(SUBJECT_ID),
     constraint subject_class_id_fk FOREIGN KEY(CLASS_ID) REFERENCES CLASSES(CLASS_ID)
);

--insert into SUBJECT values(10,'Math',1);
--insert into SUBJECT values(11,'Chemistry',1);
--insert into SUBJECT values(20,'English',2);


 CREATE TABLE TEACHER (
    FIRST_NAME VARCHAR(10),
    LAST_NAME VARCHAR(20),
    GENDER VARCHAR(10),
    SUBJECT_ID NUMBER(6),
    constraint teacher_subject_id_fk FOREIGN KEY(SUBJECT_ID) REFERENCES SUBJECT(SUBJECT_ID)
);

--insert into teacher values('Nana','Ghelekva','Female',20);
--insert into teacher values('Nana','Ghelekva','Female',11);
--insert into teacher values('Levan','Shashikadze','Male',10);



CREATE TABLE PUPIL (
    FIRST_NAME VARCHAR(10),
    LAST_NAME VARCHAR(20),
    GENDER VARCHAR(6),
    CLASS_ID NUMBER(6),
    constraint pupil_class_id_fk FOREIGN KEY(CLASS_ID) REFERENCES CLASSES(CLASS_ID)
);

--insert into pupil values('Megi','Shashikadze','Female',1);
--insert into pupil values('Giorgi','Shashikadze','Male',1);
--insert into pupil values('Lizi','Shashikadze','Female',2);



select t.first_name,t.last_name from pupil p
   join classes s on p.class_id = s.class_id
   join subject sub on s.class_id = sub.class_id
   join teacher t on sub.subject_id = t.subject_id
   where p.first_name = 'Giorgi';
    

     
