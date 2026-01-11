# TP intro systèmes

# prises de notes:

## Le Terminal :
Le Terminal permet de donner des ordres à l’ordinateur, ou plus précisément au Système d’Exploitation de l’ordinateur car c’est plutôt le Système qui contrôle l’ordinateur.Finalement, le Terminal est donc aussi une interface. Mais à la différence de l’Interface graphique, le Terminal est une interface texte : on tape des ordres au clavier. Ces ordress’appellent des commandes.

A savoir :Linux est donc un système qui peut être démarré sans interface graphique.le programme Terminal généralement se touve dans Applications > Utilitaires

## Le Shell :
Terminal ? Shell ? Je m’y perds... En fait, ce n’est pas vraiment le Terminal qui fait l’interface, mais ce fameux Shell, un logiciel qui tourne dans le Terminal. Le Terminal est juste là pour afficher le Shell et luidonner accès au clavier.C’est donc finalement le Shell qui fait réellement l’interface entre vous (par le clavier du Terminal) et l’OS.Par la suite, on s’accordera un abus de langage en parlant parfois de Terminal au lieu de Shell. On va donc les considérer comme équivalents, par simplicité.

## Les Prompts :
Un Shell a un fonctionnement très simple : 
1) Il attend un ordre, qu’on appelle une commande (on va voir ça en détail un peuplus loin).
2) Il exécute la commande en question.L’exécution de cette commande peut donner lieu à des affichages voire, ce qui
est assez rare, une certaine interaction avec l’utilisateur (affichage d’une question et saisie d’une réponse au clavier par exemple). Les affichages se font dans le Terminal.
3) Il se remet en attente d’une autre commande quand l’exécution de la précédente est terminée

Quand il est en attente d’une commande, il affiche ce qu’on appelle un prompt ou invite de commande en français. Ca se matérialise par l’affichage d’une ligne généralement terminée par un $.

## Les commandes :
A savoir :Le Shell dispose d’un historique des commandes tapées et il suffit d’utiliser les flèches vers le haut et vers le bas sur le clavier pour vous déplacer dans l’historique. Appuyez sur ENTRÉE pour exécuter celle choisie. CTRL+C permet de quitter l’historique.Vous pouvez aussi corriger une commande en vous déplaçant latéralement (flèche vers la gauche et vers la droite sur le clavier).Aussi lorsque l'on écris une commande :Tapez tout manuellement au clavier et respectez les espaces s’il y en a, mais n’en mettez pas s’il n’y en a pas. Tout a son importance !
### la syntaxe des commandes :
Le lancement d’une commande est constitué de la façon suivante : 

### commande option(s) paramètre(s)

● La partie commande est simplement l’ordre, l’action, qu’on souhaite exécuter. Dans l’exemple précédent (date), il s’agissait d’afficher la date et l’heure, vous l’aviez deviné et expérimenté. Évidemment, cette partie commande est obligatoire. 

● Une commande a toujours un comportement par défaut.La partie option(s) permet de modifier éventuellement ce comportement pardéfaut. Généralement, il peut y avoir 0, 1 ou plusieurs options qui se combinent alors. Mais si on ne précise pas d’option, c’est le comportement par défaut de la commande qui est obtenu.Il est très rare qu’une commande n’ait pas un comportement par défaut et qu’elle
nécessite au moins une option. Dans ce cas, c’est une option qui n'est pas facultative.Mais, c’est quand même très rare.Il est aussi très rare qu’une commande ne dispose pas d’au moins une option pour changer son comportement par défaut.Dans l’exemple précédent, on a commencé par une simple commande date qui aaffiché la date+heure du moment présent, c’est le comportement par défaut de lacommande date. Puis on a exécuté un date -u qui a affiché cette même date+heure mais décalée d’une ou deux heures dans le passé il s’agit toujours de la date+heure courante mais au format UTC, qui est l’heure Internationale. La présence du -u a ainsi changé le comportement par défaut de la commande. Chaque option commence par un “-”.Ce tiret est suivi d’un symbole,généralement une lettre ou un chiffre, sans espace !!! entre le tiret et le symbole (-u dans l’exemple avec la commande date). Attention !!! les minuscules et les majuscules ne sont pas interchangeables, un -u n’est pas identique un -U.Ces options sont spécifiques à chaque commande. Un -u pour la commandedate signifie quelque chose pour elle (ici l’affichage en modeUTC) mais un -u pour une autre commande signifiera autre chose, et peut même souvent ne pas exister du tout, ce que la commande vous dira certainement, par un message d’erreur, si vous lui passez une option inconnue pour elle.(Consultez le CM #1 qui explique comment on peut combiner certaines options et explique aussi qu’il existe des options longues, précédées de “--” (2 tirets) au lieu d’un seul).

● Enfin, la partie paramètre(s) indique généralement,sur quoi la commande doit agir (souvent des fichiers ou des dossiers).  La commande date n’est pas le bon exemple pour cette partie paramètre(s), nous allons voir d’autres exemples concrets très bientôt. En fonction des commandes, il peut y avoir plusieurs paramètre(s) qui seront alors séparés par des espaces.

