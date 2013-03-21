describe('About scopes : ', function(){

    variable = 42;

    it("global variables", function() {
        expect(variable).toBe( _ );
    });


    it("variables declared inside of a function", function() {
        var fruit = "banana";

        (function() {
            var anotherFruit = "orange";
            expect(fruit).toBe( _ );
            expect(anotherFruit).toBe( _ );
        })();

        expect(fruit).toBe( _ );
        expect(typeof(anotherFruit)).toBe( _ );
    });



});