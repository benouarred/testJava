# Test TodoList

## Objectifs

Tester quels outils, frameworks et librairies (JS ou CSS) le candidat met en oeuvre pour développer une application Web moderne
ainsi que leurs niveaux de maîtrise.

Pour cela, le candidat doit développer la partie Front End d'application web de type TodoList.
Un serveur node.js sert les fichiers statiques (HTML, CSS, JS) et expose des ressources REST.

Le candidat doit avoir accès à Internet et à libre choix des outils, frameworks et libraires qu'il veut utiliser.

La seule contrainte est que l'application doit être de type Single Page Application.

## Installation

Pour installer ce projet sur le poste du candidat :

1. Récupérer le code source
2. Se placer dans le répertoire `server` et exécuter la commande ```node todolist``` pour démarrer le serveur
3. Se placer dans le répertoire `front` et exécuter la commande `grunt server` pour démarrer le server statique
5. Afficher la page [http://localhost:8888](http://localhost:8888) dans le navigateur si ce n'est pas fait automatiquement.
6. Une page avec les instructions doit alors s'afficher
7. L'environnement de test est prêt.

## Important

* Le candidat n'a pas à modifier la partie serveur.

## API Server

* ```GET     /api/todos``` Récupérer la liste des todos
* ```GET     /api/todos/:id ```  Récupérer un todo
* ```POST    /api/todos``` Créer un todo
* ```PUT     /api/todos/:id``` Mise à jour d'un todo
* ```DELETE  /api/todos/:id``` Suppression d'un todo

## Contact

* guedes.b@sfeir.com
* lau.t@sfeir.com
