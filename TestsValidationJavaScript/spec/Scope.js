describe('About scopes : ', function(){

    variable = 42;

    it("global variables", function() {
        expect(variable).toBe( _ );
    });


    it("variables declared inside of a function", function() {
        var outerVariable = "outer";

        (function() {
            var innerVariable = "inner";
            expect(outerVariable).toBe( _ );
            expect(innerVariable).toBe( _ );
        })();

        expect(outerVariable).toBe( _ );
        expect(typeof(innerVariable)).toBe( _ );
    });



});