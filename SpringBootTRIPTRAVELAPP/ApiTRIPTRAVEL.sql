
--create the database ************************************************************************
CREATE DATABASE ApiTRIPTRAVEL

--use the database ***************************************************************************
USE ApiTRIPTRAVEL

--create the table ***************************************************************************
CREATE TABLE ApplyForFormData (
	    id BIGINT IDENTITY PRIMARY KEY,
	    dateOfTravel VARCHAR(255),
	    travelFor VARCHAR(255),
	    project VARCHAR(255),
	    businessUnit VARCHAR(255),
	    organisation VARCHAR(255),
	    trip VARCHAR(255),
	    tripDescription VARCHAR(255),
	    location VARCHAR(255),
	    foreignExchange VARCHAR(255),
	    applyFor VARCHAR(255),
	    other VARCHAR(255),
	    empId BIGINT
	);


	CREATE TABLE Data (
	    id BIGINT IDENTITY PRIMARY KEY,
	    type VARCHAR(255),
	    from_loc VARCHAR(255),
	    location VARCHAR(255),
	    form_loc VARCHAR(255),
	    to_loc VARCHAR(255),
	    checkIn VARCHAR(255),
	    checkOut VARCHAR(255),
	    departure VARCHAR(255),
		empId BIGINT,
	    FOREIGN KEY (empId) REFERENCES ApplyForFormData(empId)
	);



CREATE TABLE travel_desc (
	    id BIGINT IDENTITY PRIMARY KEY,
	    apply_for VARCHAR(255),
	    business_unit VARCHAR(255),
	    date_of_travel VARCHAR(255),
	    foreign_exchange VARCHAR(255),
	    location VARCHAR(255),
	    organisation VARCHAR(255),
	    other VARCHAR(255),
	    project VARCHAR(255),
	    travel_for VARCHAR(255),
	    trip VARCHAR(255),
	    trip_description VARCHAR(255),
	    emp_id BIGINT
	);

SELECT * FROM travel_desc

drop table travel_desc


--------------------------------------------------------------------------------------------------

	CREATE TABLE item (
	    id BIGINT IDENTITY PRIMARY KEY,
	    type VARCHAR(255),
	    from_location VARCHAR(255),
	    to_location VARCHAR(255),
	    departure VARCHAR(255),
	    check_in VARCHAR(255),
	    check_out VARCHAR(255),
	    location VARCHAR(255),
	    travel_desc_id BIGINT,
	    FOREIGN KEY (travel_desc_id) REFERENCES travel_desc(id)
	);


SELECT * FROM item

drop table item


----------------------------------------------------------------------------------------------------

CREATE TABLE DataTravelRequest (
	    id INT IDENTITY PRIMARY KEY,
	    dateOfTravel DATE,
	    travelFor VARCHAR(255),
	    project VARCHAR(255),
	    businessUnit VARCHAR(255),
	    organisation VARCHAR(255),
	    trip VARCHAR(255),
	    tripDescription TEXT,
	    location VARCHAR(255),
	    applyFor VARCHAR(255),
	    other TEXT,
        empId INT 
);

SELECT * FROM DataTravelRequest

drop table DataTravelRequest

--------------------------------------------------------------------------------------------------

CREATE TABLE DomesticData (
    id INT IDENTITY PRIMARY KEY,
    empId VARCHAR(255),
    data VARCHAR(255)
);

SELECT * FROM DomesticData

drop table DomesticData


---------------------------------------------------------------------------------------------------

CREATE TABLE EmployeeTravelRequest (
    id BIGINT IDENTITY PRIMARY KEY,
    dateOfTravel DATE,
    travelFor VARCHAR(255),
    project VARCHAR(255),
    businessUnit VARCHAR(255),
    organisation VARCHAR(255),
    trip VARCHAR(255),
    tripDescription TEXT,
    location VARCHAR(255),
    foreignExchange VARCHAR(255),
    applyFor VARCHAR(255),
    other TEXT
);

SELECT * FROM EmployeeTravelRequest

drop table EmployeeTravelRequest


----------------------------------------------------------------------------------------------------

CREATE TABLE TravelMultipleData (
    id INT IDENTITY PRIMARY KEY,
    employeeTravelRequestId BIGINT,
    type VARCHAR(255),
    location VARCHAR(255),
    fromLocation VARCHAR(255),
    toLocation VARCHAR(255),
    checkIn DATETIME,
    checkOut DATETIME,
    departure DATETIME,
    FOREIGN KEY (employeeTravelRequestId) REFERENCES EmployeeTravelRequest(id)
);

