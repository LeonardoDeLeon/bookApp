CREATE TABLE `book` (
	`ISBN` int(3) AUTO_INCREMENT,
    `Title` varchar(50) NOT NULL,
    `Author` varchar(50) NOT NULL,
    `PublishedDate` date NOT NULL,
    `PublisherName` varchar(50) NOT NULL,
    `Price` decimal(4,2) NOT NULL,
    PRIMARY KEY (`ISBN`)
); 

INSERT INTO  book(Title,Author,PublishedDate,PublisherName,Price)
VALUES ('Fun with swimming','Jane Smith','1985-01-15','ABC Publishing',5.97),
	('Easy Wok two three','Anne Chen','2013-05-09','DC Publishing',4.75),
	('Fishing for dummies','Hal Smith','2018-04-28','Sams Publishing',7.49);

DROP TABLE book;

SELECT * FROM book;
