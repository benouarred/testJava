describe('About strings : ', function(){

    it('delimiters', function(){
        var singleQuotedString = 'apple';
        var doubleQuotedString = "apple";
        expect(singleQuotedString === doubleQuotedString).toBe( _ );
        expect(typeof(singleQuotedString)).toBe( _ );
        expect(typeof(doubleQuotedString)).toBe( _ );

    });

    it('concatenation', function(){
        var fruit = "apple";
        var dish = "pie";
        expect(fruit + " " + dish).toBe( _ );
    });

    it('character Type', function(){
        var characterType = typeof("Amory".charAt(1));
        expect(characterType).toBe( _ );
    });

    it('string length', function(){
        var result = "hello";
        expect(result.length).toBe( _ );
    });

    it('slice', function(){
        var fruit = "pineapples";
        expect(fruit.slice( _, _)).toBe("apple");
    })

});