Create Table Apartments
(
	Id SERIAL PRIMARY KEY,
	Number Integer, 
	CountRooms Integer,
	CountPlaces Integer,
	Price Integer,
	TypeId Integer References ApartmentTypes(Id)
)