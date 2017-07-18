var Mocha = require('mocha');
var mocha = new Mocha();
var chai = require('chai');
var expect = chai.expect;
mocha.suite.emit('pre-require', this, 'solution', mocha);

describe('Operators', function() {

    it('Operators - 1', function() {
        var result = 0;
        for (var i = 0; i <= 3; i++) {
            result = result + i;
        }
        expect(result).to.equal( _ );
    });

    it('Operators - 2', function() {
        var result = 0;
        for (var i = 0; i <= 3; i++) {
            result += i;
        }
        expect(result).to.equal( _ );
    });

    it('Operators - 3', function() {
        var result = 3;
        for (var i = 0; i <= 2; i++) {
            result = result - i;
        }
        expect(result).to.equal( _ );
    });

    it('Operators - 4', function() {
        var result = 3;
        for (var i = 0; i <= 2; i++) {
            result -= i;
        }
        expect(result).to.equal( _ );
    });

    it('Operators - 5', function() {
        var result = 11;
        var x = 5;
        result %= x;
        expect(result).to.equal( _ );
    });

    it('Operators - 6', function() {
        var result = 2 * 5 + 90 / 2 - 13;
        expect(result).to.equal( _ );
    });

    it('Operators - 7', function() {
        var result = true && true || false && false;
        expect(result).to.equal( _ );
    });

    it('Operators - 8', function() {
        var result = false && true || true && true;
        expect(result).to.equal( _ );
    });
});

mocha.run();
