describe('Strings', function(){

    it('Strings - 1', function(){
        var singleQuotedString = 'apple';
        var doubleQuotedString = "apple";
        expect(singleQuotedString === doubleQuotedString).toBe(true);
        expect(typeof(singleQuotedString)).toBe('string');
        expect(typeof(doubleQuotedString)).toBe('string');

    });

    it('Strings - 2', function(){
        var fruit = "apple";
        var dish = "pie";
        expect(fruit + ' ' + dish + '.').toBe( "apple pie." );
    });

    it('Strings - 3', function(){
        var characterType = typeof("Amory".charAt(1));
        expect(characterType).toBe('string');
    });

    it('Strings - 4', function(){
        var result = "hello";
        expect(result.length).toBe(5);
    });

    it('Strings - 5', function(){
        var fruit = "pineapples";
        expect(fruit.slice(4,9)).toBe("apple");
    })

});