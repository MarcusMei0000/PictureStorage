INSERT INTO "Artist"("last_name","first_name","patronymic_name","country") VALUES ('Полякова', 'Полина','Геннадиевна','Россия');

INSERT INTO "Artist"("last_name","first_name", "patronymic_name","country") VALUES ('Скибин', 'Денис','Дмитриевич','Чехия');

INSERT INTO "Artist"("last_name","first_name", "patronymic_name","country") VALUES ('Назаренко', 'Татьяна','Владимировна','Латвия');

INSERT INTO "Artist"("last_name","first_name","patronymic_name","country") VALUES ('Зверев', 'Константин','Алексеевич','Эстония');

INSERT INTO "Artist"("last_name","first_name","patronymic_name","country") VALUES ('Зверев', 'Алексей','Адольфович','Колумбия');

INSERT INTO "Artist"("last_name","first_name","patronymic_name","country") VALUES ('Ильюшенко', 'Михаил','Дмитриевич','Австралия');

INSERT INTO "Artist"("last_name","first_name","patronymic_name","country") VALUES ('Ковтун', 'Альбина','Геннадиевна','Англия');

INSERT INTO "Artist"("last_name","first_name","patronymic_name","country") VALUES ('Поляков', 'Геннадий','Александрович','Россия');

INSERT INTO "Artist"("last_name","first_name","patronymic_name","country") VALUES ('Борисенко', 'Карина','Валерьевна','Грузия');

SELECT * FROM "Artist";

INSERT INTO "Picture"("name", "date_of_painting", "id_artist") 
VALUES ('Утро в сосновом лесу', '1859-01-01', (SELECT id_artist
        FROM "Artist"
        WHERE last_name = 'Полякова'));
		
INSERT INTO "Picture"("name", "date_of_painting", "id_artist") 
VALUES ('Рожь', '1860-01-01', (SELECT id_artist
        FROM "Artist"
        WHERE last_name = 'Полякова'));
		
INSERT INTO "Picture"("name", "date_of_painting", "id_artist") 
VALUES ('Одинокая сосна', '1870-01-01', (SELECT id_artist
        FROM "Artist"
        WHERE last_name = 'Полякова'));
		
INSERT INTO "Picture"("name", "date_of_painting", "id_artist") 
VALUES ('Берёзова роща', '1871-01-01', (SELECT id_artist
        FROM "Artist"
        WHERE last_name = 'Полякова'));
		
INSERT INTO "Picture"("name", "date_of_painting", "id_artist") 
VALUES ('Композиция 3', '1819-01-01', (SELECT id_artist
        FROM "Artist"
        WHERE last_name = 'Поляков'));
		
INSERT INTO "Picture"("name", "date_of_painting", "id_artist") 
VALUES ('Абстракция 17', '1822-01-01', (SELECT id_artist
        FROM "Artist"
        WHERE last_name = 'Поляков'));
		
INSERT INTO "Picture"("name", "date_of_painting", "id_artist") 
VALUES ('Чёрный квадрат', '1830-01-01', (SELECT id_artist
        FROM "Artist"
        WHERE last_name = 'Поляков'));
		
INSERT INTO "Picture"("name", "date_of_painting", "id_artist") 
VALUES ('Чёрный прямоугольник', '1816-01-01', (SELECT id_artist
        FROM "Artist"
        WHERE last_name = 'Поляков'));
		
INSERT INTO "Picture"("name", "date_of_painting", "id_artist") 
VALUES ('Последний день', '1903-01-01', (SELECT id_artist
        FROM "Artist"
        WHERE last_name = 'Скибин'));
		
INSERT INTO "Picture"("name", "date_of_painting", "id_artist") 
VALUES ('Полководец Суворов', '1904-01-01', (SELECT id_artist
        FROM "Artist"
        WHERE last_name = 'Скибин'));	
				
INSERT INTO "Picture"("name", "date_of_painting", "id_artist") 
VALUES ('Портрет Пушкина', '1906-01-01', (SELECT id_artist
        FROM "Artist"
        WHERE last_name = 'Скибин'));
		
INSERT INTO "Picture"("name", "date_of_painting", "id_artist") 
VALUES ('Озеро Валаам', '19013-01-01', (SELECT id_artist
        FROM "Artist"
        WHERE last_name = 'Скибин'));
				
INSERT INTO "Picture"("name", "date_of_painting", "id_artist") 
VALUES ('Танец', '1923-01-01', (SELECT id_artist
        FROM "Artist"
        WHERE last_name = 'Ковтун'));
		
INSERT INTO "Picture"("name", "date_of_painting", "id_artist") 
VALUES ('Музыка', '1901-01-01', (SELECT id_artist
        FROM "Artist"
        WHERE last_name = 'Ковтун'));
		
INSERT INTO "Picture"("name", "date_of_painting", "id_artist") 
VALUES ('Фигура', '1919-01-01', (SELECT id_artist
        FROM "Artist"
        WHERE last_name = 'Ковтун'));
		
INSERT INTO "Picture"("name", "date_of_painting", "id_artist") 
VALUES ('Обнажённая', '1916-01-01', (SELECT id_artist
        FROM "Artist"
        WHERE last_name = 'Ковтун'));
		
INSERT INTO "Picture"("name", "date_of_painting", "id_artist") 
VALUES ('Мужчина', '1946-01-01', (SELECT id_artist
        FROM "Artist"
        WHERE last_name = 'Ковтун'));	
		
SELECT * FROM "Picture";