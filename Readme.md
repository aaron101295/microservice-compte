# Projet microservices

Vous trouverez le rapport du projet [ici](https://github.com/aaron101295/microservice-compte/blob/master/Documentation/Rapport/Projet%20microservices%20Aaron%20LELLOUCHE%20Rapha%C3%AAl%20UZAN.pdf).

# Cloner le projet

```
git clone https://github.com/aaron101295/microservice-compte
```

# Compiler/builder le projet

```
mvn clean install
```
Cela va nous permettre de g�n�rer un .jar.

# Dockerisation

Construction de l'image Docker � partir du Dockerfile :
```
docker build -f Dockerfile -t microservice-compte . 
```

Lancement de notre image (i.e. de l'application) dans un conteneur :
```
docker run -p 8000:8000 microservice-compte
```
Pour information notre docker se lance sur l'IP 192.168.99.100.


# Exemple de requ�tes

M�thode	| Path	| Description | Param�tres
------------- | ------------------------- | ------------- |:----------------:|
GET	| /compte/all	| Afficher tous les comptes	| | 
POST	| /compte/creer	| Cr�er un compte | Oui, cf Param�tres | 
DELETE	| /compte/supprimer/{id}	| Supprimer un compte	| id | 
PUT	| compte/MAJCompte/{id}	| Modifier un compte| Oui, cf Param�tres | 
GET	| /compte/byType/{typedecompte}	| Rechercher un compte par type	| typedecompte | 
GET	| /compte/byIban/{iban}	| Rechercher un compte par Iban	| iban | 

Param�tres :
```
{
    "id": "xxx",
    "iban": "xxx",
    "typedecompte": "xxx",
    "interet": "xxx",
    "frais": "xxx",
    "solde": "xxx"
}
```
