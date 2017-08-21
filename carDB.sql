DROP DATABASE WEB_PROJECT; 
CREATE DATABASE WEB_PROJECT;
USE WEB_PROJECT;

--
-- Table structure for table `STATUS`
--
CREATE TABLE IF NOT EXISTS STATUS (
ID    		 		INT 		 NOT NULL,
STATUS_NAME    	 	VARCHAR (50) NOT NULL,
PRIMARY KEY (ID)
);

--
-- Dumping data for table `STATUS`
--

INSERT INTO STATUS (ID, STATUS_NAME) VALUES
(1, 'Default'),
(2, 'Vehicle is defective'),
(3, 'Run & Drive');

-- --------------------------------------------------------
	
--
-- Table structure for table `VEHICLE_TYPE`
--
CREATE TABLE IF NOT EXISTS VEHICLE_TYPE (
ID    		 		 INT 		 NOT NULL,
VEHICLE_TYPE_NAME    VARCHAR (50) NOT NULL,
PRIMARY KEY (ID)
);

--
-- Dumping data for table `VEHICLE_TYPE`
--

INSERT INTO VEHICLE_TYPE (ID, VEHICLE_TYPE_NAME) VALUES
(1, 'cars'),
(2, 'motorcycles'),
(3, 'trucks'),
(4, 'bus');

-- --------------------------------------------------------

--
-- Table structure for table `VEHICLE_MANUFACTURER`
--
CREATE TABLE IF NOT EXISTS VEHICLE_MANUFACTURER (
ID    		 				INT 		 NOT NULL,
VEHICLE_MANUFACTURER_NAME   VARCHAR (50) NOT NULL,
PRIMARY KEY (ID)
);

--
-- Dumping data for table `VEHICLE_MANUFACTURER`
--

INSERT INTO VEHICLE_MANUFACTURER (ID, VEHICLE_MANUFACTURER_NAME) VALUES
(1, 'Toyota'),
(2, 'Honda'),
(3, 'Ford'),
(4, 'Chevrolet'),
(5, 'Peugeot'),
(6, 'BMW'),
(7, 'Mercedes');

-- --------------------------------------------------------	

--
-- Table structure for table `TYPE_MANUFACTURER_AGGREGATION`
--
CREATE TABLE IF NOT EXISTS TYPE_MANUFACTURER (
ID    		 		 	INT 		NOT NULL,
VEHICLE_TYPE_ID      	INT REFERENCES VEHICLE_TYPE(ID),
VEHICLE_MANUFACTURER_ID INT REFERENCES VEHICLE_MANUFACTURER(ID),
PRIMARY KEY (ID)
);

ALTER TABLE TYPE_MANUFACTURER
	ADD FOREIGN KEY (VEHICLE_MANUFACTURER_ID) REFERENCES VEHICLE_MANUFACTURER(ID);
ALTER TABLE TYPE_MANUFACTURER
	ADD FOREIGN KEY (VEHICLE_TYPE_ID) REFERENCES VEHICLE_TYPE(ID);

INSERT INTO TYPE_MANUFACTURER (ID, VEHICLE_TYPE_ID, VEHICLE_MANUFACTURER_ID) VALUES
(1, 1, 1),
(2, 1, 2),
(3, 1, 4),
(4, 1, 6),
(5, 2, 2),
(6, 2, 3),
(7, 2, 6),
(8, 2, 7),
(9, 3, 3),
(10, 3, 6),
(11, 3, 7),
(12, 4, 2),
(13, 4, 1);
-- --------------------------------------------------------	
	
--
-- Table structure for table `BODY_STYLE`
--
CREATE TABLE IF NOT EXISTS BODY_STYLE (
ID    		 		INT 		 NOT NULL,
BODY_STYLE_NAME    	VARCHAR (50) NOT NULL,
PRIMARY KEY (ID)
);

--
-- Dumping data for table `BODY_STYLE`
--

INSERT INTO BODY_STYLE (ID, BODY_STYLE_NAME) VALUES
(1, 'Sedan'),
(2, 'SUV'),
(3, 'Pickup'),
(4, 'Hatchback'),
(5, 'Coupe'),
(6, 'Sport');

-- --------------------------------------------------------

--
-- Table structure for table `VEHICLE_MODEL`
--
CREATE TABLE IF NOT EXISTS VEHICLE_MODEL (
ID    		 				INT 		 NOT NULL,
VEHICLE_MODEL_NAME    		VARCHAR (50) NOT NULL,
VEHICLE_MANUFACTURER_ID  	INT REFERENCES VEHICLE_MANUFACTURER(ID),
VEHICLE_TYPE_ID 		    INT REFERENCES VEHICLE_TYPE(ID),
PRIMARY KEY (ID)
);

ALTER TABLE VEHICLE_MODEL
	ADD FOREIGN KEY (VEHICLE_MANUFACTURER_ID) REFERENCES VEHICLE_MANUFACTURER (ID);
ALTER TABLE VEHICLE_MODEL
	ADD FOREIGN KEY (VEHICLE_TYPE_ID) 	  REFERENCES VEHICLE_TYPE (ID);
--
-- Dumping data for table `VEHICLE_MODEL`
--

INSERT INTO VEHICLE_MODEL (ID, VEHICLE_MODEL_NAME, VEHICLE_MANUFACTURER_ID, VEHICLE_TYPE_ID) VALUES
(1, 'Acord', 1, 1),
(2, 'Civic', 1, 1),
(3, 'Corolla', 1, 1),
(4, 'Altima', 1, 1),
(5, 'Odyssey', 2, 1),
(6, 'Pilot', 2, 1),
(7, 'Fit', 2, 1),
(8, 'Cbr600Rr', 2, 2),
(9, 'Cbr1000Rr', 2, 2),
(10, 'S1000Rr', 6, 2),
(11, 'R12000Rt', 6, 2);

