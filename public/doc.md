
vous allez voir un paquet de mauvaises pratiques
je fais les choses d'une certaine façon, il y a plus éléguant ... mais ...


##Structure de l'application

je mets le code de mon application Backbone dans un objet global

    window.App = {
        Models: {},
        Collections: {},
        Routers: {},
        Views: {},
        init: function(){
            App.router = new App.Routers.main();
            Backbone.history.start();
        }
    };

    $(function() {
        App.init();
    });

###Notations

- "Classes" & objets : Pascal Case
- instances : CamelCase


    //TODO : twitter account vs image name

    /*
    window.k33g = new this.Models.Player({
        firstName:"Philippe",
        lastName:"Charrière",
        twitter : "k33g_org",
        framework:"Backbone",
        picture:"k33g_org"

    });

    window.sebmade = new this.Models.Player({
        firstName:"Sébastien",
        lastName:"Letélié",
        twitter : "sebmade",
        framework:"Angular",
        picture:"sebmade"
    });

    window.tchak13 = new this.Models.Player({
        firstName:"Paul",
        lastName:"Chavar",
        twitter : "tchak13",
        framework:"Ember",
        picture:"tchak13"
    });
    */

        //window.players = new this.Collections.Players([ sebmade, tchak13, k33g]);


fights.at(1).set({opponentOneScore:2,opponentTwoScore:4})