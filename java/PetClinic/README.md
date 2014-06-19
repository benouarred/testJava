# Pet Clinic

## Scénario

Vous venez d'être recruté au 42eme étage et devez maintenant assurer la TMA du projet Pet Clinic.
C'est un système de gestion utilisé par plusieurs cliniques vétérinaires. La livraison est pour bientôt. Malheureusement il reste quelques bugs...
A vous de les corriger et de faire tout ce qui vous semble nécessaire pour que l'application soit exploitable.


## Indications

1- Commencer par l'exécution des tests unitaires sur tout le projet
Quelques tests en erreur...  
Le candidat doit être capable de lire la stack et de voir qu'il manque l'annotation @ContextConfiguration à la classe OwnerIntegrationTest

2- Exécution 2:

La méthode findOwnerEntries doit être implémentée	
Implémenter la méthode findOwnerEntries --> Le candidat doit reconnaitre la pagination et penser à regarder l'API

3- Exécution 3:

La méthode findVisitsByDescriptionLike doit être implémentée
S'inspirer de la méthode findVisitsByDescriptionAndVisitDate: Le candidat doit se rendre compte du like 

4- Réexécuter les tests après correction:

La méthode findPetsByNameAndWeight doit être implémentée
Le candidat doit être capable de lire le code existant car la solution est dedans en combinant les deux méthodes suivantes.	

5- Maintenant que tous les test passent penser à lancer l'application.
Voir si le candidat connait mvn jetty:run sinon le faire pour lui pour avancer.

6- Essayer de créer les différentes entités --> Exception lors de la création du owner.
		if (id != null)
			throw new IllegalArgumentException("An Identifier is required"); 
Le test inverse est vrai!


7- Eventuellement demander au candidat de dessiner le diagramme de classe des entités de l'application.

Cet exercice est trivial et a pour but de vérifier les compétences de base des outils utilisés sur les projets Java:
- JUnit
- Spring
	- Gestion des contextes (par annotation)
- Maven
	- Test Unitaires
	- Test d'Intégration
	- Génération d'un war
- logs
	- Maven
	- JUnit
- Ecrire de requêtes SQL
	- find
	- like

L'idée est d'accompagner le candidat, non pas l'assister, dans les démarches à entreprendre.
Voir s'il est à l'aise avec les logs et s'il est capable de les interpréter facilement.
Observer ses réactions face aux problèmes et laisser la possiblité d'aller sur internet (ce qui permet de voir quelles sont ses habitudes).
