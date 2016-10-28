# Test Recrutement Baseball players

## Pièges référencés
* La variable **LOGO** est déclarée context static mais est initialisée dans le block d'instance.
* Utillisation de propriétés direct sans utilisation de **getter** / **setter** 
 * Permet de poser des questions sur l'encapsulation.
* Création d'une boucle infini:

> L'appelle du **toString** _Team_ fait une référence au **toString** de _Player_ et forme un cycle.

* Le **HashSet** de **Team** ne contient qu'un seul élément alors qu'on en ajoute 3 car les **Equals** et **HashCode** sont mal calculés.
* L'utilisation de **HashSet** permet de poser la question sur le pourquoi utiliser les Interface plutôt que les implémentations.
* Dans le **equals** de **Player** on utilise de manière érroné **==** mais celui ci retourne bien **true** et donc des références identiques.
 * Permet de poser des questions sur la différence entre **Equals** et **==**

> Attention ici la _JVM_ optimise les **String** déclarés et les références comme étant dans le même espace mémoire, il est nécessaire de faire un **new**!

* Utilisation de getters "magic" qui font des appelles de méthode dans les getters du type **toLower**
 * Permet de facilement lever des NullPointers
 * Questions est ce qu'un Bean doit contenir du code métier?
* Utilisation de la méthode **addPlayerToTeam** de **Team** qui permet de poser des questions sur l'immutabilité et le cycle de vie des instances en mémoire (GC).
* Répétition d'opération **addAPlayerToATeam** dans le Main
 * Possibilité de faire refactorer selon plusieurs possibilité **while** / **foreach**
* Duplication de code dans le **getCatchers**, **getPitchers** ... etc
 * A quoi sert une classe utilitaire?
* La méthode **extractYear**
 * Problème de **lastIndexOf** il manque le +1
 * Le trim fait le job pour remonter l'année.
 * Mais il vaut mieux utiliser Calendar pour ça
 * Ou joda time en java 8

## Remarques et possibilités de discution
* Constructeur à **4** paramètres
 * Utilisation l'un Builder n'est elle pas plus pertinente?
 * Demander un autre pattern de conception OO.
* Possibilité d'utiliser Java 8
 * Utilisation de la nouvelle API **Date** plus simple
 * Utilisation de **BiFunction**
 * **Predicate** pour différencier les types de joueur (pitchers etc)
* Est-ce logique de mettre toutes les classes dans le même package?

## Evolution possibles
* Demander à ce que le toString() de Team retourne la liste des joueur regroupé par type de poste
=> Une solution est de remplacer le HashSet par un TreeSet, puis d'implémeter le compareTo dans la classe Player. 
Attention pour bien faire il faut aussi réimplémenter le equal() et hasCode() 
* Possiblité d'ajouter le test chaine de caractère "null" et valeur null.
