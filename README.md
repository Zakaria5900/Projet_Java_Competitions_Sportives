# Projet Conception et programmation orientées Objet
# nom: Competitions Sportives
# realisée par: Salah Zakaria OUAICHOUCHE


introduction sur le sujet du projet
-----------------------------------
# Competitions Sportives definie un ensemble de match entre competiteur et a la fin y a toujour un gagnant et en generale ya deux type de competitions les championnats (League) et les tournois (Tournament) et chaqu'un ca specification 


Récupération du dépôt
---------------------
```
 git clone https://github.com/Zakaria5900/Projet_Java_Competitions_Sportives.git
 ```

Génération de la documentation
------------------------------
- la commande Generat Javadoc... du Projet

Génération de l’archive du projet
----------------------------------
- la commande Export... du menu File. Dans la rubrique Java choisissez JAR File.


Présentation d'éléments de code saillant
-----------------------------------------
- Les deux classe League et Tournament hyrite de la Classe Competition.
- MatchAleatoire implemante l'interface Match.
- dans les testes y a les classes LeagueTest et TournamentTest qui herite de la Classe CompetitionTest.
- En bassant sur les principe vu en cours principe Ouvert Fermée ...

Les diagrammes UML
------------------
- UML__Competitions_Sportives_V0: montre les classes et les relations entre ces classes (Heritage, Interface...)

- UML__Competitions_Sportives_V1: illustre en plus de la V0 MainRandomLeague et MainRandomTournament

- la version crée en eclipse dans src/competition_V1.ucls

"Competitions Sportives V2"
===========================

introduction sur la Version 2 du projet
----------------------------------------
# On ajoute un nouveau type de competition, "les Master", qui font s’affronter les competiteurs en deux phases, une phase de poules a l’issue de laquelle certains competiteurs sont selectionnes pour disputer la phase finale du tournoi. Les poules sont organisees sour forme de championnat tandis que la phase finale se deroule sous la forme d’un tournoi a elimination directe.

Présentation d'éléments de code saillant
----------------------------------------
- On a garder la meme organisation que la version 1 avec un refactoring du code.
- La Classe Master est abstact qui herite de Competition, Master c'est type de Competition.
- On peut avoir plusieur types de Master par exemple MasterQuatre, MasterTrois aui herite de la Classe Master.
- On a utiliser l'heritage pour respecter le principe Ouvert a l'evolution, Fermer a la modification, ainsi on assure une application qui peut evoluer dans le temps.
- On a utiliser le design pattern : strategy pour la sélection des competiteurs

Les diagrammes UML
------------------
- UML__Competitions_Sportives_V2: montre les classes et les relations entre ces classes (Heritage, Interface...), surtout l'heritage qui nous interesse pour la V2,  on as decidé de ne pas presenter la les classes Main dans le diagramme UML par sousi le lisibilité. 

- la version crée en eclipse dans src/competition_V2.ucls

"Competitions Sportives V3"
===========================
introduction sur la Version 2 du projet
----------------------------------------
# Journalistes et Bookmakers
Les competitions sont d´esormais si populaires que les media et les parieurs s’y interessent. Des journalistes peuvent donc assister aux competitions et diffuser les resultats des matchs. On considere que la diffusion d’un resultat se fait par l’affichage dudit resultat dans la sortie standard. Les bookmakers, quant a eux, font evoluer les cotes des competiteurs en fonction des resultats des matchs de la competition. Ils maintiennent une liste des cotes des competiteurs qu’ils affichent et font evoluer en fonction des victoires (diminution de la cote) et des d´efaites (augmentation de la cote). Par exemple, “Victoire de Lea (cote 4) face a Audrey (cote 1). La cote de Lea passe a 3, celle d’Audrey a 2”. Lorsqu’un journaliste ou un bookmaker vient assister a une competition, il assiste a tous les matchs de cette derniere.

Présentation d'éléments de code saillant
----------------------------------------
- On a garder la meme organisation que la version 2 avec un refactoring du code.
- L'interface CompetitionObserver
- La classe Bookmakers qui implimente l'interface CompetitionObserver
- La classe Journalist qui implimente l'interface CompetitionObserver
- On a utiliser le design pattern : observer pour les reporters et les bookmakers viennent observer les matchs

Les diagrammes UML
------------------
- UML__Competitions_Sportives_V3: montre les classes et les relations entre ces classes (Heritage, Interface...),  on as decidé de ne pas presenter la les classes Main dans le diagramme UML par sousi le lisibilité comme pour la V2. 
- la version crée en eclipse dans src/competition_V3.ucls
