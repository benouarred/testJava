var Mocha = require('mocha');
var mocha = new Mocha();
var chai = require('chai');
var expect = chai.expect;
mocha.suite.emit('pre-require', this, 'solution', mocha);

describe('Objects', function(){

    it('Objects - 1', function(){
        var result = {};
        expect(typeof(result)).to.equal( _ );
    });

    it('Objects - 2', function(){
        var person = {
            // _
        };
        expect(person.name).to.equal('Jean Paul');
        expect(person.age).to.equal(51);
    });

    it('Objects - 3', function(){
        var person = {};
        // _
        // _
        expect(person.name).to.equal('Jean Paul');
        expect(person.age).to.equal(51);
    });

    it('Objects - 4', function(){
        var person = {};
        // _
        // _
        expect(person.name).to.equal('Jean Paul');
        expect(person['phone-number']).to.equal('0145254515');
    });

    it('Objects - 5', function(){
        var person = {
            name: "Jean Paul",
            age: 25,
            toString: function() {
                return _ ;
            }
        };
        expect(person.toString()).to.equal('My name is Jean Paul and I am 25 years old');
    });


});

mocha.run();
