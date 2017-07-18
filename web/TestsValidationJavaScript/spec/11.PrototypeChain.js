var Mocha = require('mocha');
var mocha = new Mocha();
var chai = require('chai');
var expect = chai.expect;
mocha.suite.emit('pre-require', this, 'solution', mocha);

describe('Prototype chain', function(){

    var father = {
        b: 3,
        c: 4
    };

    var child = Object.create(father);
    child.a = 1;
    child.b = 2;

    it("Prototype chain - 1", function(){
        expect(child.hasOwnProperty('a')).to.equal( _ );
        expect(child.hasOwnProperty('b')).to.equal( _ );
    });

    it("Prototype chain - 2", function () {
        expect(child.a).to.equal( _ );
        expect(child.b).to.equal( _ );
    });

    it("Prototype chain - 3", function () {
        delete child.b;
        expect(child.b).to.equal( _ );
    });

    it("Prototype chain - 4", function () {
        expect(child.hasOwnProperty('c')).to.equal( _ );
    });

    it("Prototype chain - 5", function () {
        expect(child.c).to.equal( _ );
    });

    it("Prototype chain - 6", function () {
        expect(child.d).to.equal( _ );
    });


});

mocha.run();
