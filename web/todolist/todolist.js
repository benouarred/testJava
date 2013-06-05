
/**
 * Module dependencies.
 */

var express = require('express')
  , routes = require('./routes')
  , todo = require('./routes/todo')
  , http = require('http')
  , path = require('path');

var app = express();

app.configure(function(){
  app.set('port', process.env.PORT || 3000);
  app.set('views', __dirname + '/public');
  app.engine('.html', require('ejs').renderFile);
  app.set('view engine', 'html');
  app.use(express.favicon());
  app.use(express.logger('dev'));
  app.use(express.bodyParser());
  app.use(express.methodOverride());
  app.use(app.router);
  app.use(express.static(path.join(__dirname, 'public')));
});

app.configure('development', function(){
  app.use(express.errorHandler());
});

app.get('/views/:name', routes.views);

app.get('/todos', todo.findAll);
app.get('/todos/:id', todo.findById);
app.post('/todos', todo.addTodo);
app.put('/todos/:id', todo.updateTodo);
app.delete('/todos/:id', todo.deleteTodo);


http.createServer(app).listen(app.get('port'), function(){
  console.log("Express server listening on port " + app.get('port'));
});
