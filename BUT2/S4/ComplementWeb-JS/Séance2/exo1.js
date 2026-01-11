var unePersonne = {
    prenom: "John",
    nom: "Deuff",
    profession: "Humoriste",
    ouvrages: { livre1: "L’Œuf au riz", livre2: "Quoi de n’Œuf ?" }
};

//1.Valeur de la première propriete
console.log(Object.values(unePersonne)[0]);

//2.Nombre de proprietes d’unePersonne
console.log(Object.keys(unePersonne).length);

//3.Toutes les valeurs d’unePersonne
console.log(Object.values(unePersonne));

//4.Toutes les proprietes d’ouvrages
console.log(Object.keys(unePersonne.ouvrages));

//5.La profession d’unePersonne
console.log(unePersonne.profession);

//6.Les intitules des proprietes une à une    
Object.keys(unePersonne).forEach(prop => console.log(prop));

//7.Les valeurs des proprietes une à une
Object.values(unePersonne).forEach(val => console.log(val));
