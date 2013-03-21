var todos = [
    {
        user_id : 1,
        description : "Faire les courses",
        memo : 'Pomme, poire, lessive',
        priority : 1,
        updated_at : Date.now()
    },
    {
        user_id : 2,
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
        if(todos[i].user_id == id){
            res.json(200, todos[i]);
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
    todo.user_id = id++;
    todos.push(todo);
    res.json(201);
};

/*
 * Update a todo by is identifier.
 */
exports.updateTodo = function(req, res){
    var todo = req.body;
    var id = todo.user_id;

    for(var i = 0; i < todos.length; i++){
        if(todos[i].user_id === id){
            todos.splice(i, 1);
            todos.push(todo);
            res.json(200);
        }
    }

    res.json(304, "Not modified");
};

/*
 * GET users listing.
 */
exports.deleteTodo = function(req, res){

    var id = req.params.id;

    for(var i = 0; i < todos.length; i++){
        if(todos[i].user_id == id){
            todos.splice(i, 1);
            res.json(200);
        }
    }

    res.json(304, "Not modified");
};