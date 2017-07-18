var Mocha = require('mocha');
var mocha = new Mocha();
var chai = require('chai');
var expect = chai.expect;
mocha.suite.emit('pre-require', this, 'solution', mocha);

describe('This', function(){

    it("This - 1", function () {
        var person = {
            name: 'bob',
            intro: function () {
                return "Hello, my name is " + _;
            }
        };
        expect(person.intro()).to.equal("Hello, my name is bob");
    });


    it("This - 2", function () {
        var person = {
            name: 'bob',
            intro: function () {
                return "Hello, my name is " + this.name;
            }
        };

        var alias = person.intro;

        window.name = 'Peter';

        expect( _ ).to.equal("Hello, my name is Peter");
    });


    it("This - 3", function () {
        var person = {
            name: 'bob',
            intro: function () {
                return "Hello, my name is " + this.name;
            }
        };

        var message = person.intro.call( _ );
        expect(message).to.equal("Hello, my name is Frank");
    });



});

mocha.run();
