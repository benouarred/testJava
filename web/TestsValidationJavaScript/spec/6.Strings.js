var Mocha = require('mocha');
var mocha = new Mocha();
var chai = require('chai');
var expect = chai.expect;
mocha.suite.emit('pre-require', this, 'solution', mocha);

describe('Strings', function() {

    it('Strings - 1', function() {
        var singleQuotedString = 'apple';
        var doubleQuotedString = "apple";
        expect(singleQuotedString === doubleQuotedString).to.equal( _ );
        expect(typeof(singleQuotedString)).to.equal( _ );
        expect(typeof(doubleQuotedString)).to.equal( _ );
    });

    it('Strings - 2', function() {
        var fruit = "apple";
        var dish = "pie";
        expect( _ ).to.equal( "apple pie." ); // Use concatenation
        expect( _ ).to.equal( "apple pie." ); // Use template strings
    });

    it('Strings - 3', function() {
        var characterType = typeof("Amory".charAt(1));
        expect(characterType).to.equal( _ );
    });

    it('Strings - 4', function() {
        var result = "hello";
        expect(result.length).to.equal( _ );
    });

    it('Strings - 5', function() {
        var fruit = "pineapples";
        expect(fruit.slice( _, _)).to.equal("apple");
    })

});

mocha.run();
