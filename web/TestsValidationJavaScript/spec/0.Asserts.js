var Mocha = require('mocha');
var mocha = new Mocha();
var chai = require('chai');
var expect = chai.expect;
mocha.suite.emit('pre-require', this, 'solution', mocha);

describe('About Chai assertions : ', function(){

    it('you should know what will satisfy the to.be.true assertion', function(){
       expect( _ ).to.be.true;
    });

    it('you should know what will satisfy the to.be.false assertion', function(){
        expect( _ ).to.be.false;
    });

    it('you should know what will satisfy the to.equal assertion', function(){
        expect( _ ).to.equal('3');
    });

    it('you should know what will satisfy the not assertion', function(){
        expect( _ ).not.equal('3');
    });

})

mocha.run();
