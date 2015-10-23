describe('Numbers', function(){

    it('Numbers - 1', function(){
        var typeOfIntegers = typeof(6);
        var typeOfFloats = typeof(3.14159);
        expect(typeOfIntegers === typeOfFloats).toBe(true);
        expect(typeOfIntegers).toBe('number');
        expect(1.0 === 1).toBe(true);
    });

    it('Numbers - 2', function(){
        var result = 7/'beers';
        expect(isNaN(result)).toBe(true);
        expect(result == NaN).toBe(false);
    });

    it ('Numbers - 3', function() {
        var result = 7/'7';
        expect(isNaN(result)).toBe(false);
        expect(result).toBe(1);
    });

});