/*let monAge = prompt("Entrez votre année de naissance");
let uneDate = new Date();
let maPhrase =`Tu as ${uneDate.getFullYear()-monAge} ans`;
console.log(maPhrase);*/

/*let val1= 10, val2 = 20;
let reponse= (val1 > val2) ? val1 : val2;
alert("La plus grande valeur est : " + reponse);*/

/*let uneDate = new Date().getDay();
alert((uneDate==0 || uneDate==6) ? "Bon week-end" : "Bonne semaine");*/

/*let uneDate = new Date().getDay();
switch (uneDate) {
	case 0:
		console.log("On est Dimanche");
		break;
	case 1:
		console.log("On est Lundi");
		break;
  case 2:
		console.log("On est Mardi");
		break;
  case 3:
		console.log("On est Mercredi");
		break;
  case 4:
		console.log("On est Jeudi");
		break;
  case 5:
		console.log("On est Vendredi");
		break;
  case 6:
		console.log("On est Samedi");
		break;
}*/

/*var rep = Math.round(Math.random()*100);
var nbessais = 0;
do {
	nbessais++;
	var val = parseInt(prompt("Veuiller choisir un nombre entre 0 et 100"));
  if (val > rep) {
  	alert("C'est moins");
  }
  else if (val < rep) {
  	alert("C'est plus");
  }
  else {
  	alert("Bravo");
  }
}while(rep != val);
alert(`Tu as mis ${nbessais} essais`);*/

function estPremier(nombre) {
  if (nombre <= 1) return false;
  for (let i = 2; i <= Math.sqrt(nombre); i++) {
    if (nombre % i === 0) return false;
  }
  return true;
}

//verifier si un entier saisi est premier
console.log(estPremier(17));

console.log("Les 100 premiers nombres premiers sont :");
let count = 0;
let nombre = 2;
while (count < 100) {
  if (estPremier(nombre)) {
    console.log(nombre);
    count++;
  }
  nombre++;
}
