# Test Recrutement :baseball: players

## Description du test au candidat
Nous avons ici une application qui permet de gérer / afficher des équipes de :baseball: . D'après la spécification chaque équipe qui sera affichée doit:

1. Afficher le **LOGO** de la MLB (Major League of :baseball: ),
2. Afficher **tous les joueurs** sans exception **selon leur position** (Il ne doit pas en manquer),
3. Corriger les bugs s'il y en a,
4. Améliorer le code.

## Objectifs
* Afficher le **LOGO**,
* Positionner le / les bon(s) modifier(s) sur les propriétés de beans,
 * Encapsuler correctement sur la propriété **firstName**.
* Utiliser les **Interfaces** plutôt que les **Implémentation** pour les types de données collections,
* Arriver à déduire qu'il est nécessaire de mettre en place de l'héritage pour ajouter le **Manager** _Jhon Farrell_,
* Utiliser Java 8 pour refactorer la partir *getPitchers*, *getOutfields* etc. ,
* Voir pour cleaner ce qui ne sert à rien (imports, méthodes redondantes...),

## Tableau récapitulatif attendues / expérience _Comment représenter cette partie?_
Résolution attendu / XP (années) | 1 			 | 2 			| 3 			| 4 
-------------------- | ------------- | -------------| ------------- | -------------
NullPointerException | ALL 	|	|	|
ClassCastException   |		|	|	|

## Pièges référencés
* La variable **LOGO** est déclarée context static mais est initialisée dans le block d'instance,
* Utillisation de propriétés direct sans utilisation de **getter** / **setter**, 
 * Permet de poser des questions sur l'encapsulation.
* Création d'une boucle infini :trollface: :

> L'appelle du **toString** _Team_ fait une référence au **toString** de _Player_ et forme un cycle.

* **ClassCastException** dans le _getPitcher / toArray_ :shit: ,
* Dans le **equals** de **Player** on utilise de manière érroné **==** mais celui ci retourne bien **true** et donc des références identiques! ,
 * :rage4: Permet de poser des questions sur la différence entre **Equals** et **==**
* Le **HashSet** de **Team** ne contient qu'un seul élément alors qu'on en ajoute 3 car les **Equals** et **HashCode** sont mal calculés,
* L'utilisation de **HashSet** permet de poser la question sur le pourquoi utiliser les Interface plutôt que les implémentations.

> Attention ici la _JVM_ optimise les **String** déclarés et les références comme étant dans le même espace mémoire, il est nécessaire de faire un **new**!

* Utilisation de getters :sparkles: qui font des appelles de méthode dans les getters du type **toLower**
 * Permet de facilement lever des **NullPointersExceptions** :scream:
 * Questions est ce qu'un Bean doit contenir du code métier?
* Utilisation de la méthode **addPlayerToTeam** de **Team** qui permet de poser des questions sur l'immutabilité et le cycle de vie des instances en mémoire (GC).
* Répétition d'opération **addAPlayerToATeam** dans le Main :see_no_evil:
 * Possibilité de faire refactorer selon plusieurs possibilité **while** / **foreach**
* Duplication de code dans le **getCatchers**, **getPitchers** ... etc
 * A quoi sert une classe utilitaire?
* La méthode **extractYear**
 * Problème de **lastIndexOf** il manque le +1
 * Le trim fait le job pour remonter l'année.
 * Mais il vaut mieux utiliser Calendar pour ça
 * Ou Joda Time en Java 8

## Remarques et possibilités de discution
* Constructeur à **4** paramètres,
 * Utilisation d'un Builder n'est elle pas plus pertinente?
 * Demander un autre pattern de conception OO.
* Possibilité d'utiliser Java 8,
 * Utilisation de l'API **java.time.LocalDate**  / **Joda Time** plus simple,
 * Utilisation de **BiFunction**, :dolphin:
 * **Predicate** pour différencier les types de joueur (pitchers etc)
* Est-ce logique de mettre toutes les classes dans le même package?

## Evolution possibles
* Demander à ce que le **toString()** de **Team** retourne la liste des joueur regroupé par type de poste
=> Une solution est de remplacer le **HashSet** par un **TreeSet**, puis d'implémenter le **compareTo** dans la classe **Player**. 
Attention pour bien faire il faut aussi réimplémenter le _equals()_ et _hashCode()_ 
* Possiblité d'ajouter le test chaine de caractère "null" et valeur null.
