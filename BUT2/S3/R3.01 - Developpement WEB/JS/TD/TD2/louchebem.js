function louchebem(mot) {
  mot = mot.trim().toLowerCase();

  if (mot.length <= 1) {
    return mot;
  }

  const voyelles = ['a', 'e', 'i', 'o', 'u', 'y'];
  let suffixe = 'ès';
  const premierelettre = mot[0];

  // Détermine le suffixe selon la première lettre
  switch (premierelettre) {
    case 'b':
      suffixe = 'em';
      break;
    case 'c':
      suffixe = 'ès';
      break;
    case 'd':
    case 'p':
      suffixe = 'é';
      break;
    case 'f':
      suffixe = 'oque';
      break;
    case 'm':
      suffixe = 'uche';
      break;
}









// Trouver le début du groupe de consonnes
  let finDuGroupe = 1;
  while (finDuGroupe < mot.length && !voyelles.includes(mot[finDuGroupe])) {
    finDuGroupe++;
  }

  // Construire le mot louchebem
  const motLouchebem = 'l' + 
                        mot.slice(finDuGroupe) + 
                        mot.slice(0, finDuGroupe) + 
                        suffixe;

  return motLouchebem;
}

// Tester la fonction avec les mots donnés
const motsTest = ['boucher', 'merci', 'café', 'douce', 'fou', 'poil'];

motsTest.forEach(mot => {
  console.log(`${mot} -> ${louchebem(mot)}`);
});