SELECT * FROM TravelMultipleData

drop table TravelMultipleData

----------------------------------------------------------------------------------------------------

CREATE TABLE HotelData (
    id INT IDENTITY PRIMARY KEY,
    empId VARCHAR(255),
    data VARCHAR(255)
);

SELECT * FROM HotelData

drop table HotelData


-----------------------------------------------------------------------------------------------------

CREATE TABLE InternationalData (
    id INT IDENTITY PRIMARY KEY,
    empId VARCHAR(255),
    data VARCHAR(255)
);

SELECT * FROM InternationalData

drop table InternationalData

------------------------------------------------------------------------------------------------------

CREATE TABLE Travel (
	    id INT IDENTITY PRIMARY KEY,
	    type VARCHAR(255),
	    from_location VARCHAR(255),
	    to_location VARCHAR(255),
	    departure DATE,
	    check_in DATE,
	    check_out DATE,
	    location VARCHAR(255),
	    emp_id INT,
	    FOREIGN KEY (emp_id) REFERENCES DataTravelRequest(empId)
);

SELECT * FROM Travel

drop table Travel

-----------------------------------------------------------------------------------------------------

CREATE TABLE TravelData (
    id INT PRIMARY KEY IDENTITY,
    type VARCHAR(255),
    location VARCHAR(255),
    from_location VARCHAR(255),
    to_location VARCHAR(255),
    check_in DATE,
    check_out DATE,
    departure DATE
);

SELECT * FROM TravelData

drop table TravelData


-----------------------------------------------------------------------------------------------------

CREATE TABLE TravelRequest (
    id INT PRIMARY KEY ,
    dateOfTravel DATE,
    travelFor VARCHAR(255),
    project VARCHAR(255),
    businessUnit VARCHAR(255),
    organisation VARCHAR(255),
    trip VARCHAR(255),
    tripDescription TEXT,
    location VARCHAR(255),
    applyFor VARCHAR(255),
    other TEXT
);

SELECT * FROM TravelRequest

drop table TravelRequest


-------------------------------------------------------------------------------------------------------

CREATE TABLE TravelSingleData (
    id INT PRIMARY KEY IDENTITY,
    type NVARCHAR(255),
    location NVARCHAR(255),
    from_location NVARCHAR(255),
    to_location NVARCHAR(255),
    check_in NVARCHAR(255),
    check_out NVARCHAR(255),
    departure NVARCHAR(255)
);

SELECT * FROM TravelSingleData

drop table TravelSingleData

-------------------------------------------------------------------------------------------------------

CREATE TABLE trip (
	    id INT IDENTITY PRIMARY KEY,
	    dateOfTravel DATE,
	    travelFor VARCHAR(50),
	    project VARCHAR(50),
	    businessUnit VARCHAR(50),
	    organisation VARCHAR(50),
	    trip VARCHAR(50),
	    tripDescription TEXT,
	    location VARCHAR(50),
	    foreignExchange VARCHAR(50),
	    applyFor VARCHAR(50),
	    other VARCHAR(50),
		empId VARCHAR(50)
	);

SELECT * FROM trip

drop table trip

--------------------------------------------------------------------------------------------------------

CREATE TABLE trip_travel_details (
	    id INT IDENTITY PRIMARY KEY,
	    empId INT,
	    type VARCHAR(50),
	    location VARCHAR(50),
	    fromCity VARCHAR(50),
	    toCity VARCHAR(50),
	    checkIn DATE,
	    checkOut DATE,
	    departure DATE,
	    FOREIGN KEY (empId) REFERENCES trip(empId)
	);

SELECT * FROM trip_travel_details

drop table trip_travel_details

-- Insert data into table *****************************************************************************************

INSERT INTO DataTravelRequest (dateOfTravel, travelFor, project, businessUnit, organisation, trip, tripDescription, location, applyFor, other, empId)
VALUES ('2024-03-25', 'Business', 'Project X', 'Business Unit A', 'Company ABC', 'Business Trip', 'Meeting with clients', 'New York', 'John Doe', 'N/A', 1),
       ('2024-04-10', 'Personal', NULL, NULL, NULL, 'Vacation', 'Exploring Europe', 'Paris', 'John Doe', 'Family trip', 2);



