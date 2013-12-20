describe('About prototype inheritance : ', function(){

    var Mammal = function(name) {
        this.name = name;
    };

    Mammal.prototype = {
        sayHi: function() {
            return "Hello, my name is " + this.name;
        }
    };

    it("defining a 'class'", function() {
        var eric  = new Mammal("Eric");
        expect(eric.sayHi()).toBe( _ );
    });

    Mammal.prototype.favouriteSaying = function() {
        return this.name + "'s favourite saying is " + this.sayHi();
    };

    it("more functions", function() {
        var bobby = new Mammal("Bobby");
        expect(bobby.favouriteSaying()).toBe( _ );
    });

    it("calling functions added to a prototype after an object was created", function() {
        var paul = new Mammal("Paul");
        Mammal.prototype.numberOfLettersInName = function() {
            return this.name.length;
        };
        expect(paul.numberOfLettersInName()).toBe( _ );
    });

    function extend(child, supertype){
        child.prototype = supertype.prototype;
    }

    function Bat(name, wingspan) {
        Mammal.call(this, name);
        this.wingspan = wingspan;
    }

    extend(Bat, Mammal);

    it("inheritance", function() {
        var lenny = new Bat("Lenny", "1.5m");
        expect(lenny.sayHi()).toBe( _ );
        expect(lenny.wingspan).toBe( _ );
    });

});