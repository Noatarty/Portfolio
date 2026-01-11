CREATE TABLE PokemonInfo (
    NumPokemon INT PRIMARY KEY,
    Nom VARCHAR(50),
    Type VARCHAR(20),
    Niveau INT,
    Attaque VARCHAR(50),
    PV INT
);


CREATE TABLE Dresseurs (
    DresseurID INT PRIMARY KEY,
    DresseurNom VARCHAR(50)
);


CREATE TABLE PokemonDresseur (
    NumPokemon INT,
    DresseurID INT,
    PRIMARY KEY (NumPokemon, DresseurID),
    FOREIGN KEY (NumPokemon) REFERENCES PokemonInfo(NumPokemon),
    FOREIGN KEY (DresseurID) REFERENCES Dresseurs(DresseurID)
);



