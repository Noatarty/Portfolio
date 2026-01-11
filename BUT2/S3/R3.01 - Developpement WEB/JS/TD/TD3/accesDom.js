//contenu du 1er .lang
let lang = document.querySelector(".lang");

console.log(lang.innerHTML);

//contenu du 2ème paragraphe
let p = document.getElementsByTagName("p")[1];

console.log(p.innerHTML);

//elements contenu dans le 2ème .bloc
let bloc = document.getElementsByClassName("bloc")[1];

console.log(bloc.innerHTML);

//contenu du #titre1
let titre = document.getElementById("titre1");

console.log(titre.innerHTML);

//contenu du 2ème #deux .lang
let lang2 = document.querySelectorAll("#deux .lang")[1];

console.log(lang2.innerHTML);