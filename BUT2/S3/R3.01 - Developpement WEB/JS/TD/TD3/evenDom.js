let elem = document.getElementsByTagName("p")[0];
elem.addEventListener("mouseover",modifierTexte);
function modifierTexte(){
    document.getElementsByTagName("p")[1].textContent = "Bonjour";
}