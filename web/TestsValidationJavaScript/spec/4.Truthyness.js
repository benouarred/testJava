var Mocha = require('mocha');
var mocha = new Mocha();
var chai = require('chai');
var expect = chai.expect;
mocha.suite.emit('pre-require', this, 'solution', mocha);

describe('Truthyness', function(){

    it('Truthyness - 1', function(){
        var result;
        if(3){
            result = true;
        } else {
            result = false;
        }
        expect(result).to.equal( _ );
    });

    it('Truthyness - 2', function(){
        var result;
        if(-1){
            result = true;
        } else {
            result = false;
        }
        expect(result).to.equal( _ );
    });

    it('Truthyness - 3', function(){
        var result;
        if(0){
            result = true;
        } else {
            result = false;
        }
        expect(result).to.equal( _ );
    });

    it('Truthyness - 4', function(){
        var result;
        if(null){
           result = true;
        } else {
            result = false;
        }
        expect(result).to.equal( _ );
    });

	it('Truthyness - 5', function(){
        var result;
        if(undefined){
           result = true;
        } else {
            result = false;
        }
        expect(result).to.equal( _ );
    });

});

mocha.run();
