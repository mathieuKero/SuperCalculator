## Installation et mise en place. 

Pour partir de 0, il faut reprendre un projet source contenant un gradle. 

* Supprimer les fichiers / dossiers suivante => ils sont présent à la racine, si vous ne les trouvez pas c'est qu'ils ne sont pas présents :
  * /.gradle
  * /.settings
  * /.git
  * /bin
  * .classpath
  * .project

* On lance le BAT => gradlew.bat avec la commande 

> ./gradlew.bat

* On prépare Eclipe pour recevoir le projet 

> ./gradlew.bat cleanEclipse eclipse 

* Pour la suite, on a juste à importer le projet dans eclipse (File => Import => Existing project into workspace)

## Publier et livrer vos modifications 

Si vous instanciez votre projet pour la 1ère fois :

> git init

Vérification des modifications courantes

> git status

Avant tout assusrez vous que vous êtes synchronisés avec le dépot git

> git pull

Ajout des fichier temporaires sur le repository Git

> git add [vos fichier à ajouter]

Validation et commit

> git commit -m "[votre message]"

Si vous n'avez pas lié votre projet au git 

> git remote add remote https://github.com/mathieuKero/SuperCalculator.git

Pour changer de branche et publier sur les branches correspondantes 

> git checkout [nom de branche]

Il existe différentes branches :
* Mathieu
* Damien
* Sofiane
* Master

Une fois votre branche sélectionnée, pushez vos modifications sur le répertoire correspondant

si c'est la première fois

> git push -u remote [nom de branche] 

Sinon 

> git push
