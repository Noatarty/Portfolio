function moyTab(tableau) {
  let somme = 0;
  let compte = 0;

  for (let i = 0; i < tableau.length; i++) {
    for (let j = 0; j < tableau[i].length; j++) {
      somme += tableau[i][j];
      compte++;
    }
  }

  return compte > 0 ? somme / compte : 0;
}

// Exe
const tab2D = [
  [1, 2, 3],
  [4, 5, 6],
  [7, 8, 9]
];

const tab2Dfinal = [
    [45, 23, 54, 102, 1],
    [40, -4, 57, 0],
    [38, 5, -1]
  ];

console.log("La moyenne du tableau est : " + moyTab(tab2Dfinal));