-- --------------------------------------------------------	
	
--
-- Table structure for table `VEHICLE`
--
CREATE TABLE IF NOT EXISTS VEHICLE (
ID    		 	INT 		 NOT NULL,
NAME    	 	VARCHAR (50) NOT NULL,
AGE     	 	INT          NOT NULL,
DESCRIPTION  	TEXT,
ACTUAL_MILES 	INT,
STATUS_ID       INT REFERENCES STATUS(ID),
IMAGE_PATH   	VARCHAR(100),
PRICE        	INT,
LOCATION     	VARCHAR(100),
VEHICLE_MANUFACTURER_ID INT REFERENCES VEHICLE_MANUFACTURER(ID),
BODY_STYLE_ID 			INT REFERENCES BODY_STYLE(ID),
VEHICLE_MODEL_ID 		INT REFERENCES VEHICLE_MODEL(ID),
VEHICLE_TYPE_ID 		INT REFERENCES VEHICLE_TYPE(ID),
PRIMARY KEY (ID)
);

ALTER TABLE VEHICLE
	ADD FOREIGN KEY (STATUS_ID) 	  REFERENCES STATUS (ID);
ALTER TABLE VEHICLE
	ADD FOREIGN KEY (VEHICLE_MANUFACTURER_ID) REFERENCES VEHICLE_MANUFACTURER (ID);
ALTER TABLE VEHICLE
	ADD FOREIGN KEY (BODY_STYLE_ID)   REFERENCES BODY_STYLE (ID);
ALTER TABLE VEHICLE
	ADD FOREIGN KEY (VEHICLE_MODEL_ID) 		  REFERENCES VEHICLE_MODEL (ID);
ALTER TABLE VEHICLE
	ADD FOREIGN KEY (VEHICLE_TYPE_ID) 	  REFERENCES VEHICLE_TYPE (ID);

--
-- Dumping data for table `MODEL`
--

INSERT INTO VEHICLE (ID, VEHICLE_TYPE_ID, NAME, AGE, DESCRIPTION, ACTUAL_MILES, STATUS_ID, IMAGE_PATH, PRICE, LOCATION, VEHICLE_MANUFACTURER_ID, BODY_STYLE_ID, VEHICLE_MODEL_ID) VALUES
(1, 1, 'Acord', 2004, 'Lorem ipsum dolor sit amet, pro explicari disputationi ex. Probo noster vulputate at mei. Ne sed odio deseruisse. Suas vidit ius ut, nec ut elit aliquid. Diam qualisque cu vel, sed in maiorum adversarium.', 360000, 2, 'toyota', 4000, 'Belgrade', 1, 6, 3),
(2, 1, 'Civic', 2009, 'Lorem ipsum dolor sit amet, pro explicari disputationi ex. Probo noster vulputate at mei. Ne sed odio deseruisse. Suas vidit ius ut, nec ut elit aliquid. Diam qualisque cu vel, sed in maiorum adversarium.', 660000, 2, '', 4000, 'Belgrade', 1, 6, 3),
(3, 1, 'Corolla', 2014, 'Lorem ipsum dolor sit amet, pro explicari disputationi ex. Probo noster vulputate at mei. Ne sed odio deseruisse. Suas vidit ius ut, nec ut elit aliquid. Diam qualisque cu vel, sed in maiorum adversarium.', 160000, 2, 'toyotaCorolla', 4000, 'Belgrade', 1, 6, 3),
(4, 1, 'Altima', 2004, 'Lorem ipsum dolor sit amet, pro explicari disputationi ex. Probo noster vulputate at mei. Ne sed odio deseruisse. Suas vidit ius ut, nec ut elit aliquid. Diam qualisque cu vel, sed in maiorum adversarium.', 960000, 2, '', 4000, 'Belgrade', 1, 6, 3),
(5, 2, 'BMW R100Rt', 1988, 'Lorem ipsum dolor sit amet, pro explicari disputationi ex. Probo noster vulputate at mei. Ne sed odio deseruisse. Suas vidit ius ut, nec ut elit aliquid. Diam qualisque cu vel, sed in maiorum adversarium.', 36000, 2, 'motorcycle1', 4000, 'Belgrade', 6, 6, 8),
(6, 2, 'BMW R1200 C Mo', 2004, 'Lorem ipsum dolor sit amet, pro explicari disputationi ex. Probo noster vulputate at mei. Ne sed odio deseruisse. Suas vidit ius ut, nec ut elit aliquid. Diam qualisque cu vel, sed in maiorum adversarium.', 660000, 2, 'motorcycle2', 4000, 'Belgrade', 1, 6, 9),
(7, 2, 'BMW 700 Gs', 2017, 'Lorem ipsum dolor sit amet, pro explicari disputationi ex. Probo noster vulputate at mei. Ne sed odio deseruisse. Suas vidit ius ut, nec ut elit aliquid. Diam qualisque cu vel, sed in maiorum adversarium.', 160000, 2, 'motorcycle3', 4000, 'Belgrade', 6, 6, 8),
(8, 2, 'BMW G650 Gs', 2004, 'Lorem ipsum dolor sit amet, pro explicari disputationi ex. Probo noster vulputate at mei. Ne sed odio deseruisse. Suas vidit ius ut, nec ut elit aliquid. Diam qualisque cu vel, sed in maiorum adversarium.', 960000, 2, '', 4000, 'Belgrade', 6, 6, 9);

-- --------------------------------------------------------		
	