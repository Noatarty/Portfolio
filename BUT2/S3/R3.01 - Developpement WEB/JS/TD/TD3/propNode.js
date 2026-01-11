//inserer dans article deux paragraphes p contenant le nom et le type du noeud article
let article = document.querySelector("article");
let p = document.createElement("p");
p.textContent = article.nodeName;
article.appendChild(p);
p = document.createElement("p");
p.textContent = article.nodeType;
article.appendChild(p);