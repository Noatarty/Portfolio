# TP 3

## listes commandes
which
ps
ps -edf
fg/bg
kill
### listes signaux
kill -9 <PID>
un CTRL+C envoie un signal 15 qui s’appelle TERM (comme TERMinate)
CTRL+Z envoie un signal 20 qui s’appelle TSTP (comme TerminalSToP)
## Notes
NE PAS CONFONDRE : Un processus n’est pas un fichier. On utilise une commande, dont les actions sont décrites dans un fichier sur disque, pour produire, en mémoire, un processus.
cas spécial car cd n’est pas une commande du système mais une commande interne du Shell.Il y a quelques autres commandes de ce type, mais elles sont extrêmement rares, exit et logout sont deux autres exemples.
Pour lister les processus en cours d’exécution en mémoire, on utilise la commande ps qui
signifie process(es) status, état des processus.
Chaque ligne représente un processus en cours d’exécution. Une ligne est composée (au
moins) des champs suivants :
● PID : le Process ID, l’identifiant numérique unique de chaque processus.
● TTY : le Terminal qui est attaché au processus. Pour faire simple, c’est le Terminal3
qui a lancé la commande qui a engendré ce processus. Attaché signifie que si le
processus a besoin d’acher des choses ou de lire au clavier, ce sera possible
uniquement sur le TTY (le Terminal) attaché au processus.
● TIME : le temps d’exécution que le processus a consommé. On y revient un peu
plus loin.
● CMD : la commande qui a été utilisée pour engendrer ce processus. On y trouvera
aussi les options et les paramètres éventuels.
