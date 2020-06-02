DROP TABLE IF EXISTS Flowers;

CREATE TABLE Flowers (
  flowerId INTEGER AUTO_INCREMENT  PRIMARY KEY,
  flowerName VARCHAR(30),
  noOfFlowers INTEGER,
  costOfFlowers INTEGER,
  discount INTEGER
);

Select * from Flowers;