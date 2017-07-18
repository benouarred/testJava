var Mocha = require('mocha');
var mocha = new Mocha();
var chai = require('chai');
var expect = chai.expect;
mocha.suite.emit('pre-require', this, 'solution', mocha);

describe('Variables', function() {

    nom = "Pierre";

    it('Variables - 1', function() {
        // _
        expect(nom).to.equal('Thierry');
        expect(window.nom).to.equal('Thierry');
    });

    age = 6;

    it('Variables - 2', function() {
        // _
        expect(age).to.equal(4);
        expect(window.age).to.equal(6);
    });

    it('Variables - 3', function() {
        expect(company).to.equal( _ );
        var company = 'sfeir';
    });

    it('Variables - 4', function() {
        var i, j;

        for(var i = 0; i < 1; i++) {}
        expect(i).to.equal( _ );

        for(let j = 0; j < 1; j++) {}
        expect(j).to.equal( _ );
    });
});

mocha.run();
