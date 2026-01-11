*** Settings ***

Library         SeleniumLibrary         # https://robotframework.org/SeleniumLibrary/SeleniumLibrary.html

Suite Setup     Setup Browser
Suite Teardown  Teardown Browser


*** Keywords ***

Setup Browser
    Open Browser  about:blank  headlesschrome
    ...  options=add_argument("--no-sandbox")
    #Open Browser  about:blank  headlessfirefox
    Set Selenium Timeout  10
    Set Window Size  @{WINSIZE}

Teardown Browser
    Close All Browsers


*** Variables ***

${URL_WWW} =    http://host.docker.internal:8000
#${URL_WWW} =    https://www.wikipedia.fr

${URL_FR} =    http://host.docker.internal:8000/fr
#${URL_FR} =    https://fr.wikipedia.org

${URL_EN} =    http://host.docker.internal:8000/en
#${URL_EN} =    https://en.wikipedia.org


@{WINSIZE} =  1024  768


*** Test Cases ***

Test Titre de la page d'accueil de Wikipedia.fr
    Go to  ${URL_WWW}/
    Wait Until Location Is  ${URL_WWW}/
    ${title} =  Get Title
    Should Contain  ${title}  Portail de recherche
    Capture Page Screenshot

