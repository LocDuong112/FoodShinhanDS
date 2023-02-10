-- Create user FOODSERVICEV1
CREATE USER FOODSERVICEV1 IDENTIFIED BY 123456;

-- Assign all permissions to the user
GRANT ALL PRIVILEGES TO FOODSERVICEV1;

-- Create table Admin and add some data
CREATE TABLE ADMIN (
	Email NVARCHAR2(100) PRIMARY KEY,
	Password VARCHAR2(100),
	Fullname NVARCHAR2(100),
	Phone VARCHAR2(30)
);

INSERT ALL
    INTO ADMIN ( Email, Password, Fullname, Phone ) VALUES ( '1@g.com', '1', 'Nguyễn Hoàng Linh', '0933348791' )
    INTO ADMIN ( Email, Password, Fullname, Phone ) VALUES ( '2@g.com', '1', 'Alice', '0123456789' )
    INTO ADMIN ( Email, Password, Fullname, Phone ) VALUES ( '3@g.com', '1', 'Bob', '0123456001' )
SELECT 1 FROM DUAL;

-- Create table Customer and add some data
CREATE TABLE CUSTOMER (
	Email NVARCHAR2(100) PRIMARY KEY,
	Password VARCHAR2(100),
	Fullname NVARCHAR2(100),
	Phone VARCHAR2(30)
);

INSERT ALL
    INTO CUSTOMER ( Email, Password, Fullname, Phone ) VALUES ( 'theboost1305@gmail.com', '123456', 'Nguyễn Hoàng Linh', '0933348791' )
    INTO CUSTOMER ( Email, Password, Fullname, Phone ) VALUES ( 'admin2@gmail.com', '123456', 'Alice', '0123456789' )
    INTO CUSTOMER ( Email, Password, Fullname, Phone ) VALUES ( 'admin3@gmail.com', '123456', 'Bob', '0123456001' )
SELECT 1 FROM DUAL;

-- Create table Restaurant and add some data
CREATE TABLE RESTAURANT (
	Username VARCHAR2(100) PRIMARY KEY,
	Name NVARCHAR2(200),
	Email NVARCHAR2(100),
	Password VARCHAR2(100),
	ImageLink VARCHAR2(2000),
	Address NVARCHAR2(300)
);

INSERT ALL
    INTO RESTAURANT ( Username, Name, Email, Password, ImageLink, Address )
		VALUES (
			'luckrestaurant', 'Luck Restaurant', 'theboost1305@gmail.com', '123456',
			'https://cdn-icons-png.flaticon.com/512/5052/5052310.png',
			'Khu phố 6, phường Linh Trung, thành phố Thủ Đức, Thành phố Hồ Chí Minh'
		)
	INTO RESTAURANT ( Username, Name, Email, Password, ImageLink, Address )
		VALUES (
			'restaurant2', 'Restaurant 2', 'admin2@gmail.com', '123456',
			'',
			'Khu phố 6, phường Linh Trung, thành phố Thủ Đức, Thành phố Hồ Chí Minh'
		)
SELECT 1 FROM DUAL;

-- Create table Food and add some data
CREATE TABLE FOOD (
	Id VARCHAR2(200) PRIMARY KEY,
	RestaurantUsername VARCHAR2(100),
	Name NVARCHAR2(200),
	Price NUMBER,
	ImageLink VARCHAR2(2000)
);

INSERT ALL
    INTO FOOD ( Id, RestaurantUsername, Name, Price, ImageLink )
		VALUES (
			'b170bcaa-8008-4889-aa8c-886950a2ce22', 'luckrestaurant', 'Cơm Gà Xối mỡ', 25000,
			'https://cdn.cet.edu.vn/wp-content/uploads/2020/04/cach-lam-com-chien-ga-xoi-mo.jpg'
		)
	INTO FOOD ( Id, RestaurantUsername, Name, Price, ImageLink )
		VALUES (
			'45a06734-7c63-4dae-bf9e-5fa674926da2', 'luckrestaurant', 'Cơm Sườn', 25000,
			'https://comtamtuonghan.vn/wp-content/uploads/2020/09/com-tam-suon-nuong-tang-1.png'
		)
SELECT 1 FROM DUAL;



-- Create table Order and add some data
CREATE TABLE SERVICEORDER (
	Id VARCHAR2(200) PRIMARY KEY,
	RestaurantUsername VARCHAR2(100),
	RestaurantName VARCHAR2(100),
	CustomerEmail NVARCHAR2(100),
	CreatedDate TIMESTAMP
);

INSERT ALL
    INTO SERVICEORDER ( Id, RestaurantUsername, CustomerEmail, CreatedDate )
		VALUES (
			'8b9bb01d-c318-44bc-93e9-fd28f958ffd1', 'luckrestaurant', 'theboost1305@gmail.com', CURRENT_DATE
		)
SELECT 1 FROM DUAL;

-- Create table OrderFood and add some data
CREATE TABLE OrderFood (
	OrderId VARCHAR2(200),
	FoodId VARCHAR2(100),
	FoodName NVARCHAR2(200),
	Quantity NUMBER,
	Price NUMBER
);



-- SELECT Id, RestaurantUsername, CustomerEmail, TO_CHAR(CreatedDate, 'YYYY-MM-DD HH24:MI:SS') CreatedDate  FROM SERVICEORDER
--
--
-- SELECT CURRENT_DATE FROM dual
--
-- SELECT * FROM SERVICEORDER
--
-- SELECT * FROM FOOD
--
-- SELECT * FROM ORDERFOOD

-- Giá thay đổi thì order sẽ thay đổi theo!!!
-- SELECT
-- 	SERVICEORDER.Id,
-- 	SERVICEORDER.RestaurantName,
-- 	SERVICEORDER.CustomerEmail,
-- 	ORDERFOOD.FoodName,
-- 	ORDERFOOD.Price,
-- 	ORDERFOOD.Quantity,
-- 	SERVICEORDER.CreatedDate
-- FROM ORDERFOOD
-- 	JOIN SERVICEORDER ON SERVICEORDER.Id = ORDERFOOD.OrderId
-- WHERE ORDERFOOD.OrderId = '81b93081-acb4-415a-b682-7dd8e7815903'