### The Commande :
Voici maintenant sans doute la commande la plus importante à connaître sous Linux, une commande qu’il faut ABSOLUMENT connaître et utiliser ! Il s’agit de la commande man qui signifie manuel.lle donne accès au manuel, à la documentation de toutes les commandes Linux présentes sur votre système. Vous êtes bloqué sur une commande, vous vous demandez ce que fait telle option sur une commande ? Le réflexe doit être d’aller consulter le manuel ! En effet, Google n’est pas la solution. La solution, vous l’avez sous la main. Il existe de nombreuses versions différentes du manuel et Google n’a aucune idée de la version de Linux que vous utilisez. Par contre, le manuel local à votre machine correspond évidemment exactement à ce qui y est installé,donc: utilisez le manuel pas google.an est aussi une commande. Elle répond donc à la syntaxe vue précédemment.
Expérimentons la consultation du manuel de la commande date : man date
Très important : Ici man est la commande, alors que date est un paramètre passé à la commande man, et il n’y a pas d’option spécifiée (rappel, une option est précédée d’un tiret).On a vu que le paramètre indique la cible de la commande, sur quoi elle doit agir, quel est son sujet de travail. Ici la cible est simplement un texte (le mot “date”) indiquant le nom de la commande dont on souhaite voir le manuel (pour man la cible signifie voici le nom d’une commande qui m’intéresse). Il s’agit en l'occurrence de la commande date.
Attention, il n’y a qu’une seule commande exécutée, c’est la 1ère partie (man). Le reste (date) qui est, rappelons-le, un paramètre, est une simple information
texte qui informe la commande man. Donc même si date est aussi une commande qui existe (puisque,justement, on souhaite en consulter le manuel), elle n’est évidemment pas exécutée, cene serait pas ce que l’on souhaite.
Voyez le manuel comme un gros dictionnaire.

Se déplacer dans le manuel:
Maintenant que vous êtes dans le manuel, vous pouvez voir que votre Terminal est occupé à vous afficher du texte décrivant ce que fait la commande (date dans notre situation).Vous ne pouvez pas taper de nouvelle commande à exécuter, vous n’avez pas encore récupéré de prompt. C’est normal. On rappelle que le Terminal n’acceptera un nouvel ordre de votre part que lorsque la commande précédente sera terminée. En l’occurrence il s’agit de man, qui est encore en cours d’exécution. C’est une des rares commandes qui a un peu d’interaction avec l’utilisateur. Nous allons voir brièvement quelles interactions de base on peut avoir avec man. Généralement le contenu du manuel dépasse la hauteur d’une fenêtre (quand on est en environnement graphique) ou d’un écran. Vous pouvez utiliser les flèches haut et bas du clavier pour vous déplacer ligne par ligne. Vous pouvez utiliser la barre espace pour vous déplacer d’une page complète (i.e. une hauteur de fenêtre ou d’écran). Vous pouvez aussi appuyer sur la touche f comme forward.Pour revenir en arrière d’une page complète, utilisez la touche b comme backward (en arrière).Enfin, pour quitter le manuel, utilisez q comme quit. Et là, vous devez alors récupérer votre prompt dans le Terminal.

## Rappels sur les fichiers et les dossiers :
Avant de poursuivre sur d’autres commandes de base de Linux, il nous faut évoquer quelques notions concernant les fichiers et les dossiers. Les notions de fichiers et de dossiers doivent donc vous être familières.On appelle cela le Système de Fichiers ou File System (FS).

### Fichiers :
Un fichier est une sorte de conteneur dans lequel se trouvent des données, des informations. Vous en connaissez déjà certains types :

- Fichier image ou photo (JPEG ou PNG par exemple)
- Fichier vidéo
- Fichier son
- Fichier HTML
- Documents Word et Excel (ou Libre Office peut-être)

Notez que pour Word et Excel, on utilise plutôt le terme de document. Un document est un fichier mais un fichier n’est pas forcément un document. La différence est subtile et il s’agit principalement d’une sorte de convention. Un document est généralement associé à une application, souvent bureautique, c'est-à-dire qu’il faut disposer de cette application spécifique pour lire, manipuler, créer ce type de fichier.Il n’y a pas de problème à appeler tout ça des fichiers mais évitez d’utiliser le terme de document pour tout.Sous Linux, les fichiers sont très souvent des fichiers textes, c'est-à-dire des fichiers dont on peut facilement lire le contenu sans outil spécifique. Un fichier HTML par exemple est un fichier texte. Les fichiers son, vidéo ou image ne sont pas des fichiers textes.
On va apprendre à manipuler principalement des fichiers textes dans cette ressource.
Quelques caractéristiques:
Un fichier a obligatoirement un nom. Exemples : etudiants ou encore starwars.mp4
Un fichier peut avoir une extension, qui se matérialise par un point suivi delettres ou de chiffres. Exemples : tp1.c (le .c est l’extension). L’extension indique généralement la nature du fichier (ici il s’agit d’un code source en langage C) Un fichier a une taille qui indique combien d’ octets il contient. Cette taille peut être nulle, le fichier ne contient rien, mais le fichier existe, comme une simple boîte vide. Un fichier possède aussi une date de dernière modification (ou de création, au départ)Il existe d’autres caractéristiques.

