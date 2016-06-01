describe('Strings', function() {

    it('Strings - 1', function() {
        var singleQuotedString = 'apple';
        var doubleQuotedString = "apple";
        expect(singleQuotedString === doubleQuotedString).toBe( _ );
        expect(typeof(singleQuotedString)).toBe( _ );
        expect(typeof(doubleQuotedString)).toBe( _ );
    });

    it('Strings - 2', function() {
        var fruit = "apple";
        var dish = "pie";
        expect( _ ).toBe( "apple pie." ); // Use concatenation
        expect( _ ).toBe( "apple pie." ); // Use template strings
    });

    it('Strings - 3', function() {
        var characterType = typeof("Amory".charAt(1));
        expect(characterType).toBe( _ );
    });

    it('Strings - 4', function() {
        var result = "hello";
        expect(result.length).toBe( _ );
    });

    it('Strings - 5', function() {
        var fruit = "pineapples";
        expect(fruit.slice( _, _)).toBe("apple");
    })

});
