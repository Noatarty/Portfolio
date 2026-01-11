*** Settings ***

Library  OperatingSystem    # https://robotframework.org/robotframework/latest/libraries/OperatingSystem.html


*** Test Cases ***

Fichier ne doit pas exister
    File Should Not Exist  nonexistent.png

Dossier tests doit exister et ne pas être vide
    Directory Should Exist  tests
    Directory Should Not Be Empty  tests

