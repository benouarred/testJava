var Mocha = require('mocha');
var mocha = new Mocha();
var chai = require('chai');
var expect = chai.expect;
mocha.suite.emit('pre-require', this, 'solution', mocha);

describe('Scopes', function(){

    variable = 42;

    it("Scopes - 1", function() {
        expect(variable).to.equal( _ );
    });


    it("Scopes - 2", function() {
        var fruit = "banana";

        (function() {
            var anotherFruit = "orange";
            expect(fruit).to.equal( _ );
            expect(anotherFruit).to.equal( _ );
        })();

        expect(fruit).to.equal( _ );
        expect(typeof(anotherFruit)).to.equal( _ );
    });

});

mocha.run();
