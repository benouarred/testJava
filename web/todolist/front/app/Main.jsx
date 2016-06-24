var React = require('react');
var ReactDOM = require('react-dom');


var Main = React.createClass({
    render: function () {
        return (
            <section>
                <h1>Montrez nous comment vous développez une application Web moderne !</h1>

                <section>
                    <header><h1>Votre objectif</h1></header>
                    <ul>
                        <li>Développer la partie Front End d'une application single page de type todoList</li>
                        <li>Un serveur node.js expose des ressources RESTful au format json
                            <ul>
                                <li>GET     <a href="/server/api/todos">/server/api/todos</a></li>
                                <li>GET     <a href="/server/api/todos/1">/server/api/todos/1</a></li>
                                <li>POST    /server/api/todos</li>
                                <li>PUT     /server/api/todos/:id</li>
                                <li>DELETE  /server/api/todos/:id</li>
                            </ul>
                        </li>
                        <li>Votre application doit pouvoir
                            <ul>
                                <li>Afficher la liste des todos</li>
                                <li>Afficher les détails d'un todo</li>
                                <li>Créer un todo</li>
                                <li>Supprimer un todo</li>
                                <li>Mettre à jour un todo</li>
                            </ul>
                        </li>
                        <li>Vous avez libre choix des frameworks et librairies</li>
                        <li>Vous n'avez pas à modifier la partie Serveur ni l'API Rest</li>
                    </ul>
                </section>

                <section>
                    <header>
                        <h1>Critères d'évaluations</h1>
                    </header>
                    Une attention particulière sera apportée sur les points suivants :
                    <ul>
                        <li>Fonctionnalités implémentées</li>
                        <li>Qualité du code</li>
                        <li>Maintenabilité</li>
                        <li>Evolutivité</li>
                        <li>Applications des bonnes pratiques de développements Front End</li>
                        <li>Design de l'application</li>
                    </ul>
                </section>
            </section>
        );
    }
});

ReactDOM.render(<Main />, document.getElementById('main'));