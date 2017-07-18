var Mocha = require('mocha');
var mocha = new Mocha();
var chai = require('chai');
var expect = chai.expect;
mocha.suite.emit('pre-require', this, 'solution', mocha);

describe('Prototype inheritance', function(){

    var Mammal = function(name) {
        this.name = name;
    };

    Mammal.prototype = {
        sayHi: function() {
            return "Hello, my name is " + this.name;
        }
    };

    it("Prototype inheritance - 1", function() {
        var eric  = new Mammal("Eric");
        expect(eric.sayHi()).to.equal( _ );
    });

    Mammal.prototype.favouriteSaying = function() {
        return this.name + "'s favourite saying is " + this.sayHi();
    };

    it("Prototype inheritance - 2", function() {
        var bobby = new Mammal("Bobby");
        expect(bobby.favouriteSaying()).to.equal( _ );
    });

    it("Prototype inheritance - 3", function() {
        var paul = new Mammal("Paul");
        Mammal.prototype.numberOfLettersInName = function() {
            return this.name.length;
        };
        expect(paul.numberOfLettersInName()).to.equal( _ );
    });

    function extend(child, supertype){
        child.prototype = supertype.prototype;
    }

    function Bat(name, wingspan) {
        Mammal.call(this, name);
        this.wingspan = wingspan;
    }

    extend(Bat, Mammal);

    it("Prototype inheritance - 4", function() {
        var lenny = new Bat("Lenny", "1.5m");
        expect(lenny.sayHi()).to.equal( _ );
        expect(lenny.wingspan).to.equal( _ );
    });

});

mocha.run();