### Dossiers :
Un dossier est aussi un conteneur, mais il ne contient pas des données comme les fichiers, il contient des fichiers et d’ autres dossiers qui, à leur tour, peuvent contenir des fichiers et d’autres dossiers etc. On représente souvent cette structure par un arbre dont les branches seraient les dossiers et les feuilles les fichiers.Cette notion de dossier doit donc aussi vous être familière. Sur votre ordinateur,personnel, vous devez avoir un dossier Documents ou Mes documents.À l’IUT vous avez chacun un espace de travail sur les ordinateurs. Cet espace de travail personnel est aussi un dossier, qui porte votre nom de login. Il y a donc autant de dossiers d’espace personnel qu’il y a d’étudiants. Dans cet espace de travail personnel vous avez déjà des sous-dossiers, et notamment un nommé Documents.
Quelques caractéristiques :
Un dossier a des caractéristiques similaires à celles d’un fichier :
nom,extension, et même taille et date de modification mais ces deux dernières sont un peu étranges quand on ne connaît pas leur fonctionnement, qu’on ne vas pas expliquer ici. On ne s’intéressera juste qu’à la partie nom+extension pour le moment.

## Manipulations de fichiers :
Quand vous ouvrez un Terminal, vous vous retrouvez toujours dans un dossier. Vous ne pouvez pas être nulle part.Le dossier par défaut de votre environnement de travail s’appelle votre Home directory.Home signifie chez soi, et directory signifie répertoire (qui est un autre nom pour dire dossier).On utilisera désormais indifféremment les termes dossier et répertoire, et on parlera de Home pour désigner ce répertoire par défaut, ce répertoire qui est la racine de tous vos dossiers et fichiers de travail personnels.
Vous avez ouvert un Terminal et vous avez bien noté ce qui est écrit un peu plus haut : dans un Terminal on est toujours ouvert dans un dossier. Mais, dans quel dossier ?Vérifions à l’aide d’une nouvelle commande :
pwd
qui signifie print working directory (afficher le répertoire de travail).Ne pas confondre le répertoire de travail(working directory) et le répertoire par défaut de votre espace personnel (qu’on appelle parfois aussi votre espace de travail, désolé pour la similitude d’appellation), celui-là s’appelle votre Home directory (on vient juste de le voir un peu avant).Le répertoire de travail est le répertoire dans lequel vous êtesactuellement, dans votre Terminal.Cette notion de répertoire de travail est donc intimement liée à votre Terminal. Si vous ouvrez plusieurs Terminaux, vous aurez donc un répertoire de travail dans chacun d’eux et il pourra être (et sera sans doute) différent d’un Terminal à l’autre, une fois que vous aurez vu comment on se déplace d’un répertoire à un autre, un peu plus loin.
Le résultat de pwd devrait vous donner une ligne du genre :
/home/etuinfo/votre_login ou peut-être /FILER/HOME/INFO/votre_login
C’est votre Home directory, en principe.

### Création d'un fichier vide :
Créez un fichier nommé test.txt à l’aide de la commande suivante :
touch test.txt
Quand on est en mode ligne de commande, on est dans un mode de fonctionnement qui n’est pas celui de l’utilisateur lambda avec son interface graphique. N’attendez pas qu’une commande vous dise “Voilà, j’ai fait ce que tu m’as demandé,tu as maintenant un nouveau fichier qui s’appelle test.txt”.
Le mode ligne de commande est un mode “J’ordonne, tu exécutes”. Une commande s’exécute généralement en silence. Si elle n’affiche pas un message d’erreur c’est que tout s’est bien déroulé.
Jusqu’à présent, les quelques commandes qu’on avait lancées (date, man, pwd) étaient des commandes de questionnement.Il était doncnormal qu’elles affichent un résultat à l’écran.Cette commande touch permet de créer un fichier vide , c’est ce qu’elle a fait, et rien d’autre n’est attendu d’elle. Rappel : une commande fait généralement une action simple, ici la création d’un fichier.Si on a besoin de vérifier que le fichier a été créé, et bien on va faire appel à une autre commande dont c’est le rôle, tout simplement :
ls
qui signifie list (lister les fichiers/dossiers).
Il est très probable que vous ayez plus de choses affichées que ce que vous attendiez.
Effectivement, vous avez déjà des fichiers et des dossiers dans
votre répertoire de travail, qui se trouve être aussi votre
Home directory si vous avez suivi strictement les étapes de ce TP. Et votre
Home contient déjà des choses, en
principe.

Arrêt a la page 17 sur 32