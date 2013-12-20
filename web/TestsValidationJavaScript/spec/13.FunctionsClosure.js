describe('About Functions and Closure : ', function(){

    it("defining functions directly", function() {
        var result = "a";
        function changeResult() {
            result = "b";
        }
        changeResult();
        expect(result).toBe( _ );
    });

    it("assigning functions to variables", function() {
        var action = _;
        expect(action(4)).toBe(12);
    });


    it("self invoking functions", function() {
        var value = "orange";

        (function( _ ) {
            var anotherValue = "blue";
            expect(val).toBe( "orange" );
            expect(typeof(value)).toBe( _ );
            expect(typeof(anotherValue)).toBe( _ );
        })( _ );

        expect(typeof(anotherValue)).toBe( _ );
        expect(typeof(value)).toBe( _ );
    });


    it("arguments array", function() {
        var add = function() {
            var total = 0;
            for(var i = 0; i < arguments.length; i++) {
                // complete the implementation of this method so that it returns the sum of its arguments
               // _
            }
            // _
        };

        expect(add(1,2,3,4,5)).toBe(15);
        expect(add(4,7,-2)).toBe(9);
    });


    it("using call to invoke function",function(){
        var invokee = function( message ){
            return this + message;
        };

        var result = invokee.call("I am this!", "Where did it come from?");

        expect(result).toBe( _ );
    });


    it("using apply to invoke function",function(){
        var invokee = function( message1, message2 ){
            return this + message1 + message2;
        };

        var result = invokee.apply("I am this!", ["I am arg1","I am arg2"]);

        expect(result).toBe( _ );
    });

});