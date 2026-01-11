//Mettre le nom des classes du header dans les deux paragraphes p
let tabClass = document.querySelector("header").classList;
document.getElementsByTagName("p")[0].textContent=tabClass[0];
document.getElementsByTagName("p")[1].textContent=tabClass[1];

//Remplacer la classe monStyle2 par monStyle1 dans le header
document.querySelector("header").classList.replace("monStyle2","monStyle1");