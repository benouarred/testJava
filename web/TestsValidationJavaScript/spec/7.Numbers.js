describe('Numbers', function() {

    it('Numbers - 1', function() {
        var typeOfIntegers = typeof(6);
        var typeOfFloats = typeof(3.14159);
        expect(typeOfIntegers === typeOfFloats).toBe( _ );
        expect(typeOfIntegers).toBe( _ );
        expect(1.0 === _).toBe(true);
    });

    it('Numbers - 2', function() {
        var result = 7/'beers';
        expect(isNaN(result)).toBe( _ );
        expect(result == NaN).toBe( _);
    });

    it('Numbers - 3', function() {
        var result = 7/'7';
        expect(isNaN(result)).toBe( _ );
        expect(result).toBe( _ );
    });

    it('Numbers - 4', function() {
        // indice: partir de 42, base 16
        expect( _ ).toBe('2a');
    });
});
