
function verifierPlaqueImmatriculation(plaque) {
  // Expression régulière pour vérifier le format de la plaque
  const regex = /^[0-9][1-9]{1,3} [A-HJ-NP-TV-Z]{2,3} (0[1-9]|[1-8][0-9]|9[0-5]|2[AB])$/;

  if (!regex.test(plaque)) {
    return false;
  }

  // Vérification supplémentaire pour les départements
  const [, , , departement] = plaque.match(regex);
  if (departement !== '2A' && departement !== '2B') {
    const numDepartement = parseInt(departement, 10);
    if (numDepartement < 1 || numDepartement > 95) {
      return false;
    }
  }

  return true;
}

// Exemples d'utilisation
console.log(verifierPlaqueImmatriculation('12 AZ 01')); // true
console.log(verifierPlaqueImmatriculation('1234 ABC 95')); // true
console.log(verifierPlaqueImmatriculation('123 DE 2A')); // true
console.log(verifierPlaqueImmatriculation('12 IO 01')); // false (I et O non autorisés)
console.log(verifierPlaqueImmatriculation('12345 AB 01')); // false (trop de chiffres)
console.log(verifierPlaqueImmatriculation('12 ABCD 01')); // false (trop de lettres)
console.log(verifierPlaqueImmatriculation('12 AB 00')); // false (département invalide)
console.log(verifierPlaqueImmatriculation('12 AB 96')); // false (département invalide)
