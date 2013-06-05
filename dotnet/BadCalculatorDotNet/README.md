# Bad Calculator

## Scénario

Vous venez d'être recruté au 42eme étage et devez maintenant assurer la TMA du projet Calculator.
C'est un système critique utilisé au coeur du SI d'un grande banque. La livraison est pour bientôt. Malheureusement il reste quelques bugs...
A vous de les corriger et de faire tout ce qui vous semble nécessaire pour que ce code soit maintenable et évolutif.

## Indications

Cet exercice est trivial est a pour but de vérifier les compétences de base en .NET:
- equals VS ==
- manipulation de String
- logs
- refactoring
- concepts Objet
- encoding de charactères (le fichier Calculatr est encodé en UTF-8 mais contient le charactère é encodé une fois en UTF-8 une autre en ISO-8859)

Bien indiquer au candidat de s'imaginer que le code est plus complexe (des milliers de lignes de code) et ne pas hésitez à mettre en oeuvre des solutions qui serait surdimensionnées pour gérer seulement 10 lignes de code.
Lui rappeler que le projet est mavenisé s'il veut utiliser d'autres librairies (au hazard Junit) 

Il n'y a pas une seule solution, l'idée est de voir quels sont ses réflexes.

## Exemple d'améliorations possibles

- remplacer les indexOf par String.split ou une RegExp
- remplacer les if par un switch
 - avec ou sans enum
- remplacer les if par des objets + polymorphisme
- supprimer le code dupliqué (Integer.parse ...) par refactoring
- ...
