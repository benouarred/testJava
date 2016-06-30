# Pet Clinic

## Scénario

Vous venez d'être recruté au 42eme étage et devez maintenant assurer la TMA du projet Pet Clinic.
C'est un système de gestion utilisé par plusieurs cliniques vétérinaires. La livraison est pour bientôt. Malheureusement il reste quelques bugs...
A vous de les corriger et de faire tout ce qui vous semble nécessaire pour que l'application soit exploitable.


## Indications

1- Commencer par l'exécution des tests unitaires sur tout le projet
Quelques tests en erreur...  
Le candidat doit être capable de lire la stack et de voir qu'il manque l'annotation @ContextConfiguration à la classe VetIntegrationTest

2- Exécution 2:

La méthode findPetEntries doit être implémentée	
Implémenter la méthode findPetEntries --> Le candidat doit reconnaitre la pagination et penser à regarder l'API

3- Exécution 3:

La méthode findPetsByTypeAndNameLike doit être implémentée
Le candidat doit se rendre compte du like et surtout à l'emplacement des %.

4- Exécution 4:

La méthode countOwners doit être implémentée
Le candidat doit être capable d'écrire la requête avec le count et de deviner le type de retour auquel il faut caster le single result (Number).

5- Exécution 5:
La méthode findVisitsByDescriptionAndVisitDate doit être implémentée
Le candidat doit être capable de lire le code existant car la solution est dedans en combinant les deux méthodes suivantes.

6- Maintenant que tous les test passent penser à lancer l'application.
Expliquer au candidat qu'il y a deux serveurs configurés au niveau du pom du projet: Tomcat et Jetty et lui donner le choix du serveur qu'il veux utiliser.
Voir si le candidat connait mvn tomcat:run ou mvn jetty:run sinon le faire pour lui pour avancer.

7- Essayer de créer les différentes entités --> Exception lors de la création du pet.
	Après la modification de la classe PetController, le test PetControllerTest échouera, il faut le modifier avant de redéployer

8- Eventuellement demander au candidat de dessiner le diagramme de classe des entités de l'application.

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
