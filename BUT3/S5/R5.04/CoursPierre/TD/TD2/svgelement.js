/**
 * Cette classe construit un mixin sur un élément du DOM
 * Elle est destinée à faciliter la création et la gestion d'éléments
 * d'un arbre <svg>.
 * @author Pierre Nerzic pierre.nerzic@univ-rennes.fr
 */
class SVGelement {
  // namespace pour tous les éléments créés par ces méthodes
  static NS = 'http://www.w3.org/2000/svg'

  /**
   * Cette méthode cherche l'élément du DOM désigné par selector
   * et lui ajoute les méthodes de SVGelement pour en faire un mixin
   * Exemple: const svg = SVGelement.fromSelector("#dessin")
   * Exemple: const defs = svg.fromSelector("defs")
   * @param {string} selector - sélecteur CSS désignant un unique Element
   * @returns {SVGelement} l'élément désigné sous forme d'un mixin
   * @throws exception si le sélecteur n'est pas correct
   */
  static fromSelector(selector) {
    const nodes = document.querySelectorAll(selector)
    // vérifier que le sélecteur désigne un élément unique
    if (nodes.length !== 1) {
      throw `element identifier "${selector}" is either absent, or not unique`
    }
    let element = nodes[0]
    // lui affecter les méthodes de la classe SVGelement
    return SVGelement.fromElement(element)
  }
  fromSelector(selector) {
    const nodes = this.querySelectorAll(selector)
    // vérifier que le sélecteur désigne un élément unique
    if (nodes.length !== 1) {
      throw `element identifier "${selector}" is either absent, or not unique`
    }
    let element = nodes[0]
    // lui affecter les méthodes de la classe SVGelement
    return SVGelement.fromElement(element)
  }

  /**
   * Retourne true si this a au moins un sous-élément identifié par le sélecteur
   * @param {string} selector - sélecteur CSS désignant un unique Element
   * @returns true si this.querySelectorAll(selector) n'est pas vide
   */
  hasSelector(selector) {
    const nodes = this.querySelectorAll(selector)
    return nodes.length >= 1
  }

  /**
   * Cette méthode ajoute les méthodes de SVGelement à l'élément du DOM
   * Ex: const svg = SVGelement.fromElement(document.getElementById("dessin"))
   * @param {Element} element - élément du DOM à transformer en SVGelement
   * @returns {SVGelement} le mixin élément + SVGelement
   */
  static fromElement(element) {
    if (element === undefined || element === null) return element
    // ajout des méthodes pour faire un mixin sur l'élément
    // NB: Object.assign(element, SVGelement.prototype) n'est pas utilisable
    for (let funcName of Object.getOwnPropertyNames(SVGelement.prototype)) {
      if (funcName !== "constructor") {
        element[funcName] = SVGelement.prototype[funcName]
      }
    }
    return element
  }

  /**
   * Affecte plusieurs attributs de this en même temps
   * Exemple: rect.setAttributes({width: 5, fill: "red"})
   * @param {dictionnaire {nom: valeur, ...}} attributes
   * @returns this pour pouvoir chaîner les appels
   */
  setAttributes(attributes) {
    for (const [name, value] of Object.entries(attributes)) {
      if (value === null) {
        this.removeAttribute(name)
      } else {
        this.setAttribute(name, value)
      }
    }
    return this
  }

  /**
   * Ajoute un enfant en dernier, avec des attributs.
   * L'élément créé est placé dans le namespace SVG.
   * Ex: let line = svg.appendElement("path", {d: "M 0 0 H 2", stroke: "red"})
   * @param {string} name - nom de l'élément <nom> à créer
   * @param {object} attributes - optionnel, voir setAttributes
   * @param {boolean} ifAbsent - quand il est vrai, n'ajoute cet élément que s'il n'est pas présent
   * @returns l'élément enfant en tant que SVGelement
   */
  appendElement(name, attributes={}, ifAbsent=false) {
    // est-ce que l'élément existe ?
    let child = document.querySelector(name)
    if (ifAbsent !== true || child === null) {
      // créer l'élément dans le DOM et le bon namespace
      const domChild = document.createElementNS(SVGelement.NS, name)
      child = SVGelement.fromElement(domChild)
      this.appendChild(child)
    }
    // lui donner ses attributs
    child.setAttributes(attributes)
    // retourner l'élément créé
    return child
  }

  /**
   * Méthode pour ajouter un enfant en premier, avec des attributs.
   * L'élément créé est placé dans le namespace SVG.
   * Ex: let defs = svg.prependElement("defs")
   * @param {string} name - nom de l'élément <nom> à créer
   * @param {object} attributes - optionnel, voir setAttributes
   * @param {boolean} ifAbsent - quand il est vrai, n'ajoute cet élément que s'il n'est pas présent
   * @returns l'élément enfant en tant que SVGelement
   */
  prependElement(name, attributes={}, ifAbsent=false) {
    // est-ce que l'élément existe ?
    let child = document.querySelector(name)
    if (ifAbsent !== true || child === null) {
      // créer l'élément dans le DOM et le bon namespace
      const domChild = document.createElementNS(SVGelement.NS, name)
      child = SVGelement.fromElement(domChild)
      this.prepend(child)
    }
    // lui donner ses attributs
    child.setAttributes(attributes)
    // retourner l'élément créé
    return child
  }

  /**
   * Méthode pour remplacer le texte existant (ou pas)
   * Ex: svg.appendElement("text").setText("Ok")
   * @param  {string} text - texte à mettre dans l'élément
   * @returns {SVGelement} l'élément pour pouvoir chaîner les appels
   */
  setText(text) {
    this.textContent = text
    return this
  }

  /**
   * Méthode pour ajouter du texte à la suite de l'existant
   * Ex: svg.appendElement("text").appendText("Ok")
   * @param  {string} text - texte à ajouter à l'élément
   * @returns {SVGelement} l'élément pour pouvoir chaîner les appels
   */
  appendText(text) {
    this.textContent += text
    return this
  }

  /**
   * Méthode qui retourne la liste des SVGelement ayant ce nom de balise
   * parmi les éléments enfants de element.
   * C'est simplement un appel à getElementsByTagNameNS sur le bon namespace
   * @param {string} name - nom de la balise
   * @returns {SVGelement[]} éléments de ce nom de balise sous element
   */
  getElementsByTagName(name) {
    const elemlist = this.getElementsByTagNameNS(SVGelement.NS, name)
    return Array.from(elemlist).map((elem) => SVGelement.fromElement(elem))
  }

  /**
   * Méthode qui retourne l'élément englobant this et correspondant à selector
   * @param {string} selector - sélecteur CSS pour désigner l'élément parent voulu, "svg" par défaut
   * @returns {SVGelement} l'élément <svg> contenant this
   */
  getClosestParent(selector="svg") {
    return SVGelement.fromElement(this.closest(selector))
  }

  /**
   * Méthode qui crée un identifiant aléatoire
   * @returns {string} identifiant
   */
  static makeid() {
    return 'id_' + window.crypto.randomUUID().slice(0, 8)
  }
}
