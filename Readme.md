# Cloner le projet

```
git clone https://github.com/aaron101295/microservice-compte
```

# Compiler/builder le projet

```
mvn clean install
```
Cela va nous permettre de générer un .jar.

# Dockerisation

Construction de l'image Docker à partir du Dockerfile :
```
docker build -f Dockerfile -t microservice-compte . 
```

Lancement de notre image (i.e. de l'application) dans un conteneur :
```
docker run -p 8000:8000 microservice-compte
```
Pour information notre docker se lance sur l'IP 192.168.99.100.


# Exemple de requêtes

Méthode	| Path	| Description | Paramètres
------------- | ------------------------- | ------------- |:----------------:|
GET	| /compte/all	| Afficher tous les comptes	| | 
POST	| /compte/creer	| Créer un compte | Oui, cf Paramètres | 
DELETE	| /compte/supprimer/{id}	| Supprimer un compte	| | 
PUT	| compte/MAJCompte/{id}	| Modifier un compte| Oui, cf Paramètres | 
GET	| /compte/byType/{typedecompte}	| Rechercher un compte par type	| | 
GET	| /compte/byIban/{iban}	| Rechercher un compte par Iban	| | 

Paramètres :
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
