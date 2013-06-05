describe('About operators : ', function(){

    it('addition', function(){
        var result = 0;
        for (var i = 0; i <= 5; i++) {
            result = result + i;
        }
        expect(result).toBe( _ );
    });

    it('assignment addition', function(){
        var result = 0;
        for (var i = 0; i <=5; i++) {
            result += i;
        }
        expect(result).toBe( _ );
    });

    it('subtraction', function(){
        var result = 5;
        for (var i = 0; i <= 2; i++) {
            result = result - i;
        }
        expect(result).toBe( _ );
    });

    it('assignment subtraction', function(){
        var result = 5;
        for (var i = 0; i <= 2; i++) {
            result -= i;
        }
        expect(result).toBe( _ );
    });

    it('modulus', function(){
        var result = 11;
        var x = 5;
        result %= x;
        expect(result).toBe( _ );
    });

});