INSERT INTO DomesticData (empId, data)
VALUES ('EMP001', 'Domestic data 1'),
       ('EMP002', 'Domestic data 2'),
       ('EMP003', 'Domestic data 3');



INSERT INTO EmployeeTravelRequest (dateOfTravel, travelFor, project, businessUnit, organisation, trip, tripDescription, location, foreignExchange, applyFor, other)
VALUES ('2024-03-25', 'Business', 'Project X', 'Business Unit A', 'Company ABC', 'Business Trip', 'Meeting with clients', 'New York', 'USD', 'John Doe', 'N/A');



INSERT INTO TravelMultipleData (employeeTravelRequestId, type, location, fromLocation, toLocation, checkIn, checkOut, departure)
VALUES (1, 'Flight', 'New York', 'Airport A', 'Airport B', '2024-03-25 08:00:00', '2024-03-25 12:00:00', '2024-03-25 06:00:00');



INSERT INTO HotelData (empId, data)
VALUES ('EMP001', 'Hotel data 1'),
       ('EMP002', 'Hotel data 2'),
       ('EMP003', 'Hotel data 3');



INSERT INTO InternationalData (empId, data)
VALUES ('EMP001', 'International data 1'),
       ('EMP002', 'International data 2'),
       ('EMP003', 'International data 3');


INSERT INTO Travel (type, from_location, to_location, departure, check_in, check_out, location, emp_id)
VALUES ('Flight', 'New York', 'Los Angeles', '2024-03-25', '2024-03-25', '2024-03-26', 'Airport A', 1),
       ('Train', 'Paris', 'Berlin', '2024-04-10', '2024-04-10', '2024-04-11', 'Train Station B', 2);


INSERT INTO TravelData (type, location, from_location, to_location, check_in, check_out, departure)
VALUES ('Type 1', 'Location 1', 'From 1', 'To 1', '2024-03-20', '2024-03-25', '2024-03-19'),
       ('Type 2', 'Location 2', 'From 2', 'To 2', '2024-04-10', '2024-04-15', '2024-04-09'),
       ('Type 3', 'Location 3', 'From 3', 'To 3', '2024-05-05', '2024-05-10', '2024-05-04');


INSERT INTO TravelRequest (id, dateOfTravel, travelFor, project, businessUnit, organisation, trip, tripDescription, location, applyFor, other)
VALUES
(1, '2024-03-25', 'Business', 'Project X', 'Business Unit A', 'Company ABC', 'Business Trip', 'Meeting with clients', 'New York', 'John Doe', 'N/A'),
(2, '2024-04-10', 'Personal', NULL, NULL, NULL, 'Vacation', 'Exploring Europe', 'Paris', 'John Doe', 'Family trip');


INSERT INTO TravelSingleData (type, location, from_location, to_location, check_in, check_out, departure)
VALUES ('Type 1', 'Location 1', 'From 1', 'To 1', '2024-03-20', '2024-03-25', '2024-03-19'),
       ('Type 2', 'Location 2', 'From 2', 'To 2', '2024-04-10', '2024-04-15', '2024-04-09'),
       ('Type 3', 'Location 3', 'From 3', 'To 3', '2024-05-05', '2024-05-10', '2024-05-04');


INSERT INTO trip (dateOfTravel, travelFor, project, businessUnit, organisation, trip, tripDescription, location, foreignExchange, applyFor, other, empId)
VALUES ('2024-03-25', 'Business', 'Project X', 'Business Unit A', 'Company ABC', 'Business Trip', 'Meeting with clients', 'New York', 'USD', 'John Doe', 'N/A', 'EMP001'),
       ('2024-04-10', 'Personal', NULL, NULL, NULL, 'Vacation', 'Exploring Europe', 'Paris', NULL, 'John Doe', 'Family trip', 'EMP002');


INSERT INTO trip_travel_details (empId, type, location, fromCity, toCity, checkIn, checkOut, departure)
VALUES (1, 'Flight', 'New York', 'Airport A', 'Airport B', '2024-03-25', '2024-03-25', '2024-03-25'),
       (2, 'Train', 'Paris', 'Train Station A', 'Train Station B', '2024-04-10', '2024-04-10', '2024-04-10');

