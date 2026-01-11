*** Settings ***

Library         SeleniumLibrary
Library         Process

Suite Setup     Start Services
Suite Teardown  Stop Services


*** Keywords ***

Start Services
    # commenter les deux lignes si php doit être lancé dans l'hôte
    ${php} =  Start process  /usr/bin/php  -S  localhost:8000
    Set suite variable  ${php}
    # ouvrir le navigateur firefox
    Open browser  about:blank  headlessfirefox
    Set Window Size  @{WINSIZE}

Stop Services
    # fermer le navigateur (toutes ses fenêtres)
    Close All Browsers
    # commenter la ligne suivante si php a été lancé dans l'hôte
    Terminate process  ${php}


*** Variables ***

# inverser les commentaires si php a été lancé dans l'hôte
${URL} =  http://localhost:8000              # si le serveur PHP est dans le container
#${URL} =  http://host.docker.internal:8100   # si le serveur PHP est dans l'hôte

@{WINSIZE} =  1280  1024


*** Test Cases ***

Test Contenu général de la page
    Go to  ${URL}
    Page Should Contain Element  //h2[text()="Modal Login Form"]
    Page Should Contain Element  //button[text()="Login"]
    Page Should Contain Element  //div[@id="id01"]

Test Le bouton Login montre le dialogue modal
    Go to  ${URL}
    # TODO vérifier que le <div id="id01"> n'est pas visible
    # TODO cliquer sur le bouton  Login de la page
    # TODO vérifier que le <div id="id01"> est visible
    Capture Page Screenshot

Test Le dialogue modal doit être complet
    Go to  ${URL}
    # TODO cliquer sur le bouton  Login de la page
    # TODO un élément <input type="text" name="uname"> doit être visible
    # TODO un élément <input type="password" name="psw"> doit être visible
    # TODO un élément <input type="checkbox" name="remember"> doit être visible
    # TODO un élément <button type="submit"> doit être visible
    # TODO un élément <button type="button">Cancel</button> doit être visible
    # TODO un élément <span class="close"> doit être visible

Test Annulation du formulaire
    Go to  ${URL}
    # TODO cliquer sur le bouton  Login de la page
    # TODO cliquer sur le bouton  Cancel du formulaire
    # TODO vérifier que le <div id="id01"> n'est pas visible

Test Fermeture du formulaire
    Go to  ${URL}
    # TODO cliquer sur le bouton  Login de la page
    # TODO cliquer sur le bouton  <span class="close">
    # TODO vérifier que le <div id="id01"> n'est pas visible

Test Saisie infos avec remember
    Go to  ${URL}
    # TODO cliquer sur le bouton  Login de la page
    # TODO saisir le nom  Robot Framework
    # TODO saisir le mot de passe  any password will succeed
    # TODO cocher la case  remember
    # TODO cliquer sur le bouton  submit
    # TODO vérifier que l'emplacement est  ${URL}/post_login.php
    Capture Page Screenshot
    # TODO la page doit contenir  Bonjour Robot Framework
    # TODO la page doit contenir  Je ne t'oublierai pas.

Test Saisie infos sans remember
    Go to  ${URL}
    # TODO cliquer sur le bouton  Login de la page
    # TODO saisir le nom  Broken Framework
    # TODO saisir le mot de passe  only this password will succeed
    # TODO décocher la case  remember
    # TODO cliquer sur le bouton  submit
    # TODO vérifier que l'emplacement est  ${URL}/post_login.php
    Capture Page Screenshot
    # TODO la page doit contenir  Bonjour Broken Framework
    # TODO la page ne doit pas contenir  Je ne t'oublierai pas.

