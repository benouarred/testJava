describe('About numbers : ', function(){

    it('types', function(){
        var typeOfIntegers = typeof(6);
        var typeOfFloats = typeof(3.14159);
        expect(typeOfIntegers === typeOfFloats).toBe( _ );
        expect(typeOfIntegers).toBe( _ );
        expect(1.0 === 1).toBe( _ );
    });

    it('NaN', function(){
        var result = 7/'beers';
        expect(isNaN(result)).toBe( _ );
        expect(result == NaN).toBe( _);
    });

    it ('Number', function() {
        var result = 7/'7';
        expect(isNaN(result)).toBe( _ );
        expect(result).toBe( _ );
    });

});