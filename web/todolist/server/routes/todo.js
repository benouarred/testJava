var todos = [
    {
        id : 1,
        description : "Faire les courses",
        memo : 'Pomme, poire, lessive',
        priority : 1,
        updated_at : Date.now()
    },
    {
        id : 2,
        description : "Envoyer le courrier",
        memo : 'Urgent',
        priority : 2,
        updated_at : Date.now()
    }
];

var id = 3;


/*
 * GET todos listing.
 */
exports.findAll = function(req, res){
    res.json(200, todos);
};

/*
 * GET todo by identifier.
 */
exports.findById = function(req, res){
    var id = req.params.id;

    for(var i = 0; i < todos.length; i++){
        if(todos[i].id == id){
            res.json(200, todos[i]);
            return;
        }
    }

    res.json(404, "Not found");
};

/*
 * Create a todo.
 */
exports.addTodo = function(req, res){
    var todo = req.body;
    todo.updated_at = Date.now();
    todo.id = id++;
    todos.push(todo);
    res.status(201).end();
};

/*
 * Update a todo by is identifier.
 */
exports.updateTodo = function(req, res){
    var todo = req.body;
    var id = todo.id;
    
    if (String(id) !== req.params.id) {
        res.json(400, "Bad request");
        return;
    }

    for(var i = 0; i < todos.length; i++){
        if(todos[i].id === id){
            todo.updated_at = Date.now();
            todos.splice(i, 1, todo);
            res.status(204).end();
            return;
        }
    }

    res.json(404, "Not found");
};

/*
 * GET users listing.
 */
exports.deleteTodo = function(req, res){

    var id = req.params.id;

    for(var i = 0; i < todos.length; i++){
        if(String(todos[i].id) === id){
            todos.splice(i, 1);
            res.status(204).end();
            return;
        }
    }

    res.json(404, "Not found");
};