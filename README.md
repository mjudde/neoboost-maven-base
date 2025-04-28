# neoboost-maven-base
Projet pour le boost sur les bases de maven.

Projet maven minimaliste qui permet de se familiariser avec :
- la structure de base d'un projet maven
- le cycle de vie maven et les plugins configurés par défaut ([Documentation maven sur le cycle de vie](https://maven.apache.org/guides/introduction/introduction-to-the-lifecycle.html))

## Point important : 
- Identifiant du module
  + `groupId`* : id du groupe de projet. Correspond au dossier dans lequel sera stocké le(s) artifact(s) produits.
  + `artifactId`* : id du projet dans son groupe
  + `version`* : version du projet 
  + `packaging`: le type d'artifact produit. détermine le plugin de packaging qui sera utilisé lors de la phase package, ici maven-jar-plugin. Par défaut c'est 'jar'.

- Complément pour l'identifiaction on peut avoir : 
  + `name` : pour donner un nom au projet autre que son artifact id.
  + `description` : une description du projet

- `Properties` du projet : ce sont des variables utilisées ailleurs dans le projet (Dans le pom ou directement par les plugins)
  + `maven.compiler.source` : indique que le code source en entrée est en java 17 (Utilisé directement par le plugin maven-compiler-plugin)
  + `maven.compiler.target` : indique que le bytecode produit doit être en java 17 (Utilisé directement par le plugin maven-compiler-plugin)
  + `project.build.sourceEncoding` : indique que les sources du projet sont en UTF-8 (Utilisé par maven-resources-plugin)

- Balise `build` : permet de configurer le build maven. Avec avant tout : 
  + Les `plugins` maven à brancher sur le cycle. Ici on a juste modifié la version du plugin maven-surefire-plugin qui sert à lancer les tests JUnit 5. 
  + Les dépendances dans `dependencies`
    + Un dépendance à utiliser dans le code du projet
    + Une dépendance pour pouvoir faire des tests unitaires junit 5

## Structure d'un projet minimaliste
Voici la structure d'un projet maven basique. Par défaut les plugins (compiler, resources...) vont utiliser ces dossiers là.

+ `src` (Les entrées du build)
  + `main` (Le code du projet en lui-même)
    + `java` (Sources java)
    + `resources` (Resources)
  + `test` (Le code des tests)
    + `java` (Sources java)
    + `resources` (Resources)
+ `target` (Les sortie du build)
  + `classes` (Ressources et classes compilées projet en lui-même)
  + `test-classes` (Ressources et classes compilées des tests)

## Exécution du build

Si on lance la commande mvn clean install les plugins configurés par défaut (Voir la doc) vont s'exécuter les uns à la suite des  autres.

clean : va lancer un cycle clean jusqu'à la phase clean avec l'exécution des plugins suivant
- `maven-clean-plugin:2.5:clean` : goal `clean` du plugin `maven-clean-plugin` : va supprimer le dossier `target`.

install va lancer un cycle de build jusqu'à la phase install avec l'exécution des plugins suivant
- `maven-resources-plugin:2.6:resources` : goal `resources` du plugin `maven-resources-plugin` : va copier et potentiellement traiter les ressources présentes dans `src/main/ressources` pour les placer dans `target/classes`.
- `maven-compiler-plugin:3.1:compile` : goal `compile` du plugin `maven-compiler-plugin` : va compiler les sources java présentes dans `src/main/java` pour les placer dans `target/classes`.
- `maven-resources-plugin:2.6:testResources` : goal `testResources` du plugin `maven-resources-plugin` : va copier et potentiellement traiter les ressources présentes dans `src/test/ressources` pour les placer dans `target/test-classes`.
- `maven-compiler-plugin:3.1:testCompile` : goal `testCompile` du plugin `maven-compiler-plugin` : va compiler les sources java présentes dans `src/test/java` pour les placer dans `target/test-classes`.
- `maven-surefire-plugin:3.5.3:test` : goal `test` du `plugin maven-surefire-plugin` : va exécuter les tests unitaires.
- `maven-jar-plugin:2.4:jar` : goal `jar` du `plugin maven-jar-plugin` : va packager le target du projet dans un jar (Plugin configuré car on a dit plus haut que notre projet a un packaging jar dans la partie identification).
- `maven-install-plugin:2.4:install` : goal `install` du plugin `maven-install-plugin` : va installer les artifacts dans votre repository local (Par défaut dans `c:\users\<user>\.m2\repository`)

Chaque plugin à sa page de documentation, il n'y a qu'à taper son nom dans google.