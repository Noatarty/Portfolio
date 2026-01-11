let maFenetre;
function ouvrirFenetre() {
  maFenetre = window.open("", "popUp", "width=250,height=100");
  maFenetre.document.write("<h1>Ceci est une fenêtre pop-up</h1>");
  maFenetre.focus();
}

function placerFenetre() {
  maFenetre.moveTo(100, 250);
}

function decalerFenetre() {
    maFenetre.moveBy(200, 0);
}

function redimensionnerFenetre() {
    maFenetre.resizeTo(500, 200);
}

function fermerFenetre() {
    maFenetre.close();
}

ouvrirFenetre();
placerFenetre();
decalerFenetre();
redimensionnerFenetre();