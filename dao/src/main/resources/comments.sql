Create Table Comments
(
	Id SERIAL PRIMARY KEY,
	Comment VarChar(40),
	PersonId Integer References Person(Id),
	ApartmentId Integer References Apartments(Id)
)