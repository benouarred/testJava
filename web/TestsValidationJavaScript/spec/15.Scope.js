describe('Scopes', function(){

    variable = 42;

    it("Scopes - 1", function() {
        expect(variable).toBe( _ );
    });


    it("Scopes - 2", function() {
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