var Mocha = require('mocha');
var mocha = new Mocha();
var chai = require('chai');
var expect = chai.expect;
mocha.suite.emit('pre-require', this, 'solution', mocha);

describe('Numbers', function() {

    it('Numbers - 1', function() {
        var typeOfIntegers = typeof(6);
        var typeOfFloats = typeof(3.14159);
        expect(typeOfIntegers === typeOfFloats).to.equal( _ );
        expect(typeOfIntegers).to.equal( _ );
        expect(1.0 === _).to.be.true;
    });

    it('Numbers - 2', function() {
        var result = 7/'beers';
        expect(isNaN(result)).to.equal( _ );
        expect(result == NaN).to.equal( _);
    });

    it('Numbers - 3', function() {
        var result = 7/'7';
        expect(isNaN(result)).to.equal( _ );
        expect(result).to.equal( _ );
    });

    it('Numbers - 4', function() {
        // indice: partir de 42, base 16
        expect( _ ).to.equal('2a');
    });
});

mocha.run();
