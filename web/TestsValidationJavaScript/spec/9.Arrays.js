var Mocha = require('mocha');
var mocha = new Mocha();
var chai = require('chai');
var expect = chai.expect;
mocha.suite.emit('pre-require', this, 'solution', mocha);

describe('Arrays', function() {

    it('Arrays - 1', function() {
        var collection = _ ;
        expect(collection[0]).to.equal("meaning of life");
        expect(collection[1]).to.equal(42);
        expect(collection[2]).to.equal(true);

    });

    it('Arrays - 2', function() {
        expect(typeof([])).to.equal( _ );
    });

    it('Arrays - 3', function() {
        var collection = ['a','b','c'];
        expect(collection._).to.equal(3);
    });

    it('Arrays - 4', function() {
        var daysOfWeek = ['Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday', 'Sunday'];
        var workingWeek = daysOfWeek.splice(_, _ );
        expect(daysOfWeek).to.deep.equal( _ );
        expect(workingWeek).to.deep.equal( _ );
    });

    it('Arrays - 5', function() {
        var collection = [1,2,3,4,5,6,7,8,9];
        var odd = collection.filter( _ );
        expect(odd).to.deep.equal([1,3,5,7,9]);
    });

    it('Arrays - 6', function() {
        var collection = [1,2,3,4];
        var result = collection.reduce( _ );
        expect(result).to.equal(24);
    });

    it('Arrays - 7', function() {
        var collection = [1, 2, 3];
        expect( _ ).to.deep.equal([2, 4, 6]);
    });

    it('Arrays - 8', function() {
        var array1 = [1, 2, 3];
        var array2 = [4, 5, 6];
        expect( _ ).to.deep.equal([1, 2, 3, 4, 5, 6]);
    });

    it('stack methods', function() {
        var stack = [];
        stack.push("first");
        stack.push("second");
        expect(stack.pop()).to.equal( _ );
        expect(stack.pop()).to.equal( _ );
    });

});

mocha.run();
