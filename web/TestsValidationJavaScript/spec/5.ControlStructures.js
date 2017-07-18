var Mocha = require('mocha');
var mocha = new Mocha();
var chai = require('chai');
var expect = chai.expect;
mocha.suite.emit('pre-require', this, 'solution', mocha);

describe('Control structures', function(){

    it('Control structures - 1', function(){
        var result = false;
        if (2 > 0) {
            result = true;
        }
        expect(result).to.equal( _ );
    });

    it('Control structures - 2', function(){
        var fruit = true ? "orange" : "banana";
        expect(fruit).to.equal( _ );
    });

    it('Control structures - 3', function(){
        var result = 0;
        switch (2) {
            case 1:
                result = 1;
                break;
            case 1+1:
                result = 2;
                break;
        }
        expect(result).to.equal( _ );
    });

    it('Control structures - 4', function(){
        var result = "Pippin";
        switch ("m") {
            case "f":
                result = "Frodo";
                break;
            case "s":
                result = "Samwise";
                break;
            default:
                result = "Merry";
                break;
        }
        expect(result).to.equal( _ );
    });

    it('Control structures - 5', function(){
        var result = "Pippin";
        switch ("s") {
            case "f":
                result = "Frodo";
                break;
            case "s":
                result = "Samwise";
            default:
                result = "Merry";
                break;
        }
        expect(result).to.equal( _ );
    });


    it('Control structures - 6', function(){
        var fruit = null || "banana";
        expect(fruit).to.equal( _ );

        var myFavouriteFruit = fruit || "apple";
        expect(myFavouriteFruit).to.equal( _ );
    })

});

mocha.run();
