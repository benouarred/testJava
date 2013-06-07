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
2. Ouvrir un terminal et se placer à la racine du projet
3. Exécuter la commande ```npm install``` pour installer les dépendances du projet. (Normalement, cette étape n'est pas
obligatoire car le dossier node_modules accompagne le projet
4. Exécuter la commande ```node todolist``` pour démarrer le serveur
5. Afficher la page [http://localhost:3000](http://localhost:3000) dans la navigateur
6. Une page avec les instructions doit alors s'afficher
7. L'environnement est prêt.

## Important

* Les fichiers statiques (HTML, CSS, JS) doivent se trouver dans le répertoire  ```/public```.
* Le candidat n'a pas à modifier la partie serveur.

## API Server

* ```GET     /todos``` Récupérer la liste des todos
* ```GET     /todos/:id ```  Récupérer un todo
* ```POST    /todos``` Créer un todo
* ```PUT     /todos/:id``` Mise à jour d'un todo
* ```DELETE  /todos/:id``` Suppression d'un todo

## Contact

* guedes.b@sfeir.com
* lau.t@sfeir.com
