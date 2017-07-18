var Mocha = require('mocha');
var mocha = new Mocha();
var chai = require('chai');
var expect = chai.expect;
mocha.suite.emit('pre-require', this, 'solution', mocha);

describe('Functions and Closure', function(){

    it("Functions and Closure - 1", function() {
        var result = "a";
        function changeResult() {
            result = "b";
        }
        changeResult();
        expect(result).to.equal( _ );
    });

    it("Functions and Closure - 2", function() {
        var action = _;
        expect(action(4)).to.equal(12);
    });


    it("Functions and Closure - 3", function() {
        var value = "orange";

        (function( _ ) {
            var anotherValue = "blue";
            expect(val).to.equal( "orange" );
            expect(typeof(value)).to.equal( _ );
            expect(typeof(anotherValue)).to.equal( _ );
        })( _ );

        expect(typeof(anotherValue)).to.equal( _ );
        expect(typeof(value)).to.equal( _ );
    });


    it("Functions and Closure - 4", function() {
        var add = function() {
            var total = 0;
            for(var i = 0; i < arguments.length; i++) {
                // complete the implementation of this method so that it returns the sum of its arguments
               // _
            }
            // _
        };

        expect(add(1,2,3,4,5)).to.equal(15);
        expect(add(4,7,-2)).to.equal(9);
    });


    it("using call to invoke function",function(){
        var invokee = function( message ){
            return this + message;
        };

        var result = invokee.call("I am this!", "Where did it come from?");

        expect(result).to.equal( _ );
    });


    it("using apply to invoke function",function(){
        var invokee = function( message1, message2 ){
            return this + message1 + message2;
        };

        var result = invokee.apply("I am this!", ["I am arg1","I am arg2"]);

        expect(result).to.equal( _ );
    });

});

mocha.run();
