var Mocha = require('mocha');
var mocha = new Mocha();
var chai = require('chai');
var expect = chai.expect;
mocha.suite.emit('pre-require', this, 'solution', mocha);

describe('Reflection : ', function(){

    it("Reflection - 1", function() {
        var keys = [];
        var values = [];
        var person = {name: 'Thierry LAU', age: 30, unemployed: true};
        for(propertyName in person) {
            keys.push( _ );
            values.push( _);
        }
        expect(keys).to.deep.equal(['name','age','unemployed']);
        expect(values).to.deep.equal(['Thierry LAU', 30 , true]);
    });


    function A() {
        this.aprop = "A";
    }

    function B() {
        this.bprop = "B";
    }

    B.prototype = new A();

    it("Reflection - 2", function() {
        var b = new B();

        var keys = [];
        for (propertyName in b) {
            keys.push(propertyName);
        }
        expect(keys.length).to.equal( _ );
        expect(keys).to.deep.equal( _ );

        var ownKeys = [];
        for(propertyName in b) {
            if (b.hasOwnProperty(propertyName)) {
                ownKeys.push(propertyName);
            }
        }
        expect(ownKeys.length).to.equal( _ );
        expect(ownKeys).to.deep.equal( _ );
    });

    it("Reflection - 3", function () {
        var a = new A();
        var b = new B();
        expect(typeof(a.constructor)).to.equal( _ );
        expect(a.constructor.name).to.equal( _ );
        expect(b.constructor.name).to.equal( _ );
    });

});

mocha.run();
